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
    <div class="side left">


        <!--nav-->
        <h4>我的订单</h4>
        <ul class="classify E6">
            <li>&nbsp;&nbsp;<a href="#1">未发货</a></li>
            <li>&nbsp;&nbsp;<a href="#">已发货</a></li>
            <li>&nbsp;&nbsp;<a href="#">已签收</a></li>
            <div class="fixed"></div>
        </ul>
        <!--end nav-->

    </div>

    <div class="w740 right">
        <div class="o-mt">
            <h2>已发货订单</h2>
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



                <tr>
                    <td width="10%" class="text">2014-11-27</td>
                    <td width="15%" class="text">张三</td>
                    <td width="15%" class="text">13312345678</td>
                    <td width="15%" class="text">021</td>
                    <td width="15%" class="text">北京</td>
                    <td width="10%" class="text">

                        平邮


                    </td>
                    <td width="10%" class="text">￥53.30</td>
                    <td width="10%" class="text">
                        <a href="#">签收</a>
                    </td>
                </tr>


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
