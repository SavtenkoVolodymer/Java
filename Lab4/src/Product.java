import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("The price cannot be negative");
        }
    }

    public static Optional<String> findSecondMostExpensive(List<Product> products) {
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());

        if (products.size() < 2) {
            return Optional.empty();
        } else {
            return Optional.of(products.get(1).name);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
