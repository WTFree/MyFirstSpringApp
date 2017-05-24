<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<html>
<%@include file="/WEB-INF/includes/header.jsp" %>
	<div id="ContentJSP">
			
		<h1>It's your basket ${user.login}</h1>
		<div style="text-align:center" id="content">
			<c:forEach items="${basketList}" var="x">
				<div class="Remove">
					<p><img alt ="SOME ITEMS" class="top-image" src ="${pageContext.request.contextPath}/resources/${x.img}" width="160" height="150"></p>
					<h1>${x.type} : +${x.name}</h1>
					<p> ${x.price} </p>
					<form action="${pageContext.request.contextPath}/RemoveFromCard" method="post">
			  			<input type="hidden" name="prodID" value="${x.id}">
			  			<div style="margin-top:10px;"><button style="width:70%"> >>Remove<< </button></div>
			  		</form> 
			  		</div>
			</c:forEach>
		</div>		
	</div>
<%@include file='/WEB-INF/includes/footer.jsp' %>
</html>