/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.dao;


import com.application.bean.Local;
import com.application.bean.Postulaciones;
import com.application.sql.Conexion;
import com.application.sql.Sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Monica
 */
public class DAOPostulaciones {
    
    
   public boolean DAOPostulacionesCreate(Postulaciones post){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM postulaciones WHERE id_persona =?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1,post.getId_persona());
            ps.close();
            conn.close();
            resultado = Sql.ejecuta(ps);
            
            if (resultado==false){
                            
                conn = Conexion.getConnection();
                sql = "INSERT INTO postulaciones (id_persona, id_of) VALUES (?,?);";
                ps = conn.prepareStatement(sql);            
                ps.setInt(1,post.getId_persona());
                ps.setInt(2,post.getId_of());
                resultado = Sql.ejecuta(ps);

                if(resultado==true){                
                    ps.close();
                    conn.close();
                    resultado = true;
                    System.out.println("DAOPostulacionesCreate: Success");
                }else{
                    resultado = false;
                    System.out.println("DAOPostulacionesCreate: Failed");
                } 
            }
        } catch (Exception e) {
            System.out.println("DAOPostulacionesCreate: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
   
   public List<Postulaciones> DAOPostulacionesListById(int id){
        List<Postulaciones> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM postulaciones WHERE id_persona = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Postulaciones post = new Postulaciones(rs.getInt(1),rs.getInt(2),rs.getInt(3));
                list.add(post);
             }
                        
            if(list.size()>0) {                           
                ps.close();
                conn.close();                
                System.out.println("DAOPostulacionesListById: Success");
            }else{
                list = null;
                System.out.println("DAOPostulacionesListById: Failed");
            }  
        } catch (Exception e) {
            list = null;
            System.out.println("DAOPostulacionesListById: Failed "+e.getMessage());            
        } 
        return list;
        }
   
}
