<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/styles.css" type="text/css">
<title>ErrorPage</title>
</head>
<body>
<div id="ErrorPageJSP">
	<h4><c:out value="${error}"/></h4>
	<h4>OOOOooooops.... something is doing wrong<input type="submit" onclick="history.back();" value="back"/></h4>
</div>
</body>
</html>