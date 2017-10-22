package org.interview.questions;

import java.util.List;

import org.utils.Pair;

import com.beust.jcommander.internal.Lists;

/*
* 2) Find all the paths from 0 to 14. -1 is a dead point,can traverse from that point.
* [ 0    1     -1     2
*   1    4      5    10
*   3    6      8     9
*   7   -1      1    14]
*/
public class FindAllPossiblePaths {
    public static List<List<Pair<Integer>>> findAllPossiblePaths(int[][] matrix) {
        List<Pair<Integer>> pathSoFar = Lists.newArrayList();
        List<List<Pair<Integer>>> allPossiblePaths = Lists.newArrayList();
        findAllPossiblePaths(matrix, 0, 0, pathSoFar, allPossiblePaths);
        return allPossiblePaths;
    }

    private static void findAllPossiblePaths(int[][] matrix, int i, int j, List<Pair<Integer>> pathSoFar,
            List<List<Pair<Integer>>> allPossiblePaths) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length) {
            return;
        }

        Pair<Integer> p = new Pair<Integer>(i, j);

        List<Pair<Integer>> copyOfPathSoFar = Lists.newArrayList(pathSoFar);
        if (matrix[i][j] == -1 || copyOfPathSoFar.contains(p)) {
            return;
        }

        copyOfPathSoFar.add(p);
        if (i == matrix.length - 1 && j == matrix[i].length - 1) {
            allPossiblePaths.add(copyOfPathSoFar);
            return;
        }

        findAllPossiblePaths(matrix, i - 1, j, copyOfPathSoFar, allPossiblePaths);
        findAllPossiblePaths(matrix, i + 1, j, copyOfPathSoFar, allPossiblePaths);
        findAllPossiblePaths(matrix, i, j - 1, copyOfPathSoFar, allPossiblePaths);
        findAllPossiblePaths(matrix, i, j + 1, copyOfPathSoFar, allPossiblePaths);
    }
}
