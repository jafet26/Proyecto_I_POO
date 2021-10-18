/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_i_poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author chava
 */
public class Conexion {
  
  String connectionURL = "jdbc:sqlserver://localhost\\SQLEXPRESS01:1434;databaseName=Express;user=usuario;password=1234;";
        
    Connection con = null;
    
    public Connection Conexion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        con = DriverManager.getConnection(connectionURL);
        System.out.println("Conexión exitosa.");
        return con;
    }
    
    
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException{
       /* 
        try {
            Login l = new Login();
            l.setVisible(true);
       
            */ 
        
        
        
               
            Conexion c = new Conexion();
            c.Conexion();
            
            
            /*
            Insertar i = new Insertar();
            //i.insertarUsuario("Nacho", "qwer", "Administrador", "zxcv");
            
            Eliminar e = new Eliminar();
            //e.eliminarUsuario("Nacho");
            
            Modificar m = new Modificar();
            //m.ModificarString("Usuario", "Correo", "jafetchm@gmail.com", "NombreUsuario", "JafetCH");
            
            Seleccionar s = new Seleccionar();
            s.SeleccionarUsuario();
            s.SeleccionarProveedor();
            s.SeleccionarTelefonoProveedor();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     */
    }       
}

