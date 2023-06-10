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
public class GestorEventos {
    private ArrayList<Evento> eventos;
    private ArrayList<Usuario> usuarios;
    private String nombreFila;

    // Constructor
    public GestorEventos() {
        this.eventos = new ArrayList<Evento>();
        this.usuarios = new ArrayList<Usuario>();
    }

    // Métodos getters y setters
    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    // Métodos para agregar eventos y usuarios
    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Métodos para buscar eventos y usuarios
    public Evento buscarEvento(String nombreEvento) {
        for (Evento evento : eventos) {
            if (evento.getnombre().equals(nombreEvento)) {
                return evento;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    // Métodos para generar reportes
    public void generarListadoEventos() {
        for (Evento evento : eventos) {
            System.out.println("Nombre: " + evento.getnombre());
            System.out.println("Fecha de inicio: " + evento.getFechaInicio());
            System.out.println("Fecha de fin: " + evento.getFechaFin());
        }
    }

    public void generarListadoBoletos(Evento evento) {
        int boletosVendidos = 0;
        int boletosDisponibles = 0;
        for (Seccion seccion : evento.getSecciones()) {
            for (Fila fila : seccion.getFilas(nombreFila)) {
                for (Asiento asiento : fila.getAsientos()) {
                    if (asiento.isDisponible()) {
                        boletosDisponibles++;
                    } else {
                        boletosVendidos++;
                    }
                }
            }
        }
        System.out.println("Boletos vendidos: " + boletosVendidos);
        System.out.println("Boletos disponibles: " + boletosDisponibles);
    }

    public void generarDetalleBoletos(Evento evento) {
        for (Seccion seccion : evento.getSecciones()) {
            System.out.println("Sección: " + seccion.getnombre());
            for (Fila fila : seccion.getFilas(nombreFila)) {
                System.out.println("Fila: " + fila.getnombre());
                for (Asiento asiento : fila.getAsientos()) {
                    if (asiento.isDisponible()) {
                        System.out.println("Asiento " + asiento.getnombre() + " disponible");
                    } else {
                       
                        System.out.println("Asiento " + asiento.getnombre() + " ocupado por " + asiento.getnombre());
                    }
                }
            }
        }
    }

    public void generarListadoUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println("Nombre de usuario: " + usuario.getNombreUsuario());
            System.out.println("Rol: " + usuario.getRol());
            System.out.println("Estado: " + usuario.isEstado());
        }
    }

    public Boleto consultarBoleto(String numeroBoleto, Iterable<com.mycompany.gestoreventosboletos.Fila> buscarFila) {
        for (Evento evento : eventos) {
            for (Seccion seccion : evento.getSecciones()) {
                com.mycompany.gestoreventosboletos.Fila nombreFila = null;
                for (Fila fila : buscarFila) {
                    for (Asiento asiento : fila.getAsientos()) {
                        if (asiento.getBoleto().equals(numeroBoleto) && !asiento.isDisponible()) {
                            return (Boleto) asiento.getBoleto();
                        } else {
                        }
                    }
                }
            }
        }
        return null;
    }
    //método vende un boleto para un asiento específico en una fila y sección específicas.
    public void venderBoleto(String nombreEvento, String nombreSeccion, String nombreFila, int numeroAsiento, Boleto boleto) {
    Evento evento = buscarEvento(nombreEvento);
    if (evento != null) {
        Seccion seccion = evento.buscarSeccion(nombreSeccion);
        if (seccion != null) {
            Fila fila = seccion.agregarFila(nombreFila);
            if (fila != null) {
                Asiento asiento = fila.buscarAsiento(numeroAsiento);
                if (asiento != null && asiento.isDisponible()) {
                    asiento.setDisponible(false);
                    asiento.setBoleto(boleto);
                }
            }
        }
    }
}
//método cancela la venta de un boleto para un asiento específico en una fila y sección específicas
public void cancelarBoleto(String nombreEvento, String nombreSeccion, String nombreFila, int numeroAsiento) {
    Evento evento = buscarEvento(nombreEvento);
    if (evento != null) {
        Seccion seccion = evento.buscarSeccion(nombreSeccion);
        if (seccion != null) {
            var Fila = seccion.getFilas(nombreFila);
            if (Fila != null) {
                Asiento asiento = Fila(numeroAsiento);
                if (asiento != null && !asiento.isDisponible()) {
                    asiento.setDisponible(true);
                    asiento.setBoleto(null);
                }
            }
        }
    }
}
//método agrega una sección a un evento específico
public void agregarSeccion(String nombreEvento, Seccion seccion) {
    Evento evento = buscarEvento(nombreEvento);
    if (evento != null) {
        evento.agregarSeccion(seccion);
    }
}
//método agrega una fila a una sección específica de un evento específico.
public void agregarFila(String nombreEvento, String nombreSeccion, Fila fila) {
    Evento evento = buscarEvento(nombreEvento);
    if (evento != null) {
        Seccion seccion = evento.buscarSeccion(nombreSeccion);
        if (seccion != null) {
            seccion.agregarFila(fila);
        }
    }
}

    private Asiento Fila(int numeroAsiento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
