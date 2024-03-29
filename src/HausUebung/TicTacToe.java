import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char currentPlayer = 'X';
        boolean gameWon = false;
        int moves = 0;

        while (!gameWon && moves < 9) {
            printBoard(board);
            System.out.println("Spieler " + currentPlayer + ", gib deine Zugkoordinaten ein (Reihe und Spalte): ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
                System.out.println("Ungültiger Zug. Bitte erneut versuchen.");
                continue;
            }

            board[row][col] = currentPlayer;
            gameWon = checkWin(board, currentPlayer);
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            moves++;
        }

        printBoard(board);

        if (gameWon) {
            System.out.println("Spieler " + currentPlayer + " hat gewonnen!");
        } else {
            System.out.println("Unentschieden!");
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -+-+-");
            }
        }
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Horizontale Überprüfung
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Vertikale Überprüfung
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Diagonale Überprüfung (von links oben nach rechts unten)
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Diagonale Überprüfung (von rechts oben nach links unten)
        }
        return false;
    }
}
