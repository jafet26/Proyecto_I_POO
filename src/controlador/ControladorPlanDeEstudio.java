
package controlador;

import dao.PlanDeEstudioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logicadenegocios.PlanDeEstudios;
import vista.RegistrarPlanDeEstudios;

/**
 *
 * @author USUARIO
 */
public class ControladorPlanDeEstudio implements ActionListener {
  
  public RegistrarPlanDeEstudios vistaRegistroPlanDeEstudio = new RegistrarPlanDeEstudios();
  public PlanDeEstudios logicadenegocios;
  public PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
  
  //constructor
  public ControladorPlanDeEstudio(RegistrarPlanDeEstudios pVistaRegistroPlanDeEstudio, 
         PlanDeEstudioDAO pModelo) {
      
    vistaRegistroPlanDeEstudio = pVistaRegistroPlanDeEstudio;
    dao = pModelo;
        
    this.vistaRegistroPlanDeEstudio.btnRegistrar.addActionListener(this);
    this.vistaRegistroPlanDeEstudio.btnVolver.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistroPlanDeEstudio.btnRegistrar) {
        try {
            agregarPlanDeEstudio();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
  
  public void agregarPlanDeEstudio() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      
      try{
          int codigoPlanDeEstudio = Integer.parseInt(vistaRegistroPlanDeEstudio.txtCodigoPlan.getText());
          String fechaVigencia = vistaRegistroPlanDeEstudio.txtFechaVigencia.getText();
          int cantidadSemestres = Integer.parseInt(vistaRegistroPlanDeEstudio.txtCantidadSemestres.getText());
          String codigoEscuela = vistaRegistroPlanDeEstudio.cbxEscuelas.getSelectedItem().toString();
          String resul = dao.registrarPlanDeEstudio(codigoPlanDeEstudio, fechaVigencia, cantidadSemestres, codigoEscuela);
          if (resul != null) {
              //vistaRegistroEscuela.setVisible(false);
              JOptionPane.showMessageDialog(null,resul); 
              //vistaRegistroEscuela.setVisible(true);
          } else {
              JOptionPane.showMessageDialog(vistaRegistroPlanDeEstudio, "Ha sido posible registrar la escuela");
          }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  

  public void volverMenu() {
      vistaRegistroPlanDeEstudio.volverMenu();
  }
    
}
