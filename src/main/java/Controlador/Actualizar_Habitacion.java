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
public class Actualizar_Habitacion extends HttpServlet {

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
            String idre = request.getParameter("IdResidencia");
            String idha = request.getParameter("IdHabitacion");

            Base_Datos_Habitacion bd = new Base_Datos_Habitacion();

            Datos_Basico_Habitacion db = new Datos_Basico_Habitacion();
            ArrayList<Object> at = new ArrayList();
            int s = 2;

            if (boton.equals("Cargar")) {

                bd.conectar();

                Datos_Basico_Habitacion dos = bd.buscar(Integer.valueOf(idha),Integer.valueOf(idre));
                bd.obj = dos;
                bd.desconectar();
                if (dos.getId_Habitacion() != 0) {
                    String a = "";
                    a = a + "            <tr>\n"
                            + "              <td style=width: 130px;>" + "Id Habitacion: " + dos.getId_Habitacion() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Id Residencia: " + dos.getId_Residencia()+ "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Numero de Camas: " + dos.getNumero_Camas() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Valor: $ " + dos.getValor_Habitacion() + "<br>\n"
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
                            + "<form method=\"post\" action=\"Actualizar_Habitacion\"\n"
                            + " name=\"Actualizar_Habitacion\">\n"
                            + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                            + " cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "    <tbody>\n"
                            + "      <tr>\n"
                            + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                            + " src=\"./Imagenes/Img_Actualizar.jpg\" alt=\"\"></td>\n"
                            + "      </tr>\n"
                           + "      <tr>\n"
                        + "        <td>IdHabitacion: <input name=\"IdHabitacion\"></td>\n"
                        + "      </tr>\n"
                         + "      <tr>\n"
                        + "        <td>IdResidencia: <input name=\"IdResidencia\"></td>\n"
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
                            + "        <td>Id Habitacion (Confirmar):<input name=\"IdHabitacions\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>Id Residencia (Confirmar):<input name=\"IdResidencias\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>Numero de camas:<input name=\"NumeroC\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>Valor habitacion: $<input name=\"VarlorH\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr align=\"center\">\n"
                            + "        <td><input name=\"Boton\" value=\"Actualizar\"\n"
                            + " type=\"submit\"></td>\n"
                            + "      </tr>\n"
                            + "    </tbody>\n"
                            + "  </table>\n"
                            + "  <br>\n"
                            + "</form>\n"
                            + "</body>\n"
                            + "</html>");
                } else {

                    String a = "";
                    a = a + "            <tr>\n"
                           + "              <td style=width: 130px;>" + "Id Habitacion: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Id Residencia: " +"?"+ "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Numero de Camas: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Valor: $ " + "?" + "<br>\n"
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
                            + "<form method=\"post\" action=\"Actualizar_Habitacion\"\n"
                            + " name=\"Actualizar_Habitacion\">\n"
                            + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                            + " cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "    <tbody>\n"
                            + "      <tr>\n"
                            + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                            + " src=\"./Imagenes/Img_Actualizar.jpg\" alt=\"\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>IdHabitacion: <input name=\"Id\"></td>\n"
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
                            + "    </tbody>\n"
                            + "  </table>\n"
                            + "  <br>\n"
                            + "</form>\n"
                            + "</body>\n"
                            + "</html>");
                }

            }
            if (boton.equals("Actualizar")) {

                String idH = request.getParameter("IdHabitacions");
                String idResi = request.getParameter("IdResidencias");
                String NumeroC = request.getParameter("NumeroC");
                String ValorH = request.getParameter("VarlorH");
                bd.conectar();
                s = bd.actualizar(Integer.valueOf(idH), Integer.valueOf(idResi), Integer.valueOf(NumeroC), Integer.valueOf(ValorH));
                bd.desconectar();
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
                        + "<form method=\"post\" action=\"Actualizar_Habitacion\" name=\"Actualizar_Habitacion\">\n"
                        + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                        + " cellpadding=\"2\" cellspacing=\"2\">\n"
                        + "    <tbody>\n"
                        + "      <tr>\n"
                        + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                        + " src=\"./Imagenes/Img_Actualizar.jpg\"\n"
                        + " alt=\"\"></td>\n"
                        + "      </tr>\n"
                        + "      <tr>\n"
                        + "        <td>Confirmacion incorrecta</td>\n"
                        + "      </tr>\n" 
                        + "      <tr>\n"
                        + "        <td>IdHabitacion: <input name=\"IdHabitacion\"></td>\n"
                        + "      </tr>\n"
                         + "      <tr>\n"
                        + "        <td>IdResidencia: <input name=\"IdResidencia\"></td>\n"
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
                        + "            <tr>\n"
                        
                        + "            </tr>\n"
                        + "          </tbody>\n"
                        + "        </table>\n"
                        + "        </td>\n"
                        + "      </tr>\n"
                        + "      <tr align=\"center\">\n"
                        + "        <td><input name=\"Boton\" value=\"Actualizar\"\n"
                        + " type=\"submit\"></td>\n"
                        + "      </tr>\n"
                        + "    </tbody>\n"
                        + "  </table>\n"
                        + "  <br>\n"
                        + "</form>\n"
                        + "</body>\n"
                        + "</html>"
                );

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
            Logger.getLogger(Actualizar_Habitacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Actualizar_Habitacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Actualizar_Habitacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Actualizar_Habitacion.class.getName()).log(Level.SEVERE, null, ex);
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
