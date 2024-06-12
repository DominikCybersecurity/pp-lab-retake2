import java.util.*;

public class DataSet {
    private String name;
    private List<Double> data = new ArrayList<>();

    public DataSet(String name) { this.name = name; }
    public String getName() { return name; }
    public List<Double> getData() { return data; }
    public void addNumber(double number) { data.add(number); }
    public void removeNumber(double number) { data.remove(number); }
    @Override
    public String toString() { return "DataSet{name='" + name + "', data=" + data + '}'; }
}
