<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>  

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
        <div class="panel panel-default">
            <div class="panel-heading">
                <sp:message code="label.user.bankAccount"/>
            </div>
            <div class="panel-body">
		       <sf:form servletRelativeAction="" method="post" modelAttribute="bankAccount" cssClass="form-horizontal">
		            <sf:errors path="*" cssClass="alert alert-danger" element="div"/>
				    <sf:hidden path="id"/>
	
	                <div class="form-group">
				        <sf:label path="name" cssClass="col-sm-4 control-label">
				            <sp:message code="label.user.name"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="name" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				    
				    <div class="form-group">
				        <sf:label path="surname" cssClass="col-sm-4 control-label">
				            <sp:message code="label.familyname"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="surname" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				    
				    <div class="form-group">
				        <sf:label path="bankAccountName" cssClass="col-sm-4 control-label">
				            <sp:message code="label.user.bankAccountName"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="bankAccountName" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				    <div class="form-group">
				        <sf:label path="bankAccountNo" cssClass="col-sm-4 control-label">
				            <sp:message code="label.user.bankAccountNo"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="bankAccountNo" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				     <div class="form-group">
				        <sf:label path="bankAddress" cssClass="col-sm-4 control-label">
				            <sp:message code="label.user.bankAddress"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="bankAddress" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				     <div class="form-group">
				        <sf:label path="bankName" cssClass="col-sm-4 control-label">
				            <sp:message code="label.user.bankName"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="bankName" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				     <div class="form-group">
				        <sf:label path="ibanCode" cssClass="col-sm-4 control-label">
				            <sp:message code="label.user.ibanCode"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="ibanCode" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				     <div class="form-group">
				        <sf:label path="paypalAccount" cssClass="col-sm-4 control-label">
				            <sp:message code="label.user.paypalAccount"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="paypalAccount" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				     <div class="form-group">
				        <sf:label path="swiftCode" cssClass="col-sm-4 control-label">
				            <sp:message code="label.user.swiftCode"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="swiftCode" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				    <div class="form-group">
				        <sf:label path="country" cssClass="col-sm-4 control-label">
				            <sp:message code="label.country"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="country" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				    <div class="form-group">
				        <sf:label path="city" cssClass="col-sm-4 control-label">
				            <sp:message code="label.city"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="city" maxlength="20" cssClass="form-control" readonly="true"/>
				        </div>
				    </div>
				     <div class="form-group">
					 
					        <div class="col-md-offset-3 col-sm-1">
					            <button type="button" class="btn btn-default" onclick="history.go(-1);"><sp:message code="operate.cancel"/></button>
					        </div>
				        </div>
		       </sf:form>
		     </div>
		  </div>     
      </div>
     
</div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>
