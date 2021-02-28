/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abarrios
 */
public class PilaLista<E> implements Pila<E> {

    private Nodo<E> tope;

    public PilaLista() {
        this.tope = null;
    }

    @Override
    public boolean estaVacia() {
        return this.tope == null;
    }

    @Override
    public boolean poner(E elemento) {
        Nodo<E> nodo = new Nodo<>(elemento);
        if (this.estaVacia()) {
            this.tope = nodo;
        } else {
            this.tope.setSiguiente(nodo);
            this.tope = nodo;
        }
        return true;
    }

    @Override
    public E quitar() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.tope.getElemento();
            this.tope = this.tope.getSiguiente();
        }
        return elemento;
    }

    @Override
    public E cima() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.tope.getElemento();
        }
        return elemento;
    }

    @Override
    public E buscar(Object objeto) {
        E elemento = null;
        while (!estaVacia()) {
            if (this.tope.getElemento().equals(objeto)) {
                elemento = tope.getElemento();
            }
        }
        return elemento;
    }

    @Override
    public String imprimir() {
        String s = "";
        PilaLista<E> pilaListaAux = new PilaLista<>();
        while (!this.estaVacia()) {
            E elemento = this.quitar();
            s += "\n" + elemento;
            pilaListaAux.poner(elemento);
        }
        while (!pilaListaAux.estaVacia()) {
            this.poner(pilaListaAux.quitar());
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
