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
        PilaLista<String> lista = new PilaLista<>();

        c.println("Ingrese la cantidad de nombres: ");

        int cantidadNombres = c.readInt();

        for (int i = 1; i <= cantidadNombres; i++) {
            String nombre = "P" + i;
            lista.poner(nombre);
        }

        c.println(lista.imprimir());

    }
}
