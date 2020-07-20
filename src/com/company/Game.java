package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.StringBuilder;

public class Game {

  private ArrayList<Hand> hands;
  private Deck playDeck;
  private Scanner input;

  Game(Deck deck, Scanner input) {
    this.playDeck = deck;
    this.input = input;
    this.hands = new ArrayList<>(2);
    // initially empty hands
    hands.add(new Hand());
    hands.add(new Hand());
  }

  public void clearHands() {
    for (Hand hand : hands) {
      hand.clearCards();
    }
  }

  public void giveCards() {
    for (Hand hand : hands) {
      hand.setCards(playDeck.drawCard(), playDeck.drawCard(), playDeck.drawCard(),
              playDeck.drawCard(), playDeck.drawCard());
    }
  }

  public Hand findWinningHand() {
    // dummy always-losing hand to use as initial element in reduce
    Hand identity = new Hand();
    identity.setCards(
            new Card("a", "s",-10),
            new Card("a", "d",-20),
            new Card("a", "s",-30),
            new Card("a", "c",-40),
            new Card("a", "s",-50)
    );

    Hand winningHand = hands.stream()
            .reduce(identity, (prev, curr) -> curr.compareTo(prev) > 0 ? curr : prev);

    return winningHand;
  }

  public void changeCards() {
    for (int i=0; i < hands.size(); i++) {
      System.out.printf("Hand %d, enter indexes of cards to change (eg: 245):", i + 1);
      String input = this.input.nextLine();
      // convert to array of integers
      int[] indexes = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
      // replace the cards at the provided indexes
      for (int ind : indexes) {
        hands.get(i).replaceCardAtIndex(ind - 1, playDeck.drawCard());
      }
      Collections.sort(hands.get(i).getCards());
    }
  }

  public void printHands() {
    for (Hand hand : hands) {
      System.out.println(hand.toString());
    }
  }

  public void playRound() {
    giveCards();
    printHands();
    changeCards();
    printHands();
    Hand winningHand = findWinningHand();
    System.out.println("Winning hand is: " + winningHand.toString() + " with " + winningHand.getCategoryString());
    clearHands();
    playDeck.resetDeck();
    playDeck.shuffleDeck();
  }

}
