<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<%@include file="/common/showMessage.jsp"%>
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
    <c:if test="${bookList==null}">
        <jsp:forward page="/listBook?forward=listBook2&bookStatus=1"/>
    </c:if>
    <div class="w740 right">
        <div class="o-mt">
            <h2>已上架书籍</h2>
        </div>
        <div class="order01">
            <form name="" method="post" action="">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
                    <tr>
                        <td width="15%" align="right">书名：</td>
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
                    <th width="15%" class="bd2">书名</th>
                    <th width="15%" class="bd2">作者</th>
                    <th width="15%" class="bd2">价格</th>
                    <th width="25%" class="bd2">出版社</th>
                    <th width="30%" class="bd2">操作</th>
                </tr>
               <c:forEach items="${bookList}" var="v">
                <tr>
                    <td width="15%" class="text">${v.bookName}</td>
                    <td width="15%" class="text">${v.bookAuthor}</td>
                    <td width="15%" class="text">${v.bookPrice}元</td>
                    <td width="25%" class="text">${v.bookPress}</td>
                    <td width="30%" class="text"><a href="doXj?bookId=${v.bookId}">下架</a></td>
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
