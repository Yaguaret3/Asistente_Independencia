/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.*;
import conexion.*;
import java.awt.Image;
import java.awt.Toolkit;

public class EditarTurno extends javax.swing.JFrame {

    /**
     * Creates new form EditarTurno
     */
    public EditarTurno() {
        initComponents();
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Editar turno actual");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
         try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement
                ("select Turno from otros where ID = 1");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                txt_NuevoTurno.setText(rs.getString("Turno"));
            }
            cn.close();
        } catch (Exception e) {
            System.err.println("Error en tomar datos de tabla otros: " + e);
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/IconoAsistenteIndependencia.png"));
        return retValue;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_NuevoTurno = new javax.swing.JTextField();
        jButton_ActualizarTurno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Turno Actual");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, -1));
        getContentPane().add(txt_NuevoTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 60, -1));

        jButton_ActualizarTurno.setText("Actualizar");
        jButton_ActualizarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarTurnoActionPerformed

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "update otros set Turno = ? where ID = 1");

            pst.setInt(1, Integer.parseInt(txt_NuevoTurno.getText()));
            pst.executeUpdate();
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al actualizar turno manualmente: "+e);
        }
        ActualizarTablaCiudades.Actualizar();
        this.dispose();

    }//GEN-LAST:event_jButton_ActualizarTurnoActionPerformed

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
            java.util.logging.Logger.getLogger(EditarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarTurno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ActualizarTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_NuevoTurno;
    // End of variables declaration//GEN-END:variables
}