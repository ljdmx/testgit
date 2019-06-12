<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>银行个人账户管理子系统后台页面</title>
    <!-- Bootstrap 主题 CSS 文件 -->
    <link rel="stylesheet" href="/account/public/Yeti/bootstrap.css">
    <!--<link rel="stylesheet" href="/public/Bootstrap3.3.7/css/bootstrap.css">-->
    <link rel="stylesheet" href="/account/public/Admin/Admin.css">
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
            <a class="navbar-brand" href="#">银行个人账户管理子系统后台页面</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">操作 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/account/">退出</a></li>
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
                                后台管理
                                <span class="glyphicon glyphicon-chevron-down btn-xs right"></span>
                            </h4>
                        </div>
                        <div id="List-nav-Group1" class="panel-collapse collapse in" role="tabpanel" >
                                <ul class="list-group">
                                      <li class="list-group-item">
                                             <a href="/account/admin/selectAll" class="items"><span class="glyphicon glyphicon-pencil"></span>显示所有用户信息</a>
                                      </li>
                                      <li class="list-group-item">
                                             <a href="/account/grant/selectAll" class="items"><span class="glyphicon glyphicon-shopping-cart"></span>显示所有贷款信息</a>
                                      </li>
                                      <li class="list-group-item">
                                            <a href="/account/loan/selectAll" class="items"> <span class="glyphicon glyphicon-random"></span>显示还款记录信息</a>
                                      </li>
									  <li class="list-group-item">
                                            <a href="/account/credit/selectAll" class="items"> <span class="glyphicon glyphicon-random"></span>显示所有用户信用</a>
                                      </li>
									  <li class="list-group-item">
                                            <a href="/account/accountLog/selectLog" class="items"> <span class="glyphicon glyphicon-random"></span>查看日志</a>
                                      </li>
									  <li class="list-group-item">
                                            <a href="/account/root/selectroot" class="items"> <span class="glyphicon glyphicon-random"></span>查看所有管理员</a>
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
 
        
	 
			
</div>

<hr>


</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/account/public/Common/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/account/public/Admin/bootstrap.min.js"></script>
<!-- 自定 JavaScript 文件 -->
<script src="/account/public/Admin/Admin.js"></script>

</body>
</html>