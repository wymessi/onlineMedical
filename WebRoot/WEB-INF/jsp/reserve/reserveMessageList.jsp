<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>预约单列表页面</title>
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
			<h2 id="h2">我的预约单列表</h2>
			<div id="reserveMessage">
					<table id="personalTable">
						<c:forEach var="reservation" items="${page.list }">
							<tr>
								<td class="td">
									${reservation.create_time}
								</td>
								<td class="td" style=" padding-left: 200px;"><a href="${pageContext.request.contextPath }/reserveMessage.action?reservationId=${reservation.id}">预约单详情</a></td>
							</tr>
						</c:forEach>
					</table>
					<div id="page">
				    	当前第[${page.pageNum}]页，
				    	<c:forEach var="pageNum" begin="${page.startPage }" end="${ page.endPage}">
				    		[<a href="${pageContext.request.contextPath }/reserveMessageList.action?pageNum=${pageNum}">${pageNum }</a>]
				    	</c:forEach>
				    	总共[${page.totalPage }]页，总[${page.totalRecord }]纪录
    				</div>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
