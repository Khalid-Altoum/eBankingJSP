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
        <div> <span class="largeredtext">eBanking Admin Account Locked!</span> </div>
      <div class="bodytext">
        <h3>Dear eBanking Admin:</h3>
        <p class="smallgraytext">For your security, access to online banking system has been locked due to the number of incorrect login attempts. </p>
        <p class="smallgraytext">At eBanking we care about your security so, for your protection we are proativity notifying this activity.</p>
        <p class="smallgraytext">Please contact us at <span style="background-color:#FF0"><a
			href="mailto:obs.inse620@gmail.com?Subject=Need%20Help" target="_top">obs.inse620@gmail.com</a></span> to unlock your account.</p>
      </div>
    </div>
    <div id="leftpanel">
      <div class="graypanel"> <span class="smalltitle">Remember!</span><br />
        <br />
        <span> You can try to <a href="/eBanking/admin/index.jsp">login</a> <strong>THREE</strong> times before your account being locked.</span><br />
      </div>
    <div id="footer-container"> <jsp:include page="../site-footer.jsp"/></div>
  </div>
</body>
</html>