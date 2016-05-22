package com.ensicaen.calculatrice.fxml;

import com.ensicaen.calculatrice.utils.Operations;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.application.Platform;
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
 * @author Pierrick Hue & Jérémie Leclerc
 */
public class RootLayoutController implements Initializable {

    private double nb1 = 0, nb2 = 0;
    private String op = "";
    private boolean isEquals = false;
    private final Operations operator = new Operations();
    private Stage owner;

    @FXML
    private Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF;
    @FXML
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    @FXML
    private Button comaButton;

    @FXML
    private TextField textFieldDisplay;

    @FXML
    private ComboBox<String> comboBase;
    private final ObservableList<String> comboBaseData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Event handleEvent = new Event();

        buttonA.setOnAction(handleEvent);
        buttonB.setOnAction(handleEvent);
        buttonC.setOnAction(handleEvent);
        buttonD.setOnAction(handleEvent);
        buttonE.setOnAction(handleEvent);
        buttonF.setOnAction(handleEvent);
        button0.setOnAction(handleEvent);
        button1.setOnAction(handleEvent);
        button2.setOnAction(handleEvent);
        button3.setOnAction(handleEvent);
        button4.setOnAction(handleEvent);
        button5.setOnAction(handleEvent);
        button6.setOnAction(handleEvent);
        button7.setOnAction(handleEvent);
        button8.setOnAction(handleEvent);
        button9.setOnAction(handleEvent);

        buttonA.setDisable(true);
        buttonB.setDisable(true);
        buttonC.setDisable(true);
        buttonD.setDisable(true);
        buttonE.setDisable(true);
        buttonF.setDisable(true);

        comboBaseData.add("Dec");
        comboBaseData.add("Hex");
        comboBaseData.add("Bin");
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

    @FXML
    public void handleQuit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void handleAdd(ActionEvent event) {
        op = "+";
        moveResultToNumberOne();
        textFieldDisplay.clear();
    }

    @FXML
    public void handleMin(ActionEvent event) {
        op = "-";
        moveResultToNumberOne();
        textFieldDisplay.clear();
    }

    @FXML
    public void handleMul(ActionEvent event) {
        op = "*";
        moveResultToNumberOne();
        textFieldDisplay.clear();
    }

    @FXML
    public void handleDiv(ActionEvent event) {
        op = "/";
        moveResultToNumberOne();
        textFieldDisplay.clear();
    }

    @FXML
    public void handlePoint(ActionEvent event) {
        if (comaButton == event.getSource()) {
            if (!textFieldDisplay.getText().contains(".")) {
                textFieldDisplay.setText(textFieldDisplay.getText() + ".");
            }
        }
    }

    @FXML
    public void handleEquals(ActionEvent event) {
        switch (comboBase.getSelectionModel().getSelectedItem()) {
            case "Dec":
                nb2 = Double.valueOf(textFieldDisplay.getText());
                break;
            case "Hex":
                break;
            case "Bin":
                break;
        }

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

        switch (comboBase.getSelectionModel().getSelectedItem()) {
            case "Dec":
                textFieldDisplay.setText(String.valueOf(nb1) + " " + op + " " + String.valueOf(nb2) + " = " + String.valueOf(operator.getDecimalResult()));
                break;
            case "Hex":
                textFieldDisplay.setText(String.valueOf(nb1) + " " + op + " " + String.valueOf(nb2) + " = " + String.valueOf(operator.getHexResult()));
                break;
            case "Bin":
                textFieldDisplay.setText(String.valueOf(nb1) + " " + op + " " + String.valueOf(nb2) + " = " + String.valueOf(operator.getBinaryResult()));
                break;
            default:
                break;
        }
    }

    @FXML
    public void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(owner);
        alert.setTitle("A propos");
        alert.setContentText("Auteurs : Pierrick HUE et Jérémie LECLERC.\n"
                + "Version : Deux connards dans un abri-bus.");

        alert.showAndWait();
    }

    @FXML
    public void handleComboBase() {
        disableUnecessaryButtons();
    }

    private void disableUnecessaryButtons() {
        switch (comboBase.getSelectionModel().getSelectedItem()) {
            case "Hex":
                buttonA.setDisable(false);
                buttonB.setDisable(false);
                buttonC.setDisable(false);
                buttonD.setDisable(false);
                buttonE.setDisable(false);
                buttonF.setDisable(false);
                button2.setDisable(false);
                button3.setDisable(false);
                button4.setDisable(false);
                button5.setDisable(false);
                button6.setDisable(false);
                button7.setDisable(false);
                button8.setDisable(false);
                button9.setDisable(false);
                comaButton.setDisable(true);
                break;
            case "Bin":
                buttonA.setDisable(true);
                buttonB.setDisable(true);
                buttonC.setDisable(true);
                buttonD.setDisable(true);
                buttonE.setDisable(true);
                buttonF.setDisable(true);
                button2.setDisable(true);
                button3.setDisable(true);
                button4.setDisable(true);
                button5.setDisable(true);
                button6.setDisable(true);
                button7.setDisable(true);
                button8.setDisable(true);
                button9.setDisable(true);
                comaButton.setDisable(true);
                break;
            default:
                buttonA.setDisable(true);
                buttonB.setDisable(true);
                buttonC.setDisable(true);
                buttonD.setDisable(true);
                buttonE.setDisable(true);
                buttonF.setDisable(true);
                button2.setDisable(false);
                button3.setDisable(false);
                button4.setDisable(false);
                button5.setDisable(false);
                button6.setDisable(false);
                button7.setDisable(false);
                button8.setDisable(false);
                button9.setDisable(false);
                comaButton.setDisable(false);
                break;
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
            switch (comboBase.getSelectionModel().getSelectedItem()) {
                case "Dec":
                    nb1 = Double.valueOf(textFieldDisplay.getText());
                    break;
                case "Hex":
                    break;
                case "Bin":
                    break;
            }
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
                nb1 = operator.getDecimalResult();
            }

            Button handle = (Button) event.getSource();
            if (textFieldDisplay.getText().equals("0")) {
                textFieldDisplay.clear();
            }
            textFieldDisplay.setText(textFieldDisplay.getText() + handle.getText());
        }
    }
}
