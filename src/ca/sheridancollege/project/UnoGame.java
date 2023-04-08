/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author kosti
 */
public class UnoGame extends Game{

    
    private ArrayList<UnoCard>   cardPile  = new ArrayList<>();
    private ArrayList<UnoPlayer> players   = new ArrayList<>();

    public UnoGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        
     GroupOfCards cards = new GroupOfCards(60);
          
     UnoPlayer player1 = createPlayer(players);      
     UnoPlayer player2 = createPlayer(players);
     while(player2.getName().equals(player1.getName()))
     {
      players.remove(player2);
      System.out.println("Please enter a different name");
     player2 = createPlayer(players);
    
     }
     
     UnoPlayer player3 = createPlayer(players);
     while(player3.getName().equals(player1.getName()) || player3.getName().equals(player1.getName()))
     {
         System.out.println("Please enter a different name");
     player3 = createPlayer(players);
     }
     
     ArrayList<UnoCard> deck = cards.generateDeck(cards.getCards());
     
     player1.setHand(deck);     
     player2.setHand(deck);   
     player3.setHand(deck); 
     
     showHand(player1);
     showHand(player2);
     showHand(player3);
     
     cardPile.add(deck.get(deck.size()-1));
     deck.remove(deck.size()-1);
     System.out.print("First card is: ");
     if(cardPile.get(cardPile.size()-1).getColor()==null)
           {
              System.out.println(cardPile.get(cardPile.size()-1).getCardType());
           }
         else
           {
         System.out.println(cardPile.get(cardPile.size()-1).getColor() + " " + cardPile.get(cardPile.size()-1).getNumber());
           }
     System.out.println("Let's start playing now!!!!!!!!!");
     
     while(!player1.getHand().isEmpty() && !player2.getHand().isEmpty() && !player3.getHand().isEmpty() )
     {
     
     startTurn(players,deck,0);
     startTurn(players,deck,1);
     startTurn(players,deck,2);
     
     }
     declareWinner();
    }

    public void startTurn(ArrayList<UnoPlayer> players,ArrayList<UnoCard> deck,int turn)
    {     
         if(cardPile.get(cardPile.size()-1).getNumber()== UnoCard.Number.SKIP)
         {
            turn+=1;
         }
         UnoPlayer player = players.get(turn);
         ArrayList<UnoCard> hand = player.getHand();
         int cardvalue;
         Scanner input4 = new Scanner(System.in);
        
         if(cardPile.get(cardPile.size()-1).getColor()==null)
         {
         Scanner chooseColor = new Scanner(System.in);
         System.out.println("What color do you want to change to");
         String colorchange= chooseColor.next();
         cardPile.get(cardPile.size()-1).setColor(UnoCard.Color.valueOf(colorchange.toUpperCase()));
      
         }
             
         System.out.println();
         System.out.println();
         
         showHand(player);
         if(cardPile.get(cardPile.size()-1).getNumber()== null)
         {
         System.out.println(("Top card is " + cardPile.get(cardPile.size()-1).getColor() + " Wildcard"));
         }
         else{
         System.out.println(("Top card is " + cardPile.get(cardPile.size()-1).getColor() + " " + cardPile.get(cardPile.size()-1).getNumber()));
         }
         System.out.println((player.getName() + " 's turn: "));
         
         
        
        while(true)
        {
        System.out.println(("Choose the 'number' of the card you are playing: "));
         cardvalue = input4.nextInt();
         if(cardvalue == hand.size()+1)
            {
            
             if(deck.isEmpty())
              {
                 UnoCard temp = cardPile.get(cardPile.size()-1);
                 cardPile.remove(cardPile.size()-1);
         
                  for(UnoCard card : cardPile)
                     {
                          deck.add(card);
                             cardPile.remove(card);
                     }
                     cardPile.add(temp);
                     }
                 
               player.draw(deck);   
              break;
            }
         if((hand.get(cardvalue-1).canPlayOn(cardPile.get(cardPile.size()-1))))
         { 
            
            //else if statments to check what is happeneing             
         
            if(hand.get(cardvalue-1).getCardType()==UnoCard.cardType.FOURPLUS)
            {
            for(int i=0;i<4;i++)
             {
                  players.get(turn+1).draw(deck);
                  deck.remove(deck.size()-1); 
             }
           
             }
            else if(hand.get(cardvalue-1).getCardType()==UnoCard.cardType.TWOPLUS)
            {
            for(int i=0;i<2;i++)
             {
                 if(deck.isEmpty())
                 {
                 
                 }
                  players.get(turn+1).draw(deck);
                  deck.remove(deck.size()-1); 
             }
            }
            else if(hand.get(cardvalue-1).getNumber()==UnoCard.Number.REVERSE)
               {
                    reverse(players);  
               }
             

        
        if((hand.get(cardvalue-1).getCardType() != null))
                 {
                     cardPile.get(cardPile.size()-1).setColor(null);
                 }
         
        if  (hand.get(cardvalue-1).getCardType()==UnoCard.cardType.NUMBER)
           {
           System.out.println("You played " +hand.get(cardvalue-1).getColor() + " " + hand.get(cardvalue-1).getNumber());
           }
       
        else{
                System.out.println("You played " +hand.get(cardvalue-1).getCardType());
            }
       
        cardPile.add(hand.get(cardvalue-1));
        hand.remove(cardvalue-1); 
         
         break; 
        }
        
        }
                
    }
    

     public UnoPlayer createPlayer(ArrayList<UnoPlayer> players)
     {
     Scanner input = new Scanner(System.in);
     System.out.println("Enter player name: ");
     String name= input.next();
     UnoPlayer player1 = new UnoPlayer(name);
     players.add(player1);
     
    
     
     return player1;
     }
       
    
    
    
    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
    public void showHand(UnoPlayer one)
    {
        ArrayList<UnoCard> hand = one.getHand();
          System.out.println();
     System.out.println("Deck for " + one.getName() );
     for(UnoCard card: hand)
     {
           if(card.getColor()==null)
           {
              System.out.println(hand.indexOf(card)+1 + ") "+ card.getCardType());
           }
         else
           {
         System.out.println(hand.indexOf(card)+1 + ") " +  card.getColor() + " " + card.getNumber());
           }
           
     }
        System.out.println( hand.size()+1 + " )Draw a card");
    }
    public void reverse(ArrayList <UnoPlayer> players )
    {
       UnoPlayer temporary = players.get(0);
       players.set(0,players.get(1));
       players.set(1,players.get(2));
       players.set(2,temporary);
       
       System.out.println("Reversing order of playing...");
    }
 
    

    /**
     * @return the cardPile
     */
    public ArrayList<UnoCard> getCardPile() {
        return cardPile;
    }

    /**
     * @param cardPile the cardPile to set
     */
    public void setCardPile(ArrayList<UnoCard> cardPile) {
        this.cardPile = cardPile;
    }   
}

