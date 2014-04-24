/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soen.ebanking.model;

import com.soen.ebanking.dao.ObjectDao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class InvestmentPlan implements Serializable{
    
    @Id
    @GeneratedValue 
    private Long investmentPlanId;
    private double penaltyPercent;
    private int durationInDays;
    private double investmentReturnsPercent;

    public double getInvestmentReturnsPercent() {
        return investmentReturnsPercent;
    }

    public void setInvestmentReturnsPercent(double investmentReturnsPercent) {
        this.investmentReturnsPercent = investmentReturnsPercent;
    }
    

    public Long getInvestmentPlanId() {
        return investmentPlanId;
    }

    public void setInvestmentPlanId(Long id) {
        this.investmentPlanId = id;
    }

    public double getPenaltyPercent() {
        return penaltyPercent;
    }

    public void setPenaltyPercent(double penaltyPercent) {
        this.penaltyPercent = penaltyPercent;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }
      

    public void saveInvestmentPlan()  {
        ObjectDao<InvestmentPlan> investmentPlanDao = new ObjectDao<InvestmentPlan>();
        investmentPlanDao.addObject(this);
    }

    public void updateInvestmentPlan()  {
        ObjectDao<InvestmentPlan> investmentPlanDao = new ObjectDao<InvestmentPlan>();
        investmentPlanDao.updateObject(this, this.getInvestmentPlanId(), InvestmentPlan.class);
    }

    public void deleteInvestmentPlan()  {
        ObjectDao<InvestmentPlan> investmentPlanDao = new ObjectDao<InvestmentPlan>();
        investmentPlanDao.deleteObject(this, this.getInvestmentPlanId(), InvestmentPlan.class);
    }

    public static InvestmentPlan getInvestmentPlanById(long id) {
           ObjectDao<InvestmentPlan> dao = new ObjectDao<InvestmentPlan>();
           return dao.getObjectById(id, InvestmentPlan.class);
    }

    public static ArrayList<InvestmentPlan> getInvestmentPlans() {
         ObjectDao<InvestmentPlan> dao = new ObjectDao<InvestmentPlan>();
        return dao.getAllObjects(InvestmentPlan.class, "InvestmentPlan");
       
    }
}
 


