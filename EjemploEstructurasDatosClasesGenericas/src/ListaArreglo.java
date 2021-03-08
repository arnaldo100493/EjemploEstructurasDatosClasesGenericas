
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abarrios
 */
public class ListaArreglo<E> implements Lista<E> {

    private Object[] listadoElementos;
    private int tamanio;
    private static final int CAPACIDAD_PREDETERMINADA = 10;
    private static final Object[] LISTADO_DATOS_ELEMENTO_VACIO = {};

    public ListaArreglo() {
        this.listadoElementos = new Object[CAPACIDAD_PREDETERMINADA];
    }

    public ListaArreglo(int capacidadInicial) {
        if (capacidadInicial > 0) {
            this.listadoElementos = new Object[capacidadInicial];
        } else if (capacidadInicial == 0) {
            this.listadoElementos = LISTADO_DATOS_ELEMENTO_VACIO;
        }
    }

    @Override
    public boolean estaVacia() {
        return this.tamanio == -1;
    }

    @Override
    public boolean agregar(E elemento) {
        this.listadoElementos[this.tamanio] = elemento;
        this.tamanio++;
        return true;
    }

    private E listadoElementos(int indice) {
        return (E) this.listadoElementos[indice];
    }

    private String mostrarMensajeFueraDeRango(int indice) {
        return "Índice: " + indice + ", Tamaño: " + this.tamanio;
    }

    private void verificarRango(int indice) {
        if (indice > this.tamanio) {
            throw new IndexOutOfBoundsException(this.mostrarMensajeFueraDeRango(indice));
        }
    }

    public E obtener(int indice) {
        this.verificarRango(indice);
        return this.listadoElementos(indice);
    }

    public E consultar(Object consultarElemento) {
        E elemento = null;
        for (int i = 0; i < this.tamanio; i++) {
            if (this.listadoElementos[i].equals(consultarElemento)) {
                elemento = (E) this.listadoElementos[i];
            }
        }
        return elemento;
    }

    public Object[] listar() {
        Object[] elementosConsultados = new Object[this.tamanio];
        for (int i = 0; i < this.tamanio; i++) {
            elementosConsultados[i] = this.listadoElementos[i];
        }
        return elementosConsultados;
    }

    public boolean modificar(E elemento) {
        for (int i = 0; i < this.tamanio; i++) {
            if (this.listadoElementos[i].equals(elemento)) {
                this.listadoElementos[i] = elemento;
            }
        }
        return true;
    }

    private void reemplazar(int r) {
        for (int i = r; i < this.tamanio - 1; i++) {
            this.listadoElementos[i] = this.listadoElementos[i + 1];
            this.listadoElementos[this.tamanio - 1] = null;
        }
        this.tamanio--;
    }

    public boolean eliminar(E elemento) {
        for (int i = 0; i < this.tamanio; i++) {
            if (listadoElementos[i].equals(elemento)) {
                this.reemplazar(i);
            }
        }
        return true;
    }

    public int tamanio() {
        return this.tamanio;
    }

    public String imprimir() {
        String s = "";
        for (int i = 0; i < this.tamanio; i++) {
            s += "\n" + this.listadoElementos[i];
        }
        return s;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
