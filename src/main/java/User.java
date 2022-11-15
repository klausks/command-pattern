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
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Map<String, Share> getShares() {
        return shares;
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

    public List<String> getExecutedOrdersHistory() {
        return executedOrdersHistory;
    }

    public void addExecutedOrder(String order) {
        this.executedOrdersHistory.add(order);
    }

    public void subtractFromBalance(double acquisitionCost) throws IllegalArgumentException {
        if (acquisitionCost > accountBalance) {
            throw new IllegalArgumentException();
        }
        this.accountBalance -= acquisitionCost;
    }
}
