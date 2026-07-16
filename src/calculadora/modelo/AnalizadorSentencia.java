/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author johna
 */
public class AnalizadorSentencia {
    
    private List<String> sentenciaDescompuesta = new ArrayList<>();
    private MotorCalculadora motor;

    public AnalizadorSentencia(MotorCalculadora motor) {
        this.motor = motor;
    }
    
    public boolean esSentenciaValida(String sentencia){
    
        sentenciaDescompuesta.clear();
        
        if(!sentencia.isBlank()){
            
            try {
                descomponerSentencia(sentencia);
                System.out.println(Arrays.toString(sentenciaDescompuesta.toArray()));
                return true;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                 return false;
            }
            
        }else{
            System.err.print("Error la sentencia no puede estar vacia");
            return false;
        }
        
    }
    
    public void descomponerSentencia(String sentencia) throws Exception{
        
        if( esDigito(sentencia.charAt(0)) ){

            if(sentencia.length()>1){
                StringBuilder acumuladorComponente = new StringBuilder("");
                acumuladorComponente.append(sentencia.charAt(0));

                for( int i=1 ; i < (sentencia.length()-1); i++){

                    if(  esDigitoOComa(sentencia.charAt(i))  ){
                        acumuladorComponente.append(sentencia.charAt(i));
                    }else{
                        guardarNumeroYOPerador(
                                acumuladorComponente.toString(), 
                                String.valueOf(sentencia.charAt(i))
                        );
                        acumuladorComponente.setLength(0);
                    }

                }

                if( esDigito( sentencia.charAt(sentencia.length()-1) ) ){
                    acumuladorComponente.append(sentencia.charAt(sentencia.length()-1));
                    guardarComponente(acumuladorComponente.toString());
                }else{
                     throw new Exception( " Error la sentencia debe terminar con numero " );
                }
            }else{
                guardarComponente(
                        String.valueOf(sentencia.charAt(0))
                );
            }
            
        }else{
                throw new Exception( " El primer digito tiene que ser un numero " );
        }

    }
    
    public void guardarComponente (String componente){
        sentenciaDescompuesta.add(componente);
    }
    
    public void guardarNumeroYOPerador(String numero, String operador){
        guardarComponente(numero);
        guardarComponente(operador);
    }
    
    public boolean esDigitoOComa(char evaluante){
       return ( esDigito(evaluante) || evaluante == ',' );
    }
    
    public boolean esDigito(char evaluante){
        return Character.isDigit(evaluante);
    }
    
}
