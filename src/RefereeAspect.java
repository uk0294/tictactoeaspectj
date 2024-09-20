import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspect that acts as a referee for the Tic Tac Toe game.
 * It checks for win or draw conditions after each move.
 */
@Aspect
public class RefereeAspect {

    @Pointcut("execution(boolean TicTacToe.makeMove(int, int)) && target(game)")
    public void makeMove(TicTacToe game) {}

    /**
     * After a move is made, check if the game is over.
     * @param game The current TicTacToe game
     */
    @After("makeMove(game)")
    public void checkGameStatus(TicTacToe game) {
        char[][] board = game.getBoard();
        char currentPlayer = game.getCurrentPlayer();

        if (isWinningMove(board, currentPlayer)) {
            System.out.println("Player " + currentPlayer + " wins!");
            game.setGameOver(true);
        } else if (isDraw(board)) {
            System.out.println("The game is a draw!");
            game.setGameOver(true);
        }
    }

    /**
     * Checks if the current move is a winning move.
     * @param board The game board
     * @param player The current player
     * @return true if the current move is a winning move, false otherwise
     */
    private boolean isWinningMove(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    /**
     * Checks if the game is a draw (all positions filled).
     * @param board The game board
     * @return true if the game is a draw, false otherwise
     */
    private boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
