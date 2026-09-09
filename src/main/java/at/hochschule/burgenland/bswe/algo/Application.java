package at.hochschule.burgenland.bswe.algo;

public class Application {
    public static void run() {
        int[][] sudokuArray = {
                //0,1,2, 3, 4,  5, 6, 7, 8
                {5, 3, 0, 0, 7, 0, 0, 0, 0}, // 0
                {6, 0, 0, 1, 9, 5, 0, 0, 0}, // 1
                {0, 9, 8, 0, 0, 0, 0, 6, 0}, // 2
                {8, 0, 0, 0, 6, 0, 0, 0, 3}, // 3
                {4, 0, 0, 8, 0, 3, 0, 0, 1}, // 4
                {7, 0, 0, 0, 2, 0, 0, 0, 6}, // 5
                {0, 6, 0, 0, 0, 0, 2, 8, 0}, // 6
                {0, 0, 0, 4, 1, 9, 0, 0, 5}, // 7
                {0, 0, 0, 0, 8, 0, 0, 7, 9} // 8
        };

        int[][] solution = Solver.solve(sudokuArray);
        System.out.println("-----------------------");
        System.out.print("SOLUTION:\n");
        for (int row = 0; row < solution.length; row++) {
            for (int col = 0; col < solution[row].length; col++) {
                System.out.print(solution[row][col] + " ");
                if (col == solution[row].length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }
}
