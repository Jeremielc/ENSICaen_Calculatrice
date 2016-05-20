/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensicaen.calculatrice.main;

import com.ensicaen.calculatrice.fxml.RootLayoutController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author lesurfer
 */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane rootLayout;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/ensicaen/calculatrice/fxml/RootLayout.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);

            RootLayoutController rlc = loader.getController();
            rlc.setOwner(primaryStage);
            
            primaryStage.setResizable(false);
            primaryStage.setTitle("Calculatrice");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("/com/ensicaen/calculatrice/images/icon.png"));
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
