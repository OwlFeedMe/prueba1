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
public class Base_Datos_Estudiantes {
     public Datos_Basico_Estudiante obj;
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
    public void agregar(int a,int b, String c, int d, int e, String f, String g){
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement
    Calendar calendar = Calendar.getInstance();
    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

    // the mysql insert statement
    String query = " insert into Estudiantes (id_Estudiante, id_Asignar_Habitacion, nombre, edad, telefono, carrera, universidad)"
      + " values (?, ?, ?, ?, ?, ?, ?)";

    // create the mysql insert preparedstatement
    PreparedStatement preparedStmt=null;
	
    try {
    
		preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt (1, a);
	    preparedStmt.setInt (2, b);
	    preparedStmt.setString   (3, c);
	    preparedStmt.setInt(4, d);
            preparedStmt.setInt(5, e);
	    preparedStmt.setString    (6, f);
            preparedStmt.setString    (7, g);
	    // execute the preparedstatement
	    preparedStmt.execute();
	  
	    System.out.println("You made it, the insertion is ok!");
	    
	   
	} catch (SQLException er) {
		// TODO Auto-generated catch block
		System.out.println("Failed to make insertion!");
		er.printStackTrace();
	}
//    
    }
        public Datos_Basico_Estudiante buscar(int a) throws SQLException {
        Datos_Basico_Estudiante dos = new Datos_Basico_Estudiante();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Estudiantes where id_Estudiante = " + a ;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
            // iterate through the java resultset
            dos.setId_Estudiante(rs.getInt("id_Estudiante"));
            dos.setId_Asignar_Habitacion(rs.getInt("id_Asignar_Habitacion"));
            dos.setNombre(rs.getString("nombre"));
            dos.setEdad(rs.getInt("edad"));
            dos.setTelefono(rs.getInt("telefono"));
            dos.setCarrera(rs.getString("carrera"));
             dos.setUniversidad(rs.getString("universidad"));
            
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

    public int actualizar(int a,int b, String c, int d, int e, String f, String g) {
        try {
            //Update

            if (buscar(a).getId_Estudiante()==0) {
               return 0; 
            }
            // create the java mysql update preparedstatement
            String query = "update Estudiantes set nombre = ? ,id_Asignar_Habitacion = ? , edad = ? ,telefono = ? ,carrera = ? , universidad = ? where id_Estudiante = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, c);
            preparedStmt.setInt(2, b);
            preparedStmt.setInt(3, d);
            preparedStmt.setInt(4, e);
            preparedStmt.setString(5, f);
            preparedStmt.setString(6, g);
            preparedStmt.setInt(7, a);
            

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
            if (buscar(a).getId_Estudiante()==0) {
               return 0; 
            }
            String query = "delete from Estudiantes where id_Estudiante = ? ";
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

    public ArrayList<Datos_Basico_Estudiante> cargar() {
        ArrayList<Datos_Basico_Estudiante> at = new ArrayList<Datos_Basico_Estudiante>();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Estudiantes ";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Datos_Basico_Estudiante dos = new Datos_Basico_Estudiante();
            // iterate through the java resultset
            dos.setId_Estudiante(rs.getInt("id_Estudiante"));
            dos.setId_Asignar_Habitacion(rs.getInt("id_Asignar_Habitacion"));
            dos.setNombre(rs.getString("nombre"));
            dos.setEdad(rs.getInt("edad"));
            dos.setTelefono(rs.getInt("telefono"));
            dos.setCarrera(rs.getString("carrera"));
             dos.setUniversidad(rs.getString("universidad"));
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