<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<link href="css/index.css" rel="stylesheet" type="text/css"/>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
	<script>
	$(function(){
        //让当前表单调用validate方法，实现表单验证功能
        $("#form").validate({
        	onkeyup : function(element, event) {
  				//去除左侧空格
  				var value = this.elementValue(element).replace(/^\s+/g, "");
  				$(element).val(value);
  			  },
        	rules:{     //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
            	dusername:{
                    required:true, //必填。如果验证方法不需要参数，则配置为true
                },
                password:{
                    required:true,
                }
            },
	        messages:{
	        	dusername:{
	                required:"姓名不能为空!",
	            },
	            password:{
	                required:"密码不能为空!",
	            }
	        }
        });
        
        $.ajax({
        	url:"/onlineMedical/"
        });
        
    });
	</script>
</head>

<body>
	<div id = "wrapper">
		<div id="header">
        	<p id="intro">
            	无需等待，在线预约
            </p>
             <div id="rl">
            	<a href="${pageContext.request.contextPath}/doctorRegisterPage.action">医生注册</a>|<a href="${pageContext.request.contextPath}/patientRegisterPage.action">患者注册</a>
            </div>
        </div>
        <div id="logincontent">
        	<div id="login">
        		<c:if test="${isPatient==null }">
                	<h2 id="h2">医生登录</h2>
	                <a class="forget" href="${pageContext.request.contextPath}/patientLoginPage.action?isPatient=isPatient">不是医生？患者登录</a>
	                <form id="form" action="${pageContext.request.contextPath}/doctorLogin.action" method="POST">
	                    <input type="text" placeholder="请输入真实姓名" id="user" name="dusername" value="${dusername }"/>
	                    <input type="password" placeholder="请输入密码" id="password" name="password"/>
	                    <input type="checkbox" id="checkbox" name="checkbox"/>
	                    <span class="remember">下次自动登录</span>
	                    <input type="submit" value="登录" id="submit" name="submit"/>
	                </form>
                </c:if>
                
                <c:if test="${isPatient!=null }">
                	<h2 id="h2">患者登录</h2>
                	<a class="forget" href="${pageContext.request.contextPath}/doctorLoginPage.action">不是患者？医生登录</a>
	                <form id="form" action="${pageContext.request.contextPath}/patientLogin.action" method="POST">
	                    <input type="text" placeholder="请输入真实姓名" id="user" name="pusername" value="${pusername }"/>
	                    <input type="password" placeholder="请输入密码" id="password" name="password"/>
	                    <input type="checkbox" id="checkbox" name="checkbox"/>
	                    <span class="remember">下次自动登录</span>
	                    <input type="submit" value="登录" id="submit" name="submit"/>
	                </form>
                </c:if>
    		</div>
        </div>
        <div id="loginfooter">
        	
        </div>
	</div>
</body>
</html>
