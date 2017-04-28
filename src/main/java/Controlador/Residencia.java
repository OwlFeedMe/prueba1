/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Base_Datos_Residencia;

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
public class Residencia extends HttpServlet {
Base_Datos_Residencia bd=new Base_Datos_Residencia();
          
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

            String idaseo = request.getParameter("IdResidencia");
            String propietario = request.getParameter("Propietario");
            String direccion = request.getParameter("Direccion");
            String fecha_inicio_contrato = request.getParameter("FechaInicioContrato");
            String fecha_final_contrato = request.getParameter("FechaFinalContrato");
            String numeroHabitaciones = request.getParameter("NumeroHabitaciones");
            int s = 2;
            if (idaseo != null
                    && propietario != null
                    && direccion != null
                    && fecha_inicio_contrato != null
                    && fecha_final_contrato != null
                    && numeroHabitaciones != null) {
                bd.conectar();
                s = bd.agregar(Integer.valueOf(idaseo), propietario, direccion, java.sql.Date.valueOf(fecha_inicio_contrato), java.sql.Date.valueOf(fecha_final_contrato), Integer.valueOf(numeroHabitaciones));
                bd.desconectar();

            } else {
                response.sendRedirect("Residencia.html");
            }
            if (s == 1) {
                response.sendRedirect("Home.html");
            } else {
                if (s == 0) {
                    response.setContentType("text/html");
                    PrintWriter outs4 = response.getWriter();
                    String docType4
                            = "<!DOCTYPE html PUBLIC -//W3C//DTD HTML 4.01//EN http://www.w3.org/TR/html4/strict.dtd>\n";
                    out.println(docType4
                            + "<html>\n"
                            + "<head>\n"
                            + "  <meta content=\"text/html; charset=ISO-8859-1\"\n"
                            + " http-equiv=\"content-type\">\n"
                            + "  <title></title>\n"
                            + "</head>\n"
                            + "<body>\n"
                            + "<form action=\"Residencia\" name=\"Residencia\" method=\"post\">\n"
                            + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                            + " cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "    <tbody>\n"
                            + "      <tr>\n"
                            + "        <td><img style=\"width: 432px; height: 256px;\"\n"
                            + " src=\"./Imagenes/Img_AsignarResidencia.jpg\"\n"
                            + " alt=\"\"></td>\n"
                            + "      <tr>\n"
                            + "        <td>Id duplicado, no se realizo el registro</td>\n"
                            + "      </tr>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>IdResidencia:<input name=\"IdResidencia\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>IdResidencia:<input name=\"Propietario\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>Compaï¿½ia de Residencia:<input name=\"Direccion\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>Fecha Inicio Contrato:<input\n"
                            + " name=\"FechaInicioContrato\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>Fecha Final Contrato:<input\n"
                            + " name=\"FechaFinalContrato\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>Precio Residencia:<input name=\"NumeroHabitaciones\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr align=\"center\">\n"
                            + "        <td><input name=\"Boton\" value=\"Ok\"\n"
                            + " type=\"submit\"></td>\n"
                            + "      </tr>\n"
                            + "    </tbody>\n"
                            + "  </table>\n"
                            + "  <br>\n"
                            + "</form>\n"
                            + "</body>\n"
                            + "</html>\n"
                            + "");

                }

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
        Logger.getLogger(Residencia.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(Residencia.class.getName()).log(Level.SEVERE, null, ex);
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
