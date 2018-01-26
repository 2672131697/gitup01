
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

    <div class="w740 right">
        <div class="o-mt">
            <h2>书籍修改</h2>
        </div>
        <div class="order02 pb10">
            <f:form action="doEditBook" method="post" modelAttribute="b" enctype="multipart/form-data">
                <table width="738" align="center" cellpadding="0" cellspacing="0">
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">书名</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <f:input path="bookName" cssClass="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">类别</td>
                        <td width="80%"  align="left" class="bd1 pl9">

                            <f:select path="categoryId" cssStyle="width:305px;">
                                <f:option value="">--请选择--</f:option>
                                <f:options items="${bookCategoryList}" itemValue="categoryId" itemLabel="categoryName"></f:options>
                            </f:select>
                            <span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">作者</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <f:input path="bookAuthor"  cssClass="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">价格</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <f:input path="bookPrice" cssClass="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">出版社</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <f:input path="bookPress" cssClass="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">库存</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <f:input path="kucun"  cssClass="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2" >封面</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <input type="file" name="img" class="input w300">
                            <c:if test="${b.cover!=null}">
                                <img alt="" style="width: 30px;height: 30px" src="open?fileId=${b.cover}"></img>
                            </c:if>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">简介</td>
                        <td width="80%"  align="left" class="bd1 pl9" rowspan="3">
                            <f:textarea path="remark" rows="6" id="" cssClass="w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="">
                        <th width="20%" align="center" class="bd2"></td>
                    </tr>
                    <tr class="">
                        <th width="20%" align="center" class="bd2"></td>
                    </tr>
                </table>

                <table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10" align="center">
                    <tr>
                        <td width="20%" align="center" class="bd2"></td>
                        <td width="80%" align="left" class="pl9" >
                            <f:hidden path="bookId"/>
                            <input type="submit" value="确定" class="btn"/>
                        </td>
                    </tr>
                </table>
            </f:form>
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
