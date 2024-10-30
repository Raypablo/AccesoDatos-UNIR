package controller;
import java.io.*;

public class GestorFicherosLectura {

    public void lecturaDirectorios( String path){

    }

    public void lecturaRecursiva (String path){

        File file = new File(path);
        File[] files = file.listFiles();

        for(File item:files){

            System.out.println(item.getName());

            //pregunto si es directorio
            //saco todos los ficheros del directorio y los muestro --> y pueden ser n veces
            if(item.isDirectory()){
                lecturaSubdirectorio(item);
            }
        }
    }

    // RECURSIVIDAD -> EJECUCION QUE SE LLAMA A ELLA MISMA, CON CUIDADO DE QUE TENGA UNA SALIDA
    private void lecturaSubdirectorio(File fichero){

        for(File file:fichero.listFiles()){

            System.out.println(file.getName());
            if(file.isDirectory()){

                lecturaSubdirectorio(file);

            }
        }
    }

    public void lecturaTextoPlano(String path){

        // File -> FILEREADER -> BUFFERREADER -> Cuando se teminan SE CIERRAN
        File file = new File(path);
        //FileReader fileReader = null //Para cuando usemos FILE READER
        BufferedReader bufferedReader = null;

        if (file.exists() && file.isFile()) { //Existe y ademas es un fichero

            try{//Se trata la excepcion aqui

                bufferedReader = new BufferedReader( new FileReader(file));
                String lectura = null;
                //StringBuffer lecturaCompleta = new StringBuffer();
                // Con StringBuffer lo que conseguimos es una variable en la que concatena tdo el texto del fichero pero para añadir salto de linea hay que añadir lecturaCompleta.append("\n"); despues de añadir la linea
                StringBuilder lecturaCompleta = new StringBuilder(); // Funciona practicamente igual que StringBuffer

                //La unica diferencia entre StringBuffer  y StringBuilder es que StringBuffer es sincronizado, si tego varios hilo se comunican entre ellos para decir quien tiene el objeto ocupado
                //Con StringBuilder solo se puede para un hilo y da error cuando se ejecutan varios

                while((lectura = bufferedReader.readLine()) != null){
                    lecturaCompleta.append(lectura);
                    lecturaCompleta.append("\n"); // Asi se añade un salto de linea en StringBuffer
                }
                System.out.println(lecturaCompleta.toString());
                /*
                LECTURA CON FILE READER
                fileReader = new FileReader(file)
                int lectura = 0; // int -> UNICODE ASCI

                while ((lectura = fileReader.read())!=-1){ //mientras exista el numero haz la lectura e imprime
                    System.out.println((char)lectura);
                }

                */
            }catch(FileNotFoundException e){ //Aqui solo se manejan este tipo de error (FIleNotFoundException)

                System.out.println("Fallo en la lectura del fichero");
                System.out.println(e.getMessage());

            } catch (IOException e) {
                System.out.println("Error en la escritura, fallo de permisos");

            } finally{ //Se ejecuta si o si

                try{
                    bufferedReader.close(); //NULLPOINTEREXCEPTION

                }catch (IOException e){
                    System.out.println("Error en el cerrado del flujo");
                    System.out.println(e.getMessage());
                }catch (NullPointerException e){
                    System.out.println("Error en el cerrado por ser nulo");
                }



            }

        }

    }

}

