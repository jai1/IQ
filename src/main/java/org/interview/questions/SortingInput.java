package org.interview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Sorting crazy input string - question in resources folder (jpeg)
 * ##Amazon
 * ##Medium
 * ##Samarth
 * 
Input:-
logFilesize = 5
logLines=
[a1 9 2 3 1]
[g1 act car]
[zo4 4 7]
[ab1 off key dog]
[a8 act zoo]
Output:-
[g1 act car]
[a8 act zoo]
[ab1 off key dog]
[a1 9 2 3 1]
[zo4 4 7] 


Input:-
logFilesize = 6
logLines=
[b4 xi me nu]
[br8 eat nim did]
[f3 52 54 31]
[r1 box ape bit]
[t2 13 121 98]
[w1 has uri gry]
Output:-
[r1 box ape bit]
[br8 eat nim did]
[w1 has uri gry]
[b4 xi me nu]
[f3 52 54 31]
[t2 13 121 98]
 */
public class SortingInput {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String line = sc.nextLine();
			line.split(" ");
			String[] parts = line.split(" ");
			int numberOfInputs = Integer.parseInt(parts[parts.length - 1]);
			line = sc.nextLine(); // skip next line

			List<String> integerLines = new ArrayList();
			TreeMap<String, String> alphanumericMap = new TreeMap();
			for (int i = 0; i < numberOfInputs; i++) {
				String inputLine = sc.nextLine();
				line = inputLine.substring(1, inputLine.length() - 1); // remove
																		// first
																		// and
																		// last
																		// bracket
				parts = line.split(" ");
				boolean isAlpha = false;
				String temp = "";
				for (int j = 1; j < parts.length; j++) {
					if (!parts[j].matches("^[0-9]*$")) {
						isAlpha = true;
					}
					temp = temp + " " + parts[j];
				}
				if (isAlpha) {
					temp = temp + " " + parts[0]; // add key
					alphanumericMap.put(temp, inputLine);
				} else {
					integerLines.add(inputLine);
				}
			}

			for (Entry<String, String> entrySet : alphanumericMap.entrySet()) {
				System.out.println(entrySet.getValue());
			}
			integerLines.stream().forEach(input -> System.out.println(input));
		}
	}
}
