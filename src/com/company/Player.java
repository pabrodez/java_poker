package com.company;

import java.util.ArrayList;
import com.company.Card;

public class Player {
  private String name;
  private Card[] hand = new Card[5];
  private String blind;
  private int chips;
  private int wins = 0;
  private int handScore = 0;

  public Player(String name, String blind, int chips) {
    this.name = name;
    this.blind = blind;
    this.chips = chips;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public Card[] getHand() {
    return hand;
  }
  public void setHand(Card[] hand) {
    this.hand = hand;
  }

  public String getBlind() {
    return blind;
  }
  public void setBlind(String blind) {
    this.blind = blind;
  }

  public int getChips() {
    return chips;
  }
  public void setChips(int chips) {
    this.chips = chips;
  }

  public int getWins() {
    return wins;
  }
  public void setWins(int wins) {
    this.wins = wins;
  }

  public String printHand() {
    StringBuilder out = new StringBuilder();
    for (Card card : this.hand) { out.append(card.toString());}
    return out.toString();
  }

  public int getHandScore() {
    return handScore;
  }
  public void setHandScore(int handScore) {
    this.handScore = handScore;
  }

  public String toString() {
    return("Player name: " + getName() + "\n" +
           "blind: " + getBlind() + "\n" +
           "chips: " + getChips() + "\n" +
           "wins: " + getWins()
    );
  }
}
