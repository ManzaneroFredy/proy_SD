/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;

/**
 *
 * @author PC-Fredy
 */
public class MultiCastServer {
    private MulticastSocket serverSocket;
    private ArrayList<Player> players = new ArrayList();
    private ArrayList<Player> countPlayer = new ArrayList();

    
    public void start(String portGroup, int serverPort) throws IOException{
        try{
            InetAddress group = InetAddress.getByName(portGroup);
            this.serverSocket = new MulticastSocket(serverPort);
            this.serverSocket.joinGroup(group);
            while(true){
                byte inBuffer[] = new byte[1024];
                DatagramPacket data = new DatagramPacket(inBuffer, inBuffer.length);
                this.serverSocket.receive(data);
                String messageFromClient = new String (data.getData());
                JsonElement request = JsonParser.parseString(messageFromClient);
                
                
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void getCommand(JsonElement request){
        JsonArray jsonArray = request.getAsJsonArray();
        
        for(JsonElement element: jsonArray){
            JsonObject object = element.getAsJsonObject();
            if(object.get("command").toString().equals("register")){
                registerPlayer(object);
            }
            if(object.get("command").toString().equals("start")){
                if(!this.countPlayer.isEmpty()){
                    reduceStartingPlayers(object);
                }else{
                    startGame();
                }
                
            }
            
        }
    }
    
    public void registerPlayer(JsonObject player){
        Player playeTemp = new Player(player.get("username").toString());
        this.players.add(playeTemp);
        this.countPlayer.add(playeTemp);
    }
    
    public void reduceStartingPlayers(JsonObject player){
        String userToSearch = player.get("username").toString();
        for(Player user: this.countPlayer){
            if(user.getPlayerName().equals(userToSearch)){
                this.countPlayer.remove(user);
            }
        }
    }
    
    public void startGame(){
        JsonObject startMessage = new JsonObject();
        startMessage.add("command", startMessage);
    }
}


