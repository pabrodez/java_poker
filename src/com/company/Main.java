package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
      Deck deck = new Deck();
      Game game = new Game(deck);

      game.playRound();

    }

}
