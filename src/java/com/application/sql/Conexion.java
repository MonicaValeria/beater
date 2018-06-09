package com.application.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.sql.DataSource;

/**
 *
 * @author ASUS
 */
public class Conexion {
  /*  
    private String dataSource = "jdbc/MySQLDataSource";
    
    public Connection getConnection(){
        Connection conn = null;
        try 
        {   
            //System.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.mysql.jdbc.Driver");
            
            Context contextoInicial = new InitialContext();
            Context contexto = (Context) contextoInicial.lookup("java:comp/env"); 
            DataSource date = (DataSource) contexto.lookup(dataSource);                    
            conn = date.getConnection();
            System.out.println("Connection Success");
        } catch(NameNotFoundException e){
          conn=null;
          System.out.println("Connection Failed: \n"+e.getMessage());
          e.printStackTrace();
        } catch(Exception e){
          conn=null;
          System.out.println("Connection Failed: \n"+e.getMessage());
          e.printStackTrace();
        }
        return conn;
    }
    */
    
      public static Connection getConnection() {
          
          
        Connection conn = null;

        try {
            String url ="jdbc:mysql://localhost:3306/db_beater?autoReconnect=true&useSSL=false";
            String user ="root2";
            String pass = "alumno2";
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion bd success");

        } catch (Exception e) {
            System.out.println("Conexion bd failed"+e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
      
  
}
