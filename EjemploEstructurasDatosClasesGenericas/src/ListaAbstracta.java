
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abarrios
 */
public abstract class ListaAbstracta<E> extends ColeccionAbstracta<E> implements Lista<E> {
    
    protected transient int moduloContador = 0;

    public ListaAbstracta() {

    }

    @Override
    public boolean agregar(E dato) {
        this.agregar(this.tamanio(), dato);
        return true;
    }

    @Override
    public void agregar(int indice, E elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E obtener(int indice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public E remover(int indice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
