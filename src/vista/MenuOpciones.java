/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Vaglio 
 */
public class MenuOpciones extends javax.swing.JFrame {

    /**
     * Creates new form MenuOpciones
     */
    public MenuOpciones() {
        initComponents();
        
        //btnRegistrarEscuela.setText("Registrar Escuela o Area Academica");
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnRegistrarEscuela = new javax.swing.JButton();
        btnRegistrarCurso = new javax.swing.JButton();
        btnRegistrarPlanEstudios = new javax.swing.JButton();
        btnAsignarCursoRequisito = new javax.swing.JButton();
        btnModificacionInformacion = new javax.swing.JButton();
        btnConsultasAdicionales = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(0, 102, 204));

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Seleccione una Opción ");

        btnRegistrarEscuela.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnRegistrarEscuela.setText("Registrar una Escuela o Área Académica");
        btnRegistrarEscuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEscuelaActionPerformed(evt);
            }
        });

        btnRegistrarCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnRegistrarCurso.setText("Registrar un Curso");
        btnRegistrarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCursoActionPerformed(evt);
            }
        });

        btnRegistrarPlanEstudios.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnRegistrarPlanEstudios.setText("Crear un Plan de Estudios");
        btnRegistrarPlanEstudios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPlanEstudiosActionPerformed(evt);
            }
        });

        btnAsignarCursoRequisito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnAsignarCursoRequisito.setText("Asignar Cursos Requisitos a un Curso");
        btnAsignarCursoRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarCursoRequisitoActionPerformed(evt);
            }
        });

        btnModificacionInformacion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnModificacionInformacion.setText("Modificaciones a la Información");
        btnModificacionInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificacionInformacionActionPerformed(evt);
            }
        });

        btnConsultasAdicionales.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnConsultasAdicionales.setText("Consultas Adicionales");
        btnConsultasAdicionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasAdicionalesActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnModificacionInformacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrarEscuela, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrarPlanEstudios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAsignarCursoRequisito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultasAdicionales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(87, 87, 87)
                        .addComponent(lblTitulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(32, 32, 32)))
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarPlanEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAsignarCursoRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificacionInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultasAdicionales, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarEscuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEscuelaActionPerformed
       
    }//GEN-LAST:event_btnRegistrarEscuelaActionPerformed

    private void btnRegistrarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCursoActionPerformed
 
    }//GEN-LAST:event_btnRegistrarCursoActionPerformed

    private void btnRegistrarPlanEstudiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPlanEstudiosActionPerformed

    }//GEN-LAST:event_btnRegistrarPlanEstudiosActionPerformed

    private void btnAsignarCursoRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarCursoRequisitoActionPerformed

    }//GEN-LAST:event_btnAsignarCursoRequisitoActionPerformed

    private void btnModificacionInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificacionInformacionActionPerformed

    }//GEN-LAST:event_btnModificacionInformacionActionPerformed

    private void btnConsultasAdicionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasAdicionalesActionPerformed

    }//GEN-LAST:event_btnConsultasAdicionalesActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
      /*Inicio ventanaInicio = null;
        try {
            ventanaInicio = new Inicio();
        } catch (SQLException ex) {
            Logger.getLogger(MenuOpciones.class.getName()).log(Level.SEVERE, null, ex);
        }
      ventanaInicio.setVisible(true);
      this.dispose(); */
      
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(MenuOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuOpciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAsignarCursoRequisito;
    public javax.swing.JButton btnConsultasAdicionales;
    public javax.swing.JButton btnModificacionInformacion;
    public javax.swing.JButton btnRegistrarCurso;
    public javax.swing.JButton btnRegistrarEscuela;
    public javax.swing.JButton btnRegistrarPlanEstudios;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
