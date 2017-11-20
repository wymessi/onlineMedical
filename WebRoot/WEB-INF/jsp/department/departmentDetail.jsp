<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>科室详情</title>
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
				<a id="index" href="${pageContext.request.contextPath}/index.action">首页&nbsp;&nbsp;&nbsp;&nbsp;</a>
			</p>
		</div>
		<div id="content">
			<div id="mainContent">
				<div id="mainContentLeft">
					<dl id="dl">
						<dt class="dt">科室所有医生</dt>
						<c:forEach var="doctor" items="${doctors }">
							<dd class="dd"><a href="${pageContext.request.contextPath}/findDoctorById.action?doctorId=${doctor.id}">${doctor.dusername}</a></dd>
						</c:forEach>
					</dl>
				</div>
				<div id="mainContentRight">
					<dl id="dl2">
						<dt class="dt2">科室主治疾病</dt>
						<c:forEach var="illness" items="${illnesses }">
							<dd class="dd2"><a href="${pageContext.request.contextPath}/findIllnessById.action?illnessId=${illness.id}">${illness.name}</a></dd>
						</c:forEach>
					</dl>
				</div>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
