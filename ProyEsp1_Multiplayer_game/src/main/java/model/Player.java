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
     * Server's address
     */
    private String server;

    /**
     * Player's score
     */
    private int score;

    /**
     * Constructor
     * 
     * @param playerName Player's name
     * @param server Server's address
     */
    public Player(String playerName, String server) {
        this.playerName = playerName;
        this.server = server;
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
     * Gets the server's address
     * 
     * @return Server's address
     */
    public String getServer() {
        return server;
    }

    /**
     * Sets the server's address
     * 
     * @param server Server's address
     */
    public void setServer(String server) {
        this.server = server;
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
