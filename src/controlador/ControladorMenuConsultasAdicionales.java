package controlador;

import dao.EscuelaDAO;
import dao.PlanDeEstudioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logicadenegocios.Escuela;
import logicadenegocios.PlanDeEstudios;
import vista.ConsultarPlanDeEstudio;
import vista.MenuConsultasAdicionales;
import vista.RegistrarPlanDeEstudios;

/**
 *
 * @author USUARIO
 */
public class ControladorMenuConsultasAdicionales implements ActionListener {
  
  public MenuConsultasAdicionales vista;
  
  public ControladorMenuConsultasAdicionales(MenuConsultasAdicionales pVista) {
    vista = pVista;

    this.vista.btnConsultarPlanDeEstudio.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }
    
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.btnConsultarPlanDeEstudio) {
        consultarPlanDeEstudio();
    }
    //if (e.getSource() == vista.btnRegistrarPlanEstudios) {
       // registrarPlanEstudios();
    //}
    if (e.getSource() == vista.btnVolver) {
        this.vista.setVisible(false);
    }
  }
  
  public void consultarPlanDeEstudio() {
      ConsultarPlanDeEstudio registro = new ConsultarPlanDeEstudio();
      PlanDeEstudios escuela = new PlanDeEstudios();
      PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
      ControladorPlanDeEstudio controlador = new ControladorPlanDeEstudio(registro,dao);
      controlador.vistaConsultarPlanDeEstudio.setVisible(true);
      
  }
}
