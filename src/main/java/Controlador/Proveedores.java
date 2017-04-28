/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Base_Datos_Proveedor;
import Modelo.*;
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
public class Proveedores extends HttpServlet {

    Base_Datos_Proveedor bd = new Base_Datos_Proveedor();

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
        int s = 2;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            //Guardando los valores en variables  
            String idproveedor = request.getParameter("IdProveedor");
            String nombre = request.getParameter("Nombre");
            String tipo_proveedor = request.getParameter("TipoProveedor");
            String telefono = request.getParameter("Telefono");

            //asegurando que los datos sea rellenados
            if (idproveedor != null && !idproveedor.equalsIgnoreCase("")
                    && nombre != null && !nombre.equalsIgnoreCase("")
                    && tipo_proveedor != null && !tipo_proveedor.equalsIgnoreCase("")
                    && telefono != null && !telefono.equalsIgnoreCase("")) {

                bd.conectar();
                s = bd.agregar(Integer.valueOf(idproveedor), nombre, tipo_proveedor, Integer.valueOf(telefono));
                bd.desconectar();

            } else {
                response.sendRedirect("Proveedor.html");
            }
            if (s == 1) {
                response.sendRedirect("Home.html");
            } else if (s == 0) {

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
                        + "<form method=\"post\" action=\"Proveedores\"\n"
                        + " name=\"Proveedores\">\n"
                        + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                        + " cellpadding=\"2\" cellspacing=\"2\">\n"
                        + "    <tbody>\n"
                        + "      <tr>\n"
                        + "        <td><img style=\"width: 488px; height: 278px;\"\n"
                        + " src=\"./Imagenes/Img_Proveedores.png\"\n"
                        + " alt=\"\"></td>\n"
                        + "      </tr>\n"
                        + "      <tr>\n"
                        + "        <td>Id duplicado, no se realizo el registro</td>\n"
                        + "      </tr>\n"
                        + "      <tr>\n"
                        + "        <td>IdProveedor:<input name=\"IdProveedor\"></td>\n"
                        + "      </tr>\n"
                        + "      <tr>\n"
                        + "        <td>Nombre:<input name=\"Nombre\"></td>\n"
                        + "      </tr>\n"
                        + "      <tr>\n"
                        + "        <td>Tipo de Proveedor:<input name=\"TipoProveedor\"></td>\n"
                        + "      </tr>\n"
                        + "      <tr>\n"
                        + "        <td>Telefono:<input name=\"Telefono\"></td>\n"
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
                        + "</html>");

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
