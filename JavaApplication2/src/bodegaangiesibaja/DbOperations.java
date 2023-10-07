/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bodegaangiesibaja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TreeMap;
import java.sql.ResultSet;
import java.util.Map;


/**
 *
 * @author ESTUDIANTE
 */
public class DbOperations {
    
        
        public void guardar(Connection conexion, String name,
                int value,int stock,boolean available){
        try {
 
        PreparedStatement consulta;
        
        consulta = conexion.prepareStatement("INSERT INTO productos" + 
                "(Nombre,Valor,Cantidad,Disponible) VALUES(?,?,?,?)");
        
        
        consulta.setString(1, name);
        consulta.setInt(2, value);
        consulta.setInt(3, stock);
        consulta.setBoolean(4, available);
        
        
        consulta.executeUpdate();
        
        System.out.println("Escritura exitosa");
        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
        

public TreeMap<Integer, Productos> consultar(Connection conexion, String table) {
    TreeMap<Integer, Productos> registros = new TreeMap<>();

    try {
        PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + table);
        ResultSet resultSet = consulta.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id"); // Supongamos que la columna "id" es la clave
            String name = resultSet.getString("Nombre");
            int value = resultSet.getInt("Valor");
            int stock = resultSet.getInt("Cantidad");
            boolean available = resultSet.getBoolean("Disponible");

            // Crear un objeto Productos con los datos obtenidos
            Productos producto = new Productos(name, value, stock, available);

            // Agregar el objeto Productos al TreeMap con la clave id
            registros.put(id, producto);
        }


        System.out.println("Consulta exitosa");

    } catch (SQLException e) {
        System.out.println(e);
    }

    return registros;
}

public TreeMap<Integer, Empleados> consultarEmpleados(Connection conexion, String table) {
    TreeMap<Integer, Empleados> registros = new TreeMap<>();

    try {
        PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + table);
        ResultSet resultSet = consulta.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id"); // Supongamos que la columna "id" es la clave
            String name = resultSet.getString("name");
            String contraseña = resultSet.getString("contraseña");
            boolean autenticated = resultSet.getBoolean("autenticated");
            

            // Crear un objeto Productos con los datos obtenidos
            Empleados empleado = new Empleados(name, contraseña, autenticated);

            // Agregar el objeto Productos al TreeMap con la clave id
            registros.put(id, empleado);
        }


        System.out.println("Consulta exitosa");

    } catch (SQLException e) {
        System.out.println(e);
    }

    return registros;
}
}
