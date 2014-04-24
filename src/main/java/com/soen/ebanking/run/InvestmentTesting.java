/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soen.ebanking.run;

import com.soen.ebanking.model.Client;
import com.soen.ebanking.model.ClosedTermInvestment;
import com.soen.ebanking.model.InvestmentAccount;
import com.soen.ebanking.model.InvestmentPlan;
import com.soen.ebanking.utils.DateUtil;
import java.util.Date;


/**
 *
 * @author Khalid
 */
public class InvestmentTesting {
    public static void main(String[] args) {
        
       Client cl = Client.getClientsById(1);
//        ClosedTermInvestment cti = new ClosedTermInvestment(.3, 60, .55);
//        cti.saveInvestmentPlan();
        
        InvestmentPlan ip = ClosedTermInvestment.getInvestmentPlanById(201);
        InvestmentAccount ia = new InvestmentAccount(new Date(), DateUtil.addDays(new Date(), 60), ip);
        ia.setAccountNumber("Investment001");
        ia.setClient(cl);
        ia.saveAccount();
        
       
        
        
    }
 
}
