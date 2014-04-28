/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.run;

import com.soen.ebanking.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Khalid
 */
public class Testing01 {

    public static void main(String[] args) {
     
//        Client cl = new Client();
//        cl.setFirstName("Khalid");
//        cl.setLastName("Altoum");
//        cl.setAge(34);
//        cl.setEmail("peyman@gmail.com");
//        cl.setGender("Male");
//        cl.setUserName("123456789");
//        cl.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");
//        cl.setPhoneNumber("514-999-0000");
//        //cl.setClientCard(new ClientCard("12-34-56", DateTime.now(),cl));
//        cl.saveUser();
////
//        ChequingAccount ca = new ChequingAccount();
//        ca.setAccountNumber("105522446055");
//        ca.setBalance(5000);
//        ca.setOpenedDate(new Date());
//        ca.setClient(cl);
//        ca.saveAccount();
////        
////        
//         SavingAccount sa = new SavingAccount();
//        sa.setAccountNumber("450000000002");
//        sa.setBalance(1000);
//        sa.setOpenedDate(new Date());
//        sa.setClient(cl);
//        sa.saveAccount();
////        
//         List<Account> accounts = new ArrayList<Account>();
//        accounts.add(sa);
//        accounts.add(ca);
//        cl.setAccounts(accounts);
//        cl.updateUser();
//        
//         Client cl1 = Client.getClientsById(1);
//        EWallet ew = new EWallet();
//        ew.setAccountNumber("eWallet");
//        ew.setClient(cl1);
//        ew.saveAccount();
//        
//        
//        Client cl2 = Client.getClientsById(1);
//        EWallet ewalletForClient = Account.getEwalletForClient(cl2);
//        System.out.println(ewalletForClient.getBalance());
        
        
        
         Admin admin = new Admin();
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setEmail("peyman@gmail.com");
        admin.setGender("Male");
        admin.setUserName("admin");
        admin.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");
        admin.setPhoneNumber("514-999-0000");
        //cl.setClientCard(new ClientCard("12-34-56", DateTime.now(),cl));
        admin.saveUser();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
