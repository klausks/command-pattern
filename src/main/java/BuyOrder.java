public class BuyOrder extends Order {

    public BuyOrder(User owner, StockService stockService, String ticker, double pricePoint, int qty) {
        super(owner, stockService, ticker, pricePoint, qty);
    }

    public void execute() {
        stockService.placeOrder(this);
    }

    public String toString() {
        return String.format("BUY Order placed for %d units of %s at pricepoint %.2f", qty, ticker, pricePoint);
    }
}
