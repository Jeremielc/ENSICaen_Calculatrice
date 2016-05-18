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
    public double Addittion(double... nb){
        double sum = 0;
        for (Double d : nb) {
            sum += d;
        }
        return sum;
    }
    public double Substract(double... nb){
        double sum = 0;
        for (Double d : nb) {
            sum -= d;
        }
        return sum;
    }
    public double Multiply(double... nb){
        double sum = 0;
        for (Double d : nb) {
            sum *= d;
        }
        return sum;
    }
    public double Divide(double... nb){
        double sum = 0;
        for (Double d : nb) {
            sum /= d;
        }
        return sum;
    }
}
