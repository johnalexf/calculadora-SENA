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
    
    public String evaluarExpresion( List<String> expresion ){
        
        int prioridadAEvaluar = motor.getPrioridadAlta();
        
        while(prioridadAEvaluar != 0){
            
            List<String> simbolosAEvaluar = motor.obtenerSimbolosIgualPrioridad(prioridadAEvaluar);

            double resultadoOperacion;

            for(String simbolo: simbolosAEvaluar){
                while(expresion.contains(simbolo)){
                    int indice = expresion.indexOf(simbolo);
                    resultadoOperacion = motor.calcularExpresion( 
                                                    Double.parseDouble(expresion.get(indice-1)) , 
                                                    Double.parseDouble(expresion.get(indice+1)) , 
                                                    simbolo
                    );
                    expresion.set(
                            indice-1,
                            String.valueOf(resultadoOperacion)
                    );
                    expresion.remove(indice+1);
                    expresion.remove(indice);
                }
            }
            
            prioridadAEvaluar--;
        }
        
        
        
        return expresion.get(0);
    }
    
    
    
}
