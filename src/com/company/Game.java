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

  Game(Deck deck) {
    this.playDeck = deck;
    this.hands = new ArrayList<>(2);
    hands.add(new Hand(this.playDeck.drawCard(), this.playDeck.drawCard(), this.playDeck.drawCard(),
            this.playDeck.drawCard(), this.playDeck.drawCard()));
    hands.add(new Hand(this.playDeck.drawCard(), this.playDeck.drawCard(), this.playDeck.drawCard(),
            this.playDeck.drawCard(), this.playDeck.drawCard()));
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
    Hand identity = new Hand(
            new Card("a", "c", -10),
            new Card("a", "h", -20),
            new Card("a", "s", -30),
            new Card("a", "h", -40),
            new Card("a", "s", -50)
    );

    Hand winningHand = hands.stream()
            .reduce(identity, (prev, curr) -> curr.compareTo(prev) > 0 ? curr : prev);

    return winningHand;
  }

  public void changeCards() {
    Scanner scanner = new Scanner(System.in);
    for (int i=0; i < hands.size(); i++) {
      System.out.printf("Hand %d, enter indexes of cards to change (eg: 245):", i);
      String input = scanner.nextLine();
      // convert to array of integers
      int[] indexes = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
      // replace the cards at the provided indexes
      for (int ind : indexes) {
        hands.get(i).getCards().set(ind - 1, playDeck.drawCard());
      }
      Collections.sort(hands.get(i).getCards());
    }
    scanner.close();
  }

  public void playRound() {
    System.out.println(playDeck.toString());
    System.out.println(
            "Hand 1: " + hands.get(0).toString() + "\n" +
            "Hand 2: " + hands.get(1).toString()
    );
    System.out.println(
            hands.get(0).compareTo(hands.get(1))
    );
    System.out.println(findWinningHand().toString());

    changeCards();

    System.out.println(findWinningHand().toString());

    playDeck.resetDeck();
    playDeck.shuffleDeck();
  }

}
