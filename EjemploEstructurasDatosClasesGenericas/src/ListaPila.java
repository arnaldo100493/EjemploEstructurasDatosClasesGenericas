
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
public class ListaPila<E> implements Pila<E> {

    private Nodo<E> tope;

    public ListaPila() {
        this.tope = null;
    }

    @Override
    public boolean estaVacia() {
        return this.tope == null;
    }

    @Override
    public void poner(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (this.estaVacia()) {
            this.tope = nuevoNodo;
        } else {
            this.tope.setSiguiente(nuevoNodo);
            this.tope = nuevoNodo;
        }
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
    public String imprimir() {
        String s = "";
        ListaPila<E> listaPilaAuxiliar = new ListaPila<>();
        while (!this.estaVacia()) {
            E elemento = this.quitar();
            s += "\n" + elemento;
            listaPilaAuxiliar.poner(elemento);
        }
        while (!listaPilaAuxiliar.estaVacia()) {
            this.poner(listaPilaAuxiliar.quitar());
        }
        return s;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
