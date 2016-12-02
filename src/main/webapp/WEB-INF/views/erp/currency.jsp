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
	      $("#currlist").addClass("current-menu-item"); //Add "active" class to selected tab  
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
                <sp:message code="label.currency"/>
            </div>
            <div class="panel-body">
		       <sf:form servletRelativeAction="save" method="post" modelAttribute="curr" cssClass="form-horizontal">
		            <sf:errors path="*" cssClass="alert alert-danger" element="div"/>
	                <sf:hidden path="id"/>
	                <div class="form-group">
				        <sf:label path="currdesc" cssClass="col-sm-4 control-label">
				            <sp:message code="label.desc"/><span class="required">*</span>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="currdesc" maxlength="20" cssClass="form-control"/>
				        </div>
				    </div>
				    
				    <div class="form-group">
				        <sf:label path="curr" cssClass="col-sm-4 control-label">
				            <sp:message code="label.currency"/><span class="required">*</span>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="curr" maxlength="20" cssClass="form-control"/>
				        </div>
				    </div>

				   <div class="form-group">
					        <div class="col-sm-offset-3 col-sm-1" >
					            <button type="submit" class="btn btn-primary"><sp:message code="operate.save"/></button>
					        </div>
					 
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
