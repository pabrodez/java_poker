package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hand implements Comparable<Hand> {

  private final int SIZE = 5;
  private ArrayList<Card> cards;

  Hand(ArrayList<Card> cards) {
    this.cards = cards;
    Collections.sort(this.cards);
  }

  private boolean hasOcurrences(HashMap<String, Integer> hashMap, int occurrences) {
    return hashMap.containsValue(occurrences);
  }

  public HashMap<String, Integer> countCardsOrders() {
    HashMap<String, Integer> cardMap = new HashMap<>();
    for (Card card : cards) {
      String orderStr = Integer.toString(card.getOrder());
      if (cardMap.containsKey(orderStr)) {
        cardMap.put(orderStr, cardMap.get(orderStr) + 1);
      } else {
        cardMap.put(orderStr, 1);
      }
    }
    return cardMap;
  }

  public HashMap<String, Integer> countCardsSuits() {
    HashMap<String, Integer> cardMap = new HashMap<>();
    for (Card card : cards) {
      if (cardMap.containsKey(card.getSuit())) {
        cardMap.put(card.getSuit(), cardMap.get(card.getSuit()) + 1);
      } else {
        cardMap.put(card.getSuit(), 1);
      }
    }
    return cardMap;
  }


  public boolean hasPair() {
    return hasOcurrences(countCardsOrders(), 2);
  }

  public boolean hasThree() {
    return hasOcurrences(countCardsOrders(), 3);
  }

  public boolean hasFour() {
    return hasOcurrences(countCardsOrders(), 4);
  }

  public boolean hasFullHouse() {
    return hasOcurrences(countCardsOrders(), 2) && hasOcurrences(countCardsOrders(), 3);
  }

  public boolean hasTwoPair() {
    return countCardsOrders().values().stream().filter(c -> c == 2).count() == 2;
  }

  public boolean hasFlush() {
    return hasOcurrences(countCardsSuits(), 5);
  }

  public boolean hasStraight() {
    // if there's an ace with no king it needs to be shifted to the left
    ArrayList<Integer> orders = cards.stream()
            .map(c -> c.getOrder())
            .collect(Collectors.toCollection(ArrayList::new));
    if (orders.contains(13) && !orders.contains(12)) {
      // replace and resort
      orders.set(4, 0);
      Collections.sort(orders);
    }

    return orders.get(0) ==  orders.get(1) - 1 &&
        orders.get(1) ==  orders.get(2) - 1 &&
        orders.get(2) ==  orders.get(3) - 1 &&
        orders.get(3) ==  orders.get(4) - 1;
  }

  public boolean hasStraightFlush() {
    return hasStraight() && hasFlush();
  }

  public boolean hasRoyalFlush() {
    return hasStraightFlush() && cards.get(4).getOrder() == 13;
  }

  public Card getHighCard() {
    return cards.get(4);
  }

  public int getHandScore() {
    int score = 0;
    if (hasRoyalFlush())    {
      score = 10;
    } else if (hasStraightFlush()) {
      score = 9;
    }else if (hasFour())          {
      score = 8;
    } else if (hasFullHouse())     {
      score = 7;
    } else if (hasFlush())         {
      score = 6;
    } else if (hasStraight())      {
      score = 5;
    } else if (hasThree())         {
      score = 4;
    } else if (hasTwoPair())       {
      score = 3;
    } else if (hasPair()) {
      score = 2;
    }

    return score;

  }



  @Override
  public int compareTo(Hand opponent) {
    int thisScore = this.getHandScore();
    int opponentScore = opponent.getHandScore();
    int scoreDiff = thisScore - opponentScore;

    if (scoreDiff == 0) {
      if (thisScore == 0 && opponentScore == 0) {
        scoreDiff = this.getHighCard().getOrder() - opponent.getHighCard().getOrder();
      } else if (thisScore == 2 && opponentScore == 2) {
        
      }

    }
    return scoreDiff;

  }



}
