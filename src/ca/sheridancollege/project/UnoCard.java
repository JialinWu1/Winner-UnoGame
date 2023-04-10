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
public class UnoCard extends Card{

    enum Color{RED,GREEN,BLUE,YELLOW,};
    enum Number{ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TWOPLUS,REVERSE,SKIP};
    enum cardType{NUMBER,REVERSE,TWOPLUS,SKIP,WILDCARD,FOURPLUS};

    private Color color;
    private Number number;
    private cardType cardType;
    private int cardIndex; 
   
    
    /**
     * @return the cardIndex
     */
    public int getCardIndex() {
        return cardIndex;
    }

    /**
     * @param cardIndex the cardIndex to set
     */
    public void setCardIndex(int cardIndex) {
        this.cardIndex = cardIndex;
    }

    public UnoCard()
    {
    }
   public UnoCard(Color color,Number number,cardType cardType) {
       this.color = color;
       this.number = number;
       this.cardType=cardType;
               
       
    }

    
    
    
    

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the number
     */
    public Number getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Number number) {
        this.number = number;
    }

    /**
     * @return the cardType
     */
    public cardType getCardType() {
        return cardType;
    }

    /**
     * @param cardType the cardType to set
     */
    public void setCardType(cardType cardType) {
        this.cardType = cardType;
    }
    //Method to show if the card is playable. Parameter is the card on the cardPile.
    public boolean canPlayOn(UnoCard c) {
        return cardType ==   cardType.WILDCARD  ||
                cardType == cardType.FOURPLUS ||
                color == c.getColor() ||
                number == c.number && cardType == c.getCardType().NUMBER;
    }
     
     
     
       
}
