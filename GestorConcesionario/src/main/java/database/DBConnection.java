package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection; //Pertenece a la clase, no al objeto

    //Si alguien pide una conexion
    public Connection getConnection() {

       //si no está la conexion la creo
        if (connection == null) {

            newConnection();

        }

        //si está la conexion se la doy
        return connection;

    }

    private void newConnection() {

        //uri de conexion jdbc:mysql://127.0.0.1:3306/concesionario
        String url = "jdbc:mysql://localhost:3306/"+SchemaDB.DB_NAME;

        try {

            connection = DriverManager.getConnection(url,"root","");

        } catch (SQLException e) {

            System.out.println("Error al conectar con la BBDD");

        }

        System.out.println("Se ha creado la conexion correctamente");

    }

    public void closeConnection() {

        try {

            connection.close();

        } catch (SQLException e) {

            System.out.println("Error al cerrar conexion");

        }finally {

            connection = null;

        }
    }

}
