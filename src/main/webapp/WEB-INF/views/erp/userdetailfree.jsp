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
	        
	  	      $("#flist").addClass("current-menu-item"); //Add "active" class to selected tab  
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
				        
				         <sf:label path="employeeNo" cssClass="col-sm-2 control-label">
				            <sp:message code="label.employeeNo"/><span class="required">*</span>
				        </sf:label>
				         
				        <div class="col-sm-4">
				             <sf:input path="employeeNo" maxlength="20" cssClass="form-control" readonly ="${currentuser.userType != 2}"/>
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
				        <sf:label path="status" cssClass="col-sm-2 control-label">
                          <sp:message code="label.status"/>
                         </sf:label>
                         
				        <div class="col-sm-4">
				           <sf:select path="status" cssClass="form-control"> 
						    <sf:options items="${freelanceslist}" itemLabel="label" itemValue="value"/>
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
				        <sf:label path="quality" cssClass="col-sm-2 control-label">
                          <sp:message code="label.quality"/>
                         </sf:label>
                         
				        <div class="col-sm-4">
				           <sf:select path="quality" cssClass="form-control"> 
						    <sf:options items="${qualitylist}" itemLabel="label" itemValue="value"/>
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
				  
				  <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_SYSUSER,ROLE_FREELANCER">
				    
				    <div class="panel panel-default">
					   <div class="panel-heading">
	                    <sp:message code="label.personalinfo"/>
	                  </div>
	                </div> 
				    
				    <div class="form-group">				        
				        <sf:label path="motherTongue" cssClass="col-sm-2 control-label">
                           <sp:message code="label.mothertongue"/>
                         </sf:label>
				        <div class="col-sm-4">
				              <sf:select path="motherTongue" cssClass="form-control"> 
								  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
								</sf:select>
				          
				        </div>
				        
				        <sf:label path="foreignLanguage1" cssClass="col-sm-2 control-label">
                          <sp:message code="label.forelang1"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:select path="foreignLanguage1" cssClass="form-control"> 
								  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
						    </sf:select>
				           
				        </div>				       			   
				    </div>  
				    
				    <div class="form-group">				        
				        <sf:label path="foreignLanguage2" cssClass="col-sm-2 control-label">
                         <sp:message code="label.forelang2"/>
                         </sf:label>
				        <div class="col-sm-4">
				               <sf:select path="foreignLanguage2" cssClass="form-control"> 
								  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
								</sf:select>
				           
				        </div>
				        
				        <sf:label path="foreignLanguage3" cssClass="col-sm-2 control-label">
                           <sp:message code="label.forelang3"/>
                         </sf:label>
				        <div class="col-sm-4">
				           <sf:select path="foreignLanguage3" cssClass="form-control"> 
								  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
							</sf:select>				           
				        </div>				       			   
				    </div> 
				    
				    <div class="form-group">				        
				        
				        
				        <sf:label path="payType" cssClass="col-sm-2 control-label">
                           <sp:message code="label.paytype"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="payType" maxlength="50" cssClass="form-control"/>
				        </div>				       			   
				    </div> 
				    
				    <div class="form-group">
				        <sf:label path="industry" cssClass="col-sm-2 control-label">
                           <sp:message code="label.industry"/>
                         </sf:label>
				        <div class="col-sm-4">
				           <sf:select path="industry" cssClass="form-control"> 
								  <sf:options items="${industrylist}" itemLabel="label" itemValue="value"/>
							</sf:select>				           
				        </div>
				        
				        <sf:label path="region" cssClass="col-sm-2 control-label">
                          <sp:message code="label.region"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="region" maxlength="50" cssClass="form-control"/>
				        </div>
				    </div>
				    
				    <div class="form-group">
				        <sf:label path="location" cssClass="col-sm-2 control-label">
                          <sp:message code="label.location"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="location" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				        <sf:label path="title" cssClass="col-sm-2 control-label">
                          <sp:message code="label.title"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="title" maxlength="50" cssClass="form-control"/>
				        </div>
				    </div>
				    
				    <div class="form-group">
				        <sf:label path="yearsOfWorking" cssClass="col-sm-2 control-label">
                         <sp:message code="label.yearsofworking"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="yearsOfWorking" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				        <sf:label path="school" cssClass="col-sm-2 control-label">
                          <sp:message code="label.school"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="school" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				    </div>
				    
				    <div class="form-group">				        
				        <sf:label path="major" cssClass="col-sm-2 control-label">
                          <sp:message code="label.major"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="major" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				        <sf:label path="degree" cssClass="col-sm-2 control-label">
                          <sp:message code="label.degree"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="degree" maxlength="50" cssClass="form-control"/>
				        </div>
				        
				    </div>
				    
				    
				    <div class="panel panel-default">
					   <div class="panel-heading">
	                    <sp:message code="label.serviceinfo"/>
	                  </div>
	                </div>  
	                <div class="form-group">
	                   <div class="col-sm-6">
				            <div class="checkbox">
				                <label>
				                    <sf:checkbox path="translation"/>
				                    <sp:message code="label.translation"/>
				                </label>
				            </div>
				        </div>
				        
				       <sf:label path="unitPrice" cssClass="col-sm-2 control-label">
                        <sp:message code="label.quote"/>/<sp:message code="label.sourceword"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="unitPrice" maxlength="50" cssClass="form-control"/>
				        </div>   
				    </div>
		            <div class="form-group">
					        <sf:label path="sourceLanguage" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.sourcelang"/><span class="required">*</span>
	                         </sf:label>
					        <div class="col-sm-4">					            
					            <sf:select path="sourceLanguage" cssClass="form-control"> 
								  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
					        <sf:label path="targetLanguage" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.targetlang"/><span class="required">*</span>
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="targetLanguage" cssClass="form-control"> 
								  <sf:options items="${tarlanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
				     </div> 
				     
				      <div class="form-group">
					        <sf:label path="sourceLanguage2" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.sourcelang"/>2
	                         </sf:label>
					        <div class="col-sm-4">					            
					            <sf:select path="sourceLanguage2" cssClass="form-control"> 
								  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
					        <sf:label path="targetLanguage2" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.targetlang"/>2
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="targetLanguage2" cssClass="form-control"> 
								  <sf:options items="${tarlanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
				     </div> 
				     
				      <div class="form-group">
					        <sf:label path="sourceLanguage3" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.sourcelang"/>3
	                         </sf:label>
					        <div class="col-sm-4">					            
					            <sf:select path="sourceLanguage3" cssClass="form-control"> 
								  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
					        <sf:label path="targetLanguage3" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.targetlang"/>3
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="targetLanguage" cssClass="form-control"> 
								  <sf:options items="${tarlanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
				     </div> 

				     <div class="form-group">
	                   <div class="col-sm-6">
				            <div class="checkbox">
				                <label>
				                    <sf:checkbox path="trados"/>
				                    Trandos
				                </label>
				            </div>
				        </div>
				        
				       <sf:label path="tradosVersion" cssClass="col-sm-2 control-label">
                         <sp:message code="label.tradosVersion"/>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="tradosVersion" maxlength="50" cssClass="form-control"/>
				        </div>   
				    </div>
				    <div class="form-group">
	                   <div class="col-sm-6">
				            <div class="checkbox">
				                <label>
				                    <sf:checkbox path="gameLocalization"/>
				                    <sp:message code="label.gameLocalization"/>
				                </label>
				            </div>
				        </div>
				        
				       <div class="col-sm-4">
				            <div class="checkbox">
				                <label>
				                    <sf:checkbox path="transcreation"/>
				                    <sp:message code="label.transcreation"/>
				                </label>
				            </div>
				        </div>   
				    </div>

				    <div class="form-group">
	                   <div class="col-sm-6">
				            <div class="checkbox">
				                <label>
				                    <sf:checkbox path="interpreting"/>
				                    <sp:message code="label.interpreting"/>
				                </label>
				            </div>
				        </div>
				        
				       <sf:label path="unitPriceInter" cssClass="col-sm-2 control-label">
                         <sp:message code="label.quote"/>/<sp:message code="label.hour"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="unitPriceInter" maxlength="50" cssClass="form-control"/>
				        </div>   
				    </div>
				    
				    <div class="form-group">
	                   <div class="col-sm-6">
				            <div class="checkbox">
				                <label>
				                    <sf:checkbox path="subtitling"/>
				                    <sp:message code="label.subtitling"/>
				                </label>
				            </div>
				        </div>
				        
				       <sf:label path="unitPriceInter" cssClass="col-sm-2 control-label">
                         <sp:message code="label.quote"/>/<sp:message code="label.minute"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="unitPriceInter" maxlength="50" cssClass="form-control"/>
				        </div>   
				    </div>

				    <div class="form-group">
				        
				       <sf:label path="subSoftware" cssClass="col-sm-2 control-label">
                         <sp:message code="label.subSoftware"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="subSoftware" maxlength="50" cssClass="form-control"/>
				        </div>   
				    </div>
				    <div class="form-group">
	                   <div class="col-sm-6">
				            <div class="checkbox">
				                <label>
				                    <sf:checkbox path="voiceOver"/>
				                    <sp:message code="label.voiceover"/>
				                </label>
				            </div>
				        </div>
				        
				       <sf:label path="unitPriceVoice" cssClass="col-sm-2 control-label">
                         <sp:message code="label.quote"/>/<sp:message code="label.minute"/><span class="required">*</span>
                         </sf:label>
				        <div class="col-sm-4">
				            <sf:input path="unitPriceVoice" maxlength="50" cssClass="form-control"/>
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
