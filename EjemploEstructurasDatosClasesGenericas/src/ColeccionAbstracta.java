/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abarrios
 */
public abstract class ColeccionAbstracta<E> implements Coleccion<E> {

    public ColeccionAbstracta() {

    }

    @Override
    public abstract int tamanio();

    @Override
    public boolean estaVacia() {
        return this.tamanio() == 0;
    }

    @Override
    public boolean agregar(E elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
