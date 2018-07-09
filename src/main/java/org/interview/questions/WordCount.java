package org.interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class WordCount {
	/*
	 * ##Amazon ##Simple
	 * 
	 * Given a line and a set of wordsToExclude find the word with max frequency
	 * which is not present in wordsToExclude Challenge to get the solution in
	 * minimum iterations
	 * 
	 * Input:- literatureText =
	 * "jack and jill went to the market to buy cheese and bread and also cheese is jill and jack favorite food"
	 * wordsToExclude = ["and", "food", "jill"] Output:- ["to", "jack",
	 * "cheese"]
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String line = scanner.nextLine();
			String wordsToExclude = scanner.nextLine();
			HashSet<String> setOfWordsToExclude = new HashSet();
			HashMap<String, Integer> map = new HashMap<>();

			int start = 0;
			int end = 0;

			for (int i = "wordsToExclude = [".length(); i < wordsToExclude.length() - 1; i++) {
				if (wordsToExclude.charAt(i) == ' ' || wordsToExclude.charAt(i) == ',') {
					continue;
				}
				if (wordsToExclude.charAt(i) == '"') {
					if (wordsToExclude.charAt(i + 1) != ',' && wordsToExclude.charAt(i + 1) != ']') {
						start = i + 1;
						end = i + 1;
						continue;
					} else {
						setOfWordsToExclude.add(wordsToExclude.substring(start, end));
						continue;
					}
				}
				end++;
			}

			// System.out.println(setOfWordsToExclude);

			String sentinel = "literatureText = \"";
			start = sentinel.length();
			end = start;
			for (int i = start; i < line.length() - 1; i++) {
				if (line.charAt(i) == ' ') {
					String word = line.substring(start, end);
					if (!setOfWordsToExclude.contains(word)) {
						map.put(word, map.getOrDefault(word, 0) + 1);
					}
					start = i + 1;
					end = i + 1;
					continue;
				}
				end++;
			}
			// System.out.println(map);
			List<String> output = new ArrayList();
			int max = Integer.MIN_VALUE;
			for (Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() == max) {
					output.add('"' + entry.getKey() + '"');
				} else if (entry.getValue() > max) {
					max = entry.getValue();
					output.clear();
					output.add('"' + entry.getKey() + '"');
				}
			}
			System.out.println(output);
		}
	}
}
