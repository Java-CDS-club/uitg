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
			<img src="img/services/Desktop Publishing.jpg" alt="" />
		</header>

<header class="page_text title">
			<h1>Desktop Publishing</h1>
	  </header>

			<div class="column article">
			  <p align="left">Desktop Publishing, also abbreviated as DTP is an important process involved in translation and publishing. DTP have various rules in different countries, and concerns many factors such as font, color, layout, images etc. In a different culture, the habitual design on a certain type of document will be different. People also have different understandings of the meaning of the colors. With different reading habits, the layout of the materials may make no sense to a foreign eye unless re-arranged accordingly. </p>
              <p align="left">Thus we help our clients make sure that their corporate representation materials as product illustration, packaging, advertising, and marketing materials are easily understood and appealing to their targeted audience through professional consulting and checkup, as well as re-design shall the need arises.</p>
              <p align="left"> (For redesign function, please kindly refer to our design service for more information. To access our design website, please go back to <a href="http://www.uitg.co">www.uitg.co</a> and click on UITG Design tab). <br>
                <br>
                UITG has a wide base of DTP software to help us better performing the process, these include Adobe Photoshop, Adobe Illustrator, Adobe InDesign, Adobe PageMaker, Adobe FrameMaker, Adobe Acrobat, Quicksilver, Quark, PageMaker, Final Cut, Webworks, PTC Arbortext EPIC Editor etc.</p>
              <p align="left">&nbsp;</p>
<p>For more information on the software and other CAT tools we use, please feel free to email us at <a href="mailto:info@uitg.co">info@uitg.co</a> to request our company brochure. </p></div>
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