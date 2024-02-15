module calorie.calculator.calcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens calorie.calculator.calcalculator to javafx.fxml;
    exports calorie.calculator.calcalculator;
}