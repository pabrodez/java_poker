package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hand implements Comparable<Hand> {

  private ArrayList<Card> cards = new ArrayList<>();

  Hand() {

  }

  Hand(Card... newCards) {
    setCards(newCards);
  }

  public ArrayList<Card> getCards() {
    return cards;
  }
  public void setCards(Card... cards) {
    Collections.addAll(this.cards, cards);
    Collections.sort(this.cards);
  }

  public void replaceCardAtIndex(int index, Card newCard) {
    this.cards.set(index, newCard);
  }

  public void clearCards() {
    cards.clear();
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
    ArrayList<Integer> orders = Hand.getCardsOrders(this);
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

  public static int compareHighCard(Hand hand1, Hand hand2) {
    // 1 if first hand has highest card, -1 if second hand, 0 if all same cards
    int scoreDiff = 0;
    for (int i = 4; i >= 0; i--) {
      scoreDiff = hand1.getCards().get(i).getOrder() - hand2.getCards().get(i).getOrder();
      if (scoreDiff != 0) break;
    }
    return (int) Math.signum(scoreDiff);
  }

  public static int compareStraight(Hand hand1, Hand hand2) {

    ArrayList<ArrayList<Integer>> ordersList = new ArrayList<>();
    ordersList.add(
            Hand.getCardsOrders(hand1)
    );
    ordersList.add(
            Hand.getCardsOrders(hand2)
    );
    for (ArrayList<Integer> orderList : ordersList) {
      if (orderList.contains(13) && !orderList.contains(12)) {
        orderList.set(4, 0);
        Collections.sort(orderList);
      }
    }
    return (int) Math.signum(ordersList.get(0).get(4) - ordersList.get(1).get(4));
  }

  public static int compareStraightFlush(Hand hand1, Hand hand2) {
    return Hand.compareStraight(hand1, hand2);
  }

  public static int compareFlush(Hand hand1, Hand hand2) {
    return Hand.compareHighCard(hand1, hand2);
  }

  public static int compareFullHouse(Hand hand1, Hand hand2) {
    // same as comparing three
    return Hand.compareThree(hand1, hand2);
  }

  public static int compareFour(Hand hand1, Hand hand2) {
    // only need to compare four cards
    // TODO: refactor to method
    int hand1FourOrder =
            Integer.parseInt(
                    hand1.countCardsOrders().entrySet().stream()
                            .filter(c -> c.getValue() == 4)
                            .map(Map.Entry::getKey)
                            .collect(Collectors.joining(""))
            );
    int hand2FourOrder =
            Integer.parseInt(
                    hand2.countCardsOrders().entrySet().stream()
                            .filter(c -> c.getValue() == 4)
                            .map(Map.Entry::getKey)
                            .collect(Collectors.joining(""))
            );

    return (int) Math.signum(hand1FourOrder - hand2FourOrder);

  }

  public static int compareThree(Hand hand1, Hand hand2) {
    // only need to compare three cards
    int hand1ThreeOrder =
            Integer.parseInt(
                    hand1.countCardsOrders().entrySet().stream()
                            .filter(c -> c.getValue() == 3)
                            .map(Map.Entry::getKey)
                            .collect(Collectors.joining(""))
            );
    int hand2ThreeOrder =
            Integer.parseInt(
                    hand2.countCardsOrders().entrySet().stream()
                            .filter(c -> c.getValue() == 3)
                            .map(Map.Entry::getKey)
                            .collect(Collectors.joining(""))
            );

    return (int) Math.signum(hand1ThreeOrder - hand2ThreeOrder);

  }

  public static int comparePair(Hand hand1, Hand hand2) {
    // if the return is 0, it's safe to assume that running compareHighCard() will work to untie the hands
    int hand1Pair = Integer.parseInt(
              hand1.countCardsOrders().entrySet().stream()
              .filter(c -> c.getValue() == 2)
              .map(c -> c.getKey())
              .collect(Collectors.joining(""))
            );

    int hand2Pair = Integer.parseInt(
            hand2.countCardsOrders().entrySet().stream()
                    .filter(c -> c.getValue() == 2)
                    .map(c -> c.getKey())
                    .collect(Collectors.joining(""))
    );

    int scoreDiff = (int) Math.signum(hand1Pair - hand2Pair);

    return scoreDiff == 0 ? Hand.compareHighCard(hand1, hand2) : scoreDiff;


  }

  public static int compareTwoPair(Hand hand1, Hand hand2) {

    int scoreDiff = 0;
    ArrayList<Integer> hand1pairs = hand1.countCardsOrders().entrySet().stream()
            .filter(c -> c.getValue() == 2)
            .map(c -> Integer.parseInt(c.getKey()))
            .collect(Collectors.toCollection(ArrayList::new));

    ArrayList<Integer> hand2pairs = hand2.countCardsOrders().entrySet().stream()
            .filter(c -> c.getValue() == 2)
            .map(c -> Integer.parseInt(c.getKey()))
            .collect(Collectors.toCollection(ArrayList::new));

    for (int i = 1; i >= 0; i--) {
      scoreDiff = hand1pairs.get(i) - hand2pairs.get(i);
      if (scoreDiff != 0) break;
    }


    return scoreDiff == 0 ? Hand.compareHighCard(hand1, hand2) : scoreDiff;
  }

  public static ArrayList<Integer> getCardsOrders(Hand hand) {
    ArrayList<Integer> orders = hand.getCards().stream()
            .map(Card::getOrder)
            .collect(Collectors.toCollection(ArrayList::new));

    return orders;
  }

  public String getCategoryString() {

    return switch (getHandScore()) {
      case 10 -> "Royal flush";
      case 9 -> "Straight flush";
      case 8 -> "Quads";
      case 7 -> "Full house";
      case 6 -> "Flush";
      case 5 -> "Straight";
      case 4 -> "Three";
      case 3 -> "Two pairs";
      case 2 -> "Pair";
      case 0 -> "High card";
      default -> "";
    };

  }

  @Override
  public int compareTo(Hand opponent) {
    int scoreDiff = this.getHandScore() - opponent.getHandScore();
    if (scoreDiff == 0) {
      switch (this.getHandScore()) {
        case 10 ->   scoreDiff = 0;
        case 9, 5 -> scoreDiff = Hand.compareStraightFlush(this, opponent);
        case 8 ->    scoreDiff = Hand.compareFour(this, opponent);
        case 7, 4 -> scoreDiff = Hand.compareThree(this, opponent);
        case 6, 0 -> scoreDiff = Hand.compareHighCard(this, opponent);
        case 3 ->    scoreDiff = Hand.compareTwoPair(this, opponent);
        case 2 ->    scoreDiff = Hand.comparePair(this, opponent);
      }
    }

    return (int) Math.signum(scoreDiff);

  }

  @Override
  public String toString() {
    return this.getCards().toString();
  }

}
