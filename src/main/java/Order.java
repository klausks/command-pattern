public abstract class Order {
    protected double pricePoint;
    protected String ticker;

    protected int qty;
    protected StockService stockService;
    protected User owner;

    public Order(User owner, StockService stockService, String ticker, double pricePoint, int qty) {
        this.owner = owner;
        this.stockService = stockService;
        this.pricePoint = pricePoint;
        this.ticker = ticker;
        this.qty = qty;
    }

    public abstract void execute();
    public abstract String toString(double price);
}
