/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Base_Datos_AsigE;

import Modelo.Datos_Basico_AsigE;

import java.io.IOException;
import java.io.PrintWriter;
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
public class Eliminar_AsignarEstudiante extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String boton = request.getParameter("Boton");
            String idestudiaidencia = request.getParameter("IdResidencia");
            String idestudi = request.getParameter("IdEstudiante");
            String idhabit = request.getParameter("IdHabitacion");

            Base_Datos_AsigE bd = new Base_Datos_AsigE();

            ArrayList<Object> at = new ArrayList();
            int s = 2;

            if (boton.equals("Cargar")) {

                bd.conectar();

                Datos_Basico_AsigE dos = bd.buscar(Integer.valueOf(idestudiaidencia), Integer.valueOf(idestudi), Integer.valueOf(idhabit));
                bd.obj = dos;
                bd.desconectar();
                if (dos.getId_Asignar_Habitacion() != 0) {
                    String a = "";
                    a = a + "            <tr>\n"
                            + "              <td style=width: 130px;>" + "Id: " + dos.getId_Asignar_Habitacion() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Id Estudiante: " + dos.getId_Estudiante() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Id Habitacion: " + dos.getId_Habitacion() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Fecha de inicio: " + dos.getFecha_Asignacion() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Fecha de finalizacion: " + dos.getFecha_Final_Asignacion() + "<br>\n"
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
                            + "<form method=\"post\" action=\"Eliminar_AsignarEstudiante\"\n"
                            + " name=\"Eliminar_AsignarEstudiante\">\n"
                            + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                            + " cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "    <tbody>\n"
                            + "      <tr>\n"
                            + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                            + " src=\"./Imagenes/Img_Eliminar.jpg\" alt=\"\"></td>\n"
                            + "      </tr>\n"
                            + "<tr>\n"
                            + "        <td>IdResidencia: <input name=\"IdResidencia\"> IdEstudiante: <input name=\"IdEstudiante\">IdHabitacion: <input name=\"IdHabitacion\"> </td>\n"
                            + "      </tr>"
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
                            + "      <tr>\n"
                            + "        <td>Id Estudiante (Confirmar):<input name=\"idestudia\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>Id Habitacion (Confirmar):<input name=\"idhabitad\"></td>\n"
                            + "      </tr>\n"
                                  + "      <tr align=\"center\">\n"
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
                            + "              <td style=width: 130px;>" + "Id: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Id Estudiante: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Id Habitacion: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Fecha de inicio: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Fecha de finalizacion: " + "?" + "<br>\n"
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
                            + "<form method=\"post\" action=\"Eliminar_AsignarEstudiante\"\n"
                            + " name=\"Eliminar_AsignarEstudiante\">\n"
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

                String idaseos = request.getParameter("id");
                String idestudiaidencias = request.getParameter("idestudia");
                String compania_aseo = request.getParameter("idhabitad");
                

                System.out.println("");
                bd.conectar();
               
                s = bd.eliminar(Integer.valueOf(idaseos), Integer.valueOf(idestudiaidencias), Integer.valueOf(compania_aseo));
                bd.desconectar();

            }

            if (s == 1) {
                response.sendRedirect("Home.html");
            } else if (s == 0) {
                String a = "";
                a = a + "            <tr>\n"
                        + "    <tr>\n"
                        + "        <td>IdResidencia: <input name=\"IdResidencia\"> IdAsigE: <input name=\"IdAsigE\"> </td>\n"
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
                        + "<form method=\"post\" action=\"Eliminar_AsignarEstudiante\"\n"
                        + " name=\"Eliminar_AsignarEstudiante\">\n"
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
            Logger.getLogger(Eliminar_AsignarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Eliminar_AsignarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
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
