package vista;

import dao.PlanDeEstudioDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicadenegocios.Escuela;

/**
 *
 * @author USUARIO
 */
public class RegistrarPlanDeEstudios extends javax.swing.JFrame {

  /** Creates new form RegistrarPlanDeEstudios */
  public RegistrarPlanDeEstudios() {
    initComponents();
    llenarCbxEscuelas();
  }
  
  public void llenarCbxEscuelas() {
    PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
    /*ArrayList<Escuela> listaEscuelas = dao.getEscuelas();
      
    cbxEscuelas.removeAllItems();
      
    for (Escuela buscarEscuelas: listaEscuelas) {
      cbxEscuelas.addItem(new Escuela(buscarEscuelas.getCodigo(), buscarEscuelas.getNombreEscuela()));
    }*/
    cbxEscuelas.setModel(dao.llenarComboBox());
  }

  public void volverMenu(){
    MenuOpciones ventana = new MenuOpciones();
    ventana.setVisible(false);
    this.dispose();
  }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        lblNombreEscuela = new javax.swing.JLabel();
        lblCodigoPlan = new javax.swing.JLabel();
        lblNotaCodigo = new javax.swing.JLabel();
        lblVigenciaPlan = new javax.swing.JLabel();
        lblVigenciaPlan1 = new javax.swing.JLabel();
        cbxEscuelas = new javax.swing.JComboBox<>();
        txtCodigoPlan = new javax.swing.JTextField();
        txtFechaVigencia = new javax.swing.JTextField();
        txtCantidadSemestres = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Registrar un Plan de Estudios");

        btnVolver.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblNombreEscuela.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombreEscuela.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela.setText("Escuela propietaria del curso:");

        lblCodigoPlan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblCodigoPlan.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoPlan.setText("Código del plan de estudios: ");

        lblNotaCodigo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        lblNotaCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblNotaCodigo.setText("*Código: Indique su código únicamente ingresando cuatro digitos númericos. ");

        lblVigenciaPlan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblVigenciaPlan.setForeground(new java.awt.Color(255, 255, 255));
        lblVigenciaPlan.setText("Vigencia del plan de estudios: ");

        lblVigenciaPlan1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblVigenciaPlan1.setForeground(new java.awt.Color(255, 255, 255));
        lblVigenciaPlan1.setText("Cantidad de semestres del plan: ");

        cbxEscuelas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxEscuelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEscuelasActionPerformed(evt);
            }
        });

        txtCodigoPlan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        txtFechaVigencia.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        txtCantidadSemestres.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        btnRegistrar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnRegistrar.setText("Registrar plan de estudios");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNotaCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addGap(110, 110, 110))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVigenciaPlan)
                                    .addComponent(lblCodigoPlan))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxEscuelas, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblNombreEscuela)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblVigenciaPlan1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadSemestres, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(211, 211, 211))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblTitulo)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEscuelas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVigenciaPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVigenciaPlan1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadSemestres, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblNotaCodigo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       
      /*MenuOpciones ventanaMenu = new MenuOpciones();
      ventanaMenu.setVisible(true);
      this.dispose();
      */
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        //String opcion = (String) cbxEscuelas.getSelectedItem();
        //int opcion = cbxEscuelas.getSelectedIndex();
        //JOptionPane.showMessageDialog(null,"opcion " + opcion);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbxEscuelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEscuelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEscuelasActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarPlanDeEstudios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPlanDeEstudios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPlanDeEstudios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPlanDeEstudios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarPlanDeEstudios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbxEscuelas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigoPlan;
    private javax.swing.JLabel lblNombreEscuela;
    private javax.swing.JLabel lblNotaCodigo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVigenciaPlan;
    private javax.swing.JLabel lblVigenciaPlan1;
    public javax.swing.JTextField txtCantidadSemestres;
    public javax.swing.JTextField txtCodigoPlan;
    public javax.swing.JTextField txtFechaVigencia;
    // End of variables declaration//GEN-END:variables

}
