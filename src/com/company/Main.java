package com.company;
import java.util.ArrayList;
import java.util.Arrays;
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


        playersArray[0] = new Player("first", "bb", 44);
        playersArray[1] = new Player("second", "sb", 100);

        Game newGame = new Game(playersArray);
        newGame.giveCards();
        System.out.println(playersArray[0].printHand() + "\n" +
                playersArray[1].printHand());

        System.out.println(newGame.findHandScore(playersArray[0]));
        System.out.println(newGame.findHandScore(playersArray[1]));
        System.out.println(newGame.findHighestScore(playersArray));
        System.out.println(newGame.findWinner(playersArray));

    }
}
