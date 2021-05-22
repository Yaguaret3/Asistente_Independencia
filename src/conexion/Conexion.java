
package conexion;
import java.sql.*;

public class Conexion {
   
    public static Connection conectar(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/pruebaindependencia", "root", "");
            return cn;
            
        } catch (SQLException e) {
            System.out.println("Error al buscar base de datos" + e);
        }
        return (null);
    }
}
