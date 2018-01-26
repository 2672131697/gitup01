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
<div class="logoin_wrap mt30">
    <h2>用户注册</h2>
    <div id="table">
        <form>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr><td height="30px"></td></tr>
            </table>
            <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="44%" align="right" valign="middle" class="f14">用户名：</td>
                    <td width="56%" align="left" valign="middle">
                        <input type="text" name="" value="" id="a" class="input w180">
                    </td>
                </tr>
            </table>
            <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="44%" align="right" valign="middle" class="f14">密&nbsp;&nbsp;码：</td>
                    <td width="56%" align="left" valign="middle">
                        <input type="password" name="" value="" id="" class="input w180">
                    </td>
                </tr>
            </table>

            <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="44%" align="right" valign="middle" class="f14"></td>
                    <td width="56%" align="left" valign="middle">
                        <!-- 图片按钮，与type=submit按钮的效果是一样，也可以用来提交表单 -->
                        <input type="image" src="images/admin_zc.png" />
                    </td>
                </tr>
            </table>

            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr><td>&nbsp;</td></tr>
            </table>
        </form>
    </div>
</div>
<!--end content-->

<!--footer-->

<div id="footer_wrap">
    <p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

<!--end footer-->
</body>
</html>
