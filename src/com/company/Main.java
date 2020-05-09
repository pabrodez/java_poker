package com.company;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: implement Stream.reduce()
//  https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html

// https://www.pokerstars.uk/poker/games/rules/hand-rankings/?no_redirect=1

public class Main {

    public static void main(String[] args) {
        Deck theDeck = new Deck();

        // input player's info
        Player[] playersArray = new Player[2];
        Scanner userInput = new Scanner(System.in);
//        for (int i=0; i < playersArray.length; i++) {
//            String name;
//            int chips;
//
//            System.out.println("Enter player" +  (i + 1) + "'s data");
//            System.out.println("Name:");
//            name = userInput.next();
//
//            System.out.println("Chips:");
//            chips = userInput.nextInt();
//
//            playersArray[i] = new Player(name, "BB", chips);
//
//            System.out.println(playersArray[i].toString());
//        }


        // TODO: finish win and draw logic
        playersArray[0] = new Player("aa", "bb", 44);
        playersArray[1] = new Player("bb", "sb", 100);

        Game newGame = new Game(playersArray);
        newGame.giveCards();
        System.out.println(playersArray[0].printHand() + "\n" +
                playersArray[1].printHand());

        for (Player player : playersArray) {
            Card[] hand = player.getHand();
            player.setHandScore(0);
            if (newGame.hasPair(hand)) player.setHandScore(1);
            if (newGame.hasTwoPair(hand)) player.setHandScore(2);
            if (newGame.hasThree(hand)) player.setHandScore(3);
            if (newGame.hasStraight(hand)) player.setHandScore(4);
            if (newGame.hasFlush(hand)) player.setHandScore(5);
            if (newGame.hasFullHouse(hand)) player.setHandScore(6);
            if (newGame.hasQuads(hand)) player.setHandScore(7);
            if (newGame.hasStraightFlush(hand)) player.setHandScore(8);
        }
        // find max score
        int maxHand = Arrays
    }
}
