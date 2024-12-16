package org.example.Player;

import java.util.Scanner;

public class Moves {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getPlayerName()
    {
        String player_name;

        while (true)
        {
            System.out.print("Adja meg a nevét:");
            player_name = scanner.nextLine();
            if (!player_name.isEmpty())
            {
                break;
            }else{
                System.out.println("Név nem lehet üres. Próbálja meg újra.");
            }
        }
        return player_name;
    }

    public static int getColumnInput(int columns )
    {
        int column = 0;
        while (true)
        {
            System.out.print("Adja meg az oszlop számát: ");
            column = scanner.nextInt();
            if (column >= 1 && column <= columns)
            {
                break;
            }else{
                System.out.println("Nem megfelelő oszlop számot adtál meg! Próbálg újra.");
            }
        }
        return column;
    }
}
