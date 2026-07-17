/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.controlador;

import calculadora.modelo.AnalizadorSentencia;
import calculadora.modelo.EvaluadorExpresion;
import calculadora.vista.VentanaCalculadora;

/**
 *
 * @author johna
 */
public class ControladorCalcularResultado {
    
    private VentanaCalculadora vista;
    private AnalizadorSentencia analizador;
    private EvaluadorExpresion evaluador;

    public ControladorCalcularResultado(
            VentanaCalculadora vista, 
            AnalizadorSentencia analizador,
            EvaluadorExpresion evaluador
        ) {
        
        this.vista = vista;
        this.analizador = analizador;
        this.evaluador = evaluador;
    }
    
    public void calcularResultado(){
        String entradaDatoPantalla = vista.obtenerEntradaPantalla();
        try {
            if( analizador.esSentenciaValida(entradaDatoPantalla) ){
                vista.actualizarSalidaSolucion(
                        evaluador.evaluarExpresion(  
                                analizador.getSentenciaDescompuesta() 
                        )
                );
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
    
}
