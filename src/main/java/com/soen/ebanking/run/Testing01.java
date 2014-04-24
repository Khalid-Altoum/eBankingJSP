/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soen.ebanking.run;

import com.soen.ebanking.model.Account;

/**
 *
 * @author Khalid
 */
public class Testing01 {
    public static void main(String[] args) {
        Account ac =Account.getAccountByAccountNumber("Check001");
        System.out.println(ac.getBalance());
    }
    
}
