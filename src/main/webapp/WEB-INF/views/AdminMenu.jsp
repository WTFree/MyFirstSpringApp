<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="description" content="text/html; charset=UTF-8">
	<title> Admin Menu </title>
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>" type="text/css">
</head>
<body>
<div id="AdminMenu">
	  <h1>Create new Product</h1>
	  <form method = "post" action ="${pageContext.request.contextPath}/ProductRegister">
	  	<fieldset>
    		<div class="main-login">
      			<div class="field-login">
	      			<label for="nameProd"><font size="3">Name</font></label>
	      			<input type="text" name="nameProd" placeholder="Write name of product" id="nameProd" class="text ui-widget-content ui-corner-all">
      			</div>
      			<div class="field-login">
	      			<label for="price"><font size="3">Price</font></label>
	      			<input type="text" name="price" placeholder="price" id="price"  class="text ui-widget-content ui-corner-all">
	  			</div>
	  			<div class="field-login">
	      			<label for="type"><font size="3">Type</font></label>
	      			<input type="text" name="type" placeholder="Write type of product" id="type" class="text ui-widget-content ui-corner-all">
      			</div>
      			<div class="field-login">
	      			<label for="img"><font size="3">Url to img</font></label>
	      			<input type="text" name="img" placeholder="C://..." id="img"  class="text ui-widget-content ui-corner-all">
	  			</div>
	  			
   	  			<br> <input type="submit" value="Create Product" >
    		</div>
    	</fieldset>
	  </form>
	  <h1>UPDATE</h1>
	  <form method = "post" action ="${pageContext.request.contextPath}/ProductUpdate">
	  	<fieldset>
    		<div class="main-login">
      			<div class="field-login">
	      			<label for="OLDnameProd"><font size="3">OLD Name</font></label>
	      			<input type="text" name="OLDnameProd" placeholder="Write OLD name of product" id="OLDnameProd" class="text ui-widget-content ui-corner-all">
      			</div>
      			<div class="field-login">
	      			<label for="OLDprice"><font size="3">OLD Price</font></label>
	      			<input type="text" name="OLDprice" placeholder="OLD price" id="OLDprice"  class="text ui-widget-content ui-corner-all">
	  			</div>
	  			<div class="field-login">
	      			<label for="OLDtype"><font size="3">OLD Type</font></label>
	      			<input type="text" name="OLDtype" placeholder="Write OLD type of product" id="OLDtype" class="text ui-widget-content ui-corner-all">
      			</div>
      			<div class="field-login">
	      			<label for="OLDimg"><font size="3">OLD Url to img</font></label>
	      			<input type="text" name="OLDimg" placeholder="OLD C://..." id="OLDimg"  class="text ui-widget-content ui-corner-all">
	  			</div>
	  				<div class="field-login">
	      			<label for="NEWnameProd"><font size="3">NEW Name</font></label>
	      			<input type="text" name="NEWnameProd" placeholder="Write NEW name of product" id="NEWnameProd" class="text ui-widget-content ui-corner-all">
      			</div>
      			<div class="field-login">
	      			<label for="NEWprice"><font size="3">NEW Price</font></label>
	      			<input type="text" name="NEWprice" placeholder="NEW price" id="NEWprice"  class="text ui-widget-content ui-corner-all">
	  			</div>
	  			<div class="field-login">
	      			<label for="NEWtype"><font size="3">NEW Type</font></label>
	      			<input type="text" name="NEWtype" placeholder="Write NEW type of product" id="NEWtype" class="text ui-widget-content ui-corner-all">
      			</div>
      			<div class="field-login">
	      			<label for="NEWimg"><font size="3">NEW Url to img</font></label>
	      			<input type="text" name="NEWimg" placeholder="NEW C://..." id="NEWimg"  class="text ui-widget-content ui-corner-all">
	  			</div>
	  			
   	  			<br> <input type="submit" value="Update Product" >
    		</div>
    	</fieldset>
	  </form>
	  <h1>Delete Product</h1>
	  <form method = "post" action ="${pageContext.request.contextPath}/ProductDelete">
	  	<fieldset>
    		<div class="main-login">
      			<div class="field-login">
	      			<label for="nameProd"><font size="3">Name</font></label>
	      			<input type="text" name="nameProd" placeholder="Write name of product" id="nameProd" class="text ui-widget-content ui-corner-all">
      			</div>
      			<div class="field-login">
	      			<label for="price"><font size="3">Price</font></label>
	      			<input type="text" name="price" placeholder="price" id="price"  class="text ui-widget-content ui-corner-all">
	  			</div>
	  			<div class="field-login">
	      			<label for="type"><font size="3">Type</font></label>
	      			<input type="text" name="type" placeholder="Write type of product" id="type" class="text ui-widget-content ui-corner-all">
      			</div>
      			<div class="field-login">
	      			<label for="img"><font size="3">Url to img</font></label>
	      			<input type="text" name="img" placeholder="C://..." id="img"  class="text ui-widget-content ui-corner-all">
	  			</div>
	  			
   	  			<br> <input type="submit" value="Delete NOW" >
    		</div>
    	</fieldset>
	  </form>
	 <input type="submit" onclick="history.back();" value="back"/>
	 <a href="${pageContext.request.contextPath}"><button value="home page">Click to home</button></a>
</div>
<%@include file='/WEB-INF/includes/footer.jsp' %>
