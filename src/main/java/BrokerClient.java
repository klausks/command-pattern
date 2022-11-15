import java.util.HashMap;
import java.util.Map;

public class BrokerClient {
    public static void main(String[] args) {
        Map<String, Double> stockPrices = new HashMap<>();
        stockPrices.put("IRBR3", 11.8);
        stockPrices.put("ITUB4", 8.7);
        stockPrices.put("PETR4", 33.2);
        stockPrices.put("EGIE3", 57.87);
        stockPrices.put("WEGE3", 44.25);

        StockService stockService = new StockService();
        stockService.setStockPrices(stockPrices);

        User william = new User(10000, "william", "will123");

        BuyOrder order1 = new BuyOrder(william, stockService, "IRBR3", 0, 10);
        order1.execute();
        BuyOrder order2 = new BuyOrder(william, stockService, "PETR4", 0, 5);
        order2.execute();
        BuyOrder order3 = new BuyOrder(william, stockService, "WEGE3", 0, 20);
        order3.execute();
        BuyOrder order4 = new BuyOrder(william, stockService, "ITUB4", 0, 100);
        order4.execute();

        stockService.processOrders();

        System.out.println(william.accountSummary());

        SellOrder sellOrder1 = new SellOrder(william, stockService, "WEGE3", 45, 10);
        sellOrder1.execute();

        stockService.processOrders();

        System.out.println(william.accountSummary());


    }

}
