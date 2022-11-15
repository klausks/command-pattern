public class BuyOrder extends Order {

    public BuyOrder(User owner, StockService stockService, String ticker, double pricePoint, int qty) {
        super(owner, stockService, ticker, pricePoint, qty);
    }

    public void execute() {
        stockService.placeOrder(this);
    }

    public String toString(double price) {
        return String.format("BUY Order by %s for %d units of %s at price %.2f\n", owner.getName(), qty, ticker, price);
    }
}
