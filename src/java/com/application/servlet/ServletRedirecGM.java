/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.bean.Local;
import com.application.bean.MusicGenre;
import com.application.dao.DAOLocal;
import com.application.dao.DAOMusicGenre;
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
public class ServletRedirecGM extends HttpServlet {

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
                int id_mg     = Integer.parseInt(request.getParameter("id_mg"));
                int id;
                String nom_mg = "";
                String art_ref  = "";
                String det = "";
                String destino = "";
                
                
        try {
            DAOMusicGenre mgdao = new DAOMusicGenre();           
            MusicGenre mg = new MusicGenre();            
            if (id_mg > 0){                
                mg = mgdao.DAOMusicGenreList(id_mg);
                
                id_mg = mg.getId_mg();
                id = mg.getId_person();
                nom_mg = mg.getName_mg();
                art_ref = mg.getArtist_ref();
                det = mg.getDetail_mg();
                
                System.out.println(id_mg+" "+id+" "+nom_mg+" "+art_ref+" "+det);
                
                if(mg!=null){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("id_mg", id_mg);
                    session.setAttribute("id", id);
                    session.setAttribute("nom_mg", nom_mg);
                    session.setAttribute("art_ref", art_ref);
                    session.setAttribute("det", det);
                    System.out.println(id_mg+" "+id+" "+nom_mg+" "+art_ref+" "+det);
                    destino = "editar_musicgenre.jsp";
                } else {
                    destino = "panel_musicgenre.jsp";
                }
                response.sendRedirect(destino);             
            }      
            
            
        } catch (Exception e) {
            System.out.println("ServletRedirecGM Failed "+e.getMessage());
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
