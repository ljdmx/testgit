<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理页面</title>
    <!-- Bootstrap 主题 CSS 文件 -->
    <link rel="stylesheet" href="/account/public/Yeti/bootstrap.css">
    <!--<link rel="stylesheet" href="/public/Bootstrap3.3.7/css/bootstrap.css">-->
    <link rel="stylesheet" href="/account/public/Admin/Admin.css">
    <style type="text/css">
    #update1,#add1,#select3,#select4{
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
            <a class="navbar-brand" href="#">用户管理页面</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">操作 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/account/root/toshow">返回</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container-fluid">
    <div class="row">
   
        <div class="col-lg-2 col-md-2 col-sm-3 sidebar">

          

               <div class="panel-group table-responsive"  > 
                    <div class="panel panel-default leftMenu" id="myCollapsible">
                        <div class="panel-heading">
                            <h4 class="panel-title" data-toggle="collapse" data-target="#List-nav-Group1" >
                                账户管理
                                <span class="glyphicon glyphicon-chevron-down btn-xs right"></span>
                            </h4>
                        </div>
                        <div id="List-nav-Group1" class="panel-collapse collapse in" role="tabpanel" >
                                <ul class="list-group">
                                      <li class="list-group-item">
                                        <a href="/account/admin/selectAll" class="items"><span class="glyphicon glyphicon-pencil"></span>显示所有用户信息</a>
                                      </li>
                                      <li class="list-group-item">
                                             <a id="update" class="items"><span class="glyphicon glyphicon-pencil"></span>更新</a>
                                      </li>
                                      <li class="list-group-item">
                                             <a id="add" class="items"><span class="glyphicon glyphicon-shopping-cart"></span>添加</a>
                                      </li>
                                      <li class="list-group-item">
                                            <a id="select" class="items"> <span class="glyphicon glyphicon-random"></span>查找账户</a>
                                      </li>
									  <li class="list-group-item">
                                            <a id="select1" class="items"> <span class="glyphicon glyphicon-random"></span>查找用户</a>
                                      </li>
                                </ul>
                        </div>
                    </div>
                    <!--panel end-->


        
                    <!--panel end-->


            </div>
           

        </div>
    </div>
</div>



<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

    <h2 class="page-header fonth2"></h2>



 <div class="jumbotron">
 
        <div class="row clearfix">
		<div class="col-md-1 column">
		</div>
		<div class="col-md-10 column" id="table">
		<c:if test="${fn:length(list) eq 0}">
	     <span>没有操作记录</span>
	    </c:if>
	    <c:if test="${fn:length(list) gt 0}">
			<table class="table">
				<thead>
				<tr>
			   <th>ID</th>
			   <th>账号</th>
			   <th>用户名</th>
			   <th>用户密码</th>
			   <th>卡号</th>
			   <th>开户时间</th>
			   <th>余额</th>
			   <th>操作</th>
			   </tr>
				</thead>
				<tbody>
                 <c:forEach items="${list}" var="account">
				<tr class="success">
				     <td id="accountid">${account.id}</td>
					   <td>${account.accountNumber}</td>
					   <td>${account.userName}</td>
					   <td>${account.userPassword}</td>
					   <td>${account.certificateNumber}</td>
					   <td>${account.accountOpeningDate}</td>
					   <td>${account.balanceMoney}</td>
					   <td><a href="/account/admin/delete/${account.id}">删除</a></td>
				   </tr>
			 </c:forEach>
				</tbody>
			</table>
			<br>共<span>${totalRecord}</span>条记录&nbsp;&nbsp;共<span>${totalPage}</span>页&nbsp;&nbsp;当前第<span>${currentPage}</span>页&nbsp;&nbsp;
			  <a href="/account/admin/selectpage/${1}">首页</a>&nbsp;&nbsp;
			  <a href="/account/admin/selectpage/${currentPage-1}">上一页</a>&nbsp;&nbsp;
			  <a href="/account/admin/selectpage/${currentPage+1}">下一页</a>&nbsp;&nbsp;
			  <a href="/account/admin/selectpage/${totalPage}">尾页</a>&nbsp;&nbsp;
		  </c:if>
		</div>
		<div class="col-md-1 column">
		</div>
	</div>
 
          <div class="row clearfix">
				<div class="col-md-3 column">
				</div>
				<div class="col-md-6 column" id="update1">
				<h2>更新</h2>
					<form role="form" action="/account/admin/update">
					    <div class="form-group">
							 <label for="exampleInputEmail1">ID</label><input type="text" name="id" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputEmail1">密码</label><input type="password" name="userPassword" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputPassword1">余额</label><input type="text" name="balanceMoney" class="form-control" id="exampleInputPassword1" />
						</div>
						<button type="submit" class="btn btn-default">确定</button>
						 <button type="reset" class="btn btn-default">重置</button>
					</form>
				</div>
				<div class="col-md-3 column">
				</div>
			</div> 
			<div class="row clearfix">
				<div class="col-md-3 column">
				</div>
				<div class="col-md-6 column" id="add1">
				<h2>添加</h2>
					<form role="form" action="/account/admin/add" method="post">
						<div class="form-group">
							 <label for="exampleInputEmail1">账号</label><input type="text" name="accountNumber" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputEmail1">用户名</label><input type="text" name="userName" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputEmail1">密码</label><input type="password" name="userPassword" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputEmail1">卡号</label><input type="text" name="certificateNumber" class="form-control" id="exampleInputEmail1" />
						</div>
						 <button type="submit" class="btn btn-default">确定</button>
						 <button type="reset" class="btn btn-default">重置</button>
					</form>
				</div>
				<div class="col-md-3 column">
				</div>
			</div> 
			<div class="row clearfix">
				<div class="col-md-3 column">
				</div>
				<div class="col-md-6 column" id="select3">
				<h2>根据账号查找</h2>
					<form role="form" action="/account/admin/selectByAccountNumber" method="post">
						<div class="form-group">
							 <label for="exampleInputEmail1"> 账号</label><input type="text" name="accountNumber"  class="form-control" id="exampleInputEmail1" />
						</div>
						<button type="submit" class="btn btn-default">确定</button>
						<button type="reset" class="btn btn-default">重置</button>
					</form>
				</div>
				<div class="col-md-3 column">
				</div>
			</div> 
			<div class="row clearfix">
				<div class="col-md-3 column">
				</div>
				<div class="col-md-6 column" id="select4">
					<form role="form" action="/account/admin/selectByUserName" method="post">
					 <h2>根据用户查找</h2>
						<div class="form-group">
							 <label for="exampleInputEmail1">用户名</label><input type="text" name="userName" class="form-control" id="exampleInputEmail1" />
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
    <h3 >
   <c:if test="${register==1}" var="true">
  <c:out value="添加失败"></c:out>
  </c:if>
  <c:if test="${register==0}" var="true">
  <c:out value="添加成功"></c:out>
  </c:if>
  <c:if test="${select==1}" var="true">
  <c:out value="查找失败"></c:out>
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
	   $("#add").click(function(){
	    $("#add1").css("display","block");
		$("#select3").css("display","none");
		$("#update1").css("display","none");
		$("#select4").css("display","none");
		
	  });
	  $("#update").click(function(){
	    $("#add1").css("display","none");
		$("#select3").css("display","none");
		$("#update1").css("display","block");
		$("#select4").css("display","none");
		
	  });
	  $("#select").click(function(){
	    $("#add1").css("display","none");
		$("#select3").css("display","block");
		$("#update1").css("display","none");
		$("#select4").css("display","none");
		
	  });
	  $("#select1").click(function(){
	    $("#add1").css("display","none");
		$("#select3").css("display","none");
		$("#update1").css("display","none");
		$("#select4").css("display","block");
		
	  });
     
      $("body").click(function(){
  	    $(".show").css("display","none");
  	  });
});

</script>

</body>
</html>