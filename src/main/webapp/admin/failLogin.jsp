<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="../css/style.css" type="text/css" />
<title>Error!</title>
</head>
<body>
  <div id="content">
    <div id="header-container">
      <jsp:include page="../site-header.jsp"/>
    </div>
    <br/>
    <div id="contenttext">
        <div> <span class="largeredtext"> Admin Login Error!</span> </div>
      <div class="bodytext">
        <h3>Please check your user id and password, and try again</h3>
        <p class="smallgraytext">You can try to <a href="/eBanking/admin/index.jsp">login</a> <strong>THREE</strong> times before your account being locked.</p>
      </div>
    </div>
    <div id="leftpanel">
      <div class="graypanel"> <span class="smalltitle">Remember!</span><br />
        <br />
        <span> You can try to <a href="/eBanking/admin/index.jsp">login</a> <strong>THREE</strong> times before your account being locked.</span><br />
      </div>
    </div>
    <div id="footer-container"> <jsp:include page="../site-footer.jsp"/></div>
  </div>
</body>
</html>