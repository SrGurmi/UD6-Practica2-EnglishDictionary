package com.salesianos.main;

import com.salesianos.words.WordStorage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordStorage wordStorage = new WordStorage();

        System.out.println("Welcome to the Dictionary!");

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Word");
            System.out.println("2. Remove Word");
            System.out.println("3. Check Word");
            System.out.println("4. Show Available Initials");
            System.out.println("5. Show Words by Initial");
            System.out.println("6. Exit Program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter word to add: ");
                    String wordToAdd = scanner.nextLine();
                    wordStorage.addWord(wordToAdd);
                    break;
                case 2:
                    System.out.print("Enter word to remove: ");
                    String wordToRemove = scanner.nextLine();
                    wordStorage.removeWord(wordToRemove);
                    break;
                case 3:
                    System.out.print("Enter word to check: ");
                    String wordToCheck = scanner.nextLine();
                    if (wordStorage.wordExists(wordToCheck)) {
                        System.out.println("Word exists in dictionary.");
                    } else {
                        System.out.println("Word does not exist in dictionary.");
                    }
                    break;
                case 4:
                    System.out.println("Initials with stored words: " + wordStorage.getInitialsList());
                    break;
                case 5:
                    System.out.print("Enter initial to show words: ");
                    char initial = scanner.nextLine().charAt(0);
                    System.out.println("Words starting with '" + initial + "': " + wordStorage.getWordsByInitial(initial));
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}