<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="/common/head.jsp"%>
</head>
<script>

    //加入购物车
    function addCar(bookId){

        var userId=${u.userId};
        /*alert(userId);
        alert(bookId)*/
        $.ajax({
            type:"post",
            url:"addCar",
            data:{bookId:bookId,userId:userId,quantity:1},
            success:function () {
                alert("加入成功")
            }
        });
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
        <div class="order02 pb10">
            <c:forEach items="${bookList}" var="v">
            <dl class="findbook">
                <dt class="left"><img src="open?fileId=${v.cover}" /></dt>
                <dd class="right">
                    <h4>${v.bookName}</h4>
                    <p><strong>作者：</strong>${v.bookAuthor}</p>
                    <p><strong>价格：</strong>￥${v.bookPrice}</p>
                    <p><strong>出版社：</strong>${v.bookPress}</p>
                    <p><strong>书籍简介：</strong>${v.remark}</p>
                    <p class="mt10"><a href="javascript:addCar(${v.bookId})"><img src="images/btn_shopping.png" /></a><a href="jieShuBook?bookIds=${v.bookId}&userId=${u.userId}"><img src="images/btn_accounts.png" /></a> </p>
                </dd>
                <div class="fixed"></div>
            </dl>
            </c:forEach>
        </div>

        <!-- page -->
        <div style="text-align: right;">
            每页 5 行 共 9 行 第 1 页 共 2 页 <a href='javascript:gotoPage(1)'>首页</a> <a href='javascript:gotoPage(1)'>上一页</a> <a href='javascript:gotoPage(2)'>下一页</a> <a href='javascript:gotoPage(2)'>尾页</a> 页数 <input type='text' id='pageNumber'  style='width:20px;' /> <a href='javascript:jumpPage()'>GO</a>
        </div>
        <!-- end page -->

    </div>
    <div class="fixed"></div>
</div>
<!--end con-->
<!--end con-->

<!--footer-->

<div id="footer_wrap">
    <p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

<!--end footer-->
</body>
</html>
