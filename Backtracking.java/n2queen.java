public class n2queen {
    public static void nqueen(char board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            board[row][j] = 'Q';
            nqueen(board, row + 1);
            board[row][j] = 'X';
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("----chess board-----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 2;
        char board[][] = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'X';
            }
        }

        nqueen(board, 0);
    }
}
