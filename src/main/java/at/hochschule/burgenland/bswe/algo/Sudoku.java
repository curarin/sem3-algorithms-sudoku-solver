package at.hochschule.burgenland.bswe.algo;

/**
 * Singleton Sudoku class which holds the current puzzle, an emptyCellCounter as well as offers some public methods
 * for solving puzzles and stuff.@
 */
public class Sudoku {
    private static Sudoku INSTANCE;
    private int emptyCellCounter;
    private int lastIterationEmptyCellCounter;
    private int fullSudokuInterationCounter;
    private int lastIterationFullSudokuInterationCounter;
    private final int[][] sudokuArray;
    private long algorithmCalculationTimeInMillis;

    private Sudoku(int[][] sudokuArray) {
        this.sudokuArray = sudokuArray;
        this.countEmptyCells();
    }

    /**
     * static factory method which creates an instance of a sudoku puzzle
     *
     * @param sudokuArray raw data (sudoku)
     * @return instance of Sudoku
     */
    public static Sudoku instanceOf(int[][] sudokuArray) {
        if (INSTANCE == null) {
            INSTANCE = new Sudoku(sudokuArray);
        }
        return INSTANCE;
    }

    /**
     * Checks the given potential solution if its a valid solution with the same row of the 2d array / dataframe
     *
     * @param currentRow        current position within the 2d array (row)
     * @param potentialSolution the current potential solution to be checked
     * @return true if its valid
     */
    private boolean isValidNumberInRow(int currentRow, int potentialSolution) {
        for (int col = 0; col < this.sudokuArray[0].length; col++) {
            if (this.sudokuArray[currentRow][col] == potentialSolution) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks the given potential solution if its a valid solution with the same column of the 2d array / dataframe
     *
     * @param currentCol        current position with the 2d array (column)
     * @param potentialSolution the current potential solution to be checked
     * @return true if its valid
     */
    private boolean isValidNumberInColumn(int currentCol, int potentialSolution) {
        for (int row = 0; row < this.sudokuArray.length; row++) {
            if (this.sudokuArray[row][currentCol] == potentialSolution) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks the given potential solution if its a valid solution with the same quadrant of the 2d array / dataframe
     *
     * @param currentRow        current position within the 2d array (row)
     * @param currentCol        current position with the 2d array (column)
     * @param potentialSolution the current potential solution to be checked
     * @return true if its valid
     */
    private boolean isValidNumberInQuadrant(int currentRow, int currentCol, int potentialSolution) {
        int quadrantStartRow = currentRow - (currentRow % 3);
        int quadrantStartCol = currentCol - (currentCol % 3);

        for (int quadrantRow = 0; quadrantRow < 3; quadrantRow++) {
            for (int quadrantCol = 0; quadrantCol < 3; quadrantCol++) {
                int currentIterationRow = quadrantRow + quadrantStartRow;
                int currentIterationCol = quadrantCol + quadrantStartCol;
                if (this.sudokuArray[currentIterationRow][currentIterationCol] == potentialSolution) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Helper method for counting the total available cells exactly once. Used as cancel condition for iterating over the sudoku if it hits 0.
     */
    private void countEmptyCells() {
        for (int row = 0; row < this.sudokuArray.length; row++) {
            for (int col = 0; col < this.sudokuArray[0].length; col++) {
                if (this.sudokuArray[row][col] == 0) {
                    this.emptyCellCounter++;
                }
            }
        }
    }

    /**
     * Checks whether a solution is still possible or not.
     *
     * @return true, if at least one number changes every full board cycle checks
     */
    public boolean solutionIsStillPossible() {
        if (this.lastIterationEmptyCellCounter == this.emptyCellCounter && this.lastIterationFullSudokuInterationCounter != this.fullSudokuInterationCounter) {
            StatisticsPrinter.printNoSolutionPossible(this.lastIterationFullSudokuInterationCounter, this.fullSudokuInterationCounter, this.lastIterationEmptyCellCounter, this.emptyCellCounter);
            return false;
        }
        this.lastIterationEmptyCellCounter = this.emptyCellCounter;
        this.lastIterationFullSudokuInterationCounter = this.fullSudokuInterationCounter;
        return true;
    }

    /**
     * Solves the sudoku puzzle with super fancy algorithms
     */
    public void solve() {
        long calculationStartingTimeInNanoTime = System.nanoTime();
        for (int row = 0; row < this.sudokuArray.length; row++) {
            for (int col = 0; col < this.sudokuArray[0].length; col++) {
                if (row == 0 && col == 0) {
                    fullSudokuInterationCounter++;
                }
                if (this.sudokuArray[row][col] == 0) {
                    int[] possibleOptions = new int[8];
                    int possibleOptionsCounter = 0;
                    int indexCounter = 0;

                    for (int possibleOption = 1; possibleOption < 10; possibleOption++) {
                        if (isValidNumberInRow(row, possibleOption) && isValidNumberInColumn(col, possibleOption) && isValidNumberInQuadrant(row, col, possibleOption)) {
                            possibleOptions[indexCounter++] = possibleOption;
                            possibleOptionsCounter++;
                            StatisticsPrinter.printValidOptionInIteration(row, col, possibleOption);
                            if (possibleOptionsCounter > 1) {
                                StatisticsPrinter.printBreakingOutOfIterationDueToOptimization(row, col);
                                break;
                            }
                        }
                    }
                    if (possibleOptionsCounter == 1) {
                        System.out.println("In row/col " + row + "/" + col + " we found exactly one valid option: " + possibleOptions[0]);
                        this.sudokuArray[row][col] = possibleOptions[0];
                        emptyCellCounter--;
                    }
                }

            }
        }
        long calculationEndingTimeInNanoTime = System.nanoTime();
        long totalDurationInNanoTime = (calculationEndingTimeInNanoTime - calculationStartingTimeInNanoTime) / 1000000;
        this.algorithmCalculationTimeInMillis = totalDurationInNanoTime + this.algorithmCalculationTimeInMillis;
    }

    /**
     * Getter for sudoku array
     *
     * @return sudoku 2d array / dataframe
     */
    public int[][] getSudokuArray() {
        return this.sudokuArray;
    }

    /**
     * Counter for empty cells
     *
     * @return integer with current count of empty cells
     */
    public int getEmptyCellCounter() {
        return this.emptyCellCounter;
    }

    /**
     * Returns the count for full board checks. Everytime the algorithm loops through one board state as a whole,
     * the counter is increased by 1.
     *
     * @return number of full board checks
     */
    public int getFullSudokuInterationCounter() {
        return this.fullSudokuInterationCounter;
    }

    /**
     * Returns the total calculation time in milliseconds for the algorithm calculation
     *
     * @return long
     */
    public long getAlgorithmCalculationTimeInMillis() {
        return this.algorithmCalculationTimeInMillis;
    }
}
