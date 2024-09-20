/**
 * Represents the Tic Tac Toe game board and game state.
 */
public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;

    /**
     * Initializes a new Tic Tac Toe game.
     */
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        initializeBoard();
    }

    /**
     * Sets up the initial empty board.
     */
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Displays the current state of the board.
     */
    public void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -+-+-");
        }
    }

    /**
     * Attempts to make a move at the specified position.
     * @param row The row of the move (0-2)
     * @param col The column of the move (0-2)
     * @return true if the move was successful, false otherwise
     */
    public boolean makeMove(int row, int col) {
        if (gameOver || !isValidMove(row, col)) {
            return false;
        }
        board[row][col] = currentPlayer;
        return true;
    }

    /**
     * Checks if a move is valid.
     * @param row The row of the move
     * @param col The column of the move
     * @return true if the move is valid, false otherwise
     */
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    /**
     * Switches the current player.
     */
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Getters and setters
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
