<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>CoreGeek</title>
  <s:include value="/includes/header.jspf"/>
</head>
<body>
  <s:include value="/includes/menu.jsp"/>
  <div>
    <h1>Core Geek</h1>

    Welcome <s:property value="user.pseudo"></s:property>
  </div>

<img src="file/user/user1.png" width="100px">
</body>
</html>
