
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
public interface Coleccion<E> extends Iterable<E> {

    public boolean estaVacia();

    @Override
    public Iterator<E> iterator();

}
