import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by vetal on 3/8/2017.
 */
public class GardenUtilTest {

    @Test
    public void findMaxAmount() {
        int[][] input = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        Assert.assertEquals(GardenUtil.findMaxAmount(input), 12);
    }

    @Test
    public void populateResultMatrix() {
        int[][] input = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        int[][] expected = {
                {12/*->*/,11 /*->*/, 9},
                {9 /*->*/, 8 /*->*/, 6},
                {6       , 5       , 3}
        };

        Assert.assertArrayEquals(expected, GardenUtil.populateResultMatrix(input));
    }

    @Test
    public void integration() throws Exception {
        Garden garden = new Garden("input.txt");
        GardenUtil.findMaxAmount(garden.getMatrix());
        Assert.assertTrue(FileUtils.contentEquals(new File("output.txt"),
                                                  new File("src/test/resources/expected_output.txt")));
    }
}