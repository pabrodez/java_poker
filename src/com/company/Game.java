package com.company;

import java.util.*;

public class Game {
  private static final int HAND_SIZE = 5;
  private Player[] playersArray;
  private Deck theDeck;

  public Game(Player[] players) {
    this.playersArray = players;
    theDeck = new Deck();
  }

  public void giveCards() {
    for (Player player : playersArray) {
      Card[] cardsOut = new Card[HAND_SIZE];
      for (int i=0; i < HAND_SIZE; i++) {
        cardsOut[i] = theDeck.drawCard(0);
      }
      player.setHand(cardsOut);
    }
  }

  public Card[] getHighCard(Card[] hand) {
    // TODO: implement Stream.reduce()
    Card[] highestCard = new Card[1];
    highestCard[0] = hand[0];
    for (Card card : hand) {
      if (card.getOrder() > highestCard[0].getOrder()) highestCard[0] = card;
    }
    return highestCard;
  }

  public Card[] getHighestPair(Card[] hand) {
    Card[] highestPair = new Card[2];
    for (int i = 0; i < hand.length-1; i++) {
      for (int j = i+1; j < hand.length; j++) {
        if (hand[i].getOrder() == hand[j].getOrder()) {
         if (hand[i].getOrder() > highestPair[0].getOrder()) {
           highestPair[0] = hand[i];
           highestPair[1] = hand[j];

           break;
         }
        }
      }
    }

    return highestPair;
  }

}
