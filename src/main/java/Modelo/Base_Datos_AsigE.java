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
public class Base_Datos_AsigE {
    public Datos_Basico_AsigE obj;
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

    public int agregar(int a, int b, int c, java.sql.Date d, java.sql.Date e) {
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        // the mysql insert statement
        String query = " insert into Asignar_Habitacion(id_Asignar_Habitacion, id_Estudiante, id_Habitacion, fecha_Asignacion, fecha_Final_Asignacion)"
                + " values (?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;

        try {

            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a);
            preparedStmt.setInt(2, b);
            preparedStmt.setInt(3, c);
            preparedStmt.setDate(4, d);
            preparedStmt.setDate(5, e);
  
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

    public Datos_Basico_AsigE buscar(int a, int b, int c) throws SQLException {
        Datos_Basico_AsigE dos = new Datos_Basico_AsigE();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Asignar_Habitacion where id_Asignar_Habitacion = " + a + " and id_Estudiante = " + b+" and id_Habitacion = "+c;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
            // iterate through the java resultset
            dos.setId_Asignar_Habitacion(rs.getInt("id_Asignar_Habitacion"));
            dos.setId_Estudiante(rs.getInt("id_Estudiante"));
            dos.setId_Habitacion(rs.getInt("id_Habitacion"));
            dos.setFecha_Asignacion(rs.getDate("fecha_Asignacion"));
            dos.setFecha_Final_Asignacion(rs.getDate("fecha_Final_Asignacion"));
         
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

    public int actualizar(int a, int b,int c, java.sql.Date d, java.sql.Date e) {
        try {
            //Update

            if (buscar(a, b,c).getId_Asignar_Habitacion()==0) {
               return 0; 
            }
            // create the java mysql update preparedstatement
            String query = "update Asignar_Habitacion set fecha_Asignacion = ? , fecha_Final_Asignacion = ?  where id_Asignar_Habitacion = ? and id_Estudiante = ? and id_Habitacion = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDate(1, d);
            preparedStmt.setDate(2, e);
            preparedStmt.setInt(3, a);
            preparedStmt.setInt(4, b);
            preparedStmt.setInt(5, c);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            
        } catch (SQLException er) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
          er.printStackTrace();
            
        }
        return 1;
    }

    public int eliminar(int a, int b, int c) {
        try {
            if (buscar(a, b, c).getId_Asignar_Habitacion()==0) {
               return 0; 
            }
            String query = "delete from Asignar_Habitacion where id_Asignar_Habitacion = ? and id_Estudiante = ? and id_Habitacion = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a);
            preparedStmt.setInt(2, b);
            preparedStmt.setInt(3, c);
            preparedStmt.execute();
            System.out.println("eliminado");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
        return 1;
    }

    public ArrayList<Datos_Basico_AsigE> cargar() {
        ArrayList<Datos_Basico_AsigE> at = new ArrayList<Datos_Basico_AsigE>();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM AsigE ";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Datos_Basico_AsigE dos = new Datos_Basico_AsigE();
            // iterate through the java resultset
            dos.setId_Asignar_Habitacion(rs.getInt("id_Asignar_Habitacion"));
            dos.setId_Estudiante(rs.getInt("id_Estudiante"));
            dos.setId_Habitacion(rs.getInt("id_Habitacion"));
            dos.setFecha_Asignacion(rs.getDate("fecha_Inicio_Contrato"));
            dos.setFecha_Final_Asignacion(rs.getDate("fecha_Final_Contrato"));
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