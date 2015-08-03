package controller;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: Vilius Kukanauskas
 * Package: sample
 * Date: 30.07.2015
 * Time: 1:01 PM
 */
public class SudokuGenerator {
    private static ArrayList<ArrayList<Integer>> x          = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<ArrayList<Integer>> y          = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<ArrayList<Integer>> cubic      = new ArrayList<ArrayList<Integer>>();

    private static void initArrayList() {
        for (int i = 0; i <= 8; i++) {
            SudokuGenerator.x.add(new ArrayList<Integer>());
            SudokuGenerator.y.add(new ArrayList<Integer>());
            SudokuGenerator.cubic.add(new ArrayList<Integer>());

        }
    }

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

    private static void resetStaticLists(){
        for (int i = 0; i <= 8; i++) {
                SudokuGenerator.x.get(i).clear();
                SudokuGenerator.y.get(i).clear();
                SudokuGenerator.cubic.get(i).clear();
            }
    }

    private static boolean isUnique(int row, int collumn, int number) {
        if (
                (SudokuGenerator.x.get(collumn).contains(number)) ||
                 (SudokuGenerator.y.get(row).contains(number)) ||
                (SudokuGenerator.cubic.get(getCubicleNumber(row, collumn)).contains(number))) {
            return false;
        }
        return true;

    }


    private static void addNumberToGrid(int row, int column, int number) {
        SudokuGenerator.x.get(column).add(number);
        SudokuGenerator.y.get(row).add(number);
        SudokuGenerator.cubic.get(SudokuGenerator.getCubicleNumber(row, column)).add(number);
    }


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

    private static int getCubicleNumber(int row, int collumn) {
        return  ((row / 3) * 3) + (collumn / 3);
    }

}
