<%--
  Created by IntelliJ IDEA.
  User: bozzz
  Date: 2018/3/9
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html><！--表示本页会使用html5的技术-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<head>
    <!-- 接着导入js和css
       Bootstrap需要JQuery才能正常工作，所以需要导入jquery.min.js
       接着是 Bootstrap的css，里面定义了各种样式
       最后是 Bootstrap的js，用于产生交互效果，比如关闭警告框
       注：顺序不要搞错了，否则有一些效果会出不来。
       首先是JQuery
       然后是Bootstrap css
       最后是Bootstrap js-->
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link href="css/back/style.css" rel="stylesheet">

    <script>
        //自定义的函数
        function checkEmpty(id,name) {
            var value=$("#"+id).val();
            if(value.length==0){
                alert(name+"不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }

        function checkNumber(id,name) {
            var value=$("#"+id).val();
            if(value.length==0){
                alert(name+"不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            if(isNaN(value)){
                alert(name+"必须是数字");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }

        function checkInt(id,name){
            var value=$("#"+id).val();
            if(value.length==0){
                alert(name+"不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            if(parseInt(value)!=value){
                alert(name+"必须是整数");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }

        $(function(){
            $("a").click(function(){
                var deleteLink=$(this).attr("deleteLink");
                console.log(deleteLink);
                if("true"==deleteLink){
                    var confimDelete=confirm("确认要删除");
                    //如果用户点击确定按钮，则 confirm() 返回 true。如果点击取消按钮，则 confirm() 返回 false。
                    if(confimDelete)
                        return true;//链接被传递
                    return false;
                }
            });
        });

    </script>

</head>
<body>
