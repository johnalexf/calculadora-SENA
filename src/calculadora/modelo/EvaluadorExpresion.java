/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.modelo;

import java.util.List;

/**
 *
 * @author johna
 */
public class EvaluadorExpresion {
    
    private MotorCalculadora motor;

    public EvaluadorExpresion(MotorCalculadora motor) {
        this.motor = motor;
    }
    
    public String evaluarExpresion( List<String> expresion){
    
        return expresion.toString();
    }
    
    
    
}
