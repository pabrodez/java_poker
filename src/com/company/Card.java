package com.company;

public class Card implements Comparable<Card>{
  private String value;
  private String suit;
  private int order;

  public Card(String value, String suit, int order) {
    this.value = value;
    this.suit = suit;
    this.order = order;
  }

  public String getSuit() {
    return suit;
  }

  public int getOrder() {
    return order;
  }

  @Override
  public String toString() {
    return this.value + this.suit;
  }

  @Override
  public int compareTo(Card y) {
    return this.getOrder() - y.getOrder();
  }
}
