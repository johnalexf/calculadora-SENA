/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.controlador;

import calculadora.vista.VentanaCalculadora;

/**
 *
 * @author johna
 */
public class ControladorEntradaPantalla {
    
    //Variable para guardar la referencia de la vista de la calculadora
     private VentanaCalculadora vista; 

    // El constructor recibe la vista VentanaCalculadora y la guarda
    public ControladorEntradaPantalla(VentanaCalculadora vista) {
        this.vista = vista;
    }
    
    // Función que agregara la entrada de datos
    public void agregarEntradaBotonAPantalla(String valorPulsado) {
        // Le preguntamos a la vista qué texto tiene actualmente
        String textoActual = vista.obtenerEntradaPantalla();
        
        // Unimos el texto viejo con el nuevo número que pulsaron
        String nuevoTexto = textoActual + valorPulsado;
        
        // Le ordenamos a la vista que dibuje el nuevo texto completo
        vista.actualizarEntradaPantalla(nuevoTexto);
    }
     
}

