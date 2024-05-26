/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author piero
 */
public class Cliente { 
    private String dni_cliente;
    private String nom_cliente;
    private String ape_cliente;
    private int edad_cliente;
    private String telf_cliente;

    public Cliente(String dni_cliente, String nom_cliente, String ape_cliente, int edad_cliente, String telf_cliente) {
        this.dni_cliente = dni_cliente;
        this.nom_cliente = nom_cliente;
        this.ape_cliente = ape_cliente;
        this.edad_cliente = edad_cliente;
        this.telf_cliente = telf_cliente;
    }

    public Cliente() {
    }
    
    public String getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(String dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getApe_cliente() {
        return ape_cliente;
    }

    public void setApe_cliente(String ape_cliente) {
        this.ape_cliente = ape_cliente;
    }

    public int getEdad_cliente() {
        return edad_cliente;
    }

    public void setEdad_cliente(int edad_cliente) {
        this.edad_cliente = edad_cliente;
    }

    public String getTelf_cliente() {
        return telf_cliente;
    }

    public void setTelf_cliente(String telf_cliente) {
        this.telf_cliente = telf_cliente;
    }
    
    
}
