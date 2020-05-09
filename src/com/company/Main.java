package com.company;
import java.util.Scanner;

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

        // TODO: start Game(Player[] players)
        playersArray[0] = new Player("aa", "bb", 44);
        playersArray[1] = new Player("bb", "sb", 100);
        Game newGame = new Game(playersArray);
        newGame.giveCards();
        System.out.println(playersArray[0].printHand() + "\n" +
                playersArray[1].printHand()
        );
        System.out.println(newGame.getHighCard(
                playersArray[0].getHand())[0].toString() + "\n" +
                newGame.getHighCard(playersArray[1].getHand())[0].toString()
        );
        System.out.println(
                newGame.hasPair(playersArray[0].getHand()) + "\n" +
                newGame.hasPair(playersArray[1].getHand())
        );
        System.out.println(
                newGame.hasFlush(new Card[]{
                        new Card("2", "s", 1),
                        new Card("3", "s", 2),
                        new Card("4", "s", 1),
                        new Card("2", "s", 1),
                        new Card("2", "s", 1)}) + "\n" +
                        newGame.hasThree(playersArray[1].getHand())
        );


    }
}
