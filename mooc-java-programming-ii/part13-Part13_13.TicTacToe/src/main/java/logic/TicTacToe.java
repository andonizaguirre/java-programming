/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;

/**
 *
 * @author andoni
 */
public class TicTacToe {

    private String[][] ticTacToe; // Map equivalent to the button placement in UI
    private String turn;

    public TicTacToe() {
        this.ticTacToe = new String[3][3];
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe[i].length; j++) {
                ticTacToe[i][j] = " ";
            }
        }
        this.turn = "X"; // Player X always moves fist
    }

    public void place(int x, int y) { // x, y Columns and rows (GridPane perspective), invert access in parameters     
        if (!(0 <= x && x <= 2) || !(0 <= y && y <= 2)) { // Non valid location
            return;
        }
        if (!this.ticTacToe[x][y].equals(" ")) { // Non empty place
            return;
        }
        if (this.ended()) { // Conditions met for game to end
            return;
        }
        this.ticTacToe[x][y] = this.turn;
        this.switchTurn();
    }

//    public boolean ended() {
//        int[][] sameSymbols = {
//            {0, 1, 2},
//            {3, 4, 5},
//            {6, 7, 8},
//            {0, 4, 8},
//            {6, 4, 2},
//            {0, 3, 6},
//            {1, 4, 7},
//            {2, 5, 8}
//        };
//        for (int i = 0; i < sameSymbols.length; i++) {
//            if (arrayHasSameSymbolsInPlaces(sameSymbols[i])) {
//                return true;
//            }
//        }
//        for (int x = 0; x < 3; x++) {
//            for (int y = 0; y < 3; y++) {
//                if (status(x, y).trim().isEmpty()) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    
//    public String status(int x, int y) {
//        if (x < 0 || y < 0 || x > 2 || y > 2) {
//            return "";
//        } 
//        return this.ticTacToe[x][y];
//    }
//
//    private boolean arrayHasSameSymbolsInPlaces(int[] array) {
//        String[] values = {valueInArray(array[0]), valueInArray(array[1]), valueInArray(array[2])};
//        Arrays.sort(values);
//        return values[0].equals(values[1]) && values[1].equals(values[2]) && !values[0].trim().isEmpty();
//    }
//
//    private String valueInArray(int place) {
//        int x = place % 3;
//        int y = place / 3;
//        return this.ticTacToe[x][y];
//    }
    
    public boolean ended() {
        for (String row : sumsOfRows()) {
            if (row.equals("XXX") || row.equals("OOO")) {
                return true;
            }
        }
        for (String column : sumsOfColumns()) {
            if (column.equals("XXX") || column.equals("OOO")) {
                return true;
            }
        }
        for (String diagonal : sumsOfDiagonals()) {
            if (diagonal.equals("XXX") || diagonal.equals("OOO")) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> sumsOfRows() {
        ArrayList<String> sumsOfRows = new ArrayList<>();
        for (int i = 0; i < this.ticTacToe.length; i++) { // i = Y; j = X
            String sum = "";
            for (int j = 0; j < this.ticTacToe[i].length; j++) {
                sum = sum + this.ticTacToe[i][j]; // Form String that represents row
            }
            sumsOfRows.add(sum);
        }
        return sumsOfRows;
    }

    private ArrayList<String> sumsOfColumns() {
        ArrayList<String> sumsOfColumns = new ArrayList<>();
        for (int i = 0; i < this.ticTacToe.length; i++) { // i = Y; j = X
            String sum = "";
            for (int j = 0; j < this.ticTacToe[i].length; j++) {
                sum = sum + this.ticTacToe[j][i]; // Square matrix (transpose)
            }
            sumsOfColumns.add(sum);
        }
        return sumsOfColumns;
    }

    private ArrayList<String> sumsOfDiagonals() {
        ArrayList<String> sumsOfDiagonals = new ArrayList<>();
        String mainDiagonal = "";
        String antiDiagonal = "";
        for (int i = 0; i < this.ticTacToe.length; i++) {
            for (int j = 0; j < this.ticTacToe[i].length; j++) {
                if (i == j) { // Main diagonal
                    mainDiagonal = mainDiagonal + this.ticTacToe[i][j];
                }
                if (i + j == this.ticTacToe.length - 1) { // Anti-diagonal, square matrix == all lengths are the same
                    antiDiagonal = antiDiagonal + this.ticTacToe[i][j];
                }
            }
        }
        sumsOfDiagonals.add(mainDiagonal);
        sumsOfDiagonals.add(antiDiagonal);
        return sumsOfDiagonals;
    }

    public String getTurn() {
        return this.turn;
    }

    public String[][] getTicTacToe() {
        return this.ticTacToe;
    }

    public void switchTurn() {
        if (this.turn.equals("X")) {
            this.turn = "O";
        } else {
            this.turn = "X";
        }
    }
}
