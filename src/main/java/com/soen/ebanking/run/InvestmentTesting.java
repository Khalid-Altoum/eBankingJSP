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
import org.joda.time.DateTime;

/**
 *
 * @author Khalid
 */
public class InvestmentTesting {
    public static void main(String[] args) {
        
        Client cl = Client.getClientsById(1);
        InvestmentPlan ip = InvestmentPlan.getInvestmentPlanById(1);
        ClosedTermInvestment cti = new ClosedTermInvestment(.3, 60, .55);
        cti.saveInvestmentPlan();
        
        InvestmentAccount ia = new InvestmentAccount(new Date(), DateUtil.addDays(new Date(), 60), cti);
        ia.setAccountNumber("Investment001");
        ia.setClient(cl);
        ia.saveAccount();
        
       
        
        
    }
 
}
