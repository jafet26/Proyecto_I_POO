/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.CursoDAO;
import dao.PlanDeEstudioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ConsultarPlanDeEstudio extends javax.swing.JFrame {
  JTable tabla;
  ResultSet rs;
 
  
  public ConsultarPlanDeEstudio() {
    initComponents();
    
    llenarCbxEscuelas();
    llenarCbxPlanDeEstudio();
    /*DefaultTableModel dfm = new DefaultTableModel();
    tabla = this.tablaInformeCursosPlan;
    tabla.setModel(dfm);
    
    dfm.setColumnIdentifiers(new Object[]{"Codigo", "Nombre", "Horas", "Creditos", "numero Bloque"});
    PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
    rs = dao.SeleccionarCursos();
    try {
        while (rs.next()) {
            dfm.addRow(new Object[]{rs.getString("CodigoCurso"), rs.getString("NombreCurso"),
            rs.getInt("HorasLectivas"), rs.getInt("CantidadCreditos"), rs.getInt("NumeroBloqueSemestral")});
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,ex);
    }*/
  }
  
  public void llenarCbxEscuelas(){
      PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
      cbxEscuelas.setModel(dao.llenarComboBox());
  }
  
  public void llenarCbxPlanDeEstudio() {
      CursoDAO dao = new CursoDAO();
      cbxCodigoPlanDeEstudios.setModel(dao.llenarComboBoxPlanDeEstudio());
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsulta = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        lblNombreEscuela = new javax.swing.JLabel();
        cbxEscuelas = new javax.swing.JComboBox<>();
        lblCodigoPlan = new javax.swing.JLabel();
        cbxCodigoPlanDeEstudios = new javax.swing.JComboBox<>();
        txtCodigoPlan = new javax.swing.JTextField();
        lblVigenciaPlan = new javax.swing.JLabel();
        txtFechaVigencia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInformeCursosPlan = new javax.swing.JTable();
        btnGenerarPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelConsulta.setBackground(new java.awt.Color(0, 153, 153));

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Consultar Plan de Estudio");

        btnVolver.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblNombreEscuela.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela.setText("Escuela propietaria del curso:");

        cbxEscuelas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxEscuelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEscuelasActionPerformed(evt);
            }
        });

        lblCodigoPlan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblCodigoPlan.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoPlan.setText("Código del plan de estudios: ");

        cbxCodigoPlanDeEstudios.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N

        txtCodigoPlan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        lblVigenciaPlan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblVigenciaPlan.setForeground(new java.awt.Color(255, 255, 255));
        lblVigenciaPlan.setText("Vigencia del plan de estudios: ");

        txtFechaVigencia.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        tablaInformeCursosPlan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaInformeCursosPlan);

        btnGenerarPDF.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnGenerarPDF.setText("Generar PDF y enviar por correo");
        btnGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConsultaLayout = new javax.swing.GroupLayout(panelConsulta);
        panelConsulta.setLayout(panelConsultaLayout);
        panelConsultaLayout.setHorizontalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelConsultaLayout.createSequentialGroup()
                                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreEscuela)
                                    .addComponent(lblVigenciaPlan)
                                    .addComponent(lblCodigoPlan))
                                .addGap(38, 38, 38)
                                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCodigoPlanDeEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxEscuelas, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelConsultaLayout.createSequentialGroup()
                                .addGap(384, 384, 384)
                                .addComponent(txtCodigoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGenerarPDF)))
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultaLayout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(182, 182, 182))
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        panelConsultaLayout.setVerticalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEscuelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCodigoPlanDeEstudios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodigoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVigenciaPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnGenerarPDF)
                .addGap(96, 96, 96))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed


    }//GEN-LAST:event_btnVolverActionPerformed

    private void cbxEscuelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEscuelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEscuelasActionPerformed

    private void btnGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarPDFActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarPlanDeEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarPlanDeEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarPlanDeEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarPlanDeEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarPlanDeEstudio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGenerarPDF;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbxCodigoPlanDeEstudios;
    public javax.swing.JComboBox<String> cbxEscuelas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigoPlan;
    private javax.swing.JLabel lblNombreEscuela;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVigenciaPlan;
    private javax.swing.JPanel panelConsulta;
    public javax.swing.JTable tablaInformeCursosPlan;
    public javax.swing.JTextField txtCodigoPlan;
    public javax.swing.JTextField txtFechaVigencia;
    // End of variables declaration//GEN-END:variables
}
