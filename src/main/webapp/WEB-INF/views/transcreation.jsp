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
        $('#services').addClass("current-menu-item");
        $('#servicesf').addClass("current-menu-item");
    });
    </script>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

<div id="page">

	<%@ include file="./includes/header.jsp"%> 


	<!-- BEGIN ARTICLE -->
	<article class="blog full page_text" id="content">
    
    <header>
			<img src="img/services/transcreation.jpg" alt="" />
		</header>

<header class="page_text title">
			<h1>Transcreation</h1>
	  </header>

			<div class="column article">
			  <p align="left">Transcreation, &quot;is a term used chiefly by advertising and marketing professionals to refer to the process of adapting a message from one language to another, while maintaining its intent, style, and tone. A successfully transcreated message evokes the same emotions and carries the same implications in the target language as it does in the source language. Increasingly, transcreation is used in global marketing campaigns as advertisers seek to transcend the boundaries of culture and language. It also takes account of images which are used within a creative message, ensuring that they are suitable for the target local market.  (Wikipedia) </p>
              <p align="left">One famous example is a reference in biblical terms &ldquo;The Lamb of God&rdquo;, the lamb symbolizes innocence. But in the Inuit (Eskimo) version of the bible, this expression is translated as &ldquo;The Seal of God&rdquo;. This is because seals represent innocence in Eskimo culture. After all, you don&rsquo;t find many lambs running around on the Arctic ice cap.<br></p>
                <br>
                <h3>Our Transcreation Service<br></h3>
                <p>We provide our clients with the best marketing/advertising transcreation writers or sometimes called &ldquo;copywriters&rdquo; in order to help our clients come up with the best local slogans or images which not only conveys the meaning of the message, but also the tone, the style, and the emotion appeal. <br></p>
                <p>All our transcreation writers enjoy a famous reputation and a long industry related experiences. For them, doing transcreation is all about fun and a sense of fulfillment. Being able to successfully introduce a new concept or improve an old concept into another language market is just as important for a company&rsquo;s survival within this market. </p>
              <p align="left">We deal advertising slogan and some published marketing materials differently. </p>
              <br>
<p>To understand more of our transcreation process, please email us at <a href="mailto:info@uitg.co">info@uitg.co</a> .</p> </div>
</article>


<!-- START SIDEBAR -->
	<aside id="sidebar" class="page_text">
	
		<!-- START Services -->
		<section id="categories">
			<h3>Services</h3>

			<ul>
				<li>
					<a href="./translation">Translation</a>
			  </li>
				<li><a href="./localization">Localization</a></li>
				<li><a href="./interpreting">Interpreting</a></li>
                <li><a href="./desktoppubish">Desktop Publishing</a></li>
                <li><a href="./subtitlingVoiceover">Subtitling & Voice-over</a></li>
                <li><a href="./transcreation">Transcreation</a></li>
                <li><a href="./machineTranslation">Machine Translation</a></li>
			</ul>
		</section>
		</section>
		<!-- END Services -->

	
	</aside>
	<!-- END SIDEBAR -->

	


</div>
<!--  END PAGE -->


<!--  START FOOTER -->
<%@ include file="./includes/footer.jsp"%>
<!--  END FOOTER -->



</body>
</html>