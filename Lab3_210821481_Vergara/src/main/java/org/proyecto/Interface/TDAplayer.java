package org.proyecto.Interface;

public interface TDAplayer {
    /// Getters.
    String getName();
    int getID();
    String getColor();
    int getWins();
    int getLosses();
    int getDraws();
    int getRemainingPieces();

    /// Setters.
    void setID(int id);
    void setName(String name);
    void setColor(String color);
    void setWins(int wins);
    void setLosses(int losses);
    void setDraws(int draws);
    void setRemainingPieces(int remainingPieces);
}
