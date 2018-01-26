<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <%@include file="/common/head.jsp"%>
</head>
<body>
<!--top-->
<%@include file="/common/top.jsp"%>
<!--end nav-->

<!--end top-->

<!--con-->
<div class="w960 mt10">
    <c:import url="category.jsp"/>
    <div class="w740 right">
        <div class="main_div">
            <div class="banner left"><img src="images/banner.png" /></div>
            <div class="fixed"></div>
        </div>

        <div class="main_div mt10">
            <h2>
                <cite class="left">新书上架</cite>
                <div class="fixed"></div>
            </h2>

            <c:if test="${xshjListBook==null||xlListBookxl==null}">
                <jsp:forward page="/xshjListBook"/>
            </c:if>
            <ul class="arivals">

                <c:forEach items="${xshjListBook}" var="v">
                <li>
                    <a href="#"><img src="open?fileId=${v.cover}" /></a><p>${v.bookName}</p><p class="red">￥${v.bookPrice}元</p>
                </li>
                </c:forEach>

                <div class="fixed"></div>
            </ul>
        </div>

        <div class="main_div mt10">
            <h2>
                <cite class="left">热销图书</cite>
                <div class="fixed"></div>
            </h2>

            <ul class="arivals">
            <c:forEach items="${xlListBookxl}" var="v">
                <li>
                    <a href="#"><img src="open?fileId=${v.cover}" /></a><p>${v.bookName}</p><p class="red">￥${v.bookPrice}元</p>
                </li>

           </c:forEach>

                <div class="fixed"></div>
            </ul>
        </div>
    </div>
    <div class="fixed"></div>
</div>
<!--end con-->

<!--footer-->

<div id="footer_wrap">
    <p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

<!--end footer-->
</body>
</html>
