package controlador;

import dao.CursoDAO;
import dao.PlanDeEstudioDAO;
import vista.ConsultarCursosCorrequisito;
import vista.ConsultarCursosRequisito;
import vista.ConsultarPlanDeEstudio;
import vista.ConsultarPlanDeEstudioCursoParticular;
import vista.MenuConsultasAdicionales;
import vista.ConsultarListaCursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Abstraccion de la clase ControladorMenuConsultasAdicionales
 * Clase que utiliza las funcionalidades de la vista del menu de consultas adicionales
 * @author Daniel Vaglio Fallas & Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ControladorMenuConsultasAdicionales implements ActionListener {
  public MenuConsultasAdicionales vista;
  
  /**
   * Metodo Constructor
   * @param pVista despliega la vista del menu de consultas adicionales
   */
  public ControladorMenuConsultasAdicionales(MenuConsultasAdicionales pVista) {
    vista = pVista;

    this.vista.btnConsultarPlanDeEstudio.addActionListener(this);
    this.vista.btnConsultarPlanDeEstudioCursoParticular.addActionListener(this);
    this.vista.btnConsultarRequisitoCurso.addActionListener(this);
    this.vista.btnConsultarCorrequisitoCurso.addActionListener(this);
    this.vista.btnConsultarListaDeCursos.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo para accionar y ejecutar los botones de la vista
   * @param e recibe la accion del boton
   */  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.btnConsultarPlanDeEstudio) {
      consultarPlanDeEstudio();
    }
    if (e.getSource() == vista.btnConsultarPlanDeEstudioCursoParticular) {
      consultarPlanDeEstudioCursoParticular();
    }
    if (e.getSource() == vista.btnConsultarRequisitoCurso) {
      consultarRequisitoDeUnCurso();
    }
    if (e.getSource() == vista.btnConsultarCorrequisitoCurso) {
      consultarCorrequisitoDeUnCurso();
    }
    if (e.getSource() == vista.btnConsultarListaDeCursos) {
      consultarListaCursos();
    }
    if (e.getSource() == vista.btnVolver) {
      this.vista.setVisible(false);
    }
  }
  
  /**
   * Metodo que abre la ventana para consultar planes de estudio
   */
  public void consultarPlanDeEstudio() {
    ConsultarPlanDeEstudio registro = new ConsultarPlanDeEstudio();
    PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
    ControladorPlanDeEstudio controlador = new ControladorPlanDeEstudio(registro,dao);
    controlador.vistaConsultarPlanDeEstudio.setVisible(true);
  }
  
  /**
   * Metodo para desplegar la ventana de consulta de plan de estudio de un curso elegido
   */
  public void consultarPlanDeEstudioCursoParticular() {
    ConsultarPlanDeEstudioCursoParticular registro = new ConsultarPlanDeEstudioCursoParticular();
    PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
    ControladorPlanDeEstudio controlador = new ControladorPlanDeEstudio(registro,dao);
    controlador.vistaConsultarPlanDeEstudioCursoParticular.setVisible(true);
  }
  
  /**
   * Metodo para abrir la ventana de los requisitos de un curso
   */
  public void consultarRequisitoDeUnCurso() {
    ConsultarCursosRequisito registro = new ConsultarCursosRequisito();
    CursoDAO dao = new CursoDAO();
    ControladorCurso controlador = new ControladorCurso(registro, dao);
    controlador.vistaConsultarCursoRequisito.setVisible(true);
  }

  /**
   * Metodo para abrir la ventana de los correquisitos de un curso
   */
  public void consultarCorrequisitoDeUnCurso() {
    ConsultarCursosCorrequisito registro = new ConsultarCursosCorrequisito();
    CursoDAO dao = new CursoDAO();
    ControladorCurso controlador = new ControladorCurso(registro,dao);
    controlador.vistaConsultarCursoCorrequisito.setVisible(true);
  }
  
  /**
   * Metodo para abrir la ventana para ver los cursos que se muestran en una tabla
   */
  public void consultarListaCursos() {
    ConsultarListaCursos consulta = new ConsultarListaCursos();
    CursoDAO dao = new CursoDAO();
    ControladorCurso controlador = new ControladorCurso(consulta,dao);
    controlador.vistaConsultarListaCursos.setVisible(true);
    ResultSet rs;
    JTable tabla;
    DefaultTableModel dfm = new DefaultTableModel();
    rs = dao.consultarListaCursos();
    tabla = consulta.tablaInformeCursos;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo del Curso","Nombre", "Creditos", "Horas lectivas",
        "Codigo de la Escuela"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("CodigoCurso"), rs.getString("NombreCurso"),
            rs.getInt("CantidadCreditos"), rs.getInt("HorasLectivas"), 
            rs.getString("CodigoEscuelaCurso")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
}
