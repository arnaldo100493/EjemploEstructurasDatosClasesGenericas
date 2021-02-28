/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abarrios
 */
public interface Cola<E> extends Coleccion<E>{

    @Override
    public boolean estaVacia();
    
    public boolean poner(E elemento);
    
    public E quitar();
    
    public E primero();
    
    public E ultimo();
    
    public E buscar(Object objeto);
    
    public String imprimir();
}
