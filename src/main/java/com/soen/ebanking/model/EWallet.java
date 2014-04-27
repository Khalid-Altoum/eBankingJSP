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
import javax.persistence.Entity;

@Entity
public class EWallet extends Account implements Serializable {
    
    @Override
    public void saveAccount() {
        ObjectDao<EWallet> accountDao = new ObjectDao<EWallet>();
         accountDao.addObject(this);
    }

    @Override
    public void updateAccount()  {
        ObjectDao<EWallet> dao = new ObjectDao<EWallet>();
         dao.updateObject(this, this.getAccountId(), EWallet.class);
//        String setString = " balance = " + this.getBalance();
//       // setString += 
//        String whereString= " account.accountId = " + this.getAccountId();
//        checkingAccountDao.updateUsingSQL("ChequingAccount account ", setString, whereString);   
    }

    @Override
    public void deleteAccount()  {
        ObjectDao<EWallet> dao = new ObjectDao<EWallet>();
        dao.deleteObject(this, this.getAccountId(), EWallet.class);
    }

    public static EWallet getEWalletById(long id) {
       
        ObjectDao<EWallet> dao = new ObjectDao<EWallet>();
        return dao.getObjectById(id, EWallet.class);
    }

    public static List<EWallet> getCheckingAccounts() {
       ObjectDao<EWallet> dao = new ObjectDao<EWallet>();
        return dao.getAllObjects(EWallet.class, "EWallet");
    }

    @Override
    public boolean withdraw(double amount,String description)  {
        boolean isDone = false;

        if (this.getBalance() >= amount) {
            super.withdraw(amount,description);
            isDone = true;
        }
        return isDone;
    }
}
