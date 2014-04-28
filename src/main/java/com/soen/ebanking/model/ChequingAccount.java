/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.model;

import com.soen.ebanking.dao.ObjectDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class ChequingAccount extends Account implements Serializable {

    public ChequingAccount() {
    }

    public ChequingAccount(double balance, Client client) {
        this.setBalance(balance);
        this.setClient(client);
    }

    @Override
    public void saveAccount() {
        ObjectDao<ChequingAccount> accountDao = new ObjectDao<ChequingAccount>();
        accountDao.addObject(this);
    }

    @Override
    public void updateAccount() {
        ObjectDao<ChequingAccount> checkingAccountDao = new ObjectDao<ChequingAccount>();
        checkingAccountDao.updateObject(this, this.getAccountId(), ChequingAccount.class);
//        String setString = " balance = " + this.getBalance();
//       // setString += 
//        String whereString= " account.accountId = " + this.getAccountId();
//        checkingAccountDao.updateUsingSQL("ChequingAccount account ", setString, whereString);   
    }

    @Override
    public void deleteAccount() {
        ObjectDao<ChequingAccount> checkingAccountDao = new ObjectDao<ChequingAccount>();
        checkingAccountDao.deleteObject(this, this.getAccountId(), ChequingAccount.class);
    }

    public static ChequingAccount getCheckingAccountById(long id) {

        ObjectDao<ChequingAccount> dao = new ObjectDao<ChequingAccount>();
        return dao.getObjectById(id, ChequingAccount.class);
    }

    public static List<ChequingAccount> getCheckingAccounts() {
        ObjectDao<ChequingAccount> dao = new ObjectDao<ChequingAccount>();
        return dao.getAllObjects(ChequingAccount.class, "ChequingAccount");
    }

    @Override
    public boolean withdraw(double amount, String description) {
        boolean isDone = false;

        if (this.getBalance() >= amount) {
            super.withdraw(amount, description);
            isDone = true;
        }
        return isDone;
    }
}
