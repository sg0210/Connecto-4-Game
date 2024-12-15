package org.example.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class MechanicTest {

    private char[][] board;

    @BeforeEach
    void setUp()
    {
        board = new char[6][7];
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                board[i][j] = '-';
            }
        }
    }

    @Test
    void testIsValidMoveV()
    {
        assertTrue(Mechanic.isValidMove(board, 4));
    }

    @Test
    void testIsInvalidMove()
    {
        for (int i = 0; i < 6; i++)
        {
            board[i][3] = 'R';
        }
        assertFalse(Mechanic.isValidMove(board, 4));
    }

    @Test
    void testSaveMove()
    {
       Mechanic.saveMove(board, 1, 'Y');
       assertEquals('Y', board[5][0]);
    }

    @Test
    void enemyMove()
    {
        int column = Mechanic.enemyMove(board);
        assertTrue(Mechanic.isValidMove(board, column));
    }

    @Test
    void winCheckerHor() {
        board[5][0] = 'Y';
        board[5][1] = 'Y';
        board[5][2] = 'Y';
        board[5][3] = 'Y';
        assertTrue(Mechanic.winChecker(board, 'Y'));
    }

    @Test
    void winCheckerVer() {
        board[0][0] = 'R';
        board[1][0] = 'R';
        board[2][0] = 'R';
        board[3][0] = 'R';
        assertTrue(Mechanic.winChecker(board, 'R'));
    }

    @Test
    void winCheckerDiag() {
        board[0][0] = 'Y';
        board[1][1] = 'Y';
        board[2][2] = 'Y';
        board[3][3] = 'Y';
        assertTrue(Mechanic.winChecker(board, 'Y'));
    }

    @Test
    void winCheckerAntiDiag() {
        board[0][3] = 'R';
        board[1][2] = 'R';
        board[2][1] = 'R';
        board[3][0] = 'R';
        assertTrue(Mechanic.winChecker(board, 'R'));
    }

    @Test
    void testWinCheckerNoWin()
    {
        assertFalse(Mechanic.winChecker(board, 'Y'));
    }
}