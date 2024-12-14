package org.example.Player;

import java.util.Scanner;

public class Moves {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getPlayerName()
    {
        System.out.print("Adja meg a nevét: ");
        return scanner.nextLine();
    }

    public static int getColumnInput()
    {
        System.out.print("Adja meg az oszlop számát: ");
        return  scanner.nextInt();
    }
}
