package org.example.HighScoreData;

public class Manager extends Database{

    private final Database databases;

    public Manager()
    {
        this.databases = new Database();
        databases.buildDatabase();
    }

    @Override
    public void applyWin(String playerName) {
        databases.applyWin(playerName);
        System.out.println("Győzelmek mentése: " +playerName);
    }

    public void showHighScores() {
        databases.showHighScores();
    }
}
