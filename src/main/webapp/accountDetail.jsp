<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.soen.ebanking.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Account Details</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <jsp:useBean id="account" class="com.soen.ebanking.model.Account" scope="page" ></jsp:useBean>
        <% 
            String accountNumber =(String) request.getParameter("account");
            if (request.getParameter("account") != null) { 
            account = Account.getAccountByAccountNumber(accountNumber);   
        }%>
              
        <div id="content">
            <div id="header-container">
                <jsp:include page="./site-header.jsp"/>
            </div>
            <div id="contenttext">
                <div class="bodytext">
                   
                        <fieldset class="fieldallign">
                            <legend>
                                <h2 class="titletext">Account Summary</h2>
                            </legend>
                            <table align="center">
                                <tr>
                                    <th>Account No:</th>
                                    <td><b><%= account.getAccountNumber() %></b></td>
                                </tr>
                                <tr>
                                    <th>Account Type:</th>
                                    <td><b><%= account.getClass().getSimpleName() %></b></td>
                                </tr>
                                <tr>
                                    <th>Account Balance:</th>
                                    <td>$
                                        <b><%= account.getBalance()%></b></td>
                                </tr>
                                <tr>
                                    <th>Available Funds:</th>
                                    <td>$
                                        <b><%= account.getBalance() %></b></td>
                                </tr>
                                
                            </table>
                        </fieldset>
                    
                        <% List<AccountTransaction> transactions =  AccountTransaction.getAccountTransactions(accountNumber); %>
                        <fieldset  class="fieldallign">
                            <legend>
                                <h2 class="titletext">Transaction History</h2>
                            </legend>
                           
                            <table rules="rows" class="historystyle">
                                <tr>
                                    <th>Date</th>
                                    <th width="400px">Description</th>
                                    <th width="250px">Debit</th>
                                    <th width="250px">Credit</th>
                                </tr>
                              <%  for (AccountTransaction transaction: transactions) { %>
                                <tr>
                                    <td ><%= transaction.getFormattedTransactionTime()%></td>
                                    <td align="left"><%= transaction.getDescription()%></td>
                                    <td align="center"><%= transaction.getFormattedDebit()%></td>
                                    <td align="center"><%= transaction.getFormattedCredit() %></td>
                                </tr>
                                <% } %> 
                            </table>
                        </fieldset>
                     
                </div>
            </div>
            <div id="leftpanel-container">
                <jsp:include page="./site-leftpanel.jsp"/>
            </div>
            <div id="footer-container">
                <jsp:include page="./site-footer.jsp"/>
            </div>
        </div>
    </body>
</html>