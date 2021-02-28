/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abarrios
 */
public class ColaLista<E> implements Cola<E> {

    private Nodo<E> primero;
    private Nodo<E> ultimo;

    public ColaLista() {
        this.primero = null;
    }

    @Override
    public boolean estaVacia() {
        return this.primero == null;
    }

    @Override
    public boolean poner(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (this.estaVacia()) {
            this.primero = this.ultimo = nuevoNodo;
        } else {
            this.ultimo.setSiguiente(nuevoNodo);
            this.ultimo = nuevoNodo;
        }
        return true;
    }

    @Override
    public E quitar() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.primero.getElemento();
            this.primero = this.primero.getSiguiente();
        }
        return elemento;
    }

    @Override
    public E primero() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.primero.getElemento();
        }
        return elemento;
    }

    @Override
    public E ultimo() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.ultimo.getElemento();
        }
        return elemento;
    }

    @Override
    public E buscar(Object objeto) {
        E elemento = null;

        return elemento;
    }

    @Override
    public String imprimir() {
        String s = "";
        ColaLista<E> colaListaAux = new ColaLista<>();
        while (!this.estaVacia()) {
            E elemento = this.quitar();
            s += "\n" + elemento;
            colaListaAux.poner(elemento);
        }
        while (!colaListaAux.estaVacia()) {
            this.poner(colaListaAux.quitar());
        }
        return s;
    }

    @Override
    public boolean agregar(E elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contiene(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tamanio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
