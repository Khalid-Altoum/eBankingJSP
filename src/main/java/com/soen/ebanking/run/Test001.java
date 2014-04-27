/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soen.ebanking.run;

import com.soen.ebanking.model.*;


public class Test001 {
    public static void main(String[] args) {
        
        Account fromAcc = Account.getAccountById(52);
         Account toAcc=Account.getAccountById(53); 
         
         Account.transfer(fromAcc, toAcc, 12, null);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
