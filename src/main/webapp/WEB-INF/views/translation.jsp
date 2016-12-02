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
			<img src="img/services/Translation.jpg" alt="" />
		</header>

<header class="page_text title">
			<h1>Translation</h1>
	  </header>

			<div class="column article">
				
              <p align="left">Translation exists as long as human languages exist. No one remembers how early was that, but throughout time, there are rules to help deliver a precise meaning of the content across continents.</p>
              <p align="left">UITG has our own unique working process to ensure all our clients’ needs are well satisfied. We also provide tailored solutions for clients with a special requirements.  </p>
              <br>
              <h3 align="left">Our translation project cycle:</h3>
             
                <li>Client requesting a test or quotation by sending an email to our quotation team, <a href="mailto:quote@uitg.co">quote@uitg.co</a></li>
                <li>Our customer service will contact you within 24 hours of receiving the request to better understand your needs. </li>
                <li>Quotation team provide a quote, or testing team finish a test piece. </li>
                <li>Once our delivery is approved, a master contract could be signed with the client; if not, for every translation project, we will help client to issue a Purchase Order (PO). </li>
                <li>Once our cooperation starts, we will assign a project manager and a team of translators, specific for your needs, we will share their contact details shall the need arises. </li>
                <li>An invoice will be issued 3 days after final confirmation that everything is smoothly done. </li>
                <li>After the invoice date, we will give you a 15-day guarantee period at your disposal. Any questions or issues raised relating to the translation delivery within this period of time, we will help you solve it at our own cost. </li>
            
              <p align="left">&nbsp;</p>
              <h3 align="left">Our Translators: <br></h3>
               <p align="left"> All our translators are subject experts with major in translation or interpreting and minor in the subject matter. <br>
                All our translators either overseas background, or are native speakers, or native speakers residing in the targeted language speaking country. <br>
                All our translators are locally certified by country specific translation organizations such as ATA, NATTI, CATTI, etc. </p>
                <br>
              <h3 align="left">Our Project Managers: <br></h3>
               <p align="left"> Our project managers are based around the globe, in this way, we can truly operate 24/7 around the clock. </p>
               <br>
<p>For more information, please send an email to <a href="mailto:info@uitg.co">info@uitg.co</a> to request our company brochure.
<h4>&nbsp;</h4></p>
</div>
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