package conexion;

import interfaces.*;
import static interfaces.ControlGeneral.model2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ActualizarTablaCiudades {

    public static void Actualizar() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from gobernadores");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ControlGeneral.model.removeRow(0);
                Object[] fila = new Object[10];

                for (int i = 0; i < 10; i++) {
                    fila[i] = rs.getObject(i + 2);
                }
                ControlGeneral.model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al actualizar tabla de ciudades" + e);
        }
        try {
            Connection cn3 = Conexion.conectar();
            PreparedStatement pst3 = cn3.prepareStatement(
                    "select * from actorespoliticos where ID = 1");
            ResultSet rs3 = pst3.executeQuery();
            
            

            while (rs3.next()) {

                for(int i = 0; i < 11; i++){
                    model2.removeRow(0);
                }
                                
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
        }catch (SQLException e) {
            System.err.println("Error al actualizar tabla de actores políticos: " + e);
        }

        }
    
}
