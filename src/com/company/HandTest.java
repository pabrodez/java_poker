package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HandTest {

  @Test
  public void hasPair() {
    Hand hand = new Hand(
            new Card("a", "s", 12),
            new Card("a", "s", 12),
            new Card("a", "s", 4),
            new Card("a", "s", 5),
            new Card("a", "s", 6)
            );
    assertTrue(hand.hasPair());
  }

  @Test
  public void hasThree() {
    Hand hand = new Hand(
            new Card("a", "s", 13),
            new Card("a", "s", 13),
            new Card("a", "s", 4),
            new Card("a", "s", 13),
            new Card("a", "s", 6)
    );
    assertTrue(hand.hasThree());
  }

  @Test
  public void hasFour() {
    Hand hand = new Hand(
            new Card("a", "s", 5),
            new Card("a", "s", 5),
            new Card("a", "s", 4),
            new Card("a", "s", 5),
            new Card("a", "s", 5)
    );
    assertTrue(hand.hasFour());
  }

  @Test
  public void hasFullHouse() {
    Hand hand = new Hand(
            new Card("a", "s", 2),
            new Card("a", "s", 7),
            new Card("a", "s", 7),
            new Card("a", "s", 2),
            new Card("a", "s", 2)
    );
    assertTrue(hand.hasFullHouse());
  }

  @Test
  public void hasTwoPair() {
    Hand hand = new Hand(
            new Card("a", "s", 13),
            new Card("a", "s", 3),
            new Card("a", "s", 13),
            new Card("a", "s", 10),
            new Card("a", "s", 3)
    );
    assertTrue(hand.hasTwoPair());
  }

  @Test
  public void hasFlush() {
    Hand hand = new Hand(
            new Card("a", "s", 1),
            new Card("a", "s", 2),
            new Card("a", "s", 4),
            new Card("a", "s", 6),
            new Card("a", "s", 11)
    );
    assertTrue(hand.hasFlush());
  }

  @Test
  public void hasStraight() {
    Hand hand = new Hand(
            new Card("a", "s", 4),
            new Card("a", "s", 3),
            new Card("a", "s", 1),
            new Card("a", "s", 2),
            new Card("a", "s", 13)
    );
    assertTrue(hand.hasStraight());
  }

  @Test
  public void hasStraightFlush() {
    Hand hand = new Hand(
            new Card("a", "s", 4),
            new Card("a", "s", 3),
            new Card("a", "s", 1),
            new Card("a", "s", 2),
            new Card("a", "s", 13)
    );
    assertTrue(hand.hasStraightFlush());
  }

  @Test
  public void hasRoyalFlush() {
    Hand hand = new Hand(
            new Card("a", "s", 12),
            new Card("a", "s", 9),
            new Card("a", "s", 10),
            new Card("a", "s", 11),
            new Card("a", "s", 13)
    );
    assertTrue(hand.hasRoyalFlush());
  }

  @Test
  public void getHighCard() {
    Hand hand = new Hand(
            new Card("a", "s", 13),
            new Card("a", "s", 9),
            new Card("a", "s", 10),
            new Card("a", "s", 11),
            new Card("a", "s", 8)
    );
    assertEquals(hand.getHighCard(), hand.getCards().get(4));
  }

  @Test
  public void getHandScore() {
    Hand hand = new Hand(
            new Card("a", "s", 13),
            new Card("a", "s", 11),
            new Card("a", "s", 12),
            new Card("a", "s", 10),
            new Card("a", "s", 9)
    );
    assertEquals(hand.getHandScore(), 10);
  }

  @Test
  public void compareHighCard() {
    Hand hand1 = new Hand(
            new Card("a", "d", 1),
            new Card("a", "d", 3),
            new Card("a", "d", 6),
            new Card("a", "c", 7),
            new Card("a", "s", 12)
    );
    Hand hand2 = new Hand(
            new Card("a", "c", 4),
            new Card("a", "h", 8),
            new Card("a", "s", 9),
            new Card("a", "h", 10),
            new Card("a", "s", 13)
    );
    assertEquals(-1 , Hand.compareHighCard(hand1, hand2));
  }

  @Test
  public void compareStraight() {
    Hand hand1 = new Hand(
            new Card("a", "c", 4),
            new Card("a", "c", 8),
            new Card("a", "c", 5),
            new Card("a", "c", 6),
            new Card("a", "c", 7)
    );
    Hand hand2 = new Hand(
            new Card("a", "c", 7),
            new Card("a", "h", 6),
            new Card("a", "c", 5),
            new Card("a", "p", 4),
            new Card("a", "c", 8)
    );
    assertEquals(0, Hand.compareStraight(hand1, hand2));
  }

  @Test
  public void compareFullHouse() {
    Hand hand1 = new Hand(
            new Card("a", "c", 4),
            new Card("a", "h", 13),
            new Card("a", "c", 4),
            new Card("a", "p", 4),
            new Card("a", "c", 13)
    );
    Hand hand2 = new Hand(
            new Card("a", "c", 12),
            new Card("a", "h", 13),
            new Card("a", "c", 12),
            new Card("a", "p", 13),
            new Card("a", "c", 12)
    );
    assertEquals(-1, Hand.compareFullHouse(hand1, hand2));
  }

  @Test
  public void compareFour() {
    Hand hand1 = new Hand(
            new Card("a", "c", 13),
            new Card("a", "h", 13),
            new Card("a", "c", 4),
            new Card("a", "p", 13),
            new Card("a", "c", 13)
    );
    Hand hand2 = new Hand(
            new Card("a", "c", 11),
            new Card("a", "h", 4),
            new Card("a", "c", 11),
            new Card("a", "p", 11),
            new Card("a", "c", 11)
    );
    assertEquals(1, Hand.compareFour(hand1, hand2));
  }

  @Test
  public void comparePair() {
    Hand hand1 = new Hand(
            new Card("a", "c", 5),
            new Card("a", "h", 5),
            new Card("a", "c", 7),
            new Card("a", "p", 6),
            new Card("a", "c", 2)
    );
    Hand hand2 = new Hand(
            new Card("a", "c", 5),
            new Card("a", "h", 5),
            new Card("a", "c", 6),
            new Card("a", "p", 4),
            new Card("a", "c", 8)
    );
    assertEquals(-1, Hand.comparePair(hand1, hand2));
  }

  @Test
  public void compareTwoPair() {
    Hand hand1 = new Hand(
            new Card("a", "c", 13),
            new Card("a", "h", 7),
            new Card("a", "c", 13),
            new Card("a", "p", 7),
            new Card("a", "c", 9)
    );
    Hand hand2 = new Hand(
            new Card("a", "c", 13),
            new Card("a", "h", 13),
            new Card("a", "c", 8),
            new Card("a", "p", 8),
            new Card("a", "c", 4)
    );
    assertEquals(-1, Hand.compareTwoPair(hand1, hand2));
  }

  @Test
  public void compareTo() {
    Hand hand1 = new Hand(
            new Card("a", "c", 1),
            new Card("a", "h", 3),
            new Card("a", "c", 6),
            new Card("a", "p", 7),
            new Card("a", "c", 12)
    );
    Hand hand2 = new Hand(
            new Card("a", "c", 4),
            new Card("a", "h", 8),
            new Card("a", "c", 9),
            new Card("a", "p", 10),
            new Card("a", "c", 13)
    );
    assertEquals(-1, hand1.compareTo(hand2));
  }

}
