import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ListHandlerTest {

  @Test
  public void getListOfCommonItemsTest() {
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    list1.add(6);
    list1.add(5);
    List<Integer> list2 = new ArrayList<Integer>();
    list2.add(2);
    list2.add(5);
    list2.add(6);
    List<Integer> actualResult = ListHandler.getListOfCommonItems(list1, list2);
    List<Integer> expectedResult = new ArrayList<Integer>();
    expectedResult.add(6);
    expectedResult.add(5);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void getListOfCommonItemsThreeListTest() {
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    list1.add(6);
    list1.add(5);
    list1.add(5);
    List<Integer> list2 = new ArrayList<Integer>();
    list2.add(2);
    list2.add(5);
    list2.add(6);
    list2.add(7);
    list2.add(8);
    List<Integer> list3 = new ArrayList<Integer>();
    list3.add(6);
    list3.add(5);
    list3.add(1);
    List<Integer> actualResult = ListHandler.getListOfCommonItemsThreeList(list1, list2, list3);
    List<Integer> expectedResult = new ArrayList<Integer>();
    expectedResult.add(6);
    expectedResult.add(5);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void joinTwoListTest() {
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    list1.add(5);
    List<Integer> list2 = new ArrayList<Integer>();
    list2.add(2);
    list2.add(7);
    list2.add(8);
    List<Integer> actualResult = ListHandler.joinTwoList(list1, list2);
    List<Integer> expectedResult = new ArrayList<Integer>();
    expectedResult.add(1);
    expectedResult.add(5);
    expectedResult.add(2);
    expectedResult.add(7);
    expectedResult.add(8);
    assertEquals(expectedResult, actualResult);
  }
}