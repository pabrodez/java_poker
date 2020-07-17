package com.company;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class HandTest {

  @org.junit.jupiter.api.Test
  public void hasPair() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("a", "s", 12));
    cards.add(new Card("a", "s", 12));
    cards.add(new Card("a", "s", 4));
    cards.add(new Card("a", "s", 5));
    cards.add(new Card("a", "s", 6));
    Hand hand = new Hand(cards);
    assertTrue(hand.hasPair());
  }

  @org.junit.jupiter.api.Test
  public void hasThree() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("a", "s", 13));
    cards.add(new Card("a", "s", 13));
    cards.add(new Card("a", "s", 4));
    cards.add(new Card("a", "s", 13));
    cards.add(new Card("a", "s", 6));
    Hand hand = new Hand(cards);
    assertTrue(hand.hasThree());
  }

  @org.junit.jupiter.api.Test
  public void hasFour() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("a", "s", 5));
    cards.add(new Card("a", "s", 5));
    cards.add(new Card("a", "s", 13));
    cards.add(new Card("a", "s", 5));
    cards.add(new Card("a", "s", 5));
    Hand hand = new Hand(cards);
    assertTrue(hand.hasFour());
  }

  @org.junit.jupiter.api.Test
  public void hasFullHouse() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("a", "s", 5));
    cards.add(new Card("a", "s", 5));
    cards.add(new Card("a", "s", 13));
    cards.add(new Card("a", "s", 5));
    cards.add(new Card("a", "s", 13));
    Hand hand = new Hand(cards);
    assertTrue(hand.hasFullHouse());
  }

  @org.junit.jupiter.api.Test
  public void hasTwoPair() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("a", "s", 13));
    cards.add(new Card("a", "s", 3));
    cards.add(new Card("a", "s", 13));
    cards.add(new Card("a", "s", 10));
    cards.add(new Card("a", "s", 3));
    Hand hand = new Hand(cards);
    assertTrue(hand.hasTwoPair());
  }

  @org.junit.jupiter.api.Test
  public void hasFlush() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("a", "h", 1));
    cards.add(new Card("a", "h", 2));
    cards.add(new Card("a", "h", 4));
    cards.add(new Card("a", "h", 6));
    cards.add(new Card("a", "h", 11));
    Hand hand = new Hand(cards);
    assertTrue(hand.hasFlush());
  }

  @org.junit.jupiter.api.Test
  public void hasStraight() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("2", "h", 4));
    cards.add(new Card("3", "s", 3));
    cards.add(new Card("4", "c", 1));
    cards.add(new Card("5", "d", 2));
    cards.add(new Card("6", "h", 13));
    Hand hand = new Hand(cards);

    assertTrue(hand.hasStraight());
  }

  @org.junit.jupiter.api.Test
  public void hasStraightFlush() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("2", "d", 4));
    cards.add(new Card("3", "d", 3));
    cards.add(new Card("4", "d", 1));
    cards.add(new Card("5", "d", 2));
    cards.add(new Card("6", "d", 13));
    Hand hand = new Hand(cards);

    assertTrue(hand.hasStraightFlush());
  }

  @org.junit.jupiter.api.Test
  public void hasRoyalFlush() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("2", "c", 12));
    cards.add(new Card("3", "c", 9));
    cards.add(new Card("4", "c", 10));
    cards.add(new Card("5", "c", 11));
    cards.add(new Card("6", "c", 13));
    Hand hand = new Hand(cards);

    assertTrue(hand.hasRoyalFlush());
  }

  @org.junit.jupiter.api.Test
  public void getHighCard() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("2", "c", 13));
    cards.add(new Card("3", "c", 9));
    cards.add(new Card("4", "c", 10));
    cards.add(new Card("5", "c", 11));
    cards.add(new Card("6", "c", 8));
    Hand hand = new Hand(cards);

    assertEquals(hand.getHighCard(), cards.get(4));
  }

  @org.junit.jupiter.api.Test
  public void getHandScore() {
    ArrayList<Card> cards = new ArrayList<>();
    cards.add(new Card("2", "c", 13));
    cards.add(new Card("3", "c", 11));
    cards.add(new Card("4", "c", 12));
    cards.add(new Card("5", "c", 10));
    cards.add(new Card("6", "c", 9));
    Hand hand = new Hand(cards);

    assertEquals(hand.getHandScore(), 10);
  }

  @org.junit.jupiter.api.Test
  public void compareHighCard() {
    ArrayList<Card> cards1 = new ArrayList<>();
    cards1.add(new Card("2", "c", 13));
    cards1.add(new Card("3", "c", 11));
    cards1.add(new Card("4", "c", 12));
    cards1.add(new Card("5", "c", 10));
    cards1.add(new Card("6", "c", 7));
    Hand hand1 = new Hand(cards1);

    ArrayList<Card> cards2 = new ArrayList<>();
    cards2.add(new Card("2", "c", 13));
    cards2.add(new Card("3", "h", 11));
    cards2.add(new Card("4", "c", 12));
    cards2.add(new Card("5", "p", 10));
    cards2.add(new Card("6", "c", 8));
    Hand hand2 = new Hand(cards2);

    assertEquals(Hand.compareHighCard(hand1, hand2), -1);
  }

  @org.junit.jupiter.api.Test
  public void compareStraight() {
    ArrayList<Card> cards1 = new ArrayList<>();
    cards1.add(new Card("2", "c", 8));
    cards1.add(new Card("3", "c", 4));
    cards1.add(new Card("4", "c", 5));
    cards1.add(new Card("5", "c", 6));
    cards1.add(new Card("6", "c", 7));
    Hand hand1 = new Hand(cards1);

    ArrayList<Card> cards2 = new ArrayList<>();
    cards2.add(new Card("2", "c", 7));
    cards2.add(new Card("3", "h", 5));
    cards2.add(new Card("4", "c", 6));
    cards2.add(new Card("5", "p", 4));
    cards2.add(new Card("6", "c", 8));
    Hand hand2 = new Hand(cards2);

    assertEquals(0, Hand.compareStraight(hand1, hand2));
  }

  @org.junit.jupiter.api.Test
  public void compareFullHouse() {
    ArrayList<Card> cards1 = new ArrayList<>();
    cards1.add(new Card("2", "c", 4));
    cards1.add(new Card("3", "c", 13));
    cards1.add(new Card("4", "c", 4));
    cards1.add(new Card("5", "c", 4));
    cards1.add(new Card("6", "c", 13));
    Hand hand1 = new Hand(cards1);

    ArrayList<Card> cards2 = new ArrayList<>();
    cards2.add(new Card("2", "c", 12));
    cards2.add(new Card("3", "h", 13));
    cards2.add(new Card("4", "c", 12));
    cards2.add(new Card("5", "p", 13));
    cards2.add(new Card("6", "c", 12));
    Hand hand2 = new Hand(cards2);

    assertEquals(-1, Hand.compareFullHouse(hand1, hand2));
  }

  @org.junit.jupiter.api.Test
  public void compareFour() {
    ArrayList<Card> cards1 = new ArrayList<>();
    cards1.add(new Card("2", "c", 13));
    cards1.add(new Card("3", "c", 13));
    cards1.add(new Card("4", "c", 4));
    cards1.add(new Card("5", "c", 13));
    cards1.add(new Card("6", "c", 13));
    Hand hand1 = new Hand(cards1);

    ArrayList<Card> cards2 = new ArrayList<>();
    cards2.add(new Card("2", "c", 11));
    cards2.add(new Card("3", "h", 4));
    cards2.add(new Card("4", "c", 11));
    cards2.add(new Card("5", "p", 11));
    cards2.add(new Card("6", "c", 11));
    Hand hand2 = new Hand(cards2);

    assertEquals(1, Hand.compareFour(hand1, hand2));
  }

  @org.junit.jupiter.api.Test
  public void comparePair() {
    ArrayList<Card> cards1 = new ArrayList<>();
    cards1.add(new Card("2", "c", 5));
    cards1.add(new Card("3", "c", 5));
    cards1.add(new Card("4", "c", 7));
    cards1.add(new Card("5", "c", 6));
    cards1.add(new Card("6", "c", 2));
    Hand hand1 = new Hand(cards1);

    ArrayList<Card> cards2 = new ArrayList<>();
    cards2.add(new Card("2", "c", 5));
    cards2.add(new Card("3", "h", 5));
    cards2.add(new Card("4", "c", 6));
    cards2.add(new Card("5", "p", 4));
    cards2.add(new Card("6", "c", 8));
    Hand hand2 = new Hand(cards2);

    assertEquals(-1, Hand.comparePair(hand1, hand2));
  }

  @org.junit.jupiter.api.Test
  public void compareTwoPair() {
    ArrayList<Card> cards1 = new ArrayList<>();
    cards1.add(new Card("2", "c", 13));
    cards1.add(new Card("3", "c", 7));
    cards1.add(new Card("4", "c", 13));
    cards1.add(new Card("5", "c", 7));
    cards1.add(new Card("6", "c", 9));
    Hand hand1 = new Hand(cards1);

    ArrayList<Card> cards2 = new ArrayList<>();
    cards2.add(new Card("2", "c", 13));
    cards2.add(new Card("3", "h", 13));
    cards2.add(new Card("4", "c", 8));
    cards2.add(new Card("5", "p", 8));
    cards2.add(new Card("6", "c", 4));
    Hand hand2 = new Hand(cards2);

    assertEquals(-1, Hand.compareTwoPair(hand1, hand2));
  }

}
