/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensicaen.calculatrice.fxml;

import com.ensicaen.calculatrice.utils.Operations;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author lesurfer
 */
public class RootLayoutController implements Initializable {

    private double nb1 = 0, nb2 = 0;
    private String op = "";
    private boolean isEquals = false;
    private final Operations operator = new Operations();
    private Stage owner;

    @FXML
    private Button handleA, handleB, handleC, handleD, handleE, handleF;
    @FXML
    private Button handle0, handle1, handle2, handle3, handle4, handle5, handle6, handle7, handle8, handle9;
    @FXML
    private Button handlePoint, handleDiv, handleAdd, handleMul, handleMin, handleSum;
    @FXML
    private TextField textFieldDisplay;

    @FXML
    private ComboBox<String> comboBase;
    private ObservableList<String> comboBaseData = FXCollections.observableArrayList();

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
        handleA.setDisable(true);
        handleB.setDisable(true);
        handleC.setDisable(true);
        handleD.setDisable(true);
        handleE.setDisable(true);
        handleF.setDisable(true);
        comboBaseData.add(new String("Dec"));
        comboBaseData.add(new String("Hex"));
        comboBaseData.add(new String("Bin"));
        comboBase.setItems(comboBaseData);
        comboBase.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleDisplayClear(ActionEvent event) {
        textFieldDisplay.clear();
        operator.setResult(0);
        nb1 = 0;
        nb2 = 0;
        op = "";
    }

    public void handleQuit(ActionEvent event) {
        Platform.exit();
    }

    public void handleAdd(ActionEvent event) {
        op = "+";
        moveResultToNumberOne();
        textFieldDisplay.clear();
    }

    public void handleMin(ActionEvent event) {
        op = "-";
        moveResultToNumberOne();
        textFieldDisplay.clear();
    }

    public void handleMul(ActionEvent event) {
        op = "*";
        moveResultToNumberOne();
        textFieldDisplay.clear();
    }

    public void handleDiv(ActionEvent event) {
        op = "/";
        moveResultToNumberOne();
        textFieldDisplay.clear();
    }

    public void handlePoint(ActionEvent event) {
        if (handlePoint == event.getSource()) {
            if (!textFieldDisplay.getText().contains(".")) {
                textFieldDisplay.setText(textFieldDisplay.getText() + ".");
            }
        }
    }

    public void handleEquals(ActionEvent event) {
        nb2 = Double.valueOf(textFieldDisplay.getText());
        textFieldDisplay.clear();

        isEquals = true;

        switch (op) {
            case "+":
                operator.Add(nb1, nb2);
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

        textFieldDisplay.setText(String.valueOf(nb1) + " " + op + " " + String.valueOf(nb2) + " = " + String.valueOf(operator.getResult()));
    }

    public void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(owner);
        alert.setTitle("A propos");
        alert.setContentText("Auteurs : Pierrick HUE et Jérémie LECLERC.\n"
                + "Version : Deux connards dans un abri-bus.");

        alert.showAndWait();
    }

    @FXML
    private void handleComboBase() {
        setDisableHandleHexadecimal();
    }

    private void setDisableHandleHexadecimal() {
        String selectedBase = comboBase.getSelectionModel().getSelectedItem();
        if (selectedBase.equals("Hex")) {
            handleA.setDisable(false);
            handleB.setDisable(false);
            handleC.setDisable(false);
            handleD.setDisable(false);
            handleE.setDisable(false);
            handleF.setDisable(false);
            handle2.setDisable(false);
            handle3.setDisable(false);
            handle4.setDisable(false);
            handle5.setDisable(false);
            handle6.setDisable(false);
            handle7.setDisable(false);
            handle8.setDisable(false);
            handle9.setDisable(false);
            handlePoint.setDisable(true);
        } else if (selectedBase.equals("Bin")) {
            handleA.setDisable(true);
            handleB.setDisable(true);
            handleC.setDisable(true);
            handleD.setDisable(true);
            handleE.setDisable(true);
            handleF.setDisable(true);
            handle2.setDisable(true);
            handle3.setDisable(true);
            handle4.setDisable(true);
            handle5.setDisable(true);
            handle6.setDisable(true);
            handle7.setDisable(true);
            handle8.setDisable(true);
            handle9.setDisable(true);
            handlePoint.setDisable(true);
        } else {
            handleA.setDisable(true);
            handleB.setDisable(true);
            handleC.setDisable(true);
            handleD.setDisable(true);
            handleE.setDisable(true);
            handleF.setDisable(true);
            handle2.setDisable(false);
            handle3.setDisable(false);
            handle4.setDisable(false);
            handle5.setDisable(false);
            handle6.setDisable(false);
            handle7.setDisable(false);
            handle8.setDisable(false);
            handle9.setDisable(false);
            handlePoint.setDisable(false);
        }
    }

    private void moveResultToNumberOne() {
        String temp = textFieldDisplay.getText();
        if (temp.contains("=")) {
            StringTokenizer st = new StringTokenizer(temp, "=");

            while (st.hasMoreTokens()) {
                temp = st.nextToken();
            }

            nb1 = Double.parseDouble(temp.trim());
        } else {
            nb1 = Double.valueOf(textFieldDisplay.getText());
        }
    }

    public void setOwner(Stage owner) {
        this.owner = owner;
    }

    class Event implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (isEquals) {
                isEquals = false;
                textFieldDisplay.clear();
                nb1 = operator.getResult();
            }

            Button handle = (Button) event.getSource();
            if (textFieldDisplay.getText().equals("0")) {
                textFieldDisplay.clear();
            }
            textFieldDisplay.setText(textFieldDisplay.getText() + handle.getText());
        }
    }
}
