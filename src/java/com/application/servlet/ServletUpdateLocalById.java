/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.bean.Local;
import com.application.dao.DAOLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Monica
 */
@WebServlet(name = "ServletUpdateLocalById", urlPatterns = {"/ServletUpdateLocalById"})
public class ServletUpdateLocalById extends HttpServlet {

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
   
        int  id_local =  Integer.parseInt(request.getParameter("id_local"));
        int  id =  Integer.parseInt(request.getParameter("id"));
        String nom_local = (String) request.getParameter("nom_local");
        String direc = (String) request.getParameter("direc");
        String ref = (String) request.getParameter("ref");
        String telf = (String) request.getParameter("telf");
        String dias = "";
        String checkbox [] = request.getParameterValues("dias"); 
        String hora_inicio = (String) request.getParameter("hora_inicio");
        String hora_fin = (String) request.getParameter("hora_fin");
       
        
        for (int i =0; checkbox.length>i; i++) {
            dias = dias+checkbox[i]+", ";
        }
        
        System.out.println("editar, id local: "+id_local);
        
        String destino = "";
        
        try {
            DAOLocal lodao = new DAOLocal();            
            Local lo = new Local(id_local, id, nom_local, direc, ref, telf, dias, hora_inicio, hora_fin);            
            boolean ResultReg = lodao.DAOLocalUpdateById(lo);                                            
           
            if (ResultReg == true){
                lo = lodao.DAOLocalList(id_local);  
                
                id_local = lo.getId_local();
                id= lo.getId_person();
                nom_local = lo.getName_local();
                direc = lo.getAddress();
                ref = lo.getReference();
                telf = lo.getTelefono();
                dias = lo.getDias();
                hora_inicio = lo.getHorario_inicio();
                hora_fin = lo.getHorario_fin();
                System.out.println(id_local+" "+id+" "+nom_local+" "+direc+" "+ref+" "+telf+" "+
                        " "+dias+" "+hora_inicio+" "+hora_fin);
                
                if(lo!=null){
                    HttpSession session = request.getSession(true);
                    
                    session.setAttribute("id_local", id_local);
                    session.setAttribute("id", id);
                    session.setAttribute("nom_local", nom_local);
                    session.setAttribute("direc", direc);
                    session.setAttribute("ref", ref);
                    session.setAttribute("telf", telf);
                    session.setAttribute("dias", dias);
                    session.setAttribute("hora_inicio", hora_inicio);
                    session.setAttribute("hora_fin", hora_fin);
                    System.out.println(id_local+" "+id+" "+nom_local+" "+direc+" "+ref+" "+telf+" "+dias+" "+hora_inicio+" "+hora_fin);
                    destino = "panel_locales.jsp";
                } else {
                    destino = "editar_local.jsp";
                }
                response.sendRedirect(destino);
                
            }         
       
        } catch (Exception e) {
            System.out.println("ServletUpdateLocalById Error: "+e.getMessage());
            destino = "editar_local.jsp";
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
