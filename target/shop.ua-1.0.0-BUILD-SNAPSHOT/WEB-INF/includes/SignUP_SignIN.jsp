<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<div style="float:left; padding-right: 20px;">	
	<c:choose>
		<c:when test="${empty user}">
			<button id="registration">Sign up</button>
			<button id="login">Sign in</button>
		</c:when>
		<c:when test ="${user.login=='Admin'}">
			<div style="float:left;">
				<div style="float:left; margin-right:25px; margin-top: 5px;">
					<b style="font-size:14px;">${user.login}</b>
					<a href="${pageContext.request.contextPath}/productcard" class="active">
						<img alt ="Shop card" class="shop-image" src ="<c:url value="/resources/views/images/cart1.png"/>" width="30" height="20">
					</a>
				</div>
				<div style="float:left; margin-right:20px">
					<form method = "post" action ="${pageContext.request.contextPath}/AdminMenu">
						<button>Admin menu</button>
					</form>
				</div>
				<div style="float:left">
					<form method = "post" action ="logout">
						<button id="logout">Logout</button>
					</form>
				</div>
			</div>	

		</c:when>
		<c:otherwise>
			 <form method = "post" action ="${pageContext.request.contextPath}/logout">
			 	<div style="float:left; margin-right:15px;margin-top: 5px;">
			 		<b style="font-size:14px;">${user.login}</b>
			 		<a href="${pageContext.request.contextPath}/productcard" class="active">
			 			<img alt ="Shop card" class="shop-image" src ="<c:url value="/resources/views/images/cart1.png"/>" width="30" height="20">
			 		</a>
			 	</div>
				<button id="logout">Logout</button>
			</form>
		</c:otherwise>
	</c:choose>
</div>