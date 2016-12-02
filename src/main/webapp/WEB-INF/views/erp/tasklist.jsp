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
	    	if($("#ltask").val()=="F"){
			      $("#latesttask").addClass("current-menu-item"); //Add "active" class to selected tab  
			    }else{
			    	$("#tasklist").addClass("current-menu-item"); //Add "active" class to selected tab  
			    }
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
      
        <div class="panel panel-default" style="width:100%;overflow:auto;position: relative; ">
        <input type="hidden" id ="ltask" value="${latesttask}"/>

		<table class="table table-striped table-bordered table-hover table-condensed">
		    <thead>
		    <tr>
		        <th><sp:message code="label.id"/></th>
		        <th><sp:message code="label.fpo"/></th>
		        <th><sp:message code="label.projectdate"/></th>
		        <th><sp:message code="label.diliverydate"/></th>
		        <th><sp:message code="label.sourcelang"/></th>
		        <th><sp:message code="label.targetlang"/></th>
		        <th><sp:message code="label.amount"/></th>
		        <th><sp:message code="label.status"/></th>
		        <th><sp:message code="label.payment"/></th>
		        <th><sp:message code="label.score"/></th>
		        
		        <th><sp:message code="label.accepted"/></th>
		        
		        <c:if test="${order.status != 'F'}">
		        <th>&nbsp;</th>
		        </c:if>
		    </tr>
		    </thead>
		    <%--@elvariable id="users" type="java.util.List"--%>
		    <c:forEach var="order" items="${page.list}" varStatus="loop">
		        <tr>
		            <td>
		                <c:out value="${loop.index + 1}"/>
		            </td>
		            <td>
		                <c:out value="${order.fpo}"/>
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
		                <c:out value="${order.amount}"/>
		            </td>
		            <td>
		                <c:out value="${statusmap[order.status]}"/>        		              
		            </td>
		            <td>		
		                <c:if test="${order.freelancerPay == 'Y'}">
		                 <span class="glyphicon glyphicon-ok"></span>
		                </c:if>
		                <c:if test="${order.freelancerPay != 'Y'}">
		                 <span class="glyphicon glyphicon-remove"></span>   
		                 </c:if>           
		            </td>
		            <td>
		                <c:out value="${order.score}"/>        		              
		            </td>
		             <td>		
		                <c:if test="${order.accept == 'Y'}">
		                 <sp:message code="label.accepted"/>
		                </c:if>
		                <c:if test="${order.accept == 'N'}">
		                 <sp:message code="label.refused"/>
		                 </c:if> 
		                 <c:if test="${order.accept == null}">
		                 <sp:message code="label.pending"/>
		                 </c:if>              
		            </td>	
		            <c:if test="${order.status != 'F'}">
		            <td>
		                <a href="<c:url value="/order/changeorder?id=${order.id}"/>">
		                    <span class="glyphicon glyphicon-edit"></span>
		                </a>
		            </td> 	
		           </c:if>           
		        </tr>
		    </c:forEach>
		</table>
		<d:pagination page="${page.pageIndex}" total="${page.totalPage}" uri="/order/tasklist"/>
    </div>          
</div>
     
</div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>              