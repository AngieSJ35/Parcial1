/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bodegaangiesibaja;

import java.util.TreeMap;

/**
 *
 * @author ESTUDIANTE
 */
public class Productos {
    
    SqlConector con = new SqlConector();
    java.sql.Connection mCon = con.conectar();
    DbOperations operator = new DbOperations();
    String name;
    int value;
    int stock;
    boolean available;
    
        public Productos() {
       
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
        public Productos(String name, int value, int stock, boolean available) {
        this.name = name;
        this.value = value;
        this.stock = value;
        this.available = available;        
    }
    
    public void guardar(String name, int value,int stock,boolean available){

        operator.guardar(mCon, name, value, stock, available);
        
    }
    
    public TreeMap consultar(String name, int value,int stock,boolean available){

        TreeMap productos = operator.consultar(mCon, "productos");
        return productos;
    }
    
    @Override
    public String toString() {
        return "Productos [nombre=" + name + ", precio=" + value + ", cantidad=" + stock + ", disponible=" + available + "]";
    }
}
