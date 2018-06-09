/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.dao;

import com.application.bean.Event;
import com.application.bean.Offer;
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
public class DAOOffer {
    
    public boolean DAOOfferCreate(Offer of){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM offer WHERE title_of =?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setString(1,of.getTitle_of());
            ps.close();
            conn.close();
            resultado = Sql.ejecuta(ps);
            
            
            if (resultado==false){
                conn = Conexion.getConnection();
                sql = "INSERT INTO offer (id_ev, id_person, title_of, dia_inicio, dia_fin , start_time_of, "+
                        "end_time_of, description_of) VALUES (?,?,?,?,?,?,?,?);";
                ps = conn.prepareStatement(sql);            
                ps.setInt(1,of.getId_ev());
                ps.setInt(2,of.getId_person());
                ps.setString(3,of.getTitle_of());
                ps.setString(4,of.getDia_inicio());
                ps.setString(5,of.getDia_fin());
                ps.setString(6,of.getStart_time_of());
                ps.setString(7,of.getEnd_time_of());
                ps.setString(8,of.getDescription_of());


                resultado = Sql.ejecuta(ps);
            
                    if(resultado==true){                
                        ps.close();
                        conn.close();
                        resultado = true;
                        System.out.println("DAOOfferCreate: Success");
                    }else{
                        resultado = false;
                        System.out.println("DAOOfferCreate: Failed");
                    }  
            }
        } catch (Exception e) {
            System.out.println("DAOOfferCreate: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public List<Offer> DAOOfferListById(int id){
    List<Offer> list = new ArrayList<>();
    Connection conn = null;
    try {
        conn = Conexion.getConnection();
        String sql = "SELECT * FROM offer WHERE id_person = ?";            
        PreparedStatement ps = conn.prepareStatement(sql);   
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Offer of = new Offer(rs.getInt(1), rs.getInt(2),
            rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
            rs.getString(7), rs.getString(8), rs.getString(9));
            list.add(of);
         }

        if(list.size()>0) {                           
            ps.close();
            conn.close();                
            System.out.println("DAOOfferListById: Success");
        }else{
            list = null;
            System.out.println("DAOOfferListById: Failed");
        }  

    } catch (Exception e) {
        list = null;
        System.out.println("DAOOfferListById: Failed "+e.getMessage());            
        } 

    return list;
    }
    
    public List<Offer> DAOOfferList(){
        List<Offer> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM offer";            
            PreparedStatement ps = conn.prepareStatement(sql);                                   
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Offer of = new Offer(rs.getInt(1), rs.getInt(2),
                rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
                rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(of);
             }
            if(list.size()>0){                
                ps.close();
                conn.close();                
                System.out.println("DAOOfferList: Success");
            }else{
                list = null;
                System.out.println("DAOOfferList: Failed");
            }            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOOfferList: Failed "+e.getMessage());            
        }        
        return list;
    }
    
    public List<Offer> DAOOfferListByIdOffer(int id){
    List<Offer> list = new ArrayList<>();
    Connection conn = null;
    try {
        conn = Conexion.getConnection();
        String sql = "SELECT * FROM offer WHERE id_offer = ?";            
        PreparedStatement ps = conn.prepareStatement(sql);   
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Offer of = new Offer(rs.getInt(1), rs.getInt(2),
            rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
            rs.getString(7), rs.getString(8), rs.getString(9));
            list.add(of);
         }

        if(list.size()>0) {                           
            ps.close();
            conn.close();                
            System.out.println("DAOOfferListByIdOffer: Success");
        }else{
            list = null;
            System.out.println("DAOOfferListByIdOffer: Failed");
        }  

    } catch (Exception e) {
        list = null;
        System.out.println("DAOOfferListByIdOffer: Failed "+e.getMessage());            
        } 

    return list;
    }
    
    public boolean DAOOfferDeleteById(int id){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "DELETE FROM offer WHERE id_offer=?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1,id);
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOOfferDeleteById: Success");
            }else{
                resultado = false;
                System.out.println("DAOOfferDeleteById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOOfferDeleteById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public Offer DAOOfferList(int id){
        Offer of = null;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM offer WHERE id_offer = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                of = new Offer (rs.getInt(1),rs.getInt(2),
                rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8),
                rs.getString(9));}
            ps.close();
            rs.close();
            conn.close();               
            System.out.println("DAOOfferList: Success");                      
        } catch (Exception e) {            
            System.out.println("DAOOfferList: Failed "+e.getMessage());            
        }
              return of;
    }
    
    public boolean DAOOfferUpdateById(Offer of){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "UPDATE offer "+ 
                         "SET id_ev=?, id_person=?, title_of=?, dia_inicio=?, dia_fin=?, start_time_of=?, end_time_of=?, description_of=? " +
                         "WHERE id_offer=?";
            PreparedStatement ps = conn.prepareStatement(sql);  
            ps.setInt(1,of.getId_ev());
            ps.setInt(2,of.getId_person());
            ps.setString(3,of.getTitle_of());
            ps.setString(4,of.getDia_inicio());
            ps.setString(5,of.getDia_fin());
            ps.setString(6, of.getStart_time_of());
            ps.setString(7,of.getEnd_time_of());
            ps.setString(8,of.getDescription_of());
            ps.setInt(9, of.getId_offer());
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOOfferUpdateById: Success");
            }else{
                resultado = false;
                System.out.println("DAOOfferUpdateById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOOfferUpdateById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
}
