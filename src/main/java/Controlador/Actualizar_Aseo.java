/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Base_Datos_Aseo;
import Modelo.Datos_Basico_Aseo;
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
public class Actualizar_Aseo extends HttpServlet {

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
            String idresidencia = request.getParameter("IdResidencia");
            String idaseo = request.getParameter("IdAseo");

            Base_Datos_Aseo bd = new Base_Datos_Aseo();

            ArrayList<Object> at = new ArrayList();
            int s = 2;

            if (boton.equals("Cargar")) {

                bd.conectar();

                Datos_Basico_Aseo dos = bd.buscar(Integer.valueOf(idaseo), Integer.valueOf(idresidencia));
                bd.obj = dos;
                bd.desconectar();
                if (dos.getId() != 0) {
                    String a = "";
                    a = a + "            <tr>\n"
                            + "              <td style=width: 130px;>" + "Id: " + dos.getId() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "IdResidencia: " + dos.getId_re() + "<br>\n"
                            + "              </td>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Compania : " + dos.getCompania_Aseo() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Fecha de inicio: " + dos.getFI() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Fecha de finalizacion: " + dos.getFF() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Valor: $" + dos.getPre() + "<br>\n"
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
                            + "<form method=\"post\" action=\"Actualizar_Aseo\"\n"
                            + " name=\"Actualizar_Aseo\">\n"
                            + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                            + " cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "    <tbody>\n"
                            + "      <tr>\n"
                            + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                            + " src=\"./Imagenes/Img_Actualizar.jpg\" alt=\"\"></td>\n"
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
                            + "      <tr>\n"
                            + "        <td>Id residencia (Confirmar):<input name=\"idres\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>Compania de Aseo:<input name=\"CompaniaAseo\"></td>\n"
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
                            + "        <td>Precio Aseo:<input name=\"PrecioAseo\"></td>\n"
                            + "      </tr>" + "      <tr align=\"center\">\n"
                            + "        <td><input name=\"Boton\" value=\"Actualizar\"\n"
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
                            + "        <td>IdResidencia: <input name=\"IdResidencia\"> IdAseo: <input name=\"IdAseo\"> </td>\n"
                            + "      </tr>" + "              <td style=width: 130px;>" + "Id: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "IdResidencia: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Compania : " + "?" + "<br>\n"
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
                            + "<form method=\"post\" action=\"Actualizar_Aseo\"\n"
                            + " name=\"Actualizar_Aseo\">\n"
                            + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                            + " cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "    <tbody>\n"
                            + "      <tr>\n"
                            + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                            + " src=\"./Imagenes/Img_Actualizar.jpg\" alt=\"\"></td>\n"
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
            if (boton.equals("Actualizar")) {

                String idaseos = request.getParameter("id");
                String idresidencias = request.getParameter("idres");
                String compania_aseo = request.getParameter("CompaniaAseo");
                java.sql.Date fecha_inicio_contrato = java.sql.Date.valueOf(request.getParameter("FechaInicioContrato"));
                java.sql.Date fecha_final_contrato = java.sql.Date.valueOf(request.getParameter("FechaFinalContrato"));

                String precio_aseo = request.getParameter("PrecioAseo");
                System.out.println("");
                bd.conectar();
                System.out.println(idaseos + idresidencias);
                s = bd.actualizar(Integer.valueOf(idaseos), Integer.valueOf(idresidencias), compania_aseo, fecha_inicio_contrato, fecha_final_contrato, Integer.valueOf(precio_aseo));
                bd.desconectar();

            }

            if (s == 1) {
                response.sendRedirect("Home.html");
            } else if (s == 0) {
                String a = "";
                a = a + "            <tr>\n"
                        + "    <tr>\n"
                        + "        <td>IdResidencia: <input name=\"IdResidencia\"> IdAseo: <input name=\"IdAseo\"> </td>\n"
                        + "      </tr>"
                        + "              <td style=width: 130px;>" + "Id: " + "?" + "<br>\n"
                        + "              </td>\n"
                        + "              <td style=width: 130px;>" + "IdResidencia: " + "?" + "<br>\n"
                        + "              </td>\n"
                        + "              </td>\n"
                        + "              <td style=width: 130px;>" + "Compania : " + "?" + "<br>\n"
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
                        + "<form method=\"post\" action=\"Actualizar_Aseo\"\n"
                        + " name=\"Actualizar_Aseo\">\n"
                        + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                        + " cellpadding=\"2\" cellspacing=\"2\">\n"
                        + "    <tbody>\n"
                        + "      <tr>\n"
                        + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                        + " src=\"./Imagenes/Img_Actualizar.jpg\" alt=\"\"></td>\n"
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
            Logger.getLogger(Actualizar_Aseo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Actualizar_Aseo.class.getName()).log(Level.SEVERE, null, ex);
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
