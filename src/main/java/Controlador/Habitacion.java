/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Base_Datos_Habitacion;
import Modelo.Datos_Basico_Habitacion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class Habitacion extends HttpServlet {
Base_Datos_Habitacion bd=new Base_Datos_Habitacion();
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String idresidencia=request.getParameter("IdResidencia");
            String idhabitacion=request.getParameter("IdHabitacion");
            String numero_camas=request.getParameter("NumeroHabitaciones");
            String valor_habitacion=request.getParameter("ValorHabitacion");
            
            if (idresidencia !=null && !idresidencia.equalsIgnoreCase("")
                    && idhabitacion !=null && !idhabitacion.equalsIgnoreCase("")
                    && numero_camas !=null && !numero_camas.equalsIgnoreCase("")
                    && valor_habitacion !=null && !valor_habitacion.equalsIgnoreCase("")) {
                
                bd.conectar();
                bd.agregar(Integer.valueOf(idhabitacion),Integer.valueOf(idresidencia), Integer.valueOf(numero_camas), Integer.valueOf(valor_habitacion));
               bd.desconectar();
                response.sendRedirect("Home.html");
                
            }else{
                response.sendRedirect("Habitacion.html");
            }
            
            
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
