<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>预约单详情页面</title>
<link href="${pageContext.request.contextPath}/css/reserve.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<p id="intro">
				<a id="index" href="${pageContext.request.contextPath}/index.action">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;无需等待，在线预约
			</p>
		</div>
		<div id="content">
			<h2 id="h2">预约单详细信息</h2>
			<div id="reserveMessage">
				<table id="personalTable">
					<tr>
						<td class="td">预约生成时间:</td>
						<td class="td1">${ reservation.create_time}</td>
					</tr>
					<tr>
						<td class="td">申请者姓名:</td>
						<td class="td1">${ reservation.patient.pusername}</td>
					</tr>
					<tr>
						<td class="td">申请者症状:</td>
						<td class="td1">${ reservation.symptom}</td>
					</tr>
					<tr>
						<td class="td">医生姓名:</td>
						<td class="td1">${ reservation.doctor.dusername}</td>
					</tr>
					<tr>
						<td class="td">医生手机:</td>
						<td class="td1">${reservation.doctor.phone }</td>
					</tr>
					<tr>
						<td class="td">预约看病时间:</td>
						<td class="td1">${ reservation_time}</td>
					</tr>

					<tr>
						<td class="td">申请状态：</td>
						<c:choose>
							<c:when test="${reservation.success == 0 }">
								<td class="td1">申请失败</td>
							</c:when>
							<c:when test="${reservation.success == 1 }">
								<td class="td1">申请成功</td>
							</c:when>
							<c:otherwise>
								<c:if test="${doctor == null}">
									<td class="td1">待医生审批</td>
								</c:if>
								<c:if test="${doctor != null}">
									<td class="td1">待您审批</td>
									<td class="td1"><a
										href="${pageContext.request.contextPath }/handleReservation.action?id=${reservation.id}&success=1">同意</a>|<a
										href="${pageContext.request.contextPath }/handleReservation.action?id=${reservation.id}&success=0">拒绝</a></td>
								</c:if>
							</c:otherwise>
						</c:choose>
					</tr>
				</table>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
