
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
public class ListaCola<E> implements Cola<E> {

    private Nodo<E> primero;
    private Nodo<E> ultimo;

    public ListaCola() {
        this.primero = null;
        this.ultimo = null;
    }

    @Override
    public boolean estaVacia() {
        return this.primero == null;
    }

    @Override
    public void poner(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (this.estaVacia()) {
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        } else {
            this.ultimo.setSiguiente(nuevoNodo);
            this.ultimo = nuevoNodo;
        }
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
    public String imprimir() {
        String s = "";
        ListaCola<E> listaColaAuxiliar = new ListaCola<>();
        while (!this.estaVacia()) {
            E elemento = this.quitar();
            s += "\n" + elemento;
            listaColaAuxiliar.poner(elemento);
        }
        while (!listaColaAuxiliar.estaVacia()) {
            this.poner(listaColaAuxiliar.quitar());
        }
        return s;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
