/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.dao;

import com.application.bean.Event;
import com.application.bean.Local;

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
public class DAOEvent {
    
    
        public boolean DAOEventCreate(Event ev){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM event WHERE name_ev =?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setString(1,ev.getName_ev());
            ps.close();
            conn.close();
            resultado = Sql.ejecuta(ps);
            
            
            if (resultado==false){
                conn = Conexion.getConnection();
                sql = "INSERT INTO event (id_person, name_ev, dia_inicio, dia_fin , hora_inicio_ev, "+
                        "hora_fin_ev, id_local, id_gm) VALUES (?,?,?,?,?,?,?,?);";
                ps = conn.prepareStatement(sql);            
                ps.setInt(1,ev.getId_person());
                ps.setString(2,ev.getName_ev());
                ps.setString(3,ev.getDia_inicio());
                ps.setString(4,ev.getDia_fin());
                ps.setString(5,ev.getHora_inicio_ev());
                ps.setString(6,ev.getHora_fin_ev());
                ps.setInt(7,ev.getId_local());
                ps.setInt(8,ev.getId_gm());


                resultado = Sql.ejecuta(ps);
            
                    if(resultado==true){                
                        ps.close();
                        conn.close();
                        resultado = true;
                        System.out.println("DAOEventCreate: Success");
                    }else{
                        resultado = false;
                        System.out.println("DAOEventCreate: Failed");
                    }  
            }
        } catch (Exception e) {
            System.out.println("DAOEventCreate: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
        
        public List<Event> DAOEventListById(int id){
        List<Event> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM event WHERE id_person = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Event ev = new Event(rs.getInt(1), rs.getInt(2),
                rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(ev);
             }
            
            
            if(list.size()>0) {                           
                ps.close();
                conn.close();                
                System.out.println("DAOEventListById: Success");
            }else{
                list = null;
                System.out.println("DAOEventListById: Failed");
            }  
            
            
            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOEventListById: Failed "+e.getMessage());            
        } 
        
        
        return list;
        }
        
        public List<Event> DAOEventList(){
        List<Event> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM event";            
            PreparedStatement ps = conn.prepareStatement(sql);                                   
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Event ev = new Event(rs.getInt(1), rs.getInt(2),
                rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(ev);
             }
            if(list.size()>0){                
                ps.close();
                conn.close();                
                System.out.println("DAOEventList: Success");
            }else{
                list = null;
                System.out.println("DAOEventList: Failed");
            }            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOEventList: Failed "+e.getMessage());            
        }        
        return list;
    }
        
        public List<Event> DAOEventListByIdEvent(int id){
        List<Event> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM event WHERE id_ev = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Event ev = new Event(rs.getInt(1), rs.getInt(2),
                rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(ev);
             }
            
            
            if(list.size()>0) {                           
                ps.close();
                conn.close();                
                System.out.println("DAOEventListByIdEvent: Success");
            }else{
                list = null;
                System.out.println("DAOEventListByIdEvent: Failed");
            }  
            
            
            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOEventListById: Failed "+e.getMessage());            
        } 
        
        
        return list;
        }
        
        public boolean DAOEventDeleteById(int id){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "DELETE FROM event WHERE id_ev=?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1,id);
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOEventDeleteById: Success");
            }else{
                resultado = false;
                System.out.println("DAOEventDeleteById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOEventDeleteById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
        
        public Event DAOEventList(int id){
        Event ev = null;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM event WHERE id_ev = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ev = new Event (rs.getInt(1),rs.getInt(2),
                rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getInt(8),
                rs.getInt(9));}
            ps.close();
            rs.close();
            conn.close();               
            System.out.println("DAOEventList: Success");                      
        } catch (Exception e) {            
            System.out.println("DAOEventList: Failed "+e.getMessage());            
        }
              return ev;
    }
        
        public boolean DAOEventUpdateById(Event ev){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "UPDATE event "+ 
                         "SET id_person=?, name_ev=?, dia_inicio=?, dia_fin=?, hora_inicio_ev=?, hora_fin_ev=?, id_local=?, id_gm=? " +
                         "WHERE id_ev=?";
            PreparedStatement ps = conn.prepareStatement(sql);  
            ps.setInt(1,ev.getId_person());
            ps.setString(2,ev.getName_ev());
            ps.setString(3,ev.getDia_inicio());
            ps.setString(4,ev.getDia_fin());
            ps.setString(5,ev.getHora_inicio_ev());
            ps.setString(6, ev.getHora_fin_ev());
            ps.setInt(7,ev.getId_local());
            ps.setInt(8,ev.getId_gm());
            ps.setInt(9, ev.getId_ev());
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOEventUpdateById: Success");
            }else{
                resultado = false;
                System.out.println("DAOEventUpdateById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOEventUpdateById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
        
}
