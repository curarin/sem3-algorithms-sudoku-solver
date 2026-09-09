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
        assertFalse(Solver.isValidNumberInRow(sudokuArray, 0, 7));
        assertFalse(Solver.isValidNumberInRow(sudokuArray, 1, 5));
        assertFalse(Solver.isValidNumberInRow(sudokuArray, 2, 8));
        assertFalse(Solver.isValidNumberInRow(sudokuArray, 3, 3));
        assertFalse(Solver.isValidNumberInRow(sudokuArray, 4, 1));
        assertFalse(Solver.isValidNumberInRow(sudokuArray, 5, 2));
        assertFalse(Solver.isValidNumberInRow(sudokuArray, 6, 6));
        assertFalse(Solver.isValidNumberInRow(sudokuArray, 7, 4));
        assertFalse(Solver.isValidNumberInRow(sudokuArray, 8, 8));
    }

    @Test
    public void isValidNumberInRow_givenArrayWithNumberDoesNotExistInSameRow_shouldReturnTrue() {
        assertTrue(Solver.isValidNumberInRow(sudokuArray, 0, 1));
        assertTrue(Solver.isValidNumberInRow(sudokuArray, 1, 2));
        assertTrue(Solver.isValidNumberInRow(sudokuArray, 2, 3));
        assertTrue(Solver.isValidNumberInRow(sudokuArray, 3, 4));
        assertTrue(Solver.isValidNumberInRow(sudokuArray, 4, 5));
        assertTrue(Solver.isValidNumberInRow(sudokuArray, 5, 4));
        assertTrue(Solver.isValidNumberInRow(sudokuArray, 6, 9));
        assertTrue(Solver.isValidNumberInRow(sudokuArray, 7, 2));
        assertTrue(Solver.isValidNumberInRow(sudokuArray, 8, 6));
    }

    @Test
    public void isValidNumberInColumn_givenArrayWithNumberExistInSameColumn_shouldReturnFalse() {
        assertFalse(Solver.isValidNumberInColumn(sudokuArray, 0, 5));
        assertFalse(Solver.isValidNumberInColumn(sudokuArray, 1, 9));
        assertFalse(Solver.isValidNumberInColumn(sudokuArray, 2, 8));
        assertFalse(Solver.isValidNumberInColumn(sudokuArray, 3, 4));
        assertFalse(Solver.isValidNumberInColumn(sudokuArray, 4, 1));
        assertFalse(Solver.isValidNumberInColumn(sudokuArray, 5, 9));
        assertFalse(Solver.isValidNumberInColumn(sudokuArray, 6, 2));
        assertFalse(Solver.isValidNumberInColumn(sudokuArray, 7, 8));
        assertFalse(Solver.isValidNumberInColumn(sudokuArray, 8, 5));
    }

    @Test
    public void isValidNumberInColumn_givenArrayWithNumbersDoesNotExistInSameColumn_shouldReturnTrue() {
        assertTrue(Solver.isValidNumberInColumn(sudokuArray, 0, 1));
        assertTrue(Solver.isValidNumberInColumn(sudokuArray, 1, 2));
        assertTrue(Solver.isValidNumberInColumn(sudokuArray, 2, 3));
        assertTrue(Solver.isValidNumberInColumn(sudokuArray, 3, 5));
        assertTrue(Solver.isValidNumberInColumn(sudokuArray, 4, 5));
        assertTrue(Solver.isValidNumberInColumn(sudokuArray, 5, 6));
        assertTrue(Solver.isValidNumberInColumn(sudokuArray, 6, 7));
        assertTrue(Solver.isValidNumberInColumn(sudokuArray, 7, 1));
        assertTrue(Solver.isValidNumberInColumn(sudokuArray, 8, 2));
    }

    @Test
    public void isValidNumberInQuadrant_givenArrayWithNumberExistsInSameQuadrant_shouldReturnFalse() {
        assertFalse(Solver.isValidNumberInQuadrant(sudokuArray, 6, 6, 9));
        assertFalse(Solver.isValidNumberInQuadrant(sudokuArray, 5, 5, 8));
        assertFalse(Solver.isValidNumberInQuadrant(sudokuArray, 2, 2, 5));
    }

    @Test
    public void isValidNumberInQuadrant_givenArrayWithNumberDoesNotExistInSameQuadrant_shouldReturnTrue() {
        assertTrue(Solver.isValidNumberInQuadrant(sudokuArray, 0, 1, 1));
        assertTrue(Solver.isValidNumberInQuadrant(sudokuArray, 5, 5, 1));
        assertTrue(Solver.isValidNumberInQuadrant(sudokuArray, 1, 6, 1));
    }

    @Test
    public void countEmptyCells_givenArrayWith51EmptyCells_shouldReturn51() {
        assertEquals(0, Solver.emptyCellCounter);
        Solver.countEmptyCells(sudokuArray);
        assertEquals(51, Solver.emptyCellCounter);
    }
}
