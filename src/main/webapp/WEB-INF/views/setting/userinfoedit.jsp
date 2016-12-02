<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	
	<title>UITG Consulting</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css" />
    
	
	<!--[if IE]>
	<script src="./js/html5.js" type="text/javascript"></script>
	
	<![endif]-->
	
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/selectivizr.js"></script>
	<script src="${pageContext.request.contextPath}/js/prettyphoto.js"></script>
	<script src="${pageContext.request.contextPath}/js/onload.js"></script>
  
    <script type="text/javascript">
    $(document).ready(function(){
    	
    });

    </script>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body class="home">
  <div id="page">
     <%@ include file="../includes/header.jsp"%> 

<sf:form servletRelativeAction="save" method="post" modelAttribute="user" cssClass="form-horizontal">
    <sf:errors path="*" cssClass="alert alert-danger" element="div"/>

    <div class="content-header">
         <h4><sp:message code="app.setting"/></h4>

    </div>

    <sf:hidden path="username"/>
    <sf:hidden path="id"/>
   
    <div class="form-group">
        <sf:label path="password" cssClass="col-sm-2 control-label">
            <sp:message code="label.user.password"/>
        </sf:label>
         
        <div class="col-sm-4">
             <sf:password path="password" maxlength="20" cssClass="form-control" />
        </div>
    </div>
    <div class="form-group">
        <sf:label path="language" cssClass="col-sm-2 control-label">
            <sp:message code="app.language"/>
        </sf:label>
         
        <div class="col-sm-3">
             <sf:select path="language" cssClass="form-control" items="${options['languages']}"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-1">
            <button type="submit" class="btn btn-primary"><sp:message code="operate.save"/></button>
        </div>
        <div class="col-sm-1">
            <button type="button" class="btn btn-default" onclick="history.go(-1);"><sp:message code="operate.cancel"/></button>
        </div>
    </div>
</sf:form>

</div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>