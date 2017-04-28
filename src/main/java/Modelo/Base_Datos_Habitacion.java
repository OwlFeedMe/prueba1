package Modelo;

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
public class Base_Datos_Habitacion {
    public Datos_Basico_Habitacion obj;
    public Connection connection;
    public void conectar(){
        
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	System.out.println("MySQL JDBC Driver Registered!");
	

	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/public","root", "root");

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}

	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
        
        
        
	
     }
    public void desconectar(){
        try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
  
    public int agregar(int a, int b, int c, int d) {
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement
       

        // the mysql insert statement
        String query = " insert into Habitacion (id_Habitacion, id_Residencia, numero_Camas, valor_Habitacion)"
                + " values (?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;

        try {

            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a);
            preparedStmt.setInt(2, b);
            preparedStmt.setInt(3, c);
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

    public Datos_Basico_Habitacion buscar(int a, int b) throws SQLException {
        Datos_Basico_Habitacion dos = new Datos_Basico_Habitacion();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Habitacion where id_Habitacion = " + a +" and id_Residencia = " +b ;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
            // iterate through the java resultset
            dos.setId_Habitacion(rs.getInt("id_Habitacion"));
            dos.setId_Residencia(rs.getInt("id_Residencia"));
            dos.setNumero_Camas(rs.getInt("numero_Camas"));
            dos.setValor_Habitacion(rs.getInt("valor_Habitacion"));
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

    public int actualizar(int a, int b, int c, int d) {
        try {
            //Update

            if (buscar(a,b).getId_Habitacion()==0) {
               return 0; 
            }
            // create the java mysql update preparedstatement
            String query = "update Habitacion set numero_Camas = ? ,valor_Habitacion = ?  where id_Habitacion = ? and id_Residencia = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, c);
            preparedStmt.setInt(2, d);
            preparedStmt.setInt(3, a);
            preparedStmt.setInt(4, b);
            

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
            if (buscar(a,b).getId_Habitacion()==0) {
               return 0; 
            }
            String query = "delete from Habitacion where id_Habitacion = ? and id_Residencia = ?";
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

    public ArrayList<Datos_Basico_Habitacion> cargar() {
        ArrayList<Datos_Basico_Habitacion> at = new ArrayList<Datos_Basico_Habitacion>();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Habitacion ";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Datos_Basico_Habitacion dos = new Datos_Basico_Habitacion();
            // iterate through the java resultset
           dos.setId_Habitacion(rs.getInt("id_Habitacion"));
            dos.setId_Residencia(rs.getInt("id_Residencia"));
            dos.setNumero_Camas(rs.getInt("numero_Camas"));
            dos.setValor_Habitacion(rs.getInt("valor_Habitacion"));
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