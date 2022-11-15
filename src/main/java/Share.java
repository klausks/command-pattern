public class Share {
    private String ticker;
    private int qty;
    private double acquisitionPrice;

    public Share(String ticker, int qty, double acquisitionPrice) {
        this.ticker = ticker;
        this.qty = qty;
        this.acquisitionPrice = acquisitionPrice;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getQty() {
        return qty;
    }

    public void add(int qty, double acquisitionPrice) {
        this.acquisitionPrice += acquisitionPrice;
        this.qty += qty;
    }

    public double getAcquisitionPrice() {
        return acquisitionPrice;
    }

    public void setAcquisitionPrice(double acquisitionPrice) {
        this.acquisitionPrice = acquisitionPrice;
    }
}
