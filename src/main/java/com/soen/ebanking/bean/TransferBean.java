/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.bean;

import com.soen.ebanking.model.Account;
import com.soen.ebanking.model.ChequingAccount;
import com.soen.ebanking.model.Client;
import com.soen.ebanking.model.InvestmentAccount;
import com.soen.ebanking.model.PayeeAccount;
import com.soen.ebanking.model.SavingAccount;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

@ManagedBean
@RequestScoped
public class TransferBean {

    /**
     * Creates a new instance of TransferBean
     */
    public TransferBean() {
    }

    private long fromAccount;
    private long toAccount;
    private HashMap<String, Long> fromAccounts;
    private HashMap<String, Long> toAccounts;
    private double amountToTransfer;
    private PayeeAccount selectedPayeeAccountObj;
    private String SelectedPayeeAccountName;
    private String toAddress;

    public long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(long fromAccount) {
        this.fromAccount = fromAccount;
    }

    public long getToAccount() {
        return toAccount;
    }

    public void setToAccount(long toAccount) {
        this.toAccount = toAccount;
    }

    public HashMap<String, Long> getFromAccounts() {
        fromAccounts = getfromClientAccounts();
        return fromAccounts;
    }

    public void setFromAccounts(HashMap<String, Long> fromAccounts) {
        this.fromAccounts = fromAccounts;
    }

    public HashMap<String, Long> getToAccounts() {
        return toAccounts;
    }

    public void setToAccounts(HashMap<String, Long> toAccounts) {
        this.toAccounts = toAccounts;
    }

    public double getAmountToTransfer() {
        return amountToTransfer;
    }

    public void setAmountToTransfer(double amountToTransfer) {
        this.amountToTransfer = amountToTransfer;
    }

    public PayeeAccount getSelectedPayeeAccountObj() {
        return selectedPayeeAccountObj;
    }

    public void setSelectedPayeeAccountObj(PayeeAccount SelectedPayeeAccountObj) {
        this.selectedPayeeAccountObj = SelectedPayeeAccountObj;
    }

    public String getSelectedPayeeAccountName() {
        selectedPayeeAccountObj = getSelectedPayeeAccountFromSession();
        SelectedPayeeAccountName = selectedPayeeAccountObj.getPayee().getName();
        return SelectedPayeeAccountName;
    }

    public void setSelectedPayeeAccountName(String SelectedPayeeAccountName) {
        this.SelectedPayeeAccountName = SelectedPayeeAccountName;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String transferAmount() {
        Account fromAccountObj = Account.getAccountById(fromAccount);
        Account toAccountObj = Account.getAccountById(toAccount);
        if (Account.transfer(fromAccountObj, toAccountObj, amountToTransfer, ""+ fromAccountObj.getAccountNumber())) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("displaytransfer", new FacesMessage("A Succesfull Transfer Completed"));
            return "transfer";
        }
        return "loginError";
    }

    public void selectAccount(ValueChangeEvent event) {
        fromAccount = Long.parseLong(event.getNewValue().toString());
        toAccounts = getToClientAccounts();
    }

    private Client getClientfromSession() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        String clientNumber = (String) session.getAttribute("clientNumber");
        return Client.getClientByUserName(clientNumber);
    }

    private HashMap<String, Long> getfromClientAccounts() {
        Client client = getClientfromSession();
        HashMap<String, Long> tempClientAccounts = new HashMap();
        ArrayList<Account> clientAccounts = Account.getAllClientAccounts(client.getUserId());
        for (Account clientAccount : clientAccounts) {
            tempClientAccounts.put(clientAccount.getAccountNumber() + " " + InferAccountType(clientAccount) + " Account", clientAccount.getAccountId());
        }
        return tempClientAccounts;
    }

    private HashMap<String, Long> getToClientAccounts() {
        Client client = getClientfromSession();
        HashMap<String, Long> tempClientAccounts = new HashMap();
        ArrayList<Account> clientAccounts = Account.getAllClientAccounts(client.getUserId());
        for (Account clientAccount : clientAccounts) {
            if (clientAccount.getAccountId() != fromAccount) {
                tempClientAccounts.put(clientAccount.getAccountNumber() + " " + InferAccountType(clientAccount) + " Account", clientAccount.getAccountId());
            }
        }
        return tempClientAccounts;
    }

    public String InferAccountType(Account selectedAccount) {
        String accountTypeInferred = "NA";
        if (selectedAccount instanceof ChequingAccount) {
            accountTypeInferred = "Chequing";
        } else if (selectedAccount instanceof SavingAccount) {
            accountTypeInferred = "Saving";
        } else if (selectedAccount instanceof InvestmentAccount) {
            accountTypeInferred = "Investment";
        }
        return accountTypeInferred;
    }

    private PayeeAccount getSelectedPayeeAccountFromSession() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        String selectedPayeeAccountId = (String) session.getAttribute("selectedPayeeAccountId");
        return PayeeAccount.getPayeeAccountById(Long.parseLong(selectedPayeeAccountId));
    }

    public String payBill() {
        Account fromAccountObj = Account.getAccountById(fromAccount);
        Account toAccountObj = (Account) getSelectedPayeeAccountFromSession();
        if (Account.transfer(fromAccountObj, toAccountObj, amountToTransfer, "Payement from " + fromAccountObj.getAccountNumber())) {
            return "addPayee";
        }
        return "payeeAddError";
    }

    public String withdrawAmount() throws IllegalAccessException, InvocationTargetException {
        Account fromAccountObj = Account.getAccountById(fromAccount);
        fromAccountObj.withdraw(amountToTransfer, "Check sent to Address: "+toAddress);
        return "withdraw";
    }
}

