/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abarrios
 */
public interface Lista<E> extends Coleccion<E> {

    @Override
    public boolean estaVacia();
    
    public int tamanio();

    @Override
    public boolean agregar(E elemento);

    public void agregar(int indice, E elemento);

    public E obtener(int indice);

    @Override
    public boolean remover(Object objeto);

    public E remover(int indice);

}
