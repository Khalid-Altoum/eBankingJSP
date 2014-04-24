/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.model;

import com.soen.ebanking.dao.ObjectDao;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

    @Id
    @GeneratedValue
    protected Long accountId;
    private String accountNumber;
    private double balance;
    private String currency;
    private String currencySign;
    
   // @Convert(converter= JodaDateTimeConverter.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date openedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToMany(mappedBy = "sourceAccount", fetch = FetchType.EAGER)
    private List<AccountTransaction> sourceTransactions;

    public static enum AccountStatus {

        ACTIVE, BLOCKED, INACTIVE
    };

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    public Account() {
        this.balance = 0;
        this.currency = "CAD";
        this.currencySign = "$";
        this.status = AccountStatus.ACTIVE;
        this.openedDate = new Date();
        this.sourceTransactions = new ArrayList<AccountTransaction>();
    }

    public Account(double startingBalance, Client client) {
        this.balance = startingBalance;
        this.client = client;
        this.currency = "CAD";
        this.currencySign = "$";
        this.status = AccountStatus.ACTIVE;
        this.openedDate = new Date();
        this.sourceTransactions = new ArrayList<AccountTransaction>();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(Date openedDate) {
        this.openedDate = openedDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public List<AccountTransaction> getSourceTransactions() {
        return sourceTransactions;
    }

    public void setSourceTransactions(List<AccountTransaction> sourceTransactions) {
        this.sourceTransactions = sourceTransactions;
    }

    public void setCurrencySign(String currencySign) {
        this.currencySign = currencySign;
    }

  // ecliseLink Methods
    public void saveAccount() {
        ObjectDao<Account> accountDao = new ObjectDao<Account>();
        accountDao.addObject(this);
    }

    public void updateAccount() throws IllegalAccessException, InvocationTargetException {
        ObjectDao<Account> accountDao = new ObjectDao<Account>();
        accountDao.updateObject(this, this.getAccountId(), Account.class);
    }

    public void deleteAccount() throws IllegalAccessException, InvocationTargetException {
        ObjectDao<Account> accountDao = new ObjectDao<Account>();
        accountDao.deleteObject(this, this.getAccountId(), Account.class);
    }

    public static Account getAccountById(long id) {
        ObjectDao<Account> dao = new ObjectDao<Account>();
        return dao.getObjectById(id, Account.class);
    }

    public static ArrayList<Account> getAccounts() {
        ObjectDao<Account> dao = new ObjectDao<Account>();
        return dao.getAllObjects(Account.class, "Account");
    }

    public static ArrayList<Account> getAllClientAccounts(Long clientId) {
        ArrayList<Account> accounts;
        ObjectDao accountDao = new ObjectDao();
        accounts = accountDao.getAllObjectsByCondition("Account", "client_userId = " + clientId.toString());
        return accounts;
    }

    public boolean withdraw(double amount, String description)  {
        boolean isDone = false;

        double balance = this.getBalance();
        balance -= amount;
        this.setBalance(balance);
        try {
            this.updateAccount();
            isDone = true;
            AccountTransaction tr = new AccountTransaction(this, amount, 0, "Withdrawl: " + description);
            tr.saveTransaction();
        } catch (Exception e) {
            return false;
        }
        return isDone;
    }

    public boolean deposit(double amount, String description)  {
        boolean isDone = false;

        double balance = this.getBalance();
        balance += amount;
        this.setBalance(balance);
        try {
            this.updateAccount();
            isDone = true;

            AccountTransaction tr = new AccountTransaction(this, 0, amount, "Deposit:" + description);
            tr.saveTransaction();
        } catch (Exception e) {
            return false;
        }
        return isDone;
    }

    public static boolean transfer(Account sourceAccount, Account targetAccount, double amount, String description) {

        double sourceBalance = sourceAccount.getBalance();
        double targetBalance = targetAccount.getBalance();
        boolean isDone = false;

        if (sourceBalance >= amount) {
            sourceBalance -= amount;
            targetBalance += amount;

            try {
                sourceAccount.setBalance(sourceBalance);
                sourceAccount.updateAccount();

                targetAccount.setBalance(targetBalance);
                targetAccount.updateAccount();

                isDone = true;

                AccountTransaction sourceTransaction = new AccountTransaction(sourceAccount, amount, 0, description);
                sourceTransaction.saveTransaction();

                AccountTransaction targetTransaction = new AccountTransaction(targetAccount, 0, amount, description);
                targetTransaction.saveTransaction();
            } catch (Exception e) {
                return false;
            }
        }
        return isDone;

    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", accountNumber=" + accountNumber + ", balance=" + balance + ", currency=" + currency + ", currencySign=" + currencySign + ", openedDate=" + openedDate + ", client=" + client + ", sourceTransactions=" + sourceTransactions + ", status=" + status + '}';
    }

    public static List<Account> getPayeeAccounts(List<Account> clientAccounts) {
        List<Account> accounts = new ArrayList<Account>();

        for (Account ac : clientAccounts) {
            if (ac instanceof PayeeAccount) {
                accounts.add(ac);
            }
        }
        return accounts;
    }

    public static List<Account> getPersonalAccount(List<Account> clientAccounts) {
        List<Account> accounts = new ArrayList<Account>();
        for (Account ac : clientAccounts) {
            if (!(ac instanceof PayeeAccount) && !(ac instanceof InvestmentAccount)) {
                accounts.add(ac);
            }
        }
        return accounts;
    }

    public static List<InvestmentAccount> getInvestmentAccounts(List<Account> clientAccounts) {
        List<InvestmentAccount> accounts = new ArrayList<InvestmentAccount>();

        for (Account ac : clientAccounts) {
            if (ac instanceof InvestmentAccount) {
                accounts.add((InvestmentAccount) ac);
            }
        }
        return accounts;
    }

    // TO DO
    public static Account getAccountByAccountNumber(String  accountNumber) {
        
         ObjectDao<Account> dao = new ObjectDao<Account>();
        EntityManager em = dao.getEMF().createEntityManager();
        
        
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Account> query = qb.createQuery(Account.class);
        Root<Account> account = query.from(Account.class);
        query.where(qb.equal(account.get("accountNumber"), accountNumber));
        List<Account> result = em.createQuery(query).getResultList();
        
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }

    }

}
