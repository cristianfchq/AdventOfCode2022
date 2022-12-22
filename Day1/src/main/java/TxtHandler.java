import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TxtHandler {

    static File file = new File("src/main/resources/dataSet/dataSet1_2.txt");
    private static BufferedReader br;
    private static String st;

    public TxtHandler(){
    }

    public static List<String> getDataValues() throws IOException {
        instanceTxtReader();
        List<String> values = new ArrayList<String>();
        while((st = br.readLine()) != null) {
            values.add(st);
        }
        return values;
    }

    public static List<Integer> getTotalBySection() throws IOException {
        List<String> values = getDataValues();
        List<Integer> totalBySection = new ArrayList<Integer>();
        int total = 0;
        for (String value : values) {
            if ("".equals(value)) {
                totalBySection.add(total);
                total = 0;
            } else {
                total = total + parseInt(value);
            }
        }
        totalBySection.add(total);
        return totalBySection;
    }

    private static void instanceTxtReader() throws FileNotFoundException {
        br = new BufferedReader(new FileReader(file));
    }

    private static int getTotalSections() throws IOException {
        List<String> values = getDataValues();
        int a = 0;
        for (int i = 0; i < values.size() - 1; i++) {
            if("".equals(values.get(i+1))) {
                a++;
            }
        }
        return a + 1;
    }
}
