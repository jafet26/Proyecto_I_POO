
package controlador;

import dao.CursoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.EliminarRequisitoCurso;
import vista.MenuModificaciones;

/**
 *
 * @author USUARIO
 */
public class ControladorMenuModificaciones implements ActionListener {
    
  public MenuModificaciones vista;

  public ControladorMenuModificaciones(MenuModificaciones pVista) {
    vista = pVista;
    
    this.vista.btnEliminarRequisitoCurso.addActionListener(this);
    this.vista.btnEliminarCursoDePlan.addActionListener(this);
    this.vista.btnEliminarCurso.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.btnEliminarRequisitoCurso) {
      eliminarRequisitoCurso();
    }
    if (e.getSource() == vista.btnVolver) {
      this.vista.setVisible(false);
    }    
  }
  
  public void eliminarRequisitoCurso() {
    EliminarRequisitoCurso eliminar = new EliminarRequisitoCurso();
    CursoDAO dao = new CursoDAO();
    ControladorCurso controlador = new ControladorCurso(eliminar, dao);
    controlador.vistaEliminarRequisitoCurso.setVisible(true);
  }
  
    
}
