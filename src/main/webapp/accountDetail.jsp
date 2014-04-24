<%@page import="com.soen.ebanking.model.Account"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Account Details</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <jsp:useBean id="account" class="com.soen.ebanking.model.Account"></jsp:useBean>
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
                    <form name="accountDetails" action="#" method="get">
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
                                <tr>
                                    <td></td>
                                     
                                </tr>
                            </table>
                        </fieldset>
                    </form>
                    <form name="transactionHistory" id="transactionHistory" action="#" method="get">
                        <fieldset  class="fieldallign">
                            <legend>
                                <h2 class="titletext">Transaction History</h2>
                            </legend>
                            <p>
                                <h4>Select:
                                    <select>
                                        <option value="One">1 Month</option>
                                        <option value="Two">2 Month</option>
                                        <option value="Three">3 Month</option>
                                    </select>
                                </h4>
                            </p>
                            <table rules="rows" class="historystyle">
                                <tr>
                                    <th>Ref#</th>
                                    <th>Transaction Date</th>
                                    <th>Amount</th>
                                    <th>Description</th>
                                </tr>
                                <tr>
                                    <td>0001</td>
                                    <td>Mar.11, 2014</td>
                                    <td>$100.00</td>
                                    <td>Withdraw</td>
                                </tr>
                                <tr>
                                    <td>0001</td>
                                    <td>Mar.11, 2014</td>
                                    <td>$100.00</td>
                                    <td>Withdraw</td>
                                </tr>
                                <tr>
                                    <td>0001</td>
                                    <td>Mar.11, 2014</td>
                                    <td>$100.00</td>
                                    <td>Withdraw</td>
                                </tr>
                                <tr>
                                    <td>0001</td>
                                    <td>Mar.11, 2014</td>
                                    <td>$100.00</td>
                                    <td>Withdraw</td>
                                </tr>
                                <tr>
                                    <td>0001</td>
                                    <td>Mar.11, 2014</td>
                                    <td>$100.00</td>
                                    <td>Withdraw</td>
                                </tr>
                                <tr>
                                    <td>0001</td>
                                    <td>Mar.11, 2014</td>
                                    <td>$100.00</td>
                                    <td>Withdraw</td>
                                </tr>
                            </table>
                        </fieldset>
                    </form>
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