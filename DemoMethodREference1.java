import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Product {
    private String itemName;
    private int itemPrice;

    public Product(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return itemName + " = " + itemPrice;
    }
}

public class DemoMethodREference1 {
    
    public static void pojoRefer() {
        List<Product> items = Arrays.asList(
            new Product("SSD", 5600),
            new Product("Pendrive", 800)
        );
        
        items.forEach(System.out::println);
        
        items.sort(Comparator.comparing(Product::getItemName));
        
        items.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> skills = Arrays.asList("Spring", "Django", "Cypress", "Jinja", "NUnit", "active");
        
        skills.sort(String::compareTo);
        skills.forEach(System.out::println);
        
        pojoRefer();
    }
}