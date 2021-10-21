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
  
  /*public ResultSet SeleccionarCursos() {
      
      Statement st; 
      ResultSet rs = null;
      try {
        Connection con = conexion.Conexion();
        st = con.createStatement();
        rs = st.executeQuery("Select CodigoCurso, NombreCurso, HorasLectivas, CantidadCreditos, "
                + "NumeroBloqueSemestral from Curso");
      
      } catch (SQLException ex) {
          Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
          Logger.getLogger(PlanDeEstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
      return rs;
  } */
  
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
  /*public ArrayList<Curso> listarCursos() {
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<Curso> datos = new ArrayList<>();
    String sql = "select c.CodigoCurso, c.NombreCurso, c.HorasLectivas, c.CantidadCreditos, "
            + "c.NumeroBloqueSemestral from Curso c ";
    try {
      Connection con = conexion.Conexion();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while (rs.next()) {
        Curso curso = new Curso();
        curso.setCodigoCurso(rs.getString(1));
        curso.setNmbreCurso(rs.getString(2));
        curso.setHorasLectivas(rs.getInt(3));
        curso.setCantidadCreditos(rs.getInt(4));
        curso.setNumeroBloqueSemestre(rs.getInt(5));
        datos.add(curso);
      }
    } catch (Exception e) {
      }
    return datos;
  }*/
  /*public Vector<PlanDeEstudios> mostrarPlanesEstudio(String pCodigoEscuela) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Vector<PlanDeEstudios> datos = new Vector<PlanDeEstudios>();
    PlanDeEstudios dat = null;
    
      try {
          Connection conect = conexion.Conexion();
          String sql = "Select NumeroPlanEstudio from PlanDeEstudio "
                  + "where CodigoEscuelaPlanEstudio = " + pCodigoEscuela;
          ps = conect.prepareStatement(sql);
          rs = ps.executeQuery();
          
          //dat = new PlanDeEstudios();
          
          while (rs.next()) {
              dat = new PlanDeEstudios();
              dat.setNumeroPlan(rs.getInt("NumeroPlanEstudio"));
              datos.add(dat);
          }
          rs.close();
      } catch (Exception e) {
          System.err.println(e.toString());
      }
      return datos;
  }*/
    
    
    
}
