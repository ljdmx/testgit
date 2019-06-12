<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>所有用户贷款记录页面</title>
    <!-- Bootstrap 主题 CSS 文件 -->
    <link rel="stylesheet" href="/account/public/Yeti/bootstrap.css">
    <!--<link rel="stylesheet" href="/public/Bootstrap3.3.7/css/bootstrap.css">-->
    <link rel="stylesheet" href="/account/public/Admin/Admin.css">
    <style type="text/css">
      #select{
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
            <a class="navbar-brand" >所有用户贷款记录页面</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">操作 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/account/root/toshow">返回</a></li>
						<li><a class="select" >根据账户ID查找</a></li>
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
		<div class="col-md-1 column">
		</div>
		<div class="col-md-10 column">
		<c:if test="${fn:length(list) eq 0}">
	     <span>没有操作记录</span>
	    </c:if>
	    <c:if test="${fn:length(list) gt 0}">
			<table class="table">
				<thead>
				<tr>
			   <th>ID</th>
			   <th>账号ID</th>
			   <th>贷款金额</th>
			   <th>身份证号</th>
			   <th>申请时间</th>
			   <th>还款日期</th>
			   <th>电话号码</th>
			   <th>亲人电话号码</th>
			   <th>状态</th>
			   <th>同意操作</th>
			   <th>不同意操作</th>
			   <th>删除操作</th>
			   </tr>
				</thead>
				<tbody>
                 <c:forEach items="${list}" var="grant">
				<tr class="success">
				     <td id="accountid">${grant.id}</td>
					   <td>${grant.accountId}</td>
					   <td>${grant.money}</td>
					   <td>${grant.identityCard}</td>
					   <td>${grant.loanTime}</td>
					   <td>${grant.repaymentTime}</td>
					   <td>${grant.telephoneNumber}</td>
					   <td>${grant.familyTelephoneNumber}</td>
					   <td><c:if test="${grant.state==1}" var="true">
								   <c:out value="审核中"></c:out>
								   </c:if>
								   <c:if test="${grant.state==0}" var="true">
								   <c:out value="已同意"></c:out>
								   </c:if>
								   <c:if test="${grant.state==2}" var="true">
								   <c:out value="已同意"></c:out>
								   </c:if></td>
					   <td><a href="/account/grant/update/${grant.id}/${0}">同意</a></td>
					   <td><a href="/account/grant/update/${grant.id}/${2}">不同意</a></td>
					   <td><a href="/account/grant/delete/${grant.id}">删除</a></td>
				   </tr>
			 </c:forEach>
				</tbody>
			</table>
			<br>共<span>${totalRecord}</span>条记录&nbsp;&nbsp;共<span>${totalPage}</span>页&nbsp;&nbsp;当前第<span>${currentPage}</span>页&nbsp;&nbsp;
			  <a href="/account/grant/selectpage/${1}">首页</a>&nbsp;&nbsp;
			  <a href="/account/grant/selectpage/${currentPage-1}">上一页</a>&nbsp;&nbsp;
			  <a href="/account/grant/selectpage/${currentPage+1}">下一页</a>&nbsp;&nbsp;
			  <a href="/account/grant/selectpage/${totalPage}">尾页</a>&nbsp;&nbsp;
		  </c:if>
		</div>
		<div class="col-md-1 column">
		</div>
	</div>
	  <br>
	  <div class="row clearfix">
				<div class="col-md-3 column">
				</div>
				<div class="col-md-6 column" id="select">
				<h2>根据账号Id查找</h2>
					<form role="form" action="/account/grant/selectByAccountId" method="post">
						<div class="form-group">
							 <label for="exampleInputEmail1"> 账号ID</label><input type="text" name="accountId" class="form-control" id="exampleInputEmail1" />
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
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/account/public/Common/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/account/public/Admin/bootstrap.min.js"></script>
<!-- 自定 JavaScript 文件 -->
<script src="/account/public/Admin/Admin.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".select").click(function(){
	    $("#select").css("display","block");
	  });
});
</script>
</body>
</html>