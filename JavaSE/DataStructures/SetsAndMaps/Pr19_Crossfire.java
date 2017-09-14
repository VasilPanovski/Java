import java.util.*;

public class Pr19_Crossfire {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] matrixDimention = scn.nextLine().trim().split("\\s+");

        int rows = Integer.parseInt(matrixDimention[0]);
        int cols = Integer.parseInt(matrixDimention[1]);

        int[][] matrix = new int[rows][cols];

        int counter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = counter++;
            }
        }

        String inputLine = scn.nextLine();
        while (!inputLine.equals("Nuke it from orbit")) {
            String[] tokens = inputLine.trim().split(" ");

            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);


            for (int currentCol = col - radius; currentCol <= col + radius; currentCol++) {
                if (row >= 0 && row < matrix.length && currentCol >= 0 && currentCol < matrix[row].length)
                    matrix[row][currentCol] = 0;
            }

            for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
                if (currentRow >= 0 && currentRow < matrix.length && col >= 0 && col < matrix[currentRow].length) {
                    matrix[currentRow][col] = 0;
                }
            }

            int newRows = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (Arrays.stream(matrix[i]).sum() != 0) {
                    newRows++;
                }
            }

            int[][] newMatrix = new int[newRows][];

            int newMatrixRow = 0;
            for (int currentRow = 0; currentRow < matrix.length; currentRow++) {
                if (Arrays.stream(matrix[currentRow]).sum() != 0) {
                    newMatrix[newMatrixRow++] = Arrays.stream(matrix[currentRow]).filter(num -> num != 0).toArray();
                }
            }

            matrix = newMatrix;

            inputLine = scn.nextLine();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
