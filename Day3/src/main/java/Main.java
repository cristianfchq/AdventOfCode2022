import java.io.IOException;
import java.util.List;


public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Advent of code");
    System.out.println("--Day 3--");

    TxtHandler txtHandler = new TxtHandler();

    List<String> allValues = TxtHandler.getDataValues();
    allValues.forEach(System.out::println);

    List<Integer> allSizeValues = TxtHandler.getSizeValues(allValues);
    allSizeValues.forEach(System.out::println);

    System.out.println("--------------------");
    List<List<Character>> allFirstCompartment = TxtHandler
        .getAllFirstCompartment(allValues, allSizeValues);
    allFirstCompartment.forEach(System.out::println);

    System.out.println("--------------------");
    List<List<Character>> allSecondCompartment = TxtHandler
        .getAllSecondCompartment(allValues, allSizeValues);
    allSecondCompartment.forEach(System.out::println);

    System.out.println("--------------------");
    List<List<Integer>> allFirstCompartmentAsAscii = TxtHandler
        .getAllCompartmentAsAscii(allFirstCompartment);
    allFirstCompartmentAsAscii.forEach(System.out::println);

    System.out.println("--------------------");
    List<List<Integer>> allSecondCompartmentAsAscii = TxtHandler
        .getAllCompartmentAsAscii(allSecondCompartment);
    allSecondCompartmentAsAscii.forEach(System.out::println);

    System.out.println("--------------------");
    List<List<Integer>> itemInBothCompartmentsOfEachRucksack = TxtHandler
        .getItemInBothCompartment(allFirstCompartmentAsAscii, allSecondCompartmentAsAscii);
    itemInBothCompartmentsOfEachRucksack.forEach(System.out::println);

    System.out.println("--------------------");
    int totalResult = txtHandler.getTotalResultCompartment(itemInBothCompartmentsOfEachRucksack);
    System.out.println("---- Part One");
    System.out.println("Total Result -> " + totalResult);

    System.out.println("--------------------");
    List<List<Integer>> joinBothCompartmentsOfEachRucksack = TxtHandler
        .joinTwoCompartments(allFirstCompartmentAsAscii, allSecondCompartmentAsAscii);
    joinBothCompartmentsOfEachRucksack.forEach(System.out::println);

    System.out.println("--------------------");
    List<List<Integer>> commonBetweenThreeRucksack = TxtHandler
        .getCommonBetweenThreeRucksack(joinBothCompartmentsOfEachRucksack);
    commonBetweenThreeRucksack.forEach(System.out::println);

    System.out.println("--------------------");
    totalResult = txtHandler.getTotalResultCompartment(commonBetweenThreeRucksack);
    System.out.println("---- Part Two");
    System.out.println("Total Result -> " + totalResult);
  }

}
