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
	    	if($("#orderid").val()==""){
		      $("#corder").addClass("current-menu-item"); //Add "active" class to selected tab  
		    }else{
		    	$("#ordlist").addClass("current-menu-item"); //Add "active" class to selected tab  
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
      <sf:form servletRelativeAction="savecreateorder" method="post" modelAttribute="order" cssClass="form-horizontal">
       <sf:errors path="*" cssClass="alert alert-danger" element="div"/>
       <sf:hidden id ="orderid" path="id"/>
   
		<div class="panel panel-default">
					  <!-- Default panel contents -->
					  <div class="panel-heading"><sp:message code="label.order"/></div>

						<div class="form-group">
			               <sf:label path="po" cssClass="col-sm-2 control-label">
			                  <sp:message code="label.po"/>
			               </sf:label>
				            <div class="col-sm-2">
				             <sf:input id="po" path="po" maxlength="20" cssClass="form-control" readonly="true" />
				           </div>		
				           <sf:label path="orderDesc" cssClass="col-sm-4 control-label">
			                  <sp:message code="label.projectname"/>
			               </sf:label>
				            <div class="col-sm-4">
			                  <sf:input path="orderDesc" maxlength="20" cssClass="form-control"/>
			                </div>			          
			            </div>			           					    
			            
			            <div class="form-group">			            
				            <sf:label path="deliveryDate" cssClass="col-sm-2 control-label">
			                  <sp:message code="label.diliverydate"/>
			               </sf:label>
				            <div class="col-sm-4">
			                  <sf:input id="datepicker1" path="deliveryDate" maxlength="20" cssClass="form-control" placeholder="MM/DD/YYYY" readonly="true" />
			                </div>	
			            </div>
			            <div class="form-group">
					        <sf:label path="sourceLanguage" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.sourcelang"/>
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="sourceLanguage" cssClass="form-control"> 
								  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
					        <sf:label path="targetLanguage" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.targetlang"/>
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="targetLanguage" cssClass="form-control"> 
								  <sf:options items="${tarlanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
				         </div>
				
		              
        </div>          
     
     <div class="form-group">
        <div class="col-sm-offset-3 col-sm-1">
            <button type="submit" class="btn btn-primary"><sp:message code="operate.save"/></button>
        </div>
 
        <div class="col-md-offset-3 col-sm-1">
            <button type="button" class="btn btn-default" onclick="history.go(-1);"><sp:message code="operate.cancel"/></button>
        </div>
      </div>
     </sf:form>
        
       </div>
  </div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>        	