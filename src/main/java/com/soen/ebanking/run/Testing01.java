/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.run;

import com.soen.ebanking.model.Account;
import com.soen.ebanking.model.AccountTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khalid
 */
public class Testing01 {

    public static void main(String[] args) {
//        Account ac = Account.getAccountByAccountNumber("Check001");
//        System.out.println(ac.getBalance());

        List<AccountTransaction> transations = AccountTransaction.getAccountTransactions("Check001");

        for (AccountTransaction t : transations) {
            System.out.println("ID:"+t.getTransactionId()+" Time: "+t.getFormattedTransactionTime()+" Desc: "+t.getDescription()+" Debit: "+t.getFormattedDebit()+" Credit: "+t.getFormattedCredit());
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
