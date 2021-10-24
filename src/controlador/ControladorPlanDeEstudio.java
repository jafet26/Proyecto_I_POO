package controlador;

import dao.PlanDeEstudioDAO;
import java.awt.HeadlessException;
import logicadenegocios.Curso;
import logicadenegocios.PlanDeEstudios;
import vista.ConsultarPlanDeEstudio;
import vista.ConsultarPlanDeEstudioCursoParticular;
import vista.RegistrarPlanDeEstudios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Abstraccion de la clase ControladorPlanDeEstudio
 * La clase hace el uso de las funcionalidades que tienen los planes de estudio en el sistema
 * @author Daniel Vaglio Fallas & Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ControladorPlanDeEstudio implements ActionListener {
  public JTable tabla;
  public ResultSet rs;
  public DefaultTableModel modelo = new DefaultTableModel();
  public PlanDeEstudios logicadenegocios;
  public Curso curso;
  public PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
  public RegistrarPlanDeEstudios vistaRegistroPlanDeEstudio = new RegistrarPlanDeEstudios();
  public ConsultarPlanDeEstudio vistaConsultarPlanDeEstudio = new ConsultarPlanDeEstudio();
  public ConsultarPlanDeEstudioCursoParticular vistaConsultarPlanDeEstudioCursoParticular = 
      new ConsultarPlanDeEstudioCursoParticular();
  
  /**
   * Metodo Constructor
   * @param pVistaRegistroPlanDeEstudio despliega la vista del registro de un plan
   * @param pModelo para utilizar los metodos del plan de estudio
   */
  public ControladorPlanDeEstudio(RegistrarPlanDeEstudios pVistaRegistroPlanDeEstudio, 
      PlanDeEstudioDAO pModelo) {    
    vistaRegistroPlanDeEstudio = pVistaRegistroPlanDeEstudio;
    dao = pModelo;
        
    this.vistaRegistroPlanDeEstudio.btnRegistrar.addActionListener(this);
    this.vistaRegistroPlanDeEstudio.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo Constructor
   * @param pVistaConsultarPlanDeEstudio despliega la vista de la consulta de plan estudio
   * @param pModelo para utilizar los metodos del plan de estudio
   */
  public ControladorPlanDeEstudio(ConsultarPlanDeEstudio pVistaConsultarPlanDeEstudio, 
      PlanDeEstudioDAO pModelo) {
    vistaConsultarPlanDeEstudio = pVistaConsultarPlanDeEstudio;
    dao = pModelo;
    
    this.vistaConsultarPlanDeEstudio.btnGenerarPDF.addActionListener(this);
    this.vistaConsultarPlanDeEstudio.btnEnviarCorreo.addActionListener(this);
    this.vistaConsultarPlanDeEstudio.btnBuscar.addActionListener(this);
    this.vistaConsultarPlanDeEstudio.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo Constructor
   * @param pVistaConsultarPlanDeEstudioCursoParticular despliega la vista de consulta 
   * @param pModelo para utilizar los metodos del plan de estudio
   */
  public ControladorPlanDeEstudio(ConsultarPlanDeEstudioCursoParticular 
      pVistaConsultarPlanDeEstudioCursoParticular, PlanDeEstudioDAO pModelo) {
    vistaConsultarPlanDeEstudioCursoParticular = pVistaConsultarPlanDeEstudioCursoParticular;
    dao = pModelo;
    
    this.vistaConsultarPlanDeEstudioCursoParticular.btnBuscar.addActionListener(this);
    this.vistaConsultarPlanDeEstudioCursoParticular.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo que ejecuta los metodos de los planes de estudio
   * @param e recibe la accion del boton
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistroPlanDeEstudio.btnRegistrar) {
      agregarPlanDeEstudio();
    }
    if (e.getSource() == vistaConsultarPlanDeEstudio.btnBuscar) {
      consultarPlanDeEstudio();
    }
    if(e.getSource() == vistaConsultarPlanDeEstudio.btnGenerarPDF) {
      generarPDF();  
    }
    if (e.getSource() == vistaConsultarPlanDeEstudio.btnEnviarCorreo) {
      enviarCorreo();
    }
    if (e.getSource() == vistaConsultarPlanDeEstudioCursoParticular.btnBuscar) {
      consultarPlanDeEstudioCursoParticular();
    }
    if(e.getSource() == vistaRegistroPlanDeEstudio.btnVolver) {
      this.vistaRegistroPlanDeEstudio.setVisible(false);
    }
    if(e.getSource() == vistaConsultarPlanDeEstudio.btnVolver) {
      this.vistaConsultarPlanDeEstudio.setVisible(false);
    }
    if(e.getSource() == vistaConsultarPlanDeEstudioCursoParticular.btnVolver) {
      this.vistaConsultarPlanDeEstudioCursoParticular.setVisible(false);
    }
}
  
  /**
   * Metodo que agrega un plan de Estudio 
   */
  public void agregarPlanDeEstudio() { 
    try{
      int codigoPlanDeEstudio = Integer.parseInt(vistaRegistroPlanDeEstudio.txtCodigoPlan.
          getText());
      String fechaVigencia = vistaRegistroPlanDeEstudio.txtFechaVigencia.getText();
      int cantidadSemestres = Integer.parseInt(vistaRegistroPlanDeEstudio.txtCantidadSemestres.
          getText());
      String codigoEscuela = vistaRegistroPlanDeEstudio.cbxEscuelas.getSelectedItem().toString();
      String resul = dao.registrarPlanDeEstudio(codigoPlanDeEstudio, fechaVigencia, 
          cantidadSemestres, codigoEscuela);
      if (resul != null) {
        JOptionPane.showMessageDialog(null,resul); 
      } else {
        JOptionPane.showMessageDialog(vistaRegistroPlanDeEstudio, "Ha sido posible registrar la escuela");
      }
    } catch (HeadlessException | NumberFormatException ex) {
      Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Metodo que consulta un plan de estudio, ademas en este se descarga un archivo con el plan
   * en formato PDF y se envia por correo electronico
   */
  public void consultarPlanDeEstudio() {
    int numeroPlanEstudio = Integer.parseInt(vistaConsultarPlanDeEstudio.cbxCodigoPlanDeEstudios.
        getSelectedItem().toString());
    ResultSet fechaVigencia = dao.indicarFechaVigenciaPlan(numeroPlanEstudio);
    ResultSet escuela = dao.indicarNombreEscuela(numeroPlanEstudio);
    ResultSet cursos = dao.consultarCantidadTotalDeCursos(numeroPlanEstudio);
    ResultSet creditos = dao.consultarCantidadTotalDeCreditos(numeroPlanEstudio);
    try {
      if (fechaVigencia.next()){
        String fecha = fechaVigencia.getString("FechaEntradaVigencia");
        vistaConsultarPlanDeEstudio.txtFechaVigencia.setText(fecha);
        }
    } catch (SQLException ex) {
      Logger.getLogger(ControladorPlanDeEstudio.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
      if(escuela.next()) {
        String nombreEscuela = escuela.getString("NombreEscuela");
        vistaConsultarPlanDeEstudio.txtEscuelaPlan.setText(nombreEscuela);
      }
    } catch (SQLException ex) {
      Logger.getLogger(ControladorPlanDeEstudio.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
      if (cursos.next()){
        String CantidadCursos = cursos.getString("CantidadCursos");
        vistaConsultarPlanDeEstudio.txtCantidadTotalCursos.setText(CantidadCursos);
      }
    } catch (SQLException ex) {
      Logger.getLogger(ControladorPlanDeEstudio.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
      if (creditos.next()){
        String CantidadCreditos = creditos.getString("CantidadTotalCreditos");
        vistaConsultarPlanDeEstudio.txtCantidadTotalCreditos.setText(CantidadCreditos);
      }
    } catch (SQLException ex) {
      Logger.getLogger(ControladorPlanDeEstudio.class.getName()).log(Level.SEVERE, null, ex);
    }
    rs = dao.SeleccionarCursosFiltro(numeroPlanEstudio);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaConsultarPlanDeEstudio.tablaInformeCursosPlan;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo", "Nombre", "Horas", "Creditos", 
        "numero Bloque"}); 
    try {
      while (rs.next()) {
        dfm.addRow(new Object[]{rs.getString("CodigoCurso"), rs.getString("NombreCurso"),
            rs.getInt("HorasLectivas"), rs.getInt("CantidadCreditos"), 
            rs.getInt("NumeroBloqueSemestral")});
      }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,ex);
    }
  }
  
  /**
   * Metodo que consulta el plan de estudio de un curso en particular
   */
  public void consultarPlanDeEstudioCursoParticular() {
    String curso = vistaConsultarPlanDeEstudioCursoParticular.cbxCursos.getSelectedItem().
        toString();
    rs = dao.SeleccionarPlanesDeEstudioCursoParticular(curso);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaConsultarPlanDeEstudioCursoParticular.tablaInformeCursosPlan;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Curso", "Plan de Estudio", "Fecha Entrada Vigencia", 
        "Cantidad de Semestres", "Codigo de la Escuela", "Nombre"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("NombreCurso"), rs.getInt("NumeroPlanEstudio"),
            rs.getString("FechaEntradaVigencia"), rs.getInt("CantidadSemestres"), 
            rs.getString("CodigoEscuelaPlanEstudio"), rs.getString("NombreEscuela")});
      }    
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null,ex); 
    }
  }

  /**
   * Metodo que genera un archivo PDF obtenido de la consulta de un plan
   */
  public void generarPDF() {
    int plan = Integer.parseInt(vistaConsultarPlanDeEstudio.cbxCodigoPlanDeEstudios.
        getSelectedItem().toString());
    if (dao.generarPDF(plan) == true) {
      JOptionPane.showMessageDialog(vistaConsultarPlanDeEstudio, "Se ha generado el documento PDF");
    } else {
      JOptionPane.showMessageDialog(vistaConsultarPlanDeEstudio, "ERROR al generar PDF");
    }
  }
  
  /**
   * Metodo que envia un correo electronico de un archivo adjunto
   */
  public void enviarCorreo() {
    String correo = vistaConsultarPlanDeEstudio.txtCorreoElectronico.getText();
    if (correo != null) {
        dao.enviarCorreo(correo);
      JOptionPane.showMessageDialog(vistaConsultarPlanDeEstudio, "Se ha enviado el correo a la "
          + "direccion " + correo);
    } else {
      JOptionPane.showMessageDialog(vistaConsultarPlanDeEstudio, "No ha sido posible enviar el "
          + "correo");
    }
  } 
}
