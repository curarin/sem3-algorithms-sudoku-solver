package at.hochschule.burgenland.bswe.algo;

public class StatisticsPrinter {
    public static void printSudokuBoard(int[][] sudokuArray) {
        for (int row = 0; row < sudokuArray.length; row++) {
            for (int col = 0; col < sudokuArray[row].length; col++) {
                System.out.print(sudokuArray[row][col] + " ");
                if (col == sudokuArray[row].length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }

    public static void printPostGameStatistics(int countFullBoardChecks, long calculationTimeInMillis) {
        String output = String.format("""
                --------- Post Game Statistics -----------
                Number of full sudoku board iterations: %s
                Calculation duration: %d ms
                ------------------------------------------
                """, countFullBoardChecks, calculationTimeInMillis);
        System.out.println(output);
    }
}
