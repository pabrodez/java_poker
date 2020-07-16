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

  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }

  public String getSuit() {
    return suit;
  }
  public void setSuit(String suit) {
    this.suit = suit;
  }

  public int getOrder() {
    return order;
  }
  public void setOrder(int order) {
    this.order = order;
  }

  public String toString() {
    return value + suit + order;
  }

  @Override
  public int compareTo(Card y) {
    return this.getOrder() - y.getOrder();
  }
}
