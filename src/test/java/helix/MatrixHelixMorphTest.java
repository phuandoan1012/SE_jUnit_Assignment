package helix;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {

    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    // ADD TESTS TO CHECK PARTITIONS
    @Test
    public void test3x3() {
        int[][] inMatrix  = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] expOutput = { {1, 2, 3}, {8, 9, 4}, {7, 6, 5} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test4x5() {
        int[][] inMatrix  = { {7, 5, 1, 4, 6},
                              {3, 2, 9, 1, 8},
                              {8, 3, 2, 4, 1},
                              {10, 11, 15, 19, 14}};

        int[][] expOutput = { {7, 5, 1, 4, 6},
                              {4, 1, 10, 11, 3},
                              {2, 14, 19, 15, 2},
                              {3, 8, 8, 1, 9}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test4x4() {
        int[][] inMatrix  = { {7, 5, 1, 4},
                {3, 2, 9, 1},
                {8, 3, 2, 4},
                {10, 11, 15, 19}};

        int[][] expOutput = { {7, 5, 1, 4},
                {4, 10, 11, 3},
                {2, 19, 15, 2},
                {3, 8, 1, 9}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test4x6() {
        int[][] inMatrix  = { {7, 5, 1, 4, 6, 9},
                {3, 2, 9, 1, 8, 7},
                {8, 3, 2, 4, 1, 6},
                {10, 11, 15, 19, 14, 5}};

        int[][] expOutput = { {7, 5, 1, 4, 6, 9},
                {4, 1, 6, 10, 11, 3},
                {2, 5, 14, 19, 15, 2},
                {3, 8, 7, 8, 1, 9}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test4x7() {
        int[][] inMatrix  = { {7, 5, 1, 4, 6, 9, 1},
                {3, 2, 9, 1, 8, 7, 3},
                {8, 3, 2, 4, 1, 6, 5},
                {10, 11, 15, 19, 14, 5, 7}};

        int[][] expOutput = { {7, 5, 1, 4, 6, 9, 1},
                {4, 1, 6, 5, 10, 11, 3},
                {2, 7, 5, 14, 19, 15, 2},
                {3, 8, 3, 7, 8, 1, 9}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test5x5() {
        int[][] inMatrix  = { {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}};

        int[][] expOutput = { {1, 2, 3, 4, 5},
                              {14, 23, 22, 21, 16},
                              {7, 10, 9, 8, 17},
                              {20, 11, 12, 13, 18},
                              {25, 24, 15, 6, 19}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test5x6() {
        int[][] inMatrix  = { {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30}};

        int[][] expOutput = { {1, 2, 3, 4, 5, 6},
                {18, 19, 20, 21, 22, 7},
                {17, 28, 29, 30, 23, 8},
                {16, 27, 26, 25, 24, 9},
                {15, 14, 13, 12, 11, 10}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test5x9() {
        int[][] inMatrix  = { {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24, 25, 26, 27},
                {28, 29, 30, 31, 32, 33, 34, 35, 36},
                {37, 38, 39, 40, 41, 42, 43, 44, 45}};

        int[][] expOutput = { {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {24, 25, 26, 27, 28, 29, 30, 31, 10},
                {23, 40, 41, 42, 43, 44, 45, 32, 11},
                {22, 39, 38, 37, 36, 35, 34, 33, 12},
                {21, 20, 19, 18, 17, 16, 15, 14, 13}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
}
