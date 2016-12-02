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
			<img src="img/services/Interpreting.jpg" alt="" />
		</header>

<header class="page_text title">
			<h1>Interpreting</h1>
	  </header>

			<div class="column article">
			  <p align="left">Interpreting is very different from translation. They require two different set of skills, and two different sets of working mode as well as language thinking method. Interpreting is not just verbal translation, but verbal trans-creation. </p>
              <p align="left">UITG provide all kinds of tailored interpreting services for our clients. </p>
              <br>
              <h3 align="left">General Interpreting Service:</h3>
            <p>This is a type of less intensive interpreting. Usually this is for visiting, touring, or banquet. Usually this type of interpreting happens in casual situations, and does not need special equipment, nor does interpreter need to have a specific subject matter knowledge. <br></p>
  <br>
  <h3>Consecutive Interpreting Service</h3>
<p>Consecutive interpreting requires interpreter has great note taking skills as usually the speaker would stop and allow time for interpreters to interpret what he just said. This type of service is usually provided to one on one question-and-answer settings such as legal trials and hospital appointments, or to group meetings where there’s one or two key speakers such as news release. </p>
              <p align="left">Usually this does not require specific tools such as interpreting booth, but in meetings, microphone might be prepared for interpreters. Consecutive interpreting is usually bi-directional. <br>
                <br>
                <h3>Simultaneous Interpreting Service</h3>
                <p>Simultaneous interpreting is used in high end summit meetings held by the UN or EU or other similar multinational organizations in which time is of the essence. </p>
              <p align="left">Simultaneous interpreters only work from 1st foreign language into their mother tongue, but for Chinese interpreters things are a little bit different as they sometimes translate into English too. For very rare languages, a relay would be in use, which means words being interpreted from this language into English first, then into other languages. </p>
              <p align="left">Simultaneous interpreting is usually 4-5 seconds behind the original speech, thus it is a very intensive work. Usually one booth will have two interpreters, and they work in turns, each for 20 minutes, this is the maximum time for a simultaneous interpreter to work for one round and ensure the quality. </p>
              <br>
              <p align="left">For more information, please email us at <a href="mailto:info@uitg.co">info@uitg.co</a>. </p>
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