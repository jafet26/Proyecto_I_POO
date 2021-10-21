/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import logicadenegocios.Curso;
import logicadenegocios.Escuela;
import logicadenegocios.PlanDeEstudios;
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
  
  public DefaultComboBoxModel llenarComboBoxCursos() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    //modelo.addElement("Seleccione");
      try {
          CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[comboCursos]}");
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
   
  public ResultSet SeleccionarCursosFiltro(String pCodigoEscuelaCurso, int pNumeroPlanEstudio) {
    Statement ejecutor;
    ResultSet rs = null;
      
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarPlanDeEstudio '" + pCodigoEscuelaCurso +"', '" + pNumeroPlanEstudio + "'");
    } catch(SQLException ex){
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(PlanDeEstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
      
    return rs;
  }
    
  public ResultSet indicarFechaVigenciaPlan(String pCodigoEscuelaCurso, int pNumeroPlanEstudio) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.adquirirFechaVigencia '" + pCodigoEscuelaCurso +"', '" + pNumeroPlanEstudio + "'");
    } catch(SQLException ex){
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(PlanDeEstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs; 
  }
  
  public ResultSet SeleccionarPlanesDeEstudioCursoParticular(String pCurso) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarPlanDeEstudioCursoParticular '" + pCurso +"'");
    } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(PlanDeEstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
    }  
      
    return rs;
  } 
  
}
