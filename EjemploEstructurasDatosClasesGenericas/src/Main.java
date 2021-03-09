/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abarrios
 */
public class Main {

    public static Console c = new Console("PRUEBA LISTADOS");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaArreglo<String> lista = new ListaArreglo<>();

        lista.agregar("Arnaldo");
        lista.agregar("Andres");
        lista.agregar("Barrios");
        lista.agregar("Mena");

        for (Object elemento : lista.listar()) {
            c.println("" + elemento);
        }
        
        c.println("");

        String consultarElemento = lista.consultar("Arnaldo");

        if (consultarElemento != null) {
            lista.setElemento("ArnaldoAndres");
            for (Object elemento : lista.listar()) {
                c.println("" + elemento);
            }
        } else {
            c.println("No existe");
        }
    }
}
