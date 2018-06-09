/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.dao;

import com.application.bean.Local;


import com.application.sql.Conexion;
import com.application.sql.Sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Monica
 */
public class DAOLocal {
    
    
    public boolean DAOLocalCreate(Local lo){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM local WHERE name_local =?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setString(1,lo.getName_local());
            ps.close();
            conn.close();
            resultado = Sql.ejecuta(ps);
            
            if (resultado==false){
                            
                conn = Conexion.getConnection();
                sql = "INSERT INTO local (id_person, name_local, address, reference, telefono, dias, hora_inicio, hora_fin) VALUES (?,?,?,?,?,?,?,?);";
                ps = conn.prepareStatement(sql);            
                ps.setInt(1,lo.getId_person());
                ps.setString(2,lo.getName_local());
                ps.setString(3,lo.getAddress());
                ps.setString(4,lo.getReference());
                ps.setString(5, lo.getTelefono());
                ps.setString(6, lo.getDias());
                ps.setString(7, lo.getHorario_inicio());
                ps.setString(8, lo.getHorario_inicio());

                resultado = Sql.ejecuta(ps);

                if(resultado==true){                
                    ps.close();
                    conn.close();
                    resultado = true;
                    System.out.println("DAOLocalCreate: Success");
                }else{
                    resultado = false;
                    System.out.println("DAOLocalCreate: Failed");
                } 
            }
        } catch (Exception e) {
            System.out.println("DAOLocalCreate: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public List<Local> DAOLocalList(){
        List<Local> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM local";            
            PreparedStatement ps = conn.prepareStatement(sql);                                   
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Local local = new Local(rs.getInt(1),rs.getInt(2),
                rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7),
                rs.getString(8), rs.getString(9));
                list.add(local);
             }
            if(list.size()>0){                
                ps.close();
                conn.close();                
                System.out.println("DAOLocalList: Success");
            }else{
                list = null;
                System.out.println("DAOLocalList: Failed");
            }            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOLocalList: Failed "+e.getMessage());            
        }        
        return list;
    }
    
    public List<Local> DAOLocalListById(int id){
        List<Local> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM local WHERE id_person = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Local local = new Local(rs.getInt(1),rs.getInt(2),
                rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(local);
             }
                        
            if(list.size()>0) {                           
                ps.close();
                conn.close();                
                System.out.println("DAOLocalListById: Success");
            }else{
                list = null;
                System.out.println("DAOLocalListById: Failed");
            }  
            
            
            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOLocalListById: Failed "+e.getMessage());            
        } 
        
        
        return list;
        }
    
    public List<Local> DAOLocalListByIdLocal(int id){
        List<Local> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM local WHERE id_local = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Local local = new Local(rs.getInt(1),rs.getInt(2),
                rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)
                , rs.getString(9));
                list.add(local);
             }
            
            
            if(list.size()>0) {                           
                ps.close();
                conn.close();                
                System.out.println("DAOLocalListById: Success");
            }else{
                list = null;
                System.out.println("DAOLocalListById: Failed");
            }  
            
            
            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOLocalListById: Failed "+e.getMessage());            
        } 
        
        
        return list;
        }
    
    public boolean DAOLocalDeleteById(int id){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "DELETE FROM local WHERE id_local=?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1,id);
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOLocalDeleteById: Success");
            }else{
                resultado = false;
                System.out.println("DAOLocalDeleteById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOLocalDeleteById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean DAOLocalUpdateById(Local lo){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "UPDATE local "+ 
                         "SET id_person =?, name_local=?, address=?, reference=?, telefono=?, dias=?, hora_inicio=?, hora_fin=?" +
                         "WHERE id_local=?";
            PreparedStatement ps = conn.prepareStatement(sql);  
            ps.setInt(1,lo.getId_person());
            ps.setString(2,lo.getName_local());
            ps.setString(3,lo.getAddress());
            ps.setString(4,lo.getReference());
            ps.setString(5, lo.getTelefono());
            ps.setString(6, lo.getDias());
            ps.setString(7, lo.getHorario_inicio());
            ps.setString(8, lo.getHorario_fin());
            ps.setInt(9, lo.getId_local());
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOLocalUpdateById: Success");
            }else{
                resultado = false;
                System.out.println("DAOLocalUpdateById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOLocalUpdateById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public Local DAOLocalList(int id){
        Local lo = null;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM local WHERE id_local = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                lo = new Local(rs.getInt(1),rs.getInt(2),
                rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8),
                rs.getString(9));  }
            ps.close();
            rs.close();
            conn.close();               
            System.out.println("DAOLocalList: Success");                      
        } catch (Exception e) {            
            System.out.println("DAOLocalList: Failed "+e.getMessage());            
        }
              return lo;
    }
    
    
    
}


