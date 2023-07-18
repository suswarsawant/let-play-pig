package com.aurionpro.test;
import java.util.Random;
import java.util.Scanner;

public class LetsPlayPIG {
    private static int totalScore = 0;

    public static void main(String[] args) {
        playSinglePlayerPigGame();
    }

    public static void playSinglePlayerPigGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int playerScore = 0;
        int turns = 0;

        while (totalScore < 20) {
            int turnScore = 0;
            turns++;
            System.out.println("Turn: " + turns);
            System.out.println("Current score: " + playerScore);

            do {
                System.out.print("Roll or hold? (r/h) : ");
                String input = scanner.next();

                if (input.equalsIgnoreCase("r")) {
                    int roll = random.nextInt(6) + 1;
                    System.out.println("Die : " + roll);

                    if (roll == 1) {
                        System.out.println("Rolled 1, turn over, lost all points in this turn");
                        turnScore = 0;
                        break;
                    } else {
                        turnScore += roll;
                    }
                } else if (input.equalsIgnoreCase("h")) {
                    System.out.println("Holded.Score this turn: " + turnScore);
                    break;
                } else {
                    System.out.println("Invalid input. Roll or hold? (r/h) : ");
                }
            } while (true);

            playerScore += turnScore;
            totalScore += turnScore;
            System.out.println("Total score : " + totalScore);
            System.out.println();
        }

        System.out.println("You finished with score of " + playerScore + " in " + turns + " turns.");
    }
}