package database;

public interface SchemaDB {

    //ESQUEMA DE LA BD

    //La inteface sirve ara conectar 2 clases que no tienen nada que ver
    //con los metodos abstractos que tienne dicha interfaz

    //La interface tambien sirve para almacenar constantes variables --> finales (no de metodos)


    //Le ponemos el mismo nombre que en la BBDD
    String DB_NAME = "concesionario";
    String TAB_EMP = "empleados";
    String COL_ID = "id";
    String COL_EMPL_NAME = "nombre";
    String COL_EMPL_SURNAME = "apellido";
    String COL_EMPL_EMAIL = "correo";
    String COL_EMPL_PHO = "telefono";

    String COL_EMPL_KIN = "tipo";
    String TAB_KIN = "tipos";
    String COL_KIN_DES = "descripcion";
    String COL_KIN_SIG = "siglas";

}
