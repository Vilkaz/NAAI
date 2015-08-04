package controller;

import java.util.ArrayList;

/**
 * User: Vilius Kukanauskas
 * Package: sample
 * Date: 30.07.2015
 * Time: 1:01 PM
 */

/** The Static Variables represent the vertical, horizontal and Cubical arrayLists, where the Value of sudoku numbers will
 *  be inserted and checked by. There is only one public method, which gives an Arraylist of checked Sudoku
 *  Fields, number by number, row by row.*/
public class SudokuGenerator {
    private static ArrayList<ArrayList<Integer>> verticalLines   = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<ArrayList<Integer>> horizontalLines = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<ArrayList<Integer>> nineFieldCubics = new ArrayList<ArrayList<Integer>>();


    /** If we are not initialisig the ArrayLists, we ar egeting a NullPointerException.
     * Posible other solution were to try catsh nul pointer Exception and initialise the ArrayLists in the
     * catsh block. Now we are reinitialisating the ArrayLists every run.*/
    private static void initArrayList() {
        for (int i = 0; i <= 8; i++) {
            SudokuGenerator.verticalLines.add(new ArrayList<Integer>());
            SudokuGenerator.horizontalLines.add(new ArrayList<Integer>());
            SudokuGenerator.nineFieldCubics.add(new ArrayList<Integer>());

        }
    }

    /** the Public API request method to get an ArrayList of 81 numbers, where row after row the Numbers
     * are added. The Sudoku conscturcion fails mostly, so we need to sort that our ArrayList has 81 valid
     * Variables, only in this case we are pasing the result. Else we are reseting all the ArrayLists and starting
     * over again.*/
    public static ArrayList<Integer> getSudokuList() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int  run = 1;
        do {
            initArrayList();
            resetStaticLists();
            result.clear();
                 for (int row = 0; row <= 8; row++) {
                     for (int collumn = 0; collumn <= 8; collumn++) {
                         for (int number : SudokuGenerator.getCandidates()) {
                             if (isUnique(row, collumn, number)) {
                                 result.add(number);
                                 SudokuGenerator.addNumberToGrid(row, collumn, number);
                                 break;
                             }
                         }
                     }
                 }

            run++;
        } while (result.size()<81);
        System.out.println(run);
        return result;
    }

    /** if the Sudoku was coruppted, we start new Sudoku. this function resets
     * all Arraylist Fields of the last Sudoku try, so we can start with clear ArrayLists */
    private static void resetStaticLists(){
        for (int i = 0; i <= 8; i++) {
                SudokuGenerator.verticalLines.get(i).clear();
                SudokuGenerator.horizontalLines.get(i).clear();
                SudokuGenerator.nineFieldCubics.get(i).clear();
            }
    }


    /** all three Sudoku ArrayLists will be checked, if the requested number is allready
     * part of them */
    private static boolean isUnique(int row, int collumn, int number) {
        if (
                (SudokuGenerator.verticalLines.get(collumn).contains(number)) ||
                 (SudokuGenerator.horizontalLines.get(row).contains(number)) ||
                (SudokuGenerator.nineFieldCubics.get(getCubicleNumber(row, collumn)).contains(number))) {
            return false;
        }
        return true;

    }


    /** adds an number to all three ArrayLists that are important for Sudoku solution */
    private static void addNumberToGrid(int row, int column, int number) {
        SudokuGenerator.verticalLines.get(column).add(number);
        SudokuGenerator.horizontalLines.get(row).add(number);
        SudokuGenerator.nineFieldCubics.get(SudokuGenerator.getCubicleNumber(row, column)).add(number);
    }


    /**  gives all numbers from 1 to 9 in random order*/
    private static ArrayList<Integer> getCandidates() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (result.size() < 9) {
            int tempo = (int) (Math.random() * 9) + 1;
            if (!result.contains(tempo)) {
                result.add(tempo);
            }
        }
        return result;

    }


    /** takes row and collumn from actual number, and calculates in which cubical Field the number is  */
    private static int getCubicleNumber(int row, int collumn) {
        return  ((row / 3) * 3) + (collumn / 3);
    }

}
