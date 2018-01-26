<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="/common/head.jsp"%>
</head>


<script>
  $(function () {
  var money=0;
  $("input[name='money']").each(function () {
  money=money+parseFloat($(this).val());
  });
  $("#tt").html(money+"元");
  });


  function jieShuBook() {
      alert(666);
  }
</script>
<body>
<!--top-->
<%@include file="/common/top.jsp"%>
<!--end nav-->

<!--end top-->

<!--con-->
<div class="w960 mt10">
    <c:import url="category.jsp"/>
    <div class="w740 right">
        <div class="order02">
            <form action="jieShuBook" method="post" name="form1">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <th width="20%" class="bd2">书名</th>
                    <th width="20%" class="bd2">单价</th>
                    <th width="20%" class="bd2">数量</th>
                    <th width="20%" class="bd2">小计</th>
                    <th width="20%" class="bd2">操作</th>
                </tr>

                <c:if test="${shoppingCarList==null}">

                    <jsp:forward page="/listShoppCar?userId=${u.userId}"/>
                </c:if>


                <c:forEach items="${shoppingCarList}" var="v">
                <tr>
                    <input type="hidden" name="bookIds" value="${v.bookId}">
                    <input type="hidden" name="money" value="<fmt:formatNumber type="number" value="${v.quantity*v.books.bookPrice}" pattern="0.0"/>">
                    <td width="20%" class="text">${v.books.bookName}</td>
                    <td width="20%" class="text">${v.books.bookPrice}元</td>
                    <td width="20%" class="text">
                        <input class="input" style="width: 50px;text-align: center;" type="text" id="a" value="${v.quantity}">
                    </td>
                    <td width="20%" class="text"><fmt:formatNumber type="number" value="${v.quantity*v.books.bookPrice}" pattern="0.0"/>元</td>
                    <td width="20%" class="text">
                        <a href="#">删除</a>
                        <a href="#">更新</a>
                    </td>
                </tr>
                </c:forEach>
            </table>

            <table width="100%" border="0" cellspacing="0" cellpadding="0"  class="bd2">
                <tr bgcolor="#fefcea">
                    <td width="80%" align="right"><strong>订单总价：</strong></td>
                    <td width="20%" align="left"><strong><span class="STYLE1" id="tt"></span></strong></td>
                </tr>
            </table>
            <table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10">
                <tr>
                    <td width="5%" align="center" ></td>
                    <td width="30%" align="center" >
                        <a href="#"><img src="images/btn_shoppingcart.png"/></a>
                    </td>
                    <td width="30%" align="center" >
                        <a href="#"><img src="images/btn_jxgm.png"/></a>
                    </td>
                    <td width="30%" align="center">
                        <input type="hidden" name="userId" value="${u.userId}"/>
                        <input type="hidden" name="forward" value="car"/>
                        <a href="javascript:document.form1.submit();"><img src="images/btn_accounts.png"/></a>
                    </td>
                    <td width="5%"></td>
                </tr>
            </table>
            </form>
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
