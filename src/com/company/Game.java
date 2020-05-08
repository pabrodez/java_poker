package com.company;

import com.company.Deck;

public class Game {
  private Player[] playersArray;
  private Deck theDeck;

  public Game(Player[] players) {
    this.playersArray = players;
    theDeck = new Deck();
  }

  public Player[] getPlayersArray() {
    return playersArray;
  }

  public void playRound() {
    theDeck.setPlayDeck();
    // give cards to players
    for (int i=0; i < playersArray.length; i++) {
      playersArray[i].setHand();
    }
  }
}
