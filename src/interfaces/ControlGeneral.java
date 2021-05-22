package interfaces;

import java.sql.*;
import conexion.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlGeneral extends javax.swing.JFrame {

    public static DefaultTableModel model = new DefaultTableModel();
    public static DefaultTableModel model2 = new DefaultTableModel();
    public static String ciudad_a_editar = "";
    int valores_ciudad[][] = new int[10][5];
    int valores_nuevos[][] = new int[10][5];
    int valores_industria[][] = new int[10][5];
    int industria[] = new int[10];

    public ControlGeneral() {
        initComponents();
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Control General");
        ActualizarTurno();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from gobernadores");
            ResultSet rs = pst.executeQuery();

            Tabla_Ciudades = new JTable(model);
            jScrollPane_Ciudades.setViewportView(Tabla_Ciudades);

            model.addColumn("Cdd");
            model.addColumn("Est");
            model.addColumn("Cab");
            model.addColumn("Vac");
            model.addColumn("Hie");
            model.addColumn("Vin");
            model.addColumn("Yer");
            model.addColumn("Ind");
            model.addColumn("Mis");
            model.addColumn("Ofi");

            while (rs.next()) {
                Object[] fila = new Object[10];

                for (int i = 0; i < 10; i++) {
                    fila[i] = rs.getObject(i + 2);
                }
                model.addRow(fila);
            }
            cn.close();

            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "select * from otros where ID = 1");
            ResultSet rs2 = pst2.executeQuery();

            while (rs2.next()) {
                jLabel_Turno.setText("Turno " + rs2.getString("Turno"));
            }
            cn2.close();

            Tabla_ActoresPoliticos = new JTable(model2);
            jScrollPane_ActoresPoliticos.setViewportView(Tabla_ActoresPoliticos);

            model2.addColumn("Actor Político");
            model2.addColumn("Valor");

            Connection cn3 = Conexion.conectar();
            PreparedStatement pst3 = cn3.prepareStatement(
                    "select * from actorespoliticos where ID = 1");
            ResultSet rs3 = pst3.executeQuery();

            while (rs3.next()) {

                Object[] fila1 = new Object[2];
                Object[] fila2 = new Object[2];
                Object[] fila3 = new Object[2];
                Object[] fila4 = new Object[2];
                Object[] fila5 = new Object[2];
                Object[] fila6 = new Object[2];
                Object[] fila7 = new Object[2];
                Object[] fila8 = new Object[2];
                Object[] fila9 = new Object[2];
                Object[] fila10 = new Object[2];
                Object[] fila11 = new Object[2];

                fila1[0] = "Capital Inglés";
                fila2[0] = "Capital Francés";
                fila3[0] = "Esclavos";
                fila4[0] = "Iglesia";
                fila5[0] = "Mineria";
                fila6[0] = "Campaña";
                fila7[0] = "Elite";
                fila8[0] = "Cultura";
                fila9[0] = "Banca";
                fila10[0] = "Gremios";
                fila11[0] = "Gobierno Nacional";

                fila1[1] = rs3.getInt("Capital_Ingles");
                fila2[1] = rs3.getInt("Capital_Frances");
                fila3[1] = rs3.getInt("Esclavos");
                fila4[1] = rs3.getInt("Iglesia");
                fila5[1] = rs3.getInt("Mineria");
                fila6[1] = rs3.getInt("Campaña");
                fila7[1] = rs3.getInt("Elite");
                fila8[1] = rs3.getInt("Cultura");
                fila9[1] = rs3.getInt("Banca");
                fila10[1] = rs3.getInt("Gremios");
                fila11[1] = rs3.getInt("Gobierno_Nacional");

                model2.addRow(fila1);
                model2.addRow(fila2);
                model2.addRow(fila3);
                model2.addRow(fila4);
                model2.addRow(fila5);
                model2.addRow(fila6);
                model2.addRow(fila7);
                model2.addRow(fila8);
                model2.addRow(fila9);
                model2.addRow(fila10);
                model2.addRow(fila11);
            }

            cn3.close();

        } catch (SQLException e) {
            System.err.println("Error al actualizar tabla de ciudades" + e);
        }

        Tabla_Ciudades.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = Tabla_Ciudades.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    ciudad_a_editar = model.getValueAt(fila_point, columna_point).toString();
                    EditarCiudad editar = new EditarCiudad();
                    editar.setVisible(true);
                }
            }
        });
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
        jScrollPane_Ciudades = new javax.swing.JScrollPane();
        Tabla_Ciudades = new javax.swing.JTable();
        jScrollPane_ActoresPoliticos = new javax.swing.JScrollPane();
        Tabla_ActoresPoliticos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton_PausarTurno = new javax.swing.JButton();
        jButton_DespausarTurno = new javax.swing.JButton();
        jButton_SiguienteTurno = new javax.swing.JButton();
        jButton_Reset = new javax.swing.JButton();
        jButton_Leyes_Economicas = new javax.swing.JButton();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_MinimoEstatusIndustria = new javax.swing.JButton();
        jLabel_Turno = new javax.swing.JLabel();
        jButton1_Editar_Turno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Independencia: el Megajuego!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jScrollPane_Ciudades.setEnabled(false);

        Tabla_Ciudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla_Ciudades.setEnabled(false);
        jScrollPane_Ciudades.setViewportView(Tabla_Ciudades);

        getContentPane().add(jScrollPane_Ciudades, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 190));

        Tabla_ActoresPoliticos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla_ActoresPoliticos.setEnabled(false);
        jScrollPane_ActoresPoliticos.setViewportView(Tabla_ActoresPoliticos);

        getContentPane().add(jScrollPane_ActoresPoliticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 300, 210));

        jLabel2.setText("Información Ciudades");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setText("Información Actores Políticos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jButton_PausarTurno.setText("Pausar Turno");
        jButton_PausarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PausarTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_PausarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, -1));

        jButton_DespausarTurno.setText("Despausar Turno");
        jButton_DespausarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DespausarTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_DespausarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, -1, -1));

        jButton_SiguienteTurno.setText("Siguiente Turno");
        jButton_SiguienteTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SiguienteTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_SiguienteTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, -1, -1));

        jButton_Reset.setText("Reset");
        getContentPane().add(jButton_Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, -1, -1));

        jButton_Leyes_Economicas.setText("Leyes Económicas");
        getContentPane().add(jButton_Leyes_Economicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));

        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        jButton_MinimoEstatusIndustria.setText("Estatus para Industria");
        jButton_MinimoEstatusIndustria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MinimoEstatusIndustriaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_MinimoEstatusIndustria, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 350, 150, -1));
        getContentPane().add(jLabel_Turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 90, 20));

        jButton1_Editar_Turno.setText("Editar Turno");
        jButton1_Editar_Turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_Editar_TurnoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_Editar_Turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        ActualizarTablaCiudades.Actualizar();
        ActualizarTurno();

    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_MinimoEstatusIndustriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MinimoEstatusIndustriaActionPerformed

        EditarEstatusParaIndustria actualizar_estatus = new EditarEstatusParaIndustria();
        actualizar_estatus.setVisible(true);

    }//GEN-LAST:event_jButton_MinimoEstatusIndustriaActionPerformed

    private void jButton_PausarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PausarTurnoActionPerformed

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "update otros set Bandera_Pausa_Ciudad = ? where ID = 1");
            pst.setInt(1, 0);
            pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al pausar juego gobernadores: " + e);
        }
        ActualizarTablaCiudades.Actualizar();

    }//GEN-LAST:event_jButton_PausarTurnoActionPerformed

    private void jButton_DespausarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DespausarTurnoActionPerformed

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "update otros set Bandera_Pausa_Ciudad = ? where ID = 1");
            pst.setInt(1, 1);
            pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al despausar juego gobernadores: " + e);
        }
        ActualizarTablaCiudades.Actualizar();

    }//GEN-LAST:event_jButton_DespausarTurnoActionPerformed

    private void jButton_SiguienteTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SiguienteTurnoActionPerformed

        //Paso 1. Tomar valores de ciudad y armar matriz
        try {
            Connection cn = Conexion.conectar();
            for (int i = 1; i <= 10; i++) {
                PreparedStatement pst = cn.prepareStatement(
                        "select * from gobernadores where ID = '" + i + "'");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    for (int j = 0; j < 5; j++) {
                        valores_ciudad[i - 1][j] = rs.getInt(j + 4);
                    }
                }
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al tomar recursos a enviar desde ciudad: " + e);
        }
        /*Imprimir matriz de valores de ciudad
        System.out.println("Matriz Ciudad");
        for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                    
                System.out.print("[ " + valores_ciudad[i][j] + "]");
                }
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");*/

        //Paso 2. Conseguir nivel de industria de todos.
        try {
            Connection cn = Conexion.conectar();
            for (int i = 1; i <= 10; i++) {
                PreparedStatement pst = cn.prepareStatement(
                        "select Nivel_de_Industria from gobernadores where ID ='" + i + "'");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    industria[i - 1] = rs.getInt("Nivel_de_Industria");
                }
            }
            cn.close();
        }catch (SQLException e) {
                System.err.println("Error al preguntar nivel de industria: " + e);
        }

        //Imprimir valor de vector industria
        /*for (int i = 0; i < 10; i++) {
            System.out.println("["+industria[i]+"}");
        }*/
        //Paso 3. Armar matriz de industria, a partir de nivel.
        valores_industria[0][0] = industria[0];
        valores_industria[1][1] = industria[1];
        valores_industria[2][4] = industria[2];
        valores_industria[3][4] = industria[3];
        valores_industria[4][1] = industria[4];
        valores_industria[5][3] = industria[5];
        valores_industria[6][0] = industria[6];
        valores_industria[7][3] = industria[7];
        valores_industria[8][2] = industria[8];
        valores_industria[9][2] = industria[9];

        /*Imprimir matriz de valores de industria
        System.out.println("Matriz Industria");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {

                System.out.print("[ " + valores_industria[i][j] + "]");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");*/
        //Paso 4. Sumar matriz de industria a la de recursos.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                valores_nuevos[i][j] = valores_industria[i][j] + valores_ciudad[i][j];
            }
        }

        /*Imprimir valores nuevos
        System.out.println("Matriz Sumada (Nueva)");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {

                System.out.print("[ " + valores_nuevos[i][j] + "]");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");*/
        //Paso 5. Actualizar valores ciudad (tabla gobernadores)
        try {
            
            Connection cn = Conexion.conectar();
            for (int i = 0; i < 10; i++) {
                PreparedStatement pst = cn.prepareStatement(
                        "update gobernadores set Caballos = ?, Vacas = ?, Hierro = ?, Vino = ?, Yerba = ? "
                        + "where ID = '" + (i + 1) + "'");

                pst.setInt(1, valores_nuevos[i][0]);
                pst.setInt(2, valores_nuevos[i][1]);
                pst.setInt(3, valores_nuevos[i][2]);
                pst.setInt(4, valores_nuevos[i][3]);
                pst.setInt(5, valores_nuevos[i][4]);
                pst.executeUpdate();
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al actualizar recursos de ciudad con los del nuevo turno(industria): " + e);
        }

        //Paso 6. Limpiar Unidades y Oficiales Reclutados
        try {
            Connection cn = Conexion.conectar();
            for (int i = 1; i <= 10; i++) {
                PreparedStatement pst = cn.prepareStatement(
                        "update gobernadores set Unidades_Reclutadas = ?, Oficiales_Reclutados = ? "
                        + "where ID = '" + i + "'");
                pst.setInt(1, 0);
                pst.setString(2, "Ninguno");
                pst.executeUpdate();
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al limpiar unidades y oficiales reclutados (siguiente turno, control general)");
        }

        //Paso 7. Nuevo turno.
        int turno = 0;
        try {
            Connection cn = new Conexion().conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from otros where ID = 1");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                turno = rs.getInt("Turno");
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al buscar turno en la base: " + e);
        }
        try {
            Connection cn = new Conexion().conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "update otros set Turno = ? where ID = 1");
            pst.setInt(1, turno + 1);
            pst.executeUpdate();

            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al cambiar el nuevo turno: " + e);
        }

        //Paso 8. Actualizar tablas y turno
        ActualizarTablaCiudades.Actualizar();
        ActualizarTurno();

    }//GEN-LAST:event_jButton_SiguienteTurnoActionPerformed

    private void jButton1_Editar_TurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_Editar_TurnoActionPerformed

        EditarTurno editar_turno = new EditarTurno();
        editar_turno.setVisible(true);
        ActualizarTablaCiudades.Actualizar();

    }//GEN-LAST:event_jButton1_Editar_TurnoActionPerformed

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
            java.util.logging.Logger.getLogger(ControlGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlGeneral().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_ActoresPoliticos;
    private javax.swing.JTable Tabla_Ciudades;
    private javax.swing.JButton jButton1_Editar_Turno;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_DespausarTurno;
    private javax.swing.JButton jButton_Leyes_Economicas;
    private javax.swing.JButton jButton_MinimoEstatusIndustria;
    private javax.swing.JButton jButton_PausarTurno;
    private javax.swing.JButton jButton_Reset;
    private javax.swing.JButton jButton_SiguienteTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Turno;
    private javax.swing.JScrollPane jScrollPane_ActoresPoliticos;
    private javax.swing.JScrollPane jScrollPane_Ciudades;
    // End of variables declaration//GEN-END:variables

    public void ActualizarTurno() {
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "select * from otros where ID = 1");
            ResultSet rs2 = pst2.executeQuery();

            while (rs2.next()) {
                jLabel_Turno.setText("Turno " + rs2.getString("Turno"));
            }

            cn2.close();
        } catch (SQLException e) {
            System.err.println("Error al actualizar turno " + e);
        }
    }

}
