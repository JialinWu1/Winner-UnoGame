/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author kosti
 */
public class UnoGame extends Game{
    private int playerIndex;
    private ArrayList<UnoCard> cardPile;
    

    public UnoGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
    public ArrayList<UnoCard> showHand(ArrayList<UnoCard> hand)
    {
            return hand;
    }
    public void reverse()
    {
       boolean reverse;

       
    }
    
}
