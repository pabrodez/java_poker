package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.AfterTest;

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


}
