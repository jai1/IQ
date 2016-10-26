package org.interview.questions;

import static java.util.Arrays.asList;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NeedleInHaystackTest {

    @Test
    public void test() {
        NeedleInHaystack solution = new NeedleInHaystack();
        List<Integer> expectedOutput = solution.getAnagramIndices("abcdghbaabcdij", "bcda");
        System.out.println(expectedOutput);
        Assert.assertEquals(expectedOutput, asList(0, 8));

        expectedOutput = solution.getAnagramIndices("bbbababaaabbbb", "ab");
        System.out.println(expectedOutput);
        Assert.assertEquals(expectedOutput, asList(2, 3, 4, 5, 6, 9));

        expectedOutput = solution.getAnagramIndices("a", "b");
        System.out.println(expectedOutput);
        Assert.assertEquals(expectedOutput, asList());

        expectedOutput = solution.getAnagramIndices("a", "a");
        System.out.println(expectedOutput);
        Assert.assertEquals(expectedOutput, asList(0));

        expectedOutput = solution.getAnagramIndices("bbbababaaabbbb", "bbb");
        System.out.println(expectedOutput);
        Assert.assertEquals(expectedOutput, asList(0, 10, 11));
    }

}
