import java.io.*;
import java.util.Optional;

/**
 * Created by vetal on 3/9/2017.
 */
public class Garden {
    private int m,n;
    private int[][] matrix;

    /**
     * Load MxN matrix from file
     * @param resource
     */
    public Garden(String resource) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(resource)))) {
            String[] split = Optional.of(br.readLine())
                                     .map(e -> e.split(" "))
                                     .orElseThrow(() -> new RuntimeException("File" + resource + " is empty"));
            m = Integer.parseInt(split[0]);
            n = Integer.parseInt(split[1]);
            matrix = new int[m][n];

            for (int i = 0; i < m; i++) {
                int rowNumber = i;
                String[] elements = Optional.of(br.readLine())
                                            .map(e -> e.split(" "))
                                            .orElseThrow(() -> new RuntimeException("Row number:" + rowNumber
                                                                                    + "of file:" + resource +
                                                                                    "should not be empty"));
                if (elements.length != n) {
                    throw new RuntimeException("Row number:" + rowNumber + "of file:" + resource +
                                               "doesn't have " + n + "elements");
                }
                for (int j = 0; j < elements.length; j++) {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
