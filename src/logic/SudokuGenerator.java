package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Roman Hecht
 * Package: sample
 * Date: 30.07.2015
 * Time: 1:01 PM
 */
public class SudokuGenerator {
    public static ArrayList<Integer> getSudokuAsList(){
       ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(0,2,3,4,5,6,7,8,9));
        return list;
    }
}
