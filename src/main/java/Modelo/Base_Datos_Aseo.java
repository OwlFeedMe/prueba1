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
public class Base_Datos_Aseo {
    public Datos_Basico_Aseo obj;
    public Connection connection;

    public void conectar() throws URISyntaxException {

        
    	
            URI dbUri = new URI(System.getenv("DATABASE_URL"));
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

    public int agregar(int a, int b, String c, java.sql.Date d, java.sql.Date e, int f) {
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        // the mysql insert statement
        String query = " insert into Aseo (id_Aseo, id_residencia, compania_Aseo, fecha_Inicio_Contrato, fecha_Final_Contrato, precio_Aseo)"
                + " values (?, ?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;

        try {

            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a);
            preparedStmt.setInt(2, b);
            preparedStmt.setString(3, c);
            preparedStmt.setDate(4, d);
            preparedStmt.setDate(5, e);
            preparedStmt.setInt(6, f);
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

    public Datos_Basico_Aseo buscar(int a, int b) throws SQLException {
        Datos_Basico_Aseo dos = new Datos_Basico_Aseo();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Aseo where id_Aseo = " + a + " and id_residencia = " + b+" ";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
            // iterate through the java resultset
            dos.setId(rs.getInt("id_Aseo"));
            dos.setId_re(rs.getInt("id_residencia"));
            dos.setCompania_Aseo(rs.getString("compania_Aseo"));
            dos.setFF(rs.getDate("fecha_Inicio_Contrato"));
            dos.setFI(rs.getDate("fecha_Final_Contrato"));
            dos.setPre(rs.getInt("precio_Aseo"));
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

    public int actualizar(int a, int b, String c, java.sql.Date d, java.sql.Date e, int f) {
        try {
            //Update

            if (buscar(a, b).getId()==0) {
               return 0; 
            }
            // create the java mysql update preparedstatement
            String query = "update Aseo set compania_Aseo = ? ,fecha_Inicio_Contrato = ? , fecha_Final_Contrato = ? , precio_Aseo = ? where id_Aseo = ? and id_residencia = ? ";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, c);
            preparedStmt.setDate(2, d);
            preparedStmt.setDate(3, e);
            preparedStmt.setInt(4, f);
            preparedStmt.setInt(5, a);
            preparedStmt.setInt(6, b);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            
        } catch (SQLException er) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
          er.printStackTrace();
            
        }
        return 1;
    }

    public int eliminar(int a, int b) {
        try {
            if (buscar(a, b).getId()==0) {
               return 0; 
            }
            String query = "delete from Aseo where id_Aseo = ? and id_residencia = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a);
            preparedStmt.setInt(2, b);
            preparedStmt.execute();
            System.out.println("eliminado");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
        return 1;
    }

    public ArrayList<Datos_Basico_Aseo> cargar() {
        ArrayList<Datos_Basico_Aseo> at = new ArrayList<Datos_Basico_Aseo>();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Aseo ";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Datos_Basico_Aseo dos = new Datos_Basico_Aseo();
            // iterate through the java resultset
            dos.setId(rs.getInt("id_Aseo"));
            dos.setId_re(rs.getInt("id_residencia"));
            dos.setCompania_Aseo(rs.getString("compania_Aseo"));
            dos.setFF(rs.getDate("fecha_Inicio_Contrato"));
            dos.setFI(rs.getDate("fecha_Final_Contrato"));
            dos.setPre(rs.getInt("precio_Aseo"));
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
