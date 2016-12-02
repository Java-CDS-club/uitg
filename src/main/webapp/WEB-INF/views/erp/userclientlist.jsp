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
	      $("#clist").addClass("current-menu-item"); //Add "active" class to selected tab  
	    });
     
	 function searchclients(){
    	var popup_width = 1024;
    	   var popup_height = 600;
    	   var popup_left = (screen.width - popup_width) / 2;
    	   var popup_top = (screen.height - popup_height) / 2;
    	   var popup_scrollbars = "no";
    	 
    	   var popup_property = "width=" + popup_width;
    	   var popup_property = popup_property + ",height=" + popup_height;
    	   var popup_property = popup_property + ",left=" + popup_left;
    	   var popup_property = popup_property + ",top=" + popup_top;
    	   var popup_property = popup_property + ",scrollbars=" + popup_scrollbars;
    	 
    	   window.open('${pageContext.request.contextPath}/user/searchclientuser','client',popup_property);
    }
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
      
        <div class="operation-bar ">
			    <a href="<c:url value="/user/add?mode=C"/>" title="Add">
			        <span class="glyphicon glyphicon-plus"></span>
			    </a>
			   <a onclick="searchclients()" >
				 <span id="searchclient" class="glyphicon glyphicon-search"></span>
			    </a>	              
		</div>
        <div class="panel panel-default" style="margin-top:20px;">

			
			<table class="table table-striped table-bordered table-hover table-condensed">
			  <thead>
			   <tr>
			        <th><sp:message code="label.custno"/></th>
			        <th><sp:message code="label.companyname"/></th>
			       
			      
			        <th><sp:message code="label.contactperson"/></th>
			        
			        <th><sp:message code="label.email"/></th>
			        <th><sp:message code="label.phone"/></th>
			        <th><sp:message code="label.status"/></th>
			        <th>&nbsp;</th>
			        <th>&nbsp;</th>
			        <th>&nbsp;</th>
			    </tr>
			    </thead>
			    <%--@elvariable id="users" type="java.util.List"--%>
			    <c:forEach var="user" items="${page.list}" varStatus="loop">
			        <tr>
			            <td>
			                <a href="<c:url value="/user/userclientinfo/?userno=${user.userno}"/>">
			                  <c:out value="${user.userno}"/>
			                </a>
			            </td>
			            <td>
			                <c:out value="${user.companyName}"/>
			            </td>
			            
			           
			            <td>
			                <c:out value="${user.firstName}"/>
			            </td>
			            
			            <td>
			                <c:out value="${user.email}"/>
			            </td>
			            <td>
			                <c:out value="${user.phone}"/>
			            </td>
			            <td>
			                <c:out value="${user.status}"/>
			            </td>
			            <td>
			                <c:if test="${user.userType==2}">
			                    <a href="<c:url value="/user/edit?id=${user.id}"/>">
			                        <span class="glyphicon glyphicon-user"></span>
			                    </a>
			                </c:if>
			            </td>
			            <td>
			                <a href="<c:url value="/user/edit?id=${user.id}"/>">
			                    <span class="glyphicon glyphicon-edit"></span>
			                </a>
			            </td>
			            <td>
			                <c:if test="${user.id != 1}">
			                    <a href="<c:url value="/user/delete?id=${user.id}"/>">
			                        <span class="glyphicon glyphicon-trash"></span>
			                    </a>
			                </c:if>
			            </td>
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