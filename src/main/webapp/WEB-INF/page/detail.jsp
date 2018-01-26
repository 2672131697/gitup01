<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="/common/head.jsp"%>

    <script>
        $(function () {
            var money=0;
            $("input[name='money']").each(function () {
                money=money+parseFloat($(this).val());
            });
         $("#tt").html(money+"元");
        });

    </script>
</head>
<body>
<!--top-->
<%@include file="/common/top.jsp"%>
<!--end nav-->

<!--end top-->

<!--content-->
<div class="w960 mt10">
    <div class="breadcrumb"></div>
</div>

<div class="w960">
    <%@include file="/common/left.jsp"%>

    <div class="w740 right">
        <div class="o-mt">
            <h2>订单详情</h2>
        </div>
        <div class="order02">
        <table width="50%" border="0" cellspacing="0" cellpadding="0">
            <tr><td>&nbsp;订单&nbsp;ID:&nbsp;&nbsp;${o.orderId}</td></tr>
            <tr><td>&nbsp;下单时间:&nbsp;&nbsp;${o.maketime}</td></tr>
            <tr><td>&nbsp;订单状态:&nbsp;&nbsp;<c:if test="${o.orderStatus==0}">未发货</c:if><c:if test="${o.orderStatus==1}">已发货</c:if><c:if test="${o.orderStatus==2}">已签收</c:if></td></tr>
            <tr><td>&nbsp;下单用户:&nbsp;&nbsp;${o.user.userName}</td></tr>

            <tr><td>&nbsp;发货方式:&nbsp;&nbsp;${o.orderAddress.fhfs}</td></tr>
            <tr><td>&nbsp;&nbsp;收货人:&nbsp;&nbsp;${o.orderAddress.receiver}</td></tr>
            <tr><td>&nbsp;&nbsp;&nbsp;地址:&nbsp;&nbsp;${o.orderAddress.addressName}</td></tr>
            <tr><td>&nbsp;&nbsp;&nbsp;电话:&nbsp;&nbsp;${o.orderAddress.phone}</td></tr>
            <tr><td>&nbsp;&nbsp;&nbsp;邮编:&nbsp;&nbsp;${o.orderAddress.postcode}</td></tr>
        </table>
    </div>
        <div class="o-mt">
            <h2>订单明细</h2>
        </div>
        <div class="order02">
            <table width="50%" border="0" cellspacing="0" cellpadding="0">
                <th>书本名称</th>
                <th>书本价格</th>
                <th>书本数量</th>
                <th>小计</th>
                <c:forEach items="${o.orderDetailList}" var="v">
                    <tr>
                    <td style="text-align: center">${v.book.bookName}</td>
                    <td style="text-align: center">${v.book.bookPrice}</td>
                    <td style="text-align: center">${v.quantity}</td>
                    <td style="text-align: center"><fmt:formatNumber type="number" value="${v.quantity*v.book.bookPrice}" pattern="0.0"/>元</td>
                    <input type="hidden" name="money" value="<fmt:formatNumber type="number" value="${v.quantity*v.book.bookPrice}" pattern="0.0"/>">
                    </tr>
                </c:forEach>
                <tr><td colspan="3" style="text-align: right">总计:</td><td style="text-align: center" id="tt"></td></tr>
            </table>
        </div>

        <!-- page -->

        <!-- end page -->
    </div>
    <div class="fixed"></div>
</div>
<!--end content-->

<!--footer-->

<div id="footer_wrap">
    <p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

<!--end footer-->
</body>
</html>
