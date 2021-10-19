/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import logicadenegocios.Escuela;
import proyecto_i_poo.Conexion;

/**
 *
 * @author USUARIO
 */
public class PlanDeEstudioDAO {
    
  Conexion conexion;
  
  //ArrayList<Escuela> listaEscuelas = new ArrayList<>();

  public PlanDeEstudioDAO() {
    conexion = new Conexion();
  }
    
  //metodo para llenar el combobox de escuelas
  /*public ArrayList<Escuela> getEscuelas() {
    
    Statement sentencia;
    ResultSet resultado;
    
    
    try {
      Connection con = conexion.Conexion();
      sentencia = con.createStatement();
      resultado = sentencia.executeQuery("SELECT * FROM Escuela");
      
      while (resultado.next()) {
        Escuela escuela = new Escuela();
        escuela.setCodigo(resultado.getString("CodigoEscuela"));
        escuela.setNombreEscuela(resultado.getString("NombreEscuela"));
        listaEscuelas.add(escuela);
      }
    } catch (Exception ex) {
        
    }
    return listaEscuelas;
  }*/
  
  public DefaultComboBoxModel llenarComboBox() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    //modelo.addElement("Seleccione");
      try {
          CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[Combo_Escuelas]}");
          ResultSet resultado = cmd.executeQuery();
          
          while (resultado.next()) {
            modelo.addElement(resultado.getString(1));
          }
      } catch (Exception e) {
      }
      return modelo;
  }
   
  public String registrarPlanDeEstudio(int pNumeroPlan, String pFechaEntradaVigencia, 
         int pCantidadSemestres, String pCodigoEscuelaPlanDeEstudio) {
    
    String resultado = null;
      try {
          Connection conect = conexion.Conexion();
          
          CallableStatement cstmt = conect.prepareCall("{call dbo.insertarPlanDeEstudio(?,?,?,?)}");
          cstmt.setInt(1, pNumeroPlan);
          cstmt.setString(2, pFechaEntradaVigencia);
          cstmt.setInt(3, pCantidadSemestres);
          cstmt.setString(4, pCodigoEscuelaPlanDeEstudio);
          
          int respuesta = cstmt.executeUpdate();
          if (respuesta > 0 ) {
            resultado = "Registro Exitoso";
          }
      } catch (Exception e) {
      }
      return resultado;
  }
    
    
    
}
