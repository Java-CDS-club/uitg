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
	    	$('#index').removeClass("current-menu-item");
	        $('#erp').addClass("current-menu-item");
	
	        var height = $('#ccontent').height();
	   
	        $('#csidebar').css("height", height);
	       
	  	      $("#clist").addClass("current-menu-item"); //Add "active" class to selected tab  
	  	    $("#edituser").addClass("current-menu-item"); //Add "active" class to selected tab  
	  	   
	    });
    
	    var keys;
	    
	    function getKeys() {  
            $.jCryption.getKeys("${pageContext.request.contextPath}/EncryptionServlet?generateKeypair=true",function(receivedKeys) {  
                keys = receivedKeys;  
            });  
              
        }  
	    
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
    </script>
    
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body class="home">
  <div id="page">
     <%@ include file="../includes/header.jsp"%> 
      <div id="csidebar" style="float:left;width:20%;">
        <%@ include file="../includes/csidebar.jsp"%> 
      </div>
      <div id ="ccontent" style="float:right;width:80%;height:500px; overflow:auto;">
        <div class="panel panel-default">
            <div class="panel-heading">
                <sp:message code="label.user.userinfo"/>
            </div>
            <div class="panel-body">
		      <sf:form servletRelativeAction="save" method="post" modelAttribute="user" cssClass="form-horizontal">
                  <sf:errors path="*" cssClass="alert alert-danger" element="div"></sf:errors>
				     <sf:hidden path="id"/>
					 
				     <div class="form-group">
				        <sf:label path="username" cssClass="col-sm-2 control-label">
				            <sp:message code="label.user.name"/><span class="required">*</span>
				        </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="username" maxlength="20" cssClass="form-control"  readonly ="${user.id != null}"/>
				        </div>
				        
				        <sf:label path="userno" cssClass="col-sm-2 control-label">
				            <sp:message code="label.userno"/><span class="required">*</span>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="userno" maxlength="20" cssClass="form-control" readonly ="true"/>
				        </div>
				    </div>
				    
				    <div class="form-group">				        			        
				        <sf:label path="password" cssClass="col-sm-2 control-label">
				            <sp:message code="label.user.password"/>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:password id="j_password" path="password" cssClass="form-control" />
				        </div>
				    </div>
							   
				    <div class="form-group">
				        <sf:label path="language" cssClass="col-sm-2 control-label">
				            <sp:message code="app.language"/>
				        </sf:label>				         
				        <div class="col-sm-4">				           
				               <sf:select path="language" cssClass="form-control"> 
								  <sf:options items="${supportLangs}" itemLabel="label" itemValue="value"/>
								</sf:select> 				            
				        </div>
				        
				         <sf:label path="nationality" cssClass="col-sm-2 control-label">
                           <sp:message code="label.nationality"/>
                         </sf:label>
				         <div class="col-sm-4">
				            <sf:input path="nationality" maxlength="20" cssClass="form-control"/>
				         </div>
				    </div>
				    
				    <div class="form-group">
				        <sf:label path="firstName" cssClass="col-sm-2 control-label">
                            <sp:message code="label.fisrtname"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="firstName" maxlength="30" cssClass="form-control"/>
				        </div>
				        
				        <sf:label path="familyName" cssClass="col-sm-2 control-label">
                           <sp:message code="label.familyname"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="familyName" maxlength="30" cssClass="form-control"/>
				        </div>
				    </div>
				    
				    <div class="form-group">
				     <sf:label path="primaryEmail" cssClass="col-sm-2 control-label">
                           <sp:message code="label.primaryEmail"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="primaryEmail" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				        <sf:label path="email" cssClass="col-sm-2 control-label">
                           <sp:message code="label.email"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="email" maxlength="50" cssClass="form-control"/>
				        </div>				        
				       
				    </div>
				   
				     <div class="form-group">
				        <sf:label path="address" cssClass="col-sm-2 control-label">
                           <sp:message code="label.address"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="address" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				        <sf:label path="fax" cssClass="col-sm-2 control-label">
                          <sp:message code="label.fax"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="fax" maxlength="50" cssClass="form-control"/>
				        </div>
				    </div>
				    
				     <div class="form-group">		        
				        <sf:label path="zipCode" cssClass="col-sm-2 control-label">
                           <sp:message code="label.zipcode"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="zipCode" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				         <sf:label path="imAccount" cssClass="col-sm-2 control-label">
                           <sp:message code="label.imaccount"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="imAccount" maxlength="50" cssClass="form-control"/>
				        </div>
				    </div>
				   
				    <div class="form-group">
				        <sf:label path="cellPhone" cssClass="col-sm-2 control-label">
                          <sp:message code="label.cellphone"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="cellPhone" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				         <sf:label path="Phone" cssClass="col-sm-2 control-label">
                          <sp:message code="label.phone"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="Phone" maxlength="50" cssClass="form-control"/>
				        </div>
				    </div>	    
				    
				    <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_SYSUSER">
				     <div class="panel panel-default">
		             <div class="panel-heading">
                      <sp:message code="label.admin"/>
                     </div>
                    </div> 
		             <div class="form-group">				        	
                         <sf:label path="clientType" cssClass="col-sm-2 control-label">
                          <sp:message code="label.clienttype"/>
                         </sf:label>
                         
				        <div class="col-sm-4">
				           <sf:select path="clientType" cssClass="form-control"> 
						    <sf:options items="${clientTypes}" itemLabel="label" itemValue="value"/>
						   </sf:select> 	
				        </div>
		        
		                <sf:label path="userType" cssClass="col-sm-2 control-label">
                          <sp:message code="label.userType"/>
                         </sf:label>
				         <div class="col-sm-4">
				           <sf:select path="userType" cssClass="form-control"> 
						    <sf:options items="${userTypes}" itemLabel="label" itemValue="value"/>
						   </sf:select> 	
				         </div>        
				     </div>
				     <div class="form-group">	
				         <sf:label path="paymentTerms" cssClass="col-sm-2 control-label">
                          <sp:message code="label.payterms"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="paymentTerms" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				          	     
				        <div class="col-sm-4">
				            <div class="checkbox">
				                <label>
				                    <sf:checkbox path="freelancerAudit"/>
				                    <sp:message code="label.freelanceraudit"/>
				                </label>
				            </div>
				        </div>
				        
				    </div>
		          </sec:authorize>
		          		   
		          
		          <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_SYSUSER,ROLE_USER">
		            <div class="panel panel-default">
		             <div class="panel-heading">
                      <sp:message code="label.client"/>
                     </div>
                    </div> 
		        
		             <div class="form-group">				        
				        <sf:label path="companyName" cssClass="col-sm-2 control-label">
                           <sp:message code="label.companyname"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="companyName" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				        <sf:label path="website" cssClass="col-sm-2 control-label">
                           <sp:message code="label.website"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="website" maxlength="50" cssClass="form-control"/>
				        </div>				       			   
				    </div>
				    
				    <div class="form-group">				        
				        <sf:label path="currency" cssClass="col-sm-2 control-label">
		                  <sp:message code="label.currency"/><span class="required">*</span>
		               </sf:label>
			            <div class="col-sm-4">
			            <sf:select path="currency" cssClass="form-control"> 
						  <sf:options items="${currlist}" itemLabel="label" itemValue="value"/>
						</sf:select> 
			           </div> 
				        
				        <div class="col-sm-4">
				            <div class="checkbox">
				                <label>
				                    <sf:checkbox path="needInvoice"/>
				                    <sp:message code="label.needInvoice"/>
				                </label>
				            </div>
				        </div>
			       			   
				    </div>
				    
				    <div class="form-group">				       			       			        
				        <sf:label path="invoiceName" cssClass="col-sm-2 control-label">
                           <sp:message code="label.invname"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="invoiceName" maxlength="50" cssClass="form-control"/>
				        </div>				       			   
				    </div>
				    
				    <div class="form-group">				        
				        <sf:label path="invoiceReceiver" cssClass="col-sm-2 control-label">
                           <sp:message code="label.invrecevier"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="invoiceReceiver" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				        <sf:label path="invoiceTaxIdentifyNo" cssClass="col-sm-2 control-label">
                           <sp:message code="label.invtaxidenno"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="invoiceTaxIdentifyNo" maxlength="50" cssClass="form-control"/>
				        </div>				       			   
				    </div>
				   
		          </sec:authorize>
				      
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
      </div>
     
</div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>
