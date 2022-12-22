import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Advent Of Code");
        System.out.println("--Day 2--");

        List<String> allValues = TxtHandler.getDataValues();
        allValues.forEach(System.out::println);

        List<List<Integer>> allNewDataValues = TxtHandler.getNewDataValues(allValues);
        allNewDataValues.forEach(System.out::println);

        System.out.println("------------------------");

        int totalDraw = TxtHandler.getTotalResultGivenStatusResult(allNewDataValues, "Draw");
        System.out.println("total draw -> " + totalDraw);

        int totalLost = TxtHandler.getTotalResultGivenStatusResult(allNewDataValues, "Lost");
        System.out.println("total lost -> " + totalLost);

        int totalWin = TxtHandler.getTotalResultGivenStatusResult(allNewDataValues, "Won");
        System.out.println("total won -> " + totalWin);

        int totalPoints = totalDraw + totalLost + totalWin;
        System.out.println("---- Part One");
        System.out.println("Total Point -> " + totalPoints);

        System.out.println("----------------------");
        System.out.println("----------------------");

        int totalToDraw = TxtHandler.getPredictToDraw(allNewDataValues, "Draw");
        System.out.println("Total to predict Draw -> " + totalToDraw);

        int totalToLost = TxtHandler.getPredictToLost(allNewDataValues, "Lost");
        System.out.println("Total to predict Lost -> " + totalToLost);

        int totalToWin = TxtHandler.getPredictToWin(allNewDataValues, "Win");
        System.out.println("Total to predict Win -> " + totalToWin);

        int totalToPredict = totalToDraw + totalToLost + totalToWin;
        System.out.println("---- Part Two");
        System.out.println("Total Point To Predict -> " + totalToPredict);



    }

}
