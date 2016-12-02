<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title><sp:message code="app.login"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/utils.js"></script>
    <script type="text/javascript">

        $(document).ready(function() {
            var body = $('#body');

            var height = $(window).height();
            var panelHeight = body.height();
            var top = (height - panelHeight)/3;

            body.css("margin-top", top);
        });

    </script>
</head>
<body>
<div id="body" class="container-fluid">
    <div class="col-md-offset-4 col-md-4">
        <div class="panel panel-default">
         
            <div class="panel-body">
               
                    <div class="form-group">
                        Congratulations! You have registered successfully!
                    </div>
                    
                    <div class="form-group">	                 
                        <div class="col-md-offset-3 col-md-2">
                          <a href="/uitg/login" ><sp:message code="operate.ok"/></a>
                         </div>
	                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>