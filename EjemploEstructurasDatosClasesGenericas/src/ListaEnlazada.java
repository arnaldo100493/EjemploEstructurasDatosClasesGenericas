
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abarrios
 */
public class ListaEnlazada<E> extends ListaAbstracta<E> implements Lista<E> {

    private Nodo<E> primero;
    private Nodo<E> ultimo;
    private transient int tamanio;

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean contiene(Object objeto) {
        return this.indiceDe(objeto) != -1;
    }

    public int indiceDe(Object objeto) {
        int indice = 0;
        if (objeto == null) {
            for (Nodo<E> nodo = this.primero; nodo != null; nodo = nodo.getSiguiente()) {
                if (nodo.getElemento() == null) {
                    return indice;
                }
                indice++;
            }
        } else {
            for (Nodo<E> nodo = this.primero; nodo != null; nodo = nodo.getSiguiente()) {
                if (objeto.equals(nodo.getElemento())) {
                    return indice;
                }
                indice++;
            }
        }
        return -1;
    }

    public int ultimoIndiceDe(Object objeto) {
        int indice = this.tamanio;
        if (objeto == null) {
            for (Nodo<E> nodo = this.ultimo; nodo != null; nodo = nodo.getAnterior()) {
                indice--;
                if (nodo.getElemento() == null) {
                    return indice;
                }
            }
        } else {
            for (Nodo<E> nodo = this.ultimo; nodo != null; nodo = nodo.getAnterior()) {
                indice--;
                if (objeto.equals(nodo.getElemento())) {
                    return indice;
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
        return this.primero == null && this.ultimo == null;
    }

    public void limpiar() {
        for (Nodo<E> nodo = this.primero; nodo != null;) {
            Nodo<E> siguiente = nodo.getSiguiente();
            nodo.setElemento(null);
            nodo.setSiguiente(null);
            nodo.setAnterior(null);
            nodo = siguiente;
        }
        this.primero = this.ultimo = null;
        this.tamanio = 0;
        this.moduloContador++;
    }

    @Override
    public boolean agregar(E elemento) {
        this.enlazarUltimo(elemento);
        return true;
    }

    @Override
    public void agregar(int indice, E elemento) {
        this.verificarIndicePosicion(indice);
        if (indice == this.tamanio) {
            this.enlazarUltimo(elemento);
        } else {
            this.enlazarAntes(elemento, nodo(indice));
        }
    }

    public void agregarPrimero(E elemento) {
        this.enlazarPrimero(elemento);
    }

    public void agregarUltimo(E elemento) {
        this.enlazarUltimo(elemento);
    }

    public boolean ofrecer(E elemento) {
        return this.agregar(elemento);
    }

    public boolean ofrecerPrimero(E elemento) {
        this.agregarPrimero(elemento);
        return true;
    }

    public boolean ofrecerUltimo(E elemento) {
        this.agregarUltimo(elemento);
        return true;
    }

    public void poner(E elemento) {
        this.agregarPrimero(elemento);
    }

    @Override
    public E obtener(int indice) {
        this.verificarIndiceElemento(indice);
        return nodo(indice).getElemento();
    }

    public E obtenerPrimero() {
        final Nodo<E> p = this.primero;
        if (p == null) {
            throw new NoSuchElementException();
        }
        return p.getElemento();
    }

    public E obtenerUltimo() {
        final Nodo<E> u = this.ultimo;
        if (u == null) {
            throw new NoSuchElementException();
        }
        return u.getElemento();
    }

    public E cima() {
        final Nodo<E> p = this.primero;
        return (p == null) ? null : p.getElemento();
    }

    public E cimaPrimero() {
        final Nodo<E> p = this.primero;
        return (p == null) ? null : p.getElemento();
    }

    public E cimaUltimo() {
        final Nodo<E> u = this.ultimo;
        return (u == null) ? null : u.getElemento();
    }

    public E elemento() {
        return this.obtenerPrimero();
    }

    public E fondo() {
        final Nodo<E> p = this.primero;
        return (p == null) ? null : this.desenlazarPrimero(p);
    }

    public E fondoPrimero() {
        final Nodo<E> p = this.primero;
        return (p == null) ? null : this.desenlazarPrimero(p);
    }

    public E fondoUltimo() {
        final Nodo<E> u = this.ultimo;
        return (u == null) ? null : this.desenlazarUltimo(u);
    }

    public E modificar(int indice, E elemento) {
        this.verificarIndiceElemento(indice);
        Nodo<E> nodo = this.nodo(indice);
        E antiguoValor = nodo.getElemento();
        return antiguoValor;
    }

    @Override
    public boolean remover(Object objeto) {
        if (objeto == null) {
            for (Nodo<E> nodo = this.primero; nodo != null; nodo = nodo.getSiguiente()) {
                if (nodo.getElemento() == null) {
                    this.desenlazar(nodo);
                    return true;
                }
            }
        } else {
            for (Nodo<E> nodo = this.primero; nodo != null; nodo = nodo.getSiguiente()) {
                if (objeto.equals(nodo.getElemento())) {
                    this.desenlazar(nodo);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remover(int indice) {
        this.verificarIndiceElemento(indice);
        return this.desenlazar(this.nodo(indice));
    }

    public E remover() {
        return this.removerPrimero();
    }

    public E removerPrimero() {
        final Nodo<E> p = this.primero;
        if (p == null) {
            throw new NoSuchElementException();
        }
        return this.desenlazarPrimero(p);
    }

    public E removerUltimo() {
        final Nodo<E> u = this.ultimo;
        if (u == null) {
            throw new NoSuchElementException();
        }
        return this.desenlazarUltimo(u);
    }

    public E quitar() {
        return this.removerPrimero();
    }

    public boolean removerPrimeraOcurrencia(Object objeto) {
        return this.remover(objeto);
    }

    public boolean removerUltimaOcurrencia(Object objeto) {
        if (objeto == null) {
            for (Nodo<E> nodo = this.ultimo; nodo != null; nodo = nodo.getAnterior()) {
                if (nodo.getElemento() == null) {
                    this.desenlazar(nodo);
                    return true;
                }
            }
        } else {
            for (Nodo<E> nodo = this.ultimo; nodo != null; nodo = nodo.getAnterior()) {
                if (objeto.equals(nodo.getElemento())) {
                    this.desenlazar(nodo);
                    return true;
                }
            }
        }
        return false;
    }

    public String imprimir() {
        String s = "";
        ListaEnlazada<E> listaEnlazadaAux = new ListaEnlazada<>();
        while (!this.estaVacia()) {
            E elemento = this.quitar();
            s += "\n" + elemento;
            listaEnlazadaAux.poner(elemento);
        }
        while (!listaEnlazadaAux.estaVacia()) {
            this.poner(listaEnlazadaAux.quitar());
        }
        return s;
    }

    private void enlazarPrimero(E elemento) {
        final Nodo<E> p = this.primero;
        final Nodo<E> nuevoNodo = new Nodo<>(null, elemento, p);
        this.primero = nuevoNodo;
        if (p == null) {
            this.ultimo = nuevoNodo;
        } else {
            p.setSiguiente(nuevoNodo);
            this.tamanio++;
            this.moduloContador++;
        }
    }

    private void enlazarUltimo(E elemento) {
        final Nodo<E> u = this.ultimo;
        final Nodo<E> nuevoNodo = new Nodo<>(u, elemento, null);
        this.ultimo = nuevoNodo;
        if (u == null) {
            this.primero = nuevoNodo;
        } else {
            u.setSiguiente(nuevoNodo);
            this.tamanio++;
            this.moduloContador++;
        }
    }

    private void enlazarAntes(E elemento, Nodo<E> siguienteNodo) {
        final Nodo<E> anteriorNodo = siguienteNodo.getAnterior();
        final Nodo<E> nuevoNodo = new Nodo<>(anteriorNodo, elemento, siguienteNodo);
        siguienteNodo.setAnterior(nuevoNodo);
        if (anteriorNodo == null) {
            this.primero = nuevoNodo;
        } else {
            anteriorNodo.setSiguiente(nuevoNodo);
            this.tamanio++;
            this.moduloContador++;
        }
    }

    private E desenlazar(Nodo<E> nodo) {
        final E elemento = nodo.getElemento();
        final Nodo<E> anterior = nodo.getAnterior();
        final Nodo<E> siguiente = nodo.getSiguiente();

        if (anterior == null) {
            this.primero = siguiente;
        } else {
            anterior.setSiguiente(siguiente);
            nodo.setAnterior(null);
        }

        if (siguiente == null) {
            this.ultimo = anterior;
        } else {
            siguiente.setAnterior(anterior);
            nodo.setSiguiente(null);
        }

        nodo.setElemento(null);
        this.tamanio--;
        this.moduloContador++;
        return elemento;
    }

    private E desenlazarPrimero(Nodo<E> p) {
        final E elemento = p.getElemento();
        final Nodo<E> siguiente = p.getSiguiente();
        p.setElemento(null);
        p.setSiguiente(null);
        this.primero = siguiente;
        if (siguiente == null) {
            this.ultimo = null;
        } else {
            siguiente.setAnterior(null);
            this.tamanio--;
            this.moduloContador++;
        }

        return elemento;
    }

    private E desenlazarUltimo(Nodo<E> u) {
        final E elemento = u.getElemento();
        final Nodo<E> anterior = u.getAnterior();
        u.setElemento(null);
        u.setAnterior(null); // help GC
        this.primero = anterior;
        if (anterior == null) {
            primero = null;
        } else {
            anterior.setSiguiente(null);
            this.tamanio--;
            this.moduloContador++;
        }

        return elemento;
    }

    private Nodo<E> nodo(int indice) {
        if (indice < (this.tamanio >> 1)) {
            Nodo<E> x = this.primero;
            for (int i = 0; i < indice; i++) {
                x = x.getSiguiente();
            }
            return x;
        } else {
            Nodo<E> x = this.ultimo;
            for (int i = this.tamanio - 1; i > indice; i--) {
                x = x.getAnterior();
            }
            return x;
        }
    }

    private String mostrarMensajeFueraDeRango(int indice) {
        return "Indice: " + indice + "Tamaño: " + this.tamanio;
    }

    private boolean esIndiceElemento(int indice) {
        return indice >= 0 && indice < this.tamanio;
    }

    private boolean esIndicePosicion(int indice) {
        return indice >= 0 && indice <= this.tamanio;
    }

    private void verificarIndiceElemento(int indice) {
        if (!this.esIndiceElemento(indice)) {
            throw new IndexOutOfBoundsException(this.mostrarMensajeFueraDeRango(indice));
        }
    }

    private void verificarIndicePosicion(int indice) {
        if (!this.esIndicePosicion(indice)) {
            throw new IndexOutOfBoundsException(this.mostrarMensajeFueraDeRango(indice));
        }
    }
}
