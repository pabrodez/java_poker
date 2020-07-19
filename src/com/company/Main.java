package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Deck deck = new Deck();
      Game game = new Game(deck, input);

      while (true) {
        System.out.println("Press Enter to play round | exit to quit game");
        // TODO: exceptions maybe
        String option = input.nextLine();
        if (option.equals("exit")) break;
        game.playRound();
      }

      input.close();
    }

}
