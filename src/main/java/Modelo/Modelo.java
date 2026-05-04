/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Eduardo
 */
public class Modelo {
    private int idModelo;
    private String nombreModelo;
    private int anioModelo;
    private String fabricante;
    private int numeroCilindros;
    private int numeroPuertas;
    private double pesoKg;
    private int capacidadPasajeros;
    private String colorBase;
    private String paisFabricacion;
    
    public Modelo(int idModelo, String nombreModelo, int anioModelo, String fabricante,
                  int numeroCilindros, int numeroPuertas, double pesoKg,
                  int capacidadPasajeros, String colorBase, String paisFabricacion) {
        this.idModelo = idModelo;    
        this.nombreModelo = nombreModelo;
        this.anioModelo = anioModelo;
        this.fabricante = fabricante;
        this.numeroCilindros = numeroCilindros;
        this.numeroPuertas = numeroPuertas;
        this.pesoKg = pesoKg;
        this.capacidadPasajeros = capacidadPasajeros;
        this.colorBase = colorBase;
        this.paisFabricacion = paisFabricacion;
    }

    public Modelo(String nombreModelo, int anioModelo, String fabricante,
                  int numeroCilindros, int numeroPuertas, double pesoKg,
                  int capacidadPasajeros, String colorBase, String paisFabricacion) {
        this.nombreModelo = nombreModelo;
        this.anioModelo = anioModelo;
        this.fabricante = fabricante;
        this.numeroCilindros = numeroCilindros;
        this.numeroPuertas = numeroPuertas;
        this.pesoKg = pesoKg;
        this.capacidadPasajeros = capacidadPasajeros;
        this.colorBase = colorBase;
        this.paisFabricacion = paisFabricacion;
    }

    // Getters
   
    public int getIdModelo() { return idModelo; }
    public String getNombreModelo() { return nombreModelo; }
    public int getAnioModelo() { return anioModelo; }
    public String getFabricante() { return fabricante; }
    public int getNumeroCilindros() { return numeroCilindros; }
    public int getNumeroPuertas() { return numeroPuertas; }
    public double getPesoKg() { return pesoKg; }
    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public String getColorBase() { return colorBase; }
    public String getPaisFabricacion() { return paisFabricacion; }
}