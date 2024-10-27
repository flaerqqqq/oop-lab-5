package com.example.mvc;

import com.example.mvc.controllers.CalculatorController;
import com.example.mvc.models.Calculator;
import com.example.mvc.views.CalculatorView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        Calculator model = new Calculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        Scene scene = new Scene(view, 400, 500);
        primaryStage.setTitle("Vitaliy Verzun");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}