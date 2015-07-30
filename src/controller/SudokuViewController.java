package controller;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;

import static java.lang.Math.sqrt;

/**
 * User: Roman Hecht
 * Package: sample
 * Date: 30.07.2015
 * Time: 12:58 PM
 */
public class SudokuViewController {
    public static Node getNodeFromList(List list){
        double lineLength = sqrt(list.size());
        return new VBox();
    }
}
