import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringHandlerTest {

  @Test
  public void getSizeOfStringTest() {
    int actual = StringHandler.getSizeOfString("hello");
    int expected = 5;
    assertEquals(expected, actual);
  }

  @Test
  public void getAsciiValueTest() {
    int actual = StringHandler.getAsciiValue('a');
    int expected = 97;
    assertEquals(expected, actual);
  }

  @Test
  public void getValueLowerCaseTest() {
    int asciiValue = StringHandler.getAsciiValue('a');
    int actual = StringHandler.getValueLowerCase(asciiValue);
    int expected = 1;
    assertEquals(expected, actual);
  }

  @Test
  public void getValueUpperCaseTest() {
    int asciiValue = StringHandler.getAsciiValue('A');
    int actual = StringHandler.getValueUpperCase(asciiValue);
    int expected = 27;
    assertEquals(expected, actual);
  }
}