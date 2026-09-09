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
}
