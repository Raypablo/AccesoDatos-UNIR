import controller.GestionFicherosEscritura;
import controller.GestorFicherosConjuntos;
import controller.GestorFicherosLectura;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        /*
         *******************
         *     CLASE 7    *
         *******************
         */

        GestorFicherosConjuntos gestorFicherosConjuntos = new GestorFicherosConjuntos();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {

            System.out.println("Introduce que quieres hacer");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    gestorFicherosConjuntos.cifrado("src/resources/ficheros/cifrado.txt");
                    break;

                case 2:
                    gestorFicherosConjuntos.descifrarCodigo("src/resources/ficheros/cifrado.txt");
                    break;
            }

        }while(opcion!=0);


         /*
           *******************
           *     CLASE 6    *
           *******************


        //GestionFicherosEscritura gestionFicherosEscritura = new GestionFicherosEscritura();
        //gestionFicherosEscritura.escribirFichero("src/resources/ficheros/");

        GestorFicherosConjuntos gestorFicherosConjuntos = new GestorFicherosConjuntos();
        gestorFicherosConjuntos.lecturaEscritura("src/resources/ficheros/cifrado.txt");
        */

        /*
           *******************
           *     CLASE 4    *
           *******************
        GestorFicherosLectura gestorFicherosLectura = new GestorFicherosLectura();
        //gestorFicheros.lecturaDirectorios("src/resources/directorio");

        gestorFicherosLectura.lecturaTextoPlano("src/resources/ficheros/lectura.txt");



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




