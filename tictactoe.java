import java.util.Scanner;
 
class TicTacToe {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";   // For X
    public static final String RED = "\u001B[31m";    // For O
    public static final String GREEN = "\u001B[32m";  // For winner message

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char currentPlayer = 'X';
        boolean gameRunning = true;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard(board);

        while (gameRunning) {
            System.out.println("Player " + colorize(currentPlayer) + ", enter your move (1-9): ");
            int move;

            // Input validation
            while (true) {
                if (sc.hasNextInt()) {
                    move = sc.nextInt();
                    if (move >= 1 && move <= 9) {
                        int row = (move - 1) / 3;
                        int col = (move - 1) % 3;

                        if (board[row][col] == ' ') {
                            board[row][col] = currentPlayer;
                            break;
                        } else {
                            System.out.println("That spot is already taken. Try again:");
                        }
                    } else {
                        System.out.println("Invalid move! Enter a number from 1 to 9:");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number:");
                    sc.next(); // clear invalid input
                }
            }

            printBoard(board);

            // ✅ Colored win and draw messages
            if (checkWin(board, currentPlayer)) {
                System.out.println(GREEN + " Player " + colorize(currentPlayer) + " wins!" + RESET);
                gameRunning = false;
            } else if (isBoardFull(board)) {
                System.out.println(" It's a draw!");
                gameRunning = false;
            } else {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    // Prints the board with colors
    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + colorize(board[i][0]) + " | " + colorize(board[i][1]) + " | " + colorize(board[i][2]));
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    // Colors X as blue and O as red
    public static String colorize(char c) {
        if (c == 'X') return BLUE + 'X' + RESET;
        else if (c == 'O') return RED + 'O' + RESET;
        else return " ";
    }

    // Checks if a player has won
    public static boolean checkWin(char[][] board, char player) {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        }
        // Columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;
        }
        // Diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    // Checks if board is full (for draw)
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
}