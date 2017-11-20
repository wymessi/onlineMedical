<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>个人中心</title>
<link href="${pageContext.request.contextPath}/css/personal.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script type="text/javascript">
	$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		$("#form").validate({
			rules : {
				dusername : {
					required : true,
					rangelength : [ 2, 4 ]
				},
				age : {
					required : true,
					rangelength : [ 1, 100 ]
				},
				mail : {
					required : true,
					email : true
				},
				phone : {
					required : true
				}
			},
			messages : {
				dusername : {
					required : "姓名不能为空!",
					rangelength : $.validator.format("用户名长度为{0}-{1}个字符"),
				},
				age : {
					required : "年龄不能为空!",
					rangelength : $.validator.format("年龄范围为{0}-{1}岁"),
				},
				mail : {
					required : "邮箱不能为空!",
					email : "邮箱格式不正确!"
				},
				phone : "手机号码不能为空!"
			}
		});

		//当选择完医院时，联动显示该医院的科室
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
	<div id="wrapper">
		<div id="header">
			<p id="intro">
				<a id="index" href="${pageContext.request.contextPath}/index.action">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;无需等待，在线预约
			</p>
			<div id="message">
				<a href="${pageContext.request.contextPath}/reserveMessageList.action">预约消息</a>
			</div>
		</div>
		<div id="content">
			<h2 id="h2">个人信息</h2>
			<div id="personalMessage">
				<c:if test="${editPage==null }">
					<table id="personalTable">
						<tr>
							<td class="td">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
							<td class="td1">${ doctor.dusername}</td>
						</tr>
						<tr>
							<td class="td">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</td>
							<td class="td1">${doctor.age }</td>
						</tr>
						<tr>
							<td class="td">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机:</td>
							<td class="td1">${doctor.phone }</td>
						</tr>
						<tr>
							<td class="td">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</td>
							<td class="td1">${doctor.mail }</td>
						</tr>
						<tr>
							<td class="td">所属医院及科室:</td>
							<td class="td1">${doctor.hospital.hospitalName }-${doctor.department.departmentName }</td>
						</tr>
					</table>
					<div id="edit">
						<c:if test="${notDoctor==null }">
							<a href="${pageContext.request.contextPath}/doctorEditPage.action?editPage=editPage">编辑完善信息>></a>
						</c:if>
						<c:if test="${notDoctor!=null }">
							<a href="${pageContext.request.contextPath}/reservePage.action?doctorId=${doctor.id}">点击预约</a>
						</c:if>
					</div>
				</c:if>
				<c:if test="${editPage!=null }">
					<form id="form"
						action="${pageContext.request.contextPath}/updateDoctor.action"
						method="POST">
						<table id="personalTable">
							<tr>
								<td class="td">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
								<td class="td1"><input id="user" type="text"
									value="${ doctor.dusername}" name="dusername"></td>
							</tr>
							<tr>
								<td class="td">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</td>
								<td class="td1"><input id="age" type="text"
									value="${doctor.age }" name="age"></td>
							</tr>
							<tr>
								<td class="td">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机:</td>
								<td class="td1"><input id="phone" type="text"
									value="${doctor.phone }" name="phone"></td>
							</tr>
							<tr>
								<td class="td">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</td>
								<td class="td1"><input id="mail" type="text"
									value="${doctor.mail }" name="mail"></td>
							</tr>
							<tr>
								<td class="td">所属医院:</td>
								<td class="td1"><select id="hospital" name="hospitalName">
										<c:if test="${doctor!=null }">
											<option>${doctor.hospital.hospitalName }</option>
										</c:if>
										<c:forEach var="h" items="${hospitals }">
											<option value="${h.hospitalName }">${h.hospitalName }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td class="td">所属科室:</td>
								<td class="td1"><select id="department" name="departmentName">
									<c:if test="${doctor!=null}">
										<option>${doctor.department.departmentName }</option>
									</c:if>
  								</select></td>
							</tr>
						</table>
						<div id="edit">
							<input type="submit" value="提交修改" id="submit">
						</div>
					</form>
				</c:if>

			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
