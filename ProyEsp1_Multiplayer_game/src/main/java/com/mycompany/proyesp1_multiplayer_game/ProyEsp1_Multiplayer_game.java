/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyesp1_multiplayer_game;

import controller.ClientViewController;
import java.io.IOException;
import view.clientView;

/**
 *
 * @author PC-Fredy
 */
public class ProyEsp1_Multiplayer_game {

    public static void main(String[] args) throws IOException {
        clientView cv = new clientView();
        ClientViewController cvc = new ClientViewController(cv);
    }
}
