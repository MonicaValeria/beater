/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.dao;



import com.application.bean.MusicGenre;
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
public class DAOMusicGenre {
    
     public boolean DAOMGCreate(MusicGenre mg){
        boolean resultado = false;
        Connection conn = null;
        try {
            
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM music_genre WHERE id_person=? and nombre_mg =? ";
            PreparedStatement ps = conn.prepareStatement(sql);    
            ps.setInt(1, mg.getId_person());
            ps.setString(2,mg.getName_mg());
            ps.close();
            conn.close();
            resultado = Sql.ejecuta(ps);
            System.out.println("DAOMGCreate: Success");
            if (resultado==false){
                
            
            conn = Conexion.getConnection();
            sql = "INSERT INTO music_genre (id_person, nombre_mg, artista_ref_mg, detalle_mg) VALUES (?,?,?,?);";
            ps = conn.prepareStatement(sql);            
            ps.setInt(1,mg.getId_person());
            ps.setString(2,mg.getName_mg());
            ps.setString(3,mg.getArtist_ref());
            ps.setString(4,mg.getDetail_mg());
                                               
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOMGCreate: Success");
            }else{
                resultado = false;
                System.out.println("DAOMGCreate: Failed");
            }
            }
        } catch (Exception e) {
            System.out.println("DAOMGCreate: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
        
     public List<MusicGenre> DAOMusicGenreList(){
        List<MusicGenre> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM music_genre";            
            PreparedStatement ps = conn.prepareStatement(sql);                                   
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                MusicGenre gm = new MusicGenre(rs.getInt(1),rs.getInt(2),
                rs.getString(3),rs.getString(4),rs.getString(5));
                list.add(gm);
             }
            if(list.size()>0){                
                ps.close();
                conn.close();                
                System.out.println("DAOMusicGenreList: Success");
            }else{
                list = null;
                System.out.println("DAOMusicGenreList: Failed");
            }            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOMusicGenreList: Failed "+e.getMessage());            
        }        
        return list;
    }    
     
     public List<MusicGenre> DAOMusicGenreListById(int id){
        List<MusicGenre> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM music_genre WHERE id_person = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                MusicGenre gm = new MusicGenre(rs.getInt(1),rs.getInt(2),
                rs.getString(3),rs.getString(4),rs.getString(5));
                list.add(gm);
             }
            if(list.size()>0){                
                ps.close();
                conn.close();                
                System.out.println("DAOMusicGenreListById: Success");
            }else{
                list = null;
                System.out.println("DAOMusicGenreListById: Failed");
            }            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOMusicGenreListById: Failed "+e.getMessage());            
        }        
        return list;
    }
     
     public List<MusicGenre> DAOMusicGenreListByIdMG (int id){
        List<MusicGenre> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM music_genre WHERE id_mg = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                MusicGenre gm = new MusicGenre(rs.getInt(1),rs.getInt(2),
                rs.getString(3),rs.getString(4),rs.getString(5));
                list.add(gm);
             }
            
            
            if(list.size()>0) {                           
                ps.close();
                conn.close();                
                System.out.println("DAOMusicGenreListByIdMG: Success");
            }else{
                list = null;
                System.out.println("DAOMusicGenreListByIdMG: Failed");
            }  
            
            
            
        } catch (Exception e) {
            list = null;
            System.out.println("DAOMusicGenreListByIdMG: Failed "+e.getMessage());            
        } 
        
        
        return list;
        }
     
     public boolean DAOMusicGenreDeleteById(int id){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "DELETE FROM music_genre WHERE id_mg=?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1,id);
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOMusicGenreDeleteById: Success");
            }else{
                resultado = false;
                System.out.println("DAOMusicGenreDeleteById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOMusicGenreDeleteById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
     
     public MusicGenre DAOMusicGenreList(int id){
        MusicGenre gm = null;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM music_genre WHERE id_mg = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                gm = new MusicGenre(rs.getInt(1),rs.getInt(2),
                rs.getString(3),rs.getString(4),rs.getString(5));  }
            ps.close();
            rs.close();
            conn.close();               
            System.out.println("DAOMusicGenreList: Success");                      
        } catch (Exception e) {            
            System.out.println("DAOMusicGenreList: Failed "+e.getMessage());            
        }
              return gm;
    }
     
     public boolean DAOMGUpdateById(MusicGenre mg){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "UPDATE music_genre "+ 
                         "SET id_person =?, nombre_mg=?, artista_ref_mg=?, detalle_mg=? WHERE id_mg=?";
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setInt(1, mg.getId_person());
            ps.setString(2,mg.getName_mg());
            ps.setString(3,mg.getArtist_ref());
            ps.setString(4,mg.getDetail_mg());
            ps.setInt(5, mg.getId_mg());
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOMGUpdateById: Success");
            }else{
                resultado = false;
                System.out.println("DAOMGUpdateById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOMGUpdateById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
}
