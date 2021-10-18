/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import logicadenegocios.Escuela;
import proyecto_i_poo.Conexion;

/**
 *
 * @author USUARIO
 */
public class EscuelaDAO {
    
 Conexion conexion;

    public EscuelaDAO() {
        conexion = new Conexion();
    }
  
  
    public String registrarEscuela(String pCodigoEscuela, String pNombreEscuela) {
      //CallableStatement cstmt = null;
      String resultado = null;
      try {
        Connection conect = conexion.Conexion();
        //conexion = conect.getConnection();
     
        CallableStatement cstmt = conect.prepareCall("{call dbo.insertarEscuela(?,?)}");
        cstmt.setString(1, pCodigoEscuela);
        cstmt.setString(2, pNombreEscuela);
    
        int respuesta = cstmt.executeUpdate();
        if (respuesta > 0) {
          resultado = "Registro exitoso";
        }
      } catch(Exception e) {
          
      }    
        return resultado;
    }
}
