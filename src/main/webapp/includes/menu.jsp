<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="cg-menu-bar">
    <a href="index">Home</a>

    <div class="cg-menu-right"><a href="disconnect"><s:property value="#session['user'].pseudo"></s:property></a></div>
</div>