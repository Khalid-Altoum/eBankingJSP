<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<fmt:setBundle basename="en"></fmt:setBundle>
<aside id="leftpannel">
    <div id="leftpanel">
      <div id='cssmenu'>
        <ul>
          <li><a href="home.jsp">
            <table>
                <tr>
                    <td>
                    <embed src="./images/show_balance.svg" width="25px" height="25px"></embed>
                  </td>
                <td><span class="menu_link">My Accounts</span></td>
              </tr>
            </table>
            </a></li>
          <li><a href="deposit.jsp">
            <table>
              <tr>
                <td>
                    <embed src="./images/deposit_money.svg" width="25px" height="25px"></embed>
             </td>
                <td><span class="menu_link">Deposit Money</span></td>
              </tr>
            </table>
            </a></li>
          <li><a href="withdraw.jsp">
            <table>
              <tr>
                <td>
                    <embed src="./images/withdraw_money.svg" width="25px" height="25px"></embed>
                  </td>
                <td><span class="menu_link">Withdraw Money</span></td>
              </tr>
            </table>
            </a></li>            
          <li><a href="transfer.jsp">					            
            <table>
              <tr>
                <td>
                    <embed src="./images/transfer_money.svg" width="25px" height="25px"></embed>
                  </td>
                <td><span class="menu_link">Make A Transfer</span></td>
              </tr>
            </table>
            </a></li>
          <li><a href="payments.jsp">					            
            <table>
              <tr>
                <td>
                    <img src="./images/payment.png" width="25px" height="25px"></img>
                  </td>
                <td><span class="menu_link">Make A Payment</span></td>
              </tr>
            </table>
            </a></li>
          <li><a href="payeeList.jsp">					            
            <table>
              <tr>
                <td>
                    <img src="./images/payee.png" width="25px" height="25px"></img>
                  </td>
                <td><span class="menu_link">Manage Payee</span></td>
              </tr>
            </table>
            </a></li> 
          <li><a href="investmentList.jsp">					            
            <table>
              <tr>
                <td>
                    <img src="./images/investment.png" width="25px" height="25px"></img>
                  </td>
                <td><span class="menu_link">Investments</span></td>
              </tr>
            </table>
            </a></li>                       
          <li><a href="showProfile.jsp">					            
            <table>
              <tr>
                <td>
                    <embed src="./images/customer_male.svg" width="25px" height="25px"></embed>
                 </td>
                <td><span class="menu_link">My Profile</span></td>
              </tr>
            </table>
            </a></li>
        </ul>
      </div>
    </div>
</aside>