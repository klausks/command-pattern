import java.math.BigDecimal;
import java.util.*;

public class StockService {
    private List<Order> orders;
    private Map<String, Double> stockPrices;

    public StockService() {
        orders = new ArrayList<>();
        stockPrices = new HashMap<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(String.format("Placed %s", order.toString()));
    }

    public void processOrders() {
        Iterator<Order> ordersIterator = orders.iterator() ;
        while (ordersIterator.hasNext()) {
            Order order = ordersIterator.next();
            double pricePoint = order.pricePoint;
            double currentStockPrice = getStockPrice(order.ticker);
            boolean shouldProcessForCurrentPrice = pricePoint == 0 ? true : false;
            if (order instanceof BuyOrder) {
                if (shouldProcessForCurrentPrice || currentStockPrice <= currentStockPrice) {
                    buyStock(order);
                    ordersIterator.remove();
                }
            } else if (order instanceof SellOrder) {
                if (shouldProcessForCurrentPrice || currentStockPrice >= pricePoint) {
                    sellStock(order);
                    ordersIterator.remove();
                }
            }
        }
    }

    private void buyStock(Order order) {
        double currentStockPrice = stockPrices.get(order.ticker);
        double acquisitionCost = currentStockPrice * order.qty;
        try {
            order.owner.subtractFromBalance(acquisitionCost);
        } catch (IllegalArgumentException iae) {
            System.out.println("Could not fulfill buy order due to insufficient account funds.");
        }
        order.owner.addShare(order.ticker, order.qty, acquisitionCost);
        order.owner.addExecutedOrder(order.toString(currentStockPrice));
    }

    private void sellStock(Order order) {
        double currentStockPrice = stockPrices.get(order.ticker);
        order.owner.removeShare(order.ticker, order.qty);
        order.owner.addToBalance(order.qty * currentStockPrice);
        order.owner.addExecutedOrder(order.toString(currentStockPrice));
    }

    public void updateStockPrice(String ticker, double newPrice) {
        stockPrices.put(ticker, newPrice);
    }

    public double getStockPrice(String ticker) {
        return stockPrices.get(ticker);
    }

    public void setStockPrices(Map<String, Double> stockPrices) { this.stockPrices = stockPrices; }
}
