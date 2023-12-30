package Software.Ulpgc.Kata3;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ComputerLoader loader = new TsvFileComputerLoader(new File("laptops_train.txt"));
        List<Computer> computers = loader.load();
        Map<String, Integer> chart = new HashMap<>();
        double[] prices = new double[1000];
        int i = 0;
        for (Computer computer:computers) {
            prices[i++] = Double.valueOf(computer.getPrice())*0.000108;
            String manufacturer = computer.getManufacturer();
            chart.put(manufacturer, chart.getOrDefault(manufacturer, 0)+1);
        }
        for (String key : chart.keySet()) {
            System.out.println(key + " : " + chart.get(key));
        }

        Histogram histogram = new Histogram("Prices of computers", "Prices in euros", "y", prices, 5);
        MainFrame frame = new MainFrame();
        frame.histogramDisplay().show(histogram);
        frame.setVisible(true);
    }
}