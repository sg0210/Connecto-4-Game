package org.example.Main;

import org.example.Game.Board;
import org.example.Game.Mechanic;
import org.example.HighScoreData.Manager;
import org.example.Player.Moves;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Connect4 {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
            public static void main(String[] args)
            {
                logger.info("Játék elindult");

                int rows = 6;
                int columns = 7;

                char[][] board = Board.boardBuilder(rows, columns);

                Manager manager = new Manager();

                manager.buildDatabase();

                System.out.println("Üdvözöllek a Connect4 játékban");

                String playerName = Moves.getPlayerName();

                System.out.println("Játék elindult:");
                Board.boardWriter(board);

                boolean gameRun = true;

                while(gameRun)
                {
                    int column = Moves.getColumnInput();

                    if (Mechanic.isValidMove(board, column))
                    {
                        Mechanic.saveMove(board, column, 'Y');
                        Board.boardWriter(board);
                        Board.boardSaver(board);

                        if (Mechanic.winChecker(board, 'Y'))
                        {
                            System.out.println(playerName + " győztél!");
                            manager.applyWin(playerName);
                            gameRun = false;
                            continue;
                        }
                    }else{
                        System.out.println("Érvénytelen lépés, próbáld újra!");
                        continue;
                    }

                    int computerMove = Mechanic.enemyMove(board);
                    Mechanic.saveMove(board, computerMove, 'R');
                    Board.boardWriter(board);

                    if (Mechanic.winChecker(board, 'R'))
                    {
                        System.out.println("A gép nyert.");
                        gameRun = false;
                    }
                }
                System.out.println();
                manager.showHighScores();

                logger.info("Játék vége");
            }

}
