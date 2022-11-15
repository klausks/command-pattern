package account.adapter.in;

import common.Command;

import java.math.BigDecimal;

public class SendMoneyCommand implements Command {

    private final String sourceAccountId;
    private final String targetAccountId;
    private final BigDecimal money;

    public SendMoneyCommand(
            String sourceAccountId,
            String targetAccountId,
            BigDecimal money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
    }
    public void execute() {

    }
    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public String getTargetAccountId() {
        return targetAccountId;
    }

    public BigDecimal getMoney() {
        return money;
    }


}
