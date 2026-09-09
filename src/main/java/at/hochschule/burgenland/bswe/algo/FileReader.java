package at.hochschule.burgenland.bswe.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public int[][] readSudokuBoard(String fileName) throws IOException {
        int[][] board = new int[9][9];

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src", "main", "resources", fileName))) {

            String line;
            int row = 0;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                for (int column = 0; column < values.length; column++) {
                    board[row][column] = Integer.parseInt(values[column].trim());
                }

                row++;
            }
        }

        return board;
    }
}
