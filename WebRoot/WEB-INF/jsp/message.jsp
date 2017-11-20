<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>全局消息页面</title>
<link href="css/index.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
#message{height:20px; position:absolute;left:460px; top:250px; font-size:14px; }
#message a{ color:#ccc;}
</style>
</head>

<body>
	<div id = "wrapper">
		<div id="header">
        	<p id="intro">
            	无需等待，在线预约
            </p>
             
        </div>
        <div id="logincontent">
       		<p id="message">
	       		<c:if test="${ message!=null}">
	       			${message }
	       		</c:if>
           	</p>
        </div>
        <div id="loginfooter">
        	
        </div>
	</div>
</body>
</html>
