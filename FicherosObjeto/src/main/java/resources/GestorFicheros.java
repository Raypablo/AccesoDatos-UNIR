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

        }finally {

            try {

                objectOutputStream.close();

            } catch (IOException | NullPointerException e) {

                System.out.println("Error al cerrar");

            }
        }
    }

}
