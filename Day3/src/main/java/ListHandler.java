import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListHandler {

  public static List<Integer> getListOfCommonItems(final List<Integer> listOne,
      final List<Integer> listTwo) {
    return listOne.stream()
        .filter(item -> listTwo.contains(item)).collect(Collectors.toList());
  }

  public static List<Integer> getListOfCommonItemsThreeList(final List<Integer> listOne,
      final List<Integer> listTwo, final List<Integer> listThree) {
    List<Integer> listOfCommonItemsTwoList = listOne.stream().filter(item -> listTwo.contains(item))
        .collect(Collectors.toList());
    return listThree.stream().filter(item -> listOfCommonItemsTwoList.contains(item))
        .collect(Collectors.toList());
  }

  public static List<Integer> joinTwoList(final List<Integer> listOne, final List<Integer> listTwo) {
    LinkedList<Integer> merged = new LinkedList<>();
    merged.addAll(listOne);
    merged.addAll(listTwo);
    return merged;
  }

}
