<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>医院主页</title>
<link href="${pageContext.request.contextPath}/css/hospital.css"
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

			<ul id="menu">
				<li><a class="active" href="${pageContext.request.contextPath}/findHospitalByName.action?name=${hospital.hospitalName}">医院简介</a></li>
				<li><a href="${pageContext.request.contextPath}/findAllDepartmentByhospitalId.action?hospitalId=${hospital.id}">科室介绍</a></li>
			</ul>
		</div>
		<div id="content">
			<div id="mainContent">
				<p id="des"><label>简介：</label>${hospital.description}</p>
				<p id="location"><label>地址：</label>${hospital.location}</p>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
