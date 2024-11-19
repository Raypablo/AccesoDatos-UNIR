import controller.Concesionario;
import database.DBConnection;
import model.Empleado;
import model.Tipo;

import java.sql.Connection;

public class Entrada {

    public static void main(String[] args) {

        /*

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        dbConnection.closeConnection();

        DBConnection dbConnection2 = new DBConnection();
        Connection connection2 = dbConnection2.getConnection();

         */

        Concesionario concesionario = new Concesionario();
        //concesionario.insertarTrabajador(new Empleado("pablo2", "pepe2", "pablo@pablo",12345, Tipo.INDEFINIDO));
        //concesionario.borrarUsuario(1);
        concesionario.leerUsuario(2);
    }

}
