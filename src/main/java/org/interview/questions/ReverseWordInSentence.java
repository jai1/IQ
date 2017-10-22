package org.interview.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWordInSentence {
/*
 * ##KsquareIT
 * ##Easy
 * Write a Program to reverse a particular string in a group of strings based on user input.
 * For example, given a string "Hello John Smith 2" - You will have to write code where it will take this input and reverse the second string - So the output will be "Hello nhoJ Smith"
 * 
 * More examples -
 * Input 
 * Hello World 1 
 * 
 * Output
 * olleH World
 * 
 * Input 
 * What is the meaning of Life 4
 * 
 * Output
 * What is the gninaem of Life
 */
    
    public static String run(String sentence) throws IOException {
        String[] words = sentence.split(" ");
        int numberOfWords = words.length - 1;
        int index = Integer.parseInt(words[words.length - 1]) - 1;
        assert(numberOfWords >= index);
        
        words[index] = reverse(words[index]);
        StringBuffer buf = new StringBuffer();
        
        for (int i = 0; i<numberOfWords; i++) {
            buf.append(words[i]);
            if (i != numberOfWords - 1) {
                buf.append(" ");
            }
        }
        return buf.toString();
    }

    private static String reverse(String string) {
        StringBuffer buf = new StringBuffer();
        for (int i = string.length() - 1; i >= 0; i--) {
            buf.append(string.charAt(i));
        }
        return buf.toString();
    }

}
