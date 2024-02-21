/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyesp1_multiplayer_game;

import java.io.IOException;
import model.TriviaServer;

/**
 *
 * @author PC-Fredy
 */
public class ProyEsp1_Multiplayer_game {

    public static void main(String[] args) throws IOException {
        TriviaServer ts = new TriviaServer("224.0.0.1", 9000);
        ts.start();
    }
}
