<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>预约页面</title>
<link href="${pageContext.request.contextPath}/css/reserve.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<p id="intro">
				<a id="index" href="${pageContext.request.contextPath}/index.action">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;无需等待，在线预约
			</p>
		</div>
		<div id="content">
			<h2 id="h2">预约信息</h2>
			<div id="reserveMessage">
				<form id="form"
					action="${pageContext.request.contextPath}/reserve.action"
					method="POST">
					<table id="personalTable">
						<tr>
							<td class="td">申请者姓名:</td>
							<td class="td1">${ patient.pusername}</td>
						</tr>
						<tr>
							<td class="td">简要症状:</td>
							<td class="td1"><input type="text" name="symptom"/></td>
						</tr>
						<tr>
							<td class="td">申请者手机:</td>
							<td class="td1">${patient.phone }</td>
						</tr>
						<tr>
							<td class="td">申请看病时间:</td>
							<td class="td1"><input class="Wdate" type="text"
								 name="reservation_time" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"></td>
						</tr>
					</table>
					<input type="hidden" name="doctorId" value="${doctorId }"/>
					<input type="hidden" name="patientId" value="${patient.id }"/>
					<div id="edit">
						<input type="submit" value="申请预约" id="submit">
					</div>
				</form>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
