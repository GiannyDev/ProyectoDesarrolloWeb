/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Christina
 */
public class Boleta_Cliente {
    private int edad_cliente;
    private double monto_tot;

    public Boleta_Cliente(int edad_cliente, double monto_tot) {
        this.edad_cliente = edad_cliente;
        this.monto_tot = monto_tot;
    }
  
    
    public int getEdad_cliente() {
        return edad_cliente;
    }

    public void setEdad_cliente(int edad_cliente) {
        this.edad_cliente = edad_cliente;
    }

    public double getMonto_tot() {
        return monto_tot;
    }

    public void setMonto_tot(double monto_tot) {
        this.monto_tot = monto_tot;
    }
    
    
}
