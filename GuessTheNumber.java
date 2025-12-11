import javax.swing.JOptionPane;
import java.util.Random;

public class GuessTheNum {

    public static void main(String[] args) {
        Random random = new Random();
        int score = 0;
        int rounds = 3; // total rounds

        JOptionPane.showMessageDialog(null, " Welcome to Guess The Number Game!");

        for (int i = 1; i <= rounds; i++) {
            int number = random.nextInt(100) + 1; // generate 1–100
            int attempts = 0;
            int maxAttempts = 5; // limit attempts per round
            boolean guessed = false;

            JOptionPane.showMessageDialog(null, " Round " + i + " begins! Guess a number between 1 and 100\nYou have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog(null, "Enter your guess:");

                if (input == null) {
                    JOptionPane.showMessageDialog(null, " Game exited!");
                    System.exit(0);
                }

                int guess;

                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "❌ Please enter a valid number!");
                    continue;
                }

                attempts++;

                if (guess == number) {
                    guessed = true;
                    int points = (maxAttempts - attempts + 1) * 10; // more points for fewer attempts
                    score += points;

                    JOptionPane.showMessageDialog(null, "🎉 Correct Guess!\n✅ Attempts Used: " + attempts + "\n🏆 Points Earned: " + points);
                    break;
                } else if (guess > number) {
                    JOptionPane.showMessageDialog(null, "⬇ Too High! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "⬆ Too Low! Try again.");
                }
            }

            if (!guessed) {
                JOptionPane.showMessageDialog(null, " You lost this round!\nThe correct number was: " + number);
            }
        }

        JOptionPane.showMessageDialog(null, " All rounds completed!\n⭐ Final Score: " + score + "\nThanks for playing! 😄");
    }
}
