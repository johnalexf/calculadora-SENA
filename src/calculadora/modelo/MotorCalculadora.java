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
    
   private final List<Operadores> operadoresValidos;
   
   public MotorCalculadora(){
       operadoresValidos = new ArrayList<>();
       operadoresValidos.add(new Operadores("suma", "+", 2, 1));
       operadoresValidos.add(new Operadores("resta", "-", 2, 1));
       operadoresValidos.add(new Operadores("multiplicacion", "X", 2, 2));
       operadoresValidos.add(new Operadores("division", "/", 2, 2));
   
   }
    
}
