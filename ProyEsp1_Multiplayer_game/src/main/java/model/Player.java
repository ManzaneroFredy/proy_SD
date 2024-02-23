/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bebi_
 */

public class Player {

    /**
     * Player's name
     */
    private String playerName;

    /**
     * Player's score
     */
    private int score;

    /**
     * Constructor
     * 
     * @param playerName Player's name
     */
    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }

    /**
     * Gets the player's name
     * 
     * @return Player's name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets the player's name
     * 
     * @param playerName Player's name
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }



    /**
     * Gets the player's score
     * 
     * @return Player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the player's score
     * 
     * @param score Player's score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Updates the player's score
     * 
     * @param points Points to be added
     */
    public void updateScore(int points) {
        this.score += points;
    }
}