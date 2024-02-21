/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author PC-Fredy
 */
public class MultiCastServer {
    private MulticastSocket serverSocket;
    
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
    
    public void getCommand(){
        
    }
    
    public void savePlayer(){
                                            
    }
    
    
}


