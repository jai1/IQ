package org.interview.questions;

/*
 * Given a matrix and two x, y co-ordinates find the greatest number in the sub matrix
 * 
 * Throw exception if the co-ordinates are invalid
 * 
 * Assume that the matrix won't change much - implement caching
 * 
 * ##Medium ##DynamicProgramming 
 */
public class GreatestNumberInMatrix {

    int[][][] matrix;
    /*
     * Converting the 2D matrix into 3D Matrix where 1-D is the column number and the remaining two dimensions are the
     * lowest and highest row number Space complexity O(m x m x n) while brute force O(m x n) Time Complexity O(n) while
     * brute force O(m x n)
     */

    public GreatestNumberInMatrix(int[][] matrix) {
        precompute(matrix);
    }

    private void precompute(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        this.matrix = new int[numRows][numRows][numCols];

        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y < numRows; y++) {
                for (int z = 0; z < numCols; z++) {
                    this.matrix[x][y][z] = Integer.MIN_VALUE;
                }
            }
        }

        for (int lowerX = 0; lowerX < numRows; lowerX++) {
            for (int higherX = 0; higherX < numRows; higherX++) {
                for (int y = 0; y < numCols; y++) {
                    int t = higherX == 0 ? 0 : higherX - 1;
                    this.matrix[lowerX][higherX][y] = this.matrix[lowerX][t][y] > matrix[higherX][y] ? this.matrix[lowerX][t][y]
                            : matrix[higherX][y];
                }
            }
        }
    }

    int findGreatestNumber(int x1, int y1, int x2, int y2) {
        int lowestX = Math.min(x1, x2);
        int highestX = Math.max(x1, x2);
        int greatestNumber = Integer.MIN_VALUE;
        for (int y = y1; y <= y2; y++) {
            int number = matrix[lowestX][highestX][y];
            greatestNumber = number > greatestNumber ? number : greatestNumber;
        }
        return greatestNumber;
    }
}
