import java.util.Scanner;

class Connect4 {
    // Constants
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY = ' ';
    private static final char PLAYER1 = 'R'; // Red
    private static final char PLAYER2 = 'Y'; // Yellow

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[ROWS][COLS];
        initializeBoard(board);

        char currentPlayer = PLAYER1;
        boolean gameRunning = true;

        System.out.println("🎮 Welcome to Connect 4!");
        printBoard(board);

        while (gameRunning) {
            System.out.println("Player " + getColoredPlayer(currentPlayer) + ", choose a column (1-7): ");

            int col;
            while (true) {
                if (sc.hasNextInt()) {
                    col = sc.nextInt() - 1; // Convert to 0-index
                    if (col >= 0 && col < COLS) {
                        if (dropPiece(board, col, currentPlayer)) {
                            break;
                        } else {
                            System.out.println("Column full! Try another one:");
                        }
                    } else {
                        System.out.println("Invalid column! Choose between 1 and 7:");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number:");
                    sc.next();
                }
            }

            printBoard(board);

            // Check win or draw
            if (checkWin(board, currentPlayer)) {
                System.out.println("🎉 Player " + getColoredPlayer(currentPlayer) + " wins!");
                gameRunning = false;
            } else if (isBoardFull(board)) {
                System.out.println(" It's a draw!");
                gameRunning = false;
            } else {
                currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
            }
        }

        sc.close();
    }

    // Initialize empty board
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    // Print board with colors
    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            System.out.print("|");
            for (int j = 0; j < COLS; j++) {
                System.out.print(" " + colorize(board[i][j]) + " |");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
        System.out.println("  1   2   3   4   5   6   7  ");
        System.out.println();
    }

    // Drop a piece into a column
    public static boolean dropPiece(char[][] board, int col, char player) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == EMPTY) {
                board[i][col] = player;
                return true;
            }
        }
        return false;
    }

    // Check for win (horizontal, vertical, diagonals)
    public static boolean checkWin(char[][] board, char player) {
        // Horizontal
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] == player && board[i][j + 1] == player &&
                    board[i][j + 2] == player && board[i][j + 3] == player)
                    return true;
            }
        }

        // Vertical
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == player && board[i + 1][j] == player &&
                    board[i + 2][j] == player && board[i + 3][j] == player)
                    return true;
            }
        }

        // Diagonal (bottom-left to top-right)
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] == player && board[i - 1][j + 1] == player &&
                    board[i - 2][j + 2] == player && board[i - 3][j + 3] == player)
                    return true;
            }
        }

        // Diagonal (top-left to bottom-right)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player &&
                    board[i + 2][j + 2] == player && board[i + 3][j + 3] == player)
                    return true;
            }
        }

        return false;
    }

    // Check if board is full
    public static boolean isBoardFull(char[][] board) {
        for (int j = 0; j < COLS; j++) {
            if (board[0][j] == EMPTY) return false;
        }
        return true;
    }

    // Add colors for R and Y pieces
    public static String colorize(char c) {
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String YELLOW = "\u001B[33m";

        if (c == PLAYER1) return RED + "R" + RESET;
        if (c == PLAYER2) return YELLOW + "Y" + RESET;
        return " ";
    }

    // Colorize player name
    public static String getColoredPlayer(char player) {
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String YELLOW = "\u001B[33m";

        return (player == PLAYER1 ? RED + "R (Red)" + RESET : YELLOW + "Y (Yellow)" + RESET);
    }
}
/// kkkm kkbjmkjjjjjjjjjjjjjjjj jjjn jjjjjjmkmmmm 