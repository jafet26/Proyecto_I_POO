
package vista;

import dao.CursoDAO;


/**
 * Vista del registro del curso
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class RegistrarCurso extends javax.swing.JFrame {

  public RegistrarCurso() {
    initComponents();
    llenarCbxPlanDeEstudio();
    llenarCbxEscuela();
  }

  /**
   * Metodo que llena el ComboBox de las escuelas
   */
  public void llenarCbxEscuela() {
    CursoDAO dao = new CursoDAO();
    cbxEscuelas.setModel(dao.llenarComboBoxEscuela());
  }
    
  /**
   * Metodo que llena el Combobox de los planes de estudio
   */
  public void llenarCbxPlanDeEstudio() {
    CursoDAO dao = new CursoDAO();
    cbxCodigoPlanDeEstudios.setModel(dao.llenarComboBoxPlanDeEstudio());
  }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistroCurso = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombreEscuela = new javax.swing.JLabel();
        lblNombreCurso = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblCreditos = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        cbxEscuelas = new javax.swing.JComboBox<>();
        txtNombreCurso = new javax.swing.JTextField();
        txtCodigoCurso = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblNotaCodigo = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        cbxCodigoPlanDeEstudios = new javax.swing.JComboBox<>();
        lblNombre6 = new javax.swing.JLabel();
        txtBloqueSemestral = new javax.swing.JTextField();
        txtCreditos = new javax.swing.JTextField();
        txtHorasLectivas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRegistroCurso.setBackground(new java.awt.Color(0, 153, 153));

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Registrar un Curso");

        lblNombreEscuela.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombreEscuela.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela.setText("Codigo de Escuela propietaria del curso:");

        lblNombreCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombreCurso.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreCurso.setText("Nombre del curso: ");

        lblCodigo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigo.setText("*Código del curso:");

        lblCreditos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblCreditos.setForeground(new java.awt.Color(255, 255, 255));
        lblCreditos.setText("Créditos: ");

        lblNombre4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombre4.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre4.setText("Horas Lectivas: ");

        cbxEscuelas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxEscuelas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEscuelasItemStateChanged(evt);
            }
        });
        cbxEscuelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEscuelasActionPerformed(evt);
            }
        });

        txtNombreCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        txtCodigoCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        btnRegistrar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
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

        btnVolver.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblNotaCodigo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        lblNotaCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblNotaCodigo.setText("*Código: Indique su código únicamente ingresando el codigo de la escuela y cuatro digitos númericos. ");

        lblNombre5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombre5.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre5.setText("Codigo Plan de Estudios:");

        cbxCodigoPlanDeEstudios.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N

        lblNombre6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombre6.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre6.setText("Bloque Semestral:");

        txtBloqueSemestral.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        txtCreditos.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        txtHorasLectivas.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelRegistroCursoLayout = new javax.swing.GroupLayout(panelRegistroCurso);
        panelRegistroCurso.setLayout(panelRegistroCursoLayout);
        panelRegistroCursoLayout.setHorizontalGroup(
            panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreEscuela)
                            .addComponent(lblNombreCurso)))
                    .addComponent(lblCreditos)
                    .addComponent(lblNombre4)
                    .addComponent(lblNombre5)
                    .addComponent(lblNombre6))
                .addGap(49, 49, 49)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                        .addComponent(txtBloqueSemestral, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                        .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCurso)
                            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar))
                            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxEscuelas, 0, 81, Short.MAX_VALUE)
                                    .addComponent(txtCodigoCurso))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))
                    .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                        .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCodigoPlanDeEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHorasLectivas, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(215, 215, 215)
                        .addComponent(lblTitulo))
                    .addComponent(lblNotaCodigo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRegistroCursoLayout.setVerticalGroup(
            panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroCursoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo)
                        .addGap(18, 18, 18)))
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEscuelas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorasLectivas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCodigoPlanDeEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBloqueSemestral, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(lblNotaCodigo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRegistroCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRegistroCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
                                         
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

    private void cbxEscuelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEscuelasActionPerformed
   
    }//GEN-LAST:event_cbxEscuelasActionPerformed

    private void cbxEscuelasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEscuelasItemStateChanged

    }//GEN-LAST:event_cbxEscuelasItemStateChanged

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
            java.util.logging.Logger.getLogger(RegistrarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbxCodigoPlanDeEstudios;
    public javax.swing.JComboBox<String> cbxEscuelas;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCreditos;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombreCurso;
    private javax.swing.JLabel lblNombreEscuela;
    private javax.swing.JLabel lblNotaCodigo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelRegistroCurso;
    public javax.swing.JTextField txtBloqueSemestral;
    public javax.swing.JTextField txtCodigoCurso;
    public javax.swing.JTextField txtCreditos;
    public javax.swing.JTextField txtHorasLectivas;
    public javax.swing.JTextField txtNombreCurso;
    // End of variables declaration//GEN-END:variables
}
