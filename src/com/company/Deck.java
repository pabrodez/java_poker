package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.Collections;
import java.util.Random;

public class Deck {

  private enum Suit {
    SPADES("s"),
    HEARTS("h"),
    DIAMONDS("d"),
    CLUBS("c");

    public final String suit;

    Suit(String suit) {
      this.suit = suit;
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

  private ArrayList<Card> playDeck = new ArrayList<>();

  public Deck() {
    resetDeck();
    shuffleDeck();
  }

  public ArrayList<Card> getPlayDeck() {
    return this.playDeck;
  }

  public Card drawCard() {
    Random random = new Random();
    int randomIndex = random.nextInt(playDeck.size());
    Card drawnCard = playDeck.get(randomIndex);
    playDeck.remove(drawnCard);
    return drawnCard;
  }

  public void resetDeck() {
    playDeck.clear();
    for (Rank rank: Rank.values()) {
      for (Suit suit: Suit.values()) {
        playDeck.add(new Card(rank.value, suit.suit, rank.order));
      }
    }
  }

  public void shuffleDeck() {
    Collections.shuffle(playDeck);
  }

  public String toString() {
    StringBuilder out = new StringBuilder();
    for (Card card : playDeck) {
      out.append(card.toString());
    }
    return out.toString();
  }
}