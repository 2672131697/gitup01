<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!empty sessionScope.message}">
    <script>
        var message="${sessionScope.message}";
        function showMessage(){
            alert(message);
        }
        window.onload=showMessage;
    </script>
    <c:remove var="message" scope="session"/>
</c:if>
