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
        $('#about').addClass("current-menu-item");
        $('#aboutf').addClass("current-menu-item");
    });
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

<div id="page">

	<%@ include file="./includes/header.jsp"%> 


	<!-- BEGIN ARTICLE -->
	<article class="columns page_text about" id="content">
	
		<header class="page_text title">
			<h1><strong>Our Motivation</strong></h1>
		</header>

		<div class="cite_box">
			<p><strong>Fast response, precision, and on time delivery</strong> motivates us to improve continuously, which in return enables us to help our <strong>clients</strong> to <strong>better</strong> their <strong>market positions</strong> even further through our services.</p>
		</div>
	
		<h2><strong>About Us</strong></h2>

		<div class="column">
			
			<p>UITG Consulting Group is a 3rd party consulting firm constantly striving to position itself as a business partner of our clients, a third eye, providing 3rd party services to our clients. Our goal is to better our client's marketing positions through localized image design, localized marketing presentation, and localized people management. </p>

			<p>UITG Translation is a boutique translation firm under UITG Consulting Group providing tailor made language solutions for our clients. We aim to better our client's market position through localization of the company image, company presentation, and company communication. Quality, precision, and on time delivery motivates us to improve continuously. </p>

			<p>Our management team and over 3000 certified language experts all around the world form our core asset in building our brand. </p>

		</div>
		
		<section class="gallery">
			<img src="./img/examples/about_us_1.jpg" alt="" width="215" height="342" />
			<img src="./img/examples/about_us_2.jpg" alt="" width="215" height="342" />
		</section>

	</article>
	<!-- END ARTICLE -->



	<!-- BEGIN ABOUT US SUMMARY -->
	<section class="columns page_text about_summary clear cite_box2">

		<h2><strong>Reviews</strong></h2>
        <p> </p>
        
		<!-- BEGIN 3 COLUMN -->
		<div class="column column_33 reviews">
	          <figure class="photo">
			<img src="./img/company Logo/E-Learning.png"/>
		  </figure>

		  <article>
          <br>
                      <h3 class="text_center"><strong>A 3rd Party E-learning Corporation</strong></h3>
          <br>
           <p>UITG has been our vendor for the past two years, they have successfully met every delivery line with sparking quality! We are in an industry that needs shorter and shorter product cycle, and UITG can truly satisfy our needs in helping us marketing out our product in time around the globe!</p>
			</article>

	  </div>
		<!-- END 3 COLUMN -->
        
        <!-- BEGIN 3 COLUMN -->
		<div class="column column_33 reviews">
	          <figure class="photo">
			<img src="./img/company Logo/Automotive.png"/>
		  </figure>
			
			<article>
            <br>
                        <h3 class="text_center"><strong>A Well Known Automotive Company</strong></h3>
            <br>
				<p>"We have worked with many vendors before UITG finds us, at the beginning we are quite reluctant to change, but UITG provided us with free trials, and earned our trust with their truly value added service free of charge! We are very happy with their fast response, and their wonderful work. People always say that one cannot rush the good things, I do not know how they did it, but they did it!"</p>

			</article>

		</div>
		<!-- END 3 COLUMN -->
        
        <!-- BEGIN 3 COLUMN -->
		<div class="column column_33 reviews">

	          <figure class="photo">
			<img src="./img/company Logo/Fashion.png"/>
		  </figure>
			
			<article>
            <br>
            <h3 class="text_center"><strong>A High End Fashion Corporation</strong></h3>
            <br>
				<p>All UITG’s translators have overseas background, and some are pure native speakers! That’s what makes them standing out I think. They have translators working with us closely, thus they are very good at grasping our high end style. Some of their translators are even loyal user of our brand! I don’t know how much their translators are getting paid (laugh), but definitely this is a very people oriented company worth of trust! </p>
             </article>
		</div>
		<!-- END 3 COLUMN -->
        
	</section>
	<!-- END ABOUT US SUMMARY -->
    
	<div>
          <p> For client's anonymity, client's company name and client contact name has been avoided here. Shall you be interested to know more about our client base, please contact us at info@uitg.co requesting for our client base sheet for more information. </p>
          <p>&nbsp;</p>
    </div>

</div>
<!--  END PAGE -->


<!--  START FOOTER -->
<%@ include file="./includes/footer.jsp"%>
<!--  END FOOTER -->



</body>
</html>