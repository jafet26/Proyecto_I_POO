
package vista;

import dao.CursoDAO;

/**
 * Vista para agregar el requisito o correquisito a un curso
 * @author Daniel Vaglio Fallas & Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class AsignarCursoRequisito extends javax.swing.JFrame {

  public AsignarCursoRequisito() {
    initComponents();    
    llenarCbxCursos();
    llenarCbxCursosRequisitos();
    llenarCbxCursosCorrequisitos();
    llenarEscuela();
    llenarPlanEstudio();
  }

  /**
   * Metodo para llenar el ComboBox de los cursos
   */
  public void llenarCbxCursos() {
    CursoDAO dao = new CursoDAO();
    cbxCodigoCurso.setModel(dao.llenarComboBoxCodigoCurso());
  }

  /**
   * Metodo para llenar el ComboBox de los cursos Requisitos
   */
  public void llenarCbxCursosRequisitos() {
    CursoDAO dao = new CursoDAO();
    cbxCodigosCursosRequisito.setModel(dao.llenarComboBoxCodigoCursoRequisito());
  }

  /**
   * Metodo para llenar el ComboBox de los cursos Correquisitos
   */
  public void llenarCbxCursosCorrequisitos() {
    CursoDAO dao = new CursoDAO();
    cbxCursoCorrequisito.setModel(dao.llenarComboBoxCursoCorrequisito());
  }

  /**
   * Metodo para llenar el ComboBox de las escuelas
   */
  public void llenarEscuela() {
    CursoDAO dao = new CursoDAO();
    cbxEscuelas.setModel(dao.llenarComboBoxEscuela());
  }

  /**
   * Metodo para llenar el ComboBox de los planes de estudio
   */
  public void llenarPlanEstudio() {
    CursoDAO dao = new CursoDAO();
    cbxPlanEstudioCurso.setModel(dao.llenarComboBoxPlanDeEstudio());
  }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistroCursoAPlan = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombreEscuela = new javax.swing.JLabel();
        cbxEscuelas = new javax.swing.JComboBox<>();
        lblCodigoPlan = new javax.swing.JLabel();
        cbxCodigoCurso = new javax.swing.JComboBox<>();
        lblCodigoCurso = new javax.swing.JLabel();
        cbxCodigosCursosRequisito = new javax.swing.JComboBox<>();
        lblBloque = new javax.swing.JLabel();
        cbxCursoCorrequisito = new javax.swing.JComboBox<>();
        btnRegistrarRequisito = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnRegistrarCorrequisito = new javax.swing.JButton();
        lblCodigoPlan1 = new javax.swing.JLabel();
        cbxPlanEstudioCurso = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRegistroCursoAPlan.setBackground(new java.awt.Color(0, 153, 153));

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Asignar un Curso Requisito a otro Curso");

        lblNombreEscuela.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela.setText("Codigo Escuela propietaria del curso:");

        cbxEscuelas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxEscuelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEscuelasActionPerformed(evt);
            }
        });

        lblCodigoPlan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblCodigoPlan.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoPlan.setText("Codigo del curso:");

        cbxCodigoCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxCodigoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCodigoCursoActionPerformed(evt);
            }
        });

        lblCodigoCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblCodigoCurso.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoCurso.setText("Registrar Requisito del Curso");

        cbxCodigosCursosRequisito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxCodigosCursosRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCodigosCursosRequisitoActionPerformed(evt);
            }
        });

        lblBloque.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblBloque.setForeground(new java.awt.Color(255, 255, 255));
        lblBloque.setText("Registrar Correquisito del Curso");

        cbxCursoCorrequisito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxCursoCorrequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursoCorrequisitoActionPerformed(evt);
            }
        });

        btnRegistrarRequisito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnRegistrarRequisito.setText("Asignar Requisito del Curso");
        btnRegistrarRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarRequisitoActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnRegistrarCorrequisito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnRegistrarCorrequisito.setText("Asignar Correquisito del Curso");
        btnRegistrarCorrequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCorrequisitoActionPerformed(evt);
            }
        });

        lblCodigoPlan1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblCodigoPlan1.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoPlan1.setText("Numero Plan de Estudio: ");

        cbxPlanEstudioCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxPlanEstudioCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPlanEstudioCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistroCursoAPlanLayout = new javax.swing.GroupLayout(panelRegistroCursoAPlan);
        panelRegistroCursoAPlan.setLayout(panelRegistroCursoAPlanLayout);
        panelRegistroCursoAPlanLayout.setHorizontalGroup(
            panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroCursoAPlanLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(cbxCodigosCursosRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxCursoCorrequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroCursoAPlanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(94, 94, 94))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroCursoAPlanLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCodigoCurso)
                    .addComponent(btnRegistrarRequisito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarCorrequisito)
                    .addComponent(lblBloque))
                .addGap(79, 79, 79))
            .addGroup(panelRegistroCursoAPlanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addContainerGap(730, Short.MAX_VALUE))
            .addGroup(panelRegistroCursoAPlanLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroCursoAPlanLayout.createSequentialGroup()
                        .addComponent(lblCodigoPlan1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRegistroCursoAPlanLayout.createSequentialGroup()
                        .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreEscuela)
                            .addComponent(lblCodigoPlan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxPlanEstudioCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEscuelas, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );
        panelRegistroCursoAPlanLayout.setVerticalGroup(
            panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroCursoAPlanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblTitulo)
                .addGap(37, 37, 37)
                .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEscuelas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoPlan1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPlanEstudioCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBloque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCodigosCursosRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCursoCorrequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(panelRegistroCursoAPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCorrequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegistroCursoAPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegistroCursoAPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxEscuelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEscuelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEscuelasActionPerformed

    private void cbxCodigoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCodigoCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCodigoCursoActionPerformed

    private void cbxCodigosCursosRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCodigosCursosRequisitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCodigosCursosRequisitoActionPerformed

    private void cbxCursoCorrequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoCorrequisitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCursoCorrequisitoActionPerformed

    private void btnRegistrarRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarRequisitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarRequisitoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRegistrarCorrequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCorrequisitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarCorrequisitoActionPerformed

    private void cbxPlanEstudioCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPlanEstudioCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPlanEstudioCursoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AsignarCursoRequisito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarCursoRequisito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarCursoRequisito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarCursoRequisito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarCursoRequisito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegistrarCorrequisito;
    public javax.swing.JButton btnRegistrarRequisito;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbxCodigoCurso;
    public javax.swing.JComboBox<String> cbxCodigosCursosRequisito;
    public javax.swing.JComboBox<String> cbxCursoCorrequisito;
    public javax.swing.JComboBox<String> cbxEscuelas;
    public javax.swing.JComboBox<String> cbxPlanEstudioCurso;
    private javax.swing.JLabel lblBloque;
    private javax.swing.JLabel lblCodigoCurso;
    private javax.swing.JLabel lblCodigoPlan;
    private javax.swing.JLabel lblCodigoPlan1;
    private javax.swing.JLabel lblNombreEscuela;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelRegistroCursoAPlan;
    // End of variables declaration//GEN-END:variables
}
