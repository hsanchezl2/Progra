/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestoreventosboletos;

/**
 *
 * @author PC
 */
public class Asiento {
    private String fila;
    private int numero;
    private boolean disponible;
    private double precio;
    private String seccion;
    private String nombre;
    private int numeroBoleto;

    // Constructor
    public Asiento(String fila, int numero, boolean disponible, double precio, String seccion) {
        this.fila = fila;
        this.numero = numero;
        this.disponible = disponible;
        this.precio = precio;
        this.seccion = seccion;
    }

    Asiento(String nombre, int i, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Métodos getters y setters
    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNombreCliente() {
        return nombre;
    }

    public void setNombreCliente(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(int numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    // Método para reservar el asiento
    public void reservar(String nombreCliente, int numeroBoleto) {
        disponible = false;
        this.nombre = nombreCliente;
        this.numeroBoleto = numeroBoleto;
    }

    // Método para liberar el asiento
    public void liberar() {
        disponible = true;
        nombre = null;
        numeroBoleto = 0;
    }

    // Método para obtener el estado del asiento
    public String getEstado() {
        if (disponible) {
            return "Disponible";
        } else if (nombre != null) {
            return "Reservado por " + nombre;
        } else {
            return "Ocupado";
        }
    }

    String getnombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getBoleto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getLetra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getCorrelativo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setBoleto(Boleto boleto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
