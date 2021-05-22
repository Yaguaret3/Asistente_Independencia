package interfaces;

import conexion.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LogIn extends javax.swing.JFrame {

    public static String usuario, ciudad;
    String contraseña;

    public LogIn() {
        initComponents();
        setSize(400, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Independencia: el Megajuego - Iniciar Sesión");

        
        Image image_logo = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/Posible_Logo_1_5_2.png"));
        ImageIcon image_icon_logo = new ImageIcon(image_logo);  
        Icon icon_logo = new ImageIcon(image_icon_logo.getImage().getScaledInstance(jLabel_Logo.getWidth(),
                                    jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(icon_logo);
        this.repaint();
        
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
        txtField_usuario = new javax.swing.JTextField();
        txtField_contraseña = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel_Logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, -1));

        jLabel3.setText("Independencia: El Megajuego!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 4, -1, 20));
        getContentPane().add(txtField_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 100, 30));
        getContentPane().add(txtField_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 100, 30));

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, -1, -1));
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 330, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        usuario = txtField_usuario.getText();
        contraseña = txtField_contraseña.getText();

        if (!usuario.equals("") || !contraseña.equals("")) {

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select Estado, Rol, Ciudad from participantes where Usuario = '" + usuario + "' and Contraseña = '" + contraseña + "'");

                ResultSet rs = pst.executeQuery();
                if(rs.next()) {

                    String estado = rs.getString("Estado");
                    String rol = rs.getString("Rol");
                    ciudad = rs.getString("Ciudad");

                    if (estado.equals("Activo")) {
                        if (rol.equals("Control General")) {
                            new ControlGeneral().setVisible(true);
                            dispose();

                        } else if (rol.equals("Control Mapa")) {
                            new ControlMapa().setVisible(true);
                            dispose();

                        } else if (rol.equals("Gobernador")) {
                            new Gobernador().setVisible(true);
                            dispose();

                        } else if (rol.equals("Capitan")) {
                            new Capitan().setVisible(true);
                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Tu cuenta está inactiva. Comunicate con MegaJuegos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Los datos no coinciden");
                }
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al revisar base de datos" + e);
            }
        } else {
            txtField_contraseña.setText("");
            txtField_usuario.setText("");
            JOptionPane.showMessageDialog(null, "Llená todos los campos");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JPasswordField txtField_contraseña;
    private javax.swing.JTextField txtField_usuario;
    // End of variables declaration//GEN-END:variables
}