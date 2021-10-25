package dao;

import proyecto_i_poo.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 * Abstraccion de la clase CursoDAO
 * Clase utilizada para implementar los procedimientos creados en SQL para las diversas
 * funcionalidades de los cursos en el sistema
 * 
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class CursoDAO {
  Conexion conexion;

  /**
   * Metodo constructor
   */
  public CursoDAO() {
    conexion = new Conexion();
  }

  /**
   * Metodo para llenar un ComboBox en las vistas de las funciones de los cursos en la interfaz
   * @return el modelo de ComboBox con la informacion de los codigos de planes de estudio
   */
  public DefaultComboBoxModel llenarComboBoxPlanDeEstudio() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().
          prepareCall("{CALL [dbo].[Combo_Codigo_PlanEstudio]}");
      ResultSet resultado = cmd.executeQuery();
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
    return modelo;
  }
  
  /**
   * Metodo para llenar un ComboBox en las vistas de las funciones de los cursos en la interfaz
   * @return el modelo de ComboBox con la informacion de las Escuelas
   */
  public DefaultComboBoxModel llenarComboBoxEscuela() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[Combo_Escuelas]}");
      ResultSet resultado = cmd.executeQuery();    
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
    return modelo;
  }
  
  /**
   * Metodo para llenar un ComboBox en las vistas de las funciones de los cursos en la interfaz
   * @return el modelo de ComboBox con la informacion de los cursos para los requisitos
   */
  public DefaultComboBoxModel llenarComboBoxCodigoCursoRequisito() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[comboCursos]}");
      ResultSet resultado = cmd.executeQuery();
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
    return modelo;
  }
  
  /**
   * Metodo para llenar un ComboBox en las vistas de las funciones de los cursos en la interfaz
   * @return el modelo de ComboBox con la informacion de los cursos para los requisitos
   */
  public DefaultComboBoxModel llenarComboBoxCodigoCurso() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[comboCursos]}");
      ResultSet resultado = cmd.executeQuery();
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
    return modelo;
  }
  
  /**
   * Metodo para llenar un ComboBox en las vistas de las funciones de los cursos en la interfaz
   * @return el modelo de ComboBox con la informacion de los cursos para la eliminacion de estos
   */
  public DefaultComboBoxModel llenarComboBoxCodigoCursoBackup() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[comboCursosBackup]}");
      ResultSet resultado = cmd.executeQuery();
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
    return modelo;
  }
  
  /**
   * Metodo para llenar un ComboBox en las vistas de las funciones de los cursos en la interfaz
   * @return el modelo de ComboBox con la informacion de las escuelas
   */
  public DefaultComboBoxModel llenarComboBoxEscuelaTablaRequisito() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("(CALL [dbo].[Combo_Escuelas])");
      ResultSet resultado = cmd.executeQuery();
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
    return modelo;
  }
  
  /**
   * Metodo para llenar un ComboBox en las vistas de las funciones de los cursos en la interfaz
   * @return el modelo de ComboBox con la informacion de los cursos para agregar correquisitos
   */
  public DefaultComboBoxModel llenarComboBoxCursoCorrequisito() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[comboCursos]}");
      ResultSet resultado = cmd.executeQuery();
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
    return modelo;
  }
  
  /**
   * Metodo que registra un curso y lo asigna a un plan de estudio
   * @param pCodigoCurso el codigo del curso 
   * @param pNombreCurso el nombre del curso
   * @param pHorasLectivas las horas lectivas del curso
   * @param pCantidadCreditos los creditos que tiene el curso
   * @param pNumeroPlanEstudioCurso el plan de estudio el cual pertenece
   * @param pNumeroBloqueSemestral el bloque semestral donde se ubica el curso en el plan
   * @param pCodigoEscuelaCurso el codigo de la escuela al que pertenece el curso
   * @return el registro del curso con exito
   */
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
    } catch (SQLException e) {
    }
    return resultado;
  }
  
  /**
   * Metodo para registrar la informacion de un curso
   * @param pCodigoCurso el codigo del curso 
   * @param pNombreCurso el nombre del curso
   * @param pHorasLectivas las horas lectivas del curso
   * @param pCantidadCreditos los creditos que tiene el curso
   * @param pNumeroBloqueSemestral el bloque semestral donde se ubica el curso en el plan
   * @param pCodigoEscuelaCurso el codigo de la escuela al que pertenece el curso
   * @return el registro del curso con exito 
   */
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
  
  /**
   * Metodo que asigna un curso que es requisitos de otro curso
   * @param pCodigoCurso El codigo del curso que requiere de otro
   * @param pCodigoCurso_Requisito El codigo del curso que es requisito
   * @param pCodigoEscuela_CursoRequisito El codigo de la escuela del curso requisito
   * @param pNumeroPlanEstudio_CursoRequisito El numero de plan del curso requisito
   * @return la asginacion del requisito del curso con exito 
   */
  public String asignarRequisitoAUnCurso(String pCodigoCurso, String pCodigoCurso_Requisito, 
      String pCodigoEscuela_CursoRequisito, int pNumeroPlanEstudio_CursoRequisito) {
    String resultado = null;
    try {
      Connection conect = conexion.Conexion();
      CallableStatement cstmt = conect.prepareCall("{call [dbo].[insertarRequisitoAUnCurso]"
          + "(?,?,?,?)}");
      cstmt.setString(1, pCodigoCurso);
      cstmt.setString(2, pCodigoCurso_Requisito);
      cstmt.setString(3, pCodigoEscuela_CursoRequisito);
      cstmt.setInt(4, pNumeroPlanEstudio_CursoRequisito);
      int respuesta = cstmt.executeUpdate();
      if (respuesta > 0 ) {
        resultado = "Registro Exitoso";
      }
    } catch (SQLException e) {
    }
      return resultado;
  }
  
  /**
   * Metodo que asigna un curso que sea Correquisito de otro curso
   * @param pCodigoCurso El codigo del curso que necesita de un correquisito
   * @param pCodigoCurso_Correquisito El codigo del curso que es correquisito
   * @param pNumeroPlanEstudio_CursoCorrequisito Numero de plan de estudio del curso correquisito
   * @return La asignacion del correquisito con exito de un curso
   */
  public String asignarCorrequisitoAUnCurso(String pCodigoCurso, String pCodigoCurso_Correquisito, 
      int pNumeroPlanEstudio_CursoCorrequisito) {
    String resultado = null;
    try {
      Connection conect = conexion.Conexion();
      CallableStatement cstmt = conect.prepareCall("{call [dbo].[insertarCursoCorrequisitoAUnCurso]"
          + "(?,?,?)}");
      cstmt.setString(1, pCodigoCurso);
      cstmt.setString(2, pCodigoCurso_Correquisito);
      cstmt.setInt(3, pNumeroPlanEstudio_CursoCorrequisito);
      int respuesta = cstmt.executeUpdate();
      if (respuesta > 0 ) {
        resultado = "Registro Exitoso";
      }
    } catch (SQLException e) {
    }
    return resultado;
  }
  
  /**
   * Metodo para hacer busqueda de cursos
   * @param pCodigoCurso el codigo del curso
   * @return La informacion del curso buscado
   */
  public ResultSet BuscarCurso(String pCodigoCurso) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.adquirirCursos '" + pCodigoCurso +"'");
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }    
    return rs;
  } 
  
  /**
   * Metodo que elimina el requisito de un curso
   * @param pCurso el curso el cual se le elimina el requisito
   * @param pNumeroPlan el numero de plan
   * @return verdadero si el requisito se elimina, falso en caso contrario
   */
  public boolean eliminarCursoRequisito(String pCurso, int pNumeroPlan) {
    boolean res = false;
    try {
      Connection con = conexion.Conexion();
      String query = ("dbo.eliminarCursoRequisito @CodigoCurso_Requisito = ? , "
              + "@NumeroPlanEstudio_CursoRequisito = ?");
      CallableStatement consulta = con.prepareCall(query);
      consulta.setString(1, pCurso);
      consulta.setInt(2, pNumeroPlan);
      consulta.execute();
      res = true;     
    } catch (SQLException e) {
      System.out.println(e);
    }
    return res;
  }
  
  /**
   * Metodo que busca el plan de estudio de un curso
   * @param pCurso el curso el cual se le busca los planes de estudio donde pertenece
   * @return la informacion de los planes de estudio del curso
   */
  public ResultSet BuscarPlanEstudioCurso(String pCurso) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.adquirirPlanEstudioCurso '" + pCurso +"'");
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }  
    return rs;
  }
  
  /**
   * Metodo que elimina la relacion de un plan de estudio con un Curso 
   * @param pCodigoCurso el codigo del curso
   * @param pNumeroPlanCurso el plan de estudio
   * @return verdadero si se realiza la eliminacion con exito, falso en caso contrario
   */
  public boolean eliminarPlanEstudioCurso(String pCodigoCurso, int pNumeroPlanCurso) {
    boolean res = false;
    try {
      Connection con = conexion.Conexion();
      String query = "dbo.eliminarPlanEstudioCurso @CodigoCurso = ?, @NumeroPlanEstudioCurso = ?";
      CallableStatement consulta = con.prepareCall(query);
      consulta.setString(1, pCodigoCurso);
      consulta.setInt(2, pNumeroPlanCurso);
      consulta.execute();
      res = true;
          
    } catch (SQLException e) {
      System.out.println(e);
    }
    return res;
  }
  
  /**
   * Metodo que busca un curso en el backup del sistema
   * @param pCurso el Codigo del curso que se busca
   * @return la informacion del curso 
   */
  public ResultSet BuscarCursoBackup(String pCurso) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.adquirirCursoBackup '" + pCurso +"'");
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }  
    return rs;
  } 

  /**
   * Metodo que elimina un curso de la base de datos
   * @param pCodigoCurso el codigo del curso a eliminar
   * @return verdadero si el curso se elimina, falso en caso contrario
   */
  public boolean eliminarCurso(String pCodigoCurso) {
    boolean res = false;
    try {
      Connection con = conexion.Conexion();
      String query = "dbo.eliminarCurso @CodigoCurso = ?";
      CallableStatement consulta = con.prepareCall(query);
      consulta.setString(1, pCodigoCurso);
      consulta.execute();
      res = true;
    } catch (SQLException ex) {
      System.out.println(ex);
    }
    return res;
  }
  
  /**
   * Metodo que busca los requisitos que tiene un curso en particular 
   * @param pCodigoCurso el codigo del curso a buscar
   * @return la informacion del requisito del curso
   */
  public ResultSet seleccionarCursoConRequisito(String pCodigoCurso) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarRequisitoDeUnCurso '" + pCodigoCurso + "'");
    } catch(SQLException ex){
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }
  
  /**
   * Metodo para buscar los correquisitos de un curso en particular
   * @param pCodigoCurso el codigo del curso a buscar
   * @return la informacion de los correquisitos del curso
   */
  public ResultSet seleccionarCursoConCorrequisito(String pCodigoCurso) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarCorrequisitoDeUnCurso '" 
          + pCodigoCurso + "'");
    } catch(SQLException ex){
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }
  
  /**
   * Metodo para consultar el listado de cursos existentes en el sistema
   * @return La informacion de los cursos 
   */
  public ResultSet consultarListaCursos() {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.tablaCursos");
    } catch (SQLException e) {
    }  
    return rs;
  }
}
