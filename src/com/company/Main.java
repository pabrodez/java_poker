package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

      Deck deck = new Deck();
      Hand hand1 = new Hand(
              deck.drawCard(), deck.drawCard(),
              deck.drawCard(),deck.drawCard(),deck.drawCard()
      );
      Hand hand2 = new Hand(
              deck.drawCard(), deck.drawCard(),
              deck.drawCard(),deck.drawCard(),deck.drawCard()
      );

      System.out.println(hand1.toString() + "\n" + hand2.toString());
      System.out.println(hand1.compareTo(hand2));

    }

}
