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
	    	if($("#orderstatus").val()!="F"){
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
      <sf:form servletRelativeAction="savechangeorder" method="post" modelAttribute="order" cssClass="form-horizontal">
       <sf:errors path="*" cssClass="alert alert-danger" element="div"/>
       <sf:hidden id ="orderid" path="id"/> 
       <sf:hidden id ="orderstatus" path="status"/>       
		
		<div class="panel panel-default">
		<div class="panel-heading"><sp:message code="label.order"/></div>
		   <div class="panel-body">    				  
	           <div class="form-group">
	               <sf:label path="endDate" cssClass="col-sm-2 control-label">
	                  <sp:message code="label.enddate"/>
	               </sf:label>
		            <div class="col-sm-2">
		             <sf:input id="datepicker" path="endDate" maxlength="20" cssClass="form-control" placeholder="MM/DD/YYYY"/>
		           </div>
				                    
			     </div>
	            <div class="form-group">
	               <sf:label path="amount" cssClass="col-sm-2 control-label">
	                  <sp:message code="label.amount"/>
	               </sf:label>
		            <div class="col-sm-2">
		             <sf:input path="amount" maxlength="20" cssClass="form-control"/>
		           </div>
		           
			        <sf:label path="accept" cssClass="col-sm-4 control-label">
                          <sp:message code="label.accept"/>
                        </sf:label>
			        <div class="col-sm-3">					            
			            <sf:select path="accept" cssClass="form-control"> 
						  <sf:options items="${acceptlist}" itemLabel="label" itemValue="value"/>
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
      </div>
     </sf:form>
        
       </div>
  </div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>        	