package no.finntech.kata;

public class GameOfLife {

    private int[][] board;

    public GameOfLife(int rows, int cols) {
        board = new int[rows][cols];
    }

    public String getBoard() {
        String result = "";
        for (int[] aBoard : board) {
            for (int anABoard : aBoard) {
                result = result + anABoard;
            }
            result += "\n";
        }
        return result;
    }

    public void setAlive(int row, int col) {
        board[row][col] = 1;
    }

    public void nextGeneration() {
        int[][] tempBoard = new int[board.length][board[0].length];
        int neighbours;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                neighbours = numberOfNeighbours(row, col);

                if (neighbours < 2 || neighbours > 3) {
                    tempBoard[row][col] = 0;
                } else if (neighbours == 3) {
                    tempBoard[row][col] = 1;
                } else {
                    tempBoard[row][col] = board[row][col];
                }
            }
        }

        board = tempBoard;
    }

    int numberOfNeighbours(int row, int col) {
        int counter = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                try {
                    if (board[i][j] == 1 && (i != row || j != col)) {
                        counter++;
                    }
                }  catch ( ArrayIndexOutOfBoundsException ignored) {

                }
            }
        }

        return counter;
    }
}
