/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-11
 * Modified: 2024-06-11
 * Description: Test 01
 */

package Test01;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class MatrixGeneration implements Summable {
    private static final SecureRandom random = new SecureRandom();
    final static int BOUNCE = 100; // random integer from [0, 100)
    private int[][] matrix;

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public int sumRow(int row) {
        int sum = 0;
        // get matrix from this class
        for (int i = 0; i < this.matrix[row].length; i++) {
            sum += this.matrix[row][i];
        }

        return sum;
    }

    @Override
    public int sumColumn(int[][] matrix, int colIndex) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][colIndex];
        }

        return sum;
    }

    public static int[][] createMatrix(int size) {
        int[][] matrix = new int[size][size];

        for (int m =0; m < size; m++) {
            for (int n = 0; n < size; n++) {
                matrix[m][n] = random.nextInt(BOUNCE);
            }
        }

        return matrix;
    }

    public ArrayList<Integer> getLargestSumRows(int[][] matrix) {
        ArrayList<Integer> largestSumRow = new ArrayList<>();
        int largestSum = 0;
        for (int i =0; i < matrix.length; i++) {
            int sum = sumRow(i);
            if(sum > largestSum) {
                largestSum = sum;
                largestSumRow.clear();
                largestSumRow.add(i);
            } else if (sum == largestSum) {
                largestSumRow.add(i);
            }
        }

        return largestSumRow;
    }

    public ArrayList<Integer> getLargestSumCols(int[][] matrix) {
        ArrayList<Integer> largestSumCol = new ArrayList<>();
        int largestSum = 0;
        for (int i =0; i < matrix[0].length; i++) {
            int sum = sumColumn(matrix, i);
            if(sum > largestSum) {
                largestSum = sum;
                largestSumCol.clear();
                largestSumCol.add(i);
            } else if (sum == largestSum) {
                largestSumCol.add(i);
            }
        }

        return largestSumCol;
    }

    public static void main(String[] args) {
        MatrixGeneration mg = new MatrixGeneration();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the matrix size n: ");
        int matrixSize = scanner.nextInt();

        int[][] matrix = createMatrix(matrixSize);
        mg.setMatrix(matrix);
        scanner.close();
        System.out.println("The random matrix is: ");
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.printf("%02d ", col);
            }
            System.out.println();
        }

        ArrayList<Integer> largestSumRow = mg.getLargestSumRows(matrix);
        System.out.print("The largest row index: ");
        // print out the largest row index
        for (int i = 0; i < largestSumRow.size(); i++) {
            System.out.printf("%d", largestSumRow.get(i));
            if( i < largestSumRow.size()-1) {
                // use comma to split
                System.out.print(", ");
            }
        }
        System.out.println();

        ArrayList<Integer> largestSumCol = mg.getLargestSumCols(matrix);
        System.out.print("The largest column index: ");
        // print out the largest column index
        for (int i = 0; i < largestSumCol.size(); i++) {
            System.out.printf("%d", largestSumCol.get(i));
            if( i < largestSumCol.size()-1) {
                // use comma to split
                System.out.print(", ");
            }
        }
        System.out.println("\nProgrammed by Bo Qu - 41118521");
    }
}
