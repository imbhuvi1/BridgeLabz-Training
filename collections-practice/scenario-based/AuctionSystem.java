package scenario_based;

import java.util.*;

//Custom Exception
class InvalidBidException extends Exception {
 public InvalidBidException(String msg) {
     super(msg);
 }
}

//User class
class User implements Comparable<User> {
 private String name;
 private double bidAmount;

 public User(String name, double bidAmount) {
     this.name = name;
     this.bidAmount = bidAmount;
 }

 public double getBidAmount() {
     return bidAmount;
 }

 public String getName() {
     return name;
 }

 // Sort users by bid amount (descending)
 @Override
 public int compareTo(User other) {
     return Double.compare(other.bidAmount, this.bidAmount);
 }
}

//AuctionItem class
class AuctionItem {
 private String itemName;
 private TreeMap<User, Double> bids = new TreeMap<>();

 public AuctionItem(String itemName) {
     this.itemName = itemName;
 }

 public void placeBid(User user, double amount) throws InvalidBidException {
     if (!bids.isEmpty()) {
         double highestBid = bids.firstEntry().getValue();
         if (amount <= highestBid) {
             throw new InvalidBidException("Bid must be higher than current highest bid");
         }
     }
     bids.put(user, amount);
 }

 public void showHighestBid() {
     if (!bids.isEmpty()) {
         Map.Entry<User, Double> entry = bids.firstEntry();
         System.out.println("Highest Bid: " +
                 entry.getKey().getName() + " -> " + entry.getValue());
     }
 }
}

//Main class
public class AuctionSystem {
 public static void main(String[] args) {

     AuctionItem item = new AuctionItem("Antique Vase");

     try {
         item.placeBid(new User("Aman", 5000), 5000);
         item.placeBid(new User("Riya", 7000), 7000);
         item.placeBid(new User("Karan", 6000), 6000); // Invalid
     } catch (InvalidBidException e) {
         System.out.println(e.getMessage());
     }

     item.showHighestBid();
 }
}
