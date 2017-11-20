<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>患者注册页面</title>
<link href="${pageContext.request.contextPath}/css/register.css"
	rel="stylesheet" type="text/css" />
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
			rules : {
				pusername : {
					required : true,
					rangelength : [ 2, 4 ]
				},
				password : {
					required : true,
					rangelength : [ 4, 12 ]
				},
				repassword : {
					required : true,
					rangelength : [ 4, 12 ],
					equalTo : "#password"
				},
				phone : {
					required : true
				}

			},
			messages : {
				pusername : {
					required : "姓名不能为空!",
					rangelength : $.validator.format("用户名长度为{0}-{1}个字符"),
				},
				password : {
					required : "密码不能为空!",
					rangelength : $.validator.format("密码长度为{0}-{1}个字符")
				},
				repassword : {
					required : "请输入确认密码",
					rangelength : $.validator.format("密码长度为{0}-{1}个字符"),
					equalTo : "两次密码输入不一致!"
				},
				phone : "手机号码不能为空!"

			}
		});
	});
</script>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<p id="intro">无需等待，在线预约</p>
			<div id="rl">
				<a
					href="${pageContext.request.contextPath}/doctorRegisterPage.action">医生注册</a>
			</div>
		</div>
		<div id="content">
			<div id="login">
				<h2 id="h2">患者注册</h2>
				<form id="form"
					action="${pageContext.request.contextPath}/patientRegister.action"
					method="POST">
					<input type="text" placeholder="请输入用户名" id="user" name="pusername" />
					<input type="password" placeholder="请输入密码" id="password"
						name="password" /> <input type="password" placeholder="确认密码"
						id="repassword" name="repassword" /> <input type="text"
						placeholder="请输入手机号" id="phone" name="phone" /> <input
						type="submit" value="注册" id="submit" name="submit" />
				</form>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
