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
	<article class="blog page_text" id="content">
    
    		<header class="page_text title">
			<h1><strong>Services</strong></h1>
		</header>
    
    <div class="cite_box">
			
			<p>UITG Consulting enjoys an excellent reputation among its clients for the high quality of services, customized solutions, superior project management, state-of-the-art technology, and rigorous quality assurance systems. Our services are aligned to add value to your business. </p>
        
      </div>

		<!-- Translation -->
		<div class="post columns">


<div class="column description">
				
				<h3>Translation</h3>
				
				<p>Translation exists as long as human languages exist. No one remembers how early was that, but throughout time, there are rules to help deliver a precise meaning of the content across continents ...</p>
			
	<p class="more"><a href="./translation">Read more…</a></p>
			
			</div>

		</div>
		<!-- Translation -->
		

		<!-- Localization -->
		<div class="post columns">

			<div class="column description">
				
				<h3>Localization</h3>
				
				<p>In a world full of multinational companies, it is key to launch your unified product across the globe in a timely manner. Our localization services are mainly for clients with websites or software which need to be launched in many different languages and in many different cultural countries...</p>
			
				<p class="more"><a href="./localization">Read more…</a></p>
			
			</div>

		</div>
		<!-- Localization -->
        
        		<!-- Interpreting -->
		<div class="post columns">

			<div class="column description">
				
				<h3>Interpreting</h3>
				
				<p align="left">Interpreting is very different from translation. They require two different set of skills, and two different sets of working mode as well as language thinking method. Interpreting is not just verbal translation, but verbal trans-creation...</p>
<p class="more"><a href="./interpreting">Read more…</a></p>
			
			</div>

		</div>
		<!-- Interpreting -->
		
        
	        		<!-- Desktop Publishing -->
		<div class="post columns">

			<div class="column description">
				
				<h3>Desktop Publishing</h3>
				
				<p>Desktop Publishing, also abbreviated as DTP is an important process involved in translation and publishing. DTP have various rules in different countries, and concerns many factors such as font, color, layout, images etc. In a different culture, the habitual design on a certain type of document will be...</p>
			
				<p class="more"><a href="./desktoppubish">Read more…</a></p>
			
			</div>

		</div>
		<!-- Desktop Publishing -->
        
        
                		<!-- Subtitling & Voice-over -->
		<div class="post columns">

			<div class="column description">
				
				<h3>Subtitling & Voice-over</h3>
				
				<p>Using video and micro-films to present a company’s product or image has becoming a more and more popular way with the growing of social media popularity. Lots of our clients have huge needs in corporate video subtitling translation or voice over in order to promote their product or company image across the globe...</p>
			
				<p class="more"><a href="./subtitlingVoiceover">Read more…</a></p>
			
			</div>

		</div>
		<!-- Subtitling & Voice-over -->
        
        
                		<!-- Transcreation -->
		<div class="post columns">

			<div class="column description">
				
				<h3>Transcreation</h3>
				
				<p>Transcreation, &quot;is a term used chiefly by advertising and marketing professionals to refer to the process of adapting a message from one language to another, while maintaining its intent, style, and tone. A successfully transcreated message evokes the same emotions and carries the same implications in the...</p>
			
				<p class="more"><a href="./transcreation">Read more…</a></p>
			
			</div>

		</div>
		<!-- Transcreation -->
        
        
                		<!-- Machine Translation -->
		<div class="post columns">

			<div class="column description">
				
				<h3>Machine Translation</h3>
				
				<p>Machine translation (MT) is mainly for clients who have huge translation needs with a high tolerance in translation quality, and not enough time for normal solutions...</p>
			
				<p class="more"><a href="./machineTranslation">Read more…</a></p>
			
			</div>

		</div>
		<!-- Machine Translation -->

	</article>
	<!-- END ARTICLE -->
    
    

	
	<!-- START SIDEBAR -->
	<aside id="sidebar" class="page_text">
	
		<!-- START Services -->
		<section id="categories">
			<h3>Services</h3>

			<ul>
				<li class="current-menu-item">
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