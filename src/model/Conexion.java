package model;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Conexion {
	private static final Conexion conexion = new Conexion();
	
	private static Connection con;
    private final String ruta="jdbc:mysql://localhost:3306/pull"; 
    private final String usuario="root";
    private final String password="";


    private Conexion(){       
    	System.out.println("singleton");
        try {
 	       Class.forName("com.mysql.jdbc.Driver");
 	       con=DriverManager.getConnection(ruta,usuario,password);
 	   } catch (Exception e) {
 		   System.out.println(e.getMessage());
 	   }        
    }
    
    
   public static Conexion getConexion(){
	   return conexion;
   }
   
   public Connection getConex(){
       return con;
   }
}
