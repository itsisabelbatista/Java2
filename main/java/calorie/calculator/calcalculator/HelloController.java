package calorie.calculator.calcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label display;
    @FXML
    private TextField bigmac;
    @FXML
    private TextField smallshake;
    @FXML
    private TextField mediumfries;

    @FXML
    protected void onClickCalc(ActionEvent event) throws IOException {

        //create our variables
        int[] foodCal = {563, 378,530};//{bigmac,mediumfries,smallshake}
        String[] foodname = {"big mac","medium fries","small shake"};
        int[] foodQty = {
                Integer.parseInt(bigmac.getText()),
                Integer.parseInt(smallshake.getText()),
                Integer.parseInt(mediumfries.getText()),
        };
        int[] intakeEach={0,0,0};
        int intakeTotal = 0;

        int burnRun = 557, burnJog = 398;
        int hoursRun =0, hoursjog = 0;

        //Calculate
        for (int i = 0; i < foodCal.length; i++) {
            intakeEach[i] = foodCal[i]*foodQty[i]; //each item
            intakeTotal += foodCal[i]*foodQty[i]; //total kcal consumed
        }

        //calculate how many hours to burn kcal
        hoursRun = Math.round((intakeTotal/burnRun)*100/100);
        hoursjog = Math.round((intakeTotal/burnJog)*100/100);

        String data = ""+foodname[0]+": "+intakeEach[0]+"kcal\n"+
                ""+foodname[1]+": "+intakeEach[1]+"kcal\n"+
                ""+foodname[2]+": "+intakeEach[2]+"kcal\n";

        // Load the display page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("display.fxml"));
        Parent root = loader.load();

        // Set the display label text
        display = (Label) root.lookup("#display");
        display.setText(data+"\ntotal intake:"+intakeTotal+"kcal\n\nHow many calorie you loose if you:\n\nRun: "+hoursRun+"hrs\nJog: "+hoursjog+"hrs");

        // Show the display page
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // Close the input page if needed
        ((Stage) bigmac.getScene().getWindow()).close();
    }

    @FXML
    protected void onClickBack() throws IOException {
        // Load other page hello-view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        // Show the display page
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // Close the input page if needed
        ((Stage) display.getScene().getWindow()).close();
    }
}