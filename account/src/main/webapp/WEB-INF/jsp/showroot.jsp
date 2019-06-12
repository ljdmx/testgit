<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>显示所有管理员页面</title>
    <!-- Bootstrap 主题 CSS 文件 -->
    <link rel="stylesheet" href="/account/public/Yeti/bootstrap.css">
    <!--<link rel="stylesheet" href="/public/Bootstrap3.3.7/css/bootstrap.css">-->
    <link rel="stylesheet" href="/account/public/Admin/Admin.css">
    <style type="text/css">
      #add{
      display:none;
     }
    </style>
</head>
<body>

<!--navbar navbar-inverse navbar-fixed-top-->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" >显示所有管理员页面</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">操作 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/account/root/toshow">返回</a></li>
						<li><a class="add" >添加</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>



<div class="container">

    <h2 class="page-header fonth2"></h2>


   

 <div class="jumbotron">
 
                		
	 <div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column">
		<c:if test="${fn:length(list) eq 0}">
	     <span>没有操作记录</span>
	    </c:if>
	    <c:if test="${fn:length(list) gt 0}">
			<table class="table">
				<thead>
				<tr>
			   <th>ID</th>
			   <th>管理员名</th>
			   <th>管理员密码</th>
			   <th>操作</th>
			   </tr>
				</thead>
				<tbody>
                 <c:forEach items="${list}" var="root">
				<tr class="success">
				   <td>${root.id}</td>
				   <td>${root.name}</td>
				   <td>${root.password}</td>
				   <td><a href="/account/root/delete/${root.id}" >删除</a></td>
				   </tr>
			 </c:forEach>
				</tbody>
			</table>
		  </c:if>
		</div>
		<div class="col-md-2 column">
		</div>
	</div>
	  <br>
	  <div class="row clearfix">
				<div class="col-md-3 column">
				</div>
				<div class="col-md-6 column" id="add">
				<h2>添加管理员</h2>
					<form role="form" action="/account/root/add">
						<div class="form-group">
							 <label for="exampleInputEmail1">管理员名</label><input type="text" name="name" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputPassword1">密码</label><input type="password" name="password" class="form-control" id="exampleInputPassword1" />
						</div>
						<button type="submit" class="btn btn-default">确定</button>
						 <button type="reset" class="btn btn-default">重置</button>
					</form>
				</div>
				<div class="col-md-3 column">
				</div>
			</div>
			
</div>

<hr>
<div class="show">
  <h3>
  <c:if test="${notadd==1}" var="true">
     <c:out value="添加失败"></c:out>
     </c:if>
 </h3>
</div>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/account/public/Common/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/account/public/Admin/bootstrap.min.js"></script>
<!-- 自定 JavaScript 文件 -->
<script src="/account/public/Admin/Admin.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".add").click(function(){
	    $("#add").css("display","block");
	  });
      $("body").click(function(){
  	    $(".show").css("display","none");
  	  });
});
</script>
</body>
</html>