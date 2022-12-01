
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <s:include value="/includes/header.jspf"/>
</head>
<body>
<div class="cg-container">
    <h1>Welcome</h1>
    <s:form action="inscription" validate="true">
        <s:textfield label="Email" name="strutsEmail"></s:textfield>
        <s:textfield label="Pseudo" name="strutsPseudo"></s:textfield>
        <s:password label="Password" name="strutsPassword"></s:password>
        <s:hidden name="strutsAction" value="inscription"></s:hidden>
        <s:submit value="Inscription"></s:submit>
    </s:form>
</div>
</body>
</html>
