import account.adapter.in.SendMoneyCommand;
import account.application.service.SendMoneyService;

import java.math.BigDecimal;

public class Application {
    public static void main() {
        SendMoneyService sendMoneyService = new SendMoneyService();
        SendMoneyCommand command = new SendMoneyCommand("1", "2", BigDecimal.valueOf(100.0));

        sendMoneyService.sendMoney(command);
    }
}
