/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Base_Datos_AsigE;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class AsignarEstudiantes extends HttpServlet {
    Base_Datos_AsigE bd = new Base_Datos_AsigE();
    
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
            throws ServletException, IOException, URISyntaxException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         
            String idestudiantes=request.getParameter("IdEstudiante");
            String idresidencia=request.getParameter("IdResidencia");
            String idhabitacion=request.getParameter("IdHabitacion");
            String fecha_asignacion=request.getParameter("FechaAsignacion");
            String fecha_final=request.getParameter("FechaFinal");
            
            
            
            if (idestudiantes !=null && !idestudiantes.equalsIgnoreCase("")
                    && idresidencia !=null && !idresidencia.equalsIgnoreCase("")
                    && idhabitacion !=null && !idhabitacion.equalsIgnoreCase("")
                    && fecha_asignacion !=null && !fecha_asignacion.equalsIgnoreCase("")
                    && fecha_final !=null && !fecha_final.equalsIgnoreCase("")) {
              bd.conectar();
                bd.agregar(Integer.valueOf(idresidencia), Integer.valueOf(idestudiantes),Integer.valueOf(idhabitacion), java.sql.Date.valueOf(fecha_asignacion), java.sql.Date.valueOf(fecha_final));
                bd.desconectar();
                response.sendRedirect("Home.html");
                
            }else{
                
                response.sendRedirect("AsignarEstudiantes.html");
                
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
        try {
            processRequest(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AsignarEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AsignarEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
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
