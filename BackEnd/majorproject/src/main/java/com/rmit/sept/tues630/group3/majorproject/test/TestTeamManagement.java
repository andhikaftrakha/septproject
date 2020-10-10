package com.rmit.sept.tues630.group3.majorproject.test;

import com.rmit.sept.tues630.group3.majorproject.model.Account;
import com.rmit.sept.tues630.group3.majorproject.model.Team;
import com.rmit.sept.tues630.group3.majorproject.services.TeamManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Collection;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestTeamManagement {
    TeamManagement test = new TeamManagement();
    Collection<Account> teamMembers = new ArrayList<>();
    Team member1;
    Team member2;
    Account member3;
    Account customer;
    Account nullAcc;
    @BeforeEach
    public void setup(){
        member1 = new Team("Alan","Du", 123123, "000", true);
        member2 = new Team("Tommy","Ao", 111111, "123", false);
        member3 = new Account("Tommy","Ao", "caramel", "000", "0484135441", "banking",20.00,4);
        customer = new Account("Alan","Du", "2215518450", "000", "0474880181", "banking");
        nullAcc = new Account();
        test.addWorker(member3);


    }
    @Test
    public void Test_Success_AssignCustomerToATeamMember(){
        Assertions.assertEquals(test.assignCustomerToWorker(member2,customer, "Banking") == true,test.assignCustomerToWorker(member2,customer, "Banking") == true);
    }

    @Test
    public void Test_Fail_AssignCustomerToATeamMember(){
        Assertions.assertEquals(test.assignCustomerToWorker(member2,customer, "Banking") == false, test.assignCustomerToWorker(member2,customer, "Banking") == false);
    }

    @Test
    public void Test_Fail_AssignEmployeeToTeam(){
        Assertions.assertTrue(test.assignCustomerToWorker(member1,member3,"Banking")==false);
    }

    @Test
    public void Test_Fail_AssignNullAccountToTeam(){
        Assertions.assertTrue(test.assignCustomerToWorker(member1,nullAcc,"NNN") == false);
    }


}
