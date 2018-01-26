<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="format-detection" content="telephone=no" />
    <meta name=""/>

    <link rel="stylesheet" href="css/tasp.css" />
    <link href="css/orderconfirm.css" rel="stylesheet" />
    <style>

        #hhh{
            display: inline;
        }
    </style>
</head>
<body data-spm="1">

<%@include file="/common/showMessage.jsp"%>
<div id="page">
    <p class="right"><a href="#"> 后台管理</a> | <a href="toLogin">退出系统</a> | <a href="input/index">网站首页</a></p>
    <div id="content" class="grid-c">

        <div id="address" class="address" style="margin-top: 20px;" data-spm="2">
                <h3>确认收货信息
                    <span class="manage-address">
 <a href="http://member1.taobao.com/member/fresh/deliver_address.htm" target="_blank" title="管理我的收货地址"
    class="J_MakePoint" data-point-url="http://log.mmstat.com/buy.1.7">管理收货地址 | </a>
 </span>
                </h3>
                <ul id="address-list" class="address-list">

                    <%--<c:if test="${orderAddressList==null||books==null}">
                        <jsp:forward page="/jieShuBook?bookIds=${param.bookId}&userId=${u.userId}"/>
                    </c:if>--%>

                    <c:forEach items="${orderAddressList}" var="v" varStatus="status">
                        收货方式${status.index+1}
                        <div style="width: 30%">
                                    收货人:${v.receiver}<br>
                                    收货地址:${v.addressName}<br>
                                    发货方式:${v.fhfs}
                                   <a href="toEditOrderAddress?addressId=${v.addressId}">修改信息</a>&nbsp;&nbsp;<a href="editMorenDiZhi?addressId=${v.addressId}&userId=${u.userId}">设为默认收货信息</a><br><br>
                                    <c:if test="${v.mraddress==1}"><font color="red">默认地址设置成功</font></c:if>
                            </table>
                        </div>
                        <hr>
                    </c:forEach>

                </ul>
                <ul id="J_MoreAddress" class="address-list hidden">

                </ul>

                <div class="address-bar">
                    <a href="toAddOrderAddress" class="new J_MakePoint" id="J_NewAddressBtn">使用新地址</a>
                </div>

                <hr>

        </div>
        <form action="addOrder" method="post" id="tmj">
        <div class="address-bar">
            支付方式:&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="payway"  value="支付宝">支付宝&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="payway"  value="微信">微信
        </div><br><br><br>
            <div>
                <h3 class="dib">确认订单信息</h3>
                <table  summary="统一下单订单信息区域">

                    <div class="w740 right">
                            <table width="100%" border="1" align="center">
                                <tr>
                                    <th style="text-align: center" width="20%" class="bd2">书名</th>
                                    <th style="text-align: center" width="20%" class="bd2">单价</th>
                                    <th style="text-align: center" width="20%" class="bd2">数量</th>
                                    <th style="text-align: center" width="20%" class="bd2">小计</th>
                                    <th style="text-align: center" width="20%" class="bd2">操作</th>
                                </tr>
                                <!--订单地址的ID-->
                                <input type="hidden" name="addressId" value="${oa.addressId}"/>
                                <!--用户的ID-->

                                <input type="hidden" name="userId" value="${u.userId}"/>
                                <c:forEach items="${books}" var="v" varStatus="status">
                                <tr>

                                    <!--订单的ID-->

                                    <!--书本的ID-->
                                    <input type="hidden" name="orderDetailList[${status.index}].bookId" value="${v.bookId}"/>

                                    <td width="20%" class="text">${v.bookName}</td>
                                    <td width="20%" class="text">${v.bookPrice}</td>
                                    <td width="20%" class="text">
                                        <input class="input" style="width: 50px;text-align: center;" type="text" name="orderDetailList[${status.index}].quantity" value="<c:if test="${v.shoppingCar.quantity==null}">1</c:if>${v.shoppingCar.quantity}">
                                    </td>
                                    <td width="20%" class="text">28.50</td>
                                    <td width="20%" class="text">
                                        <a href="#">删除</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </table>

                            <table width="100%" border="0" cellspacing="0" cellpadding="0"  class="bd2">
                                <tr bgcolor="#fefcea">
                                    <td width="80%" align="right"><strong>订单总价：</strong></td>
                                    <td width="20%" align="left"><strong><span class="STYLE1">53.30</span></strong></td>
                                </tr>
                            </table>
                    </div>
                    <tfoot>
                    <tr>
                        <td colspan="5">

                            <div class="order-go" data-spm="4">
                                <div class="J_AddressConfirm address-confirm">
                                    <div class="kd-popup pop-back" style="margin-bottom: 40px;">
                                        <div class="box">
                                            <div class="bd">
                                                <div class="point-in">

                                                    <em class="t">实付款：</em>  <span class='price g_price '>
 <span>&yen;</span><em class="style-large-bold-red"  id="J_ActualFee"  >630.00</em>
  </span>
                                                </div>

                                                <ul >
                                                    <li><em>寄送至:</em><span id="J_AddrConfirm" style="word-break: break-all;">
   ${oa.addressName}
   </span></li>
                                                    <li><em>收货人:</em><span id="J_AddrNameConfirm">${oa.receiver}</span></li>
                                                    <li><em>联系电话:</em><span id="J_AddrNameConfirm1">${oa.phone}</span></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <a href="#"
                                           class="back J_MakePoint" target="_top"
                                           data-point-url="">返回购物车</a>
                                        <button id="J_Go" type="submit" class=" btn-go"  data-point-url=""  tabindex="0" title="点击此按钮，提交订单。">提交订单<b class="dpl-button"></b></button>
                                    </div>
                                </div>

                                <div class="J_confirmError confirm-error">
                                    <div class="msg J_shopPointError" style="display: none;"><p class="error">积分点数必须为大于0的整数</p></div>
                                </div>


                                <div class="msg" style="clear: both;">
                                    <p class="tips naked" style="float:right;padding-right: 0">若价格变动，请在提交订单后联系卖家改价，并查看已买到的宝贝</p>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
    </div>
    </form>
    <div id="footer"></div>
</div>
<div style="text-align:center;">
</div>
</body>
</html>
