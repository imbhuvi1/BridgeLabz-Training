package gcr_codebase.collectors;

import java.util.*;
import java.util.stream.Collectors;

class Order {
    String customer;
    double amount;

    Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    String getCustomer() { return customer; }
    double getAmount() { return amount; }
}

public class OrderRevenue {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
            new Order("Raj", 1200),
            new Order("Raj", 800),
            new Order("Simran", 1500)
        );

        orders.stream()
              .collect(Collectors.groupingBy(
                  Order::getCustomer,
                  Collectors.summingDouble(Order::getAmount)
              ))
              .forEach((customer, total) ->
                  System.out.println(customer + " : " + total)
              );
    }
}

