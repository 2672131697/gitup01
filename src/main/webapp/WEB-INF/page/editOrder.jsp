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
        <div class="o-mt">
            <h2>订单收货地址新增</h2>
        </div>
        <div class="order02 pb10">
            <f:form action="editOrderAddress" method="post" modelAttribute="loadOrderAddress">
                <table width="738" align="center" cellpadding="0" cellspacing="0">
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <f:input path="receiver" cssClass="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人电话</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <f:input path="phone" cssClass="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人邮编</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <f:input path="postcode" cssClass="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人地址</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <f:input path="addressName" cssClass="input w300"/><span class="required">*</span>
                        </td>
                    </tr>

                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">发货方式</td>
                        <td width="80%"  align="left" class="bd1 pl9">
                            <select name="fhfs"  style="width:305px;"><option value="">--请选择--</option>
                                <option <c:if test="${loadOrderAddress.fhfs=='平邮'}">selected</c:if> value="平邮">平邮</option>
                                <option <c:if test="${loadOrderAddress.fhfs=='快递'}">selected</c:if> value="快递">快递</option>
                            </select>
                            <span class="required">*</span>
                        </td>
                    </tr>
                </table>

                <table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10" align="center">
                    <tr>
                        <td width="20%" align="center" class="bd2"></td>
                        <td width="80%" align="left" class="pl9" >
                            <f:hidden path="userId"/>
                            <f:hidden path="addressId"/>
                            <input type="submit" value="确定" class="btn"/>
                        </td>
                    </tr>
                </table>
            </f:form>
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
