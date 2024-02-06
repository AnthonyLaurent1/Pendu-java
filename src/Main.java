import com.dyma.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

/**
 * Class of the entrypoint of the Guess Game.
 */
public class Main {
    /**
     * Entry point of the Guess Game. Contains the main algorithm of the game.
     */
    public static void main(String[] args) {
        final Random random = new Random();
        final String wordsGuesses = "abuser crottes fleches continental babiole etoile bougie coup coeur malade";
        final String[] words = wordsGuesses.split(" ");
        final int lifePoints = 10;
        String wordToGuess = words[random.nextInt(words.length)];
        GuessGame game = new GuessGame(wordToGuess, lifePoints);

        System.out.println("Début du jeu !");

        while (true) {
            System.out.println(game);
            final char letter = scanLetter("Entrez une lettre : ");

            game.guessLetter(letter);
            if (game.isLost()) {
                System.out.println("Perdu !");
            }
            if (game.isWon()) {
                System.out.println("Gagné !");
            }
            if (game.isWon() || game.isLost()) {
                System.out.println(game);
                char replayAnswer = scanLetter("Rejouer ? (y, Y, n, N)");
                if (replayAnswer == 'y' || replayAnswer == 'Y') {
                    wordToGuess = words[random.nextInt(words.length-1)];
                    game = new GuessGame(wordToGuess, lifePoints);
                } else {
                    System.out.println("Merci d'avoir jouer !");
                    break;
                }
            }

        }

    }
    private static char scanLetter(String question) {
        final Scanner scanner = new Scanner(System.in);
        Character letter = null;
        do {
            System.out.println(question);
            String input = scanner.nextLine();
            if (input.length() == 1) {
                letter = input.charAt(0);
            }
        } while (letter == null);
        return letter;
    }
}

