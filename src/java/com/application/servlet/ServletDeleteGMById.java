/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.dao.DAOMusicGenre;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Monica
 */
public class ServletDeleteGMById extends HttpServlet {

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
            
            String id_mg = request.getParameter("id_mg");
            
            System.out.println(id_mg);
            
            String destino = "";
        
                try {
                    DAOMusicGenre mdao = new DAOMusicGenre();                  
                    boolean ResultReg = mdao.DAOMusicGenreDeleteById(Integer.parseInt(id_mg));

                    if(ResultReg==true){
                        System.out.println("ServletDeleteGMById Success"+id_mg);
                        destino = "panel_musicgenre.jsp";
                    }else{
                        System.out.println("ServletDeleteGMById Failed");
                        destino = "panel_musicgenre.jsp";
                    }

                    response.sendRedirect(destino);

                } catch (Exception e) {
                    System.out.println("ServletDeleteGMById Failed "+e.getMessage());
                    destino = "panel_musicgenre.jsp";
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
