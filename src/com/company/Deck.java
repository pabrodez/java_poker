package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Deck {
  private static final int SIZE = 52;
  private static final String TWO = "2";
  private static final String THREE = "3";
  private static final String FOUR = "4";
  private static final String FIVE = "5";
  private static final String SIX = "6";
  private static final String SEVEN = "7";
  private static final String EIGHT = "8";
  private static final String NINE = "9";
  private static final String TEN = "T";
  private static final String JACK = "J";
  private static final String QUEEN = "Q";
  private static final String KING = "K";
  private static final String ACE = "A";

  private static final String SPADES = "s";
  private static final String HEARTS = "h";
  private static final String DIAMONDS = "d";
  private static final String CLUBS = "c";

  public enum Suit {
    SPADES("s"),
    HEARTS("h"),
    DIAMONDS("d"),
    CLUBS("c");

    public final String letter;

    Suit(String letter) {
      this.letter = letter;
    }
  }

  public enum Rank {
    TWO(1, "2"), THREE(2, "3"), FOUR(3, "4"), FIVE(4, "5"),
    SIX(5, "6"), SEVEN(6, "7"), EIGHT(7, "8"), NINE(8, "9"),
    TEN(9, "10"), JACK(10, "J"), QUEEN(11, "Q"), KING(12, "K"),
    ACE(13, "A");

    public final int order;
    public final String value;

    Rank(int order, String value) {
      this.order = order;
      this.value = value;
    }
  }

  private final ArrayList<Card> STANDARD_DECK = new ArrayList<>();

  // TODO: make content of STANDARD_DECK a class parameter (not instance)

//  private static final ArrayList<Card> STANDARD_DECK = new ArrayList<>(Arrays.asList(
//          new Card(Rank.TWO.value, Suit.SPADES.letter, Rank.TWO.order),
//          new Card(Rank.THREE.value, Suit.SPADES.letter, 2),
//          new Card(FOUR, Suit.SPADES.letter, 3),
//          new Card(FIVE, Suit.SPADES.letter, 4),
//          new Card(SIX, Suit.SPADES.letter, 5),
//          new Card(SEVEN, Suit.SPADES.letter,6 ),
//          new Card(EIGHT, Suit.SPADES.letter, 7),
//          new Card(NINE, Suit.SPADES.letter, 8),
//          new Card(TEN, Suit.SPADES.letter, 9),
//          new Card(JACK, Suit.SPADES.letter, 10),
//          new Card(QUEEN, Suit.SPADES.letter, 11),
//          new Card(KING, Suit.SPADES.letter, 12),
//          new Card(ACE, Suit.SPADES.letter, 13),
//
//          new Card(TWO,  Suit.HEARTS.letter, 1),
//          new Card(THREE, HEARTS, 2),
//          new Card(FOUR, HEARTS, 3),
//          new Card(FIVE, HEARTS,4 ),
//          new Card(SIX, HEARTS, 5),
//          new Card(SEVEN, HEARTS, 6),
//          new Card(EIGHT, HEARTS, 7),
//          new Card(NINE, HEARTS, 8),
//          new Card(TEN, HEARTS, 9),
//          new Card(JACK, HEARTS, 10),
//          new Card(QUEEN, HEARTS, 11),
//          new Card(KING, HEARTS, 12),
//          new Card(ACE, HEARTS, 13),
//
//          new Card(TWO, DIAMONDS, 1),
//          new Card(THREE, DIAMONDS,2),
//          new Card(FOUR, DIAMONDS,3),
//          new Card(FIVE, DIAMONDS,4),
//          new Card(SIX, DIAMONDS,5),
//          new Card(SEVEN, DIAMONDS,6),
//          new Card(EIGHT, DIAMONDS,7),
//          new Card(NINE, DIAMONDS,8),
//          new Card(TEN, DIAMONDS,9),
//          new Card(JACK, DIAMONDS,10),
//          new Card(QUEEN, DIAMONDS,11),
//          new Card(KING, DIAMONDS,12),
//          new Card(ACE, DIAMONDS,13),
//
//          new Card(TWO, CLUBS,1),
//          new Card(THREE, CLUBS,2),
//          new Card(FOUR, CLUBS,3),
//          new Card(FIVE, CLUBS,4),
//          new Card(SIX, CLUBS,5),
//          new Card(SEVEN, CLUBS,6),
//          new Card(EIGHT, CLUBS,7),
//          new Card(NINE, CLUBS,8),
//          new Card(TEN, CLUBS,9),
//          new Card(JACK, CLUBS,10),
//          new Card(QUEEN, CLUBS,11),
//          new Card(KING, CLUBS,12),
//          new Card(ACE, CLUBS,13)
//  ));

  private ArrayList<Card> playDeck;

  public Deck() {

    for (Rank rank: Rank.values()) {
      for (Suit suit: Suit.values()) {
        STANDARD_DECK.add(new Card(rank.value, suit.letter, rank.order));
      }
    }

    this.playDeck = shuffleStandardDeck();
  }

  public ArrayList<Card> getPlayDeck() {
    return this.playDeck;
  }

  public void newPlayDeck() {
    this.playDeck = shuffleStandardDeck();
  }

  public Card drawCard(int ind) {
    Card drawnCard = playDeck.get(ind);
    playDeck.remove(ind);
    return drawnCard;
  }

  public ArrayList<Card> shuffleStandardDeck() {
    // TODO: use Collections.shuffle() instead
    ArrayList<Card> newDeck = new ArrayList<>();
    ArrayList<String> usedCards = new ArrayList<>();
    for (int i = 0; SIZE > i; i++) {
      boolean isUsed = true;
      while (isUsed) {
        int random = (int)(Math.random() * SIZE);
        String pickedCard = STANDARD_DECK.get(random).toString();
        if (!usedCards.contains(pickedCard)) {
          newDeck.add(STANDARD_DECK.get(random));
          usedCards.add(pickedCard);
          isUsed = false;
        }
      }
    }
    return newDeck;
  }

  public String printStandardDeck() {
    StringBuilder out = new StringBuilder();
    for (Card card : STANDARD_DECK) {
      out.append(card.toString());
    }
    return out.toString();
  }

  public String toString() {
    StringBuilder out = new StringBuilder();
    for (Card card : playDeck) {
      out.append(card.toString());
    }
    return out.toString();
  }
}