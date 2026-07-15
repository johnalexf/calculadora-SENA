/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import calculadora.controlador.controladorEntradaPantalla;
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
        VentanaCalculadora ventanaPrincipal = new VentanaCalculadora();
        
        //Instanciar el controlador Entrada pantalla pasandole como argumento la ventana principal
        //Para que este pueda acceder a la informacion escrita por el usuario en el campo de texto
        controladorEntradaPantalla controladorEntradaPantalla = new controladorEntradaPantalla(ventanaPrincipal);
        
        //Asignar el valor del controlador entrada principal para que la vista pueda reportar cuando un boton se ha oprimido
        ventanaPrincipal.setControladorEntradaPantalla(controladorEntradaPantalla);
        
        //Poner visible en pantalla la ventana principal
        ventanaPrincipal.setVisible(true);
    }
    
}
