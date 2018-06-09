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

/**
 *
 * @author Monica
 */
public class ServletRegistro extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String user     = request.getParameter("user");
        String pass      = request.getParameter("pass");
        String name      = request.getParameter("name");
        String ape     = request.getParameter("ape");
        String correo    = request.getParameter("correo");
        String type      = request.getParameter("type");

        System.out.println(type);
        
        Alert alert = null;
        String titulo = null;
        String msg = null;
        String tipo = null;
        
        String destino = "";

                try {
                                                             
                     DAOPerson pdao = new DAOPerson();
                     Person per = new Person(user, pass, name, ape, correo, 0, "", Integer.parseInt(type));
                     boolean ResultReg = pdao.DAOPersonCreate(per);

                     if(ResultReg==true){
                         System.err.println("ServletRegistro Success");
                         destino = "login.jsp";
                     }else{
                         System.err.println("ServletRegistro Failed");
                         System.out.println("el usuario ya existe");
                         //SWAL ALERT
                         alert = new Alert();
                         titulo = "¡ERROR!";
                         msg = "Usuario ya existe";
                         tipo = "error";   // "error" "success" "warning" and "info".   // 
                         destino = "registro.jsp";
                     }
                        
                     RequestDispatcher rd = request.getRequestDispatcher(destino);            
                     rd.include(request, response);
                     out.print(alert.AlertError(titulo,msg,tipo));

                 } catch (Exception e) {
                     System.out.println("ServletRegistro Failed "+e.getMessage());
                      destino = "login.jsp";
                     response.sendRedirect(destino);    
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
