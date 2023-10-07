/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bodegaangiesibaja;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ESTUDIANTE
 */
public class SqlConector {
    
    private static java.sql.Connection con;
    
    public static String driver  = "com.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "root";
    public static String url = "jdbc:mysql://localhost:3306/bodega";
    
    public java.sql.Connection conectar(){
        
        con = null;
        try {

            con =  DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Conexión no exitosa");
        }
        
        return con;
        
    }
    
    
}
