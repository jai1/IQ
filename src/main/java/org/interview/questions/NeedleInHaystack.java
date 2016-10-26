package org.interview.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//    ##Company-Amazon
//    ##Anagrams
//    Anagram Substring Search (Or Search for all permutations)
//    Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] and its permutations (or anagrams) in txt[]. You may assume that n > m. 
//    Expected time complexity is O(n)
//    
//    Examples:
//    
//    1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
//       Output:   Found at Index 0
//                 Found at Index 5
//                 Found at Index 6
//    2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
//       Output:   Found at Index 0
//                 Found at Index 1
//                 Found at Index 4

public class NeedleInHaystack {

    public List<Integer> getAnagramIndices(String haystack, String needle) {
        List<Integer> output = new ArrayList<Integer>();
        if (haystack.length() < needle.length() || haystack.length() == 0 || needle.length() == 0) {
            return output;
        }

        Set<String> needleSet = getNeedleSet(needle);
        // (haystack.length() - (needle.length() - 1))
        // Since if needle.length is 3 you want to stop 2 (needle.length - 1) elements from last
        // and check for 3 (needle.length) elements are a time
        for (int i = 0; i < (haystack.length() - (needle.length() - 1)); i++) {
            String possibleNeedle = haystack.substring(i, i + needle.length());
            if (needleSet.contains(possibleNeedle)) {
                output.add(i);
            }
        }
        return output;
    }

    private Set<String> getNeedleSet(String needle) {
        Set<String> output = new HashSet<String>();
        permutations("", needle, output);
        return output;
    }

    private void permutations(String prefix, String str, Set<String> output) {
        if (str.length() == 0) {
            output.add(prefix);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()), output);
        }
    }
}
