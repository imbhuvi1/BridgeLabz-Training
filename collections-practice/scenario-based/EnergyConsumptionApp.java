package scenario_based;

import java.util.*;

//Custom Exception
class InvalidEnergyReadingException extends Exception {
 public InvalidEnergyReadingException(String msg) {
     super(msg);
 }
}

//EnergyMonitor class
class EnergyMonitor {

 private Map<Date, List<Double>> usageData = new HashMap<>();

 public void addReading(Date date, double reading) throws InvalidEnergyReadingException {
     if (reading < 0) {
         throw new InvalidEnergyReadingException("Energy reading cannot be negative");
     }

     usageData.computeIfAbsent(date, d -> new ArrayList<>()).add(reading);
 }

 public void dailyAverage(Date date) {
     List<Double> readings = usageData.get(date);
     if (readings != null) {
         double avg = readings.stream().mapToDouble(Double::doubleValue).average().orElse(0);
         System.out.println("Daily Average: " + avg);
     }
 }

 public void monthlyAverage() {
     double avg = usageData.values().stream()
             .flatMap(List::stream)
             .mapToDouble(Double::doubleValue)
             .average()
             .orElse(0);

     System.out.println("Monthly Average: " + avg);
 }
}

//Main class
public class EnergyConsumptionApp {
 public static void main(String[] args) {

     EnergyMonitor monitor = new EnergyMonitor();
     Date today = new Date();

     try {
         monitor.addReading(today, 5.2);
         monitor.addReading(today, 6.1);
         monitor.addReading(today, -2.0); // Invalid
     } catch (InvalidEnergyReadingException e) {
         System.out.println(e.getMessage());
     }

     monitor.dailyAverage(today);
     monitor.monthlyAverage();
 }
}

