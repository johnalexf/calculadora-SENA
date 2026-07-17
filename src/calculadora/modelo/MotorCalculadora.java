/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author johna
 */
public class MotorCalculadora {
    
   private final Map<String, Operador> operadoresValidos;
   private final int prioridadAlta = 2;

   public MotorCalculadora(){
       operadoresValidos = new HashMap<>();
       //operadoresValidos.put( "simbolo del operador" , 
       //      new Operador ( "nombre del simbolo" , cantidad operandos, prioridad operacion, funcion que representa la operacion )
       operadoresValidos.put( "+",
               new Operador( "suma" , 2 , 1 , (a,b)-> a + b )  );
       operadoresValidos.put( "-", 
               new Operador("resta", 2, 1, (a,b)-> a - b ));
       operadoresValidos.put( "X", 
               new Operador("multiplicacion", 2, 2, (a,b)-> a * b ));
       operadoresValidos.put( "/", 
               new Operador("division", 2, 2, (a,b)-> a / b ));
   
   }
   
   public boolean validarOperador(String simbolo){  
       return operadoresValidos.containsKey(simbolo);
   }
   
   public double calcularExpresion(double num1,
                                    double num2,
                                    String simbolo) {

        Operador operador = operadoresValidos.get(simbolo);

        if (operador == null) {
            throw new IllegalArgumentException("Operador no válido");
        }

        return operador.calcular(num1, num2);
    }

    public int getPrioridadAlta() {
        return prioridadAlta;
    }
    
    public List<String> obtenerSimbolosIgualPrioridad(int prioridad){

        List<String> simbolos = new ArrayList<>();

        // Se utiliza Map.Entry para representar una única entrada (clave, valor) de un Map.
        // entrySet() devuelve todas las entradas del Map para poder recorrerlas con un foreach.
        for(Map.Entry<String, Operador> entrada : operadoresValidos.entrySet()){

            if(entrada.getValue().getPrioridad() == prioridad){
                simbolos.add(entrada.getKey());
            }

        }

        return simbolos;
    }
   
   
     
}
