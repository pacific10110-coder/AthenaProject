import java.io.*;
import java.util.*;

class Wordle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String secretWord = getRandomWord(); // random word from file
        int maxAttempts = 6;

        System.out.println("Welcome to Wordle!");
        System.out.println("Try to guess the 5-letter word.\n");

        // Game loop
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Enter guess #" + attempt + ": ");
            String guess = sc.nextLine().trim().toUpperCase();

            // Check for correct length
            if (guess.length() != 5) {
                System.out.println("Please enter a 5-letter word.\n");
                attempt--;
                continue;
            }

            // Simple check for numbers
            boolean hasNumber = false;
            for (int i = 0; i < guess.length(); i++) {
                if (Character.isDigit(guess.charAt(i))) {
                    hasNumber = true;
                    break;
                }
            }

            if (hasNumber) {
                System.out.println("Please use only letters (no numbers).\n");
                attempt--;
                continue;
            }

            // Feedback logic (same as before)
            StringBuilder feedback = new StringBuilder();

            for (int i = 0; i < 5; i++) {
                char guessChar = guess.charAt(i);
                char secretChar = secretWord.charAt(i);

                if (guessChar == secretChar) {
                    feedback.append("\u001B[32m" + guessChar + "\u001B[0m"); // Green
                } else if (secretWord.indexOf(guessChar) != -1) {
                    feedback.append("\u001B[33m" + guessChar + "\u001B[0m"); // Yellow
                } else {
                    feedback.append("\u001B[31m" + guessChar + "\u001B[0m"); // Red
                }
            }

            System.out.println("Feedback: " + feedback + "\n");

            // ✅ Win condition — stops immediately and reveals the word
            if (guess.equals(secretWord)) {
                System.out.println("🎉 Congratulations! You guessed the word!");
                System.out.println("✅ The correct word was: " + secretWord);
                sc.close();
                return;
            }

            // ✅ If all 6 guesses are used, end the game
            if (attempt == maxAttempts) {
                System.out.println("❌ You've run out of chances!");
                System.out.println("The correct word was: " + secretWord);
                break;
            }
        }

        sc.close();
    }

    // Picks random word from words.txt
    private static String getRandomWord() {
        List<String> words = new ArrayList<>();
        try {
            File file = new File("words.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.length() == 5 && line.matches("[a-zA-Z]+")) {
                    words.add(line.toUpperCase());
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ File 'words.txt' not found! Using default word CRIME.");
            return "CRIME";
        }

        if (words.isEmpty()) {
            System.out.println("⚠️ No valid 5-letter words found. Using default word CRIME.");
            return "CRIME";
        }
// ffffff
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }
}
// kkkkkkkkkkkkkkkkk