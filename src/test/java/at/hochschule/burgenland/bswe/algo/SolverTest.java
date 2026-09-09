package at.hochschule.burgenland.bswe.algo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    /**
     * Source: https://www.baeldung.com/java-unit-test-private-methods
     *
     * @return reflection
     * @throws NoSuchMethodException method does not exist
     */
    private Method getIsValidNumberInQuadrant() throws NoSuchMethodException {
        Method method = Sudoku.class.getDeclaredMethod("isValidNumberInQuadrant", int.class, int.class, int.class);
        method.setAccessible(true);
        return method;
    }

    /**
     * Source: https://www.baeldung.com/java-unit-test-private-methods
     *
     * @return reflection
     * @throws NoSuchMethodException method does not exist
     */
    private Method getIsValidNumberInColumn() throws NoSuchMethodException {
        Method method = Sudoku.class.getDeclaredMethod("isValidNumberInColumn", int.class, int.class);
        method.setAccessible(true);
        return method;
    }

    /**
     * Source: https://www.baeldung.com/java-unit-test-private-methods
     *
     * @return reflection
     * @throws NoSuchMethodException method does not exist
     */
    private Method getIsValidNumberInRow() throws NoSuchMethodException {
        Method method = Sudoku.class.getDeclaredMethod("isValidNumberInRow", int.class, int.class);
        method.setAccessible(true);
        return method;
    }

    @Test
    public void isValidNumberInRow_givenArrayWithNumberExistInSameRow_shouldReturnFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        Method method = getIsValidNumberInRow();
        assertFalse((boolean) method.invoke(sudoku, 0, 7));
        assertFalse((boolean) method.invoke(sudoku, 1, 5));
        assertFalse((boolean) method.invoke(sudoku, 2, 8));
        assertFalse((boolean) method.invoke(sudoku, 3, 3));
        assertFalse((boolean) method.invoke(sudoku, 4, 1));
        assertFalse((boolean) method.invoke(sudoku, 5, 2));
        assertFalse((boolean) method.invoke(sudoku, 6, 6));
        assertFalse((boolean) method.invoke(sudoku, 7, 4));
        assertFalse((boolean) method.invoke(sudoku, 8, 8));
    }

    @Test
    public void isValidNumberInRow_givenArrayWithNumberDoesNotExistInSameRow_shouldReturnTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        Method method = getIsValidNumberInRow();
        assertTrue((boolean) method.invoke(sudoku, 0, 1));
        assertTrue((boolean) method.invoke(sudoku, 1, 2));
        assertTrue((boolean) method.invoke(sudoku, 2, 3));
        assertTrue((boolean) method.invoke(sudoku, 3, 4));
        assertTrue((boolean) method.invoke(sudoku, 4, 5));
        assertTrue((boolean) method.invoke(sudoku, 5, 4));
        assertTrue((boolean) method.invoke(sudoku, 6, 9));
        assertTrue((boolean) method.invoke(sudoku, 7, 2));
        assertTrue((boolean) method.invoke(sudoku, 8, 6));
    }

    @Test
    public void isValidNumberInColumn_givenArrayWithNumberExistInSameColumn_shouldReturnFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        Method method = getIsValidNumberInColumn();
        assertFalse((boolean) method.invoke(sudoku, 0, 5));
        assertFalse((boolean) method.invoke(sudoku, 1, 9));
        assertFalse((boolean) method.invoke(sudoku, 2, 8));
        assertFalse((boolean) method.invoke(sudoku, 3, 4));
        assertFalse((boolean) method.invoke(sudoku, 4, 1));
        assertFalse((boolean) method.invoke(sudoku, 5, 9));
        assertFalse((boolean) method.invoke(sudoku, 6, 2));
        assertFalse((boolean) method.invoke(sudoku, 7, 8));
        assertFalse((boolean) method.invoke(sudoku, 8, 5));
    }

    @Test
    public void isValidNumberInColumn_givenArrayWithNumbersDoesNotExistInSameColumn_shouldReturnTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        Method method = getIsValidNumberInColumn();
        assertTrue((boolean) method.invoke(sudoku, 0, 1));
        assertTrue((boolean) method.invoke(sudoku, 1, 2));
        assertTrue((boolean) method.invoke(sudoku, 2, 3));
        assertTrue((boolean) method.invoke(sudoku, 3, 5));
        assertTrue((boolean) method.invoke(sudoku, 4, 5));
        assertTrue((boolean) method.invoke(sudoku, 5, 6));
        assertTrue((boolean) method.invoke(sudoku, 6, 7));
        assertTrue((boolean) method.invoke(sudoku, 7, 1));
        assertTrue((boolean) method.invoke(sudoku, 8, 2));
    }

    @Test
    public void isValidNumberInQuadrant_givenArrayWithNumberExistsInSameQuadrant_shouldReturnFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        Method method = getIsValidNumberInQuadrant();
        assertFalse((boolean) method.invoke(sudoku, 6, 6, 9));
        assertFalse((boolean) method.invoke(sudoku, 5, 5, 8));
        assertFalse((boolean) method.invoke(sudoku, 2, 2, 5));
    }

    @Test
    public void isValidNumberInQuadrant_givenArrayWithNumberDoesNotExistInSameQuadrant_shouldReturnTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        Method method = getIsValidNumberInQuadrant();
        assertTrue((boolean) method.invoke(sudoku, 0, 1, 1));
        assertTrue((boolean) method.invoke(sudoku, 5, 5, 1));
        assertTrue((boolean) method.invoke(sudoku, 1, 6, 1));
    }

    @Test
    public void countEmptyCells_givenArrayWith51EmptyCells_shouldReturn51() {
        Sudoku sudoku = Sudoku.instanceOf(sudokuArray);
        assertEquals(51, sudoku.getEmptyCellCounter());
    }
}
