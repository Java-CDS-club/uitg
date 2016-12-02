<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	
	<title>UITG Consulting</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css" />
	
	<!--[if IE]>
	<script src="./js/html5.js" type="text/javascript"></script>
	
	<![endif]-->
	
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/selectivizr.js"></script>
	<script src="${pageContext.request.contextPath}/js/prettyphoto.js"></script>
	<script src="${pageContext.request.contextPath}/js/onload.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	$('#index').removeClass("current-menu-item");
    	$('#indexf').removeClass("current-menu-item");
        $('#cs').addClass("current-menu-item");
        $('#csf').addClass("current-menu-item");
    });
    </script> 

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

<div id="page">

	<%@ include file="./includes/header.jsp"%> 



	<!-- BEGIN ARTICLE -->
	<article class="columns page_text contact" id="content">
	
		<header class="title">
			<h1><strong>Contact Us</strong></h1>
		</header>


		<!-- BEGIN INFORMATIONS -->
		<div>
		
			<h3>Info</h3>
			
			<p>If you have any questions, please feel free to contact us at:</p>
			
			<div class="contact-data">
				
				<dl>
					<dt>E-mail:</dt>
					<dd><a href="mailTo:info@uitg.co">info@uitg.co</a></dd>
				</dl>
				
				<dl>
					<dt>Phone:</dt>
					<dd>+86 1861 676 5616</dd>
				</dl>
				<dl>
					<dt>&nbsp;</dt>
					<dd>+86 1861 609 6417</dd>
				</dl>
				
			</div>
			
			<div class="contact-data">
				<p><strong>Address:</strong></p>
				<p>No.194, FengXian Rd, Jing'An Shanghai, China</p>
			</div>

		</div>
		<!-- END INFORMATIONS -->


		<!-- BEGIN FORM -->
		<div class="column column_75">
		
			
		
		</div>
		<!-- END FORM -->


	</article>
	<!-- END ARTICLE -->

</div>
<!--  END PAGE -->




<!--  START FOOTER -->
<%@ include file="./includes/footer.jsp"%>
<!--  END FOOTER -->


</body>
</html>