/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soen.ebanking.run;

import com.soen.ebanking.model.CreditAccount;
import com.soen.ebanking.model.CreditPlan;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;


public class test2DB {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        
        CreditPlan cr = new CreditPlan(.23, .35);
        CreditAccount ca = new CreditAccount("4520-5656-0000-9000-4564", 5000, new Date(), "151");
        ca.setCreditPlan(cr);
        
        List<CreditAccount> accounts = cr.getCreditAccounts();
        accounts.add(ca);
        
//        long id= cr.saveCreditPlan();
        
        
        
        
        
        
        
        
        
        
        
    }
}