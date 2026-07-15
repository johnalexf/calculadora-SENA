/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.modelo;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author johna
 */
public class MotorCalculadora {
    
   private final List<Operador> operadoresValidos;
   
   public MotorCalculadora(){
       operadoresValidos = new ArrayList<>();
       operadoresValidos.add(new Operador("suma", "+", 2, 1));
       operadoresValidos.add(new Operador("resta", "-", 2, 1));
       operadoresValidos.add(new Operador("multiplicacion", "X", 2, 2));
       operadoresValidos.add(new Operador("division", "/", 2, 2));
   
   }
   
   public boolean validarOperador(String operadorAValidar){
       
       for(Operador operador : this.operadoresValidos){
           if(operador.getSimbolo().equals(operadorAValidar))
               return true;
       }
       return false;
       
   }
    
}
