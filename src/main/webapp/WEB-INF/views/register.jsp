<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
            var body = $('#body');

            var height = $(window).height();
            var panelHeight = body.height();
            var top = (height - panelHeight)/3;

            body.css("margin-top", top);
            $("div[id^='clientid']").css("display","block");
    		$("div[id^='freeid']").css("display","none");
        });
        
        function refreshCaptcha() {  
            $('#captchaImg').hide().attr(  
                    'src',  
                    '<c:url value="/jcaptcha"/>' + '?' + Math  
                            .floor(Math.random() * 100)).fadeIn();  
        } 
        
        function openterms(){
        	var popup_width = 900;
        	   var popup_height = 600;
        	   var popup_left = (screen.width - popup_width) / 2;
        	   var popup_top = (screen.height - popup_height) / 2;
        	   var popup_scrollbars = "no";
        	 
        	   var popup_property = "width=" + popup_width;
        	   var popup_property = popup_property + ",height=" + popup_height;
        	   var popup_property = popup_property + ",left=" + popup_left;
        	   var popup_property = popup_property + ",top=" + popup_top;
        	   var popup_property = popup_property + ",scrollbars=" + popup_scrollbars;
        	 
        	   window.open('${pageContext.request.contextPath}/register/terms','terms',popup_property);
        }
        
        function openprivicy(){
        	var popup_width = 900;
        	   var popup_height = 600;
        	   var popup_left = (screen.width - popup_width) / 2;
        	   var popup_top = (screen.height - popup_height) / 2;
        	   var popup_scrollbars = "no";
        	 
        	   var popup_property = "width=" + popup_width;
        	   var popup_property = popup_property + ",height=" + popup_height;
        	   var popup_property = popup_property + ",left=" + popup_left;
        	   var popup_property = popup_property + ",top=" + popup_top;
        	   var popup_property = popup_property + ",scrollbars=" + popup_scrollbars;
        	 
        	   window.open('${pageContext.request.contextPath}/register/privicy','privicy',popup_property);
        }
        
       var keys;
	    
	    function getKeys() {  
            $.jCryption.getKeys("${pageContext.request.contextPath}/EncryptionServlet?generateKeypair=true",function(receivedKeys) {  
                keys = receivedKeys;  
            });  
              
        }  
	    
        $(function(){  
            
            getKeys();  
                
            var hasPass = $('input:password');   
              
            $(hasPass).each(function(index){  
                var currentItem = $(this);  
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

        }); 
        
        function clickcheckbx(obj){
        	if(obj.checked){
        		$("div[id^='clientid']").css("display","none");
        		$("div[id^='freeid']").css("display","block");
        	}else{
        		$("div[id^='clientid']").css("display","block");
        		$("div[id^='freeid']").css("display","none");
        	}
        }

        </script>
</head>
<body class="home">
  <div id="page">
      <%@ include file="./includes/header.jsp"%> 
      <div style="margin-left:10%;width:80%;">
	      <div class="panel panel-default">
	            <div class="panel-heading">
	               <sp:message code="app.signup"/>
	            </div>
	            <div class="panel-body">
	                 <sf:form servletRelativeAction="registerSub" method="post" modelAttribute="registrant"  class="form-horizontal">
                         <div style="width:100%;text-align:center;height:40px;">
                              <sf:errors path="*" cssClass="alert alert-danger" style="width:100%;"></sf:errors>
                         </div>
              
                        <div class="form-group">                       
                              <label class="col-md-3 control-label">
			                    
			                  </label>
				              <div class="col-md-4 checkbox">
				                    <label> <sf:checkbox path="freelancer" onclick="clickcheckbx(this)"/> <sp:message code="label.iamfreelancer"/></label> 				                
				              </div>
				            
                         </div>
                         
	                    <div class="form-group">
	                        <label for="username" class="col-md-3 control-label">
	                           <sp:message code="app.login.username"/><span class="required">*</span>
	                        </label>
	                        <div class="col-md-4">
	                            <sf:input  path="username"  cssClass="form-control"/>
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <label for="password" class="col-md-3 control-label">
	                             <sp:message code="app.login.password"/><span class="required">*</span>
	                        </label>
	                        <div class="col-md-4">
	                            <sf:password id="j_password" path="password" cssClass="form-control"/>
	                        </div>
	                    </div>
	                    
	                    <div class="form-group">
	                        <label for="confirmPassword" class="col-md-3 control-label">
	                             <sp:message code="label.confirmpwd"/><span class="required">*</span>
	                        </label>
	                        <div class="col-md-4">
	                            <sf:password path="confirmPassword"  cssClass="form-control"/>
	                        </div>
	                    </div>
	                    
	                <div class="form-group">
				        <sf:label path="firstName" cssClass="col-sm-3 control-label">
                            <sp:message code="label.fisrtname"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="firstName" maxlength="30" cssClass="form-control"/>
				        </div>
				     </div>
				    <div class="form-group">    
				        <sf:label path="familyName" cssClass="col-sm-3 control-label">
                           <sp:message code="label.familyname"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="familyName" maxlength="30" cssClass="form-control"/>
				        </div>
				    </div>
				    
				    <div class="form-group">
				     <sf:label path="primaryEmail" cssClass="col-sm-3 control-label">
                           <sp:message code="label.primaryEmail"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="primaryEmail" maxlength="50" cssClass="form-control"/>
				        </div>				       
				    </div>
				    <div class="form-group" id="clientid1">				        
				        <sf:label path="companyName" cssClass="col-sm-3 control-label">
                           <sp:message code="label.companyname"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="companyName" maxlength="50" cssClass="form-control"/>
				        </div>		       			   
				    </div>
				    <div class="form-group" id="clientid2">				       			       			        
				        <sf:label path="invoiceName" cssClass="col-sm-3 control-label">
                           <sp:message code="label.invname"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="invoiceName" maxlength="50" cssClass="form-control"/>
				        </div>				       			   
				    </div>
				    
				    <div class="form-group" id="clientid3">				        
				        <sf:label path="invoiceReceiver" cssClass="col-sm-3 control-label">
                           <sp:message code="label.invrecevier"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="invoiceReceiver" maxlength="50" cssClass="form-control"/>
				        </div>
				     </div>
				    
				     <div class="form-group" id="freeid1">
					        <sf:label path="sourceLanguage" cssClass="col-sm-3 control-label">
	                           <sp:message code="label.sourcelang"/><span class="required">*</span>
	                         </sf:label>
					        <div class="col-sm-4">					            
					            <sf:select path="sourceLanguage" cssClass="form-control"> 
								  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
					 </div> 
				    <div class="form-group" id="freeid2">      
					        <sf:label path="targetLanguage" cssClass="col-sm-3 control-label">
	                           <sp:message code="label.targetlang"/><span class="required">*</span>
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="targetLanguage" cssClass="form-control"> 
								  <sf:options items="${tarlanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
				     </div>  
				      <div class="form-group" id="freeid3">				        
				        <sf:label path="unitPrice" cssClass="col-sm-3 control-label">
                         <sp:message code="label.unitprice"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="unitPrice" maxlength="50" cssClass="form-control"/>
				        </div>
		       			   
				    </div> 
	                    
	                     <div class="form-group">
	                        <label for="verifyCode" class="col-md-3 control-label">
	                             <sp:message code="label.verificationcode"/><span class="required">*</span>
	                        </label>
	                        <div class="col-md-8"> 
	                           <sf:input path='verifyCode' cssClass="form-control required"/>  
	                           <img id="captchaImg" src="<c:url value="/jcaptcha"/>" />  
	                           <a href="javascript:refreshCaptcha()"> <sp:message code="label.refeshimage"/></a>
	                        </div>
	                       
                         </div>
                         
                         <div class="form-group">
                             <label class="col-md-3 control-label">
			                    
			                  </label>
				              <div class="col-md-7">
				               <label>
	                             <sp:message code="label.agreement"/> 
	                             <a onclick="openterms()"><sp:message code="label.terms"/> </a>
	                             &nbsp;<sp:message code="label.and"/> &nbsp;
	                             <a onclick="openprivicy()"><sp:message code="label.privicy"/></a>
	                            </label>  
	                         </div>	                        	                       
                         </div>                          
	
	                    <div class="form-group">
	                        <div class="col-md-offset-3 col-md-1">
	                            <button type="submit" class="btn btn-primary">
	                                <sp:message code="operate.submit"/>
	                            </button>
	                        </div>
	                        <div class="col-md-offset-3 col-md-2">
	                          <button type="button" class="btn btn-default" onclick="history.go(-1);"><sp:message code="operate.cancel"/></button>
	                         </div>
	                    </div>
	                </sf:form>
	            </div>
	        </div>

     </div>
  </div>

 <%@ include file="./includes/footer.jsp"%> 
</body>
</html>