package com.application.sql;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ** @author dlimas-pract
 */
public class Sql {

    // INSERT, DELETE, UPDATE
    public static boolean ejecuta(PreparedStatement ps) throws Exception {
        boolean resultado = false;
        try {            
            ps.executeUpdate();
            resultado = true;
            System.out.println("SQLEjecuta: Success");
        } catch (SQLException e) {
            System.out.println("SQLEjecuta: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
   // SELECT simple
    static public List consulta(PreparedStatement ps) {

        List<Object[]> list = new ArrayList<Object[]>();
        try {       
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();
            // Toma titulos de columnas
            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }
            // fila 0 lleva los titulos de columnas
            list.add(titCols);

            // toma las filas de la consulta
            while (rs.next()) {
                Object[] fila = new Object[numCols];
                for (int i = 0; i < numCols; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                list.add(fila);
            }
            System.out.println("SQLConsulta: Success");
            
        } catch (SQLException e) {
            System.out.println("SQLConsulta: Failed " + e.getMessage() + "\t" + e.getSQLState());
            list = null;
        }
        return list;    // returna null si falla
    }
}
