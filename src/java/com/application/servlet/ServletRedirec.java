/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.bean.Local;

import com.application.dao.DAOLocal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Monica
 */
public class ServletRedirec extends HttpServlet {

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
        
        int id_local     = Integer.parseInt(request.getParameter("id_local"));
        int id; 
        String nom_local = "";
        String direc  = "";
        String ref = "";
        String  telf = "";
        String hora_ini = "";
        String hora_fin = "";
        String destino = "";
        try {
            DAOLocal lodao = new DAOLocal();           
            Local lo = new Local();            
            if (id_local > 0){                
                lo = lodao.DAOLocalList(id_local);
                

                id_local = lo.getId_local();
                id = lo.getId_person();
                nom_local = lo.getName_local();
                direc = lo.getAddress();
                ref = lo.getReference();
                telf = lo.getTelefono();
                hora_ini = lo.getHorario_inicio();
                hora_fin = lo.getHorario_fin();
                System.out.println(id_local+" "+id+" "+nom_local+" "+direc+" "+ref+" "+telf+" "+hora_ini+" "+hora_fin);
                
                if(lo!=null){
                    HttpSession session = request.getSession(true);

                    session.setAttribute("id_local", id_local);
                    session.setAttribute("id", id);
                    session.setAttribute("nom_local", nom_local);
                    session.setAttribute("direc", direc);
                    session.setAttribute("ref", ref);
                    session.setAttribute("telf", telf);
                    session.setAttribute("hora_ini", hora_ini);
                    session.setAttribute("hora_fin", hora_fin);
                    System.out.println(id_local+" "+id+" "+nom_local+" "+direc+" "+ref+" "+telf+" "+hora_ini+" "+hora_fin);
                    destino = "editar_local.jsp";
                } else {
                    destino = "panel_locales.jsp";
                }
                response.sendRedirect(destino);             
            }      
            
            
        } catch (Exception e) {
            System.out.println("ServletRedirec Failed "+e.getMessage());
            destino = "panel_locales.jsp";
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
