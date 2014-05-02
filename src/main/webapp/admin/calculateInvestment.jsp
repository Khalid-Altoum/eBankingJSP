<%-- 
    Document   : adminFinished
    Created on : Apr 27, 2014, 2:24:02 PM
    Author     : Hongrui Guan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Admin Console</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
         <link rel="stylesheet" href="../css/jquery-ui.css">
        <script src="../js/jquery-1.10.2.js"></script>
        <script src="../js/jquery-ui.js"></script>
        
    </head>
    <body>

        <div id="content">
            <div id="header-container">
                <jsp:include page="../site-header.jsp"/>
            </div>
            <div id="contenttext">
                <div class="bodytext">
                    <span class="largeredtext">Calculate Investment for all Clients </span>
                    <p><b>Dear Administrator:
                            Please Make sure that you want to Calculate Investment for All Clients.
                            This action can not be undo.</b>></p>
                    <br/>
                    <br/>
                    <form  method="post"  name = "calculateInvestment"  action="/eBanking/CalculateInvestmentServlet">
                        <script>
                            $(function() {
                                $("#datepicker").datepicker();
                            });

                        </script>


                        <table>
                            <tr>
                                <td>End Date:</td>
                                <td><input name="date" type="text" size="20" id="datepicker" ></td>
                            </tr>
                            <tr>
                                <td>    </td>
                            </tr>
                        </table> 
                        <div class="button big-btn">
                            <button type="submit" name="submit" >Calculate Investment for All Clients</button> 
                        </div>
                        <%
                            String successString = (session.getAttribute("successfulMSG99") != null) ? (String) session.getAttribute("successfulMSG99") : " ";
                            String errorString = (session.getAttribute("errorMSG99") != null) ? (String) session.getAttribute("errorMSG99") : " ";
                        %>      
                        <p style="font-style:italic;"> <b style="color:#00FF00"> <%= successString%>  </b></p>           
                        <p style="font-style:italic;"> <b style="color:#F00"> <%= errorString%> </b></p>
                    </form>
                    <%
                        session.removeAttribute("successfulMSG99");
                        session.removeAttribute("errorMSG99");
                    %>
                    <div class="bodytext">
                        <h3>Back to Admin Console <a href="adminConsole.jsp">Home</a></h3>
                    </div>

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