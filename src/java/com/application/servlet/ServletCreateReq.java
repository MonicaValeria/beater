/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.servlet;

import com.application.bean.Offer;
import com.application.bean.Requirement;
import com.application.dao.DAOOffer;
import com.application.dao.DAORequirements;
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
public class ServletCreateReq extends HttpServlet {

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
            String id_of = request.getParameter("id_of");
            String des_req = request.getParameter("des_req");
            String destino = "";
            try {
                DAORequirements rdao = new DAORequirements();
                Requirement req = new Requirement(Integer.parseInt(id_of), des_req);
                boolean ResultReg = rdao.DAOReqCreate(req);
            
                if(ResultReg==true){
                    System.err.println("ServletCreateOffer Success");
                    destino = "panel_ofertas.jsp";
                }else{
                    System.err.println("ServletCreateOffer Failed");
                    System.out.println("la oferta ya existe");                
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
