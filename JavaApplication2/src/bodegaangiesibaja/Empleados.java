/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bodegaangiesibaja;

/**
 *
 * @author lica-
 */
public class Empleados {
    SqlConector con = new SqlConector();
    java.sql.Connection mCon = con.conectar();
    DbOperations operator = new DbOperations();
    String name;
    String contraseña;
    boolean autenticated;

    public Empleados() {
    }

    public Empleados(String name, String contraseña, boolean autenticated) {
        this.name = name;
        this.contraseña = contraseña;
        this.autenticated = autenticated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isAutenticated() {
        return autenticated;
    }

    public void setAutenticated(boolean autenticated) {
        this.autenticated = autenticated;
    }

    @Override
    public String toString() {
        return "Empleados{" + "name=" + name + ", contrase\u00f1a=" + contraseña + ", autenticated=" + autenticated + '}';
    }
    
    
}
