package interfaces;

import conexion.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.WindowConstants;

public class EditarCiudad extends javax.swing.JFrame {

    String ciudad;

    public EditarCiudad() {
        initComponents();
        ciudad = ControlGeneral.ciudad_a_editar;
        setSize(676, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Editar " + ciudad);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from gobernadores where Ciudad = '" + ciudad + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtField_Ciudad.setText(ciudad);
                txtField_Estatus.setText(rs.getString("Estatus"));
                txtField_Caballos.setText(rs.getString("Caballos"));
                txtField_Vacas.setText(rs.getString("Vacas"));
                txtField_Hierro.setText(rs.getString("Hierro"));
                txtField_Vino.setText(rs.getString("Vino"));
                txtField_Yerba.setText(rs.getString("Yerba"));
                txtField_Industria.setText(rs.getString("Nivel_de_Industria"));
                txtField_MisionComercial.setText(rs.getString("Nivel_de_Mision_Comercial"));
                txtField_UnidadesReclutadas.setText(rs.getString("Unidades_Reclutadas"));
                txtField_OficialesReclutados.setText(rs.getString("Oficiales_Reclutados"));
            }
            cn.close();
            

        } catch (SQLException e) {
            System.err.println("Error al cargar datos de ciudad\n" + e);
        }

    }
    
    @Override
    public Image getIconImage(){
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtField_Ciudad = new javax.swing.JTextField();
        txtField_Estatus = new javax.swing.JTextField();
        txtField_Caballos = new javax.swing.JTextField();
        txtField_Vacas = new javax.swing.JTextField();
        txtField_Hierro = new javax.swing.JTextField();
        txtField_Vino = new javax.swing.JTextField();
        txtField_Yerba = new javax.swing.JTextField();
        txtField_Industria = new javax.swing.JTextField();
        txtField_MisionComercial = new javax.swing.JTextField();
        txtField_UnidadesReclutadas = new javax.swing.JTextField();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtField_OficialesReclutados = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ciudad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setText("Estatus");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel3.setText("Caballos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel4.setText("Vacas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel5.setText("Hierro");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel6.setText("Vino");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jLabel7.setText("Yerba");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        jLabel8.setText("Nivel de Industria");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel9.setText("Nivel de Misi??n Comercial");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jLabel12.setText("Unidades Reclutadas");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        txtField_Ciudad.setEnabled(false);
        getContentPane().add(txtField_Ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 85, -1));
        getContentPane().add(txtField_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 60, -1));
        getContentPane().add(txtField_Caballos, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 30, 60, -1));
        getContentPane().add(txtField_Vacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 60, -1));
        getContentPane().add(txtField_Hierro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 60, -1));
        getContentPane().add(txtField_Vino, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 60, -1));
        getContentPane().add(txtField_Yerba, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 60, -1));
        getContentPane().add(txtField_Industria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 60, -1));
        getContentPane().add(txtField_MisionComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 60, -1));
        getContentPane().add(txtField_UnidadesReclutadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 60, -1));

        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Oficiales Reclutados");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));
        getContentPane().add(txtField_OficialesReclutados, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "update gobernadores set Estatus = ?, Caballos = ?, Vacas = ?, Hierro = ?, "
                    + "Vino = ?, Yerba = ?, Nivel_de_Industria = ?, Nivel_de_Mision_Comercial = ?, "
                    + "Unidades_Reclutadas = ?, Oficiales_Reclutados = ? where Ciudad = '" + ciudad + "'");

            pst.setString(1, txtField_Estatus.getText());
            pst.setString(2, txtField_Caballos.getText());
            pst.setString(3, txtField_Vacas.getText());
            pst.setString(4, txtField_Hierro.getText());
            pst.setString(5, txtField_Vino.getText());
            pst.setString(6, txtField_Yerba.getText());
            pst.setString(7, txtField_Industria.getText());
            pst.setString(8, txtField_MisionComercial.getText());
            pst.setString(9, txtField_UnidadesReclutadas.getText());
            pst.setString(10, txtField_OficialesReclutados.getText());
            pst.executeUpdate();
            cn.close();
            ActualizarTablaCiudades.Actualizar();
            this.dispose();

        } catch (SQLException e) {
            System.err.println("Error al actualizar base: " + e);
        }


    }//GEN-LAST:event_jButton_ActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCiudad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtField_Caballos;
    private javax.swing.JTextField txtField_Ciudad;
    private javax.swing.JTextField txtField_Estatus;
    private javax.swing.JTextField txtField_Hierro;
    private javax.swing.JTextField txtField_Industria;
    private javax.swing.JTextField txtField_MisionComercial;
    private javax.swing.JTextField txtField_OficialesReclutados;
    private javax.swing.JTextField txtField_UnidadesReclutadas;
    private javax.swing.JTextField txtField_Vacas;
    private javax.swing.JTextField txtField_Vino;
    private javax.swing.JTextField txtField_Yerba;
    // End of variables declaration//GEN-END:variables
}
