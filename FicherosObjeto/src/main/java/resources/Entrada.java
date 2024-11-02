package resources;

public class Entrada {

    public static void main(String[] args) {

        GestorFicheros gestor = new GestorFicheros();
        gestor.escribirBinarios("src/main/java/resources/datos.bin");
        gestor.lecturaBinarios("src/main/java/resources/datos.bin");
    }
}
