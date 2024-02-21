/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bebi_
 */
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.*;

/**
 * Server module for a multiplayer trivia game.
 */
public class TriviaServer {

    private final MulticastSocket socket;
    private final InetAddress group;
    private final int port;
    private final List<DatagramPacket> clients;

    /**
     * Creates a new server instance.
     *
     * @param groupAddress The multicast group address.
     * @param port The server port.
     * @throws IOException If an I/O error occurs.
     */
    public TriviaServer(String groupAddress, int port) throws IOException {
        this.socket = new MulticastSocket(port);
        this.group = InetAddress.getByName(groupAddress);
        this.port = port;
        this.clients = new ArrayList<>();
    }

    /**
     * Starts the server and listens for new clients.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void start() throws IOException {
        socket.joinGroup(group);
        System.out.println("Server started.");
        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            if (!clients.contains(packet)) {
                clients.add(packet);
                System.out.println("New client connected.");
            }
        }
    }

    /**
     * Sends a message to all connected clients.
     *
     * @param message The message to send.
     * @throws IOException If an I/O error occurs.
     */
    public void broadcastMessage(String message) throws IOException {
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), group, port);
        socket.send(packet);
    }

    /**
     * Sorts a list of questions randomly.
     *
     * @param questions The list of questions to sort.
     * @return A new list of questions sorted randomly.
     */
    private List<Question> sortQuestions(List<Question> questions) {
        List<Question> sortedQuestions = new ArrayList<>(questions);
        Collections.shuffle(sortedQuestions);
        return sortedQuestions;
    }
    
    /**
 *  Gets the score from a JSON object
 *
 * @param json The JSON object containing the score and the user
 * @return The score of the user
 */
    public static int getScore(JsonObject json){
        return json.get("User").getAsJsonObject().get("score").getAsInt();
    }

    /**
     * Sends the score of the player to the clients
     *
     * @param socket The socket to send the score
     * @param playerName The name of the player
     * @param score The score of the player
     * @throws IOException If an I/O error occurs
     */
    public static void sendScore(MulticastSocket socket, String playerName, int score) throws IOException {
        JsonObject json = new JsonObject();
        json.addProperty("playerName", playerName);
        json.addProperty("score", score);
        String jsonStr = json.toString();
        byte[] data = jsonStr.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("228.5.6.7"), 4446);
        socket.send(packet);
    }
    
    
}