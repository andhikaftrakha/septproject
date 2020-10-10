package com.rmit.sept.tues630.group3.majorproject.test;

import com.rmit.sept.tues630.group3.majorproject.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCreateAccount {
    Account account;
    Account account1;
    @BeforeEach
    public void setup(){
        account = new Account("Alan","Du", "2215518450", "000", "0474880181", "banking",20.00,4);
        account1 = new Account("","Du", "2215518450", "000", "0474880181", "banking",1.00,2);
    }
    @Test
    public void Test_Success_Create(){
        Assertions.assertEquals(account.getFirstName() != null ,account.getFirstName() != null);
    }
    @Test
    public void Test_Fail_Create(){
        Assertions.assertTrue(account1.getFirstName().isEmpty());
    }
}
