/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.bean.Event;
import com.application.bean.Local;
import com.application.dao.DAOEvent;
import com.application.dao.DAOLocal;
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
public class ServletUpdateEventById extends HttpServlet {

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
   
        int  id_ev =  Integer.parseInt(request.getParameter("id_ev"));
        int  id =  Integer.parseInt(request.getParameter("id"));
        String nom_ev = (String) request.getParameter("nom_ev");
        String dia_ini_ev = (String) request.getParameter("dia_ini_ev");
        String dia_fin_ev = (String) request.getParameter("dia_fin_ev");
        String hora_ini_ev = (String) request.getParameter("hora_ini_ev");
        String hora_fin_ev = (String) request.getParameter("hora_fin_ev");
        int  id_local =  Integer.parseInt(request.getParameter("id_local"));
        int  id_gm =  Integer.parseInt(request.getParameter("id_gm"));
       
        
        
        
        System.out.println("editar, id evento: "+id_ev);
        
        String destino = "";
        
        try {
            DAOEvent edao = new DAOEvent();            
            Event ev = new Event(id_ev, id, nom_ev, dia_ini_ev, dia_fin_ev, hora_ini_ev, hora_fin_ev, id_local, id_gm);            
            boolean ResultReg = edao.DAOEventUpdateById(ev);                                            
           
            if (ResultReg == true){
                ev = edao.DAOEventList(id_ev);  
                
                id_ev = ev.getId_ev();
                id= ev.getId_person();
                nom_ev = ev.getName_ev();
                dia_ini_ev = ev.getDia_inicio();
                dia_fin_ev = ev.getDia_fin();
                hora_ini_ev = ev.getHora_inicio_ev();
                hora_fin_ev = ev.getHora_fin_ev();
                id_local = ev.getId_local();
                id_gm = ev.getId_gm();
                System.out.println(id_ev+" "+id+" "+nom_ev+" "+dia_ini_ev+" "+dia_fin_ev+" "+hora_ini_ev+" "+
                        " "+hora_fin_ev+" "+id_local+" "+id_gm);
                
                if(ev!=null){
                    HttpSession session = request.getSession(true);
                    
                    session.setAttribute("id_ev", id_ev);
                    session.setAttribute("id", id);
                    session.setAttribute("nom_ev", nom_ev);
                    session.setAttribute("dia_ini_ev", dia_ini_ev);
                    session.setAttribute("dia_fin_ev", dia_fin_ev);
                    session.setAttribute("hora_ini_ev", hora_ini_ev);
                    session.setAttribute("hora_fin_ev", hora_fin_ev);
                    session.setAttribute("id_local", id_local);
                    session.setAttribute("id_gm", id_gm);
                    System.out.println(id_ev+" "+id+" "+nom_ev+" "+dia_ini_ev+" "+dia_fin_ev+" "+hora_ini_ev+" "+
                        " "+hora_fin_ev+" "+id_local+" "+id_gm);
                    destino = "panel_eventos.jsp";
                } else {
                    destino = "editar_evento.jsp";
                }
                response.sendRedirect(destino);
                
            }         
       
        } catch (Exception e) {
            System.out.println("ServletUpdateLocalById Error: "+e.getMessage());
            destino = "editar_evento.jsp";
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
