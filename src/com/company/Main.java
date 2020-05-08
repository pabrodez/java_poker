package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Deck theDeck = new Deck();
        theDeck.setPlayDeck();

        // input player's info
        Player[] playersArray = new Player[2];
        Scanner userInput = new Scanner(System.in);
        for (int i=0; i < playersArray.length; i++) {
            String name;
            int chips;

            System.out.println("Enter player" +  (i + 1) + "'s data");
            System.out.println("Name:");
            name = userInput.next();

            System.out.println("Chips:");
            chips = userInput.nextInt();

            playersArray[i] = new Player(name, "BB", chips);

            System.out.println(playersArray[i].toString());
        }

        // input hoy many hands
        System.out.println("Number of hands:");
        int nHands = userInput.nextInt();

        // start Game(Player[] players) for each hand

    }
}
