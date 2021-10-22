
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import proyecto_i_poo.Conexion;

/**
 *
 * @author Vaglio
 */
public class CursoDAO {
  Conexion conexion;

  public CursoDAO() {
    conexion = new Conexion();
  }


 
  public DefaultComboBoxModel llenarComboBoxPlanDeEstudio() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    
      try {
          CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[Combo_Codigo_PlanEstudio]}");
          ResultSet resultado = cmd.executeQuery();
          
          while (resultado.next()) {
            modelo.addElement(resultado.getString(1));
          }
      } catch (Exception e) {
      }
      return modelo;
  }
  
  public DefaultComboBoxModel llenarComboBoxEscuela() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
 
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
  
  public DefaultComboBoxModel llenarComboBoxCodigoCursoRequisito() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
 
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
  
  public DefaultComboBoxModel llenarComboBoxCodigoCurso() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
 
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
  
  public DefaultComboBoxModel llenarComboBoxEscuelaTablaRequisito() {

    DefaultComboBoxModel modelo = new DefaultComboBoxModel();

    try {

        CallableStatement cmd = conexion.Conexion().prepareCall("(CALL [dbo].[Combo_Escuelas])");
        ResultSet resultado = cmd.executeQuery();

          while (resultado.next()) {
            modelo.addElement(resultado.getString(1));
          }
      } catch (Exception e) {
      }
      return modelo;

  }
  
  public DefaultComboBoxModel llenarComboBoxCursoCorrequisito() {

      DefaultComboBoxModel modelo = new DefaultComboBoxModel();
 
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
  
  public String registrarCurso(String pCodigoCurso, String pNombreCurso, int pHorasLectivas, 
         int pCantidadCreditos, int pNumeroPlanEstudioCurso, int pNumeroBloqueSemestral,
         String pCodigoEscuelaCurso) {
    
    String resultado = null;
      try {
          Connection conect = conexion.Conexion();
          
          CallableStatement cstmt = conect.prepareCall("{call dbo.insertarCurso(?,?,?,?,?,?,?)}");
          cstmt.setString(1, pCodigoCurso);
          cstmt.setString(2, pNombreCurso);
          cstmt.setInt(3, pHorasLectivas);
          cstmt.setInt(4, pCantidadCreditos);
          cstmt.setInt(5, pNumeroPlanEstudioCurso);
          cstmt.setInt(6, pNumeroBloqueSemestral);
          cstmt.setString(7, pCodigoEscuelaCurso);
          
          int respuesta = cstmt.executeUpdate();
          if (respuesta > 0 ) {
            resultado = "Registro Exitoso";
          }
      } catch (Exception e) {
      }
      return resultado;
  }
  
  public String registrarCursoBackup(String pCodigoCurso, String pNombreCurso, int pHorasLectivas, 
         int pCantidadCreditos, int pNumeroBloqueSemestral, String pCodigoEscuelaCurso) {
    
    String resultado = null;
      try {
          Connection conect = conexion.Conexion();
          
          CallableStatement cstmt = conect.prepareCall("{call dbo.insertarCursoBackup(?,?,?,?,?,?)}");
          cstmt.setString(1, pCodigoCurso);
          cstmt.setString(2, pNombreCurso);
          cstmt.setInt(3, pHorasLectivas);
          cstmt.setInt(4, pCantidadCreditos);
          cstmt.setInt(5, pNumeroBloqueSemestral);
          cstmt.setString(6, pCodigoEscuelaCurso);
          
          int respuesta = cstmt.executeUpdate();
          if (respuesta > 0 ) {
            resultado = "Registro Exitoso";
          }
      } catch (Exception e) {
      }
      return resultado;
  }
  
  public String asignarRequisitoAUnCurso(String pCodigoCurso, String pCodigoCurso_Requisito, 
          String pCodigoEscuela_CursoRequisito, int pNumeroPlanEstudio_CursoRequisito) {
    String resultado = null;
      try {
          Connection conect = conexion.Conexion();

          CallableStatement cstmt = conect.prepareCall("{call [dbo].[insertarRequisitoAUnCurso](?,?,?,?)}");
          cstmt.setString(1, pCodigoCurso);
          cstmt.setString(2, pCodigoCurso_Requisito);
          //cstmt.setString(3, pCodigoCurso_Correquisito);
          cstmt.setString(3, pCodigoEscuela_CursoRequisito);
          cstmt.setInt(4, pNumeroPlanEstudio_CursoRequisito);

          int respuesta = cstmt.executeUpdate();
          if (respuesta > 0 ) {
            resultado = "Registro Exitoso";
          }
      } catch (Exception e) {
      }
      return resultado;
  }
  
  public String asignarCorrequisitoAUnCurso(String pCodigoCurso, String pCodigoCurso_Correquisito, 
          int pNumeroPlanEstudio_CursoCorrequisito) {

    String resultado = null;
      try {
          Connection conect = conexion.Conexion();

          CallableStatement cstmt = conect.prepareCall("{call [dbo].[insertarCursoCorrequisitoAUnCurso](?,?,?)}");
          cstmt.setString(1, pCodigoCurso);
          cstmt.setString(2, pCodigoCurso_Correquisito);
          cstmt.setInt(3, pNumeroPlanEstudio_CursoCorrequisito);

          int respuesta = cstmt.executeUpdate();
          if (respuesta > 0 ) {
            resultado = "Registro Exitoso";
          }
      } catch (Exception e) {
      }
      return resultado;
  }
  
}
