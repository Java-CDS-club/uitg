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
        $('#wwu').addClass("current-menu-item");
        $('#wwuf').addClass("current-menu-item");
    });
    </script>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

<div id="page">

	<%@ include file="./includes/header.jsp"%> 

      		<header class="page_text title">
			<h1>Work with Us</h1>
		</header>




	<!-- BEGIN ARTICLE -->
	<article class="typography page_text" id="content">

		<!-- BEGIN SHORTCODES -->
		<section class="article">

<h3>Work with us as translator/Interpreter</h3>

<p>UITG as a multi-lingual firm is always looking for qualified translators and interpreters to join us. If you are interested to work or freelance for us, please send your CV to <a href="mailTo:freelance@uitg.co.">freelance@uitg.co.</a></p>

<h3>Work with us as sales</h3>
<p>UITG has a incentive plan for anyone who is interested or happen to have the right resources. For every client you introduce to us, we will be happy to give you a gift. Please contact us to discuss more on this matter shall you be interested. Email us at <a href="mailTo:freelancesales@utig.co">freelancesales@utig.co.</a> </p>

<h3>Work with us as our client</h3>
<P>If you are interested in our services, or if there's any files you want to be quoted, Please contact us at <a href="mailTo:quote@uitg.co">quote@uitg.co.</a> </P>

<h3>Advice and Questions:</h3>
<p>If you have any questions, or advice, please feel free to reach us at <a href="mailTo:feedback@uitg.co">feedback@uitg.co,</a> we will get back to you within 48 hours. We value your time and your input. Your opinions are very important to us. </p>

	</section>
	<!-- END LATEST POSTS -->
        


	</article>
	<!-- END ARTICLE -->
	
	


</div>
<!--  END PAGE -->


<!--  START FOOTER -->
<%@ include file="./includes/footer.jsp"%>
<!--  END FOOTER -->



</body>
</html>