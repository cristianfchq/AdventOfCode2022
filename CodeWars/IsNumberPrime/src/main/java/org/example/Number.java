package org.example;

public class Number {

  private int number;

  public Number() {
  }

  public Number(final int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(final int number) {
    this.number = number;
  }

  public boolean isPrime() {
    int count = 0;
    if (isGreaterThanOne()) {
      for (int i = 1; i <= number; i++) {
        System.out.println(i);
        if (number % i == 0) {
          count++;
        }
      }
      if (count == 2) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public boolean isPrime2() {
    int nSquared = (int)Math.sqrt(number);
    if (isGreaterThanOne()) {
      for (int i = 2; i <= nSquared; i++) {
        if (number % i == 0) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  public boolean isPrime3() {
    if (number <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  public boolean isPrime4() {
    return number > 1 && java.math.BigInteger.valueOf(number).isProbablePrime(20);
  }

  public boolean isGreaterThanOne() {
    return (number > 1) ? true : false;
  }
}
