package com.company;

import static org.junit.jupiter.api.Assertions.*;
import org.testng.annotations.AfterTest;

public class PlayerTest {

  @org.junit.jupiter.api.Test
  public void getWins() {
    Player player = new Player("test", "BB", 0);
    assertEquals(0, player.getWins());
  }
}