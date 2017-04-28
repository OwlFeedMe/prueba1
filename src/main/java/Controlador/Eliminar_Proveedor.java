/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Base_Datos_Proveedor;

import Modelo.Datos_Basico_Proveedor;
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
public class Eliminar_Proveedor extends HttpServlet {

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
           
            String boton=request.getParameter("Boton");
            String idproveedor=request.getParameter("Id");
           Base_Datos_Proveedor bd = new Base_Datos_Proveedor();
          
            Datos_Basico_Proveedor db = new Datos_Basico_Proveedor();
            ArrayList<Object> at = new ArrayList();
            int s=2;
            if (boton.equals("Cargar")) {
            bd.conectar();

                Datos_Basico_Proveedor dos = bd.buscar(Integer.valueOf(idproveedor));
                bd.obj = dos;
                bd.desconectar();
                if (dos.getId() != 0) {
                    String a = "";
                    a = a + "            <tr>\n"
                            + "              <td style=width: 130px;>" + "Id: " + dos.getId() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Nombre: " + dos.getNombre() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Edad: " + dos.getTipo() + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Telefono: " + dos.getTel() + "<br>\n"
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
                            + "<form method=\"post\" action=\"Eliminar_Proveedor\"\n"
                            + " name=\"Eliminar_Proveedor\">\n"
                            + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                            + " cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "    <tbody>\n"
                            + "      <tr>\n"
                            + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                            + " src=\"./Imagenes/Img_Eliminar.jpg\" alt=\"\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>IdProveedor: <input name=\"Id\"></td>\n"
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
                            + "        <td>Id (Confirmar):<input name=\"IdProveedor\"></td>\n"
                            + "      </tr>\n"
                           
                            + "      <tr align=\"center\">\n"
                            + "        <td><input name=\"Boton\" value=\"Eliminar\"\n"
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
                            + "              <td style=width: 130px;>" + "Id: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Nombre: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Edad: " + "?" + "<br>\n"
                            + "              </td>\n"
                            + "              <td style=width: 130px;>" + "Telefono: " + "?" + "<br>\n"
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
                            + "<form method=\"post\" action=\"Eliminar_Proveedor\"\n"
                            + " name=\"Eliminar_Proveedor\">\n"
                            + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                            + " cellpadding=\"2\" cellspacing=\"2\">\n"
                            + "    <tbody>\n"
                            + "      <tr>\n"
                            + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                            + " src=\"./Imagenes/Img_Eliminar.jpg\" alt=\"\"></td>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "        <td>IdProveedor: <input name=\"Id\"></td>\n"
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
            if (boton.equals("Eliminar")) {
                String iDproveedor = request.getParameter("IdProveedor");
           
                bd.conectar();
                s = bd.eliminar(Integer.valueOf(iDproveedor));
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
                        + "<form method=\"post\" action=\"Eliminar_Proveedor\" name=\"Eliminar_Proveedor\">\n"
                        + "  <table style=\"text-align: left; width: 100px;\" border=\"1\"\n"
                        + " cellpadding=\"2\" cellspacing=\"2\">\n"
                        + "    <tbody>\n"
                        + "      <tr>\n"
                        + "        <td><img style=\"width: 488px; height: 208px;\"\n"
                        + " src=\"./Imagenes/Img_Eliminar.jpg\"\n"
                        + " alt=\"\"></td>\n"
                        + "      </tr>\n"
                        + "      <tr>\n"
                        + "        <td>Confirmacion incorrecta</td>\n"
                        + "      </tr>\n" + "      <tr>\n"
                        + "        <td>IdProveedor: <input name=\"Id\"></td>\n"
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
                    
                        + "          </tbody>\n"
                        + "        </table>\n"
                        + "        </td>\n"
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
            Logger.getLogger(Eliminar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Eliminar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Eliminar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Eliminar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
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
