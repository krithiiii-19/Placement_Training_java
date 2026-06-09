import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product {
    String itemName;
    int itemPrice;

    // Adding a constructor makes object creation much cleaner
    public Product(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return itemName + " = " + itemPrice;
    }
}

public class DemoLAmbda {
    
    public static void pojoLambda() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("HP Pavilion", 45000));
        products.add(new Product("Macbook", 120000));
        products.add(new Product("Dell Vostro", 35000)); // Added a price for Dell

        System.out.println("--- Before Sorting Products ---");
        // Using a lambda expression to print each item
        products.forEach(p -> System.out.println(p));

        // Using a lambda expression to sort products by price (Ascending)
        products.sort((p1, p2) -> Integer.compare(p1.itemPrice, p2.itemPrice));

        System.out.println("\n--- After Sorting Products by Price ---");
        products.forEach(p -> System.out.println(p));
    }

    public static void main(String[] args) {
        System.out.println("--- Integer Sorting ---");
        List<Integer> alpha = new ArrayList<>();
        alpha.add(34);
        alpha.add(78);
        alpha.add(46);
        alpha.add(12);
        
        System.out.println("Before sort: " + alpha);
        
        // Sorting the integers using Collections
        Collections.sort(alpha);
        System.out.println("After sort: " + alpha + "\n");

        // Executing the custom object lambda method
        pojoLambda();
    }
}