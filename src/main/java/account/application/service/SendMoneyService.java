package account.application.service;

import account.adapter.in.SendMoneyCommand;
import account.domain.Account;

import java.time.LocalDateTime;

public class SendMoneyService {
    public boolean sendMoney(SendMoneyCommand command) {
        Account sourceAccount = loadAccount(command.getSourceAccountId());
        Account targetAccount = loadAccount(command.getSourceAccountId());

        String sourceAccountId = sourceAccount.getId()
                .orElseThrow(() -> new IllegalStateException("expected source account ID not to be empty"));
        String targetAccountId = targetAccount.getId()
                .orElseThrow(() -> new IllegalStateException("expected target account ID not to be empty"));

        sourceAccount.withdraw(command.getMoney());
        targetAccount.deposit(command.getMoney());
        return true;
    }

    public Account loadAccount(String accountId) {
        //...
    }
}
