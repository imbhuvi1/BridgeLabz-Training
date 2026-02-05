package scenario_based;

import java.util.*;

//Custom exception
class NoAgentAvailableException extends Exception {
 public NoAgentAvailableException(String msg) {
     super(msg);
 }
}

class Order {
 private String id;
 private double lat, lon;
 
 public Order(String id, double lat, double lon) {
     this.id = id;
     this.lat = lat;
     this.lon = lon;
 }
 
 public String getId() { return id; }
 public double getLat() { return lat; }
 public double getLon() { return lon; }
}

class Agent {
 private String id;
 private double lat, lon;
 private boolean available = true;
 
 public Agent(String id, double lat, double lon) {
     this.id = id;
     this.lat = lat;
     this.lon = lon;
 }
 
 public String getId() { return id; }
 public double getLat() { return lat; }
 public double getLon() { return lon; }
 public boolean isAvailable() { return available; }
 public void setAvailable(boolean avail) { available = avail; }
}

class DeliveryService {
 private Queue<Order> orders = new LinkedList<>();
 private List<Agent> agents = new ArrayList<>();
 private List<Order> activeDeliveries = new ArrayList<>();
 
 public void addAgent(Agent agent) {
     agents.add(agent);
 }
 
 public void addOrder(Order order) {
     orders.add(order);
 }
 
 public void assignOrder() throws NoAgentAvailableException {
     if (orders.isEmpty()) return;
     
     Order order = orders.poll();
     Agent nearest = null;
     double minDist = Double.MAX_VALUE;
     
     for (Agent agent : agents) {
         if (agent.isAvailable()) {
             double dist = distance(order.getLat(), order.getLon(), agent.getLat(), agent.getLon());
             if (dist < minDist) {
                 minDist = dist;
                 nearest = agent;
             }
         }
     }
     
     if (nearest == null) {
         orders.add(order);
         throw new NoAgentAvailableException("No agent available for " + order.getId());
     }
     
     nearest.setAvailable(false);
     activeDeliveries.add(order);
     System.out.println("Assigned " + order.getId() + " to " + nearest.getId());
 }
 
 public void cancelDelivery(String orderId) {
     activeDeliveries.removeIf(o -> o.getId().equals(orderId));
     for (Agent a : agents) {
         if (!a.isAvailable()) {
             a.setAvailable(true);
             break;
         }
     }
     System.out.println("Cancelled " + orderId);
 }
 
 public void viewActiveDeliveries() {
     System.out.println("Active: " + activeDeliveries.stream().map(Order::getId).toList());
 }
 
 private double distance(double lat1, double lon1, double lat2, double lon2) {
     return Math.sqrt(Math.pow(lat1 - lat2, 2) + Math.pow(lon1 - lon2, 2));
 }
}

//Test
public class FoodDeliveryOrderRoutingSystem {
 public static void main(String[] args) {
     DeliveryService service = new DeliveryService();
     service.addAgent(new Agent("A1", 0, 0));
     service.addAgent(new Agent("A2", 10, 10));
     service.addOrder(new Order("O1", 1, 1));
     service.addOrder(new Order("O2", 9, 9));
     try {
         service.assignOrder();
         service.assignOrder();
     } catch (NoAgentAvailableException e) {
         System.out.println(e.getMessage());
     }
     service.viewActiveDeliveries();
 }
}

