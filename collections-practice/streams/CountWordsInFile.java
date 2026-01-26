package gcr_codebase.streams;

import java.io.*;
import java.util.*;

public class CountWordsInFile {

	public static void main(String[] args) {
		String fileName = "input.txt"; // your text file
		Map<String, Integer> wordCount = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split(" ");
				for (String word : words) {
					if (word.isEmpty()) {
						continue;
					}
					word = word.toLowerCase();
					wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
				}
			}

		} catch (IOException e) {
			System.out.println(e);
		}
		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
		sortedList.sort((a, b) -> b.getValue() - a.getValue());
		for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
			Map.Entry<String, Integer> entry = sortedList.get(i);
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
