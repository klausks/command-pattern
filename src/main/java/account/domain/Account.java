package account.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class Account {
    private final String id;
    private final BigDecimal balance;

    public Account(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public Optional<String> getId(){
        return Optional.ofNullable(this.id);
    }

    public boolean withdraw(BigDecimal money) {

        if (!mayWithdraw(money)) {
            return false;
        }
        balance.subtract(money);
        return true;
    }

    private boolean mayWithdraw(BigDecimal money) {
        return balance.compareTo(money) > -1;
    }

    public boolean deposit(BigDecimal money) {
        balance.add(money);
        return true;
    }

}
