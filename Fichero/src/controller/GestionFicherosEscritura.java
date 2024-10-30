package controller;

import java.io.*;
import java.util.Scanner;

public class GestionFicherosEscritura {

    public void escribirFichero(String path) {

        //el flujo es el siguiente File --> FileWriter --> BufferedWriter/PrintWriter --> Cerrar

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el nombre del fichero");
        String nombreFichero = scanner.next();
        scanner.nextLine(); // Limpia el buffer antes de leer la línea completa
        System.out.println("Por favor introduce lo que quieres guardar");
        String lecturaFrase = scanner.nextLine();

        try {

            // FileWriter Se usa para escribir poco texto, cada vez que escribimos algo, va directamente para el archivo, escritura lenta

            //fileWriter = new FileWriter(path+nombreFichero+".txt", true); Se puede poner directamente en BufferedWriter
            //fileWriter.write("\n"+lecturaFrase);

            // BufferedWriter se usa para escrituras grandes ya que no escribe palabra por palabra como fileWriter, lo que hace es que almacena todo el texto que se
            // va a introducir y lo escribe de una sola vez, escritura bastante rapida

            //bufferedWriter = new BufferedWriter(new FileWriter(path+nombreFichero+".txt", true));
            //bufferedWriter.write(lecturaFrase);
            //bufferedWriter.newLine(); //Para ir a la siguiente linea

            // PrintWriter no se puede hacer sobreescritura, es para hacer una escritura de una, ademas te permite escribir con formato pero no es tan rapido escribiedo
            printWriter = new PrintWriter(new FileWriter(path+nombreFichero+".txt"));
            printWriter.println(lecturaFrase);

        } catch (IOException e) {

            System.out.println("Error en la escritura del fichero por permisos");

        }finally {

            try {

                //bufferedWriter.close();
                printWriter.close();

            }catch (/* IOException | - En printWriter no hace falta printWriter.close por lo tanto tampoco necesita IOException */ NullPointerException e){

                System.out.println("Error en el cierre del flujo");

            }
        }

        // en realidad es new FileWriter(path, append), append es para anexar o no la escritura, y puede ser True o False
        //true, mantiene lo que tiene el fichero y continua abajo. False, borra el contenido y escribe.
        //FileWriter nos puede dar error si no tenemos colocado una excepcion

    }

}
