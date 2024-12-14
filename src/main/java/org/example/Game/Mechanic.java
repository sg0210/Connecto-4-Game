package org.example.Game;

public class Mechanic {

    public static boolean isValidMove(char[][] board, int column)
    {
        int Column = column - 1;
        return  Column >= 0 && Column < board[0].length && board[0][Column] == '-';
    }

    public static void saveMove(char[][] board, int column, char symbol)
    {
        int Column = column - 1;
        for (int row = board.length - 1; row >= 0; row--)
        {
            if (board[row][Column] == '-')
            {
                board[row][Column] = symbol;
                break;
            }
        }
        System.out.println("Gép választotta oszlop: " + column);
    }

    public static int enemyMove(char[][] board)
    {
        int column;
        do {
            column = (int) (Math.random() * board[0].length) + 1;
        }while (!isValidMove(board, column));
            return column;
    }

    public static boolean winChecker(char[][] board, char symbol)
    {
        int rows = board.length;
        int columns = board[0].length;

        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column <= columns -4 ; column++) {
                if(board[row][column] == symbol && board[row][column + 1] == symbol && board[row][column + 2] == symbol && board[row][column + 3] == symbol)
                {
                    return true;
                }
            }
        }

        for (int column = 0; column < columns; column++)
        {
            for (int row = 0; row <= rows -4 ; row++) {
                if(board[row][column] == symbol && board[row + 1][column] == symbol && board[row + 2][column] == symbol && board[row + 3][column] == symbol)
                {
                    return true;
                }
            }
        }

        for (int row = 0; row < rows - 4; row++)
        {
            for (int column = 0; column <= columns -4 ; column++) {
                if(board[row][column] == symbol && board[row + 1][column + 1] == symbol && board[row + 2][column + 2] == symbol && board[row + 3][column + 3] == symbol)
                {
                    return true;
                }
            }
        }

        for (int row = 0; row < rows - 4; row++)
        {
            for (int column = 3; column < columns ; column++) {
                if(board[row][column] == symbol && board[row + 1][column - 1] == symbol && board[row + 2][column - 2] == symbol && board[row + 3][column - 3] == symbol)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
