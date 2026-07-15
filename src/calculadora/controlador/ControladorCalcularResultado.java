/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.controlador;

import calculadora.modelo.MotorCalculadora;
import calculadora.vista.VentanaCalculadora;

/**
 *
 * @author johna
 */
public class ControladorCalcularResultado {
    
    private VentanaCalculadora vista;
    private MotorCalculadora motorCalculadora;

    public ControladorCalcularResultado(VentanaCalculadora vista, MotorCalculadora motorCalculadora) {
        this.vista = vista;
        this.motorCalculadora = motorCalculadora;
    }
    
    public void calcularResultado(){
        String entradaDatoPantalla = vista.obtenerEntradaPantalla();
        System.out.println(entradaDatoPantalla);
    }
    
}
