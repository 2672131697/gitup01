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

<!--content-->
<div class="w960 mt10">
    <div class="breadcrumb"></div>
</div>

<div class="w960">
    <%@include file="/common/left.jsp"%>

    <c:if test="${orderList==null}">
        <jsp:forward page="/listOrder?orderStatus=1"/>
    </c:if>
    <div class="w740 right">
        <div class="o-mt">
            <h2>已发货订单</h2>
        </div>
        <div class="order01">
            <form name="" method="post" action="">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
                    <tr>
                        <td width="15%" align="right">收货人电话：</td>
                        <td width="15%">
                            <input type="text" name="" value="" class="w110 input">
                        </td>
                        <td width="15%" align="right"></td>
                        <td width="15%">
                            <input type="image" name="imageField2" src="images/btn_cx.png" />
                        </td>
                        <td width="15%" align="right"></td>
                        <td width="25%"></td>
                    </tr>
                </table>
            </form>
        </div>

        <div class="order02">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <th width="10%" class="bd2">下单日期</th>
                    <th width="15%" class="bd2">收货人</th>
                    <th width="15%" class="bd2">收货人电话</th>
                    <th width="15%" class="bd2">收货人邮编</th>
                    <th width="15%" class="bd2">收货人地址</th>
                    <th width="10%" class="bd2">发货方式</th>
                    <th width="10%" class="bd2">订单总价</th>
                    <th width="10%" class="bd2">操作</th>
                </tr>


          <c:forEach  items="${orderList}" var="v">
                <tr>
                    <td width="10%" class="text">${v.maketime}</td>
                    <td width="15%" class="text">${v.orderAddress.receiver}</td>
                    <td width="15%" class="text">${v.orderAddress.phone}</td>
                    <td width="15%" class="text">${v.orderAddress.postcode}</td>
                    <td width="15%" class="text">${v.orderAddress.addressName}</td>
                    <td width="10%" class="text">${v.orderAddress.fhfs}</td>
                    <td width="10%" class="text">￥${v.ddzj}元</td>
                    <td width="10%" class="text">
                    </td>
                </tr>
          </c:forEach>

            </table>
        </div>

        <!-- page -->
        <div style="text-align: right;">
            每页 5 行 共 1 行 第 1 页 共 1 页 <a href='javascript:gotoPage(1)'>首页</a> <a href='javascript:gotoPage(1)'>上一页</a> <a href='javascript:gotoPage(1)'>下一页</a> <a href='javascript:gotoPage(1)'>尾页</a> 页数 <input type='text' id='pageNumber'  style='width:20px;' /> <a href='javascript:jumpPage()'>GO</a>
        </div>
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
