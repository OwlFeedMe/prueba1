/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Base_Datos_Estudiantes;
import Modelo.Datos_Basico_Estudiante;
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
public class Estudiantes extends HttpServlet {
Base_Datos_Estudiantes bd=new Base_Datos_Estudiantes();
            Datos_Basico_Estudiante db;
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
           
            String idestudiante=request.getParameter("IdEstudiante");
            String nombre=request.getParameter("Nombre");
            String idhabi=request.getParameter("IdHabitacion");
            String edad=request.getParameter("Edad");
            String telefono=request.getParameter("Telefono");
            String carrera=request.getParameter("Carrera");
            String universidad=request.getParameter("Universidad");
          
            if (idestudiante !=null && !idestudiante.equalsIgnoreCase("")
                    && nombre !=null && !nombre.equalsIgnoreCase("")
                    && edad !=null && !edad.equalsIgnoreCase("")
                    && telefono !=null && !telefono.equalsIgnoreCase("")
                    && carrera !=null && !carrera.equalsIgnoreCase("")
                    && universidad !=null && !universidad.equalsIgnoreCase("")) {
                bd.conectar();
                bd.agregar(Integer.valueOf(idestudiante), Integer.valueOf(idhabi), nombre, Integer.valueOf(edad), Integer.valueOf(telefono), carrera, universidad);
                bd.desconectar();
                
                response.sendRedirect("Home.html");
                
            }else{
                
                response.sendRedirect("Estudiantes.html");
                
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
        Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
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
