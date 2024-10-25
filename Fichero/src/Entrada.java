import controller .GestorFicheros;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Entrada {

    public static void main(String[] args) {

        GestorFicheros gestorFicheros = new GestorFicheros();
        //gestorFicheros.lecturaDirectorios("src/resources/directorio");

        gestorFicheros.lecturaTextoPlano("src/resources/ficheros/lectura.txt");










        /*

           *******************
           *     CLASE 3     *
           *******************

        File ficheroSinPuntero = new File("src/resources/directorio/ejemplo_fichero.txt");
        System.out.println(ficheroSinPuntero.getName());
        System.out.println(ficheroSinPuntero.getParent());
        System.out.println(ficheroSinPuntero.length());
        System.out.println(ficheroSinPuntero.exists());
        System.out.println(ficheroSinPuntero.isFile());

        // Devuelve un array de todos los FCIHEROS que estan dentro del directorio
        ficheroSinPuntero.listFiles();

        //Devuelve un String Array con todas las rutas de los FICHEROS que estan dentro del directorio
        ficheroSinPuntero.list();

        //Hay que hacer el try/catch para manejar la excepcion de los permisos de creacion del archivo/fichero
        if(ficheroSinPuntero.exists()){
            try {
                ficheroSinPuntero.createNewFile();
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo");
            }
        }*/
    }
}




