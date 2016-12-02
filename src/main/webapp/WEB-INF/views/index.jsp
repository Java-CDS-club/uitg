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
       
    });

    </script>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body class="home">
  <div id="page">
     <%@ include file="./includes/header.jsp"%> 
     
     <!-- BEGIN SLIDER -->
	<div id="slider">
		<ul class="slider_photos">
			<li>
				<div class="inside">
					
					<img src="./img/examples/top_2.jpg" alt="" />
			  </div>
			</li>
		</ul>
		<div class="progressbar">
			<div class="bar"></div>
		</div>
	</div>
	<!-- END SLIDER -->


	<div class="cite_box">
		<p>We aim to <strong>better our client's market position</strong> through <strong>localization </strong> of:<p>
      <p>  company <strong>image</strong><p>
        <p> company <strong>presentation</strong>
        <p>
        <p> and company <strong>communication</strong>. </p>
	</div>




  <!-- START INFORMATIONS -->
	<section class="home_info page_text columns">
	
		<a href="#" class="column column_33">
			<h1>Who <strong>We</strong> Are?</h1>
			<span class="arrow"></span>
			<header></header>
			<p>UITG Consulting Group is a 3rd party consulting firm constantly striving to position itself as a business partner of our clients, a third eye, providing 3rd party services to our clients.</p>
    </a>
		
		<a href="/uitg/services" class="column column_33">
	<h1>Our <strong>Skills</strong> and <strong>Abilities</strong></h1>
			<span class="arrow"></span>
			<header></header>
			<p>UITG Consulting is highly recommanded by its clients for its fast response, translation precision, on time delivery, tailored client oriented solutions, and high quality cutomer service.  </p>
    </a>
		
		<a href="/uitg/workwithus" class="column column_333">
			<h1><strong>Join Us?</strong></h1>
			<span class="arrow"></span>
			<header></header>
			<p>UITG as a multi-lingual firm is always looking for qualified translators and interpreters to join us. If you are interested to work or freelance for us, please send your CV to freelance@uitg.co.</p>
		</a>

	</section>
	<!-- END INFORMATIONS -->


	<!-- START HOME PORTFOLIO -->
	<section class="home_portfolio page_text columns" style="display:none;">

		<nav class="arrows">
			<a class="next"></a>
			<a class="prev"></a>
		</nav>

	  <h1><strong>Some of Our Clients</strong></h1>

		<div id="slider_portfolio">
			<ul>
				<li class="column">
					<a ><img src="./img/company Logo/siemens_big.png" alt="" />
					</a>
				</li>
				<li class="column">
					<a ><img src="./img/company Logo/guidewire_big.png" alt="" />
					</a>
				</li>
				
				<li class="column">
					<a><img src="./img/company Logo/credit_suisse_big.png" alt="" />
					</a>
				</li>
				<li class="column">
					<a><img src="./img/company Logo/four_seasons_hotel_big.png" alt="" />
					</a>
				</li>
                
                <li class="column">
					<a><img src="./img/company Logo/ge_big.png" alt="" />
					</a>
				</li>
				<li class="column">
					<a><img src="./img/company Logo/nvidia_big.png" alt="" />
					</a>
				</li>
                
                				<li class="column">
					<a><img src="./img/company Logo/ubisoft_big.png" alt="" />
					</a>
				</li>
				<li class="column">
					<a><img src="./img/company Logo/volksvagens_big.png" alt="" />
					</a>
				</li>

			</ul>
            
            
	  </div>
      
      
		<figure class="float_right">
        
			<h3 class="more"><a href="/uitg/ourclients">More</a></h3>
            
		</figure>

	</section>
	<!-- END HOME PORTFOLIO -->

</div>
<!--  END PAGE -->

 <%@ include file="./includes/footer.jsp"%> 
</body>
</html>
