/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestoreventosboletos;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Comprador {
   private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private ArrayList<Boleto> boletos;

    // Constructor
    public Comprador(String nombre, String apellido, String email, String telefono, ArrayList<Boleto> boletos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.boletos = boletos;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(ArrayList<Boleto> boletos) {
        this.boletos = boletos;
    }
    public void agregarBoleto(Boleto boleto) {
    this.boletos(boleto);
}
    //Método agrega un boleto a la lista de boletos del comprador
    private void boletos(Boleto boleto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //método elimina un boleto de la lista de boletos del comprado
    public void eliminarBoleto(Boleto boleto) {
    boletos.remove(boleto);
}
    //Método imprime la información de todos los boletos del comprador en la consola
    public void imprimirBoletos() {
    for (Boleto boleto : boletos) {
        boleto.imprimirBoleto();
        System.out.println("--------------------");
    }
}
    //Método que calcula el total gastado por el comprador en boletos
    public double calcularTotalGastado() {
    double totalGastado = 0;
    for (Boleto boleto : boletos) {
        totalGastado += boleto.calcularPrecioTotal();
    }
    return totalGastado;
}
} 

