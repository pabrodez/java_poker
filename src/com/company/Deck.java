package com.company;

import java.util.ArrayList;
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

  private static final Card[] STANDARD_DECK = {
          new Card(TWO, SPADES),
          new Card(THREE, SPADES),
          new Card(FOUR, SPADES),
          new Card(FIVE, SPADES),
          new Card(SIX, SPADES),
          new Card(SEVEN, SPADES),
          new Card(EIGHT, SPADES),
          new Card(NINE, SPADES),
          new Card(TEN, SPADES),
          new Card(JACK, SPADES),
          new Card(QUEEN, SPADES),
          new Card(KING, SPADES),
          new Card(ACE, SPADES),

          new Card(TWO, HEARTS),
          new Card(THREE, HEARTS),
          new Card(FOUR, HEARTS),
          new Card(FIVE, HEARTS),
          new Card(SIX, HEARTS),
          new Card(SEVEN, HEARTS),
          new Card(EIGHT, HEARTS),
          new Card(NINE, HEARTS),
          new Card(TEN, HEARTS),
          new Card(JACK, HEARTS),
          new Card(QUEEN, HEARTS),
          new Card(KING, HEARTS),
          new Card(ACE, HEARTS),

          new Card(TWO, DIAMONDS),
          new Card(THREE, DIAMONDS),
          new Card(FOUR, DIAMONDS),
          new Card(FIVE, DIAMONDS),
          new Card(SIX, DIAMONDS),
          new Card(SEVEN, DIAMONDS),
          new Card(EIGHT, DIAMONDS),
          new Card(NINE, DIAMONDS),
          new Card(TEN, DIAMONDS),
          new Card(JACK, DIAMONDS),
          new Card(QUEEN, DIAMONDS),
          new Card(KING, DIAMONDS),
          new Card(ACE, DIAMONDS),

          new Card(TWO, CLUBS),
          new Card(THREE, CLUBS),
          new Card(FOUR, CLUBS),
          new Card(FIVE, CLUBS),
          new Card(SIX, CLUBS),
          new Card(SEVEN, CLUBS),
          new Card(EIGHT, CLUBS),
          new Card(NINE, CLUBS),
          new Card(TEN, CLUBS),
          new Card(JACK, CLUBS),
          new Card(QUEEN, CLUBS),
          new Card(KING, CLUBS),
          new Card(ACE, CLUBS),
  };

  private Card[] playDeck;

  public Deck() {
    this.playDeck = new Card[SIZE];
  }

  public Card[] getPlayDeck() {
    return this.playDeck;
  }

  public void setPlayDeck() {
    this.playDeck = shuffleStandardDeck();
  }

  public Card[] shuffleStandardDeck() {
    Card[] newDeck = new Card[SIZE];
    ArrayList<String> usedCards = new ArrayList<>();
    for (int i = 0; i < newDeck.length; i++) {
      boolean isUsed = true;
      while (isUsed) {
        int random = (int) (Math.random() * SIZE);
        String pickedCard = STANDARD_DECK[random].toString();
        if (!usedCards.contains(pickedCard)) {
          newDeck[i] = STANDARD_DECK[random];
          usedCards.add(pickedCard);
          isUsed = false;
        }
      }
    }
    return newDeck;
  }

  public static String printStandardDeck() {
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