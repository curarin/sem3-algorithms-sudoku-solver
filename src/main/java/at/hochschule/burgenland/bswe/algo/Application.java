package at.hochschule.burgenland.bswe.algo;

public class Application {
    public static void run() {
        int input;
        InputHandler handler = new InputHandler();

        Menu.startMenu();

        do {
            Menu.mainMenu();
            input = handler.getInputChoice();
            switch (input) {
                case 1 -> {
                    System.out.println("YOU CHOOSE 1");
                }
                case 2 -> {
                    FileReader fileReader = new FileReader();
                    try {
                        int[][] sudokuArray = fileReader.readSudokuBoard("input.csv");
                        System.out.println("--------- INITIAL STATE ---------");
                        StatisticsPrinter.printSudokuBoard(sudokuArray);
                        int[][] solution = Solver.solve(sudokuArray);
                        System.out.println("--------- FULL SOLUTION ---------");
                        StatisticsPrinter.printSudokuBoard(solution);
                        System.exit(0);
                    } catch (Exception e) {
                        System.out.println("Cant load data from file: " + e.getMessage());
                        input = -1;
                    }

                }
                case 3 -> {
                    System.out.println("Thanks for using the Paul Mitsch Sudoku Resolver. Come back any time.");
                }
                default -> {
                    System.out.println("Invalid choice. Try again.");
                    input = -1;
                }
            }
        } while (input != 3);
    }
}
