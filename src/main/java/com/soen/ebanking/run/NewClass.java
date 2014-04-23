/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.run;

import com.soen.ebanking.model.Client;
import com.soen.ebanking.model.ClosedTermInvestment;
import com.soen.ebanking.model.InvestmentAccount;
import com.soen.ebanking.utils.DateUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author Khalid
 */
public class NewClass {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
//        ClosedTermInvestment closed = new ClosedTermInvestment(.04, 30, .15);
//        closed.saveInvestmentPlan();
//
//        OpenTermInvestment open = new OpenTermInvestment(0, 0, .004);
//        open.saveInvestmentPlan();
//
//        DateTime startDate = new DateTime(2014, 1, 30, 0, 0);
//        DateTime endDate = new DateTime(2014, 3, 30, 0, 0);
//        InvestmentAccount ia = new InvestmentAccount(startDate, endDate, open);
////       long id= ia.saveAccount();
//        ClosedTermInvestment closed = ClosedTermInvestment.getClosedTermInvestmentById(2);
//        InvestmentAccount ia = InvestmentAccount.getInvestmentAccountById(1);
////        ia.setAccountNumber("Investment0001");
////        ia.setClient(null);
////        ia.setBalance(1000);
////        ia.setInvestmentPlan(closed);
////        ia.updateAccount();
//       
//        Date today = new Date(2014, 2, 31, 0, 0);
//        System.out.println(" The ROI = "+ia.calculateReturnOfInvestment(today));
        Client client =Client.getClientByUserName("01234567890");
        if(client == null){
            System.out.println("client is null");
        }else{
            System.out.println(client.getFirstName()+" "+client.getLastName());
        }
        
    }
}
