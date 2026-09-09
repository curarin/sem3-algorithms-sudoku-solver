package at.hochschule.burgenland.bswe.algo;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getInputChoice() {
        String choice = scanner.nextLine();
        if (choice == null || choice.isBlank()) {
            System.out.println("Invalid choice - please put in full numbers only");
            return -1;
        }
        try {
            return Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice - please put in full numbers only");
            return -1;
        }
    }

    public int[][] getManualSudoku() {
        int[][] manualSudoku = new int[9][9];
        System.out.println("Please enter all row values like so: 1,2,3,4,5,... - 0 is an empty field to be solved.");
        for (int row = 0; row < 9; row++) {
            int prettyRow = row + 1;
            System.out.println("Please enter row '" + prettyRow + "':");
            String input = scanner.nextLine();
            String[] rowInput = input.split(",");

            if (rowInput.length != 9) {
                System.out.println("Solving a 9x9 sudoku involves putting in exactly 9 numbers - we recognized: " + rowInput.length + ". Please try again.");
                row--;
            } else {
                for (int col = 0; col < 9; col++) {
                    try {
                        manualSudoku[row][col] = Integer.parseInt(rowInput[col].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number put in - please put in full numbers only");
                        break;
                    }
                }
            }
        }
        return manualSudoku;
    }
}
