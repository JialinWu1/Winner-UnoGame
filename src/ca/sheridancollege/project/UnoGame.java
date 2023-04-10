/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kosti
 */
public class UnoGame extends Game{
  
  private static UnoGame unoGame; //UnoGame static and private
  private ArrayList<UnoCard>   cardPile  = new ArrayList<>();
  private ArrayList<UnoPlayer> players   = new ArrayList<>();
  
  //private constuctor
  private UnoGame(String name)  {  
    super(name);
  }
  
  // getInstance method to create only one UnoGame(SingleTon design pattern)
  public static UnoGame getInstance()
  {
    if(unoGame == null)
    {
       unoGame = new UnoGame("UnoGame"); 
    }
    return unoGame;
  }
  
  
  //method that is used to start the game
  @Override
  public void play() {
    
    GroupOfCards cards = new GroupOfCards(112);
    
    //creating players
    UnoPlayer player1 = createPlayer(players);      
    UnoPlayer player2 = createPlayer(players);
    while(player2.getName().equals(player1.getName()))  //players shouldn't have the same name
    {
      players.remove(player2);
      System.out.println("Please enter a different name");
      player2 = createPlayer(players);
    }
    
    UnoPlayer player3 = createPlayer(players);
    while(player3.getName().equals(player1.getName()) || player3.getName().equals(player2.getName()))
    {
      System.out.println("Please enter a different name");
      player3 = createPlayer(players);
    }
    
    ArrayList<UnoCard> deck = cards.generateDeck(cards.getCards());
    
    //giving each player a hand from the deck
    player1.setHand(deck);     
    player2.setHand(deck);   
    player3.setHand(deck); 
    
    //adding a card from the deck in the cardpile for the first card to start the game
    cardPile.add(deck.get(deck.size()-1));
    deck.remove(deck.size()-1);
    
    //displaying first card
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
    
    //each user takes turn until one finish his cards and then declare the winner
    while(!player1.getHand().isEmpty() && !player2.getHand().isEmpty() && !player3.getHand().isEmpty() )
    { 
      startTurn(players,deck,0);
      declareWinner(players);
      startTurn(players,deck,1);
      declareWinner(players);
      startTurn(players,deck,2);
      declareWinner(players); 
    }
    
  }
  
  // method to simulate a turn for one player
  public void startTurn(ArrayList<UnoPlayer> players,ArrayList<UnoCard> deck,int turn)
  {  
      
    //geting the player that has the turn to play  
    UnoPlayer player = players.get(turn);
    ArrayList<UnoCard> hand = player.getHand();
    
    int cardvalue; //each card in the hand has an order and user select the number of the card by its order.
    Scanner input4 = new Scanner(System.in);
    
    
    if(cardPile.get(cardPile.size()-1).getColor()==null)
    {
      
      Scanner input = new Scanner(System.in);
      String chooseColor;
      
      //changing the color if A wildcard was played
      do{     
        
        System.out.println("What color do you want to change to? ");
        chooseColor = input.next();
        
        
      }
      while (!chooseColor.matches("R..|r..|G....|g....|B...|b...|Y.....|y.....") );  // making sure no runtime error occurs when asking for color
      
      
      
      if (chooseColor.matches("R..|r..") )
      {chooseColor = "Red";  }
      else if (chooseColor.matches("G....|g....") )
      { chooseColor = "Green";}
      else if (chooseColor.matches("B...|b...") )
      {chooseColor = "Blue";}
      else if (chooseColor.matches("Y.....|y.....") )
      { chooseColor = "Yellow";}
      
      
      cardPile.get(cardPile.size()-1).setColor(UnoCard.Color.valueOf(chooseColor.toUpperCase()));
     
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
    // if there is a skip card played stop the player from playing a card
     if(cardPile.get(cardPile.size()-1).getNumber()== UnoCard.Number.SKIP)
      {
        System.out.println("You are stopped");
        cardPile.get(cardPile.size()-1).setNumber(UnoCard.Number.SIX); 
     }
     else{
         
    while(true)
    {
        while (true)
        {
            try{
      System.out.println(("Choose the 'number' of the card you are playing: "));
      cardvalue = Integer.parseInt(input4.nextLine());
      if(cardvalue>0 && cardvalue <hand.size()+2)
         { 
             System.out.println("You drew a card");
             break;}
      
       }
         catch( NumberFormatException e)
         {
               
         }
            }
       
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
        //draw four card 
        if(hand.get(cardvalue-1).getCardType()==UnoCard.cardType.FOURPLUS)
        {
          for(int i=0;i<4;i++)
          {
            if(players.indexOf(player)==2)
            {
              players.get(1).draw(deck);
            }
            else{
            players.get(turn+1).draw(deck);
            }
            deck.remove(deck.size()-1); 
          }
          
        }
        //draw two cards
        else if(hand.get(cardvalue-1).getNumber()==UnoCard.Number.TWOPLUS)
        {
          for(int i=0;i<2;i++)
          {
            if(players.indexOf(player)==2)
            {
              players.get(1).draw(deck);
            }
            players.get(turn+1).draw(deck);
            deck.remove(deck.size()-1); 
          }
        }
        //reversing order
        else if(hand.get(cardvalue-1).getNumber()==UnoCard.Number.REVERSE)
        {
          reverse(players);  
        }
        
        
     
        if((hand.get(cardvalue-1).getCardType() != UnoCard.cardType.NUMBER))
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
        
        if(cardPile.get(cardPile.size()-1).getNumber()== null)
    {
      cardPile.get(cardPile.size()-1).setColor(null);
    }
        cardPile.add(hand.get(cardvalue-1));
        hand.remove(cardvalue-1); 
        for (int i = 0; i < cardPile.size() - 1; i++) {
          deck.add(cardPile.get(i));
          cardPile.remove(i);
        }
        break; 
      } 
    
    }
     }
  }
  
 //create a player method
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
  public void declareWinner()
  {
    System.out.print("And the winner is..  ");
  }
  
  //declare winner method
  public void declareWinner(ArrayList<UnoPlayer> players ) {
    
    for(UnoPlayer player: players)
    {
      if(player.getHand().isEmpty())
      {
        declareWinner();
        System.out.println(player.getName());
      }
      
    }
  }
  //displaying hand 
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
    System.out.println( hand.size()+1 + ") Draw a card");
  }
  //reversing order of players through the array
  public void reverse(ArrayList <UnoPlayer> players )
  {
    UnoPlayer temporary = players.get(1);
    
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

