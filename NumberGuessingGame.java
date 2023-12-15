
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minNumber = 1;
        int maxNumber = 100;
        int targetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;

        int maxAttempts = 5;
        int currentRound = 1;
        int totalAttempts = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (currentRound <= 3) {
            System.out.println("\nRound " + currentRound + ":");
            System.out.println("Guess the number between " + minNumber + " and " + maxNumber + ".");
            System.out.println("You have " + maxAttempts + " attempts.\n");

            int attempts = 0;
            int score = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                    score = maxAttempts - attempts + 1;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is lower than the target number.");
                } else {
                    System.out.println("Your guess is higher than the target number.");
                }
            }

            totalAttempts += attempts;
            totalScore += score;

            if (guessedCorrectly) {
                System.out.println("Round " + currentRound + " ended.");
                System.out.println("Score for this round: " + score);
                System.out.println("Total attempts so far: " + totalAttempts);
                System.out.println("Total score so far: " + totalScore);
                currentRound++;
                targetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            } else {
                System.out.println("You have reached the maximum number of attempts. The correct number was: " + targetNumber);
                System.out.println("Game Over!");
                break;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Total score: " + totalScore);

        scanner.close();
    }
}
