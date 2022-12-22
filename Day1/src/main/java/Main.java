import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Advent Of Code");
        System.out.println("--Day 1--");


        List<String> allValues = TxtHandler.getDataValues();
//        allValues.forEach(System.out::println);

        List<Integer> valuesBySection = TxtHandler.getTotalBySection();
//        valuesBySection.forEach(System.out::println);

        List<Integer> sortedList = valuesBySection.stream().sorted().collect(Collectors.toList());
//        sortedList.forEach(System.out::println);

        System.out.println("---- Part One");
        System.out.println(sortedList.get(sortedList.size() - 1));
        System.out.println("---- Part Two");
        System.out.println(sortedList.get(sortedList.size() - 1) + sortedList.get(sortedList.size() - 2) + sortedList.get(sortedList.size() - 3));
    }
}
