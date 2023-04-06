/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unocard;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *The Deck class consists of 60 Uno Cards. There are 4 colors: Red, Green, Blue and Yellow.
 * Each color consists of one 0 card, two 1 cards, 2s, 3s, 4s, 5s, 6s, 7s, 8s, 9s; 1 Draw_Two cards; 1 Skip Cards and 1 Reverse cards.
 * In addition, there are 4 Wild cards and 4 Wild_Draw_Four cards.
 * @author Jialin_Wu
 */
public class UnoDeck 
{
    private UnoCard[] cards;
    private int cardsInDeck;
    
    public UnoDeck()
    {
        cards = new UnoCard[60];
    }
    public void reset()
    {
        UnoCard.Color[] colors = UnoCard.Color.values();
        cardsInDeck = 0;
        
        for(int i = 0; i < colors.length-1; i++)
        {
            UnoCard.Color color = colors[i];
            cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0));
            
            for(int j= 1; j < 10; j++)
            {
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
            }
            
            UnoCard.Value[] values = new UnoCard.Value[]{UnoCard.Value.DrawTwo, UnoCard.Value.Skip, UnoCard.Value.Reverse};
            for(UnoCard.Value value: values)
            {
                cards[cardsInDeck++] = new UnoCard(color,value);
                cards[cardsInDeck++] = new UnoCard(color,value);
            }
        }
        
        UnoCard.Value[] values = new UnoCard.Value[]{UnoCard.Value.Wild, UnoCard.Value.Wild_Four};
        for(UnoCard.Value value : values)
        {
            for(int i = 0; i < 4; i++)
            {
                cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Wild, value); //???the video is wrong about this..
            }
        }
    }
    /*
    *@parameter cards(stockpile)
    *replace the deck with an arraylist of UnoCards(the stockpile)
    */
    public void replaceDeckWith(ArrayList<UnoCard> cards)
    {
        this.cards = cards.toArray(new UnoCard[cards.size()]);
        this.cardsInDeck = this.cards.length;
    }
    //check if the cards in the deck are empty
    public boolean isEmpty()
    {
        return cardsInDeck == 0;
    }
    //shuffle the deck
    public void shuffle()
    {
        int n = cards.length;
        Random random = new Random();
        
        for(int i = 0; i<cards.length; i++)
        {
            //get a random index of the array past the current index
            //then the argument is an exclusive bound
            //Swap the random element with the present element
            int randomValue = i + random.nextInt(n -i);
            UnoCard randomCard = cards [randomValue];  //draw a random card from the deck
            //swap it
            cards[randomValue] = cards[i]; //put the first card at the position of the random value
            cards[i] = randomCard;        //the random card created on line83 is put at the 1st position of the deck
        }   
    }
    public UnoCard drawCard() throws IllegalArgumentException
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("Cannot draw a card since no cards in the deck");
        }
        return cards[--cardsInDeck];
    }
    //if we want to make a GUI game, run this method, otherwise, comment it out.
    public ImageIcon drawCardImage() throws IllegalArgumentException
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("Cannot draw a card since the deck is empty");
        }
        return new ImageIcon(cards[--cardsInDeck].toString() + ".png ");  //toString returns the card with the color and numebr
    }
    //draw card when someone hits you with the +2 or +4, you get multiple unocards
    public UnoCard[] drawCard(int n) throws IllegalArgumentException
    {
        if(n < 0)
        {
            throw new IllegalArgumentException("Must draw positive cards and try to draw" + n + "cards.");
        }
        if(n > cardsInDeck)
        {
            throw new IllegalArgumentException("Cannot draw" + n + "cards since there are only" + cardsInDeck + "cards left.");                                                                                                            
        }
        UnoCard[] ret = new UnoCard[n];
        for(int i=0; i<n; i++)
        {
            ret[i] = cards[--cardsInDeck];
        }
        return ret;
    }
}
