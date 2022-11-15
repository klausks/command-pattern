public class Share {
    private String ticker;
    private int qty;
    private double acquisitionPrice;

    public Share(String ticker, int qty, double acquisitionPrice) {
        this.ticker = ticker;
        this.qty = qty;
        this.acquisitionPrice = acquisitionPrice;
    }

    public void add(int qty, double acquisitionPrice) {
        this.acquisitionPrice += acquisitionPrice;
        this.qty += qty;
    }
    public void subtract(int qty) {
        this.acquisitionPrice -= qty * (this.acquisitionPrice / this.qty);
        this.qty -= qty;
    }

    public String toString() {
        return String.format("Ticker: %s, Qty: %d, Total cost: %.2f\n", ticker, qty, acquisitionPrice);
    }
}
