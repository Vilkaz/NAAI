package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


/**
 * User: Vilius Kukanauskas
 * Package: sample
 * Date: 30.07.2015
 * Time: 12:58 PM
 */
public class SudokuViewController {

    /** if given a ArrayList of specific length, it wil be represented
     * in Field of Textfields */
    public static VBox getNumberfieldFromList(ArrayList<Integer> list){
        int amountOfRows = 9;
        int amountOfCollumns = 9;
        int index = 0;
        VBox rows = new VBox();
        for (int row = 1; row <= amountOfRows; row++) {
            HBox temporary = new HBox();
            for (int collumn = 1; collumn <= amountOfCollumns; collumn++) {
               temporary.getChildren().add(new TextField(String.valueOf(list.get(index))));
                index++;
            }
            rows.getChildren().add(temporary);
        }
        return rows;
    }


    /** on click the button clears the content VBox, and fills the Content with new
     * Sudoku Field */
    public static Button getButton(final VBox content){
        Button button = new Button("generate random sudoku");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                content.getChildren().clear();
                content.getChildren().add(SudokuViewController.getNumberfieldFromList(SudokuGenerator.getSudokuList()));
            }
        });
    return button;
    }

}
