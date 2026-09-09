package at.hochschule.burgenland.bswe.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolverTest {
    int[][] sudokuArray = {
            //0,1,2, 3, 4,  5, 6, 7, 8
            {5, 3, 0, 0, 7, 0, 0, 0, 0}, // 0
            {6, 0, 0, 1, 9, 5, 0, 0, 0}, // 1
            {0, 9, 8, 0, 0, 0, 0, 6, 0}, // 2
            {8, 0, 0, 0, 6, 0, 0, 0, 3}, // 3
            {4, 0, 0, 8, 0, 3, 0, 0, 1}, // 4
            {7, 0, 0, 0, 2, 0, 0, 0, 6}, // 5
            {0, 6, 0, 0, 0, 0, 2, 8, 0}, // 6t
            {0, 0, 0, 4, 1, 9, 0, 0, 5}, // 7
            {0, 0, 0, 0, 8, 0, 0, 7, 9} // 8
    };

    @Test
    public void isValidNumberInRow_givenArrayWithNumberExistInSameRow_shouldReturnFalse() {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        assertFalse(sudoku.isValidNumberInRow(0, 7));
        assertFalse(sudoku.isValidNumberInRow(1, 5));
        assertFalse(sudoku.isValidNumberInRow(2, 8));
        assertFalse(sudoku.isValidNumberInRow(3, 3));
        assertFalse(sudoku.isValidNumberInRow(4, 1));
        assertFalse(sudoku.isValidNumberInRow(5, 2));
        assertFalse(sudoku.isValidNumberInRow(6, 6));
        assertFalse(sudoku.isValidNumberInRow(7, 4));
        assertFalse(sudoku.isValidNumberInRow(8, 8));
    }

    @Test
    public void isValidNumberInRow_givenArrayWithNumberDoesNotExistInSameRow_shouldReturnTrue() {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        assertTrue(sudoku.isValidNumberInRow(0, 1));
        assertTrue(sudoku.isValidNumberInRow(1, 2));
        assertTrue(sudoku.isValidNumberInRow(2, 3));
        assertTrue(sudoku.isValidNumberInRow(3, 4));
        assertTrue(sudoku.isValidNumberInRow(4, 5));
        assertTrue(sudoku.isValidNumberInRow(5, 4));
        assertTrue(sudoku.isValidNumberInRow(6, 9));
        assertTrue(sudoku.isValidNumberInRow(7, 2));
        assertTrue(sudoku.isValidNumberInRow(8, 6));
    }

    @Test
    public void isValidNumberInColumn_givenArrayWithNumberExistInSameColumn_shouldReturnFalse() {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        assertFalse(sudoku.isValidNumberInColumn(0, 5));
        assertFalse(sudoku.isValidNumberInColumn(1, 9));
        assertFalse(sudoku.isValidNumberInColumn(2, 8));
        assertFalse(sudoku.isValidNumberInColumn(3, 4));
        assertFalse(sudoku.isValidNumberInColumn(4, 1));
        assertFalse(sudoku.isValidNumberInColumn(5, 9));
        assertFalse(sudoku.isValidNumberInColumn(6, 2));
        assertFalse(sudoku.isValidNumberInColumn(7, 8));
        assertFalse(sudoku.isValidNumberInColumn(8, 5));
    }

    @Test
    public void isValidNumberInColumn_givenArrayWithNumbersDoesNotExistInSameColumn_shouldReturnTrue() {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        assertTrue(sudoku.isValidNumberInColumn(0, 1));
        assertTrue(sudoku.isValidNumberInColumn(1, 2));
        assertTrue(sudoku.isValidNumberInColumn(2, 3));
        assertTrue(sudoku.isValidNumberInColumn(3, 5));
        assertTrue(sudoku.isValidNumberInColumn(4, 5));
        assertTrue(sudoku.isValidNumberInColumn(5, 6));
        assertTrue(sudoku.isValidNumberInColumn(6, 7));
        assertTrue(sudoku.isValidNumberInColumn(7, 1));
        assertTrue(sudoku.isValidNumberInColumn(8, 2));
    }

    @Test
    public void isValidNumberInQuadrant_givenArrayWithNumberExistsInSameQuadrant_shouldReturnFalse() {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        assertFalse(sudoku.isValidNumberInQuadrant(6, 6, 9));
        assertFalse(sudoku.isValidNumberInQuadrant(5, 5, 8));
        assertFalse(sudoku.isValidNumberInQuadrant(2, 2, 5));
    }

    @Test
    public void isValidNumberInQuadrant_givenArrayWithNumberDoesNotExistInSameQuadrant_shouldReturnTrue() {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        assertTrue(sudoku.isValidNumberInQuadrant(0, 1, 1));
        assertTrue(sudoku.isValidNumberInQuadrant(5, 5, 1));
        assertTrue(sudoku.isValidNumberInQuadrant(1, 6, 1));
    }

    @Test
    public void countEmptyCells_givenArrayWith51EmptyCells_shouldReturn51() {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        assertEquals(51, sudoku.getEmptyCellCounter());
    }
}
