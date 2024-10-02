package net.javaguides.banking_app.service;

import net.javaguides.banking_app.dta.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);
}
