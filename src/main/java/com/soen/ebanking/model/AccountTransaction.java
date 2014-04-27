package com.soen.ebanking.model;

import com.soen.ebanking.dao.ObjectDao;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.*;

@Entity
public class AccountTransaction implements Serializable, Comparable  {

    @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long transactionId;

    @Temporal(javax.persistence.TemporalType.DATE)
    
    private  Date transactionTime;
    private  String formattedTransactionTime;
    private String description;
    private double debit;
    private String formattedDebit;
    private double credit;
    private String formattedCredit;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account sourceAccount;

    public AccountTransaction() {
    }

    public AccountTransaction(Account sourceAccount, double debit, double credit, String description) {
        this.sourceAccount = sourceAccount;
        this.description = description;
        this.debit = debit;
        if (this.debit == 0 ){
        this.formattedDebit = " ";
        }else{
        this.formattedDebit = formatDoubleToCurrency(debit);
        }
        this.credit = credit;
         if (this.credit == 0 ){
        this.formattedCredit = " ";
        }else{
        this.formattedCredit = formatDoubleToCurrency(credit);
        }
        this.transactionTime = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	this.formattedTransactionTime = sdf.format(transactionTime);
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getFormattedDebit() {
        return formattedDebit;
    }

    public void setFormattedDebit(String formattedDebit) {
        this.formattedDebit = formattedDebit;
    }

    public String getFormattedCredit() {
        return formattedCredit;
    }

    public void setFormattedCredit(String formattedCredit) {
        this.formattedCredit = formattedCredit;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String formatDoubleToCurrency(double amount) {
        if (amount == 0) {
            return "";
        } else {
            String currencyString = NumberFormat.getCurrencyInstance(Locale.CANADA).format(amount);
            //return currencyString.replaceAll("\\.00", "");
            return currencyString;

        }
    }

    public String getFormattedTransactionTime() {
        return formattedTransactionTime;
    }

    public void setFormattedTransactionTime(String formattedTransactionTime) {
        this.formattedTransactionTime = formattedTransactionTime;
    }

    
    public void saveTransaction() {
            ObjectDao<AccountTransaction> accountDao = new ObjectDao<AccountTransaction>();
        accountDao.addObject(this);
    }

    public void updateTransaction()  {
        ObjectDao<AccountTransaction> accountDao = new ObjectDao<AccountTransaction>();
        accountDao.updateObject(this, this.getTransactionId(), AccountTransaction.class);
    }

    public void deleteTransaction()  {
        ObjectDao<AccountTransaction> accountDao = new ObjectDao<AccountTransaction>();
        accountDao.deleteObject(this, this.getTransactionId(), AccountTransaction.class);
    }

    public static AccountTransaction getTransactionById(long id) {
       
       ObjectDao<AccountTransaction> dao = new ObjectDao<AccountTransaction>();
        return dao.getObjectById(id, AccountTransaction.class);
    }

    public static ArrayList<AccountTransaction> getTransactions() {
         ObjectDao<AccountTransaction> dao = new ObjectDao<AccountTransaction>();
        return dao.getAllObjects(AccountTransaction.class, "AccountTransaction");
    }

    public static List<AccountTransaction> getAccountTransactions(String accountNumber) {
      
        Account foundAccount = Account.getAccountByAccountNumber(accountNumber);
        
//        Collections.sort(foundAccount.getSourceTransactions());
        
        return foundAccount.getSourceTransactions();
        
//        CriteriaBuilder qb = em.getCriteriaBuilder();
//        CriteriaQuery<AccountTransaction> query = qb.createQuery(AccountTransaction.class);
//        Root<AccountTransaction> transactions = query.from(AccountTransaction.class);
//        query.where(qb.equal(transactions.get("sourceAccount"), foundAccount));
//        query.orderBy(qb.desc(transactions.get("transactionTime"))); 
//        List<AccountTransaction> result = em.createQuery(query).getResultList();

         // Collections.sort(result);
        
       // return  result;
    }
   

    @Override
    public int compareTo(Object o) {
        AccountTransaction transaction  = (AccountTransaction)o;
        int compareage= transaction.getTransactionTime().compareTo(this.transactionTime);
        return compareage;
    }
   
    
}