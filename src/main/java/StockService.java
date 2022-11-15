import java.math.BigDecimal;
import java.util.*;

public class StockService {
    private List<Order> orders;
    private Map<String, Double> stockPrices;

    public StockService() {
        orders = new ArrayList<>();
        stockPrices = new HashMap<>();
        stockPrices.put("PETR4", 20.7);
        stockPrices.put("IRBR3", 25.2);
        stockPrices.put("B3SA3", 27.0);
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void processOrders() {
        for (Order order: orders) {
            double pricePoint = order.pricePoint;
            double currentStockPrice = getStockPrice(order.ticker);
            if (order instanceof BuyOrder) {
                if (pricePoint <= currentStockPrice) {
                    buyStock(order.owner, order.ticker, order.qty);
                }
            } else if (order instanceof SellOrder) {
                if (pricePoint >= currentStockPrice) {
                    sellStock(order.owner, order.ticker, order.qty);
                }
            }
        }
    }

    private void buyStock(User owner, String ticker, int qty) {
        double currentStockPrice = stockPrices.get(ticker);
        double acquisitionCost = currentStockPrice * qty;
        try {
            owner.subtractFromBalance(acquisitionCost);
        } catch (IllegalArgumentException iae) {
            System.out.println("Could not fulfill buy order due to insufficient account funds.");
        }
        owner.addShare(ticker, qty, acquisitionCost);
    }

    private void sellStock(User owner, String ticker, int qty) {
        Share currentShare = owner.getShare(ticker).get();
    }

    public void updateStockPrice(String ticker, double newPrice) {
        stockPrices.put(ticker, newPrice);
    }

    public double getStockPrice(String ticker) {
        return stockPrices.get(ticker);
    }
}
