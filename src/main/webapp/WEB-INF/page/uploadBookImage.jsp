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

    <div class="w740 right">
        <div class="o-mt">
            <h2>图片上传</h2>
        </div>
        <div class="order02 pb10">
            <form enctype="multipart/form-data" action="uploadImage" method="post">
                <table width="738" align="center" cellpadding="0" cellspacing="0">
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">图片</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <input type="file" name="img" class="input w300"/><span class="required">*</span>
                            <input type="hidden" name="bookId" value="${param.bookId}" class="input w300"/>
                        </td>
                    </tr>
                </table>

                <table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10" align="center">
                    <tr>
                        <td width="20%" align="center" class="bd2"></td>
                        <td width="80%" align="left" class="pl9" >
                            <input type="submit" value="确定" class="btn"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
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
