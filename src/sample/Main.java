package sample;

import controller.SudokuGenerator;
import controller.SudokuViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        VBox numberField = SudokuViewController.getNumberfieldFromList(SudokuGenerator.getSudokuList());
        primaryStage.setTitle("NAAI 0.1");
        VBox content = new VBox(numberField);
        root.getChildren().addAll(content,SudokuViewController.getButton(content));
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
