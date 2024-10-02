package net.javaguides.banking_app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.banking_app.dta.AccountDto;
import net.javaguides.banking_app.entity.Account;
import net.javaguides.banking_app.mapper.AccountMapper;
import net.javaguides.banking_app.repository.AccountRepository;
import net.javaguides.banking_app.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        //Check if the account is exist or not
        Account account=accountRepository
        .findById(id)
        .orElseThrow(()-> new RuntimeException("Account doesn't exists"));

        return AccountMapper.mapToAccountDto(account);
    }


    @Override
    public AccountDto deposit(Long id, double amount) {

        //Check if the account is exist or not
        Account account=accountRepository
        .findById(id)
        .orElseThrow(()-> new RuntimeException("Account doesn't exists"));

        //deposit 
        double total = account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }


    @Override
    public AccountDto withdraw(Long id, double amount) {

        //Check if the account is exist or not
        Account account=accountRepository
        .findById(id)
        .orElseThrow(()-> new RuntimeException("Account doesn't exists"));

        //withdraw
        //Check for Sufficient Balance
        if(account.getBalance() < amount)
        {
            throw new RuntimeException("Insufficient Balance");
        }

        double total = account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }


    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

}
