/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.dao;


import com.application.bean.Event;
import com.application.bean.Requirement;
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
public class DAORequirements {
    
        public boolean DAOReqCreate(Requirement req){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM requirements WHERE description_req =?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setString(1,req.getDescription_req());
            ps.close();
            conn.close();
            resultado = Sql.ejecuta(ps);
            
            
            if (resultado==false){
                conn = Conexion.getConnection();
                sql = "INSERT INTO requirements (id_of, description_req) VALUES (?,?);";
                ps = conn.prepareStatement(sql);            
                ps.setInt(1,req.getId_of());
                ps.setString(2,req.getDescription_req());
        
                resultado = Sql.ejecuta(ps);
            
                    if(resultado==true){                
                        ps.close();
                        conn.close();
                        resultado = true;
                        System.out.println("DAOReqCreate: Success");
                    }else{
                        resultado = false;
                        System.out.println("DAOReqCreate: Failed");
                    }  
            }
        } catch (Exception e) {
            System.out.println("DAOReqCreate: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
        
        public List<Requirement> DAOReqListById(int id){
        List<Requirement> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM requirements WHERE id_of = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Requirement req = new Requirement(rs.getInt(1), rs.getInt(2),
                rs.getString(3));
                list.add(req);
             }
            
            
            if(list.size()>0) {                           
                ps.close();
                conn.close();                
                System.out.println("DAOReqListById: Success");
            }else{
                list = null;
                System.out.println("DAOReqListById: Failed");
            }  
            
            
            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOReqListById: Failed "+e.getMessage());            
        } 
        
        
        return list;
        }
        
        public boolean DAOReqDeleteById(int id){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "DELETE FROM requirements WHERE id_req=?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1,id);
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOReqDeleteById: Success");
            }else{
                resultado = false;
                System.out.println("DAOReqDeleteById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOReqDeleteById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
        
        public Requirement DAOReqList(int id){
        Requirement req = null;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM requirements WHERE id_req = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                req = new Requirement (rs.getInt(1),rs.getInt(2),
                rs.getString(3));}
            ps.close();
            rs.close();
            conn.close();               
            System.out.println("DAOReqList: Success");                      
        } catch (Exception e) {            
            System.out.println("DAOReqList: Failed "+e.getMessage());            
        }
              return req;
    }
        
        public boolean DAOReqUpdateById(Requirement req){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "UPDATE requirements "+ 
                         "SET id_of =?, description_req=? " +
                         "WHERE id_req=?";
            PreparedStatement ps = conn.prepareStatement(sql);  
            ps.setInt(1,req.getId_of());
            ps.setString(2,req.getDescription_req());
            ps.setInt(3,req.getId_req());

            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOReqUpdateById: Success");
            }else{
                resultado = false;
                System.out.println("DAOReqUpdateById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOReqUpdateById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }        
}
