package org.example.Game;

import java.io.*;
import java.util.Arrays;

public class Board {

    private static final String BOARD_FILE_PATH = "C:\\Users\\sulle\\IdeaProjects\\Connetc4\\src\\board.txt";


    public static char[][] boardBuilder(int rows, int columns)
    {
        char[][] board = new char[rows][columns];
        for (int i = 0;i < rows; i++)
        {
            Arrays.fill(board[i],'-');
        }

        File file = new File(BOARD_FILE_PATH);
        if (file.exists()){
            try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                for (int i = 0; i < rows; i++)
                {
                    String line = reader.readLine();
                    if (line != null)
                    {
                        for (int j = 0; j < Math.min(columns, line.length()); j++)
                        {
                            board[i][j] = line.charAt(j);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Nem sikerült betölteni a játékállást: " + e.getMessage());
            }
        }
        return board;
    }

    public static void boardWriter(char[][] board)
    {
        System.out.print("  ");
        for (int i = 0; i < board[0].length; i++)
        {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();
        for (int i = 0 ; i < board.length; i++)
        {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void boardSaver(char[][] board)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOARD_FILE_PATH)))
        {
            for (char[] row : board)
            {
                writer.write(new String(row));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Nem sikerült betölteni a játékállást: " + e.getMessage());
        }
    }

}

