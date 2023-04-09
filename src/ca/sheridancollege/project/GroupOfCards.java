/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<UnoCard> unocards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
    }
 
    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<UnoCard> getCards(){
        return unocards;
    }

    public void shuffle() {
        Collections.shuffle(unocards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public UnoCard deliverCard(UnoCard unocard)
    {
       return unocard;
    }
  // generate a deck and shuufle it
     public ArrayList<UnoCard> generateDeck(ArrayList<UnoCard> deck)
    {
        deck = new ArrayList<>();
        
        
        for(int i=1;i<=size;i++)
        {
           UnoCard card = new UnoCard();
           deck.add(card);
                   
        }
       
        int index = 0;
    for (UnoCard.Color color : UnoCard.Color.values()) {
        for (UnoCard.Number number : UnoCard.Number.values()) {
            
            deck.get(index).setColor(color);
            deck.get(index).setNumber(number);
            deck.get(index).setCardType(UnoCard.cardType.NUMBER);
            index++;
            
        }

    }
    
     
    
     for(int i=52;i<=55;i++)
        {
          deck.get(i).setCardType(UnoCard.cardType.WILDCARD);
          index++;
        }
      for(int i=56;i<=59;i++)
        {
          deck.get(i).setCardType(UnoCard.cardType.FOURPLUS);
          index++;
        }
      
      for (UnoCard.Color color : UnoCard.Color.values()) {
        for (UnoCard.Number number : UnoCard.Number.values()) {
            
            deck.get(index).setColor(color);
            deck.get(index).setNumber(number);
            deck.get(index).setCardType(UnoCard.cardType.NUMBER);
            index++;
            
        }
  
    }
    
     
    
    
        Collections.shuffle(deck);
        return deck;
       
    
    
    }
    }
  
//end class
