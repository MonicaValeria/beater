/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.bean.Person;
import com.application.dao.DAOPerson;
import com.application.sql.Alert;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Monica
 */
public class ServletLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //espaniol
        PrintWriter out = response.getWriter(); //
        String user     = request.getParameter("user");
        String pass     = request.getParameter("pass");
        
        String destino = "";
        
        try {
            DAOPerson pdao = new DAOPerson();            
            Person log = pdao.DAOPersonLogin(user,pass);   
            int id = log.getId();  
            user = log.getUser();
            String nombre =log.getName();
            String ape =log.getLastName();
            String des =log.getDescription();
            pass = log.getPassword();
            int type =log.getId_type();
            
            System.out.println(id+" "+user+" "+pass+" "+nombre+" "+ape+" "+des+" "+type);

                    
            
            if(log!=null){
                HttpSession session = request.getSession(true);
                session.setAttribute("id", id); 
                session.setAttribute("user", user);
                session.setAttribute("pass", pass);
                session.setAttribute("nombre", nombre);
                session.setAttribute("ape", ape);
                session.setAttribute("des", des);                       
                session.setAttribute("type", type);
                
                destino = "index.jsp";
            } else {
                destino = "login.jsp";
            }
            response.sendRedirect(destino);
            
        } catch (Exception e) {
            System.out.println("ServletLogin Error: "+e.getMessage());
            //SWAL ALERT
            Alert alert = new Alert();
            String titulo = "¡ERROR!";
            String msg = "Por favor verifique sus credenciales de acceso.";
            String tipo = "error";   // "error" "success" "warning" and "info".
            
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");            
            rd.include(request, response);
            out.print(alert.AlertError(titulo,msg,tipo)); //
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
