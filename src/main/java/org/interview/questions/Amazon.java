package org.interview.questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Amazon {

    public static void main(String[] args) {
        List<Character> input = new ArrayList();
        input.add('a');
        input.add('b');
        input.add('c');
        input.add('d');
        input.add('a');
        input.add('e');
        input.add('f');
        input.add('g');
        input.add('h');
        input.add('i');
        input.add('j');
        input.add('e');

        // System.out.println(lengthEachScene(input));
        
        System.out.println(subStringsKDist("abcd", -1));
        System.out.println(subStringsKDist("awaglknagawunagwkwagl", 4));

        
    }

    public static List<Integer> lengthEachScene(List<Character> inputList) {
        HashMap<Character, Integer> initialMap = new HashMap();
        for (Character c : inputList) {
            if (initialMap.containsKey(c)) {
                initialMap.put(c, initialMap.get(c) + 1);
            } else {
                initialMap.put(c, 1);
            }
        }

        List<Integer> output = new ArrayList<Integer>();
        int lengthOfSequence = 0;
        HashMap<Character, Integer> onGoingMap = new HashMap();

        for (Character c : inputList) {
            lengthOfSequence++;
            if (onGoingMap.containsKey(c)) {
                onGoingMap.put(c, onGoingMap.get(c) + 1);
            } else {
                onGoingMap.put(c, 1);
            }

            if (onGoingMap.get(c).equals(initialMap.get(c))) {
                onGoingMap.remove(c);
            }

            if (onGoingMap.size() == 0) {
                output.add(lengthOfSequence);
                lengthOfSequence = 0;
            }
        }
        return output;
    }

    public static List<String> subStringsKDist(String inputStr, int num) {
        Set<String> output = new HashSet<String>();
        List<Character> list = new ArrayList();
        for (int i = 0; i <inputStr.length(); i++) {
            Character c = inputStr.charAt(i);
            int index = list.indexOf(c);
            if (index != -1) {
                // element was already present - remove all elements before c's first occurence
                list = list.subList(index + 1, list.size());
            }
            list.add(c);
            if (list.size() == num) {
                output.add(toString(list));
                list = list.subList(1, list.size());
            }
        }
        return new ArrayList<String>(output);
    }

    private static String toString(List<Character> list) {
        StringBuffer buffer = new StringBuffer();
        for (Character c : list) {
            buffer.append(c);
        }
        return buffer.toString();
    }
}
