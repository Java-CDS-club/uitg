<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>  
<%@ taglib prefix="d" uri="https://github.com/xpjsky/devices/tags" %>
<html>
<head>
	
	<title>UITG Consulting</title>
	
	<%@ include file="../includes/jsheader.jsp"%> 
    <script type="text/javascript">
	    $(document).ready(function(){ 
	      $("#industrylist").addClass("current-menu-item"); //Add "active" class to selected tab  
	    });
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body class="home">
  <div id="page">
     <%@ include file="../includes/header.jsp"%> 
      <div id="csidebar" style="float:left;width:20%;">
        <%@ include file="../includes/csidebar.jsp"%> 
      </div>
      <div style="float:right;width:80%;">
      
        <div class="operation-bar">
			    <a href="<c:url value="/industry/create"/>" title="Add">
			        <span class="glyphicon glyphicon-plus"></span>
			    </a>
		</div>
        <div class="panel panel-default">
         
		 <table class="table table-striped table-bordered table-hover table-condensed">
		    <thead>
		    <tr>
		        <th><sp:message code="label.id"/></th>
		        <th><sp:message code="label.desc"/></th>
		        <th><sp:message code="label.industry"/></th>
		        <th>&nbsp;</th>
		    </tr>
		    </thead>
		    <%--@elvariable id="users" type="java.util.List"--%>
		    <c:forEach var="industry" items="${industrylist}" varStatus="loop">
		        <tr>
		            <td>
		                <c:out value="${loop.index + 1}"/>
		            </td>
		            <td>
		                <c:out value="${industry.industrydesc}"/>
		            </td>
		            <td>
		                <c:out value="${industry.code}"/>		                
		            </td>		        	             	 
		            <td>
		                <a href="<c:url value="/industry/edit?id=${industry.id}"/>">
		                    <span class="glyphicon glyphicon-edit"></span>
		                </a>
		            </td>          
		        </tr>
		    </c:forEach>
		</table>
    </div>          
</div>
     
</div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>              