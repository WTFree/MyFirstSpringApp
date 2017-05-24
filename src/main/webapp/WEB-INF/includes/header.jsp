<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="description" content="Hello from my first normal webProject">
	<title>ProjectTraineeShop</title>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
	<script>
	$(function(){
	    $('#login').click(function () {
	      $('.modal-shadow-login').show();
	    $('.modal-window-login').show();
	    });
	    $('#login2').click(function () {
		      $('.modal-shadow-login').show();
		    $('.modal-window-login').show();
		    });
	    $('.modal-shadow-login').click(function () {
	      $('.modal-shadow-login').hide();
	    $('.modal-window-login').hide();
	    });
	 
	    $('.close-login').click(function () {
	      $('.modal-shadow-login').hide();
	    $('.modal-window-login').hide();
	    });
	});
	</script>
	<script>
		$(function(){
		    $('#registration').click(function () {
		      $('.modal-shadow-registration').show();
		    $('.modal-window-registration').show();
		    });
		 
		    $('.modal-shadow-registration').click(function () {
		      $('.modal-shadow-registration').hide();
		    $('.modal-window-registration').hide();
		    });
		 
		    $('.close-registration').click(function () {
		      $('.modal-shadow-registration').hide();
		    $('.modal-window-registration').hide();
		    });
		});
	</script>
	<script>
		$(function(e){
			$("#selectBackground ul li a").click(function(e) {
			  e.preventDefault();
			  $("#selectBackground ul li a").removeClass('active');
			  $(this).addClass('active');
			})
		})
		$(function(){
			$("#HOME").click(function(){
				$(location).attr('href',"http://localhost:8080/vitaly/");
			});
			$("#AboutMe").click(function(){
				$("#content").html("<h3>My name is Vitaly Gaiduchok, I'm 22 year old. I live in Lviv and...</h3>"+
						"<br><h4>My summary of Qualifications: I’m a proactive and disciplined technical person, the one who always set clear goals and achieve them. Software Engineer with strong passion to self-development and new challenges.</h4>"+
						"<br><h4>My skills: Programming Languages/ Technologies: Java/ JDBC /OOP. J2EE/ JSP /Servlets. HTML/CSS. Python. Pascal</h4>"+
						"<br><h4>My education: Master’s Degree Ivan Franko National University of Lviv Faculty of Physics Graduated in 2017 year</h4>"+
						"<br><h4>My languages: English - Intermediate </h4>");
			});
			$("#CONTACT").click(function(){
				$("#content").html('<h4>E-mail: vitaly.gaiduchok@gmail.com</h4><br>'+
						'<h4>Phone: +38-(050)-1-555-339</h4><br>'+
						'<h4>Skype: frek4uk</h4><br>'+
						'<h4>facebook: <a href="https://www.facebook.com/profile.php?id=100003197080384" class="active">myFacebook</a></h4>');
			});
		})
	</script>
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>"type="text/css">
</head>
<body>
	<div id="wrapper">
		<header>
		<div style="height:100px">
			<div style="float:left">
				<a href="${pageContext.request.contextPath}">
					<img alt ="Logo Of Shop" id="top-image" src ="<c:url value="/resources/views/images/SHoP.png"/>">
				</a>
			</div>
			<div style="float:right; padding: 25px 0;">
				<%@include file="/WEB-INF/includes/SignUP_SignIN.jsp" %>
				<div style="float:left">		
					<form action="Search" method="get">
						<input type="text" name="name" placeholder ="Search">
						<button type="submit">Go</button>
					</form>
				</div>
			</div>
		</div>
					
			<div style="clear: both;">	
				<nav>
					<div id="selectBackground" style="background-color: #fff;">
					<ul class="top-menu">
						<li><a href="${pageContext.request.contextPath}/ProductVIEW" class="active" id="HOME">HOME</a></li>
						<li><a href="" id="AboutMe">ABOUT ME</a></li>
						<li><a href="" id="CONTACT">CONTACT</a></li>
					</ul>
					</div>
				</nav>
			</div>
			<div id="LoginJSP">
				<%@include file="/WEB-INF/includes/Login.jsp" %>
			</div>
			<div id = RegistrationJSP>
				<%@include file="/WEB-INF/includes/Registration.jsp" %>
			</div>

		</header>
