/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.modelo;

/**
 *
 * @author johna
 */
public class Operador {
    
    private String nombre;
    private String simbolo;
    private int cantOperandos;
    private int prioridad;
    
    //Constructor
    public Operador(String nombre, String simbolo, int cantOperandos, int prioridad) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.cantOperandos = cantOperandos;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getCantOperandos() {
        return cantOperandos;
    }

    public int getPrioridad() {
        return prioridad;
    }
    
    
    
    
}
