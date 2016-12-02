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
			<img src="img/services/subtitling & voiceover.jpg" alt="" />
		</header>

<header class="page_text title">
			<h1>Subtitling & Voice-over</h1>
	  </header>

			<div class="column article">
			  <p align="left">Using video and micro-films to present a company’s product or image has becoming a more and more popular way with the growing of social media popularity. Lots of our clients have huge needs in corporate video subtitling translation or voice over in order to promote their product or company image across the globe. </p>
              <p align="left">To Satisfy their needs, we started provide this subtitling and voice over service from last year, and it got very popular among our clients. </p>
              <h3 align="left">Now we offer a full set of services including:</h3>
              <li align="left"><strong>Dictation</strong>: our native speakers would write down the source language conversations in the video with the time line. </li>
                <li><strong>Translation</strong>: our subtitling translators will translate the script into various languages. </li>
                <li><strong>Loading</strong>: our engineering team will load the subtitle into the film, to make sure it matches with the timeline. At this stage, if required, we could also burn the subtitle into the film. </li>
                <li><strong>Voice-Over</strong>: Our voice-over artists will standby, and record in our voice-over studio (this studio belongs to one of our partners who runs a serious movie studios) which equipped with the most advanced voice-over equipment and technologies. </li>
                <br>
                <p>After the file is ready, we will send over the sample for our client’s inspection. Shall it be acceptable, we could also burn the video into permanent tapes or DVDs for mass production. </p>
              <p align="left">Our clients can order a whole set of service listed above, or order individual service. </p>
              <br>
<p>For more detailed information on file type, or price charges, please email us at <a href="mailto:ingo@uitg.co">ingo@uitg.co</a>. </p></div>
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