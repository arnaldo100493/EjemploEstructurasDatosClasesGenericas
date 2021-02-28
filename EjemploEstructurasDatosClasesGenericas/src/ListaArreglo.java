
import java.util.Arrays;
import java.util.ConcurrentModificationException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abarrios
 */
public class ListaArreglo<E> extends ListaAbstracta<E> implements Lista<E> {

    private transient Object[] listadoElementos;
    private static final int CAPACIDAD_PREDETERMINADA = 10;
    private static final int TAMANIO_MAXIMO_ARREGLO = Integer.MAX_VALUE - 8;
    private static final Object[] LISTADO_ELEMENTOS_VACIO = {};
    private static final Object[] CAPACIDAD_PREDETERMINADA_LISTADO_ELEMENTOS_VACIO = {};
    private int tamanio;
    private int contadorElementos;

    public ListaArreglo() {
        this.listadoElementos = CAPACIDAD_PREDETERMINADA_LISTADO_ELEMENTOS_VACIO;
    }

    public ListaArreglo(int capacidadInicial) {
        if (capacidadInicial > 0) {
            this.listadoElementos = new Object[capacidadInicial];
        } else if (capacidadInicial == 0) {
            this.listadoElementos = CAPACIDAD_PREDETERMINADA_LISTADO_ELEMENTOS_VACIO;
        } else {
            throw new IllegalArgumentException("Capacidad Ilegal: " + capacidadInicial);
        }
    }

    public void recortarAlTamanio() {
        this.moduloContador++;
        if (this.tamanio < this.listadoElementos.length) {
            this.listadoElementos = (this.tamanio == 0)
                    ? LISTADO_ELEMENTOS_VACIO
                    : Arrays.copyOf(this.listadoElementos, this.tamanio);
        }
    }

    public void asegurarCapacidad(int capacidadMinima) {
        int minExpand = (this.listadoElementos != CAPACIDAD_PREDETERMINADA_LISTADO_ELEMENTOS_VACIO)
                // any size if not default element table
                ? 0
                // larger than default for default empty table. It's already
                // supposed to be at default size.
                : CAPACIDAD_PREDETERMINADA;

        if (capacidadMinima > minExpand) {
            this.asegurarCapacidadExplicita(capacidadMinima);
        }
    }

    @Override
    public boolean contiene(Object objeto) {
        return this.indiceDe(objeto) >= 0;
    }

    public int indiceDe(Object objeto) {
        if (objeto == null) {
            for (int i = 0; i < this.tamanio; i++) {
                if (this.listadoElementos[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < this.tamanio; i++) {
                if (objeto.equals(this.listadoElementos[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int ultimoIndiceDe(Object objeto) {
        if (objeto == null) {
            for (int i = this.tamanio - 1; i >= 0; i--) {
                if (this.listadoElementos[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = this.tamanio - 1; i >= 0; i--) {
                if (objeto.equals(this.listadoElementos[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int tamanio() {
        return this.tamanio;
    }

    @Override
    public boolean estaVacia() {
        return this.tamanio == 0;
    }

    public void limpiar() {
        this.moduloContador++;

        for (int i = 0; i < this.tamanio; i++) {
            this.listadoElementos[i] = null;
        }

        this.tamanio = 0;
    }

    @Override
    public boolean agregar(E elemento) {
        this.asegurarCapacidadInterna(this.tamanio + 1);
        this.listadoElementos[tamanio++] = elemento;
        return true;
    }

    @Override
    public void agregar(int indice, E elemento) {
        this.verificarRangoParaAgregar(indice);
        this.asegurarCapacidadInterna(this.tamanio + 1);
        System.arraycopy(this.listadoElementos, indice, this.listadoElementos, indice + 1,
                this.tamanio - indice);
        this.listadoElementos[indice] = elemento;
        this.tamanio++;
    }

    public void agregarElemento(E objeto) {
        this.moduloContador++;
        this.asegurarCapacidadAyudante(this.contadorElementos + 1);
        this.listadoElementos[this.contadorElementos++] = objeto;
    }

    public E listadoElementos(int indice) {
        return (E) this.listadoElementos[indice];
    }

    @Override
    public E obtener(int indice) {
        return this.listadoElementos(indice);
    }

    public E modificar(int indice, E elemento) {
        this.verificarRango(indice);
        E antiguoValor = this.listadoElementos(indice);
        this.listadoElementos[indice] = elemento;
        return antiguoValor;
    }

    @Override
    public boolean remover(Object objeto) {
        if (objeto == null) {
            for (int indice = 0; indice < this.tamanio; indice++) {
                if (this.listadoElementos[indice] == null) {
                    this.removerRapido(indice);
                    return true;
                }
            }
        } else {
            for (int indice = 0; indice < this.tamanio; indice++) {
                if (objeto.equals(listadoElementos[indice])) {
                    removerRapido(indice);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remover(int indice) {
        this.verificarRango(indice);
        this.moduloContador++;
        E elemento = this.listadoElementos(indice);
        int numeroMovido = this.tamanio - indice - 1;
        if (numeroMovido > 0) {
            System.arraycopy(this.listadoElementos, indice + 1, this.listadoElementos, indice,
                    numeroMovido);
            this.listadoElementos[--this.tamanio] = null;
        }
        return elemento;
    }

    private void removerRapido(int indice) {
        moduloContador++;
        int numeroMovido = this.tamanio - indice - 1;
        if (numeroMovido > 0) {
            System.arraycopy(this.listadoElementos, indice + 1, this.listadoElementos, indice,
                    numeroMovido);
            this.listadoElementos[--this.tamanio] = null;
        }
    }

    private void removerRango(int desdeIndice, int hastaIndice) {
        this.moduloContador++;
        int numeroMovido = this.tamanio - hastaIndice;
        System.arraycopy(this.listadoElementos, hastaIndice, this.listadoElementos, desdeIndice,
                numeroMovido);
        int nuevoTamanio = this.tamanio - (hastaIndice - desdeIndice);
        for (int i = nuevoTamanio; i < this.tamanio; i++) {
            this.listadoElementos[i] = null;
        }
        this.tamanio = nuevoTamanio;
    }

    private void verificarRangoParaAgregar(int indice) {
        if (indice > this.tamanio || indice < 0) {
            throw new IndexOutOfBoundsException(this.mostrarMensajeFueraDeRango(indice));
        }
    }

    private void crecer(int capacidadMinima) {
        int antiguaCapacidad = this.listadoElementos.length;
        int nuevaCapacidad = antiguaCapacidad + (antiguaCapacidad >> 1);
        if (nuevaCapacidad - capacidadMinima < 0) {
            nuevaCapacidad = capacidadMinima;
        }
        if (nuevaCapacidad - TAMANIO_MAXIMO_ARREGLO > 0) {
            nuevaCapacidad = capacidadEnorme(capacidadMinima);
        }
        // minCapacity is usually close to size, so this is a win:
        this.listadoElementos = Arrays.copyOf(this.listadoElementos, nuevaCapacidad);
    }

    private static int capacidadEnorme(int minCapacity) {
        if (minCapacity < 0) // overflow
        {
            throw new OutOfMemoryError();
        }
        return (minCapacity > TAMANIO_MAXIMO_ARREGLO)
                ? Integer.MAX_VALUE
                : TAMANIO_MAXIMO_ARREGLO;
    }

    private static int calcularCapacidad(Object[] listadoElementos, int capacidadMinima) {
        if (listadoElementos == CAPACIDAD_PREDETERMINADA_LISTADO_ELEMENTOS_VACIO) {
            return Math.max(CAPACIDAD_PREDETERMINADA, capacidadMinima);
        }
        return capacidadMinima;
    }

    private void asegurarCapacidadAyudante(int capacidadMinima) {
        if (capacidadMinima - this.listadoElementos.length > 0) {
            this.crecer(capacidadMinima);
        }
    }

    private void asegurarCapacidadInterna(int capacidadMinima) {
        this.asegurarCapacidadExplicita(calcularCapacidad(this.listadoElementos, capacidadMinima));
    }

    private void asegurarCapacidadExplicita(int capacidadMinima) {
        this.moduloContador++;
        if (capacidadMinima - this.listadoElementos.length > 0) {
            this.crecer(capacidadMinima);
        }
    }

    private String mostrarMensajeFueraDeRango(int indice) {
        return "Indice: " + indice + "Tamaño: " + this.tamanio;
    }

    private void verificarRango(int indice) {
        if (indice >= this.tamanio) {
            throw new IndexOutOfBoundsException(this.mostrarMensajeFueraDeRango(indice));
        }
    }

    private void escribirObjeto(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        int moduloContadorEsperado = this.moduloContador;
        s.defaultWriteObject();

        s.writeInt(this.tamanio);

        for (int i = 0; i < this.tamanio; i++) {
            s.writeObject(this.listadoElementos[i]);
        }

        if (this.moduloContador != moduloContadorEsperado) {
            throw new ConcurrentModificationException();
        }
    }

}
