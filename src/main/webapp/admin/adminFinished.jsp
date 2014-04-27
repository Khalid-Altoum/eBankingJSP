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
    </head>
    <body>

        <div id="content">
            <div id="header-container">
                <jsp:include page="../site-header.jsp"/>
            </div>
            <div id="contenttext">
                <div class="bodytext">
                    <span class="largeredtext">Admin Operation Finished</span>
                    <p></p>
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