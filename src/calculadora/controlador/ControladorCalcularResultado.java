/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.controlador;

import calculadora.modelo.AnalizadorSentencia;
import calculadora.modelo.MotorCalculadora;
import calculadora.vista.VentanaCalculadora;

/**
 *
 * @author johna
 */
public class ControladorCalcularResultado {
    
    private VentanaCalculadora vista;
    private AnalizadorSentencia analizador;

    public ControladorCalcularResultado(VentanaCalculadora vista, AnalizadorSentencia analizador) {
        this.vista = vista;
        this.analizador = analizador;
    }
    
    public void calcularResultado(){
        String entradaDatoPantalla = vista.obtenerEntradaPantalla();
        System.out.println(entradaDatoPantalla);
        System.out.println( analizador.esSentenciaValida(entradaDatoPantalla) );
    }
    
}
