import java.util.Scanner;

/**
 * Created by mm on 20.5.2016 г..
 */
public class Pr15_RubixMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[rows][cols];
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = counter++;
            }
        }

        int commandsCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < commandsCount; i++) {
            String[] currentCommand = sc.nextLine().trim().split(" ");

            String direction = currentCommand[1];
            int currentPosition = Integer.parseInt(currentCommand[0]);
            int moves = Integer.parseInt(currentCommand[2]);

            switch (direction) {
                case "up": moveUpElements(matrix, currentPosition, moves); break;
                case "right": moveRightElements(matrix, currentPosition, moves); break;
                case "left": moveLeftElements(matrix, currentPosition, moves); break;
                case "down": moveDownElements(matrix, currentPosition, moves); break;
            }
        }

        int checkNum = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == checkNum) {
                    System.out.println("No swap required");
                } else {
                    findValuePosition(matrix, row, col, checkNum);
                }
                checkNum++;
            }
        }

       // printMatrix(matrix);
    }

    private static void findValuePosition(int[][] matrix, int row, int col, int chekNum) {
        int currentValue = matrix[row][col];
        boolean swapped = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == chekNum) {
                    matrix[row][col] = matrix[i][j];
                    matrix[i][j] = currentValue;
                    System.out.printf("Swap (%d, %d) with (%d, %d)\n", row, col, i, j);
                    swapped = true;
                    break;
                }
            }
            if (swapped) {
                break;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void moveDownElements(int[][] matrix, int currentCol, int moves) {
        moves %= matrix.length;

        for (int i = 0; i < moves; i++) {
            int tempNum = matrix[matrix.length - 1][currentCol];
            for (int currentRow = matrix.length - 1; currentRow > 0; currentRow--) {
                matrix[currentRow][currentCol] = matrix[currentRow - 1][currentCol];
            }
            matrix[0][currentCol] = tempNum;
        }
    }

    private static void moveUpElements(int[][] matrix, int currentCol, int moves) {
        moves %= matrix.length;
        for (int i = 0; i < moves; i++) {
            int tempNum = matrix[0][currentCol];
            for (int currentRow = 0; currentRow < matrix.length - 1; currentRow++) {
                matrix[currentRow][currentCol] = matrix[currentRow + 1][currentCol];
            }
            matrix[matrix.length - 1][currentCol] = tempNum;
        }
    }

    private static void moveLeftElements(int[][] matrix, int currentRow, int moves) {
        moves %= matrix[currentRow].length;
        for (int i = 0; i < moves; i++) {
            int tempNum = matrix[currentRow][0];
            for (int currentCol = 0; currentCol < matrix[currentRow].length - 1; currentCol++) {
                matrix[currentRow][currentCol] = matrix[currentRow][currentCol + 1];
            }
            matrix[currentRow][matrix[currentRow].length - 1] = tempNum;
        }
    }

    private static void moveRightElements(int[][] matrix, int currentRow, int moves) {
        moves %= matrix[currentRow].length;
        for (int i = 0; i < moves; i++) {
            int tempNum = matrix[currentRow][matrix[currentRow].length - 1];
            for (int currentCol = matrix[currentRow].length - 1; currentCol > 0; currentCol--) {
                matrix[currentRow][currentCol] = matrix[currentRow][currentCol-1];
            }
            matrix[currentRow][0] = tempNum;
        }
    }
}
