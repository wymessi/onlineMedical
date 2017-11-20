<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>个人中心</title>
<link href="${pageContext.request.contextPath}/css/illness.css"rel="stylesheet" type="text/css"/>

</head>

<body>
	<div id = "wrapper">
		<div id="header">
        	<p id="intro">
            	<a id="index" href="${pageContext.request.contextPath}/index.action">首页&nbsp;&nbsp;&nbsp;&nbsp;</a>无需等待，在线预约
            </p>
        </div>
        <div id="content">
			<div id="mainContent">
				<p id="name"><label>名称：</label>${illness.name}</p>
				<p id="des"><label>简介：</label>${illness.description}</p>
			</div>
		</div>
        <div id="footer">
        </div>
	</div>
</body>
</html>
