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
	      $("#allorder").addClass("current-menu-item"); //Add "active" class to selected tab  
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
		    <a href="<c:url value="/order/addorder"/>" title="Register">
		        <span class="glyphicon glyphicon-plus"></span>
		    </a>
		</div>
        <div class="panel panel-default">		
		 <table class="table table-striped table-bordered table-hover table-condensed">
		    <thead>
		    <tr>
		        <th><sp:message code="label.id"/></th>
		        <th><sp:message code="label.po"/></th>
		        <th><sp:message code="label.projectdate"/></th>
		        <th><sp:message code="label.diliverydate"/></th>
		        <th><sp:message code="label.sourcelang"/></th>
		        <th><sp:message code="label.targetlang"/></th>
		        <th><sp:message code="label.amount"/></th>
		        <th><sp:message code="label.status"/></th>
		        <th>&nbsp;</th>
		    </tr>
		    </thead>
		    <%--@elvariable id="users" type="java.util.List"--%>
		    <c:forEach var="order" items="${page.list}" varStatus="loop">
		        <tr>
		            <td>
		                <c:out value="${loop.index + 1}"/>
		            </td>
		            <td>
		                <c:out value="${order.po}"/>
		            </td>
		            <td>
		                <f:formatDate value="${order.orderDate}" type="both" pattern="MM/dd/yyyy"/>
		            </td>
		            <td>
		                <f:formatDate value="${order.deliveryDate}" type="both" pattern="MM/dd/yyyy"/>
		            </td>
		            <td>		      		
		                <c:out value="${langmap[order.sourceLanguage]}"/>
		            </td>
		            <td>
		                <c:out value="${langmap[order.targetLanguage]}"/>
		            </td>
		            <td>
		                <c:out value="${order.totalamt}"/>
		            </td>
		            <td>
		               <c:out value="${statusmap[order.status]}"/>		                   		              
		            </td>		    
		            <td>
		                <a href="<c:url value="/order/editorder?id=${order.id}"/>">
		                    <span class="glyphicon glyphicon-edit"></span>
		                </a>
		            </td>      
		        </tr>
		    </c:forEach>
		  </table>
		<d:pagination page="${page.pageIndex}" total="${page.totalPage}" uri="/order/allorderlist"/>
    </div>          
</div>
     
</div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>              