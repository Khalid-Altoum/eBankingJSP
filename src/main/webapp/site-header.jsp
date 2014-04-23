<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    
        <%
            //java
String userName = (String)session.getAttribute("userName");
%>
    
<header id="header">
<div id="logo">
	<div class="headerlogotitle">
                        <strong>Online </strong> <strong>Banking </strong>
                        <p></p>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>System</strong>
	</div>
</div>   
<div id="topheader">

    <div class="authortext">
		<br />
		
	</div>
	<div id="toplinks">
		<a href="home.jsp">Home</a> | <a href="index.jsp">Logout</a> | <a
			href="mailto:obs.inse620@gmail.com?Subject=Need%20Help" target="_top">
			Contact Us</a>
	</div>
</div>
<div id="menu"></div>
<div id="submenu">
	
</div>

</header>