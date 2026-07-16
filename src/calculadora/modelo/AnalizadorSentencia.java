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
    
    //atributos de AnalizadorSentencia
    private List<String> sentenciaDescompuesta = new ArrayList<>();
    private MotorCalculadora motor;
    
    //variables globales por conveniencia para reducir codigo de  descomponerSentencia
    private StringBuilder acumuladorNumero = new StringBuilder("");
    private StringBuilder acumuladorOperador = new StringBuilder("");
    private boolean acumuladoresListos;

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
    
    private void descomponerSentencia(String sentencia) throws Exception{
        
        limpiarAcumuladores();
        
        if( esDigito(sentencia.charAt(0)) ){

            if(sentencia.length()>1){
                
                acumuladoresListos = false;
                acumuladorNumero.append(sentencia.charAt(0));

                for( int i=1 ; i < (sentencia.length()-1); i++){

                    if(  esDigitoOComa(sentencia.charAt(i))  ){
                       
                        if( acumuladoresListos ){ 
                           procesarAcumuladores();
                        }
                        acumuladorNumero.append(sentencia.charAt(i));
                        
                    }else{
                        if(!acumuladoresListos){
                            acumuladoresListos = true;
                        }
                        acumuladorOperador.append(sentencia.charAt(i));
                    }

                }

                if( esDigito( sentencia.charAt(sentencia.length()-1) ) ){
                    if( acumuladoresListos ){
                        procesarAcumuladores();
                    }
                    acumuladorNumero.append(sentencia.charAt(sentencia.length()-1));
                    guardarComponente(acumuladorNumero.toString());
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
    
    private void procesarAcumuladores() throws Exception {
    
       if(  validarOperador( acumuladorOperador.toString() )  ){ 
            guardarAcumuladores();
       }
       
    }
    
    private void guardarAcumuladores(){
        guardarNumeroYOPerador(
            acumuladorNumero.toString(), 
            acumuladorOperador.toString()
        );
        limpiarAcumuladores();
        acumuladoresListos = false;
    }
    
    private boolean validarOperador( String operador ) throws Exception {
        
        if(!motor.validarOperador(operador)){
            throw new Exception(String.format("Error: el operador '%s' no es valido", acumuladorOperador.toString()));
        }  
        return true;
    }
    
    private void limpiarAcumuladores(){
        acumuladorNumero.setLength(0);
        acumuladorOperador.setLength(0);
    }
    
    private void guardarComponente (String componente){
        sentenciaDescompuesta.add(componente);
    }
    
    private void guardarNumeroYOPerador(String numero, String operador){
        guardarComponente(numero);
        guardarComponente(operador);
    }
    
    private boolean esDigitoOComa(char evaluante){
       return ( esDigito(evaluante) || evaluante == ',' );
    }
    
    private boolean esDigito(char evaluante){
        return Character.isDigit(evaluante);
    }
    
}
