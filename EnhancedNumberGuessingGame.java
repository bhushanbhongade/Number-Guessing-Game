package application;

import java.util.Random;
import java.util.Scanner;

public class EnhancedNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10; // Maximum number of attempts per round
        int totalRounds = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Enhanced Number Guessing Game!");
        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy (1-10)");
        System.out.println("2. Medium (1-50)");
        System.out.println("3. Hard (1-100)");
        int difficultyChoice = scanner.nextInt();

        switch (difficultyChoice) {
            case 1:
                upperBound = 10;
                break;
            case 2:
                upperBound = 50;
                break;
            case 3:
                upperBound = 100;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to medium difficulty.");
                break;
        }

        while (true) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int numberOfTries = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + (totalRounds + 1));
            System.out.println("I've picked a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");
            
            while (!hasGuessedCorrectly && numberOfTries < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfTries++;

                if (userGuess < numberToGuess) {
                    System.out.println("Try a higher number.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Try a lower number.");
                } else {
                    System.out.println("Congratulations! You've guessed the number (" + numberToGuess + ") in " + numberOfTries + " tries.");
                    int roundScore = maxAttempts - numberOfTries + 1; // Award points based on attempts
                    System.out.println("Round Score: " + roundScore);
                    totalScore += roundScore;
                    totalRounds++;

                    System.out.println("Total Score: " + totalScore);
                    break;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
                totalRounds++;
            }

            System.out.println("Do you want to play another round? (yes/no)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        scanner.close();
    }
}

