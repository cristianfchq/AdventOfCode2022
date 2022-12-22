import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class TxtHandler {

    final static Map<String, Integer> rockPaperScissors = Map.of(
            "A", 10,
            "B", 20,
            "C", 30,
            "X", 1,
            "Y", 2,
            "Z", 3);

    final static Map<String, List<Integer>> lostDrawWon = Map.of(
            "Draw", Arrays.asList(11, 22, 33),
            "Lost", Arrays.asList(13, 21, 32),
            "Won", Arrays.asList(12, 23, 31)
    );

    final static Map<String, List<Integer>> predictLostDrawWon = Map.of(
            "Draw", Arrays.asList(12, 22, 32),
            "Lost", Arrays.asList(11, 21, 31),
            "Win", Arrays.asList(13, 23, 33)
    );

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

    public static List<List<Integer>> getNewDataValues(final List<String> values) throws IOException {
        List<List<Integer>> newDataValues = new ArrayList<List<Integer>>();
        for (int i = 0; i < values.size(); i++) {
            String[] players = values.get(i).split(" ");
            List<Integer> strategyGuide = new ArrayList<>();
            strategyGuide.add(rockPaperScissors.get(players[0]));
            strategyGuide.add(rockPaperScissors.get(players[1]));
            newDataValues.add(strategyGuide);
        }
        return newDataValues;
    }

    public static int getTotalResultGivenStatusResult(final List<List<Integer>> valuesFirstSecondPlayer, final String statusResult) {
        List<Integer> valuesResult = lostDrawWon.get(statusResult);
        int status = "Lost".equals(statusResult) ? 0 : "Draw".equals(statusResult) ? 3 : 6;
        int pointTotal = 0;
        for (int i = 0; i < valuesFirstSecondPlayer.size(); i++) {
            int aux = valuesFirstSecondPlayer.get(i).get(0) + valuesFirstSecondPlayer.get(i).get(1);
            if (aux == valuesResult.get(0) || aux == valuesResult.get(1) || aux == valuesResult.get(2)) {
                pointTotal = pointTotal + valuesFirstSecondPlayer.get(i).get(1) + status;
            }
        }
        return pointTotal;
    }

    public static int getTotalDraw(final List<List<Integer>> valuesFirstSecondPlayer) {
        int draw = 3;
        int pointTotalDraw = 0;
//        valuesFirstSecondPlayer.forEach((row) -> {
//            int aux = row.get(0) + row.get(1);
//            if (aux == 7) {
//                pointTotalDraw = row.get(1) + draw;
//            }
//        });
        for (int i = 0; i < valuesFirstSecondPlayer.size(); i++) {
            int aux = valuesFirstSecondPlayer.get(i).get(0) + valuesFirstSecondPlayer.get(i).get(1);
            if (aux == 11 || aux == 22 || aux == 33) {
                pointTotalDraw = pointTotalDraw + valuesFirstSecondPlayer.get(i).get(1) + draw;
            }
        }
        return pointTotalDraw;
    }

    public static int getTotalLost(final List<List<Integer>> valuesFirstSecondPlayer) {
        int lost = 0;
        int pointTotalLost = 0;
        for (int i = 0; i < valuesFirstSecondPlayer.size(); i++) {
            int aux = valuesFirstSecondPlayer.get(i).get(0) + valuesFirstSecondPlayer.get(i).get(1);
            if (aux == 13 || aux == 21 || aux == 32) {
                pointTotalLost = pointTotalLost + valuesFirstSecondPlayer.get(i).get(1) + lost;
            }
        }
        return pointTotalLost;
    }

    public static int getTotalWon(final List<List<Integer>> valuesFirstSecondPlayer) {
        int win = 6;
        int pointTotalWin = 0;
        for (int i = 0; i < valuesFirstSecondPlayer.size(); i++) {
            int aux = valuesFirstSecondPlayer.get(i).get(0) + valuesFirstSecondPlayer.get(i).get(1);
            if (aux == 12 || aux == 23 || aux == 31) {
                pointTotalWin = pointTotalWin + valuesFirstSecondPlayer.get(i).get(1) + win;
            }
        }
        return pointTotalWin;
    }

    public static int getPredictToDraw(final List<List<Integer>> valuesFirstSecondPlayer, final String statusResult) {
        List<Integer> valuesResult = predictLostDrawWon.get(statusResult);
        int status = "Lost".equals(statusResult) ? 0 : "Draw".equals(statusResult) ? 3 : 6;
        int pointTotalToDraw = 0;
        for (int i = 0; i < valuesFirstSecondPlayer.size(); i++) {
            int aux = valuesFirstSecondPlayer.get(i).get(0) + valuesFirstSecondPlayer.get(i).get(1);
            if (aux == valuesResult.get(0))
                pointTotalToDraw = pointTotalToDraw + status + 1;
            if (aux == valuesResult.get(1))
                pointTotalToDraw = pointTotalToDraw + status + 2;
            if (aux == valuesResult.get(2))
                pointTotalToDraw = pointTotalToDraw + status + 3;
        }
        return pointTotalToDraw;
    }

    public static int getPredictToLost(final List<List<Integer>> valuesFirstSecondPlayer, final String statusResult) {
        List<Integer> valuesResult = predictLostDrawWon.get(statusResult);
        int status = "Lost".equals(statusResult) ? 0 : "Draw".equals(statusResult) ? 3 : 6;
        int pointTotalToLost = 0;
        for (int i = 0; i < valuesFirstSecondPlayer.size(); i++) {
            int aux = valuesFirstSecondPlayer.get(i).get(0) + valuesFirstSecondPlayer.get(i).get(1);
            if (aux == valuesResult.get(0))
                pointTotalToLost = pointTotalToLost + status + 3;
            if (aux == valuesResult.get(1))
                pointTotalToLost = pointTotalToLost + status + 1;
            if (aux == valuesResult.get(2))
                pointTotalToLost = pointTotalToLost + status + 2;
        }
        return pointTotalToLost;
    }

    public static int getPredictToWin(final List<List<Integer>> valuesFirstSecondPlayer, final String statusResult) {
        List<Integer> valuesResult = predictLostDrawWon.get(statusResult);
        int status = "Lost".equals(statusResult) ? 0 : "Draw".equals(statusResult) ? 3 : 6;
        int pointTotalToWin = 0;
        for (int i = 0; i < valuesFirstSecondPlayer.size(); i++) {
            int aux = valuesFirstSecondPlayer.get(i).get(0) + valuesFirstSecondPlayer.get(i).get(1);
            if (aux == valuesResult.get(0))
                pointTotalToWin = pointTotalToWin + status + 2;
            if (aux == valuesResult.get(1))
                pointTotalToWin = pointTotalToWin + status + 3;
            if (aux == valuesResult.get(2))
                pointTotalToWin = pointTotalToWin + status + 1;
        }
        return pointTotalToWin;
    }

    private static void instanceTxtReader() throws FileNotFoundException {
        br = new BufferedReader(new FileReader(file));
    }
}
