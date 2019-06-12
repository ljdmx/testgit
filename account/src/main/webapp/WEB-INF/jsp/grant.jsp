<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>贷款管理页面</title>
    <!-- Bootstrap 主题 CSS 文件 -->
    <link rel="stylesheet" href="/account/public/Yeti/bootstrap.css">
    <!--<link rel="stylesheet" href="/public/Bootstrap3.3.7/css/bootstrap.css">-->
    <link rel="stylesheet" href="/account/public/Admin/Admin.css">
    <style type="text/css">
      #div1,#div2,#div3,#grant1,#repay1{
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
            <a class="navbar-brand" >贷款页面</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">操作 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/account/admin/tosuccess/${account.accountNumber}">返回</a></li>
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
                            <h4 class="panel-title" data-toggle="collapse" data-target="#List-nav-Group2" >
                                贷款操作
                                <span class="glyphicon glyphicon-chevron-down btn-xs right"></span>
                            </h4>
                        </div>
                        <div id="List-nav-Group2" class="panel-collapse collapse" role="tabpanel"  >
                                <ul class="list-group">
                                      <li class="list-group-item">
                                             <a  id="grant" class="items"><span class="glyphicon glyphicon-pencil"></span>贷款申请</a>
                                      </li>
                                      <li class="list-group-item">
                                             <a id="repay" class="items"><span class="glyphicon glyphicon-shopping-cart"></span>还款</a>
                                      </li>
                                      <li class="list-group-item">
                                             <a id="id1" class="items"><span class="glyphicon glyphicon-shopping-cart"></span>查看信用</a>
                                      </li>
                                      <li class="list-group-item">
                                            <a id="id2" class="items"> <span class="glyphicon glyphicon-random"></span>查看贷款记录</a>
                                      </li>
                                      <li class="list-group-item">
                                            <a id="id3" class="items"> <span class="glyphicon glyphicon-random"></span>查看还款记录</a>
                                      </li>
                                </ul>
                        </div>
                    </div>
                    <!--panel end-->


               
            </div>
           

        </div>
    </div>
</div>



<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

    <h2 class="page-header fonth2"></h2>


   

 <div class="jumbotron">
          <div class="row clearfix">
				<div class="col-md-3 column">
				</div>
				<div class="col-md-6 column" id="grant1">
				<h2>贷款申请</h2>
					<form role="form" action="/account/grant/add/${account.id}" method="post">
						<div class="form-group">
							 <label for="exampleInputEmail1">贷款金额</label><input type="text" name="money" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputEmail1">身份证号</label><input type="text" name="identityCard" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputEmail1">还款日期</label><input type="text" name="repaymentTime" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputEmail1">电话号码</label><input type="text" name="telephoneNumber" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">亲人号码:</label><input type="text" name="familyTelephoneNumber" class="form-control" id="exampleInputPassword1" />
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
				<div class="col-md-6 column" id="repay1">
				<h2>还款</h2>
					<form role="form" action="/account/grant/repayment/${account.id}" method="post">
						<div class="form-group">
							 <label for="exampleInputEmail1"> 还款金额</label><input type="text" name="loanMoney" class="form-control" id="exampleInputEmail1" />
						</div>
						<button type="submit" class="btn btn-default">确定</button>
						<button type="reset" class="btn btn-default">重置</button>
					</form>
				</div>
				<div class="col-md-3 column">
				</div>
			</div> 
			
			
	 <div class="row clearfix">
		<div class="col-md-1 column">
		</div>
		<div class="col-md-10 column" id="div1">
		<c:if test="${fn:length(list) eq 0}">
	     <span>没有操作记录</span>
	    </c:if>
	    <c:if test="${fn:length(list) gt 0}">
			<table class="table">
				<thead>
				<tr><th>ID</th>
				   <th>账号ID</th>
				   <th>贷款金额</th>
				   <th>身份证号</th>
				   <th>申请时间</th>
				   <th>还款日期</th>
				   <th>电话号码</th>
				   <th>亲人电话号码</th>
				   <th>状态</th>
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
                       </c:if>
                       </td>
				</tr>
			 </c:forEach>
				</tbody>
			</table>
			</c:if>
		</div>
		<div class="col-md-1 column">
		</div>
	</div>
	
	
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column" id="div2">
			<table class="table">
				<thead>
				 <tr><th>ID</th>
				   <th>账户id</th>
				   <th>信用级别</th>
				   <th>有无欠款</th>
				   <th>欠款金额</th>
				   <th>刷新操作</th>
				   </tr>
				</thead>
				<tbody>
				<tr class="success">
				   <td id="accountid">${credit.id}</td>
			   <td>${credit.accountId}</td>
			   <td>${credit.creditRatings}</td>
			   <td>${credit.arrears}</td>
			   <td>${credit.arrearsMoney}</td>
			   <td><a href="/account/grant/update/${credit.accountId}">刷新</a></td>
			   </tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-2 column">
		</div>
	</div>
	
	
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column" id="div3">
		   <c:if test="${fn:length(list1) eq 0}">
	       <span>没有操作记录</span>
	       </c:if>
	       <c:if test="${fn:length(list1) gt 0}">
			<table class="table">
				<thead>
				<tr><th>ID</th>
	            <th>还款时间</th>
	            <th>还款金额</th>     
	             </tr>
				</thead>
				<tbody>
                 <c:forEach items="${list1}" var="loan">
				  <tr class="success">
				     <td>${loan.id}</td>
	                 <td>${loan.repaymentTime}</td>
	                 <td>${loan.loanMoney}</td>
			     </tr>
			    </c:forEach>
				</tbody>
			</table>
		</c:if>
		</div>
		<div class="col-md-2 column">
		</div>
	</div>
			
</div>

<hr>

    <div class="show">
    <h3 >
      <c:if test="${notsuccess==1}" var="true">
          <c:out value="还款失败，余额不足"></c:out>
          </c:if>
           <c:if test="${notsuccess==2}" var="true">
          <c:out value="还款失败，还款金额超过欠款金额"></c:out>
          </c:if>
          <c:if test="${notsuccess==3}" var="true">
          <c:out value="还款失败，你不欠款"></c:out>
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
	$("#grant").click(function(){
	    $("#grant1").css("display","block");
		$("#div1").css("display","none");
		$("#div2").css("display","none");
		$("#repay1").css("display","none");
		$("#div3").css("display","none");
	  }); 
	  $("#repay").click(function(){
	    $("#repay1").css("display","block");
		$("#grant1").css("display","none");
		$("#div1").css("display","none");
		$("#div2").css("display","none");
		$("#div3").css("display","none");
		});
		 $("#id1").click(function(){
	    $("#repay1").css("display","none");
		$("#grant1").css("display","none");
		$("#div1").css("display","none");
		$("#div2").css("display","block");
		$("#div3").css("display","none");
		});
		 $("#id2").click(function(){
	    $("#repay1").css("display","none");
		$("#grant1").css("display","none");
		$("#div1").css("display","block");
		$("#div2").css("display","none");
		$("#div3").css("display","none");
		});
		 $("#id3").click(function(){
		  $("#repay1").css("display","none");
		  $("#grant1").css("display","none");
		  $("#div1").css("display","none");
		  $("#div2").css("display","none");
		  $("#div3").css("display","block");
		 });
		 $("body").click(function(){
			  $(".show").css("display","none");
			 });
});

</script>

</body>
</html>