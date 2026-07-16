/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import calculadora.controlador.ControladorCalcularResultado;
import calculadora.controlador.ControladorEntradaPantalla;
import calculadora.modelo.AnalizadorSentencia;
import calculadora.modelo.MotorCalculadora;
import calculadora.vista.VentanaCalculadora;

/**
 *
 * @author JOHN FORERO
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Instanciar la vista principal que va ver el usuario
        VentanaCalculadora vista = new VentanaCalculadora();
        
        //Instanciar el motor
        MotorCalculadora motor = new MotorCalculadora();
        AnalizadorSentencia analizador = new AnalizadorSentencia(motor);
        
        //Instanciar los controladores Entrada pasandole como argumento la ventana principal
        //Para que estos pueda acceder a los campos de texto entradaDatoPantalla y salidaDatoSolucion
        //Asignar las instancias de los controladores para que la vista pueda reportar cuando un boton se ha oprimido   
        vista.setControladores(
                new ControladorEntradaPantalla( vista ), 
                new ControladorCalcularResultado( vista, analizador)
        );
        
        //Poner visible en pantalla la ventana principal
        vista.setVisible(true);
    }
    
}
