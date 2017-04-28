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
public class Base_Datos_Residencia {
       public Datos_Basico_Residencia obj;
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
        
	
     
    public void desconectar(){
        try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
    
     public int agregar(int a, String b, String c, java.sql.Date d, java.sql.Date e, int f) {
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        // the mysql insert statement
        String query = " insert into Residencia (id_Residencia, propietario, direccion , fecha_Inicio_Contrato, fecha_Final_Contrato, numero_Habitacion)"
                + " values (?, ?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;

        try {

            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a);
            preparedStmt.setString(2, b);
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

    public Datos_Basico_Residencia buscar(int a) throws SQLException {
        Datos_Basico_Residencia dos = new Datos_Basico_Residencia();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Residencia where id_Residencia = " + a ;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
            // iterate through the java resultset
            dos.setId_Residencia(rs.getInt("id_Residencia"));
            dos.setPropietario(rs.getString("propietario"));
            dos.setDireccion(rs.getString("direccion"));
            dos.setFecha_Inicio_Contrato(rs.getDate("fecha_Inicio_Contrato"));
            dos.setFecha_Final_Contrato(rs.getDate("fecha_Final_Contrato"));
            dos.setNumero_Habitacion(rs.getInt("numero_Habitacion"));
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

    public int actualizar(int a, String b, String c, java.sql.Date d, java.sql.Date e, int f) {
        try {
            //Update

            if (buscar(a).getId_Residencia()==0) {
               return 0; 
            }
            // create the java mysql update preparedstatement
            String query = "update Residencia set direccion  = ? ,fecha_Inicio_Contrato = ? , fecha_Final_Contrato = ? , numero_Habitacion = ? , propietario = ? where id_Residencia = ? ";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, c);
            preparedStmt.setDate(2, d);
            preparedStmt.setDate(3, e);
            preparedStmt.setInt(4, f);
            preparedStmt.setInt(6, a);
            preparedStmt.setString(5, b);

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
            if (buscar(a).getId_Residencia()==0) {
               return 0; 
            }
            String query = "delete from Residencia where id_Residencia = ? ";
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

    public ArrayList<Datos_Basico_Residencia> cargar() {
        ArrayList<Datos_Basico_Residencia> at = new ArrayList<Datos_Basico_Residencia>();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Residencia ";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Datos_Basico_Residencia dos = new Datos_Basico_Residencia();
            // iterate through the java resultset
            dos.setId_Residencia(rs.getInt("id_Residencia"));
            dos.setPropietario(rs.getString("propietario"));
            dos.setDireccion(rs.getString("direccion"));
            dos.setFecha_Inicio_Contrato(rs.getDate("fecha_Inicio_Contrato"));
            dos.setFecha_Final_Contrato(rs.getDate("fecha_Final_Contrato"));
            dos.setNumero_Habitacion(rs.getInt("numero_Habitacion"));
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