public class StringHandler {

  public static int getSizeOfString(final String stringValue) {
    return stringValue.length();
  }

  public static int getAsciiValue(final char value) {
    int ascii = (int)value;
    return ascii;
  }

  public static int getValueLowerCase(final int value) {
    return value - 96;
  }

  public static int getValueUpperCase(final int value) {
    return value - 38;
  }
}
