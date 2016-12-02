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
			<img src="img/services/localization.jpg" alt="" />
		</header>

<header class="page_text title">
			<h1>Localization</h1>
	  </header>

			<div class="column article">
			  <p align="left">In a world full of multinational companies, it is key to launch your unified product across the globe in a timely manner. Our localization services are mainly for clients with websites or software which need to be launched in many different languages and in many different cultural countries. Through our value-added localization service, we help our clients better their market positions in the local market. <br>
			    <h3>Website Localization Services</h3>
			   <p> In today’s digital age, website sometimes is even more important than name cards or company brochures, because the website itself is a digital version of the company’s representation. Thus a well presented website to the local market is very important. </p>
              <p align="left">Website localization operates in a concept that under the branding frame, which means to keep the branding element unchanged, to create a locally accepted web image. Changes in details including the website layout, paragraph adjustment, font, rewording, image change etc. <br>
                <br>
                UITG is highly experienced in providing website translation in various forms such as HTML, ASP, PHP, ASP.NET, etc. And we provide a whole set of value added services from the content analysis and abstracting to finished website testing. <br>
  <br>
 <h3>Software Localization Service</h3>
                <p>Software localization mainly involves user-interface (UI), help files, and technical documents. Software localization is no simpler than the website localization. It involves several seemingly independent localization processes yet in the end the software are a whole need to be well presented in another language. </p>
              <p align="left">Our in-house engineers can help with abstracting all the materials out and make sure they can be analyzed by CAT translation tools, and put those translated files back together once each independent translation is finished.</p>
              <br>
              <h3 align="left">Other Localization Materials We Covered: </h3>
               <li> Other Online Applications (such as Games) <br></li>
               <li> E-learning Materials<br></li>
               <li> Business Systems (ERP, CRM, Database)</li>
                <br>
<p>For more information on our<strong> Game localization</strong>, please email us at <a href="mailto:info@uitg.co">info@uitg.co</a> .
<p>&nbsp;</p>
			
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