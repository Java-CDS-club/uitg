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
	      $("#flist").addClass("current-menu-item"); //Add "active" class to selected tab  
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
      <sf:form servletRelativeAction="" method="post" modelAttribute="user" cssClass="form-horizontal">
       <sf:errors path="*" cssClass="alert alert-danger" element="div"/>
     
		<div class="panel panel-default">
		      
				<div class="form-group">	               
		            <div class="col-sm-4">		         
		             <b><sp:message code="label.userno"/>:</b><c:out value="${user.userno}"/>
		           </div>		
	            </div>    
	            <div class="form-group">	
	              <div class="col-sm-4">		         
		             <b><sp:message code="label.user.name"/>:</b><c:out value="${user.firstName}"/>&nbsp;<c:out value="${user.familyName}"/> 
		           </div>	
		           
		            <div class="col-sm-2">
	                 <b><sp:message code="label.phone"/>:</b> <c:out value="${user.phone}"/>
	                </div>
	            </div>      
	            
	            <div class="form-group">	
	                 <div class="col-sm-4">	
	                   <b><sp:message code="label.mothertongue"/>:</b><c:out value="${user.motherTongue}"/> 
	                  </div>
	                  <div class="col-sm-4">			        
				        <b><sp:message code="label.forelang1"/>:</b><c:out value="${user.foreignLanguage1}"/> 
				      </div>
				      
				 </div> 
				 
				 <div class="form-group">	
	                 <div class="col-sm-4">	
	                   <b><sp:message code="label.forelang2"/>:</b><c:out value="${user.foreignLanguage2}"/> 
	                  </div>
	                  <div class="col-sm-4">			        
				        <b><sp:message code="label.forelang3"/>:</b><c:out value="${user.foreignLanguage3}"/> 
				      </div>
				      
				 </div>  
				 
				 <div class="form-group">	
	                 <div class="col-sm-4">	
	                   <b><sp:message code="label.unitprice"/>:</b><c:out value="${user.unitPrice}"/> 
	                  </div>		      
				 </div>        
				        				    
	             <div class="form-group">				         
				         <a href="<c:url value="/user/edit?id=${user.id}"/>" style="float:right;margin-right:10%;" class="btn btn-large btn-primary"><sp:message code="label.edit"/></a>
				  </div>           	       		           					    
	
        </div>
			      
		<div class="panel panel-default">          			          
            <table id="searchtable" class="table table-striped table-bordered table-hover table-condensed">
             <thead>
				    <tr>
				     <th><sp:message code="label.fpo"/></th>
				     <th><sp:message code="label.count"/></th>
				     <th><sp:message code="label.unitprice"/></th>
				     <th><sp:message code="label.amount"/></th>
				     <th><sp:message code="label.score"/></th>
				     <th><sp:message code="label.cashback"/></th>
				     <th><sp:message code="label.po"/></th>
				     <th><sp:message code="label.custname"/></th>					  
				    </tr>
			    </thead>
			     <tbody>
			      <c:forEach var="ord" items="${orderlists}" varStatus="loop">
			      
			        <tr>
			            <td>
			                <c:out value="${ord.fpo}"/>
			            </td>
			            <td>
			                <c:out value="${ord.characterCount}"/> 
			            </td>
			            <td>
			               <c:out value="${ord.assignee.unitPrice}"/>
			            </td>
			            <td>
			                <c:out value="${ord.amount}"/>
			            </td>
			            <td>
			                <c:out value="${ord.score}"/>
			            </td>						           
			            <td>
			                <c:out value="${ord.cashBack}"/>
			            </td>
			            <td>
			                <a href="<c:url value="/order/editorder/?id=${ord.id}"/>">
			                  <c:out value="${ord.po}"/>
			                </a>
			            </td>
	                    <td>
			                <c:out value="${ord.client.companyName}"/>
			            </td>
			           
			        </tr>              
			        </c:forEach>
			     </tbody>
			</table>
			 
		        
        </div>          
     

     </sf:form>
        
       </div>
  </div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>        	