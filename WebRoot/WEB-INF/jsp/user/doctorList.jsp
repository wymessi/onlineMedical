<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>查询医生结果列表页面</title>
<link href="${pageContext.request.contextPath}/css/departments.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	
</script>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<p id="intro">
				<a id="index" href="${pageContext.request.contextPath}/index.action">首页&nbsp;&nbsp;&nbsp;&nbsp;</a>${hospital.hospitalName}
			</p>
		</div>
		<div id="content">
			<div id="mainContent">
				<dl id="dl">
					<dt class="dt">医生列表</dt>
					<c:forEach var="doctor" items="${page.list }">
						<dd class="dd"><a href="${pageContext.request.contextPath}/findDoctorById.action?doctorId=${doctor.id}">${doctor.dusername}</a></dd>
					</c:forEach>
				</dl>
			</div>
			<div id="page">
		    	当前第[${page.pageNum}]页，
		    	<c:forEach var="pageNum" begin="${page.startPage }" end="${ page.endPage}">
		    		[<a href="${pageContext.request.contextPath }/findDoctorsByName.action?name=${param.name }&pageNum=${pageNum}">${pageNum }</a>]
		    	</c:forEach>
		    	总共[${page.totalPage }]页，总[${page.totalRecord }]纪录
    		</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
