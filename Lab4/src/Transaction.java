import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Transaction {
    private double amount;
    private String category;

    public Transaction(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public double getAmount() {
        return amount;

    }
    public String getCategory() {
        return category;
    }

    public static Map<String, Double> sumTransactionsByCategory(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,
                        Collectors.summingDouble(Transaction::getAmount)));

    }
}
