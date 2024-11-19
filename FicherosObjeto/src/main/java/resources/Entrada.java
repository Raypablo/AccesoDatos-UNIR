package resources;

public class Entrada {

    public static void main(String[] args) {

        GestorFicheros gestor = new GestorFicheros();
        //gestor.escribirBinarios("src/main/java/resources/datos.bin");
        //gestor.lecturaBinarios("src/main/java/resources/datos.bin");

        gestor.escribirObjetos("src/main/java/resources/objetos_serializados.obj");
        gestor.lecturaObjetos("src/main/java/resources/objetos_serializados.obj");

    }
}
