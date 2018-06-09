/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.bean.Local;
import com.application.dao.DAOLocal;
import com.application.sql.Alert;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Monica
 */
@WebServlet(name = "ServletCreateLocal", urlPatterns = {"/ServletCreateLocal"})
public class ServletCreateLocal extends HttpServlet {

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
        String id = request.getParameter("id");
        String nom_lo  = request.getParameter("nom_lo");
        String add     = request.getParameter("add");
        String ref     = request.getParameter("ref");
        String telf     = request.getParameter("telf");
        String checkbox [] = request.getParameterValues("dias"); 
        String hora_inicio     = request.getParameter("hora_inicio");
        String hora_fin     = request.getParameter("hora_fin");
        String dias = "";
        
        for (int i =0; checkbox.length>i; i++) {
            dias = dias+checkbox[i]+", ";
        }
        
        System.out.println(id +" "+ nom_lo +" "+ add +" "+ref+" "+telf+" "+hora_inicio+" "+hora_fin+" "+dias);
        
        Alert alert = null;
        String titulo = null;
        String msg = null;
        String tipo = null;
        
        String destino = "";
        
        
        try {
            DAOLocal lodao = new DAOLocal();
            Local loc = new Local(Integer.parseInt(id),nom_lo,add,ref,telf,dias,hora_inicio,hora_fin);
            boolean ResultReg = lodao.DAOLocalCreate(loc);
            
            if(ResultReg==true){
                System.out.println("ServletCreateLocal Success. Id_persona:"+id);
                destino = "panel_locales.jsp";
            }else{
                System.out.println("ServletCreateLocal Failed");
                //SWAL ALERT
                alert = new Alert();
                titulo = "¡ERROR!";
                msg = "Nombre de local ya existe";
                tipo = "error";   // "error" "success" "warning" and "info".   // 
                destino = "panel_locales.jsp";
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(destino);            
            rd.include(request, response);
            out.print(alert.AlertError(titulo,msg,tipo));
                   
        } catch (Exception e) {
            System.out.println("ServletCreateEvent Failed "+e.getMessage());
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
