/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abarrios
 */
public interface Coleccion<E> {

    public boolean estaVacia();

    public boolean contiene(Object objeto);

    public int tamanio();

    public boolean agregar(E elemento);

    public boolean remover(Object objeto);

}
