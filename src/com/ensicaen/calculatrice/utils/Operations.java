/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensicaen.calculatrice.utils;

/**
 *
 * @author lesurfer
 */
public class Operations {
    
    private double sum;
    
    public double getSum(){
        return sum;
    }
    public double Addittion(double... nb){
        sum = 0;
        for (Double d : nb) {
            sum += d;
        }
        return sum;
    }
    /*public double Substract(double... nb){
        sum = 0;
        for (Double d : nb) {
            if( d < sum){
                sum -= d;
            }else{
                sum = d - sum;
            }
        }
        return sum;
    }*/
    public double Substract(double... nb){
        sum = 0;
        for (Double d : nb) {
                sum -= d;
        }
        return sum;
    }
    public double Multiply(double... nb){
        sum = 1;
        for (Double d : nb) {
            sum *= d;
        }
        return sum;
    }
    public double Divide(double... nb){
        sum = 1;
        for (Double d : nb) {
            sum /= d;
        }
        return sum;
    }
}
