import java.util.*;

public class StatisticsManager implements StatisticsOperations {
    private List<DataSet> dataSets = new ArrayList<>();

    public StatisticsManager() {
    
        
        dataSets.add(new DataSet("Zbiór 1"));
        dataSets.add(new DataSet("Zbiór 2"));
        dataSets.add(new DataSet("Zbiór 3"));
    }

    public void addDataSet(DataSet dataSet) { dataSets.add(dataSet); }
    public void removeDataSet(String name) { dataSets.removeIf(dataSet -> dataSet.getName().equals(name)); }
    public DataSet findDataSetByName(String name) { return dataSets.stream().filter(dataSet -> dataSet.getName().equals(name)).findFirst().orElse(null); }
    public void addNumberToDataSet(String name, double number) { findDataSetByName(name).addNumber(number); }
    public void removeNumberFromDataSet(String name, double number) { findDataSetByName(name).removeNumber(number); }
    public void displayDataSet(String name) { System.out.println(findDataSetByName(name)); }

    @Override
    public double calculateMean(DataSet dataSet) {
        return dataSet.getData().stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    @Override
    public double calculateMedian(DataSet dataSet) {
        List<Double> data = new ArrayList<>(dataSet.getData());
        Collections.sort(data);
        int middle = data.size() / 2;
        return data.size() % 2 == 0 ? (data.get(middle - 1) + data.get(middle)) / 2.0 : data.get(middle);
    }

    @Override
    public double calculateStandardDeviation(DataSet dataSet) {
        double mean = calculateMean(dataSet);
        return Math.sqrt(dataSet.getData().stream().mapToDouble(num -> Math.pow(num - mean, 2)).sum() / dataSet.getData().size());
    }
}
