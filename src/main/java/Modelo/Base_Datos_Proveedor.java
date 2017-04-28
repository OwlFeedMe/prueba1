/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*
 * Clase que sirve como ejemplo de conexion con MYSQL, sin embargo, carece
 * de la aplicacion de buenas practicas de programacion y carece tambien
 * de un dise�o arquitectonico adecuado para la interaccion con base de datos.
 * 
 * */
public class Base_Datos_Proveedor {
    public Datos_Basico_Proveedor obj;
    public Connection connection;

  public void conectar() throws URISyntaxException {   URI dbUri = new URI(System.getenv("DATABASE_URL"));
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
    
		   
			  	try {
					connection = DriverManager.getConnection(dbUrl, username, password);
                        	} catch (SQLException e) {
					System.out.println("Connection Failed! Check output console");
					e.printStackTrace();
				}

				
		   
		  
	

    }

    public void desconectar() {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    

    public int agregar(int a, String b, String c, int d) {
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        // the mysql insert statement
        String query = " insert into Proveedores (id_Proveedores, nombre, tipo_proveedor, telefono)"
                + " values (?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;

        try {

            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a);
            preparedStmt.setString(2, b);
            preparedStmt.setString(3, c);
            preparedStmt.setInt(4, d);
           
            // execute the preparedstatement
            preparedStmt.execute();

            System.out.println("You made it, the insertion is ok!");

        } catch (SQLException ee) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make insertion!");
            
            ee.printStackTrace();
            return 0;
        }
    return 1;
    }

    public Datos_Basico_Proveedor buscar(int a) throws SQLException {
        Datos_Basico_Proveedor dos = new Datos_Basico_Proveedor();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Proveedores where id_Proveedores = " + a ;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
            // iterate through the java resultset
            dos.setId(rs.getInt("id_Proveedores"));
            dos.setNombre(rs.getString("nombre"));
            dos.setTipo(rs.getString("tipo_proveedor"));
            dos.setTel(rs.getInt("telefono"));
            }
            // print the results
            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }

        return dos;
    }

    public int actualizar(int a, String b, String c, int d) {
        try {
            //Update

            if (buscar(a).getId()==0) {
               return 0; 
            }
            // create the java mysql update preparedstatement
            String query = "update Proveedores set nombre = ? ,tipo_proveedor = ? , telefono = ? where id_Proveedores = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, b);
            preparedStmt.setString(2, c);
            preparedStmt.setInt(3, d);
            preparedStmt.setInt(4, a);
            

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            
        } catch (SQLException er) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
          er.printStackTrace();
            
        }
        return 1;
    }

    public int eliminar(int a) {
        try {
            if (buscar(a).getId()==0) {
               return 0; 
            }
            String query = "delete from Proveedor where id_Proveedor = ? ";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a);
      
            preparedStmt.execute();
            System.out.println("eliminado");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
        return 1;
    }

    public ArrayList<Datos_Basico_Proveedor> cargar() {
        ArrayList<Datos_Basico_Proveedor> at = new ArrayList<Datos_Basico_Proveedor>();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Proveedores ";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Datos_Basico_Proveedor dos = new Datos_Basico_Proveedor();
            // iterate through the java resultset
            dos.setId(rs.getInt("id_Proveedores"));
            dos.setNombre(rs.getString("nombre"));
            dos.setTipo(rs.getString("tipo_proveedor"));
            dos.setTel(rs.getInt("telefono"));
            at.add(dos);
            }
            // print the results
            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        return at;
}

}
