package resources;

import model.Producto;

import java.io.*;

public class GestorFicheros {

    public void escribirBinarios (String path){

        File file = new File(path);
        DataOutputStream dataOutputStream = null;

        try {

            dataOutputStream = new DataOutputStream(new FileOutputStream(file));

            dataOutputStream.writeUTF("Ejemplo de escritura binaria");
            dataOutputStream.writeInt(5);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeChar(234);

        } catch (FileNotFoundException e) {

            System.out.println("Fichero no encontrado");

        }catch (IOException e){

            System.out.println("Problema con el fichero");

        }finally {

            try {

                dataOutputStream.close();

            } catch (IOException | NullPointerException e) {

                System.out.println("Error al cerrar");

            }
        }
    }

    public void lecturaBinarios (String path){

        File file = new File(path);
        DataInputStream dataInputStream = null;

        try {

            dataInputStream = new DataInputStream(new FileInputStream(file));

            /* Hemos escrito por orden

                1º Chars
                2º Entero
                3º booleano
                4º Char

             */

            //Chars
            String lectura = dataInputStream.readUTF();
            System.out.println(lectura);

            //int
            int numero = dataInputStream.readInt();
            System.out.println(numero);

            //boolean
            boolean valor = dataInputStream.readBoolean();
            System.out.println(valor);

            //char
            char letra = dataInputStream.readChar();
            System.out.println(letra);

        } catch (FileNotFoundException e) {

            System.out.println("Fichero no encontrado");

        }catch (IOException e){

            System.out.println("Problema con el fichero");

        }finally {

            try {

                dataInputStream.close();

            } catch (IOException | NullPointerException e) {

                System.out.println("Error al cerrar");

            }
        }
    }

    public void escribirObjetos (String path){

        File file = new File(path);
        ObjectOutputStream objectOutputStream = null;

        try {

            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(new Producto(1, "Producto", 98.65, 3));

        }catch (IOException e){

            System.out.println("Problema con el fichero");
            System.out.println(e.getMessage());

        }finally {

            try {

                objectOutputStream.close();

            } catch (IOException | NullPointerException e) {

                System.out.println("Error al cerrar");

            }
        }
    }

    public void lecturaObjetos (String path){


        File file = new File(path);
        ObjectInputStream objectInputStream = null;

        try {

            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Producto producto = (Producto) objectInputStream.readObject(); // Por si acaso no casteamos correctamente la clase hay que poner en catch ClassCastException
            producto.mostrarDatos();

            /*
            objectInputStream.readObject(); //se puede poner asi si no conocemos la clase del objeto guardado
            Hay que poner un ClassNotFoundException por si no encuentra la clase a no ser que pongamos la clase concreta.
            */

        } catch (IOException e) {

            System.out.println("Error en la lectura del fichero");

        } catch (ClassNotFoundException e) {

            System.out.println("No se encuentra la clase destino");

        }catch (ClassCastException e){

            System.out.println("Error al declarar el tipo de dato");

        }

    }

}
