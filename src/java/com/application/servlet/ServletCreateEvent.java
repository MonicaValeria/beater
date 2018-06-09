/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.bean.Event;

import com.application.dao.DAOEvent;
import com.application.sql.Alert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Monica
 */
@WebServlet(name = "ServletCreateEvent", urlPatterns = {"/ServletCreateEvent"})
public class ServletCreateEvent extends HttpServlet {

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
        response.setContentType("text/html");  

        response.setContentType("text/html;charset=UTF-8"); //espaniol
        PrintWriter out = response.getWriter();
        
        String id     = request.getParameter("id");        
        String nom_ev      = request.getParameter("nom_ev");
        String dia_ini_ev = request.getParameter("dia_ini_ev");
        String dia_fin_ev = request.getParameter("dia_fin_ev");
        String hora_ini_ev        = request.getParameter("hora_ini_ev");
        String hora_fin_ev     = request.getParameter("hora_fin_ev");
        String id_local     = request.getParameter("id_local");
        String id_gm     = request.getParameter("id_gm");
    
        System.out.println(id +" "+ nom_ev +" "+ dia_ini_ev +" "+dia_fin_ev+" "+hora_ini_ev+" "+hora_fin_ev+" "+id_local+" "+id_gm);
        String destino = "";
        Alert alert = null;
        String titulo = null;
        String msg = null;
        String tipo = null;
        
        try {
            DAOEvent edao = new DAOEvent();
            Event ev = new Event(Integer.parseInt(id), nom_ev, dia_ini_ev, dia_fin_ev,
                    hora_ini_ev, hora_fin_ev,Integer.parseInt(id_local),Integer.parseInt(id_gm));
            boolean ResultReg = edao.DAOEventCreate(ev);
            
            if(ResultReg==true){
                System.err.println("ServletCreateEvent Success");
                destino = "panel_eventos.jsp";
            }else{
                System.err.println("ServletCreateEvent Failed");
                System.out.println("el evento ya existe");
                //SWAL ALERT
                alert = new Alert();
                titulo = "¡ERROR!";
                msg = "El evento ya existe";
                tipo = "error";   // "error" "success" "warning" and "info".   // 
                destino = "panel_eventos.jsp";
            }
            
            response.sendRedirect(destino);
                
        } catch (Exception e) {
            System.out.println("ServletCreateEvent Failed "+e.getMessage());
            destino = "panel_eventos.jsp";
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
