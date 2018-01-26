<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<div class="side left">
    <h3>图书分类</h3>
    <c:if test="${bookCategoryList1==null}">
        <jsp:forward page="/listBookCategory"/>
    </c:if>
    <ul class="classify bgf7e4e4 bdf7e4e4">

        <c:forEach items="${bookCategoryList1}" var="v">
            <li> <a href="listBookCategoryDeShu?categoryId=${v.categoryId}">${v.categoryName}</a></li>
        </c:forEach>
        <div class="fixed"></div>
    </ul>

</div>

</body>
</html>
