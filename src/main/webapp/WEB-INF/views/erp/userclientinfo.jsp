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
		            <div class="col-sm-4">
	                   <b><sp:message code="label.companyname"/>:</b><c:out value="${user.companyName}"/>
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
	                <div class="col-sm-8">
	                   <b><sp:message code="label.address"/>:</b><c:out value="${user.address}"/>
	                </div>	
	            </div>
	            <div class="form-group">	    
	                 <div class="col-sm-4">
	                  <b><sp:message code="label.invname"/>:</b><c:out value="${user.invoiceName}"/>
	                </div>			    
	                 <div class="col-sm-4">
	                  <b><sp:message code="label.invrecevier"/>:</b><c:out value="${user.invoiceReceiver}"/>
	                </div>	      
	            </div>	
	            
	            <div class="form-group">	                     	                            	               
	                 <div class="col-sm-8">
	                  <b><sp:message code="label.invtaxidenno"/>:</b><c:out value="${user.invoiceTaxIdentifyNo}"/>
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
				     <th><sp:message code="label.po"/></th>
				     <th><sp:message code="label.orderdate"/></th>
				     <th><sp:message code="label.diliverydate"/></th>
				     <th><sp:message code="label.sourcelang"/></th>
				     <th><sp:message code="label.amount"/></th>
				     <th><sp:message code="label.cashback"/></th>
				     <th><sp:message code="label.freelancer"/></th>
				     <th><sp:message code="label.freelancerpay"/></th>	
				     <th><sp:message code="label.status"/></th>					  
				    </tr>
			    </thead>
			     <tbody>
			      <c:forEach var="ord" items="${orderlists}" varStatus="loop">
			      
			        <tr>
			            <td>
			              <a href="<c:url value="/order/editorder/?id=${ord.id}"/>">
			                <c:out value="${ord.po}"/>
			               </a>
			            </td>
			            <td>
			                <f:formatDate value="${ord.orderDate}" type="both" pattern="MM/dd/yyyy"/>
			            </td>
			            <td>
			               <f:formatDate value="${ord.deliveryDate}" type="both" pattern="MM/dd/yyyy"/>			              
			            </td>
			            <td>		      		
		                 <c:out value="${langmap[ord.sourceLanguage]}"/>
		                </td>

			            <td>
			                <c:out value="${ord.totalamt}"/>
			            </td>						           
			            <td>
			                <c:out value="${ord.cashBack}"/>
			            </td>
			              <td>
			                <c:out value="${ord.assignee.userno}"/>
			            </td>
	                    <td>
			                <c:out value="${ord.freelancerPay}"/>
			            </td>
			            <td>
			                <c:out value="${statusmap[ord.status]}"/>            
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