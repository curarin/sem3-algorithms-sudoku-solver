package at.hochschule.burgenland.bswe.algo;

public class Menu {
    public static void startMenu() {
        String menu = """
                ################################
                WELCOME TO SUDOKU PUZZLE SOLVER
                        BY PAUL MITSCH
                ################################
                """;
        System.out.println(menu);
    }

    public static void mainMenu() {
        String menu = """
                ################################
                Please choose your pick:
                (1) Load sudoku via CLI input
                (2) Load sudoku from input file
                (3) Exit
                """;
        System.out.println(menu);
    }


}
