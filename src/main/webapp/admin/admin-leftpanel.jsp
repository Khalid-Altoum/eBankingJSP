<%-- 
    Document   : admin_leftPanel
    Created on : Apr 27, 2014, 11:57:54 AM
    Author     : Hongrui Guan
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<fmt:setBundle basename="en"></fmt:setBundle>
<aside id="leftpannel">
    <div id="leftpanel">
        <div id='cssmenu'>
            <ul>
                <li><a href="adminConsole.jsp">
                        <table>
                            <tr>
                                
                                <td><span class="menu_link">Home</span></td>
                            </tr>
                        </table>
                    </a>
                </li>
                <li><a href="register.jsp">
                        <table>
                            <tr>
                                
                                <td><span class="menu_link">Register New Client</span></td>
                            </tr>
                        </table>
                    </a>
                </li>
                <li><a href="addAccount.jsp">
                        <table>
                            <tr>
                               
                                <td><span class="menu_link">New Bank Account</span></td>
                            </tr>
                        </table>
                    </a>
                </li>
                <li><a href="newInvestment.jsp">
                        <table>
                            <tr>
                                
                                <td><span class="menu_link">New Investment Plan</span></td>
                            </tr>
                        </table>
                    </a>
                </li>            
                <li><a href="addInvestment.jsp">					            
                        <table>
                            <tr>
                                
                                <td><span class="menu_link">Investment for Client</span></td>
                            </tr>
                        </table>
                    </a>
                </li> 
            </ul>
        </div>
    </div>
</aside>