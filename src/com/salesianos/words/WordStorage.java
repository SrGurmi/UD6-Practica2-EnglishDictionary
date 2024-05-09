package com.salesianos.words;

import com.salesianos.utils.Sanitizer;

import java.util.*;

public class WordStorage {
    private Map<Character, Set<String>> wordsByInitial;

    public WordStorage() {
        this.wordsByInitial = new HashMap<>();
    }

    public void addWord(String word) {
        word = Sanitizer.sanitize(word);
        if (!word.isEmpty()) {
            char initial = Character.toLowerCase(word.charAt(0));
            if (!wordsByInitial.containsKey(initial)) {
                wordsByInitial.put(initial, new HashSet<>());
            }
            wordsByInitial.get(initial).add(word);
            System.out.println("Word added successfully.");
        } else {
            System.out.println("Invalid word. Please try again.");
        }
    }

    public void removeWord(String word) {
        word = Sanitizer.sanitize(word);
        if (!word.isEmpty()) {
            char initial = Character.toLowerCase(word.charAt(0));
            if (wordsByInitial.containsKey(initial)) {
                if (wordsByInitial.get(initial).remove(word)) {
                    System.out.println("Word removed successfully.");
                } else {
                    System.out.println("Word not found in dictionary.");
                }
            } else {
                System.out.println("Word not found in dictionary.");
            }
        } else {
            System.out.println("Invalid word. Please try again.");
        }
    }

    public boolean wordExists(String word) {
        word = Sanitizer.sanitize(word);
        if (!word.isEmpty()) {
            char initial = Character.toLowerCase(word.charAt(0));
            return wordsByInitial.containsKey(initial) && wordsByInitial.get(initial).contains(word);
        }
        return false;
    }

    public List<Character> getInitialsList() {
        return new ArrayList<>(wordsByInitial.keySet());
    }

    public List<String> getWordsByInitial(char initial) {
        initial = Character.toLowerCase(initial);
        return wordsByInitial.getOrDefault(initial, Collections.emptySet()).stream()
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
