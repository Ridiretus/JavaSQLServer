/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

/**
 *
 * @author Nicolás
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class Conection {
    static Connection contact=null;
    public static Connection getConexion(){
    	String URL;
        URL = "jdbc:sqlserver://DESKTOP-8K8LDCJ:1433;databaseName=PracticeDB";
    	try{
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	}catch (ClassNotFoundException e){
    		JOptionPane.showMessageDialog(null,e);
    	}

    	try{
    		contact =DriverManager.getConnection(URL,"Nico","Nicolopito652");
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,e);
    	}

    	return contact;

    }
    
    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try{
        	declara=con.createStatement();
        	ResultSet respuesta=declara.executeQuery(consulta); 
        	return respuesta;
        }catch(SQLException e){
        	JOptionPane.showMessageDialog(null,e);
        }
        return null;
    }
    public static void insert(){
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Insertar consulta");
        String consulta = sc.nextLine(); 
        ResultSet aux;
        aux=Consulta(consulta);
      try{  
        while(aux.next()){
            String mail;
            mail=aux.getString(1);
            String pass;
            pass=aux.getString(2);
            System.out.println(mail+" "+pass);
        }
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e);
      }
    }

}

