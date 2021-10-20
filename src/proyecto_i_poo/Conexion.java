/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_i_poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import vista.*;
import controlador.*;
import dao.CursoDAO;
import dao.EscuelaDAO;
import dao.PlanDeEstudioDAO;
import logicadenegocios.*;


/**
 *
 * @author chava
 */
public class Conexion {
  //Jafet
  //String connectionURL = "jdbc:sqlserver://localhost\\SQLEXPRESS01:1434;databaseName=GestorPlanEstudio;user=usuario;password=1234;";
  
  //Daniel
  String connectionURL = "jdbc:sqlserver://DESKTOP-N2DB42H\\ADMIN:1433;databaseName=GestorPlanEstudio;user=admin;password=123;";
  Connection con = null;
    
  public Connection Conexion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
      con = DriverManager.getConnection(connectionURL);
      System.out.println("Conexión exitosa.");
      return con;
  }
  
  public Connection getConnection(){
      return con;
  }
  
  public void desconectar() {
      try{
          System.out.println("Cerrando conexion");
          con.close();
      } catch(SQLException ex){
          System.out.println(ex.getErrorCode());
      }
  }
    
  public static void main(String[] args) throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException{
      //Conexion c = new Conexion();
           
      MenuOpciones inicio = new MenuOpciones();
      ControladorMenuOpciones controlador = new ControladorMenuOpciones(inicio);
      controlador.vista.setVisible(true);
      
  }       
}

