package com.company;

import java.util.*;
import java.lang.StringBuilder;

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

  public boolean hasPair(Card[] hand) {
    boolean out = false;
    for (int i = 0; i < hand.length; i++) {
      for (int j = 0; j < hand.length; j++) {
        if (i != j && hand[i].getOrder() == hand[j].getOrder()) {
          out = true;
          break;
        }
      }
    }

    return out;
  }

  public boolean hasThree(Card[] hand) {
    int out = 0;
    for (int i = 0; i < hand.length; i++) {
      int occurrences = 1;
      for (int j = 0; j < hand.length; j++) {
        if (i != j && (hand[i].getOrder() == hand[j].getOrder())) {
          occurrences++;
        }
      }
      if (occurrences >= 3) {
        out = occurrences;
        break;
      }

    }

    return out >= 3;
  }

  public boolean hasQuads(Card[] hand) {
    int out = 0;
    for (int i = 0; i < hand.length; i++) {
      int occurrences = 1;
      for (int j = 0; j < hand.length; j++) {
        if (i != j && (hand[i].getOrder() == hand[j].getOrder())) {
          occurrences++;
        }
      }
      if (occurrences == 4) {
        out = occurrences;
        break;
      }

    }

    return out == 4;
  }

  public boolean hasFlush(Card[] hand) {
    StringBuilder handSuits = new StringBuilder();
    for (Card card : hand) {
      handSuits.append(card.getSuit());
    }
    return(handSuits.toString().equals(hand[0].getSuit().repeat(5)));
  }

  public boolean hasStraight(Card[] hand) {
    ArrayList<Card> handOrders = new ArrayList<>();
    for (Card card : hand) {
      handOrders
    }
  }

//  public Card[] getHighestPair(Card[] hand) {
//
//    for (int i = 0; i < hand.length-1; i++) {
//      for (int j = i+1; j < hand.length-1; j++) {
//        if (hand[i].getOrder() == hand[j].getOrder()) {
//         if (hand[i].getOrder() > highestPair[0].getOrder()) {
//           highestPair[0] = hand[i];
//           highestPair[1] = hand[j];
//
//           break;
//         }
//        }
//      }
//    }
//
//    return highestPair;
//  }

}
