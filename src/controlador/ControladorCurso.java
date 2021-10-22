
package controlador;

import dao.CursoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logicadenegocios.Curso;
import vista.AsignarCursoRequisito;
import vista.RegistrarCurso;

/**
 *
 * @author USUARIO
 */
public class ControladorCurso implements ActionListener {
  
  public RegistrarCurso vistaRegistroCurso = new RegistrarCurso();
  public AsignarCursoRequisito vistaAsignarCursoRequisito = new AsignarCursoRequisito();
  public Curso curso;
  public CursoDAO dao;
  
  //constructor
  public ControladorCurso(RegistrarCurso pVistaRegistroCurso, Curso pCurso) {
      
    vistaRegistroCurso = pVistaRegistroCurso;
    curso = pCurso;
    dao = new CursoDAO();
        
    this.vistaRegistroCurso.btnRegistrar.addActionListener(this);
    this.vistaRegistroCurso.btnVolver.addActionListener(this);
  }
  
  public ControladorCurso(AsignarCursoRequisito pVistaAsignarCursoRequisito, Curso pCurso) {

    vistaAsignarCursoRequisito = pVistaAsignarCursoRequisito;
    curso = pCurso;
    dao = new CursoDAO();

    this.vistaAsignarCursoRequisito.btnRegistrarRequisito.addActionListener(this);
    this.vistaAsignarCursoRequisito.btnRegistrarCorrequisito.addActionListener(this);
    this.vistaAsignarCursoRequisito.btnVolver.addActionListener(this);

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
    
    if (e.getSource() == vistaAsignarCursoRequisito.btnRegistrarRequisito) {

        try {
            agregarCursoRequisito();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if(e.getSource() == vistaAsignarCursoRequisito.btnRegistrarCorrequisito) {
        try {
            agregarCursoCorrequisito();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    if (e.getSource() == vistaRegistroCurso.btnVolver) {
      this.vistaRegistroCurso.setVisible(false);
    }
    if (e.getSource() == vistaAsignarCursoRequisito.btnVolver) {
      this.vistaAsignarCursoRequisito.setVisible(false);
    }
    
}
  
  public void agregarCurso() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      
      try{
          String codigoCurso = vistaRegistroCurso.txtCodigoCurso.getText();
          String nombreCurso = vistaRegistroCurso.txtNombreCurso.getText();
          int horasLectivas = Integer.parseInt(vistaRegistroCurso.txtHorasLectivas.getText());
          int cantidadCreditos = Integer.parseInt(vistaRegistroCurso.txtCreditos.getText());
          int numeroPlanEstudioCurso = Integer.parseInt(vistaRegistroCurso.txtCodigoPlanDeEstudios.getText());
          int numeroBloqueSemestral = Integer.parseInt(vistaRegistroCurso.txtBloqueSemestral.getText());
          String codigoEscuela = vistaRegistroCurso.cbxEscuelas.getSelectedItem().toString();
          String resul = dao.registrarCurso(codigoCurso, nombreCurso, horasLectivas, cantidadCreditos,
                  numeroPlanEstudioCurso,numeroBloqueSemestral, codigoEscuela );
          String resul2 = dao.registrarCursoBackup(codigoCurso, nombreCurso, horasLectivas, cantidadCreditos,
                  numeroPlanEstudioCurso, codigoEscuela );
          if (resul != null) {
              JOptionPane.showMessageDialog(null,resul); 
          } else {
              JOptionPane.showMessageDialog(vistaRegistroCurso, "Ha sido posible registrar el curso");
          }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public void agregarCursoRequisito() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

      try{

          String codigoCurso = vistaAsignarCursoRequisito.cbxCodigoCurso.getSelectedItem().toString();
          String codigoCurso_Requisito = vistaAsignarCursoRequisito.cbxCodigosCursosRequisito.getSelectedItem().toString();
          //String codigoCurso_Correquisito = vistaAsignarCursoRequisito.txtCursoCorrequisito.getText();
          String codigoEscuela_CursoRequisito = vistaAsignarCursoRequisito.cbxEscuelas.getSelectedItem().toString();
          int numeroPlanEstudio_CursoRequisito = Integer.parseInt(vistaAsignarCursoRequisito.txtNumeroPlanEstudioCurso.getText());
          String resul = dao.asignarRequisitoAUnCurso(codigoCurso, codigoCurso_Requisito,
                  codigoEscuela_CursoRequisito, numeroPlanEstudio_CursoRequisito);
          System.out.println("Se ha registrado el requisito");
          if (resul != null) {
              //vistaRegistroEscuela.setVisible(false);
              JOptionPane.showMessageDialog(null,resul); 
              //vistaRegistroEscuela.setVisible(true);
          } else {

              JOptionPane.showMessageDialog(vistaAsignarCursoRequisito, "Ha sido posible registrar el requisito");
          }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public void agregarCursoCorrequisito() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

    try {

        String codigoCurso = vistaAsignarCursoRequisito.cbxCodigoCurso.getSelectedItem().toString();
        String codigoCurso_Correquisito = vistaAsignarCursoRequisito.cbxCursoCorrequisito.getSelectedItem().toString();
        int numeroPlanEstudio_CursoRequisito = Integer.parseInt(vistaAsignarCursoRequisito.txtNumeroPlanEstudioCurso.getText());
        String resul = dao.asignarCorrequisitoAUnCurso(codigoCurso, codigoCurso_Correquisito, numeroPlanEstudio_CursoRequisito);

        if (resul != null) {
              //vistaRegistroEscuela.setVisible(false);
              JOptionPane.showMessageDialog(null,resul); 
              //vistaRegistroEscuela.setVisible(true);
          } else {

              JOptionPane.showMessageDialog(vistaAsignarCursoRequisito, "Ha sido posible registrar el Correquisito");
          }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }

  }
  

  /*public void volverMenu() {
      vistaRegistroCurso.volverMenu();
  }*/
}
