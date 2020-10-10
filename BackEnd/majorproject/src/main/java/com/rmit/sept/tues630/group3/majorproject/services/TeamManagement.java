package com.rmit.sept.tues630.group3.majorproject.services;

import com.rmit.sept.tues630.group3.majorproject.model.Account;
import com.rmit.sept.tues630.group3.majorproject.model.Team;

import java.util.ArrayList;

public class TeamManagement {
    private ArrayList<Account> teamMembers = new ArrayList<>();

    public TeamManagement(Account account){
        teamMembers = new ArrayList<Account>();

    }

    public TeamManagement() {

    }
    //Customer assignment
    public boolean assignCustomerToWorker(Team employee,Account account, String services){
        if(account == null || employee == null){
            return false;
        }else if(account.getAc_type() == "Customer"){
            employee.setAvailability(false);
            return true;
        }else{
            return false;
        }

    }

    //Add worker accounts to teamMembers array.
    public void addWorker(Account account){
        if(account == null){
            return;
        }else if(account.getAc_type() == "Worker"){
            teamMembers.add(account);
        }else{
            return;
        }


    }
    //Print a hard copy of all workers
    public ArrayList<Account> getAllWorker(){
        ArrayList<Account> workerCopy = new ArrayList<Account>();
        workerCopy.addAll(teamMembers);
        return workerCopy;
    }
}
