/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.bean.Event;
import com.application.bean.Offer;
import com.application.dao.DAOEvent;
import com.application.dao.DAOOffer;
import com.application.sql.Alert;
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
public class ServletCreateOffer extends HttpServlet {

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
        
        
        String id_ev     = request.getParameter("id_ev"); 
        String id     = request.getParameter("id");  
        String nom_of      = request.getParameter("nom_of");
        String dia_ini_of = request.getParameter("dia_ini_of");
        String dia_fin_of = request.getParameter("dia_fin_of");
        String hora_ini_of        = request.getParameter("hora_ini_of");
        String hora_fin_of     = request.getParameter("hora_fin_of");
        String pago     = request.getParameter("pago");

    
        System.out.println(id_ev +" "+ id +" "+ nom_of +" "+dia_ini_of+" "+dia_fin_of+" "+hora_ini_of+" "+hora_fin_of+" "+pago);
        String destino = "";
        Alert alert = null;
        String titulo = null;
        String msg = null;
        String tipo = null;
        
        try {
            DAOOffer ofdao = new DAOOffer();
            Offer of = new Offer(Integer.parseInt(id_ev), Integer.parseInt(id), nom_of, dia_ini_of,
                    dia_fin_of, hora_ini_of, hora_fin_of, pago);
            boolean ResultReg = ofdao.DAOOfferCreate(of);
            
            if(ResultReg==true){
                System.err.println("ServletCreateOffer Success");
                destino = "panel_ofertas.jsp";
            }else{
                System.err.println("ServletCreateOffer Failed");
                System.out.println("la oferta ya existe");
                //SWAL ALERT
                alert = new Alert();
                titulo = "¡ERROR!";
                msg = "La oferta ya existe";
                tipo = "error";   // "error" "success" "warning" and "info".   // 
                destino = "panel_ofertas.jsp";
            }
            
            response.sendRedirect(destino);
                
        } catch (Exception e) {
            System.out.println("ServletCreateOffer Failed "+e.getMessage());
            destino = "panel_ofertas.jsp";
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
