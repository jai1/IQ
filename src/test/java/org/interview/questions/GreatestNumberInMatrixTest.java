package org.interview.questions;

import org.junit.Test;

import junit.framework.Assert;

public class GreatestNumberInMatrixTest {

    @Test
    public void test() {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, -11, 10, 12 }, { 13, 14, 15, -16 } };
        GreatestNumberInMatrix obj = new GreatestNumberInMatrix(matrix);
        Assert.assertEquals(1, obj.findGreatestNumber(0, 0, 0, 0));
        Assert.assertEquals(5, obj.findGreatestNumber(0, 0, 1, 0));
        Assert.assertEquals(2, obj.findGreatestNumber(0, 0, 0, 1));
        Assert.assertEquals(10, obj.findGreatestNumber(0, 0, 2, 2));
        Assert.assertEquals(15, obj.findGreatestNumber(0, 1, 3, 3));

    }

}
