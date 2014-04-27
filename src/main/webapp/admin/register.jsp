<%-- 
    Document   : register
    Created on : Apr 27, 2014, 11:04:08 AM
    Author     : Hongrui Guan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Admin Console</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="content">
            <div id="header-container">
                <jsp:include page="../site-header.jsp"/>
            </div>
            <div id="contenttext">
                <div class="bodytext">
                    <strong class="largeredtext">Register a New Client</strong>
                    <p></p>
                    <form name = "newClient" method = "post" action="/eBankingJSP/NewClientServlet">
                    <table>
                        <tr>
                            <td>First Name:</td>
                            <td>
                                <input name = "firstName" type="text" size="15">
                            </td>
                        </tr>
                        <tr>
                            <td>Last Name:</td>
                            <td>
                                <input name = "lastName" type="text" size="15">
                            </td>
                        </tr>
                        <tr>
                            <td>Gender:</td>
                            <td>
                                <select name="gender">
                                        <option value="" disabled="disabled" selected="selected">- Gender -</option>
                                        <option value="Male">Male</option>
                                        <option value="Female">Female</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Age:</td>
                            <td>
                                <input name = "age" type="text" size="15">
                            </td>
                        </tr>
                        <tr>
                            <td>Email Address:</td>
                            <td>
                                <input name = "email" type="text" size="15">
                            </td>
                        </tr>
                        <tr>
                            <td>Phone Number:</td>
                            <td>
                                <input name = "phoneNum" type="text" size="15">
                            </td>
                        </tr>
                        <tr>
                            <td>Apartment Number:</td>
                            <td>
                                <input name = "aptNum" type="text" size="15">
                            </td>
                        </tr>
                        <tr>
                            <td>Street Number:</td>
                            <td>
                                <input name = "streetNum" type="text" size="15">
                            </td>
                        </tr>
                        <tr>
                            <td>Street Name:</td>
                            <td>
                                <input name = "streetName" type="text" size="15">
                            </td>
                        </tr>
                        <tr>
                            <td>City:</td>
                            <td>
                                <input name = "city" type="text" size="15">
                            </td>
                        </tr>
                        <tr>
                            <td>Province:</td>
                            <td>
                                <select name="province">
                                        <option value="" disabled="disabled" selected="selected">- province -</option>
                                        <option value="QC">QC</option>
                                        <option value="ON">ON</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Country:</td>
                            <td>
                                <select name="country">
                                        <option value="" disabled="disabled" selected="selected">- country -</option>
                                        <option value="CA">CA</option>
                                        <option value="US">US</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Postal Code:</td>
                            <td>
                                <input name = "postCode" type="text" size="15" >
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button type="submit" name="submit">Submit</button>&nbsp;&nbsp;
                                <button type="reset" name="reset">Reset</button></td>
                        </tr>
                    </table>
                    </form>
                </div>
            </div>
             <div id="leftpannel-container">
                <jsp:include page="admin-leftpanel.jsp"/>
            </div>
            <div id="footer-container">
                <jsp:include page="../site-footer.jsp"/>
            </div>
        </div>
    </body>
</html>
