/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bodegaangiesibaja;

import java.util.TreeMap;
import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author ESTUDIANTE
 */
public class BodegaAngieSibaja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bienvenido:");
        
        inicio();
    }
    
    private static void inicio() {
        Scanner s = new Scanner(System.in);
    SqlConector con = new SqlConector();
        java.sql.Connection mCon = con.conectar();
        DbOperations operator = new DbOperations();
        TreeMap employees = operator.consultarEmpleados(mCon, "empleados");
        System.out.println("1. Ingresa tu nombre");
        String name = s.next();
        Empleados empleado = buscarPorNombreEmpleado(employees,name);
        if(empleado != null && empleado.isAutenticated()){
            autenticated();
        } else if(empleado != null) {
            nonAutenticated();
        } else {
            System.out.println("No existe un empleado con ese nombre");
        }
    }

    private static void autenticated() {
        Scanner s = new Scanner(System.in);
        System.out.println("Estas autenticado");
        System.out.println("¿Que deseas hacer?");
        System.out.println("1. Ingresar producto");
        System.out.println("2. Consultar productos");
        //2. Almacenar opción en una variable
        String numero = String.valueOf(s.nextInt());
        //3. Validar opción del usuario
        if("1".equals(numero)){
            System.out.println("A continuación podras ingresar un nuevo producto");
            Productos producto = new Productos();
            System.out.println("1. Ingresa el nombre del producto");
            String name = s.next();
            System.out.println("1. Ingresa el valor del producto");
            int value = s.nextInt();
            System.out.println("1. Ingresa la cantidad del producto");
            int stock = s.nextInt();
            producto.guardar(name, value, stock, true);
        } else if("2".equals(numero)){
            System.out.println("Consulta de productos");
            SqlConector con = new SqlConector();
        java.sql.Connection mCon = con.conectar();
        DbOperations operator = new DbOperations();
        TreeMap productos = operator.consultar(mCon, "productos");
        System.out.println(productos);
        } else {
            System.out.println("Opción no valida");
        }
        //3. Imprimir número de cédula ingresado
        //System.out.println("El número de cédula ingresado es: " + numero);
    }
    
    private static void nonAutenticated() {
        Scanner s = new Scanner(System.in); 
        //1. advierte al usuario
        System.out.println("No estas autenticado");
        System.out.println("Digite opción.");
        System.out.println("1. Autenticarme");
        System.out.println("2. Salir");
        //2. Almacenar opción en una variable
        String numero = String.valueOf(s.nextInt());
        //3. Validar opción del usuario
        if("1".equals(numero)){
            System.out.println("A continuación podras ingresar");
            System.out.println("1. Ingresa tu nombre");
            String name = s.next();
            System.out.println("1. Ingresa tu contraseña");
            String contraseña = s.next();
            
        } else if("2".equals(numero)){
            System.out.println("Ejecuto opción 2");
        } else {
            System.out.println("Opción no valida");
        }
        //3. Imprimir número de cédula ingresado
        //System.out.println("El número de cédula ingresado es: " + numero);
    }
    
    public static Productos buscarPorNombreProductos(TreeMap<Integer, Productos> productosTreeMap, String nombre) {
    for (Map.Entry<Integer, Productos> entry : productosTreeMap.entrySet()) {
        Productos producto = entry.getValue();
        if (producto.getName().equals(nombre)) {
            // Se encontró un producto con el nombre deseado
            return producto;
        }
    }
    // Si no se encontró el producto, puedes retornar null o lanzar una excepción.
    return null;
}
    
        public static Empleados buscarPorNombreEmpleado(TreeMap<Integer, Empleados> productosTreeMap, String nombre) {
    for (Map.Entry<Integer, Empleados> entry : productosTreeMap.entrySet()) {
        Empleados empleado = entry.getValue();
        if (empleado.getName().equals(nombre)) {
            return empleado;
        }
    }
    return null;
}
}
