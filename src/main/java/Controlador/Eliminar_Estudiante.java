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
import java.sql.SQLException;
import java.util.ArrayList;
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
public class Eliminar_Estudiante extends HttpServlet {

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
            throws ServletException, IOException, SQLException, URISyntaxException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String boton = request.getParameter("Boton");
    
            String idestu= request.getParameter("Id");

            Base_Datos_Estudiantes bd = new Base_Datos_Estudiantes();

            ArrayList<Object> at = new ArrayList();
            int s = 2;

            if (boton.equals("Cargar")) {

                bd.conectar();

                Datos_Basico_Estudiante dos = bd.buscar(Integer.valueOf(idestu));
                bd.obj = dos;
                bd.desconectar();
                if (dos.getId_Estudiante() != 0) {
                    String a = "";
                    a = a + "            <tr>\n"
                            + "              <td style=width: 130px;>" + "Id: " + dos.getId_Estudiante() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Id habitacion: " + dos.getId_Asignar_Habitacion() + "<br>\n"
                            + "              </td>\n"
               
                            + "              <td style=width: 130px;>" + "Nombre : " + dos.getNombre() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Edad: " + dos.getEdad() + "<br>\n"
                            + "              </td>\n"
                             + "              <td style=width: 130px;>" + "Telefono " + dos.getTelefono() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Carrera: " + dos.getCarrera() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Universidad: " + dos.getUniversidad() + "<br>\n"
                            + "              </td>\n"
                            + "            </tr>\n";

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
                            + "<form method=\"post\" action=\"Eliminar_Estudiante\"\n"
                            + " name=\"Eliminar_Estudiante\">\n"
                            + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                            + " cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "    <tbody>\n"
                            + "      <tr>\n"
                            + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                            + " src=\"./Imagenes/Img_Eliminar.jpg\" alt=\"\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr align=\"center\">\n"
                            + "        <td><input name=\"Boton\" value=\"Cargar\"\n"
                            + " type=\"submit\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>\n"
                            + "        <table style=\"text-align: left; width: 484px; height: 32px;\"\n"
                            + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "          <tbody>\n"
                            + a
                            + "          </tbody>\n"
                            + "        </table>\n"
                            + "        </td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>Id (Confirmar):<input name=\"id\"></td>\n"
                            + "      </tr>\n"
                           
                            + "      </tr>" + "      <tr align=\"center\">\n"
                            + "        <td><input name=\"Boton\" value=\"Eliminar\"\n"
                            + " type=\"submit\"></td>\n"
                            + "    </tbody>\n"
                            + "  </table>\n"
                            + "  <br>\n"
                            + "</form>\n"
                            + "</body>\n"
                            + "</html>");
                } else {
                    String a = "";
                    a = a + "            <tr>\n"
                            + "    <tr>\n"
                            + "        <td>IdEstudiantes: <input name=\"Id\"> </td>\n"
                            + "      </tr>" + "              <td style=width: 130px;>" + "Id: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Id Habitacion: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Nombre: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Edad: " + "?" + "<br>\n"
                            + "              </td>\n"
                              + "              <td style=width: 130px;>" + "telefono: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Carrera: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Universidad: $" + "?" + "<br>\n"
                            + "              </td>\n"
                            + "            </tr>\n";

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
                            + "<form method=\"post\" action=\"Eliminar_Estudiante\"\n"
                            + " name=\"Eliminar_Estudiante\">\n"
                            + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                            + " cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "    <tbody>\n"
                            + "      <tr>\n"
                            + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                            + " src=\"./Imagenes/Img_Eliminar.jpg\" alt=\"\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr align=\"center\">\n"
                            + "        <td><input name=\"Boton\" value=\"Cargar\"\n"
                            + " type=\"submit\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>\n"
                            + "        <table style=\"text-align: left; width: 484px; height: 32px;\"\n"
                            + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "          <tbody>\n"
                            + a
                            + "          </tbody>\n"
                            + "        </table>\n"
                            + "        </td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "    </tbody>\n"
                            + "  </table>\n"
                            + "  <br>\n"
                            + "</form>\n"
                            + "</body>\n"
                            + "</html>");
                }

            }
            if (boton.equals("Eliminar")) {

                String idestud = request.getParameter("id");
                

                String uni = request.getParameter("universidad");

                bd.conectar();
               
                s = bd.eliminar(Integer.valueOf(idestud));
                bd.desconectar();

            }

            if (s == 1) {
                response.sendRedirect("Home.html");
            } else if (s == 0) {
                String a = "";
                a = a + "            <tr>\n"
                        + "    <tr>\n"
                        + "        <td> IdEstudiantes: <input name=\"Id\"> </td>\n"
                        + "      </tr>"
                        + "              <td style=width: 130px;>" + "Id: " + "?" + "<br>\n"
                        + "              </td>\n"
                        + "              <td style=width: 130px;>" + "IdResidencia: " + "?" + "<br>\n"
                        + "              </td>\n"
                        + "              </td>\n"
                        + "              <td style=width: 130px;>" + "Compañia : " + "?" + "<br>\n"
                        + "              </td>\n"
                        + "              <td style=width: 130px;>" + "Fecha de inicio: " + "?" + "<br>\n"
                        + "              </td>\n"
                        + "              <td style=width: 130px;>" + "Fecha de finalizacion: " + "?" + "<br>\n"
                        + "              </td>\n"
                        + "              <td style=width: 130px;>" + "Valor: $" + "?" + "<br>\n"
                        + "              </td>\n"
                        + "            </tr>\n";

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
                        + "<form method=\"post\" action=\"Eliminar_Estudiante\"\n"
                        + " name=\"Eliminar_Estudiante\">\n"
                        + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                        + " cellpadding=\"2\" cellspacing=\"2\">\n"
                        + "    <tbody>\n"
                        + "      <tr>\n"
                        + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                        + " src=\"./Imagenes/Img_Eliminar.jpg\" alt=\"\"></td>\n"
                        + "      </tr>\n"
                        + "      <tr align=\"center\">\n"
                        + "        <td><input name=\"Boton\" value=\"Cargar\"\n"
                        + " type=\"submit\"></td>\n"
                        + "      </tr>\n"
                        + "      <tr>\n"
                        + "        <td>\n"
                        + "        <table style=\"text-align: left; width: 484px; height: 32px;\"\n"
                        + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                        + "          <tbody>\n"
                        + a
                        + "          </tbody>\n"
                        + "        </table>\n"
                        + "        </td>\n"
                        + "      </tr>\n"
                        + "      <tr>\n"
                        + "        <td></td>\n"
                        + "      </tr>\n"
                        + "      <tr>\n"
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Eliminar_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Eliminar_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(Eliminar_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Eliminar_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
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
