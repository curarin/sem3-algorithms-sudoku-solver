package at.hochschule.burgenland.bswe.algo;

public class Solver {
    public static int[][] solve(int[][] array) {
        Sudoku sudoku = Sudoku.instanceOf(array);

        do {
            sudoku.solve();

        } while (sudoku.getEmptyCellCounter() > 0 && sudoku.solutionIsStillPossible());
        StatisticsPrinter.printPostGameStatistics(sudoku.getFullSudokuInterationCounter(), sudoku.getAlgorithmCalculationTimeInMillis());
        return sudoku.getSudokuArray();
    }
}
