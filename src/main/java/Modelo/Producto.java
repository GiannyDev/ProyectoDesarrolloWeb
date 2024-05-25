/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.DecimalFormat;

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
    private boolean oferta_producto;
    private double descuento;
    private int dia;
    private int mes;
    private int anio;

    public Producto(String id_producto, String nom_producto, double monto_producto, String id_tipo_producto, String ruta_imagen) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.monto_producto = monto_producto;
        this.id_tipo_producto = id_tipo_producto;
        this.ruta_imagen = ruta_imagen.toUpperCase().charAt(0) + ruta_imagen.substring(1,ruta_imagen.length());
    }
    
    public Producto(String id_producto, String nom_producto, int cant_producto) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.cant_producto = cant_producto;
    }

    public Producto(String id_producto, String nom_producto, double monto_producto) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.monto_producto = monto_producto;
    }
    
    public Producto() {
    }
    
    public void Oferta(boolean oferta_producto, double descuento, int dia, int mes, int anio) {
        this.oferta_producto = oferta_producto;
        this.descuento = descuento;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
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
        this.ruta_imagen = ruta_imagen.toUpperCase().charAt(0) + ruta_imagen.substring(1,ruta_imagen.length());
    }

    public boolean isOferta_producto() {
        return oferta_producto;
    }

    public void setOferta_producto(boolean oferta_producto) {
        this.oferta_producto = oferta_producto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public String mostrarPagina(){
        DecimalFormat df = new DecimalFormat("0.00");
        String pag = null;
        if (!oferta_producto) {
            pag = "<div style='display: flex; justify-content: center; margin: 35px 0 '>"
                    + "<div class='mitad_pantalla_producto'><img style='object-fit: contain;width: 350px; height: 350px;' src='" + ruta_imagen + "' ></div>"
                    + "<div class='mitad_pantalla_producto'>"
                        + "<div class='titulo_producto'>" + nom_producto + "</div>"
                        + "<div class='precio_producto'> S/ "+ df.format(monto_producto) +"</div>"
                        + "<div class='letras_producto_sm'>" + des_producto  +"</div>"
                        + "<input class='boton_naranja_producto' type='button' value='Agregar Carrito'>"
                    + "</div>"
                + "</div>";
        } else {
            double precio = (monto_producto * (100-descuento))/100;
            pag = "<div style='display: flex; justify-content: center; margin: 35px 0 '>"
                    + "<div class='mitad_pantalla_producto'><img style='object-fit: contain;width: 350px; height: 350px;' src='" + ruta_imagen + "'></div>"
                    + "<div class='mitad_pantalla_producto'>"
                        + "<div class='franja_roja'>Oferta Limitada &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Termina el " + formatoFecha() + "</div>"
                        + "<div class='titulo_producto'>" + nom_producto + "aaa </div>"
                        + "<div style='display: flex; align-items: center;'>"
                            + "<div class='precio_producto_rojo'> S/ " + df.format(precio) + "</div>"
                            + "<div class='precio_producto_sm' style='margin-left: 20px;'><del>S/ "+ df.format(monto_producto) +"</del></div>"
                        + "</div>"
                        + "<div class='letras_producto_sm'>"+des_producto+"</div>"
                        + "<input class='boton_naranja_producto' type='button' value='Agregar Carrito'>"
                    + "</div>"
                + "</div>";
        }
        return pag;
    }

    public String formatoFecha(){
        String formated = dia+"/"+mes+"/"+anio;
        return formated;
    }
}
