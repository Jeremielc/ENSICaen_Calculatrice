/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensicaen.calculatrice.fxml;

import com.ensicaen.calculatrice.utils.Operations;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author lesurfer
 */
public class RootLayoutController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Event handleEvent = new Event();
        handleA.setOnAction(handleEvent);
        handleB.setOnAction(handleEvent);
        handleC.setOnAction(handleEvent);
        handleD.setOnAction(handleEvent);
        handleE.setOnAction(handleEvent);
        handleF.setOnAction(handleEvent);
        handle0.setOnAction(handleEvent);
        handle1.setOnAction(handleEvent);
        handle2.setOnAction(handleEvent);
        handle3.setOnAction(handleEvent);
        handle4.setOnAction(handleEvent);
        handle5.setOnAction(handleEvent);
        handle6.setOnAction(handleEvent);
        handle7.setOnAction(handleEvent);
        handle8.setOnAction(handleEvent);
        handle9.setOnAction(handleEvent);
    }

    private double nb1 = 0, nb2 = 0;
    private String op = "";

    @FXML
    private Button handleA, handleB, handleC, handleD, handleE, handleF;
    @FXML
    private Button handle0, handle1, handle2, handle3, handle4, handle5, handle6, handle7, handle8, handle9;
    @FXML
    private Button handlePoint, handleDiv, handleAdd, handleMul, handleMin, handleSum;

    @FXML
    private TextField textFieldDisplay;

    @FXML
    public void handleDisplayClear(ActionEvent event) {
        textFieldDisplay.clear();
    }

    public void handleQuit(ActionEvent event) {
        System.exit(0);
    }

    public void handleAdd(ActionEvent event) {
        op = "+";
        nb1 = Double.valueOf(textFieldDisplay.getText());
        textFieldDisplay.setText("");
    }

    public void handleMin(ActionEvent event) {
        op = "-";
        nb1 = Double.valueOf(textFieldDisplay.getText());
        textFieldDisplay.setText("");
    }

    public void handleMul(ActionEvent event) {
        op = "*";
        nb1 = Double.valueOf(textFieldDisplay.getText());
        textFieldDisplay.setText("");
    }

    public void handleDiv(ActionEvent event) {
        op = "/";
        nb1 = Double.valueOf(textFieldDisplay.getText());
        textFieldDisplay.setText("");
    }

    public void handlePoint(ActionEvent event) {
        if (handlePoint == event.getSource()) {
            if (!textFieldDisplay.getText().contains(".")) {
                textFieldDisplay.setText(textFieldDisplay.getText() + ".");
            }
        }
    }

    public void handleSum(ActionEvent event) {
        Operations operator = new Operations();
        nb2 = Double.valueOf(textFieldDisplay.getText());
        textFieldDisplay.setText("");

        switch (op) {
            case "+":
                operator.Addittion(nb1, nb2);
                break;
            case "-":
                operator.Substract(nb1, nb2);
                break;
            case "/":
                operator.Divide(nb1, nb2);
                break;
            case "*":
                operator.Multiply(nb1, nb2);
                break;
            default:
                break;
        }
        textFieldDisplay.setText(String.valueOf(nb1) + " " + op + " " + String.valueOf(nb2) + " = " + (String.valueOf(operator.getSum())));
    }

    class Event implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Button handle = (Button) event.getSource();
            if (textFieldDisplay.getText().equals("0")) {
                textFieldDisplay.setText("");
            }
            textFieldDisplay.setText(textFieldDisplay.getText() + handle.getText());
        }
    }
}
