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
        System.out.println("-------------------------------");
    }

    public static void printPostGameStatistics(int countFullBoardChecks, long calculationTimeInMillis) {
        String output = String.format("""
                ##########################################
                --------- Post Game Statistics -----------
                Number of full sudoku board iterations: %s
                Calculation duration: %d ms
                ------------------------------------------
                """, countFullBoardChecks, calculationTimeInMillis);
        System.out.println(output);
    }

    public static void printNoSolutionPossible(int lastIterationFullSudokuInterationCounter, int fullSudokuInterationCounter, int lastIterationEmptyCellCounter, int emptyCellCounter) {
        System.out.println("No Solution is possible anymore - we iterated through a whole board cycle again (before: " + lastIterationFullSudokuInterationCounter + ", now: " + fullSudokuInterationCounter + ") - but the empty cell counter is still then same as before: (before: " + lastIterationEmptyCellCounter + ", now: " + emptyCellCounter + ")");
    }

    public static void printBreakingOutOfIterationDueToOptimization(int row, int col) {
        String output = String.format("Breaking out of loop on Row/Col %s/%s because we already have more than one valid option.", row, col);
        System.out.println(output);
    }
    public static void printValidOptionInIteration(int row, int col, int validOption) {
        String output = String.format("Valid option found on %s/%s -> %s", row, col, validOption);
        System.out.println(output);
    }
}
