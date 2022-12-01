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
    <h1>Received messages</h1>
    <s:iterator step="1" var="i" value="messages">
      <s:property value="content"></s:property><br />
    </s:iterator>
  </div>
  <div>
    <h1>Core Geek</h1>

    Welcome <s:property value="user.pseudo"></s:property>
  </div>
  <div class="cg-container">
    <s:iterator step="1" var="i" value="users">
      <div class="cg-portrait">
        <div class="cg-portrait-content" style="background: url('file/<s:property value="image"></s:property>') no-repeat; background-position: top; background-size: cover">
        </div>
      </div>
    </s:iterator>
    <!--
    <div class="cg-portrait">
      <div class="cg-portrait-content" style="background: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSq9rBu2pG8XhDelxsJiXbbvNldYsFADH8LyGvzXtDtNQ&s') no-repeat; background-position: top; background-size: cover">
      </div>
    </div>
    <div class="cg-portrait">
      <div class="cg-portrait-content">content here</div>
    </div>
    <div class="cg-portrait">
      <div class="cg-portrait-content">content here</div>
    </div>
    <div class="cg-portrait">
      <div class="cg-portrait-content">content here</div>
    </div>
    -->
  </div>
</body>
</html>
