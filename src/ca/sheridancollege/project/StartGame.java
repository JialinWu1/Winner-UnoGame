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
public class StartGame {
    
    public static void main(String[] args)
    {
    
    }
    
    public ArrayList<UnoCard> generateDeck()
    {
        GroupOfCards myCards = new GroupOfCards(60);
        ArrayList<UnoCard> deck = myCards.getCards();
        return deck;
    }
    }
