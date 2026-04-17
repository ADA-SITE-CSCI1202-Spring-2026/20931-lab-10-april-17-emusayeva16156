import java.util.*;
import java.util.function.Predicate;

class Product {
    String name;
    double price;
    boolean inStock;

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " - " + (inStock ? "In Stock" : "Out of Stock");
    }
}

public class ProductFilter {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 900, true));
        products.add(new Product("Mouse", 25, true));
        products.add(new Product("Keyboard", 45, false));
        products.add(new Product("USB Cable", 10, true));
        products.add(new Product("Monitor", 150, true));

        Predicate<Product> isAffordable =
                p -> p.price < 50 && p.inStock;

        products.removeIf(isAffordable.negate());

        System.out.println("Filtered Products:");
        products.forEach(System.out::println);
    }
}
