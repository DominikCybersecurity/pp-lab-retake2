import java.util.*;

public class Main {
    public static void main(String[] args) {
        StatisticsManager manager = new StatisticsManager();
        manager.addDataSet(new DataSet("Zbiór 1"));
        manager.addDataSet(new DataSet("Zbiór 2"));
        manager.addDataSet(new DataSet("Zbiór 3"));
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); 
        
        while (true) {
            System.out.println("1. Dodaj nowy zbiór danych\n2. Usuń istniejący zbiór danych\n3. Dodaj dane do zbioru\n4. Usuń dane ze zbioru\n5. Wyświetl dane zbioru\n6. Oblicz średnią\n7. Oblicz medianę\n8. Oblicz odchylenie\n9. Wyjście");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 9) break;

            System.out.print("Podaj nazwę zbioru danych: ");
            String name = scanner.nextLine();
            DataSet dataSet = manager.findDataSetByName(name);

            try {
                switch (choice) {
                    case 1:
                        manager.addDataSet(new DataSet(name));
                        break;
                    case 2:
                        manager.removeDataSet(name);
                        break;
                    case 3:
                        if (dataSet != null) {
                            System.out.print("Podaj liczbę do dodania: ");
                            double numberToAdd = scanner.nextDouble();
                            scanner.nextLine();
                            manager.addNumberToDataSet(name, numberToAdd);
                        } else {
                            System.out.println("Zbiór danych nie istnieje.");
                        }
                        break;
                    case 4:
                        if (dataSet != null) {
                            System.out.print("Podaj liczbę do usunięcia: ");
                            double numberToRemove = scanner.nextDouble();
                            scanner.nextLine(); 
                            manager.removeNumberFromDataSet(name, numberToRemove);
                        } else {
                            System.out.println("Zbiór danych nie istnieje.");
                        }
                        break;
                    case 5:
                        if (dataSet != null) {
                            manager.displayDataSet(name);
                        } else {
                            System.out.println("Zbiór danych nie istnieje.");
                        }
                        break;
                    case 6:
                        if (dataSet != null) {
                            System.out.println("Średnia: " + manager.calculateMean(dataSet));
                        } else {
                            System.out.println("Zbiór danych nie istnieje.");
                        }
                        break;
                    case 7:
                        if (dataSet != null) {
                            System.out.println("Mediana: " + manager.calculateMedian(dataSet));
                        } else {
                            System.out.println("Zbiór danych nie istnieje.");
                        }
                        break;
                    case 8:
                        if (dataSet != null) {
                            System.out.println("Odchylenie standardowe: " + manager.calculateStandardDeviation(dataSet));
                        } else {
                            System.out.println("Zbiór danych nie istnieje.");
                        }
                        break;
                    default:
                        System.out.println("Nieprawidłowy wybór.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Nieprawidłowy format liczby. Użyj kropki jako separatora dziesiętnego.");
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }
}
