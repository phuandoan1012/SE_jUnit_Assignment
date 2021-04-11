package helix;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix( int[][] inMatrix) {
        int[] temp = new int[inMatrix.length * inMatrix[0].length];
        int[][] outputMatrix = new int[inMatrix.length][inMatrix[0].length];
        int index = -1;
        int i,j;

        for (i = 0; i < inMatrix.length; i++){
            for (j = 0; j < inMatrix[0].length; j++){
                index++;
                temp[index] = inMatrix[i][j];
            }
        }

        index = -1;

        int top = 0;
        int left = 0;
        int right = inMatrix[0].length - 1;
        int bottom = inMatrix.length - 1;

        while (true){
            if (left > right) break;
            for (i = left; i <= right; i++){
                index++;
                outputMatrix[top][i] = temp[index];
            }
            top++;

            if (top > bottom) break;
            for (i = top; i <= bottom; i++){
                index++;
                outputMatrix[i][right] = temp[index];
            }
            right--;

            if (left > right) break;
            for (i = right; i >= left; i--){
                index++;
                outputMatrix[bottom][i] = temp[index];
            }
            bottom--;

            if (top > bottom) break;
            for (i = bottom; i >= top; i--){
                index++;
                outputMatrix[i][left] = temp[index];
            }
            left++;
        }

        return outputMatrix;
    }
}

// Reference: https://www.youtube.com/watch?v=qvYY-5qepbg