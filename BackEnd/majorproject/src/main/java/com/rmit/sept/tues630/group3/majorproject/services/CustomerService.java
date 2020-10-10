package com.rmit.sept.tues630.group3.majorproject.services;


import com.rmit.sept.tues630.group3.majorproject.Repository.AccountRepository;

import com.rmit.sept.tues630.group3.majorproject.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveOrUpdateAccount(Account account){
        //Business logic
        return accountRepository.save(account);
    }

    public Account findByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    public Account findByUsernameAndPassword(String username) {
        return accountRepository.findAccountByUsernameAndPasswordTrue(username);
    }
}
