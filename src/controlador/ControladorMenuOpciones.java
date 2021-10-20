
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
      ControladorPlanDeEstudio controlador = new ControladorPlanDeEstudio(registro, plan);
      controlador.vistaRegistroPlanDeEstudio.setVisible(true);
      
  }
  
  public void registrarCurso() {
      RegistrarCurso registro = new RegistrarCurso();
      Curso curso = new Curso();
      CursoDAO dao = new CursoDAO();
      ControladorCurso controlador = new ControladorCurso(registro, curso);
      controlador.vistaRegistroCurso.setVisible(true);
      
  }
}
