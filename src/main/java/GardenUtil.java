import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vetal on 3/7/2017.
 *
 * Utility class for operations performed on garden
 */
public final class GardenUtil {
    private GardenUtil() {}

    /**
     * Finds the max amount of points the subject can collect by moving over the garden either right or down
     * starting from the left upper square
     * @param garden matrix
     * @return max amount of points
     */
    public static int findMaxAmount(int [][] garden) {
        int[][] resultMatrix = populateResultMatrix(garden);
        print(resultMatrix[0][0]);
        return resultMatrix[0][0];
    }

    private static void print(int content) {
        try(PrintWriter writer = new PrintWriter("output.txt", "UTF-8")) {
            writer.write(String.valueOf(content));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implementation of function F[i, j] = max(F[i+1,j], F[i,j+1] + matrix[i,j])
     * where F[i, j] is the biggest sum that can be obtained in coordinate matrix[i, j] with given
     * restriction that object can go either down or right
     * @param matrix
     * @return result matrix with calculated F[i, j] for all input matrix elements
     */
    static int[][] populateResultMatrix(int [][] matrix) {
        int m = matrix.length - 1;
        int n = matrix[m].length - 1;
        int sumBottom = 0;
        int sumRight = 0;

        //populate right border
        for (int i = m; i > -1; i--) {
            matrix[i][n] = sumRight + matrix[i][n];
            sumRight = matrix[i][n];
        }

        //populate bottom border
        for(int j = matrix[m].length - 1; j > -1; j--) {
            matrix[m][j] = sumBottom + matrix[m][j];
            sumBottom = matrix[m][j];
        }

        //populate the rest of the elements with given borders above
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                matrix[i][j] = Math.max(matrix[i + 1][j], matrix[i][j+1]) + matrix[i][j];
            }
        }
        return matrix;
    }
}
