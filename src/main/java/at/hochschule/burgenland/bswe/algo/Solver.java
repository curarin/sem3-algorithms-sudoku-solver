package at.hochschule.burgenland.bswe.algo;

public class Solver {
    public static int emptyCellCounter;

    /**
     * Checks the given potential solution if its a valid solution with the same row of the 2d array / dataframe
     *
     * @param array             sudoku array
     * @param currentRow        current position within the 2d array (row)
     * @param potentialSolution the current potential solution to be checked
     * @return true if its valid
     */
    public static boolean isValidNumberInRow(int[][] array, int currentRow, int potentialSolution) {
        for (int col = 0; col < array[0].length; col++) {
            if (array[currentRow][col] == potentialSolution) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks the given potential solution if its a valid solution with the same column of the 2d array / dataframe
     *
     * @param array             sudoku array
     * @param currentCol        current position with the 2d array (column)
     * @param potentialSolution the current potential solution to be checked
     * @return true if its valid
     */
    public static boolean isValidNumberInColumn(int[][] array, int currentCol, int potentialSolution) {
        for (int row = 0; row < array.length; row++) {
            if (array[row][currentCol] == potentialSolution) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks the given potential solution if its a valid solution with the same quadrant of the 2d array / dataframe
     *
     * @param array             sudoku array
     * @param currentRow        current position within the 2d array (row)
     * @param currentCol        current position with the 2d array (column)
     * @param potentialSolution the current potential solution to be checked
     * @return true if its valid
     */
    public static boolean isValidNumberInQuadrant(int[][] array, int currentRow, int currentCol, int potentialSolution) {
        int quadrantStartRow = currentRow - (currentRow % 3);
        int quadrantStartCol = currentCol - (currentCol % 3);

        for (int quadrantRow = 0; quadrantRow < 3; quadrantRow++) {
            for (int quadrantCol = 0; quadrantCol < 3; quadrantCol++) {
                int currentIterationRow = quadrantRow + quadrantStartRow;
                int currentIterationCol = quadrantCol + quadrantStartCol;
                if (array[currentIterationRow][currentIterationCol] == potentialSolution) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] solveHelper(int[][] array) {
        return array;
    }

    /**
     * Helper method for counting the total available cells exactly once. Used as cancel condition for iterating over the sudoku if it hits 0.
     *
     * @param array Sudoku puzzle
     */
    public static void countEmptyCells(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] == 0) {
                    emptyCellCounter++;
                }
            }
        }
    }

    public static int[][] solve(int[][] array) {
        countEmptyCells(array);
        do {
            solveHelper(array);

        } while (emptyCellCounter > 0);
        return array;
    }
}
