package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class NumberTest {

  @Test
  void testGetNumber() {
    Number number = new Number(10);
    assertEquals(10, number.getNumber());
  }

  @Test
  public void testBasic() {
    Number number = new Number();
    assertFalse(number.isPrime2(0), "0  is not prime");
    assertFalse(number.isPrime2(1), "1  is not prime");
    assertTrue(number.isPrime2(2), "2  is prime");
    assertTrue(number.isPrime2(73), "73 is prime");
    assertFalse(number.isPrime2(75), "75 is not prime");
    assertFalse(number.isPrime2(-1), "-1 is not prime");
  }

  @Test
  public void testPrime() {
    Number number = new Number();
    assertTrue(number.isPrime2(3), "3 is prime");
    assertTrue(number.isPrime2(5), "5 is prime");
    assertTrue(number.isPrime2(7), "7 is prime");
    assertTrue(number.isPrime2(41), "41 is prime");
    assertTrue(number.isPrime2(5099), "5099 is prime");
  }

  @Test
  public void testNotPrime() {
    Number number = new Number();
    assertFalse(number.isPrime2(4), "4 is not prime");
    assertFalse(number.isPrime2(6), "6 is not prime");
    assertFalse(number.isPrime2(8), "8 is not prime");
    assertFalse(number.isPrime2(9), "9 is not prime");
    assertFalse(number.isPrime2(45), "45 is not prime");
    assertFalse(number.isPrime2(-5), "-5 is not prime");
    assertFalse(number.isPrime2(-8), "-8 is not prime");
    assertFalse(number.isPrime2(-41), "-41 is not prime");
  }
}
