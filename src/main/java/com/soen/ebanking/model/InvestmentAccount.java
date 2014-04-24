/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.model;

import com.soen.ebanking.dao.ObjectDao;
import com.soen.ebanking.utils.DateUtil;
import com.soen.ebanking.utils.RandomUtil;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;


@Entity
public class InvestmentAccount extends Account implements Serializable {

   // @Convert(converter= JodaDateTimeConverter.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
   // @Convert(converter= JodaDateTimeConverter.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private InvestmentPlan investmentPlan;
    
    public InvestmentAccount() {
        super();
    }

    public InvestmentAccount(Date startDate, Date endDate, InvestmentPlan investmentPlan) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.investmentPlan = investmentPlan;
    }

  

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public InvestmentPlan getInvestmentPlan() {
        return investmentPlan;
    }

    public void setInvestmentPlan(InvestmentPlan investmentPlan) {
        this.investmentPlan = investmentPlan;
    }

    @Override
    public void saveAccount() {
        ObjectDao<InvestmentAccount> accountDao = new ObjectDao<InvestmentAccount>();
        this.endDate = DateUtil.addDays(this.startDate, this.investmentPlan.getDurationInDays());
        accountDao.addObject(this);
    }

    @Override
    public void updateAccount() throws IllegalAccessException, InvocationTargetException {
        ObjectDao<InvestmentAccount> investmentAccountDao = new ObjectDao<InvestmentAccount>();
        this.endDate = DateUtil.addDays(this.startDate, this.investmentPlan.getDurationInDays());
        investmentAccountDao.updateObject(this, this.getAccountId(), InvestmentAccount.class);
    }

    @Override
    public void deleteAccount() throws IllegalAccessException, InvocationTargetException {
        ObjectDao investmentAccountDao = new ObjectDao();
        investmentAccountDao.deleteObject(this, this.getAccountId(), InvestmentAccount.class);
    }

    public static InvestmentAccount getInvestmentAccountById(long id) {
        ObjectDao<InvestmentAccount> dao = new ObjectDao<InvestmentAccount>();
        return dao.getObjectById(id, InvestmentAccount.class);
        
    }

    public static ArrayList<InvestmentAccount> getInvestmentAccounts() {
        ObjectDao<InvestmentAccount> dao = new ObjectDao<InvestmentAccount>();
        return dao.getAllObjects(InvestmentAccount.class, "InvestmentAccount");
    }

    @Override
    public boolean withdraw(double amount, String description) {
        boolean isDone = false;
        return isDone;
    }

    public double calculateReturnOfInvestment(Date today) {
        double result = 0;
        if (this.investmentPlan instanceof ClosedTermInvestment) {
            return calculateReturnOfInvestmentForClosedTermInvestment(today);
        } else if (this.investmentPlan instanceof OpenTermInvestment) {
            return calculateReturnOfInvestmentForOpenTermInvestment(today);
        }
        return result;
    }

    public double calculateReturnOfInvestmentForClosedTermInvestment(Date today) {
//        long duration = this.getInvestmentPlan().getDurationInDays();
        double returnOfInvestmentPercent = this.getInvestmentPlan().getInvestmentReturnsPercent();
        double returnOfInvestment = 0;

        long days = DateUtil.DateDifference(this.endDate, today);
        if (days > 0) {
            returnOfInvestment = (returnOfInvestmentPercent * this.getBalance()) + this.getBalance();
        }
        return returnOfInvestment;
    }

    public double calculateReturnOfInvestmentForOpenTermInvestment(Date today) {

        double returnOfInvestment = 0;

        long days = DateUtil.DateDifference(this.endDate, today);
        if (days > 0) {
            for (int i = 0; i < days; i++) {
                double returnOfInvestmentPercent = RandomUtil.randomInRange(0.0000001, 0.0003);
                returnOfInvestment = (returnOfInvestmentPercent * this.getBalance()) + this.getBalance();

            }

        }
        return returnOfInvestment;
    }
}
