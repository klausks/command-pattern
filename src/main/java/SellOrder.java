public class SellOrder extends Order {

    public SellOrder(User owner, StockService stockService, String ticker, double pricePoint, int qty) {
        super(owner, stockService, ticker, pricePoint, qty);
    }

    public void execute() {
        stockService.placeOrder(this);
    }

    public String toString() {
        return String.format("SELL Order placed for %f units of %s at pricepoint %.2f", qty, ticker, pricePoint);
    }
}
