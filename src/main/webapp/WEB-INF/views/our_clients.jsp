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
        $('#ourclient').addClass("current-menu-item");
        $('#ourclientf').addClass("current-menu-item");
    });
    </script>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

<div id="page">

	<%@ include file="./includes/header.jsp"%> 

      		<header class="page_text title">
			<h1>Our <strong>Clients</strong></h1>
		</header>




	<!-- BEGIN ARTICLE -->
	<article class="typography page_text" id="content">

		<!-- BEGIN SHORTCODES -->
		<section class="article">

		<h3>We have continuously working with following clients on various projects in over <strong>50 languages</strong>:</h3>
		
        <p>Simplified Chinese, Traditional Chinese, Japanese, Korean
          French Italian, German, Spanish, and other European Languages 
          Vietnamese, Indonesian, Thai, Malaysian, and other Asian Languages</p>
		<h3>The <strong>projects and materials</strong> we have worked on：</h3>
        
        <p>Manu; Marketing materials; corporate video; book; guidance; news release; educational material; website; software; online course.</p>
		<p> </p>
        <p> </p>
        </section>
        
        
        </article>
        
        <header class="page_text title">
			<h3><strong>Our Industry Clients:</strong></h3>
		</header>
  
        <article class="typography page_text" id="content">
        
        <section class="article">
        
        <h3>Financial Industry</h3>

		<a><img src="img/Industry Clients/financial.jpg" alt="" />
					</a>
        
        
		<h3>Manufacturing</h3>
        
        		<a><img src="img/Industry Clients/Manufacturing.jpg" alt="" />
					</a>
                    
		<h3>Automotive Industry</h3>
        
        		<a><img src="img/Industry Clients/Automotive.jpg" alt="" />
					</a>
                    
       <h3>Energy, Oil & Gas</h3>
       
    		<a><img src="img/Industry Clients/Oil & Gas.jpg" alt="" />
					</a>
        
        		<h3>Legal and Intellectual Property</h3>
        
        		<a><img src="img/Industry Clients/Legal and Intellectual.jpg" alt="" />
					</a>
                    
                    
                    		<h3>Game</h3>
        
        		<a><img src="img/Industry Clients/Game.jpg" alt="" />
					</a>
                    
                    		<h3>Electronics & Telecommunication</h3>
        
        		<a><img src="img/Industry Clients/Electronics & Telecommunication.jpg" alt="" />
					</a>
		
                            		<h3>IT & Software</h3>
        
        		<a><img src="img/Industry Clients/IT & Software.jpg" alt="" />
					</a>
                    
                                        		<h3>Hotel & Hospitality</h3>
        
        		<a><img src="img/Industry Clients/Hotel.jpg" alt="" />
					</a>
                    
                                                         		<h3>Advertising</h3>
        
        		<a><img src="img/Industry Clients/Advertising.jpg" alt="" />
					</a>
        
		</section>
		<!-- END SHORTCODES -->

	
	</section>
	<!-- END LATEST POSTS -->
        


	</article>
	<!-- END ARTICLE -->
	
	


</div>
<!--  END PAGE -->


<!--  START FOOTER -->
<%@ include file="./includes/footer.jsp"%>
<!--  END FOOTER -->



</body>
</html>