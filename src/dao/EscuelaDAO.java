package dao;

import proyecto_i_poo.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Abstraccion de la clase EscuelaDAO
 * Clase que implementa las funcionales de la Escuela en el sistema
 * @author Daniel Vaglio Fallas & Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class EscuelaDAO { 
  Conexion conexion;

  /**
   * Metodo Constructor
   */
  public EscuelaDAO() {
    conexion = new Conexion();
  }
  
  /**
   * Metodo para registrar una escuela o area academica
   * @param pCodigoEscuela el codigo de la escuela o area academica que sera asignado
   * @param pNombreEscuela el nombre que tendra la escuela o area academica 
   * @return el registro exitoso en el sistema
   */
  public String registrarEscuela(String pCodigoEscuela, String pNombreEscuela) {
    String resultado = null;
    try {
      Connection conect = conexion.Conexion();
      CallableStatement cstmt = conect.prepareCall("{call dbo.insertarEscuela(?,?)}");
      cstmt.setString(1, pCodigoEscuela);
      cstmt.setString(2, pNombreEscuela);
      int respuesta = cstmt.executeUpdate();
      if (respuesta > 0) {
        resultado = "Registro exitoso";
      }
    } catch(SQLException e) {      
    }    
    return resultado;
    }
}
