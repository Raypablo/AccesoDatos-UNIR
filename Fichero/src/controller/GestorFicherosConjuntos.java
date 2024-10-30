package controller;
import java.io.*;
import java.util.Scanner;

public class GestorFicherosConjuntos {

    public void cifrado(String path){

        Scanner scanner = new Scanner(System.in);
        File file = new File(path);
        FileWriter fileWriter = null;

        System.out.println("Por favor, introduce el mensaje que quieres guardar");
        String mensaje = scanner.nextLine();

        System.out.println("Por favor, indica la fase de cifrado del mensaje");
        int fase = scanner.nextInt();

        try{

            fileWriter = new FileWriter(file,false);

            //Lo que vamos a hacer ahora es "cifrar" el contenido del fichero

            for(int i=0; i<mensaje.length();i++){

                char letra = mensaje.charAt(i);
                //fileWriter.write(letra+" ");

                int codigo = (int)letra;
                //fileWriter.write(String.valueOf(codigo)+"\n");

                //Para que sea un "cifrado" mas potente podemos hacer lo siguiente
                //fileWriter.write(String.valueOf(codigo*fase)+"\n");
                char codigoLetra = (char) (codigo*fase); //con esto conseguimos que nos salgan caracteres raros ej: ϲѾ҈іŀϲѾŀҒьϊŀѠѴҒϲϔϊ en lugar de numeros
                fileWriter.write(codigoLetra);
            }

        }catch (IOException e){

            System.out.println("Error en los permisos");

        }finally {

            try {

                fileWriter.close();

            }catch (IOException | NullPointerException e){

                System.out.println("Fallo en el cerrado");

            }
        }
    }

    public void descifrar(String path){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, indica la fase de descifrado del mensaje");
        int fase = scanner.nextInt();

        File file = new File(path);
        BufferedReader bufferedReader = null;

        try{

            bufferedReader = new BufferedReader(new FileReader(file)); // Recordamos que BufferedReader debe de tener en parametro un FileReader
            String lectura = null;

            while((lectura=bufferedReader.readLine())!=null){ //En lectura tendria cada una de las lineas con esto --> lectura=bufferedReader.readLine()

                int codigo = Integer.valueOf(lectura); //tenemos que hacer Integer.valueOf() ya que lo que tenemos en lectura es un String
                System.out.print((char)(codigo/fase));
            }

        }catch (Exception e){


        }



    }

    public void descifrarCodigo(String path){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, indica la fase de descifrado del mensaje");
        int fase = scanner.nextInt();

        File file = new File(path);
        BufferedReader bufferedReader = null;

        try{

            bufferedReader = new BufferedReader(new FileReader(file)); // Recordamos que BufferedReader debe de tener en parametro un FileReader
            String lectura = null;
            StringBuffer lecturaConjunta = new StringBuffer();


            while((lectura=bufferedReader.readLine())!=null){ //En lectura tendria cada una de las lineas con esto --> lectura=bufferedReader.readLine()

               lecturaConjunta.append(lectura);
            }
            System.out.println(lecturaConjunta);

            for(int i=0; i<lecturaConjunta.length();i++){ //Con esto conseguimos ir letra a letra descifrando ya que lo hemos hecho en una sola linea (descrifrando tambien los espacios)
                int codigo = (int)lecturaConjunta.charAt(i)/fase;
                System.out.print((char)codigo);
            }
            System.out.println();
        }catch (Exception e){


        }



    }

}
