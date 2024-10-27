package com.example.mvc.views;

import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import lombok.Getter;

/**
 * The CalculatorView class represents the user interface of the calculator application.
 * It extends VBox and provides input fields and buttons for performing calculations,
 * checking age categories, and generating multiplication tables.
 */
@Getter
public class CalculatorView extends VBox {

    private TextField input1;
    private TextField input2;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private TextField ageInput;
    private Button checkAgeButton;
    private TextField multiplicationInput;
    private Button generateTableButton;

    /**
     * Constructor for the CalculatorView class.
     * Initializes the user interface components and arranges them in a vertical box layout.
     */
    public CalculatorView() {
        input1 = new TextField();
        input2 = new TextField();
        addButton = new Button("Додати");
        subtractButton = new Button("Відняти");
        multiplyButton = new Button("Помножити");
        divideButton = new Button("Поділити");
        ageInput = new TextField();
        checkAgeButton = new Button("Перевірити вік");
        multiplicationInput = new TextField();
        generateTableButton = new Button("Генерувати таблицю множення");

        setPadding(new Insets(20));
        setSpacing(10);

        getChildren().addAll(
                new Text("Введіть перше число:"), input1,
                new Text("Введіть друге число:"), input2,
                addButton, subtractButton, multiplyButton, divideButton,
                new Text("Введіть ваш вік:"), ageInput, checkAgeButton,
                new Text("Введіть число для таблиці множення:"), multiplicationInput, generateTableButton
        );
    }
}
