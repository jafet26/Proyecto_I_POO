
package controlador;

import dao.CursoDAO;
import dao.EscuelaDAO;
import dao.PlanDeEstudioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicadenegocios.Curso;
import logicadenegocios.Escuela;
import logicadenegocios.PlanDeEstudios;
import vista.AsignarCursoRequisito;
import vista.MenuConsultasAdicionales;
import vista.MenuOpciones;
import vista.RegistrarCurso;
import vista.RegistrarEscuela;
import vista.RegistrarPlanDeEstudios;

/**
 *
 * @author USUARIO
 */
public class ControladorMenuOpciones implements ActionListener {
    
  public MenuOpciones vista;
  
  public ControladorMenuOpciones(MenuOpciones pVista) {
      
    vista = pVista;
    this.vista.btnRegistrarEscuela.addActionListener(this);
    this.vista.btnRegistrarPlanEstudios.addActionListener(this);
    this.vista.btnRegistrarCurso.addActionListener(this);
    this.vista.btnAsignarCursoRequisito.addActionListener(this);
    this.vista.btnConsultasAdicionales.addActionListener(this);
  }
  
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
    if (e.getSource() == vista.btnVolver) {
        this.vista.setVisible(false);
    }
  }
    
   
  public void registrarEscuela() {
      RegistrarEscuela registro = new RegistrarEscuela();
      Escuela escuela = new Escuela();
      EscuelaDAO dao = new EscuelaDAO();
      ControladorEscuela controlador = new ControladorEscuela(registro, escuela);
      controlador.vistaRegistroEscuela.setVisible(true);
      
  }
  
  public void registrarPlanEstudios() {
      RegistrarPlanDeEstudios registro = new RegistrarPlanDeEstudios();
      PlanDeEstudios plan = new PlanDeEstudios();
      PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
      ControladorPlanDeEstudio controlador = new ControladorPlanDeEstudio(registro, dao);
      controlador.vistaRegistroPlanDeEstudio.setVisible(true);
      
  }
  
  public void registrarCurso() {
      RegistrarCurso registro = new RegistrarCurso();
      Curso curso = new Curso();
      CursoDAO dao = new CursoDAO();
      ControladorCurso controlador = new ControladorCurso(registro, curso);
      controlador.vistaRegistroCurso.setVisible(true);
      
  }
  
  public void registrarRequisitoAUnCurso() {
      AsignarCursoRequisito asignacion = new AsignarCursoRequisito();
      Curso curso = new Curso();
      CursoDAO dao = new CursoDAO();
      ControladorCurso controlador = new ControladorCurso(asignacion, curso);
      //controlador.vistaRegistroCurso.setVisible(false);
      controlador.vistaAsignarCursoRequisito.setVisible(true);
  }
  
  public void mostrarConsultasAdicionales() {
    MenuConsultasAdicionales menu = new MenuConsultasAdicionales();
    ControladorMenuConsultasAdicionales controlador = new ControladorMenuConsultasAdicionales(menu);
    controlador.vista.setVisible(true);
  }
}
