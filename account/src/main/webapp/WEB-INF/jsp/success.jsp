<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>银行个人账户管理前台页面</title>
    <!-- Bootstrap 主题 CSS 文件 -->
    <link rel="stylesheet" href="/account/public/Yeti/bootstrap.css">
    <!--<link rel="stylesheet" href="/public/Bootstrap3.3.7/css/bootstrap.css">-->
    <link rel="stylesheet" href="/account/public/Admin/Admin.css">
    <style type="text/css">
    #updatePwd1,.table,#transfer1,#save1,#get1,#select1{
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
            <a class="navbar-brand">银行个人账户管理前台页面</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">操作 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/account/">安全退出</a></li>
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
                                账户信息
                                <span class="glyphicon glyphicon-chevron-down btn-xs right"></span>
                            </h4>
                        </div>
                        <div id="List-nav-Group1" class="panel-collapse collapse in" role="tabpanel" >
                                <ul class="list-group">
                                      <li class="list-group-item">
                                             <a id="show" class="items"><span class="glyphicon glyphicon-pencil"></span>显示信息</a>
                                      </li>
                                      <li class="list-group-item">
                                             <a id="updatePwd" class="items"><span class="glyphicon glyphicon-shopping-cart"></span>更改密码</a>
                                      </li>
                                      <li class="list-group-item">
                                            <a href="/account/accountLog/selectByAccountId/${account.id}" class="items"> <span class="glyphicon glyphicon-random"></span>历史记录</a>
                                      </li>
                                </ul>
                        </div>
                    </div>
                    <!--panel end-->


               <div class="panel-group table-responsive"  > 
                    <div class="panel panel-default leftMenu" id="myCollapsible">
                        <div class="panel-heading">
                            <h4 class="panel-title" data-toggle="collapse" data-target="#List-nav-Group2" >
                                账户操作
                                <span class="glyphicon glyphicon-chevron-down btn-xs right"></span>
                            </h4>
                        </div>
                        <div id="List-nav-Group2" class="panel-collapse collapse" role="tabpanel"  >
                                <ul class="list-group">
                                      <li class="list-group-item">
                                             <a href="/account/accountOperation/select/${account.certificateNumber}" class="items"><span class="glyphicon glyphicon-pencil"></span>查询余额</a>
                                      </li>
                                      <li class="list-group-item">
                                             <a href="/account/grant/selectById/${account.id}" class="items"><span class="glyphicon glyphicon-shopping-cart"></span>贷款操作</a>
                                      </li>
                                      <li class="list-group-item">
                                             <a id="transfer" class="items"><span class="glyphicon glyphicon-shopping-cart"></span>转账</a>
                                      </li>
                                      <li class="list-group-item">
                                            <a id="save" class="items"> <span class="glyphicon glyphicon-random"></span>存款</a>
                                      </li>
                                      <li class="list-group-item">
                                            <a id="get" class="items"> <span class="glyphicon glyphicon-random"></span>取款</a>
                                      </li>
                                </ul>
                        </div>
                    </div>
                    <!--panel end-->


                </div>
            </div>
           

        </div>
    </div>
</div>



<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

    <h2 class="page-header fonth2">基本显示</h2>



 <div class="jumbotron">
          <div class="row clearfix">
				<div class="col-md-3 column">
				</div>
				<div class="col-md-6 column" id="transfer1">
				<h2>转账</h2>
					<form role="form" action="/account/accountOperation/transfer/${account.certificateNumber}" method="post">
						<div class="form-group">
							 <label for="exampleInputEmail1">转入卡号</label><input type="text" name="certificateNumber1" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputPassword1"> 金额数目</label><input type="text" name="balanceMoney" class="form-control" id="exampleInputPassword1" />
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
				<div class="col-md-6 column" id="save1">
				<h2>存款</h2>
					<form role="form" action="/account/accountOperation/save/${account.certificateNumber}">
						<div class="form-group">
							 <label for="exampleInputEmail1">金额</label><input type="text" name="balanceMoney" class="form-control" id="exampleInputEmail1" />
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
				<div class="col-md-6 column" id="get1">
				<h2>取款</h2>
					<form role="form" action="/account/accountOperation/get/${account.certificateNumber}">
						<div class="form-group">
							 <label for="exampleInputEmail1">金额</label><input type="text" name="balanceMoney"  class="form-control" id="exampleInputEmail1" />
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
				<div class="col-md-6 column" id="updatePwd1">
					<form role="form" action="/account/admin/updatePwd/${account.id}">
					 <h2>更改密码</h2>
						<div class="form-group">
							 <label for="exampleInputEmail1">请输入密码</label><input type="text" name="userPassword" class="form-control" id="exampleInputEmail1" />
						</div>
						 <button type="submit" class="btn btn-default">确定</button>
						<button type="reset" class="btn btn-default">重置</button>
					</form>
				</div>
				<div class="col-md-3 column">
				</div>
			</div> 
			
	 <div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column">
			<table class="table">
				<thead>
					<tr>
						<th>
							ID
						</th>
						<th>
							账号
						</th>
						<th>
							用户名
						</th>
						<th>
							用户密码
						</th>
						<th>
							卡号
						</th>
						<th>
							开户时间
						</th>
						<th>
							余额
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="success">
						<td>
							${account.id}
						</td>
						<td>
							${account.accountNumber}
						</td>
						<td>
							${account.userName}
						</td>
						<td>
							${account.userPassword}
						</td>
						<td>
							${account.certificateNumber}
						</td>
						<td>
							${account.accountOpeningDate}
						</td>
						<td>
							${account.balanceMoney}
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-2 column">
		</div>
	</div>
			
</div>

<hr>

<div class="div2">
    <h3 class="money">
      <c:if test="${Number==0}" var="true">
      <span>余额：${money}</span>
      </c:if>
      <c:if test="${success==0}" var="true">
      <c:out value="操作成功"></c:out>
      </c:if>
      <c:if test="${success==1}" var="true">
      <c:out value="操作失败,余额不足"></c:out>
      </c:if>
      <c:if test="${success1==1}" var="true">
      <c:out value="操作失败"></c:out>
      </c:if>
      <c:if test="${certificateNumber==1}" var="true">
      <c:out value="你好！卡号不存在。"></c:out>
      </c:if>
       <c:if test="${pwd == 0}" var="true">
      <c:out value="更改密码成功"></c:out>
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
	$("#transfer").click(function(){
	    $("#transfer1").css("display","block");
		$("#save1").css("display","none");
		$("#get1").css("display","none");
		$(".table").css("display","none");
		$("#updatePwd1").css("display","none");
	  });
     $("#save").click(function(){
	    $("#save1").css("display","block");
		$("#transfer1").css("display","none");
		$("#get1").css("display","none");
		$(".table").css("display","none");
		$("#updatePwd1").css("display","none");
	  });
      $("#get").click(function(){
	    $("#get1").css("display","block");
		$("#transfer1").css("display","none");
		$("#save1").css("display","none");
		$(".table").css("display","none");
		$("#updatePwd1").css("display","none");
	  });	
      $("#show").click(function(){
  	    $("#get1").css("display","none");
  		$("#transfer1").css("display","none");
  		$("#save1").css("display","none");
  		$("#updatePwd1").css("display","none");
  		$(".table").css("display","block");
  	  });
      $("#updatePwd").click(function(){
    	    $("#get1").css("display","none");
    		$("#transfer1").css("display","none");
    		$("#save1").css("display","none");
    		$(".table").css("display","none");
    		$("#updatePwd1").css("display","block");
    	  });
      $("body").click(function(){
  	    $(".money").css("display","none");
  	  });
});

</script>

</body>
</html>