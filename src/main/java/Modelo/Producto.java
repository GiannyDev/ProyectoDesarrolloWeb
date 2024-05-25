/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author piero
 */
public class Producto {
    private String id_producto;
    private String nom_producto;
    private double monto_producto;
    private String des_producto;
    private int cant_producto;
    private String id_tipo_producto;
    private String ruta_imagen;

    public Producto(String id_producto, String nom_producto, double monto_producto, String id_tipo_producto, String ruta_imagen) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.monto_producto = monto_producto;
        this.id_tipo_producto = id_tipo_producto;
        this.ruta_imagen = ruta_imagen;
    }
    
    public Producto() {
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public double getMonto_producto() {
        return monto_producto;
    }

    public void setMonto_producto(double monto_producto) {
        this.monto_producto = monto_producto;
    }

    public String getDes_producto() {
        return des_producto;
    }

    public void setDes_producto(String des_producto) {
        this.des_producto = des_producto;
    }

    public int getCant_producto() {
        return cant_producto;
    }

    public void setCant_producto(int cant_producto) {
        this.cant_producto = cant_producto;
    }

    public String getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(String id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }
    
    
}
