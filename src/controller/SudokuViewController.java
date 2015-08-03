package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Main;

import java.util.ArrayList;

import static java.lang.Math.sqrt;

/**
 * User: Vilius Kukanauskas
 * Package: sample
 * Date: 30.07.2015
 * Time: 12:58 PM
 */
public class SudokuViewController {

    public static VBox getNumberfieldFromList(ArrayList<Integer> list){
        int amountOfRows = 9;
        int amountOfCollumns = 9;
        int rowWidth = 9;
        int collumnHeigth = 9;
        int cubicleWidth = 3;
        int cubicleHeigth = 3;
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
