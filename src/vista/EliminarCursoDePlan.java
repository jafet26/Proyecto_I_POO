/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.CursoDAO;

/**
 *
 * @author USUARIO
 */
public class EliminarCursoDePlan extends javax.swing.JFrame {

    /**
     * Creates new form EliminarRequisitoCurso
     */
    public EliminarCursoDePlan() {
        initComponents();
        
        llenarCbxCursos();
    }

    public void llenarCbxCursos() {
      CursoDAO dao = new CursoDAO();

      cbxCurso.setModel(dao.llenarComboBoxCodigoCurso());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEliminar = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        lblNombreEscuela = new javax.swing.JLabel();
        cbxCurso = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInformeCurso = new javax.swing.JTable();
        btnEliminarPlanEstudioCurso = new javax.swing.JButton();
        lblNombreEscuela1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelEliminar.setBackground(new java.awt.Color(0, 153, 153));

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Eliminar Curso de un Plan de Estudio");

        btnVolver.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblNombreEscuela.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela.setText("Seleccione el Curso a buscar: ");

        cbxCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursoActionPerformed(evt);
            }
        });

        tablaInformeCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaInformeCurso);

        btnEliminarPlanEstudioCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnEliminarPlanEstudioCurso.setText("Eliminar Plan");
        btnEliminarPlanEstudioCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPlanEstudioCursoActionPerformed(evt);
            }
        });

        lblNombreEscuela1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela1.setText("Seleccione el Plan de Estudio que desea eliminar: ");

        btnBuscar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar Plan del Curso");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEliminarLayout = new javax.swing.GroupLayout(panelEliminar);
        panelEliminar.setLayout(panelEliminarLayout);
        panelEliminarLayout.setHorizontalGroup(
            panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEliminarLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(lblNombreEscuela)
                .addGap(18, 18, 18)
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
            .addGroup(panelEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEliminarLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblNombreEscuela1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEliminarLayout.createSequentialGroup()
                        .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEliminarLayout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addGap(80, 80, 80)
                                .addComponent(lblTitulo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEliminarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEliminarLayout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEliminarLayout.createSequentialGroup()
                        .addComponent(btnEliminarPlanEstudioCurso)
                        .addGap(335, 335, 335))))
        );
        panelEliminarLayout.setVerticalGroup(
            panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEliminarLayout.createSequentialGroup()
                .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEliminarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEliminarLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblTitulo)))
                .addGap(51, 51, 51)
                .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblNombreEscuela1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarPlanEstudioCurso)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCursoActionPerformed

    private void btnEliminarPlanEstudioCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPlanEstudioCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPlanEstudioCursoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarCursoDePlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarCursoDePlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarCursoDePlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarCursoDePlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarCursoDePlan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminarPlanEstudioCurso;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreEscuela;
    private javax.swing.JLabel lblNombreEscuela1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelEliminar;
    public javax.swing.JTable tablaInformeCurso;
    // End of variables declaration//GEN-END:variables
}
