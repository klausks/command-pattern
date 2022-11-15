import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.*;

public class User {
    private double accountBalance;

    private Map<String, Share> shares;
    private String name;
    private String accountId;
    private List<String> executedOrdersHistory;

    public User(double accountBalance, String name, String accountId) {
        this.accountBalance = accountBalance;
        this.shares = new HashMap<>();
        this.name = name;
        this.accountId = accountId;
        this.executedOrdersHistory = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public Optional<Share> getShare(String ticker) {
        return Optional.ofNullable(shares.get(ticker));
    }

    public void addShare(String ticker, int qty, double acquisitionPrice) {
        Optional<Share> share = getShare(ticker);
        if (share.isPresent()) {
            share.get().add(qty, acquisitionPrice);
        } else {
            Share newShare = new Share(ticker, qty, acquisitionPrice);
            shares.put(ticker, newShare);
        }
    }

    public void removeShare(String ticker, int qty) {
        Optional<Share> share = getShare(ticker);
        if (share.isPresent()) {
            share.get().subtract(qty);
        } else {
            throw new IllegalArgumentException("No share of stock %s held by %s was found.");
        }
    }

    public void addExecutedOrder(String order) {
        this.executedOrdersHistory.add(order);
    }

    public void subtractFromBalance(double amount) throws IllegalArgumentException {
        if (amount > accountBalance) {
            throw new IllegalArgumentException();
        }
        this.accountBalance -= amount;
    }

    public void addToBalance(double amount) {
        this.accountBalance += amount;
    }

    public String accountSummary() {
        return String.format("----- Account summary for %s ------\n Account balance: %.2f\n--- Shares ---\n%s\n--- Transaction History ---\n%s",
                name, accountBalance, sharesSummary(), executedOrdersSummary()
        );
    }

    public String sharesSummary() {
        StringBuilder sb = new StringBuilder();
        for (Share share: shares.values()) {
            sb.append(share.toString());
        }
        return sb.toString();
    }

    public String executedOrdersSummary() {
        StringBuilder sb = new StringBuilder();
        for (String orderDetails : executedOrdersHistory) {
            sb.append(orderDetails);
        }
        return sb.toString();
    }


}
