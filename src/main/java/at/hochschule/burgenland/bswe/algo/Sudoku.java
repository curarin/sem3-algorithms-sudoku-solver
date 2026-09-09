package at.hochschule.burgenland.bswe.algo;

/**
 * Singleton Sudoku class which holds the current puzzle, an emptyCellCounter as well as offers some public methods
 * for solving puzzles and stuff.@
 */
public class Sudoku {
    private static Sudoku INSTANCE;
    private int emptyCellCounter;
    private final int[][] sudokuArray;

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
    public boolean isValidNumberInRow(int currentRow, int potentialSolution) {
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
    public boolean isValidNumberInColumn(int currentCol, int potentialSolution) {
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
    public boolean isValidNumberInQuadrant(int currentRow, int currentCol, int potentialSolution) {
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
    public void countEmptyCells() {
        for (int row = 0; row < this.sudokuArray.length; row++) {
            for (int col = 0; col < this.sudokuArray[0].length; col++) {
                if (this.sudokuArray[row][col] == 0) {
                    this.emptyCellCounter++;
                }
            }
        }
    }

    /**
     * Solves the sudoku puzzle with super fancy algorithms
     */
    public void solve() {
        for (int row = 0; row < this.sudokuArray.length; row++) {
            for (int col = 0; col < this.sudokuArray[0].length; col++) {
                if (this.sudokuArray[row][col] == 0) {
                    System.out.println("Iterating over Row " + row + " and Col " + col);
                    int[] possibleOptions = new int[8];
                    int possibleOptionsCounter = 0;
                    int indexCounter = 0;

                    for (int possibleOption = 1; possibleOption < 10; possibleOption++) {
                        System.out.println("Checking Number " + possibleOption);
                        if (isValidNumberInRow(row, possibleOption) && isValidNumberInColumn(col, possibleOption) && isValidNumberInQuadrant(row, col, possibleOption)) {
                            possibleOptions[indexCounter++] = possibleOption;
                            possibleOptionsCounter++;
                            System.out.println("Number " + possibleOption + " is an valid option!");
                            if (possibleOptionsCounter > 1) {
                                System.out.println("Breaking out of loop because no valid option can be found in this iteration");
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
}
