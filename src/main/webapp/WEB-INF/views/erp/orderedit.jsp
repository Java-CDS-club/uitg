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
 
    function selectActive(tab){
      $("[id^=tabli]").removeClass("active");
      $("[id^=tabdiv]").css("display","none");
    
      if(tab==1){
    	  $("#tabli1").addClass("active");
    	  $("#tabdiv1").css("display","block");
      }else  if(tab==2){
    	  $("#tabli2").addClass("active");
    	  $("#tabdiv2").css("display","block");
      }else  if(tab==3){
    	  $("#tabli3").addClass("active");
    	  $("#tabdiv3").css("display","block");
      }else  if(tab==4){
    	  $("#tabli4").addClass("active");
    	  $("#tabdiv4").css("display","block");
      }else  if(tab==5){
    	  $("#tabli5").addClass("active");
    	  $("#tabdiv5").css("display","block");
      }
    }  
    
    $(function(){ 
      $("#savebutton").click(function(){     
          //var jsobj=JSON.stringify([ {"userid":"8","po":"1234444"},{"uerid":"13","po":"3333333"}]);
          var trlen= $("#searchtable tr").length-1;
          var jsobj='[';
          var jsobj;
          var po = $("#po").val();
          var orderid = $("#orderid").val();
          var userid;
          var fpo;
          $("#searchtable tr:gt(0)").each(function (j,itemj){
        	  $(this).find("td").each(function(i,item){
        		  if(i==0){
        			userid= $(this).find('input').val();
        			jsobj=jsobj+"{\"userid\":\""+ userid +"\",";
        		  }
             
        		  jsobj=jsobj+"\"orderid\":\""+ orderid +"\",";	
        		  jsobj=jsobj+"\"po\":\""+ po +"\",";       		  
        			
        		  if(i==1){
        			  fpo= $(this).text().replace("ntttttt","").replace("ntttttt","").trim();
        			  jsobj=jsobj+"\"fpo\":\""+ fpo +"\",";
        		  }
        		  
        		  if(i==3){
        			  jsobj=jsobj+"\"count\":\""+ $(this).find('input').val() +"\",";
        		  }
        		  
        		  if(i==5){
        			  jsobj=jsobj+"\"amount\":\""+ $(this).find('input').val() +"\",";
        		  }
        		  
        		  if(i==6){
        			  jsobj=jsobj+"\"enddate\":\""+ $(this).find('input').val() +"\",";
        		  }
        		  
        		  if(i==7){
        			  jsobj=jsobj+"\"score\":\""+ $(this).find('input').val() +"\"}";
        		  }
        		 
        	  });
        	  
        	  if(trlen!=1 && j<trlen-1){
        	     jsobj=jsobj+",";
              }
          });
      
          jsobj=jsobj+']';
          //jsobj = JSON.stringify(jsobj);
          
    	  $.ajax({         
              type: "POST",
              dataType : "json",
              url:"${pageContext.request.contextPath}/order/saveorders?copyEditFlag=N",
              data:jsobj,
              contentType: "application/json; charset=utf-8",
              error: function(request) {
            	  alert("Assign order Failer!");
              },
              success: function(data) {
            	  alert("Assign order Successfully!");
              }
        });
      })
    })    
    
     $(function(){ 
      $("#savebuttonedit").click(function(){     
          //var jsobj=JSON.stringify([ {"userid":"8","po":"1234444"},{"uerid":"13","po":"3333333"}]);
          var trlen= $("#searchtableedit tr").length-1;
          var jsobj='[';
          var jsobj;
          var po = $("#po").val();
          var orderid = $("#orderid").val();
          var userid;
          var fpo;       
          
          $("#searchtableedit tr:gt(0)").each(function (j,itemj){
        	  ceflag="Y";
        	  $(this).find("td").each(function(i,item){
        		  if(i==0){
        			userid= $(this).find('input').val();
        			jsobj=jsobj+"{\"userid\":\""+ userid +"\",";
        		  }
             
        		  jsobj=jsobj+"\"orderid\":\""+ orderid +"\",";	
        		  jsobj=jsobj+"\"po\":\""+ po +"\",";       		  
        			
        		  if(i==1){
        			  fpo= $(this).text().replace("ntttttt","").replace("ntttttt","").trim();
        			  jsobj=jsobj+"\"fpo\":\""+ fpo +"\",";
        		  }
        		  
        		  if(i==3){
        			  jsobj=jsobj+"\"count\":\""+ $(this).find('input').val() +"\",";
        		  }
        		  
        		  if(i==5){
        			  jsobj=jsobj+"\"amount\":\""+ $(this).find('input').val() +"\",";
        		  }
        		  
        		  if(i==6){
        			  jsobj=jsobj+"\"enddate\":\""+ $(this).find('input').val() +"\",";
        		  }
        		  
        		  if(i==7){
        			  jsobj=jsobj+"\"score\":\""+ $(this).find('input').val() +"\"}";
        		  }
        		 
        	  });
        	  
        	  if(trlen!=1 && j<trlen-1){
        	     jsobj=jsobj+",";
              }
          });
          
          jsobj=jsobj+']';
          //jsobj = JSON.stringify(jsobj);
          
    	  $.ajax({         
              type: "POST",
              dataType : "json",
              url:"${pageContext.request.contextPath}/order/saveorders?copyEditFlag=Y",
              data:jsobj,
              contentType: "application/json; charset=utf-8",
              error: function(request) {
            	  alert("Assign order Failer!");
              },
              success: function(data) {
            	  alert("Assign order Successfully!");
              }
        });
      })
    })
      
    function teppdf(){
    	var orderid = $("#orderid").val();
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
    	 
    	   window.open('${pageContext.request.contextPath}/pdf/tep?id='+orderid,'tep',popup_property);
    }
    
    function invoicepdf(){
    	var orderid = $("#orderid").val();
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
    	 
    	   window.open('${pageContext.request.contextPath}/pdf/invoice?id='+orderid,'invoice',popup_property);
    }
    
    function proofeditpdf(){
    	var orderid = $("#orderid").val();
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
    	 
    	   window.open('${pageContext.request.contextPath}/pdf/proofedit?id='+orderid,'proofedit',popup_property);
    }
    
    $(function() {
        $("[id^=finvbt]").click(function(){
        	var po = $("#po").val();
        	var fid = $(this).parent().parent().find('input').val();
        	//var fpo = $(this).parent().parent().next().text();
           var popup_width = 1024;
      	   var popup_height = 600;
      	   var popup_left = (screen.width - popup_width) / 2;
      	   var popup_top = (screen.height - popup_height) / 2;
      	   var popup_scrollbars = "no";
      	 
      	   var popup_property = "width=" + popup_width;
      	   var popup_property = popup_property + ",height=" + popup_height;
      	   var popup_property = popup_property + ",left=" + popup_left;
      	   var popup_property = popup_property + ",top=" + popup_top;
      	   var popup_property = popup_property + ",scrollbars=" + popup_scrollbars;
      	 
      	   window.open('${pageContext.request.contextPath}/pdf/offer?po='+po+'&userid='+fid,'freelancer',popup_property);
        })
    })
    
    function searchclients(){
    	var popup_width = 1024;
    	   var popup_height = 600;
    	   var popup_left = (screen.width - popup_width) / 2;
    	   var popup_top = (screen.height - popup_height) / 2;
    	   var popup_scrollbars = "no";
    	 
    	   var popup_property = "width=" + popup_width;
    	   var popup_property = popup_property + ",height=" + popup_height;
    	   var popup_property = popup_property + ",left=" + popup_left;
    	   var popup_property = popup_property + ",top=" + popup_top;
    	   var popup_property = popup_property + ",scrollbars=" + popup_scrollbars;
    	 
    	   window.open('${pageContext.request.contextPath}/user/searchclientuser','client',popup_property);
    }
    
    function searchfreelancer(editflag){
       var popup_width = 1024;
 	   var popup_height = 600;
 	   var popup_left = (screen.width - popup_width) / 2;
 	   var popup_top = (screen.height - popup_height) / 2;
 	   var popup_scrollbars = "no";
 	 
 	   var popup_property = "width=" + popup_width;
 	   var popup_property = popup_property + ",height=" + popup_height;
 	   var popup_property = popup_property + ",left=" + popup_left;
 	   var popup_property = popup_property + ",top=" + popup_top;
 	   var popup_property = popup_property + ",scrollbars=" + popup_scrollbars;
 	   
 	   var orderpo = $("#po").val();
 	 
 	   window.open('${pageContext.request.contextPath}/user/searchfreelanceruser?po='+orderpo+'&editflag='+editflag,'freelancer',popup_property);
    }
    
    $(function() {
        $("[id^=searchfreebt]").click(function(){
           var fid = $(this).parent().parent().find('input').attr("id");
           var popup_width = 1024;
      	   var popup_height = 600;
      	   var popup_left = (screen.width - popup_width) / 2;
      	   var popup_top = (screen.height - popup_height) / 2;
      	   var popup_scrollbars = "no";
      	 
      	   var popup_property = "width=" + popup_width;
      	   var popup_property = popup_property + ",height=" + popup_height;
      	   var popup_property = popup_property + ",left=" + popup_left;
      	   var popup_property = popup_property + ",top=" + popup_top;
      	   var popup_property = popup_property + ",scrollbars=" + popup_scrollbars;
      	 
      	   var freeid = $("#"+fid).val();
      	   window.open('${pageContext.request.contextPath}/user/searchfreelanceruser?fid='+fid+'&freeid='+freeid,'freelancer',popup_property);
        })
    })
    
 
    function dateclick(){
    	$("input[name='count']").live("focus", function () {
	　　         $("input[name='returndate']").datepicker({changeMonth: true, changeYear: true });
	   });
	    $("input[name='returndate']").live("focus", function () {
	 　　          $(this).datepicker({changeMonth: true, changeYear: true });
	    });
    }
    
    function calculaterate(){
    	var uniPrice = $("#uniqueRate").val();
    	$("#repetitionRate").attr("value",(uniPrice*0.3).toFixed(2));
    	$("#match100Rate").attr("value",(uniPrice*0.5).toFixed(2));
    	$("#match95Rate").attr("value",(uniPrice*0.6).toFixed(2));
    	$("#match85Rate").attr("value",(uniPrice*0.7).toFixed(2));
    	$("#match75Rate").attr("value",(uniPrice*0.8).toFixed(2));
    	calTotal();
    }
    
    function calTotal(){
    	var proofread = ($("#proofread").val())*($("#proofreadRate").val());
    	$("#proofreadamt").text(proofread.toFixed(2));
    	var edit = ($("#edit").val())*($("#editRate").val());
    	$("#editamt").text(edit.toFixed(2));
    	var repetition = ($("#repetition").val())*($("#repetitionRate").val());
    	$("#repetitionamt").text(repetition.toFixed(2));
    	var match100 = ($("#match100").val())*($("#match100Rate").val());
    	$("#match100amt").text(match100.toFixed(2));
    	var match95 = ($("#match95").val())*($("#match95Rate").val());
    	$("#match95amt").text(match95.toFixed(2));
    	var match85 = ($("#match85").val())*($("#match85Rate").val());
    	$("#match85amt").text(match85.toFixed(2));
    	var match75 = ($("#match75").val())*($("#match75Rate").val());
    	$("#match75amt").text(match75.toFixed(2));
    	var unique = ($("#unique").val())*($("#uniqueRate").val());
    	$("#uniqueamt").text(unique.toFixed(2));
    	var filePrepration = ($("#filePrepration").val())*150;
    	$("#filePreprationamt").text(filePrepration.toFixed(2));
    	var glossary = ($("#glossary").val())*150;
    	$("#glossaryamt").text(glossary.toFixed(2));
    	var dtp = ($("#dtp").val())*($("#dtpRate").val());
    	$("#dtpamt").text(dtp.toFixed(2));
        var total = proofread+edit+repetition+match100+match95+match85+match75+unique+filePrepration+glossary+dtp;
    	
    	var projectMgmtFee =total*0.03;
    	$("#projectMgmtFeeamt").text(projectMgmtFee.toFixed(2));
    	toltal=(total+projectMgmtFee)*((100-$("#discount").val())/100);
    	$("#totalamt").attr("value",toltal.toFixed(2));
    }
    
    function calculatetol(countobj){
    	var count = $(countobj).val();
    	var unitprice = $(countobj).parent().next().text().replace("ntttttt","").replace("ntttttt","").trim();;
    	$(countobj).parent().next().next().find("input").val((count*unitprice).toFixed(2));
    }
    
    $(document).ready(function(){
    	calTotal();
    	 $("#allorder").addClass("current-menu-item"); //Add "active" class to selected tab  
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
      <sf:form servletRelativeAction="saveorder" method="post" modelAttribute="order" cssClass="form-horizontal">
       <sf:errors path="*" cssClass="alert alert-danger" element="div"/>
       <sf:hidden id ="orderid" path="id"/>
       
       <div class="panel panel-default">     
                <div class="form-group">
			               <sf:label path="po" cssClass="col-sm-2 control-label">
			                  <sp:message code="label.po"/>
			               </sf:label>
				            <div class="col-sm-2">
				             <sf:input id="po" path="po" maxlength="20" cssClass="form-control" readonly="true" />
				           </div>		
				           <sf:label path="orderDesc" cssClass="col-sm-4 control-label">
			                  <sp:message code="label.projectname"/><span class="required">*</span>
			               </sf:label>
				            <div class="col-sm-4">
			                  <sf:input path="orderDesc" maxlength="20" cssClass="form-control"/>
			                </div>			          
			            </div>			           					    
			            
			            <div class="form-group">
			               <sf:label path="orderDate" cssClass="col-sm-2 control-label">
			                  <sp:message code="label.orderdate"/><span class="required">*</span>
			               </sf:label>
				            <div class="col-sm-2">
				             <sf:input id="datepicker" path="orderDate" maxlength="20" cssClass="form-control" placeholder="MM/DD/YYYY"/>
				           </div>
				            <sf:label path="deliveryDate" cssClass="col-sm-4 control-label">
			                  <sp:message code="label.diliverydate"/><span class="required">*</span>
			               </sf:label>
				            <div class="col-sm-4">
			                  <sf:input id="datepicker1" path="deliveryDate" maxlength="20" cssClass="form-control" placeholder="MM/DD/YYYY"/>
			                </div>				           
			            </div>
			            
			            <div class="form-group">
			               <sf:label path="client" cssClass="col-sm-2 control-label">
			                  <sp:message code="label.client"/><span class="required">*</span>
			               </sf:label>
				            <div class="col-sm-2">				             
				             <sf:input  id ="clientname" path="client.companyName" maxlength="50" cssClass="form-control" readonly="true"/>
				             <sf:hidden id ="client" path="client.id"/>
				           </div>
				           &nbsp;&nbsp;
                           <c:if test="${order.client.id == null}">				           
				            <div class="col-sm-2">
				              <button id="searchclient" type="button" class="btn btn-primary" onclick="searchclients()" style="margin-left: 150px;"><sp:message code="label.search"/></button>
				            </div>	
				           </c:if>   				         
			            </div>
			            <div class="form-group">
			               <sf:label path="endDate" cssClass="col-sm-2 control-label">
			                  <sp:message code="label.enddate"/><span class="required">*</span>
			               </sf:label>
				            <div class="col-sm-2">
				             <sf:input id="datepicker2" path="returnDate" maxlength="20" cssClass="form-control" placeholder="MM/DD/YYYY"/>
				           </div>
				          				                      
			            </div>
			            <div class="form-group">
			               <sf:label path="totalamt" cssClass="col-sm-2 control-label">
			                  <sp:message code="label.totalprice"/><span class="required">*</span>
			               </sf:label>
				            <div class="col-sm-2">
				             <sf:input path="totalamt" maxlength="20" readonly="true" cssClass="form-control"/>
				           </div>
				           <sf:label path="discount" cssClass="col-sm-4 control-label">
			                  <sp:message code="label.discount"/><span class="required">*</span>
			               </sf:label>
				            <div class="col-sm-4">
				             <sf:input path="discount" maxlength="20" onblur="calTotal()" cssClass="inlinecss form-control"/>% <sp:message code="label.off"/>
				           </div>           
			            </div>
			            <div class="form-group">
					        <sf:label path="sourceLanguage" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.sourcelang"/><span class="required">*</span>
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="sourceLanguage" cssClass="form-control"> 
								  <sf:options items="${srclanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
					        <sf:label path="targetLanguage" cssClass="col-sm-3 control-label">
	                           <sp:message code="label.targetlang"/><span class="required">*</span>
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="targetLanguage" cssClass="form-control"> 
								  <sf:options items="${tarlanlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
				         </div>
				         <div class="form-group">
					         <sf:label path="status" cssClass="col-sm-2 control-label">
		                          <sp:message code="label.status"/><span class="required">*</span>
		                      </sf:label>
					          <div class="col-sm-3">					            
					            <sf:select path="status" cssClass="form-control"> 
								  <sf:options items="${statuslist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					          </div>
				  
				              <sf:label path="currency" cssClass="col-sm-3 control-label">
				                  <sp:message code="label.currency"/><span class="required">*</span>
				               </sf:label>
					            <div class="col-sm-4">
					            <sf:select path="currency" cssClass="form-control"> 
								  <sf:options items="${currlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					           </div>  
				          </div>  
		</div>
		<ul class="nav nav-pills">
		   <li id="tabli1" class="active" onclick="selectActive(1)"><a href="#"><sp:message code="label.quote"/></a></li>
		   <li id="tabli2" onclick="selectActive(2)"><a href="#"><sp:message code="label.translation"/></a></li>
		   <li id="tabli3" onclick="selectActive(3)"><a href="#"><sp:message code="label.copyedit"/></a></li>
		   <li id="tabli4" onclick="selectActive(4)"><a href="#"><sp:message code="label.submit"/></a></li>
		   <li id="tabli5" onclick="selectActive(5)"><a href="#"><sp:message code="label.finish"/></a></li>
		</ul>
		<div class="panel panel-default">
		        <div id="tabdiv1" >
		            <div class="panel panel-default">
					  <!-- Default panel contents -->
					  <div class="panel-heading"><sp:message code="label.offer"/></div>

						
					
					  <!-- Table -->
					  <table class="table">
					    <tr>
					     <th><sp:message code="label.item"/></th>
					     <th><sp:message code="label.unit"/></th>
					     <th><sp:message code="label.quantity"/></th>
					     <th><sp:message code="label.rate"/></th>
					     <th><sp:message code="label.amount"/></th>					  
					    </tr>
				        <tr>
					      <td><sp:message code="label.proof"/></td>
                           <td><sp:message code="label.hour"/></td>
                           <td><sf:input path="proofread" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="proofreadRate" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td id="proofreadamt"></td>
					     </tr> 
					     <tr>
					      <td><sp:message code="label.edit"/></td>
                           <td><sp:message code="label.hour"/></td>
                           <td><sf:input path="edit" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="editRate" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                            <td id="editamt"></td>
					     </tr> 
					      <tr>
					       <td><sp:message code="label.unique"/> </td>
                           <td><sp:message code="label.word"/></td>
                           <td><sf:input path="unique" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="uniqueRate" maxlength="50" onblur="calculaterate()" cssClass="form-control"/></td>
                           <td id="uniqueamt"></td>
					     </tr> 
					    <tr>
					      <td><sp:message code="label.repetition"/></td>
                           <td><sp:message code="label.word"/></td>
                           <td><sf:input path="repetition" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="repetitionRate" maxlength="50" readonly="true" cssClass="form-control"/></td>
                           <td id="repetitionamt"></td>
					     </tr> 
					      <tr>
					       <td><sp:message code="label.match100"/> </td>
                           <td><sp:message code="label.word"/></td>
                           <td><sf:input path="match100" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="match100Rate" maxlength="50" readonly="true" cssClass="form-control"/></td>
                           <td id="match100amt"></td>
					     </tr> 
					     <tr>
					       <td><sp:message code="label.match95"/> </td>
                           <td><sp:message code="label.word"/></td>
                           <td><sf:input path="match95" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="match95Rate" maxlength="50" readonly="true" cssClass="form-control"/></td>
                           <td id="match95amt"></td>
					     </tr> 
					     <tr>
					       <td><sp:message code="label.match85"/> </td>
                           <td><sp:message code="label.word"/></td>
                           <td><sf:input path="match85" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="match85Rate" maxlength="50" readonly="true" cssClass="form-control"/></td>
                            <td id="match85amt"></td>
					     </tr> 
					     <tr>
					       <td><sp:message code="label.match75"/> </td>
                           <td><sp:message code="label.word"/></td>
                           <td><sf:input path="match75" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="match75Rate" maxlength="50" readonly="true" cssClass="form-control"/></td>
                            <td id="match75amt"></td>
					     </tr> 				    
					    
					     <tr>
					       <td><sp:message code="label.filePrepration"/> </td>
                           <td><sp:message code="label.hour"/></td>
                           <td><sf:input path="filePrepration" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="filePrepraRate" maxlength="50" value="150" readonly="true" cssClass="form-control"/></td>
                            <td id="filePreprationamt"></td>
					     </tr> 
					     <tr>
					       <td><sp:message code="label.glossaryCreation"/> </td>
                           <td><sp:message code="label.hour"/></td>
                           <td><sf:input path="glossary" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="glossaryRate" maxlength="50" value="150" readonly="true" cssClass="form-control"/></td>
                           <td id="glossaryamt"></td>
					     </tr> 
					     <tr>
					       <td><sp:message code="label.dtp"/> </td>
                           <td><sp:message code="label.page"/></td>
                           <td><sf:input path="dtp" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td><sf:input path="dtpRate" maxlength="50" onblur="calTotal()" cssClass="form-control"/></td>
                           <td id="dtpamt"></td>
					     </tr> 
					     <tr>
					       <td><sp:message code="label.projectmgmtfee"/> </td>
                           <td><sp:message code="label.project"/></td>
                           <td><sf:input path="projectMgmtFee" maxlength="50" value="1" readonly="true" cssClass="form-control"/></td>
                           <td><sf:input path="projectMgmtFeeRate" maxlength="50" value="3" readonly="true" cssClass="inlinecss form-control"/>%</td>
                           <td id="projectMgmtFeeamt"></td>
					     </tr>
					     <tr>
                          <td></td>
                          <td></td>
                          <td></td>
                          <td></td>
				           <td>
                             <button id="tep" type="button" class="btn btn-primary" onclick="teppdf()" style=""><sp:message code="label.generatetep"/></button>
                           </td>   
					     </tr> 					    
					  </table>
					  	 
					</div>
		     
		        </div>
		        
		        <div id="tabdiv2" style="display:none;">
			         <div class="panel panel-default">			          
			          
			            <table id="searchtable" class="table table-striped table-bordered table-hover table-condensed">
			                <thead>
							    <tr>
							     <th><sp:message code="label.id"/></th>
							     <th><sp:message code="label.fpo"/></th>
							     <th><sp:message code="label.fisrtname"/></th>
							     <th><sp:message code="label.count"/></th>
							     <th><sp:message code="label.unitprice"/></th>
							     <th><sp:message code="label.total"/></th>
							     <th><sp:message code="label.enddate"/></th>
							     <th><sp:message code="label.score"/></th>					  
							    </tr>
						    </thead>
						     <tbody>
						      <c:forEach var="ord" items="${orders}" varStatus="loop">
						      
						        <tr>
						            <td nowrap="nowrap">
						               <input id='searchfree<c:out value="${loop.index}"/>' type='text' name='count' size='10' value='<c:out value="${ord.assignee.id}"/>' style='width:50px;padding:4px;' readonly="readonly"/> 
						                <c:if test="${ord.accept != 'Y'}">
						                 <a>
					                        <span id='searchfreebt<c:out value="${loop.index}"/>' class="glyphicon glyphicon-edit" title="<sp:message code="operate.user.edit"/>"></span>
					                      </a>
					                    </c:if>
					                    <a>
					                        <span id='finvbt<c:out value="${loop.index}"/>' class="glyphicon glyphicon-usd" title="<sp:message code="label.po"/>"></span>
					                    </a>					              
						            </td>
						            <td>
						                <c:out value="${ord.fpo}"/>
						            </td>
						            <td>
						                <c:out value="${ord.assignee.firstName}"/> 
						            </td>
						            <td>
						                <input type='text' name='count' size='10' value='<c:out value="${ord.characterCount}"/>' onblur='calculatetol(this)' style='width:100px;padding:4px;'/> 
						            </td>
						            <td>
						                <c:out value="${ord.assignee.unitPrice}"/>
						            </td>
						            <td>
						                <input type='text' name='subtotal' size='10' value='<c:out value="${ord.amount}"/>' style='width:100px;padding:4px;'/>
						            </td>						           
						            <td>	
						               <input id='datepicker<c:out value="${loop.index + 10}"/>' type='text' name='returndate' value='<f:formatDate value="${ord.endDate}" type="both" pattern="MM/dd/yyyy"/>'  onclick='dateclick()' size='10' style='width:100px;padding:4px;'/>					              						               
						            </td>
						              <td>
						                <input type='text' name='score' size='3' value ='<c:out value="${ord.score}"/>' style='width:100px;padding:4px;'/>
						            </td>
				         
						        </tr>
						        </c:forEach>
						     </tbody>
						</table>			           			            
			         </div> 
			          <div class="form-group">
			            <c:if test="${order.closed != 'Y'}">	  
			              <label class="col-sm-2 control-label">                          
	                      </label>
				            <div class="col-sm-2">
				              <button id="searchfree" type="button" class="btn btn-primary" onclick="searchfreelancer('N')"><sp:message code="label.search"/></button>
				            </div>					
				            <div class="col-sm-offset-3 col-sm-1">
					            <button id="savebutton" type="button" class="btn btn-primary"><sp:message code="operate.save"/></button>
					        </div>  
					     </c:if>             
			            </div>
		        </div>
		        
		        <div id="tabdiv3" style="display:none;">
		         <div class="panel panel-default">			          
			          
			            <table id="searchtableedit" class="table table-striped table-bordered table-hover table-condensed">
			                <thead>
							    <tr>
							     <th><sp:message code="label.id"/></th>
							     <th><sp:message code="label.fpo"/></th>
							     <th><sp:message code="label.fisrtname"/></th>
							     <th><sp:message code="label.count"/></th>
							     <th><sp:message code="label.unitprice"/></th>
							     <th><sp:message code="label.total"/></th>
							     <th><sp:message code="label.enddate"/></th>
							     <th><sp:message code="label.score"/></th>					  
							    </tr>
						    </thead>
						     <tbody>
						      <c:forEach var="editord" items="${editorders}" varStatus="loop">
						      
						        <tr>
						            <td nowrap="nowrap">
						               <input id='searchfreeedit<c:out value="${loop.index}"/>' type='text' name='count' size='10' value='<c:out value="${editord.assignee.id}"/>' style='width:50px;padding:4px;' readonly="readonly"/> 
						                <c:if test="${editord.accept != 'Y'}">
						                 <a>
					                        <span id='searchfreebtedit<c:out value="${loop.index}"/>' class="glyphicon glyphicon-edit" title="<sp:message code="operate.user.edit"/>"></span>
					                      </a>
					                    </c:if>
					                    <a>
					                        <span id='finvbtedit<c:out value="${loop.index}"/>' class="glyphicon glyphicon-usd" title="<sp:message code="label.po"/>"></span>
					                    </a>					              
						            </td>
						            <td>
						                <c:out value="${editord.fpo}"/>
						            </td>
						            <td>
						                <c:out value="${editord.assignee.firstName}"/> 
						            </td>
						            <td>
						                <input type='text' name='count' size='10' value='<c:out value="${editord.characterCount}"/>' onblur="calculatetol(this)" style='width:100px;padding:4px;'/> 
						            </td>
						            <td>
						                <c:out value="${editord.assignee.unitPrice}"/>
						            </td>
						            <td>
						                <input type='text' name='subtotal' size='10' value='<c:out value="${editord.amount}"/>' style='width:100px;padding:4px;'/>
						            </td>						           
						            <td>	
						               <input id='datepicker<c:out value="${loop.index + 100}"/>' type='text' name='returndate' value='<f:formatDate value="${editord.endDate}" type="both" pattern="MM/dd/yyyy"/>'  onclick='dateclick()' size='10' style='width:100px;padding:4px;'/>					              						               
						            </td>
						              <td>
						                <input type='text' name='score' size='3' value ='<c:out value="${editord.score}"/>' style='width:100px;padding:4px;'/>
						            </td>
				         
						        </tr>
						        </c:forEach>
						     </tbody>
						</table>			           			            
			         </div> 
			          <div class="form-group">
			           <c:if test="${order.closed != 'Y'}">	  
			              <label class="col-sm-2 control-label">                          
	                      </label>
				            <div class="col-sm-2">
				              <button id="searchfreeedit" type="button" class="btn btn-primary" onclick="searchfreelancer('Y')"><sp:message code="label.search"/></button>
				            </div>					
				            <div class="col-sm-offset-3 col-sm-1">
					            <button id="savebuttonedit" type="button" class="btn btn-primary"><sp:message code="operate.save"/></button>
					        </div> 
					     </c:if>              
			            </div>
		        </div>
		        <div id="tabdiv4" style="display:none;">
		         <div class="panel panel-body">
		            <div class="form-group">
					        <sf:label path="score" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.needmodify"/>
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="needModify" cssClass="form-control"> 
								  <sf:options items="${needModifylist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
					         <div class="col-sm-2">
				              <button id="proofedit" type="button" class="btn btn-primary" onclick="proofeditpdf()" style="margin-left: 50px;width:120%;"><sp:message code="label.proofedit"/></button>
				            </div>
				      </div>
				       <div class="form-group">      
				              <sf:label path="note" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.notes"/>
	                         </sf:label>
				           <div class="col-sm-4">
				            <sf:textarea path="${order.note}" cols="60" rows="6" />
				           </div> 
				    </div>				    				  
				    
				    <div class="form-group">
				        <sf:label path="score" cssClass="col-sm-2 control-label">
	                           <sp:message code="label.confirm"/>
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="confirm" cssClass="form-control"> 
								  <sf:options items="${confirmlist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>
					        <div class="col-sm-2">
				              <button id="inv" type="button" class="btn btn-primary" onclick="invoicepdf()" style="margin-left: 50px;"><sp:message code="label.invoice"/></button>
				            </div>
					 </div> 
					    
			       </div> 
		        </div>
		        <div id="tabdiv5" style="display:none;">
		          <div class="panel panel-body">
			        <div class="form-group">
					        <sf:label path="score" cssClass="col-sm-4 control-label">
	                           <sp:message code="label.cashback"/>
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="cashBack" cssClass="form-control"> 
								  <sf:options items="${cashbacklist}" itemLabel="label" itemValue="value"/>
								</sf:select> 
					        </div>				        
					    </div>
					     
			        <div class="form-group">
					        <sf:label path="score" cssClass="col-sm-4 control-label">
	                           <sp:message code="label.freelancerpay"/>
	                         </sf:label>
					        <div class="col-sm-3">					            
					            <sf:select path="freelancerPay" cssClass="form-control"> 
								  <sf:options items="${freelancerpaylist}" itemLabel="label" itemValue="value" />
								</sf:select> 
					        </div>
					 </div>
					 
					  <div class="form-group">
					   <div class="col-sm-4">
				            <div class="checkbox">
				                <label>
				                    <sf:checkbox path="isFapiaoSend"/>
				                    <sp:message code="label.fapiaosend"/>
				                </label>
				            </div>
				        </div>
				        <sf:label path="expressNo" cssClass="col-sm-3 control-label">
		                  <sp:message code="label.expressNo"/>
		               </sf:label>
			            <div class="col-sm-4">
			             <sf:input path="expressNo" maxlength="20" cssClass="form-control"/>
			           </div>
				      </div>
					  
		        </div>
			   </div>
        </div>          
     
     <div class="form-group">
       <c:if test="${order.closed != 'Y'}">	  
        <div class="form-group">
        <sf:label path="closed" cssClass="col-sm-4 control-label">
                       <sp:message code="label.closeorder"/>
                     </sf:label>
        <div class="col-sm-3">					            
            <sf:select path="closed" cssClass="form-control"> 
			  <sf:options items="${freelancerpaylist}" itemLabel="label" itemValue="value" />
			</sf:select> 
        </div>
       </div>
        <div class="col-sm-offset-3 col-sm-1">
            <button type="submit" class="btn btn-primary"><sp:message code="operate.save"/></button>
        </div>
 
        <div class="col-md-offset-3 col-sm-1">
            <button type="button" class="btn btn-default" onclick="history.go(-1);"><sp:message code="operate.cancel"/></button>
        </div>
       </c:if> 
      </div>
     </sf:form>
        
       </div>
  </div>

 <%@ include file="../includes/footer.jsp"%> 
</body>
</html>        	