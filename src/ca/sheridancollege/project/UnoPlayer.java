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
public class UnoPlayer extends Player {

    /**
     * @return the hand
     */
    public ArrayList <UnoCard> getHand() {
        return hand;
    }

    /**
     * @param hand the hand to set
     */
    public void setHand(ArrayList <UnoCard> deck) {
        ArrayList<UnoCard> hand = new ArrayList<>();
        for(int i=0;i<7;i++)
     {
         hand.add(deck.get(deck.size()-1));
         deck.remove(deck.size()-1);
     }
       this.hand = hand;
      
    }

    private int playerIndex;
    
    public UnoPlayer(String name) {
        super(name);
    }
    
    private ArrayList <UnoCard> hand;

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
    public void draw( ArrayList<UnoCard> deck) {
        hand.add(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);
    }
    
    
   
 
    /**
     * @return the playerIndex
     */
    public int getPlayerIndex() {
        return playerIndex;
    }

    /**
     * @param playerIndex the playerIndex to set
     */
    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
  
    
}
