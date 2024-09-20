import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player X goes first.");

        while (!game.isGameOver()) {
            game.printBoard();
            System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row and column, 0-2): ");
            
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (game.makeMove(row, col)) {
                    // RefereeAspect automatically checks for win or draw after each move
                    if (!game.isGameOver()) {
                        game.switchPlayer();
                    }
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter two numbers (0-2).");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        game.printBoard();
        System.out.println("Game over! Thanks for playing!");
        scanner.close();
    }
}
