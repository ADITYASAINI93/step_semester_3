package ex1;
import java.util.Random;
import java.util.Scanner;

public class prob1 {
    static String playRound(String player, String computer) {
        if (player.equals(computer))
            return "Draw";

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0, losses = 0, draws = 0;
        int n = 5;

        System.out.println("Enter Rock, Paper, or Scissors:");

        for (int i = 1; i <= n; i++) {
            System.out.print("Round " + i + ": ");
            String player = sc.next();

            if (!player.equalsIgnoreCase("Rock") &&
                !player.equalsIgnoreCase("Paper") &&
                !player.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move. Enter a valid move.");
                i--;
                continue;
            }

            player = player.substring(0, 1).toUpperCase()
                     + player.substring(1).toLowerCase();

            String computer = moves[random.nextInt(3)];
            String result = playRound(player, computer);

            System.out.println("Player: " + player
                + " | Computer: " + computer
                + " | Result: " + result);

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n",
                          wins * 100.0 / n);

        sc.close();
    }
}
