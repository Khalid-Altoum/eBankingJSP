/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.run;

import com.soen.ebanking.model.*;
import com.soen.ebanking.utils.SHA1Util;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class test1DB {

    public static void main(String[] args)  {

//        Client cl = new Client();
//        cl.setFirstName("jh");
//        cl.setLastName("jf");
//        cl.setAge(99);
//        cl.setEmail("ff");
//        cl.setGender("Male");
//        cl.setUserName("01234567890");
//        cl.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");
//        cl.setPhoneNumber("514-9999");
//        //cl.setClientCard(new ClientCard("12-34-56", DateTime.now(),cl));
//        cl.saveUser();
////
//        
//        
           Client cl = Client.getClientsById(1);
//           System.out.println(cl1.getPassword());
           
//        try {
//            System.out.println(SHA1Util.sha1("1234"));
//           } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(test1DB.class.getName()).log(Level.SEVERE, null, ex);
//        }  
            
//        ChequingAccount ca = new ChequingAccount();
//        ca.setAccountNumber("Check001");
//        ca.setBalance(5000);
//        ca.setOpenedDate(new Date());
//        ca.setClient(cl);
//        ca.saveAccount();
//////
//        SavingAccount sa = new SavingAccount();
//        sa.setAccountNumber("Saving001");
//        sa.setBalance(1000);
//        sa.setOpenedDate(new Date());
//        sa.setClient(cl);
//        sa.saveAccount();
////
//        List<Account> accounts = new ArrayList<Account>();
//        accounts.add(sa);
//        accounts.add(ca);
////
//        cl.setAccounts(accounts);
//         cl.updateUser();
//            
            
            
//        Client cl2 = Client.getClientsById(8);
//        
//        List ss = Account.getPersonalAccount(cl2.getAccounts());
//        
//        for (Iterator<Account> it = ss.iterator(); it.hasNext();) {
//            String ac = it.next().toString();
//            System.out.println(ac);
//        }
            
            
//        Address address = new Address();
//        address.setApartmentNumber("1502");
//        address.setCity("Montreal");
//        address.setCountry("Canada");
//        address.setPostalCode("H3H 2J2");
//        address.setProvince("Quebec");
//        address.setStreetName("Rue St.Mathieu");
//        address.setStreetNumber("2055");
//        address.saveAddress();
//        
//        Client client = new Client();
//        client.setEmail("pradeep.samuel90@gmail.com");
//        client.setFirstName("Pradeep Samuel");
//        client.setGender("Male");
//        client.setLastName("Daniel");
//        client.setPassword("1234");
//        client.setPhoneNumber("514-430-8730");
//        client.setUserName("pradeep samuel");
//        client.setUserAddress(address);
//        client.setAge(23);
//        
//        Account account = new Account(1200, client);
//        account.setAccountNumber("345662636251673");
//        account.setCurrency("CAD");
//        account.setCurrencySign("$");
//        account.setOpenedDate(new DateTime());
//        account.setStatus(Account.AccountStatus.ACTIVE);
//        
//        account.saveAccount();
//        
//        ArrayList<Account> accounts = new ArrayList();
//        accounts.add(account);
//        
//        client.setAccounts(accounts);
//        client.saveUser();
            
            
//        Client cl = new Client();
//        cl.setFirstName("FirstName2");
//        cl.setLastName("LastName2");
//        cl.setAge(99);
//        cl.setEmail("a@b.com");
//        cl.setGender("Male");
//        cl.setUserName("01234567890");
//        cl.setPassword("1234");
//        cl.setPhoneNumber("514-000-9999");
//
////       
//        ChequingAccount ca = new ChequingAccount();
//        ca.setAccountNumber("Check002");
//        ca.setBalance(50000);
//        ca.setOpenedDate(DateTime.now());
//        ca.setClient(cl);
//
//        SavingAccount sa = new SavingAccount();
//        sa.setAccountNumber("Check002");
//        sa.setBalance(50000);
//        sa.setOpenedDate(DateTime.now());
//        sa.setClient(cl);
////
//        List<Account> accounts = new ArrayList<Account>();
//        accounts.add(sa);
//        accounts.add(ca);
////
//        Address address = new Address();
//        address.setApartmentNumber("1502");
//        address.setCity("Montreal");
//        address.setCountry("Canada");
//        address.setPostalCode("H3H 2J2");
//        address.setProvince("Quebec");
//        address.setStreetName("Rue St.Mathieu");
//        address.setStreetNumber("2055");
//        address.saveAddress();
////        
//        Client client = new Client();
//        client.setEmail("pradeep.samuel90@gmail.com");
//        client.setFirstName("Pradeep Samuel");
//        client.setGender("Male");
//        client.setLastName("Daniel");
//        client.setPassword("1234");
//        client.setPhoneNumber("514-430-8730");
//        client.setUserName("pradeep samuel");
//        client.setUserAddress(null);
//        client.setAge(23);
//        client.saveUser();
////       
//        Account account = new Account(1200, client);
//        account.setAccountNumber("345662636251673");
//        account.setCurrency("CAD");
//        account.setCurrencySign("$");
//        account.setOpenedDate(new DateTime());
//        account.setStatus(Account.AccountStatus.ACTIVE);
//        account.saveAccount();
//        
//        client.setAccounts(accounts);
//        client.saveUser();
//        ChequingAccount ca = ChequingAccount.getCheckingAccountById(2);
//        Transaction tr=new Transaction();
//        tr.setDebit(50);
//        tr.setDescription("Withdrwal of $50");
//        tr.setFormattedDebit("$50");
//        tr.setSourceAccount(ca);
//        tr.setTransactionTime(DateTime.now());
//        tr.saveTransaction();
//        ca.updateAccount();
        
//        CreditAccount cAcc = new CreditAccount();
////        long  temp=145648;
//        cAcc.setAccountId(null);
//        cAcc.setAvailableCredit(555);
//        cAcc.setBalance(6000);
//        cAcc.setCVS(588);
//        cAcc.setClient(client);
//        cAcc.setCreditLimit(2000);
//        cAcc.setExpiryDate(null);
//        cAcc.setOpenedDate(DateTime.now());
//        cAcc.setStatus(Account.AccountStatus.ACTIVE);
//        cAcc.setCurrencySign("$");
//        cAcc.setCurrency("Can");
//        cAcc.saveAccount();
        
//        List<CreditAccount> accounts1 = new ArrayList<CreditAccount>();
//        accounts1.add(cAcc);
//        
//        CreditPlan cp=new CreditPlan();
//        cp.setCreditAccounts(accounts1);
//        cp.setCashAdvanceInterest(1);
//        cp.setInterestRate(0.5);
//        cp.saveCreditPlan();
        
//        Client c = Client.getClientsById(1);
//        ClientCard cCard= new ClientCard("12-AA-56", DateTime.now(),c);
//        cCard.saveClientCard();
            
            
            
            
//        Client client = Client.getClientByUserName("12-AA-56");
//        ArrayList<Account> allAccounts = Account.getAllClientAccounts(client.getUserId());
//        System.out.println("=====>" + allAccounts);
        
//        Client cl2= Client.getClientsById(1);
//        if (cl2 == null)
//            System.out.println("Client is null");
//
//        
//        ChequingAccount ca = ChequingAccount.getCheckingAccountById(1);
//        SavingAccount sa = SavingAccount.getSavingAccountById(2);
//
////     
//        if (sa == null)
//            System.out.println("Saving is null");
//        if (ca == null)
//            System.out.println("Chequing is null");
//        else{
//            System.out.println("Before: Chequing Balance = " + ca.getBalance());
//             System.out.println("Before: Saving Balance = " + sa.getBalance());
//             Account.transfer(ca, sa, 1000, "Paying my load");
//             System.out.println("After: Chequing Balance = " + ca.getBalance());
//             System.out.println("After: Saving Balance = " + sa.getBalance());
//        } 
//        
       
         ChequingAccount ca = ChequingAccount.getCheckingAccountById(51);
         SavingAccount sa = SavingAccount.getSavingAccountById(52);
         
         ca.withdraw(1600, "1600 from ca");
         
    }
}
