import java.util.Scanner;

/**
 * Created by mm on 22.5.2016 г..
 */
public class Pr16_TargetPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        String snake = sc.nextLine();
        int impactRow = sc.nextInt();
        int impactCol = sc.nextInt();
        int radius = sc.nextInt();

        char[][] matrix = new char[rows][cols];

        int snakeIndex = 0;
        int currentRow = 0;
        for (int row = rows - 1; row >= 0; row--) {
            if (currentRow % 2 == 0) {
                for (int col = cols - 1; col >= 0; col--) {
                    matrix[row][col] = snake.charAt(snakeIndex % snake.length());
                    snakeIndex++;
                }
            } else {
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = snake.charAt(snakeIndex % snake.length());
                    snakeIndex++;
                }
            }
            currentRow++;
        }

        removeImpactedCells(impactRow, impactCol, radius, matrix);

        for (int col = 0; col < cols; col++) {
            clearImpactedCells(matrix, col);
        }

        printMatrix(matrix);
    }

    private static void clearImpactedCells(char[][] matrix, int col) {
        while (true) {
            boolean hasFallen = false;

            for (int row = 1; row < matrix.length; row++) {
                char charOnTop = matrix[row-1][col];
                char currentChar = matrix[row][col];
                if (currentChar == ' ' && charOnTop != ' ') {
                    matrix[row][col] = charOnTop;
                    matrix[row-1][col] = ' ';
                    hasFallen = true;
                }
            }
            if (!hasFallen) {
                break;
            }
        }
    }

    private static void removeImpactedCells(int inpactRow, int inpactCol, int radius, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                boolean isInRange = Math.pow(row - inpactRow, 2) + Math.pow(col - inpactCol, 2) <= Math.pow(radius, 2);
                if (isInRange) {
                    matrix[row][col] = ' ';
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
