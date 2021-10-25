package dao;

import proyecto_i_poo.Conexion;

//librerias para generar archivos PDF
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

//Librerias para el envio de correos electronicos
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstraccion de la clase PlanDeEstudioDAO
 * Implementa las funciones que se utilizan para la gestion de los planes de estudio del sistema
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class PlanDeEstudioDAO {
    
  Conexion conexion;
  
  /**
   * Metodo Constructor
   */
  public PlanDeEstudioDAO() {
    conexion = new Conexion();
  }

  /**
   * Metodo para llenar un Combobox con la informacion de las escuelas
   * @return la informacion que es contenida en un ComboBox
   */
  public DefaultComboBoxModel llenarComboBox() {
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
   * Metodo para llenar un ComboBox de los cursos
   * @return la informacion para colocarse en un ComboBox
   */
  public DefaultComboBoxModel llenarComboBoxCursos() {
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
   * Metodo para registrar un plan de estudio el cual le pertenece a una escuela
   * @param pNumeroPlan el numero del plan
   * @param pFechaEntradaVigencia la fecha de vigencia del plan
   * @param pCantidadSemestres la cantidad de semestres que tiene el plan
   * @param pCodigoEscuelaPlanDeEstudio el codigo de la escuela la cual es propietaria del plan
   * @return el exito del registro del plan de estudio
   */
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
    } catch (SQLException e) {
    }
    return resultado;
  }
  
  /**
   * Metodo que consulta la informacion de un plan de estudio
   * @param pNumeroPlanEstudio el plan de estudio que contiene el curso
   * @return la informacion del plan de estudio
   */
  public ResultSet SeleccionarCursosFiltro(int pNumeroPlanEstudio) {
    Statement ejecutor;
    ResultSet rs = null; 
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarPlanDeEstudio '" + pNumeroPlanEstudio + "'");
    } catch(SQLException ex){
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }
  
  /**
   * Metodo que consulta el total de cursos que tiene un plan de estudio
   * @param pNumeroPlanEstudio el plan de estudio
   * @return la informacion de la cuenta de cursos del plan de estudio
   */
  public ResultSet consultarCantidadTotalDeCursos(int pNumeroPlanEstudio) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.sumarCantidadCursosPlan '" + pNumeroPlanEstudio +"'");
    } catch (SQLException e) {
    }
    return rs;
  }
  
  /**
   * Metodo que consulta la suma total de los creditos que tiene un plan de estudio
   * @param pNumeroPlanEstudio el plan de estudio
   * @return la informacion de la suma total de los creditos
   */
  public ResultSet consultarCantidadTotalDeCreditos(int pNumeroPlanEstudio) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.sumarCantidadCreditosPlan '" 
          + pNumeroPlanEstudio +"'");
    } catch (SQLException e) {
    }
    return rs;
  }
  
  /**
   * Metodo que indica la fecha de vigencia de un plan de estudio en particular
   * @param pNumeroPlanEstudio el plan de estudio
   * @return la fecha de vigencia del plan
   */
  public ResultSet indicarFechaVigenciaPlan(int pNumeroPlanEstudio) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.adquirirFechaVigencia '" + pNumeroPlanEstudio + "'");
    } catch(SQLException ex){
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs; 
  }
  
  /**
   * Metodo que indica la escuela propietaria de un plan es particular
   * @param pNumeroPlanEstudio el plan de estudio
   * @return el nombre de la escuela propietaria
   */
  public ResultSet indicarNombreEscuela(int pNumeroPlanEstudio) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.adquirirNombreEscuela '" + pNumeroPlanEstudio + "'");
    } catch(SQLException ex){
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs; 
  }
  
  /**
   * Metodo que consulta los planes de estudio que tiene un curso en particular
   * @param pCurso el curso que forma parte del plan a buscar
   * @return la informacion del plan de estudio el cual tiene el curso
   */
  public ResultSet SeleccionarPlanesDeEstudioCursoParticular(String pCurso) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarPlanDeEstudioCursoParticular '" 
          + pCurso +"'");
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }  
    return rs;
  } 
  
  /**
   * Metodo que genera un archivo con extension PDF de un plan de estudio en particular
   * @param pNumeroPlanEstudio el plan de Estudio
   * @return verdadero si se genera el archivo, falso en caso contrario
   */
  public boolean generarPDF(int pNumeroPlanEstudio) {
    boolean generado = false;
    Statement ejecutor;
    ResultSet rs;
    Document documento = new Document();
    try {
      String ruta = System.getProperty("user.home");
      PdfWriter.getInstance(documento, new FileOutputStream(ruta 
          + "/Desktop/Reporte_PlanEstudio.pdf"));
      documento.open();
      PdfPTable tabla = new PdfPTable(6);
      tabla.addCell("Codigo del curso");
      tabla.addCell("Nombre del curso");
      tabla.addCell("Horas Lectivas");
      tabla.addCell("Cantidad Creditos");
      tabla.addCell("Bloque Semestral");
      tabla.addCell("Numero del plan");
      try {
        Connection con = conexion.Conexion();
        ejecutor = con.createStatement();
        rs = ejecutor.executeQuery("execute dbo.consultarPlanDeEstudio '" 
            + pNumeroPlanEstudio + "'");
        if (rs.next()) {   
          do {
            tabla.addCell(rs.getString(1));
            tabla.addCell(rs.getString(2));
            tabla.addCell(rs.getString(3));
            tabla.addCell(rs.getString(4));
            tabla.addCell(rs.getString(5));
            tabla.addCell(rs.getString(6));
            
          } while (rs.next());
          documento.add(tabla);
          generado = true;
        }
      } catch (DocumentException | SQLException e) {
      }
      documento.close();
    } catch (DocumentException | FileNotFoundException e) {
    }
    return generado;
  }
  
  /**
   * Metodo que envia un correo electronico con un archivo adjunto con extension PDF
   * @param correoDestino el correo electronico que recibe el correo 
   */
  public void enviarCorreo(String correoDestino) {
    try {
      final String correo = "gestionplanesestudio@gmail.com";
      final String pass = "rridjcbobxmhiuhn";
      final String archivoAdjunto = "C:\\Users\\USUARIO\\Desktop\\Reporte_PlanEstudio.pdf";    
      Properties prop = new Properties();
      prop.put("mail.smtp.host","smtp.gmail.com");
      prop.setProperty("mail.smtp.starttls.enable","true");
      prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
      prop.setProperty("mail.smtp.port","587");
      prop.setProperty("mail.smtp,user",correo);
      prop.setProperty("mail.smtp.auth","true");    
      Session sesion = Session.getInstance(prop);    
      BodyPart texto = new MimeBodyPart();
      texto.setText("Se adjunta el archivo correspondiente al plan de estudio consultado");
      BodyPart adjunto = new MimeBodyPart();
      adjunto.setDataHandler(new DataHandler(new FileDataSource(archivoAdjunto)));
      adjunto.setFileName(archivoAdjunto);
      MimeMultipart multipart = new MimeMultipart();
      multipart.addBodyPart(texto);
      multipart.addBodyPart(adjunto);       
      MimeMessage mensaje = new MimeMessage(sesion);
      mensaje.setFrom(new InternetAddress(correo));
      mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
      mensaje.setSubject("Sistema Gestor de Planes de Estudio - Archivo PDF Adjunto");
      mensaje.setContent(multipart);    
      Transport transporte = sesion.getTransport("smtp");
      transporte.connect(correo, pass);
      transporte.sendMessage(mensaje, mensaje.getAllRecipients());
      transporte.close();
    } catch (MessagingException ex) {
      Logger.getLogger(PlanDeEstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  } 
}