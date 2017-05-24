<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<html>
<%@include file="/WEB-INF/includes/header.jsp" %>
	<div id="content">
		<div id="ContentJSP">
		
			<div>	
					<div class="ProductByID">
						<img style="border: 1px solid #d7dadd; border-radius: 20px;" alt ="SOME ITEMS" src ="${pageContext.request.contextPath}/resources/${product.img}" width="250" height="230">
						<div style="margin-top:10px;">
							<c:if test="${not empty user }">
							<form action="${pageContext.request.contextPath}/AddToCard" method="post">
								<input type="hidden" name ="productID" value="${product.id}">
								<button id="ButtonBUY" type="submit" value="click here">Buy me pls</button>
							</form>
							</c:if>
							<c:if test="${empty user}">
								<div style="margin-top:10px;"><button id="login2" style="width:100%">If you want to buy me, pls log in :)</button></div>
							</c:if>
						</div>
					</div> 
					<div style="margin-left:280px">
						<h1>Name of product : ${product.name} </h1>
						<h1>Price of product: ${product.price}</h1>
						<h1>Type of product: ${product.type}</h1>
					</div>
			</div>	
		
		</div>
	</div>
<%@include file='/WEB-INF/includes/footer.jsp' %>
</html>