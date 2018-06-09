/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;


import com.application.bean.Local;
import com.application.bean.Postulaciones;
import com.application.dao.DAOPostulaciones;
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
public class ServletPostular extends HttpServlet {

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
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            
            String id_pos = request.getParameter("id_pos");
            String id_of = request.getParameter("id_of");
            
            System.out.println(id_of+" "+id_pos);
            
             String destino = "";
             Alert alert = null;
             String titulo = null;
             String msg = null;
             String tipo = null;
             
        try {
            DAOPostulaciones pdao = new DAOPostulaciones();           
            Postulaciones post = new Postulaciones(Integer.parseInt(id_pos),Integer.parseInt(id_of));
            boolean ResultReg = pdao.DAOPostulacionesCreate(post);
            
            if(ResultReg==true){
                System.err.println("ServletPostular Success");
                //SWAL ALERT
                alert = new Alert();
                titulo = "¡CORRECTO!";
                msg = "Postulo con áxito";
                tipo = "success";   // "error" "success" "warning" and "info".   //                
                destino = "panel_ofertas.jsp";
            }else{
                System.err.println("ServletPostular Failed");
                destino = "panel_ofertas.jsp";
            }         
                        
            RequestDispatcher rd = request.getRequestDispatcher(destino);            
            rd.include(request, response);
            out.print(alert.AlertError(titulo,msg,tipo));
                
        } catch (Exception e) {
            System.out.println("ServletPostular Failed "+e.getMessage());
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
