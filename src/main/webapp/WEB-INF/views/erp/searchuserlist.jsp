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
		function selectUser(){
			var val=$('input:radio[name="companyName"]:checked').val();
			var clientnameval=$('input:radio[name="companyName"]:checked').parent().next().next().text();
            if(val==null){
                alert("Please select at least one client");
                return false;
            }
            else{
                $('#client',window.opener.document).val(val);
                clientnameval= clientnameval.replace("\n","").replace("\n","").trim();
                $('#clientname',window.opener.document).val(clientnameval);
                window.close();  
            }            
     }
  </script>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body class="home">
  <div id="page">
     <%@ include file="../includes/header.jsp"%> 
      <div style="width:100%;">
      
        <sf:form servletRelativeAction="searchclient" method="post" modelAttribute="user" cssClass="form-horizontal">
        <sf:errors path="*" cssClass="alert alert-danger" element="div"/>
        
        <div class="form-group">
	               <sf:label path="companyName" cssClass="col-sm-3 control-label">
	                  <sp:message code="label.companyname"/>
	               </sf:label>
		            <div class="col-sm-3">
		             <sf:input path="companyName" maxlength="20" cssClass="form-control"/>
		           </div>
		            <div class="col-sm-2">
		              <button type="submit" class="btn btn-primary"><sp:message code="label.search"/></button>
		            </div>  
			 </div>
         <div class="panel panel-default">	
			<table class="table table-striped table-bordered table-hover table-condensed">
			    <thead>
			    <tr>
			        <th>&nbsp;</th>
			        <th><sp:message code="label.id"/></th>
			        <th><sp:message code="label.companyname"/></th>
			      
			        <th><sp:message code="label.website"/></th>
			        <th><sp:message code="label.address"/></th>
			    </tr>
			    </thead>
			    <%--@elvariable id="users" type="java.util.List"--%>
			    <c:forEach var="user" items="${clientlist}" varStatus="loop">
			        <tr>
			            <td>
			               <sf:radiobutton path="companyName" value="${user.id}"/>
			            </td>
			            <td>
			                <c:out value="${user.id}"/>
			            </td>
			            <td>
			                <c:out value="${user.companyName}"/>
			            </td>
			            <td>
			                <c:out value="${user.website}"/>
			            </td>
			           
			            <td>
			                <c:out value="${user.address}"/>
			            </td>
		         
			        </tr>
			    </c:forEach>
			</table>		
    </div> 
    <div class="col-sm-2">
      <button type="button" class="btn btn-primary" onclick="selectUser()"><sp:message code="operate.save"/></button>
    </div> 
    </sf:form>         
</div>
     
</div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>        	