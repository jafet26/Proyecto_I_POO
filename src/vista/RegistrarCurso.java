
package vista;

import dao.CursoDAO;

/**
 *
 * @author USUARIO
 */
public class RegistrarCurso extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarCurso
     */
    public RegistrarCurso() {
        initComponents();
        agregarHorasItems();
        agregarCreditosItems();
        llenarCbxPlanDeEstudio();
        llenarCbxEscuela();
    }

    public void agregarHorasItems() {
      cbxHorasLectivas.addItem("1");
      cbxHorasLectivas.addItem("2");
      cbxHorasLectivas.addItem("3");
      cbxHorasLectivas.addItem("4");
      cbxHorasLectivas.addItem("5");
    }
    
    public void agregarCreditosItems() {
      cbxCreditos.addItem("0");
      cbxCreditos.addItem("1");
      cbxCreditos.addItem("2");
      cbxCreditos.addItem("3");
      cbxCreditos.addItem("4");
    }
    
    public void llenarCbxPlanDeEstudio() {
      CursoDAO dao = new CursoDAO();
      /*ArrayList<Escuela> listaEscuelas = dao.getEscuelas();
      
      cbxEscuelas.removeAllItems();
      
      for (Escuela buscarEscuelas: listaEscuelas) {
        cbxEscuelas.addItem(new Escuela(buscarEscuelas.getCodigo(), buscarEscuelas.getNombreEscuela()));
      }*/
      cbxCodigoPlanDeEstudios.setModel(dao.llenarComboBoxPlanDeEstudio());
    }
    
    public void llenarCbxEscuela() {
      CursoDAO dao = new CursoDAO();
      /*ArrayList<Escuela> listaEscuelas = dao.getEscuelas();
      
      cbxEscuelas.removeAllItems();
      
      for (Escuela buscarEscuelas: listaEscuelas) {
        cbxEscuelas.addItem(new Escuela(buscarEscuelas.getCodigo(), buscarEscuelas.getNombreEscuela()));
      }*/
      cbxEscuelas.setModel(dao.llenarComboBoxEscuela());
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
        lblCodCurso = new javax.swing.JLabel();
        cbxEscuelas = new javax.swing.JComboBox<>();
        txtNombreCurso = new javax.swing.JTextField();
        txtCodigoCurso = new javax.swing.JTextField();
        cbxCreditos = new javax.swing.JComboBox<>();
        cbxHorasLectivas = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblNotaCodigo = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        cbxCodigoPlanDeEstudios = new javax.swing.JComboBox<>();
        lblNombre6 = new javax.swing.JLabel();
        txtBloqueSemestral = new javax.swing.JTextField();

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

        lblCodCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblCodCurso.setForeground(new java.awt.Color(255, 255, 255));
        lblCodCurso.setText("Cod+");

        cbxEscuelas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxEscuelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEscuelasActionPerformed(evt);
            }
        });

        txtNombreCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        txtCodigoCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        cbxCreditos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N

        cbxHorasLectivas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N

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
        lblNotaCodigo.setText("*Código: Indique su código únicamente ingresando cuatro digitos númericos. ");

        lblNombre5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombre5.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre5.setText("Codigo Plan de Estudios:");

        cbxCodigoPlanDeEstudios.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N

        lblNombre6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        lblNombre6.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre6.setText("Bloque Semestral:");

        txtBloqueSemestral.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelRegistroCursoLayout = new javax.swing.GroupLayout(panelRegistroCurso);
        panelRegistroCurso.setLayout(panelRegistroCursoLayout);
        panelRegistroCursoLayout.setHorizontalGroup(
            panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblNotaCodigo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(183, 183, 183))
            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                            .addComponent(lblCodigo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodCurso))
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
                        .addComponent(cbxCodigoPlanDeEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                    .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbxHorasLectivas, javax.swing.GroupLayout.Alignment.LEADING, 0, 68, Short.MAX_VALUE)
                                        .addComponent(cbxCreditos, javax.swing.GroupLayout.Alignment.LEADING, 0, 68, Short.MAX_VALUE))
                                    .addComponent(cbxEscuelas, 0, 81, Short.MAX_VALUE)
                                    .addComponent(txtCodigoCurso))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))))
        );
        panelRegistroCursoLayout.setVerticalGroup(
            panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroCursoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
                .addGap(24, 24, 24)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEscuelas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxHorasLectivas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addGap(18, 18, 18)
                .addComponent(lblNotaCodigo)
                .addGap(16, 16, 16))
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
     
      MenuOpciones ventanaMenu = new MenuOpciones();
      ventanaMenu.setVisible(true);
      this.dispose();
      
    }//GEN-LAST:event_btnVolverActionPerformed

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
    public javax.swing.JComboBox<String> cbxCreditos;
    public javax.swing.JComboBox<String> cbxEscuelas;
    public javax.swing.JComboBox<String> cbxHorasLectivas;
    private javax.swing.JLabel lblCodCurso;
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
    public javax.swing.JTextField txtNombreCurso;
    // End of variables declaration//GEN-END:variables
}
