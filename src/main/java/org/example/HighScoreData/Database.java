package org.example.HighScoreData;

import java.sql.*;

public class Database {

    private static final String DATABASE_PATH = "high_scores.db";
    private static final String DATABASE_URL = "jdbc:sqlite" + DATABASE_PATH;

    public void buildDatabase()
    {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS high_scores(
                    player_name TEXT PRIMARY KEY,
                    wins INTEGER NOT NULL
                    );
                """;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL); Statement statement = connection.createStatement())
        {
            statement.execute(createTableSQL);
            System.out.println("Sikeres adatbázisbetöltés");
        } catch (SQLException e) {
            System.out.println("Nem sikerült betölteni az adatbázist: " + e.getMessage());
        }
    }

    public void applyWin(String playerName)
    {
        String insertOrUpdateSWL = """
                INSERT TO high_scores (player_name, wins)
                VALUES (?, 1)
                ON CONFLICT(player_name) DO UPDATE SET
                wins = wins + 1
                """;

        try (Connection connection = DriverManager.getConnection(DATABASE_URL); PreparedStatement preparedStatement = connection.prepareStatement(insertOrUpdateSWL))
        {
            preparedStatement.setString(1, playerName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Nem sikerült elmenteni a győzelmet: " + e.getMessage());
        }
    }

    public void showHighScores()
    {
        String selectSQL = "SELECT player_name, wins FORM high_scroes ORDER BY wins DESC";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(selectSQL)){
            if (!resultSet.isBeforeFirst())
            {
                System.out.println("Nincs elérhető adat!");
                return;
            }

            System.out.println("High Scores:");
            while(resultSet.next())
            {
                String playerName = resultSet.getString("player_name");
                int wins = resultSet.getInt("wins");
                System.out.println(playerName + ": " + wins + " győzelem");
            }
        } catch (SQLException e) {
            System.out.println("Nem sikerült beolvasni a High Score beolvasásakor: " + e.getMessage());
        }
    }
}
