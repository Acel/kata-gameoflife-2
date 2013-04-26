package no.finntech.kata;

public class GameOfLife {

    private int[][] board;

    public GameOfLife(int rows, int cols) {
        board = new int[rows][cols];
    }

    public String getBoard() {
        String result = "";
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                result = result  + board[row][col];
            }
            result += "\n";
        }
        return result;
    }

    public void setAlive(int row, int col) {
        board[row][col] = 1;
    }

}
