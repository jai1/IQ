package org.interview.questions;

import static org.testng.Assert.*;

import java.io.IOException;

import org.testng.annotations.Test;

public class ReverseWordsInSentenceTest {

    @Test
    public void test1() throws IOException {
        String input = "Hello World 1";
        String expectedOutput = "olleH World";
        assertEquals(expectedOutput, ReverseWordInSentence.run(input));
    }
    
    @Test
    public void test2() throws IOException {
        String input = "What is the meaning of Life 4";
        String expectedOutput = "What is the gninaem of Life";
        assertEquals(expectedOutput, ReverseWordInSentence.run(input));
    }

    @Test
    public void test3() throws IOException {
        String input = "What is the meaning of Life 6";
        String expectedOutput = "What is the meaning of efiL";
        assertEquals(expectedOutput, ReverseWordInSentence.run(input));
    }
}
