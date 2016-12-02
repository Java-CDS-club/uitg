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
			<img src="img/services/machineTranslation.jpg" alt="" />
		</header>

<header class="page_text title">
			<h1>Machine Translation</h1>
	  </header>

			<div class="column article">
			  <p align="left">Machine translation (MT) is mainly for clients who have huge translation needs with a high tolerance in translation quality, and not enough time for normal solutions. </p>
              <p align="left">Lots of our customers would ask us how MT actually works, the truth is that the whole process is not purely carried out by machines, and there is human intervention as well. <br>
                <br>
                Usually MT is based on a translation software, together with a vast terminology database, the software would do an analysis on the source language including its wording habits, its grammar, and context, then gives out the software’s best guess of the meaning, then express it in another language based on grammar. Thus, machine translation is more suitable for simple grammar articles, as in this way, it is easier to get an accurate translation result. However, if the original document is way too complicated for the machine to analyze and imitate, to ensure the quality, human editing is needed. <br>
  <br>
 <h3>Our Advantage</h3>
               <p> UITG has a vast terminology database up in the cloud, with our translation software, we can help to provide the best machine translation with comparatively low cost. If certain criteria is met, we will provide FREE post machine translation editing for the clients. <br>
  <br>
                For more information on our MT, please email us at <a href="mailto:info@uitg.co"><u>info@uitg.co</u></a>. </p>
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