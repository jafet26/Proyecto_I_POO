package controlador;

import dao.CursoDAO;

import logicadenegocios.Curso;
import vista.AsignarCursoRequisito;
import vista.EliminarCurso;
import vista.EliminarCursoDePlan;
import vista.EliminarRequisitoCurso;
import vista.RegistrarCurso;
import vista.ConsultarCursosCorrequisito;
import vista.ConsultarCursosRequisito;
import vista.ConsultarListaCursos;

import java.awt.HeadlessException;
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
 * Abstraccion de la clase ControladorCurso
 * Para utilizar las funcionalidades que se implementan en los cursos a nivel de GUI
 * 
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ControladorCurso implements ActionListener {
  
  public RegistrarCurso vistaRegistroCurso = new RegistrarCurso();
  public AsignarCursoRequisito vistaAsignarCursoRequisito = new AsignarCursoRequisito();
  public EliminarRequisitoCurso vistaEliminarRequisitoCurso = new EliminarRequisitoCurso();
  public EliminarCursoDePlan vistaEliminarCursoDePlan = new EliminarCursoDePlan();
  public EliminarCurso vistaEliminarCurso = new EliminarCurso();
  public ConsultarCursosRequisito vistaConsultarCursoRequisito = new ConsultarCursosRequisito();
  public ConsultarCursosCorrequisito vistaConsultarCursoCorrequisito = new ConsultarCursosCorrequisito();
  public ConsultarListaCursos vistaConsultarListaCursos = new ConsultarListaCursos();
  public Curso curso;
  public CursoDAO dao;
  public ResultSet rs;
  public JTable tabla;
  
  /**
   * Metodo Constructor
   * @param pVistaRegistroCurso vista que despliega el menu de registro
   * @param pCurso Curso
   */ 
  public ControladorCurso(RegistrarCurso pVistaRegistroCurso, Curso pCurso) {  
    vistaRegistroCurso = pVistaRegistroCurso;
    curso = pCurso;
    dao = new CursoDAO();
        
    this.vistaRegistroCurso.btnRegistrar.addActionListener(this);
    this.vistaRegistroCurso.btnVolver.addActionListener(this);
    this.vistaRegistroCurso.btnLimpiar.addActionListener(this);
  }
  
  /**
   * Metodo Constructor
   * @param pVistaAsignarCursoRequisito vista que despliega la opcion de asignar un requisito a un 
   * curso
   * @param pCurso el curso 
   */
  public ControladorCurso(AsignarCursoRequisito pVistaAsignarCursoRequisito, Curso pCurso) {
    vistaAsignarCursoRequisito = pVistaAsignarCursoRequisito;
    curso = pCurso;
    dao = new CursoDAO();

    this.vistaAsignarCursoRequisito.btnRegistrarRequisito.addActionListener(this);
    this.vistaAsignarCursoRequisito.btnRegistrarCorrequisito.addActionListener(this);
    this.vistaAsignarCursoRequisito.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo Constructor
   * @param pVistaEliminarRequisitoCurso parametro de la vista para el despliegue de la opcion de 
   * eliminar
   * @param pModelo curso
   */
  public ControladorCurso(EliminarRequisitoCurso pVistaEliminarRequisitoCurso, CursoDAO pModelo) {
    vistaEliminarRequisitoCurso = pVistaEliminarRequisitoCurso;
    dao = pModelo;
    
    this.vistaEliminarRequisitoCurso.btnBuscar.addActionListener(this);
    this.vistaEliminarRequisitoCurso.btnEliminarRequisito.addActionListener(this);
    this.vistaEliminarRequisitoCurso.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo Constructor
   * @param pVistaEliminarCursoDePlan para desplegar la vista de eliminacion del curso de un plan de
   * estudio
   * @param pModelo  el curso
   */
  public ControladorCurso(EliminarCursoDePlan pVistaEliminarCursoDePlan, CursoDAO pModelo) {
    vistaEliminarCursoDePlan = pVistaEliminarCursoDePlan;
    dao = pModelo;
    
    this.vistaEliminarCursoDePlan.btnBuscar.addActionListener(this);
    this.vistaEliminarCursoDePlan.btnEliminarPlanEstudioCurso.addActionListener(this);
    this.vistaEliminarCursoDePlan.btnVolver.addActionListener(this);
  } 
  
  /**
   * Metodo Constructor
   * @param pVistaEliminarCurso vista que despliega la opcion de eliminar un curso
   * @param pModelo el curso
   */
  public ControladorCurso(EliminarCurso pVistaEliminarCurso, CursoDAO pModelo) {
    vistaEliminarCurso = pVistaEliminarCurso;
    dao = pModelo;
    
    this.vistaEliminarCurso.btnBuscar.addActionListener(this);
    this.vistaEliminarCurso.btnEliminarCurso.addActionListener(this);
    this.vistaEliminarCurso.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo Constructor
   * @param pVistaConsultarCursoRequisito vista de la consulta de requisitos de un curso
   * @param pModelo recibe las diferentes funcionalidades que tiene el sistema sobre los cursos
   */
  public ControladorCurso(ConsultarCursosRequisito pVistaConsultarCursoRequisito, CursoDAO pModelo) {
    vistaConsultarCursoRequisito = pVistaConsultarCursoRequisito;
    dao = pModelo;

    this.vistaConsultarCursoRequisito.btnBuscar.addActionListener(this);
    this.vistaConsultarCursoRequisito.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo Constructor
   * @param pVistaConsultarCursoCorrequisito despliega la vista de ocnsulta de correquisitos
   * @param pModelo recibe las diferentes funcionalidades que tiene el sistema sobre los cursos
   */
  public ControladorCurso(ConsultarCursosCorrequisito pVistaConsultarCursoCorrequisito, 
      CursoDAO pModelo) {
    vistaConsultarCursoCorrequisito = pVistaConsultarCursoCorrequisito;
    dao = pModelo;

    this.vistaConsultarCursoCorrequisito.btnBuscar.addActionListener(this);
    this.vistaConsultarCursoCorrequisito.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo Constructor
   * @param pVistaConsultarListaCursos vista de despliegue de los cursos existentes
   * @param pModelo recibe las diferentes funcionalidades que tiene el sistema sobre los cursos
   */
  public ControladorCurso(ConsultarListaCursos pVistaConsultarListaCursos, CursoDAO pModelo) {
    vistaConsultarListaCursos = pVistaConsultarListaCursos;
    dao = pModelo;

    this.vistaConsultarListaCursos.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo que ejecuta una opcion elegida con respecto a los cursos
   * @param e accion que se recibe a traves de la accion de los botones
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistroCurso.btnRegistrar) {
        agregarCurso();
    }
    if (e.getSource() == vistaRegistroCurso.btnLimpiar) {
        limpiarCampos();
    }
    if (e.getSource() == vistaAsignarCursoRequisito.btnRegistrarRequisito) {
        agregarCursoRequisito();
    }
    if(e.getSource() == vistaAsignarCursoRequisito.btnRegistrarCorrequisito) {
        agregarCursoCorrequisito();
    }
    if (e.getSource() == vistaEliminarRequisitoCurso.btnBuscar) {
      consultarCursosRequisito();
    }
    if(e.getSource() == vistaEliminarRequisitoCurso.btnEliminarRequisito) {
        eliminarRequisitoCurso();
    }
    if (e.getSource() == vistaEliminarCursoDePlan.btnBuscar) {
      consultarCursosPlan();
    }
    if (e.getSource() == vistaEliminarCursoDePlan.btnEliminarPlanEstudioCurso) {
      try {
        eliminarPlanEstudioCurso();
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    if (e.getSource() == vistaEliminarCurso.btnBuscar) {
      consultarCurso();
    }
    if (e.getSource() == vistaEliminarCurso.btnEliminarCurso) {
      try {
        eliminarCurso();
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    if(e.getSource() == vistaConsultarCursoRequisito.btnBuscar) {
      consultarRequisitoDelCurso();
    }
     if (e.getSource() == vistaConsultarCursoCorrequisito.btnBuscar) {
      consultarCorrequisitoDelCurso();
    }
    if (e.getSource() == vistaRegistroCurso.btnVolver) {
      this.vistaRegistroCurso.setVisible(false);
    }
    if (e.getSource() == vistaAsignarCursoRequisito.btnVolver) {
      this.vistaAsignarCursoRequisito.setVisible(false);
    }
    if (e.getSource() == vistaEliminarRequisitoCurso.btnVolver) {
      this.vistaEliminarRequisitoCurso.setVisible(false);
    }
    if (e.getSource() ==  vistaEliminarCursoDePlan.btnVolver) {
      this.vistaEliminarCursoDePlan.setVisible(false);
    }
    if (e.getSource() ==  vistaEliminarCurso.btnVolver) {
      this.vistaEliminarCurso.setVisible(false);
    } 
    if (e.getSource() == vistaConsultarCursoCorrequisito.btnVolver) {
      this.vistaConsultarCursoCorrequisito.setVisible(false);
    }
    if(e.getSource() == vistaConsultarCursoRequisito.btnVolver) {
      this.vistaConsultarCursoRequisito.setVisible(false);
    }
    if(e.getSource() == vistaConsultarListaCursos.btnVolver) {
      this.vistaConsultarListaCursos.setVisible(false);
    }
  }
  
  /**
   * Metodo para agregar un Curso a una escuela
   */
  public void agregarCurso() {
    try{
      String codigoCurso = vistaRegistroCurso.txtCodigoCurso.getText();
      String nombreCurso = vistaRegistroCurso.txtNombreCurso.getText();
      int horasLectivas = Integer.parseInt(vistaRegistroCurso.txtHorasLectivas.getText());
      int cantidadCreditos = Integer.parseInt(vistaRegistroCurso.txtCreditos.getText());
      int numeroPlanEstudioCurso = Integer.parseInt(vistaRegistroCurso.cbxCodigoPlanDeEstudios.
          getSelectedItem().toString());
      int numeroBloqueSemestral = Integer.parseInt(vistaRegistroCurso.txtBloqueSemestral.getText());
      String codigoEscuela = vistaRegistroCurso.cbxEscuelas.getSelectedItem().toString();
      if (cantidadCreditos >= 0 && cantidadCreditos <= 4 && horasLectivas >= 1 &&
          horasLectivas <= 5) {
        String resul = dao.registrarCurso(codigoCurso, nombreCurso, horasLectivas, cantidadCreditos,
            numeroPlanEstudioCurso,numeroBloqueSemestral, codigoEscuela );
        String resul2 = dao.registrarCursoBackup(codigoCurso, nombreCurso, horasLectivas, 
            cantidadCreditos, numeroBloqueSemestral, codigoEscuela );
        if (resul != null) {
          JOptionPane.showMessageDialog(null,resul); 
        } else {
          JOptionPane.showMessageDialog(vistaRegistroCurso, "Se ha registrado el curso " + 
              nombreCurso + " exitosamente.");
        }
      } else {
          JOptionPane.showMessageDialog(vistaRegistroCurso, "Error de datos: el rango de los"
              + " creditos debe estar entre 0-4 y el ranro de las horas lectivas debe estar"
              + " entre 1-5");
      }
    } catch (HeadlessException | NumberFormatException ex) {
      Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Metodo para agregarle requisitos a un curso
   */
  public void agregarCursoRequisito() {
    try{
      String codigoCurso = vistaAsignarCursoRequisito.cbxCodigoCurso.getSelectedItem().toString();
      String codigoCurso_Requisito = vistaAsignarCursoRequisito.cbxCodigosCursosRequisito.
          getSelectedItem().toString();
      String codigoEscuela_CursoRequisito = vistaAsignarCursoRequisito.cbxEscuelas.
          getSelectedItem().toString();
      int numeroPlanEstudio_CursoRequisito = Integer.parseInt(vistaAsignarCursoRequisito.
          cbxPlanEstudioCurso.getSelectedItem().toString());
      String resul = dao.asignarRequisitoAUnCurso(codigoCurso, codigoCurso_Requisito,
          codigoEscuela_CursoRequisito, numeroPlanEstudio_CursoRequisito);
      System.out.println("Se ha registrado el requisito");
      if (resul != null) {
        JOptionPane.showMessageDialog(null,resul); 
      } else {
        JOptionPane.showMessageDialog(vistaAsignarCursoRequisito, "Ha sido posible registrar el "
            + "requisito " + codigoCurso_Requisito);
      }
    } catch (HeadlessException | NumberFormatException ex) {
      Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   *  Metodo para agregarle un correquisito a un curso
   */
  public void agregarCursoCorrequisito() {
    try {
      String codigoCurso = vistaAsignarCursoRequisito.cbxCodigoCurso.getSelectedItem().toString();
      String codigoCurso_Correquisito = vistaAsignarCursoRequisito.cbxCursoCorrequisito.
          getSelectedItem().toString();
      int numeroPlanEstudio_CursoRequisito = Integer.parseInt(vistaAsignarCursoRequisito.
          cbxPlanEstudioCurso.getSelectedItem().toString());
      String resul = dao.asignarCorrequisitoAUnCurso(codigoCurso, codigoCurso_Correquisito, 
          numeroPlanEstudio_CursoRequisito);
      if (resul != null) {
        JOptionPane.showMessageDialog(null,resul);
      } else {
        JOptionPane.showMessageDialog(vistaAsignarCursoRequisito, "Ha sido posible registrar el "
                + "Correquisito " + codigoCurso_Correquisito);
      }
    } catch (HeadlessException | NumberFormatException ex) {
      Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Metodo para Consultar los Requisitos de un curso
   */
  public void consultarCursosRequisito() {
    String curso = vistaEliminarRequisitoCurso.cbxCurso.getSelectedItem().toString();
    rs = dao.BuscarCurso(curso);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaEliminarRequisitoCurso.tablaInformeCursosRequisito;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo del Curso Buscado","Curso Buscado", 
        "Codigo de Curso Requisito", "Plan de Estudio del Curso"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("CodigoCurso"),rs.getString("NombreCurso"), 
            rs.getString("CodigoCurso_Requisito"), rs.getInt("NumeroPlanEstudio_CursoRequisito")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }  
  }
  
  /**
   * Metodo para eliminar el Requisito de un curso 
   */
  public void eliminarRequisitoCurso() {
    int seleccion = vistaEliminarRequisitoCurso.tablaInformeCursosRequisito.getSelectedRow();
    if (seleccion == -1) {
      JOptionPane.showMessageDialog(vistaEliminarRequisitoCurso, "Seleccione una fila que coincida "
              + "con el numero de plan de estudio seleccionado anteriormente");
    } else {
      String nombre = vistaEliminarRequisitoCurso.tablaInformeCursosRequisito.
          getValueAt(seleccion, 1).toString();
      String codigo = vistaEliminarRequisitoCurso.tablaInformeCursosRequisito.
          getValueAt(seleccion, 2).toString();
      int numeroPlan = Integer.parseInt(vistaEliminarRequisitoCurso.cbxPlanEstudio.
          getSelectedItem().toString());
      if (dao.eliminarCursoRequisito(codigo, numeroPlan) == true) {
        JOptionPane.showMessageDialog(vistaEliminarRequisitoCurso, "Se ha eliminado el Requisito " 
            + codigo + " del curso " + nombre + " exitosamente");
        } else {
          JOptionPane.showMessageDialog(vistaEliminarRequisitoCurso, "No ha sido posible eliminar "
              + "el requisito " + codigo);
        }
    }
  }
  
  /**
   * Metodo para consultar a que plan de estudio pertenece un curso
   */
  public void consultarCursosPlan() {
    String curso = vistaEliminarCursoDePlan.cbxCurso.getSelectedItem().toString();
    rs = dao.BuscarPlanEstudioCurso(curso);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaEliminarCursoDePlan.tablaInformeCurso;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo del curso","Curso Buscado","Cantidad de Creditos", 
        "Plan de Estudio del Curso"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("CodigoCurso"), rs.getString("NombreCurso"), 
            rs.getString("CantidadCreditos"), rs.getInt("NumeroPlanEstudioCurso")});  
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(vistaEliminarCursoDePlan,"No se puede visualizar la consulta"); 
    } 
  }
  
  /**
   * Metodo para eliminar un curso de un plan de estudio
   * @throws ClassNotFoundException si el metodo no realiza la conexion con los parametros recibidos
   */
  public void eliminarPlanEstudioCurso() throws ClassNotFoundException {
    int seleccion = vistaEliminarCursoDePlan.tablaInformeCurso.getSelectedRow();
    if (seleccion == -1) {
      JOptionPane.showMessageDialog(vistaEliminarCursoDePlan, "Seleccione una fila");
    } else {
      String codigo = vistaEliminarCursoDePlan.tablaInformeCurso.getValueAt(seleccion, 0).
          toString();
      String nombre = vistaEliminarCursoDePlan.tablaInformeCurso.getValueAt(seleccion, 1).
          toString();
      int numeroPlan = Integer.parseInt(vistaEliminarCursoDePlan.tablaInformeCurso.
          getValueAt(seleccion,3).toString());
      if (dao.eliminarPlanEstudioCurso(codigo, numeroPlan) == true) {
        JOptionPane.showMessageDialog(vistaEliminarCursoDePlan, "Se ha eliminado la referencia al "
            + "plan de estudio " + numeroPlan + " del curso " + nombre + " exitosamente");
        } else {
          JOptionPane.showMessageDialog(vistaEliminarCursoDePlan, "No ha sido posible eliminar el "
            + "plan de estudio");
        }
    }
  }
  
  /**
   * Metodo para consultar la informacion de un curso
   */
  public void consultarCurso() {
    String curso = vistaEliminarCurso.cbxCurso.getSelectedItem().toString();
    rs = dao.BuscarCursoBackup(curso);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaEliminarCurso.tablaInformeCursosPlan;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo del Curso", "Nombre", "Horas Lectivas", 
        "Cantidad de Creditos", "Codigo de Escuela que pertenece"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("CodigoCurso"),rs.getString("NombreCurso"), 
            rs.getString("HorasLectivas"), rs.getInt("CantidadCreditos"), 
            rs.getString("CodigoEscuelaCurso")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  /**
   * Metodo que elimina un curso
   * @throws ClassNotFoundException si el metodo no realiza la conexion con los parametros recibidos
   */
  public void eliminarCurso() throws ClassNotFoundException{
    int seleccion = vistaEliminarCurso.tablaInformeCursosPlan.getSelectedRow();
    if (seleccion == -1) {
      JOptionPane.showMessageDialog(vistaEliminarCurso,"Seleccione la fila para eliminar el curso");
    } else {  
      String codigo = vistaEliminarCurso.tablaInformeCursosPlan.getValueAt(seleccion, 0).toString();
      String nombre = vistaEliminarCurso.tablaInformeCursosPlan.getValueAt(seleccion, 1).toString();    
      if (dao.eliminarCurso(codigo) == true) {
        JOptionPane.showMessageDialog(vistaEliminarCurso, "Se ha eliminado el curso " + nombre + 
            " exitosamente");
      } else {
        JOptionPane.showMessageDialog(vistaEliminarCurso, "No ha sido posible eliminar el curso");
        }
    }
  }
  
  /**
   * Metodo para consultar los Requisitos de un curso
   */
  public void consultarRequisitoDelCurso() {
    String curso = vistaConsultarCursoRequisito.cbxCurso.getSelectedItem().toString();
    rs = dao.seleccionarCursoConRequisito(curso);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaConsultarCursoRequisito.tablaInformeCursosRequisito;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo del Curso Requisito", "Numero Plan Estudio"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("CodigoCurso_Requisito"), 
            rs.getInt("NumeroPlanEstudio_CursoRequisito")});
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  /**
   * Metodo para consultar Correquisitos de un curso
   */
  public void consultarCorrequisitoDelCurso() {
    String curso = vistaConsultarCursoCorrequisito.cbxCurso.getSelectedItem().toString();
    rs = dao.seleccionarCursoConCorrequisito(curso);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaConsultarCursoCorrequisito.tablaInformeCursosCorrequisito;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo del Curso Correquisito", "Numero Plan Estudio"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("CodigoCurso_Correquisito"), 
            rs.getInt("NumeroPlanEstudio_CursoCorrequisito")});
      }
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  /**
   * Metodo que limpia los campos de texto
   */
  public void limpiarCampos() {
    vistaRegistroCurso.txtBloqueSemestral.setText("");
    vistaRegistroCurso.txtCodigoCurso.setText("");
    vistaRegistroCurso.txtCreditos.setText("");
    vistaRegistroCurso.txtHorasLectivas.setText("");
    vistaRegistroCurso.txtNombreCurso.setText("");
  }
}
