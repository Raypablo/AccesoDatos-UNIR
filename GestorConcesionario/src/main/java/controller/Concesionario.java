package controller;

import database.DBConnection;
import database.SchemaDB;
import model.Empleado;

import java.sql.*;

public class Concesionario {

    //Hay 2 grandes objetos:
    //Statement --> "Query directa" --> INSERT INTO empleados (nombre, apellido, correo, telefono) VALUES ('Borja','Martin','correo@correo',1234
        //Esto puede ser true o false --> Create
        //nº de filas afectadas --> UPDATE o DELETE

    //PrepareStatement (EL MAS RECOMENDABLE) --> "Query con template" --> INSERT INTO empleados (nombre, apellido, correo, telefono) VALUES (?,?,?,?)
    //SetInt(4,123) (SetInt(nº de ?, dato))
    //SetInt(1,"Borja")
    //SetInt(2,"Martin")
    //SetInt(3,"correo@correo")

    //Vamos a realizar --> Create Read Update y Delete pero en realidad esta separado en 2
    //Create, Read y Update se realizan de una forma PERO Read se realiza de una forma totalmente diferente.

    //Insertar trabajador
    public void insertarTrabajador(Empleado empleado){

        //Connection -> Statement (query) -> execute
        Connection connection = new DBConnection().getConnection();

        //ya puedo acceder a la base de datos
        try {

            //String query = "INSERT INTO "+SchemaDB.TAB_EMP+" (" + SchemaDB.COL_EMPL_NAME + " , " + SchemaDB.COL_EMPL_SURNAME + " , " + SchemaDB.COL_EMPL_EMAIL + " , " + SchemaDB.COL_EMPL_PHO + ") VALUES ( '" + empleado.getNombre() + "' , '" + empleado.getApellido() + "' , '" + empleado.getCorreo() + "' , " + empleado.getTelefono() + ")";
            //el String query de arriba es bastante engorroso, lo mejor es hacerlo mediante el metodo de abajo

            Statement statement = connection.createStatement();
            String queryPS = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?)",
                    SchemaDB.TAB_EMP,
                    SchemaDB.COL_EMPL_NAME, SchemaDB.COL_EMPL_SURNAME, SchemaDB.COL_EMPL_EMAIL, SchemaDB.COL_EMPL_PHO, SchemaDB.COL_EMPL_KIN);

            PreparedStatement preparedStatement = connection.prepareStatement(queryPS);

            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getApellido());
            preparedStatement.setString(3, empleado.getCorreo());
            preparedStatement.setInt(4, empleado.getTelefono());
            preparedStatement.setInt(5, empleado.getTipo().getId());

            preparedStatement.execute();


            //%s -> String
            //%d -> int
            //%f -> double o float
            //%b -> boolean
            //%c -> char
            /*
            String query = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES ('%s', '%s', '%s', %d)",
                    SchemaDB.TAB_EMP,
                    SchemaDB.COL_EMPL_NAME, SchemaDB.COL_EMPL_SURNAME, SchemaDB.COL_EMPL_EMAIL, SchemaDB.COL_EMPL_PHO,
                    empleado.getNombre(), empleado.getApellido(), empleado.getCorreo(), empleado.getTelefono());

            statement.execute(query); //Si hay o no fallo
            */
            //statement.executeUpdate(); //cuantas filas estan afectadas

        } catch (SQLException e) {

            System.out.println("Error en la conexion de la BBDD");

        }

    }

    public void borrarUsuario(int id){

        Connection connection = new DBConnection().getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM "+SchemaDB.TAB_EMP + " Where id = ?");
            preparedStatement.setInt(1, 1);
            int row = preparedStatement.executeUpdate();
            System.out.println("El Nº de registros borrados son: " + row);

        } catch (SQLException e) {

            System.out.println("Error en la creacion de la query");

        }

    }

    public void leerUsuario(int tipo){

        //Si tuviera JPA podria mapearlo, al no tenerlo aun (porque no se ha dado)
        //no nos queda otra que sacar el empleado en forma de vector de vectores [[nombre, apellido][nombre, apellido]]

        //Necesitamos una connection luego un PrepareStatement o un Statement (Pero no podemos ejecutar el execute ni el executeUpdate porque no nos intenresa
        //saber cuales han sido modificadas o si se han modificados. Lo que nos interesa ahora es executeQuery que nos devuelve un obejto de ResultSet
        //que es el vector que hemos hablado antes

        Connection connection = new DBConnection().getConnection();
        String query =String.format("SELECT * FROM %s WHERE %s = ?",SchemaDB.TAB_EMP, SchemaDB.COL_EMPL_KIN);
        //String query = "SELECT * FROM " + SchemaDB.TAB_EMP;
        PreparedStatement preparedStatement;

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tipo); // con esto le decimos que el ? de la query es la variable tipo
            ResultSet resultSet = preparedStatement.executeQuery();

            //resultSet.next()
            //con esto nos movemos al primer resultado del vector
            //imaginamos que nos da R, R, R, R, R (R es resultado) y con resultSet.next() es que nos vamos
            //moviendo de resultado en resultado cada vez que lo ejecutamos pero lo que nos devuelve resultSet.next() es un boolean
            //dependiendo de si encuentra algun resultado o vacio nos dará true o false

            while(resultSet.next()){

                String nombre = resultSet.getString(SchemaDB.COL_EMPL_NAME); //Con getString podemos pedirle que nos saque la informacion
                String correo = resultSet.getString(SchemaDB.COL_EMPL_EMAIL);
                int tipo1 = resultSet.getInt(SchemaDB.COL_EMPL_KIN);
                //que hay en la columna llamada (lo que le pongamos entre los () )

                System.out.printf("Nombre del empleado: %s\n\tCorreo del empleado %s\n\ttipo del empleado %s\n",nombre,correo,tipo1);
                //para formatear la salida de esta forma no utilizamos println o print, usamos printf

            }

        } catch (SQLException e) {

            System.out.println("Error en la Query");

        }

    }
}
