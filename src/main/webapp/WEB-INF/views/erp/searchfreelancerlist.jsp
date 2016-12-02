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
		function selectUser(){
			var editflag=$("#editflag").val();

			if(editflag=="N"){
				var i =10;
				var dateid="datepicker";
				var fid="searchfree";
				var fidbt="searchfreebt";
				$("input[name='username']:checked").each(function(){				
				    if ("checked" == $(this).attr("checked")) {
				    	  i=i+1;
				         var id = $(this).parent().next().text();
				         id= id.replace("\n","").replace("\n","").trim();
				         var name = $(this).parent().next().next().text();
				         var unitprice = $(this).parent().next().next().next().text();
				         dateid =  dateid+i; 
				         fid = fid+i;
				          $('#searchtable',window.opener.document).append("<tr><td>"+ "<input id='"+fid+"' type='text' name='id' value='"+id+"' size='10' style='width:50px;padding:4px;' readonly='readonly'/>"
				                  + "</td><td></td><td>"
				        		  +name + "</td><td>" 
				        		  + "<input type='text' name='count' size='10' onblur='calculatetol(this)' style='width:100px;padding:4px;'/>" + "</td><td>" + unitprice
				        		  +"</td><td>"+"<input type='text' name='subtotal' size='10' style='width:100px;padding:4px;'/>"
				        		  +"</td><td>"+"<input id='"+dateid+"' type='text' name='returndate' onclick='dateclick()' size='10' style='width:100px;padding:4px;'/>"
				        		  +"</td><td>"+"<input type='text' name='score' size='3' style='width:100px;padding:4px;'/>"+"</td></tr>");
				    }
			     })
			}else{
				var i =100;
				var dateid="datepicker";
				var fid="searchfreeedit";
				var fidbt="searchfreebtedit";
				$("input[name='username']:checked").each(function(){				
				    if ("checked" == $(this).attr("checked")) {
				    	  i=i+1;
				         var id = $(this).parent().next().text();
				         id= id.replace("\n","").replace("\n","").trim();
				         var name = $(this).parent().next().next().text();
				         var unitprice = $(this).parent().next().next().next().text();
				         dateid =  dateid+i; 
				         fid = fid+i;
				          $('#searchtableedit',window.opener.document).append("<tr><td>"+ "<input id='"+fid+"' type='text' name='id' value='"+id+"' size='10' style='width:50px;padding:4px;' readonly='readonly'/>"
				                  + "</td><td></td><td>"
				        		  +name + "</td><td>" 
				        		  + "<input type='text' name='count' size='10' style='width:100px;padding:4px;'/>" + "</td><td>" + unitprice
				        		  +"</td><td>"+"<input type='text' name='subtotal' size='10' style='width:100px;padding:4px;'/>"
				        		  +"</td><td>"+"<input id='"+dateid+"' type='text' name='returndate' onclick='dateclick()' size='10' style='width:100px;padding:4px;'/>"
				        		  +"</td><td>"+"<input type='text' name='score' size='3' style='width:100px;padding:4px;'/>"+"</td></tr>");
				    }
			     })
			}
			    
			window.close();             
     }
  </script>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body class="home">
  <div id="page">
     <%@ include file="../includes/header.jsp"%> 

      <div style="width:100%;">
      
        <sf:form servletRelativeAction="searchfreelancer" method="post" modelAttribute="user" cssClass="form-horizontal">
        <sf:errors path="*" cssClass="alert alert-danger" element="div"/>
        <input id="po" name="po" type="hidden" value="${po}">
        <input id="editflag" name="editflag" type="hidden" value="${editflag}">
 
        <div class="form-group">
	               <sf:label path="sourceLanguage" cssClass="col-sm-2 control-label">
                          <sp:message code="label.sourcelang"/>
                        </sf:label>
			        <div class="col-sm-3">					            
			            <sf:select path="sourceLanguage" cssClass="form-control"> 
						  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
						</sf:select> 
			        </div>
		           <sf:label path="username" cssClass="col-sm-2 control-label">
	                  <sp:message code="app.login.username"/>
	               </sf:label>
		            <div class="col-sm-3">
		             <sf:input path="username" maxlength="20" cssClass="form-control"/>
		           </div>
		            
			 </div>
        <div class="form-group">
                   <sf:label path="targetLanguage" cssClass="col-sm-2 control-label">
                          <sp:message code="label.targetlang"/>
                        </sf:label>
			        <div class="col-sm-3">					            
			            <sf:select path="targetLanguage" cssClass="form-control"> 
						  <sf:options items="${tarlanlist}" itemLabel="label" itemValue="value"/>
						</sf:select> 
			        </div>
	              
	                <sf:label path="industry" cssClass="col-sm-2 control-label">
                           <sp:message code="label.industry"/>
                         </sf:label>
				        <div class="col-sm-4">
				           <sf:select path="industry" cssClass="form-control"> 
								  <sf:options items="${industrylist}" itemLabel="label" itemValue="value"/>
							</sf:select>				           
				        </div>
		</div>
	       <div class="form-group">   		        
		            <div class="col-sm-2">
		              <button type="submit" class="btn btn-primary"><sp:message code="label.search"/></button>
		            </div>  
			 </div>
	 
         <div class="panel panel-default" style="width:100%;overflow:auto;position: relative; ">	
			<table class="table table-striped table-bordered table-hover table-condensed">
			    <thead>
			    <tr>
			        <th>&nbsp;</th>
			        <th><sp:message code="label.id"/></th>
			        <th><sp:message code="label.freelancer"/></th>
			        <th nowrap="nowrap"><sp:message code="label.unitprice"/></th>
			        <th nowrap="nowrap"><sp:message code="label.sourcelang"/></th>
			        <th nowrap="nowrap"><sp:message code="label.targetlang"/></th>
			        <th><sp:message code="label.status"/></th>
			        <th><sp:message code="label.quality"/></th>
			         <th><sp:message code="label.industry"/></th>
			         <th><sp:message code="label.translation"/></th>
			         <th><sp:message code="label.interpreting"/></th>
			         <th><sp:message code="label.subtitling"/></th>
			         <th nowrap="nowrap"><sp:message code="label.voiceover"/></th>
			         <th>Trados</th>
			    </tr>
			    </thead>
			    <%--@elvariable id="users" type="java.util.List"--%>
			    <c:forEach var="user" items="${clientlist}" varStatus="loop">
			        <tr>
			            <td>
			               <sf:checkbox path="username" value="${user.id}"/>
			            </td>
			            <td>
			                <c:out value="${user.id}"/>
			            </td>
			            <td>
			                <c:out value="${user.firstName}"/> 
			            </td>
			            <td nowrap="nowrap">
			                <c:out value="${user.unitPrice}"/>
			            </td>
			            <td nowrap="nowrap">		      		
		                  <c:out value="${langmap[user.sourceLanguage]}"/>
			            </td>
			            <td nowrap="nowrap">
			                <c:out value="${langmap[user.targetLanguage]}"/>
			            </td>
	                     <td>
			                <c:out value="${user.status}"/>
			            </td>
			             <td>
			                <c:out value="${user.quality}"/>
			            </td>
			            <td>
			                <c:out value="${user.industry}"/>
			            </td>
			             <td>
			                <c:out value="${user.translation}"/>
			            </td>
			             <td>
			                <c:out value="${user.interpreting}"/>
			            </td>
			             
			             <td>
			                <c:out value="${user.subtitling}"/>
			            </td>
			             <td>
			                <c:out value="${user.voiceOver}"/>
			            </td>
			             <td>
			                <c:out value="${user.trados}"/>
			            </td>
			        </tr>
			    </c:forEach>
			</table>		
      </div> 
    <div class="col-sm-2">
      <button type="button" class="btn btn-primary" onclick="selectUser()"><sp:message code="operate.save"/></button>
    </div> 
    <br/>
    </sf:form>         
</div>
     
</div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>        	