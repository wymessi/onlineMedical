<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>医生注册页面</title>
<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" type="text/css"/>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    <script type="text/javascript">
    $().ready(function() {
    	// 在键盘按下并释放及提交后验证提交表单
    	  $("#form").validate({
   		  onkeyup : function(element, event) {
 				//去除左侧空格
 				var value = this.elementValue(element).replace(/^\s+/g, "");
 				$(element).val(value);
 		  },
    	  rules: {
    	      dusername: {
    	        required: true,
    	        rangelength:[2,4]
    	      },
    	      password: {
    	        required: true,
    	        rangelength:[4,12]
    	      },
    	      repassword: {
    	        required: true,
    	        rangelength:[4,12],
    	        equalTo: "#password"
    	      },
    	      phone: {
    	        required: true
    	      }
    	    },
    	    messages: {
    	      dusername: {
    	        required: "姓名不能为空!",
    	        rangelength:$.validator.format("用户名长度为{0}-{1}个字符"),
    	      },
    	      password: {
    	        required: "密码不能为空!",
    	        rangelength:$.validator.format("密码长度为{0}-{1}个字符")
    	      },
    	      repassword: {
    	        required: "请输入确认密码",
    	        rangelength:$.validator.format("密码长度为{0}-{1}个字符"),
    	        equalTo: "两次密码输入不一致!"
    	      },
    	      phone: "手机号码不能为空!"
    	    }
    	    
    	});
    	
    	  $("#hospital").change(function() {
  			var hospitalName = $("#hospital").val();
  			$.ajax({
  				url : "/onlineMedical/getDepartmentsByHospitalId.action",
  				type : "post",
  				data : "hospitalName=" + hospitalName,
  				success : function(data) {
  					removeBeforeAdd(data);
  				}
  			});
  			
  			function removeBeforeAdd(data){
  				$("#department").empty();   //每次新增前将原来的删除
  				for(var i = 0;i < data.length;i++){
  					$("<option value='"+data[i].departmentName+"'>"+data[i].departmentName+"</option>").appendTo("#department");
  				}
  			}
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
            	<a href="${pageContext.request.contextPath}/patientRegisterPage.action">患者注册</a>
            </div>
        </div>
        <div id="content">
        	<div id="login">
                <h2 id="h2">医生注册</h2>
                <form id="form" action="${pageContext.request.contextPath}/doctorRegister.action" method="POST">
                    <input type="text" placeholder="请输入用户名" id="user" name="dusername"/>
                    <input type="password" placeholder="请输入密码" id="password" name="password"/>
                    <input type="password" placeholder="确认密码" id="repassword" name="repassword"/>
                    <input type="text" placeholder="请输入手机号" id="phone" name="phone"/>
                    <select id="hospital" name="hospitalName">
                    	<option>请选择医院</option>
						<c:forEach var="h" items="${hospitals }">
							<option value="${h.hospitalName }">${h.hospitalName }</option>
						</c:forEach>
					</select>
                    <select id="department" name="departmentName">
						<option>请选择科室</option>
  					</select>
                    <input type="submit" value="注册" id="submit" name="submit"/>
                </form>
    		</div>
        </div>
        <div id="footer">
        	
        </div>
	</div>
</body>
</html>
