package controlador;

import dao.PlanDeEstudioDAO;
import logicadenegocios.Curso;
import logicadenegocios.Escuela;
import vista.AsignarCursoRequisito;
import vista.MenuConsultasAdicionales;
import vista.MenuModificaciones;
import vista.MenuOpciones;
import vista.RegistrarCurso;
import vista.RegistrarEscuela;
import vista.RegistrarPlanDeEstudios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Abstraccion de la clase ControladorMenuOpciones
 * Se utilizan las funcionalidades del menu principal de opciones
 * @author Daniel Vaglio Fallas & Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ControladorMenuOpciones implements ActionListener {
    
  public MenuOpciones vista;
  
  /**
   * Metodo Constructor
   * @param pVista despliega la vista del menu principal de opciones
   */
  public ControladorMenuOpciones(MenuOpciones pVista) {
    vista = pVista;
    
    this.vista.btnRegistrarEscuela.addActionListener(this);
    this.vista.btnRegistrarPlanEstudios.addActionListener(this);
    this.vista.btnRegistrarCurso.addActionListener(this);
    this.vista.btnAsignarCursoRequisito.addActionListener(this);
    this.vista.btnConsultasAdicionales.addActionListener(this);
    this.vista.btnModificacionInformacion.addActionListener(this);
    this.vista.btnSalir.addActionListener(this);
  }
  
  /**
   * Metodo que recibe y ejecuta las opciones del menu
   * @param e rebice la accion del boton 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.btnRegistrarEscuela) {
      registrarEscuela();
    }
    if (e.getSource() == vista.btnRegistrarPlanEstudios) {
      registrarPlanEstudios();
    }
    if (e.getSource() == vista.btnRegistrarCurso) {
      registrarCurso();
    }
    if (e.getSource() == vista.btnAsignarCursoRequisito) {
      registrarRequisitoAUnCurso();
    }
    if (e.getSource() == vista.btnConsultasAdicionales) {
      mostrarConsultasAdicionales();
    }
    if(e.getSource() == vista.btnModificacionInformacion) {
      mostrarConsultasModificacionInformacion();
    }
    if (e.getSource() == vista.btnSalir) {
      System.exit(0);
      this.vista.setVisible(false);
    }
  }
    
  /**
   * Metodo que abre la interfaz de registro de escuela
   */
  public void registrarEscuela() {
    RegistrarEscuela registro = new RegistrarEscuela();
    Escuela escuela = new Escuela();
    ControladorEscuela controlador = new ControladorEscuela(registro, escuela);
    controlador.vistaRegistroEscuela.setVisible(true);   
  }
  
  /**
   * Metodo que despliega la ventana de registro de un plan de estudio
   */
  public void registrarPlanEstudios() {
    RegistrarPlanDeEstudios registro = new RegistrarPlanDeEstudios();
    PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
    ControladorPlanDeEstudio controlador = new ControladorPlanDeEstudio(registro, dao);
    controlador.vistaRegistroPlanDeEstudio.setVisible(true);
  }
  
  /**
   * Metodo que abre la ventana de registrar un curso
   */
  public void registrarCurso() {
    RegistrarCurso registro = new RegistrarCurso();
    Curso curso = new Curso();
    ControladorCurso controlador = new ControladorCurso(registro, curso);
    controlador.vistaRegistroCurso.setVisible(true);
  }
  
  /**
   * Metodo que abre la ventana de registro de requisitos y correquisitos de un curso
   */
  public void registrarRequisitoAUnCurso() {
    AsignarCursoRequisito asignacion = new AsignarCursoRequisito();
    Curso curso = new Curso();
    ControladorCurso controlador = new ControladorCurso(asignacion, curso);
    controlador.vistaAsignarCursoRequisito.setVisible(true);
  }
  
  /**
   * Metodo que despliega la ventana para las consultas adicionales
   */
  public void mostrarConsultasAdicionales() {
    MenuConsultasAdicionales menu = new MenuConsultasAdicionales();
    ControladorMenuConsultasAdicionales controlador = new ControladorMenuConsultasAdicionales(menu);
    controlador.vista.setVisible(true);
  }
  
  /**
   * Metodo que abre la interfaz del submenu de modificaciones
   */
  public void mostrarConsultasModificacionInformacion() {
    MenuModificaciones menu = new MenuModificaciones();
    ControladorMenuModificaciones controlador = new ControladorMenuModificaciones(menu);
    controlador.vista.setVisible(true);
  }
}
