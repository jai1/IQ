package org.interview.questions;

import java.util.List;

import org.testng.annotations.Test;
import org.utils.Pair;

public class FindAllPossiblePathsTests {
    /*
    * 2) Find all the paths from 0 to 14. -1 is a dead point,can traverse from that point.
    * [ 0    1     -1     2
    *   1    4      5    10
    *   3    6      8     9
    *   7   -1      1    14]
    */
    @Test
    public void test_1() {
        int[][] matrix = { { 0, 1, -1, 2 }, { 1, 4, 5, 10 }, { 3, 6, 8, 9 }, { 7, -1, 1, 14 } };
        List<List<Pair<Integer>>> res = FindAllPossiblePaths.findAllPossiblePaths(matrix);
        System.out.println("Size of res = " + res.size());
        for (List<Pair<Integer>> l : res) {
            System.out.println("=============================");
            System.out.println("Path = " + l);
        }
    }

}
