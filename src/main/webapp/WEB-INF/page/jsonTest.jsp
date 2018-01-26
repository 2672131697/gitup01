<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <script>
        //请求的是Json 输出的也是Json
        function requestJson() {

            $.ajax({
               type:'post',
               url:'requestJson',
               contentType:'application/json;charset=utf-8',
               data:'{"bookName":"一个人","bookAuthor":"少年","bookPrice":"88.8","shoppingCar.quantity":"200"}',
               success:function (data) {  //返回Json结果
                   alert(data);
               }

            });

                /*alert("请求的是Json 输出的也是Json");*/

        }

        //请求的是key/value 输出的也是Json
        function responseJson() {

            $.ajax({
               type:'post',
                url:'responseJson',
                data:{bookName:"两个人",bookAuthor:"小少年","shoppingCar.quantity":200},
                success:function (data) {
                    alert(data);
                }

            });
           //alert("请求的是key/value 输出的也是Json");
        }

    </script>
</head>

<body>

<input type="button" value="请求的是Json 输出的也是Json" onclick="requestJson()"/>
<input type="button" value="请求的是key/value 输出的也是Json" onclick="responseJson()"/>
</body>
</html>
