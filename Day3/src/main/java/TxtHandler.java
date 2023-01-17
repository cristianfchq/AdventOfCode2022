import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtHandler {

  static File file = new File("src/main/resources/dataSet/dataSet1_2.txt");
  private static BufferedReader br;
  private static String st;

  public TxtHandler() {
  }

  public static List<String> getDataValues() throws IOException {
    instanceTxtReader();
    List<String> values = new ArrayList<String>();
    while ((st = br.readLine()) != null) {
      values.add(st);
    }
    return values;
  }

  private static void instanceTxtReader() throws FileNotFoundException {
    br = new BufferedReader(new FileReader(file));
  }

  public static List<Integer> getSizeValues(final List<String> allValues) {
    List<Integer> values = new ArrayList<Integer>();
    for (int i = 0; i < allValues.size(); i++) {
      values.add(StringHandler.getSizeOfString(allValues.get(i)));
    }
    return values;
  }

  public static List<List<Character>> getAllFirstCompartment(final List<String> allValues,
      final List<Integer> allSizeValues) {
    char value = ' ';
    int size = 0;
    List<List<Character>> allFirstCompartment = new ArrayList<List<Character>>();
    for (int i = 0; i < allValues.size(); i++) {
      List<Character> firstCompartment = new ArrayList<>();
      size = allSizeValues.get(i);
      for (int j = 0; j < size / 2; j++) {
        firstCompartment.add(allValues.get(i).charAt(j));
      }
      allFirstCompartment.add(firstCompartment);
    }
    return allFirstCompartment;
  }

  public static List<List<Character>> getAllSecondCompartment(final List<String> allValues,
      final List<Integer> allSizeValues) {
    char value = ' ';
    int size = 0;
    List<List<Character>> allSecondCompartment = new ArrayList<List<Character>>();
    for (int i = 0; i < allValues.size(); i++) {
      List<Character> secondCompartment = new ArrayList<>();
      size = allSizeValues.get(i);
      for (int j = size / 2; j < size; j++) {
        secondCompartment.add(allValues.get(i).charAt(j));
      }
      allSecondCompartment.add(secondCompartment);
    }
    return allSecondCompartment;
  }

  public static List<List<Integer>> getAllCompartmentAsAscii(
      final List<List<Character>> allCompartment) {
    char value = ' ';
    int size = 0;
    List<List<Integer>> allCompartmentAsAscii = new ArrayList<List<Integer>>();
    for (int i = 0; i < allCompartment.size(); i++) {
      List<Integer> compartmentAsAscii = new ArrayList<>();
      for (int j = 0; j < allCompartment.get(i).size(); j++) {
        value = allCompartment.get(i).get(j);
        int asciiValue = StringHandler.getAsciiValue(value);
        int realValue = 0;
        if (asciiValue >= 97 && asciiValue <= 122) {
          realValue = StringHandler.getValueLowerCase(asciiValue);
        }
        if (asciiValue >= 65 && asciiValue <= 90) {
          realValue = StringHandler.getValueUpperCase(asciiValue);
        }
        compartmentAsAscii.add(realValue);
      }
      allCompartmentAsAscii.add(compartmentAsAscii);
    }
    return allCompartmentAsAscii;
  }

  public static List<List<Integer>> getItemInBothCompartment(
      final List<List<Integer>> allFirstCompartmentAsAscii,
      final List<List<Integer>> allSecondCompartmentAsAscii) {
    List<List<Integer>> values = new ArrayList<List<Integer>>();
    for (int i = 0; i < allFirstCompartmentAsAscii.size(); i++) {
      List<Integer> listOne = allFirstCompartmentAsAscii.get(i);
      List<Integer> listTwo = allSecondCompartmentAsAscii.get(i);
      List<Integer> listOfCommonItems = ListHandler.getListOfCommonItems(listOne, listTwo);
      values.add(listOfCommonItems);
    }
    return values;
  }

  public static List<List<Integer>> joinTwoCompartments(final List<List<Integer>> firstCompartment,
      final List<List<Integer>> secondCompartment) {
    List<List<Integer>> rucksacks = new ArrayList<List<Integer>>();
    for (int i = 0; i < firstCompartment.size(); i++) {
      rucksacks.add(ListHandler.joinTwoList(firstCompartment.get(i), secondCompartment.get(i)));
    }
    return rucksacks;
  }

  public static List<List<Integer>> getCommonBetweenThreeRucksack(
      final List<List<Integer>> rucksacks) {
    List<List<Integer>> values = new ArrayList<List<Integer>>();
    for (int i = 0; i < rucksacks.size(); i = i + 3) {
      List<Integer> listOfCommonItems = ListHandler
          .getListOfCommonItemsThreeList(rucksacks.get(i), rucksacks.get(i + 1),
              rucksacks.get(i + 2));
      values.add(listOfCommonItems);
    }
    return values;
  }

  public int getTotalResultCompartment(
      List<List<Integer>> itemInBothCompartmentsOfEachRucksack) {
    int total = 0;
    for (int i = 0; i < itemInBothCompartmentsOfEachRucksack.size(); i++) {
      total = total + itemInBothCompartmentsOfEachRucksack.get(i).get(0);
    }
    return total;
  }
}
