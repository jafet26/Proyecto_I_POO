
package controlador;

import dao.CursoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logicadenegocios.Curso;
import vista.RegistrarCurso;

/**
 *
 * @author USUARIO
 */
public class ControladorCurso implements ActionListener {
  
  public RegistrarCurso vistaRegistroCurso = new RegistrarCurso();
  public Curso logicadenegocios;
  public CursoDAO dao = new CursoDAO();
  
  //constructor
  public ControladorCurso(RegistrarCurso pVistaRegistroCurso, CursoDAO pModelo) {
      
    vistaRegistroCurso = pVistaRegistroCurso;
    dao = pModelo;
        
    this.vistaRegistroCurso.btnRegistrar.addActionListener(this);
    this.vistaRegistroCurso.btnVolver.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistroCurso.btnRegistrar) {
        try {
            agregarCurso();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
  
  public void agregarCurso() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      
      try{
          String codigoCurso = vistaRegistroCurso.txtCodigoCurso.getText();
          String nombreCurso = vistaRegistroCurso.txtNombreCurso.getText();
          int horasLectivas = vistaRegistroCurso.cbxHorasLectivas.getSelectedIndex();
          int cantidadCreditos = vistaRegistroCurso.cbxCreditos.getSelectedIndex();
          int numeroPlanEstudioCurso = vistaRegistroCurso.cbxCodigoPlanDeEstudios.getSelectedIndex();
          int numeroBloqueSemestral = Integer.parseInt(vistaRegistroCurso.txtBloqueSemestral.getText());
          String codigoEscuela = vistaRegistroCurso.cbxEscuelas.getSelectedItem().toString();
          String resul = dao.registrarCurso(codigoCurso, nombreCurso, horasLectivas, cantidadCreditos,
                  numeroPlanEstudioCurso,numeroBloqueSemestral,codigoEscuela );
          if (resul != null) {
              //vistaRegistroEscuela.setVisible(false);
              JOptionPane.showMessageDialog(null,resul); 
              //vistaRegistroEscuela.setVisible(true);
          } else {
              JOptionPane.showMessageDialog(vistaRegistroCurso, "Ha sido posible registrar la escuela");
          }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  

  /*public void volverMenu() {
      vistaRegistroCurso.volverMenu();
  }*/
}
