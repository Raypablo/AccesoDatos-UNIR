import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PeticionJSON {

    public void procesarPeticion() {

        // Los pasos a seguir seran, crear una URL luego hacer un HTTPCONNECTION y creamos un BUFFERREADER

         String urlString = "https://dummyjson.com/products";
         BufferedReader bufferedReader = null;

        try{

            URL url = new URL(urlString); // Peticion abierta
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Peticion realizada
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream())); //Peticion interpretada

            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();

            while ((linea = bufferedReader.readLine()) != null) {
                stringBuffer.append(linea);
            }

            //Una vez creado el JSONObject y añadido todo el contenido de stringBuffer, al ser ya un JSON podemos analizarlo
            JSONObject peticionProducto = new JSONObject(stringBuffer.toString());
            JSONArray listaProductos = peticionProducto.getJSONArray("products");

            //Para imprimir todos los titulos
            for(Object item : listaProductos){

                JSONObject producto = (JSONObject) item;

                System.out.println("Titulo: " + producto.getString("title"));
                System.out.println("Precio: " + producto.getDouble("price"));
                System.out.println("Las categorias del producto son:");

                JSONArray tags = producto.getJSONArray("tags");

                for(Object tag : tags){

                    System.out.println("\t"+"· "+tag);

                }

            }

            /*
            Para Imprimir 1 solo titulo
            JSONObject producto = listaProductos.getJSONObject(0);
            System.out.println(producto.getString("title"));
            */

        }catch(MalformedURLException e){ //captura el error de si url está mal formada

            System.out.println("No es una web, intentelo de nuevo");

        }catch (IOException e){ //captura el error por si la web no existe, no hay internet, etc...

            System.out.println("No se pudo abrir el web");

        }

    }

}
