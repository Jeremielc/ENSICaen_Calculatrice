package com.ensicaen.calculatrice.utils;

/**
 *
 * @author Pierrick Hue & Jérémie Leclerc
 */
public class Operations {

    private double result;

    public void Add(double nb1, double nb2) {
        result = nb1 + nb2;
        roundResult();
    }

    public void Substract(double nb1, double nb2) {
        result = nb1 - nb2;
        roundResult();
    }

    public void Multiply(double nb1, double nb2) {
        result = nb1 * nb2;
        roundResult();
    }

    public void Divide(double nb1, double nb2) {
        result = nb1 / nb2;
        roundResult();
    }

    private void roundResult() {
        result = (double) Math.round(result * 100000d) / 100000d;
    }

    public double getDecimalResult() {
        return result;
    }
    
    public int getHexResult() {
        int res = Integer.parseInt(String.valueOf(result), 16);
        return res;
    }
    
    public int getBinaryResult() {
        int res = Integer.parseInt(String.valueOf(result), 2);
        return res;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
