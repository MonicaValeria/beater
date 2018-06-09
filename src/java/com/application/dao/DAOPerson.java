/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.dao;



import com.application.bean.Person;
import com.application.sql.Conexion;
import com.application.sql.Sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Monica
 */
public class DAOPerson {
    
    public boolean DAOPersonCreate(Person p){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM person WHERE user =?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setString(1,p.getUser());
            ps.close();
            conn.close();
            resultado = Sql.ejecuta(ps);
            
            if (resultado==false){
                conn = Conexion.getConnection();
                sql = "INSERT INTO person (user, password, name, lastName, correo, score, description, id_type) VALUES (?,?,?,?,?,0,'',?);";
                ps = conn.prepareStatement(sql);            
                ps.setString(1,p.getUser());
                ps.setString(2,p.getPassword());
                ps.setString(3,p.getName());
                ps.setString(4,p.getLastName());
                ps.setString(5, p.getCorreo());
                ps.setInt(6,p.getId_type());
                resultado = Sql.ejecuta(ps);

                if(resultado==true){                
                    ps.close();
                    conn.close();
                    resultado = true;
                    System.out.println("DAOPersonCreate: Success");
                }else{
                    resultado = false;
                    System.out.println("DAOPersonCreate: Failed");
                }
            }
                       
        } catch (Exception e) {
            System.out.println("DAOPersonCreate: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public Person DAOPersonLogin(String user, String pass) throws Exception{
        Person p = null;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();            
          
            String sql = "select * from person where user=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                p = new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
            }
            ps.close();
            rs.close();
            conn.close();               
            System.out.println("DAOPersonLogin: Success");
        } catch (SQLException e) {
            System.out.println("DAOPersonLogin: Failed "+e.getMessage());
            e.printStackTrace();
        }
        return p;
    }
    
    public boolean DAOPersonLoginPassword(String de, String clave, String para, String mensaje, String asunto){
        boolean enviado = false;
            try{
            
                String host = "smtp.gmail.com";
                
                Properties prop = System.getProperties();
                
                prop.put("mail.smtp.starttls.enable","true");
                prop.put("mail.smtp.host", host);
                prop.put("mail.smtp.user",de);
                prop.put("mail.smtp.password", clave);
                prop.put("mail.smtp.port",587);
                prop.put("mail.smtp.auth","true");
                
                Session sesion = Session.getDefaultInstance(prop,null);
                
                MimeMessage message = new MimeMessage(sesion);
                
                message.setFrom(new InternetAddress(de));                
                         
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
                
                message.setSubject(asunto);
                message.setText(mensaje);
                
                Transport transport = sesion.getTransport("smtp");
                
                transport.connect(host,de,clave);
                
                transport.sendMessage(message, message.getAllRecipients());
                
                transport.close();
                
                enviado = true;
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
        return enviado;
    }
    
    public boolean DAOPersonUpdateById(Person p){
        boolean resultado = false;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "UPDATE person "+ 
                         "SET user=?, password=?, name=?,lastName=?, correo=?, description=?" +
                         "WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);          
            ps.setString(1,p.getUser());
            ps.setString(2,p.getPassword());
            ps.setString(3,p.getName());
            ps.setString(4,p.getLastName());
            ps.setString(5, p.getCorreo());
            ps.setString(6,p.getDescription());
            ps.setInt(7,p.getId());
            resultado = Sql.ejecuta(ps);
            
            if(resultado==true){                
                ps.close();
                conn.close();
                resultado = true;
                System.out.println("DAOPersonUpdateById: Success");
            }else{
                resultado = false;
                System.out.println("DAOPersonUpdateById: Failed");
            }            
        } catch (Exception e) {
            System.out.println("DAOPersonUpdateById: Failed "+e.getMessage());
            resultado = false;
        }
        return resultado;
    } 
    
    public Person DAOPersonListById(int id){
        Person per = null;
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM person WHERE id = ?";            
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                per = new Person(rs.getInt(1),rs.getString(2),
                rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),0,rs.getString(8),rs.getInt(9));                
             }
            ps.close();
            rs.close();
            conn.close();               
            System.out.println("DAOPersonListById: Success");                      
        } catch (Exception e) {            
            System.out.println("DAOPersonListById: Failed "+e.getMessage());            
        }
        
        return per;
    }
    
}
