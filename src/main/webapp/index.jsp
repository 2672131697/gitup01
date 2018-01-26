
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<%=System.currentTimeMillis()%>
<jsp:forward page="/toLogin"/>
</body>
</html>
