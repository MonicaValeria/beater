/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.bean.Person;
import com.application.dao.DAOPerson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Monica
 */
public class ServletUpdatePerson extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        int  id =       Integer.parseInt(request.getParameter("id"));
        String user     = request.getParameter("user");
        String pass     = request.getParameter("pass");
        String nombre   = request.getParameter("nombre");
        String ape     = request.getParameter("ape");
        String correo    = request.getParameter("correo");
        String des  = request.getParameter("des");
        int  type = Integer.parseInt(request.getParameter("type"));
        System.out.println(id+" "+user+" "+pass+" "+nombre+" "+ape+" "+correo+" "+des+" "+type);
        String destino = "";
        
        try {
            DAOPerson pdao = new DAOPerson();            
            Person per = new Person(id, user, pass, nombre, ape, correo, 0, des, type);            
            boolean ResultReg = pdao.DAOPersonUpdateById(per);                                            
           
            if (ResultReg == true){
                per = pdao.DAOPersonListById(id);
                
                id = per.getId();
                user = per.getUser();
                pass = per.getPassword();
                nombre = per.getName();
                ape = per.getLastName();
                correo = per.getCorreo();
                des = per.getDescription();
                System.out.println(id+" "+user+" "+pass+" "+nombre+" "+ape+" "+correo+" "+des+" "+type);
                
                if(per!=null){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", user);
                    session.setAttribute("id", id);
                    session.setAttribute("nombre", nombre);
                    session.setAttribute("ape", ape);
                    session.setAttribute("pass", pass);
                    session.setAttribute("correo", correo);
                    session.setAttribute("des", des);
                    session.setAttribute("type", type);
                    System.out.println(id+" "+user+" "+pass+" "+nombre+" "+ape+" "+correo+" "+des+" "+type);
                    destino = "index.jsp";
                } else {
                    destino = "index.jsp";
                }
                response.sendRedirect(destino);             
            }         
            
        } catch (Exception e) {
            System.out.println("ServletUpdatePerson Error: "+e.getMessage());
            destino = "index.jsp";
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
