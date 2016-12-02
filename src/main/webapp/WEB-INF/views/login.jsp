<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <title><sp:message code="app.login"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/utils.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/selectivizr.js"></script>
	<script src="${pageContext.request.contextPath}/js/prettyphoto.js"></script>
	<script src="${pageContext.request.contextPath}/js/onload.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.jcryption.1.1.js"></script>
    <script type="text/javascript">

        $(document).ready(function() {
        	$(document).ready(function(){
            	$('#index').removeClass("current-menu-item");
            	$('#indexf').removeClass("current-menu-item");
                $('#erp').addClass("current-menu-item");
            });
            var body = $('#body');

            var height = $(window).height();
            var panelHeight = body.height();
            var top = (height - panelHeight)/3;

            body.css("margin-top", top);

            getKeys();  
        });

        function refreshCaptcha() {  
            $('#captchaImg').hide().attr(  
                    'src',  
                    '<c:url value="/jcaptcha"/>' + '?' + Math  
                            .floor(Math.random() * 100)).fadeIn();  
        }  
        
        var keys;
        $(function(){  
            
            getKeys();  
                
            var currentItem = $('#j_password');  
            $(currentItem).focus(function(){  
                $(currentItem).val("");  
            });  
            $(currentItem).blur(function(){  
                var cVal = $(currentItem).val();  
                if($.trim(cVal) != "" && "undefined" != keys && null != keys){  
                    $.jCryption.encrypt($(currentItem).val(), keys, function(encryptedPasswd) {  
                        $(currentItem).val(encryptedPasswd);  
                    });  
                }  
            });  

        }); 
        
        
        function getKeys() {  
            $.jCryption.getKeys("${pageContext.request.contextPath}/EncryptionServlet?generateKeypair=true",function(receivedKeys) {  
                keys = receivedKeys;  
            });  
              
        }  
        </script>

</head>
<body class="home">
  <div id="page">
      <%@ include file="./includes/header.jsp"%> 
      <div style="margin-left:10%;width:80%;">
        <div class="panel panel-default">
            <div class="panel-heading">
                <sp:message code="app.login"/>
            </div>
            <div class="panel-body">
                <form id="loginform" action="security_check" method="post" class="form-horizontal" >
                    <c:if test="${not empty param.error=='true'}">
                        <div class="alert alert-danger">
                            <sp:message code="validation.user.invalid"/>
                        </div>
                    </c:if>
                    <c:if test="${not empty param.error}">
                        <div class="alert alert-danger">
                            <sp:message code="validation.verificationcode.invalid"/>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <label for="j_username" class="col-md-3 control-label">
                            <sp:message code="app.login.username"/>
                        </label>
                        <div class="col-md-4">
                            <input id="j_username" name="j_username" type="text" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="j_password" class="col-md-3 control-label">
                            <sp:message code="app.login.password"/>
                        </label>
                        <div class="col-md-4">
                            <input id="j_password" name="j_password" type="password" class="form-control"/>
                        </div>
                     </div>           
                                        
                    <div class="form-group">
                        <label for="j_password" class="col-md-3 control-label">
                             <sp:message code="label.verificationcode"/>
                        </label>
                        <div class="col-md-8"> 
                           <input type='text' name='j_captcha' class="form-control required" size='5' />  
                           <img id="captchaImg" src="<c:url value="/jcaptcha"/>" />  
                           <a href="javascript:refreshCaptcha()"> <sp:message code="label.refeshimage"/></a>
                        </div>
                       
                    </div>
                    
                    <div class="form-group">  
                         <label class="col-md-3 control-label">
                            
                        </label>
                        <div class="col-md-4">  
                          <input type="checkbox" name="_spring_security_remember_me" /> <sp:message code="label.rememberme"/><br/>   
                        </div>          
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-1">
                            <button type="submit" class="btn btn-primary">
                                <sp:message code="app.login"/>
                            </button>
                        </div>
                        <div class="col-md-offset-3 col-md-2">
                          <a href="register/new" ><sp:message code="label.user.register"/></a>
                         </div>
                    </div>
                </form>
            </div>
        </div>
     </div>
     
  </div>

 <%@ include file="./includes/footer.jsp"%> 
</body>
</html>