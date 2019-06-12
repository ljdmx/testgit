<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>登陆页面</title>
<script src="/account/public/Common/jquery.min.js"></script>
<style type="text/css">
 *{
   margin:0;
   padding:0; 
 }
  body{
      background:url("/account/image/7.jpg") no-repeat;
  }
  .nav{
      background-color:#d1e9e9;
	  opacity:0.5;
	  height:50px;
	  width:100%;
	  line-height:50px;
	  text-align:right;
	  position:fixed;
      top:0;
	  
  }
  .footer{
     
	  height:40px;
	  width:100%;
      text-align:center;
	  position:fixed;
	  left:0;
      bottom:0;	  
  }
   .main1,.main2{
      background:url("/account/image/1.jpg") no-repeat;
      opacity:0.8;
	  width:240px;
	  height:200px;
	  text-align:center;
	  position:fixed;
	  left:50%;
	  top:50%;
	  margin-left:-120px;
	  margin-top:-60px; 
  }
  .main3{
      background:url("/account/image/1.jpg") no-repeat;
      opacity:0.8;
	  width:260px;
	  height:300px;
	  text-align:center;
	  position:fixed;
	  left:50%;
	  top:50%;
	  margin-left:-130px;
	  margin-top:-160px; 
  }
  #label1{
      background-color:#336677;
      width:240px;
      height:40px;
	  line-height:30px;
	  text-align:left;
  }
  #label2{
      width:240px;
      height:100px;
	  line-height:25px;
  }
  #label3{
      width:240px;
      height:40px;
      line-height:15px;
      text-align:center;
  }
  #label31{
      background-color:#336677;
      width:260px;
      height:40px;
	  line-height:30px;
	  text-align:left;
  }
   #label32{
      width:260px;
      height:200px;
	  line-height:25px;
  }
  #label33{
      width:260px;
      height:30px;
      line-height:15px;
      text-align:center;
  }
  input{
      display:inline;
	 width:220px;
	 height:25px;
	 background-color:#aabbcc;
	 border:1px solid #fee;
	 outline:none;
	 border-radius:10px;
  }
  input[type="submit"],input[type="reset"]{
     display:inline;
	 background-color:#A3D1D1;
     width:100px;
	 height:25px;
  }
  input[type="button"]{
     display:inline;
	 background-color:#aaaaff;
     width:100px;
	 height:25px;
  }
  .main2,.main3{
     display:none;
  }
  .show{
     background:url("/account/image/1.jpg") no-repeat;
      opacity:0.8;
	  width:240px;
	  height:40px;
	  line-height:40px;
	  text-align:center;
	  position:fixed;
	  left:50%;
	  top:50%;
	  margin-left:-120px;
	  margin-top:140px; 
  }
    #s{
   text-align: center;
  }
</style>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	 $("#Root").click(function(){
		$(".main1").css("display","none");
		$(".main2").css("display","block");
		$(".main3").css("display","none");
	  });
	  $("#Create").click(function(){
		$(".main1").css("display","none");
		$(".main2").css("display","none");
		$(".main3").css("display","block");
	  });
	  $("#User").click(function(){
	    $(".main1").css("display","block");
		$(".main2").css("display","none");
		$(".main3").css("display","none");
	  });
	  $("body").click(function(){
		    $("#show").css("display","none");
		});
	});

</script>
    <div class="nav">
    <h1 id="s">银行个人账号管理子系统</h1>
	<input id="User" type="button"  value="User Landing" />
	<input id="Root" type="button"  value="Root Landing" />
	<input id="Create" type="button"  value="Create Account"/>
    </div>
    <div class="main1">
        <form  action="/account/admin/login" method="post">
        <div id="label1">
	    <p>User Landing now <p>
	    </div>
		<br/>
	    <div id="label2">
        <input type="text" name="userName"  placeholder="User Name..." /><br/><br/>
	    <input type="password" name="userPassword"  placeholder="User Password..." /><br/><br/>
        </div >
	    <div id="label3">
		<input type="submit" value="Land" />
		&nbsp;&nbsp;
		<input type="reset" value="Reset"/>
        </div>
	    </form>
	</div>
	<div class="main2">
        <form  action="/account/root/login" >
        <div id="label1">
	    <p>Root Landing now <p>
	    </div>
		<br/>
	    <div id="label2">
        <input type="text" name="name" placeholder="Root Name..." /><br/><br/>
        <input type="password" name="password" placeholder="Root Password..." /><br/><br/>
	    </div>
		<div id="label3">
        <input type="submit" value="Land" />
		&nbsp;&nbsp;
        <input type="reset" value="Reset"/>
        </div>
        </form>
     </div>
	 
	 <div class="main3">
	   <form  action="/account/admin/register" method="post">
	   <div id="label31">
	   <p>Create Account <p>
	   </div>
	   <br/>
	   <div id="label32">
       <input type="text" name="accountNumber" placeholder="Account Number.." /><br/><br/>
       <input type="text" name="userName" placeholder="User Name..."/><br/><br/>
       <input type="password" name="userPassword" placeholder="User Password..."/><br/><br/>
       <input type="text" name="certificateNumber" placeholder="Certificate Number..."/><br/><br/>
	   </div>
	   <div id="label33">
       <input type="submit"  value="Submission" /> 
	   &nbsp;&nbsp;
       <input type="reset" value="Reset"/><br/>
	   </div>
       </form>
    </div>
	 <div class="show">
	   <p id="show">
	      <c:if test="${success==1}" var="true">
          <c:out value="登录失败"></c:out>
          </c:if>
	      <c:if test="${register==1}" var="true">
          <c:out value="注册失败"></c:out>
          </c:if>
          <c:if test="${register==0}" var="true">
          <c:out value="注册成功"></c:out>
          </c:if>
       </p>
	 </div>
     <br/>
	 <br/>
<div class="footer">
     &copy;
     <script>
     document.write(new Date().getFullYear())
     </script>
     <p>欢迎使用本网站</p>
</div>
</body>
</html>