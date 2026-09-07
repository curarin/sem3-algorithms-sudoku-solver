package at.hochschule.burgenland.bswe.algo;

public class Solver {

    public static boolean isValidNumberInRow(int[][] array, int currentRow, int currentCol, int potentialSolution) {
        // Check if the potentialSolution exists in the same row
        for (int col = 0; col < array.length; col++) {
            if (array[currentRow][col] == potentialSolution) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidNumberInColumn(int[][] array, int currentRow, int currentCol, int potentialSolution) {
        // Check if potentialSolution exists in same column
        for (int row = 0; row < array.length; row++) {
            if (array[row][currentCol] == potentialSolution) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidNumberInQuadrant(int[][] array, int currentRow, int currentCol, int potentialSolution) {
        // Check if potentialSolution exists in same Quadrant
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

    public static boolean solveHelper(int[][] array, int rowIndex, int colIndex) {
        return true;
    }

    public static int[][] solve(int[][] array) {
        boolean returnValue = solveHelper(array, 0, 0);
        return array;
    }
}
