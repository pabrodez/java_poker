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

  // TODO: start Game(Player[] players).round()

  public void giveCards() {
    for (Player player : playersArray) {
      Card[] cardsOut = new Card[HAND_SIZE];
      for (int i=0; i < HAND_SIZE; i++) {
        cardsOut[i] = theDeck.drawCard(0);
      }
      player.setHand(cardsOut);
    }
    // TODO: include reshuffle standard deck here?
    theDeck.newPlayDeck();
  }

  public Player findWinner(Player[] players) {
    int highestScore = findHighestScore(players);
    ArrayList<Player> playersWithHighest = new ArrayList<>();
    Player winner = null;
    for (Player player : players) {
      if (player.getHandScore() == highestScore) playersWithHighest.add(player);
    }

    if (playersWithHighest.size() == 1) {
      // no ties
      winner = playersWithHighest.get(0);
    } else if (highestScore == 0){
      // TODO: logic to untie the round


    } else if (highestScore == 1) {

    } else if (highestScore == 2) {

    }

    return winner;
  }

  public int findHighestScore(Player[] players) {
    int[] handsScores = new int[players.length];
    for (int i = 0; i < players.length; i++) {
      handsScores[i] = findHandScore(players[i]);
    }
    Arrays.sort(handsScores);

    return handsScores[handsScores.length - 1];
  }

  public int findHandScore(Player player) {
    int score = 0;

    player.setHandScore(0);

    if (hasPair(player.getHand())) score = 1;
    if (hasTwoPair(player.getHand())) score = 2;
    if (hasThree(player.getHand())) score = 3;
    if (hasStraight(player.getHand())) score = 4;
    if (hasFlush(player.getHand())) score = 5;
    if (hasFullHouse(player.getHand())) score = 6;
    if (hasQuads(player.getHand())) score = 7;
    if (hasStraightFlush(player.getHand())) score = 8;

    player.setHandScore(score);

    return score;
  }

  public Card[] getHighCard(Card[] hand) {

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
      int repetitions = 0;
      for (int j = 0; j < hand.length; j++) {
        if (i != j && (hand[i].getOrder() == hand[j].getOrder())) {
          repetitions++;
        }
      }
      if (repetitions == 2) {
        out = repetitions;
        break;
      }

    }

    return out == 3;
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
    int[] handOrders = new int[5];
    boolean hasDeuce = false;
    boolean hasAce = false;
    // ad hoc logic to check straight starting from Ace
    for (int i=0; i < hand.length; i++) {
      handOrders[i] = hand[i].getOrder();
      if (hand[i].getOrder() == 2) hasDeuce = true;
      if (hand[i].getOrder() == 13) hasAce = true;
    }
    // reassign Ace value to 0 to make it be the first in order
    if (hasAce && hasDeuce) handOrders[4] = 0;
    Arrays.sort(handOrders);
    int nOrdered = 0;
    for (int i = 0; i < handOrders.length - 1; i++) {
      if (handOrders[i] + 1 == handOrders[i + 1]) nOrdered++;
    }
    return nOrdered == 4;
  }

  public boolean hasStraightFlush(Card[] hand) {
    return (hasFlush(hand) && hasStraight(hand));
  }

  public boolean hasTwoPair(Card[] hand) {
    int nPairs = 0;
    int lastPairOrder = 0;
    for (int i = 0; i < hand.length; i++) {
      int repetitions = 0;

      if (nPairs < 2) {
        for (int j = 0; j < hand.length; j++) {
          if ((i != j) && (hand[i].getOrder() == hand[j].getOrder())) {
            repetitions++;
          }
        }

        if (repetitions == 1 && (hand[i].getOrder() != lastPairOrder)) {
          nPairs++;
          lastPairOrder = hand[i].getOrder();
        }
      }
    }

    return nPairs == 2;
  }

  public boolean hasFullHouse(Card[] hand) {
    // 3 occurrences of card rank
    boolean threeOccur = false;
    int threeRank = 0;
    // 2 occurrences of card rank, different to the 3 occurrences rank
    boolean twoOccur = false;

    // check 3 occur
    for (int i = 0; i < hand.length; i++) {
      int nOccur = 0;
      for (int j = 0; j < hand.length; j++) {
        if (i != j && hand[i].getOrder() == hand[j].getOrder()) {
          nOccur++;
          threeRank = hand[i].getOrder();
        }
      }
      if (nOccur == 2) {
        threeOccur = true;
        break;
      }
    }
    // check 2 occur
    for (int i = 0; i < hand.length; i++) {
      int nOccur = 0;
      for (int j = 0; j < hand.length; j++) {
        if (i != j
                && hand[i].getOrder() == hand[j].getOrder()
                && hand[i].getOrder() != threeRank
                && nOccur < 2) {
          nOccur++;
        }
      }
      if (nOccur == 1) {
        twoOccur = true;
        break;
      }
    }

    return threeOccur && twoOccur;
  }
}
