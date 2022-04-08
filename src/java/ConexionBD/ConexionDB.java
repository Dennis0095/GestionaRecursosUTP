package ConexionBD;

import java.sql.*;


public class ConexionDB {
    
    public static ConexionDB instance = null;
//Traemos la interfaz connection de la API JDBC
    private static Connection con;
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://192.168.1.50\\MSSQLSERVER:1433;databaseName=recursosti";
    private static final String USER = "alumnos";
    private static final String PASS = "Integrador2021";

    public ConexionDB() {     // METODO DE CONSTRUCTOR 
        try {
            Class.forName(DRIVER).newInstance();
            con = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Conectado correctamente");
        } catch (Exception ex) {
            System.out.println("Error en la conexion");
            ex.printStackTrace();
        }
    }
        
    public synchronized static ConexionDB getInstance() {    // METODO PARA GENERAR LAS INSTANCIAS DE CONEXION 
        if (instance == null) {
            instance = new ConexionDB();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return con;
    } 
    
    public void cerrarConexion(){   
        instance=null;
    }
}