package com.example.mvc.controllers;

import com.example.mvc.models.Calculator;
import com.example.mvc.views.CalculatorView;
import javafx.scene.control.Alert;

/**
 * The CalculatorController class serves as the controller in the MVC pattern.
 * It handles user interactions, performs calculations, and updates the view based on the model's data.
 */
public class CalculatorController {

    private Calculator model;
    private CalculatorView view;

    /**
     * Constructor for the CalculatorController.
     *
     * @param model The Calculator model that handles calculations.
     * @param view  The CalculatorView that presents the user interface.
     */
    public CalculatorController(Calculator model, CalculatorView view) {
        this.model = model;
        this.view = view;

        this.view.getAddButton().setOnAction(e -> performCalculation("+"));
        this.view.getSubtractButton().setOnAction(e -> performCalculation("-"));
        this.view.getMultiplyButton().setOnAction(e -> performCalculation("*"));
        this.view.getDivideButton().setOnAction(e -> performCalculation("/"));
        this.view.getCheckAgeButton().setOnAction(e -> checkAge());
        this.view.getGenerateTableButton().setOnAction(e -> generateMultiplicationTable());
    }

    /**
     * Performs the calculation based on the operator provided.
     *
     * @param operator The arithmetic operator (+, -, *, /) for the calculation.
     */
    private void performCalculation(String operator) {
        try {
            double num1 = Double.parseDouble(view.getInput1().getText());
            double num2 = Double.parseDouble(view.getInput2().getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = model.add(num1, num2);
                    break;
                case "-":
                    result = model.subtract(num1, num2);
                    break;
                case "*":
                    result = model.multiply(num1, num2);
                    break;
                case "/":
                    result = model.divide(num1, num2);
                    break;
            }
            new Alert(Alert.AlertType.INFORMATION,"Результат: " + result).showAndWait();
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR,"Введіть дійсні числа!").showAndWait();
        } catch (ArithmeticException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).showAndWait();
        }
    }

    /**
     * Checks the user's age and displays the corresponding age category.
     */
    private void checkAge() {
        try {
            int age = Integer.parseInt(view.getAgeInput().getText());
            String category = model.getAgeCategory(age);
            String message = "Категорія віку: " + category;
            new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Введіть дійсне число для віку!").showAndWait();
        }
    }

    /**
     * Generates a multiplication table for the given number and displays it.
     */
    private void generateMultiplicationTable() {
        try {
            int number = Integer.parseInt(view.getMultiplicationInput().getText());
            String table = model.generateMultiplicationTable(number);
            new Alert(Alert.AlertType.INFORMATION, table).showAndWait();
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR,"Введіть дійсне число для таблиці!").showAndWait();
        }
    }
}
