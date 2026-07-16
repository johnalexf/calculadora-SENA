/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.modelo;

import java.util.function.BiFunction;

/**
 *
 * @author johna
 */
public class Operador {
    
    private final String nombre;
    private final int cantOperandos;
    private final int prioridad;
    private final BiFunction<Double, Double, Double> funcion;
    
    //Constructor
    public Operador(
            String nombre, 
            int cantOperandos, 
            int prioridad,
            BiFunction<Double, Double, Double> funcion) {
        this.nombre = nombre;
        this.cantOperandos = cantOperandos;
        this.prioridad = prioridad;
        this.funcion = funcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantOperandos() {
        return cantOperandos;
    }

    public int getPrioridad() {
        return prioridad;
    }
    
    public double calcular(double num1, double num2) {
        return funcion.apply(num1,num2);
    }
      
    
    
}
