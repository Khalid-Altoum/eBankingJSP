/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soen.ebanking.model;

import com.soen.ebanking.dao.ObjectDao;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
public class SavingAccount extends Account implements Serializable{
    
  
    public SavingAccount(){}
   
    public SavingAccount(double balance, Client client){
    this.setBalance(balance);
    this.setClient(client);
    }
    
    
      public void saveSavingAccount() {
        ObjectDao<SavingAccount> savingAccountDao = new ObjectDao<SavingAccount>();
        savingAccountDao.addObject(this);
    }

    @Override
    public void updateAccount()  {
        ObjectDao<SavingAccount> savingAccountDao = new ObjectDao<SavingAccount>();
        savingAccountDao.updateObject(this, this.getAccountId(), SavingAccount.class);
    }

    @Override
    public void deleteAccount()  {
        ObjectDao<SavingAccount> savingAccountDao = new ObjectDao<SavingAccount>();
        savingAccountDao.deleteObject(this, this.getAccountId(), SavingAccount.class);
    }

    public static SavingAccount getSavingAccountById(long id) {
        ObjectDao<SavingAccount> dao = new ObjectDao<SavingAccount>();
        return dao.getObjectById(id, SavingAccount.class);
        
    }

    public static List<SavingAccount> getSavingAccounts() {
         ObjectDao<SavingAccount> dao = new ObjectDao<SavingAccount>();
        return dao.getAllObjects(SavingAccount.class, "SavingAccount");
        
    }
}
