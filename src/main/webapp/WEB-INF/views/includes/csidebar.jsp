   <ul class="dropdown-menu" style="display:block !important;">
          <sec:authorize ifAnyGranted="ROLE_USER">
             <li id="corder">
               <a href="<c:url value="/order/createorder"/>">
                 <sp:message code="label.placeneworder"/>
               </a>
             </li>
             <li id="ordlist">
               <a href="<c:url value="/order/orderlist"/>">
                 <sp:message code="label.orderhistory"/>
               </a>
             </li>
          </sec:authorize>
          <sec:authorize ifAnyGranted="ROLE_FREELANCER">
             <li id="latesttask">
               <a href="<c:url value="/order/tasklist?status=F"/>">
                 <sp:message code="label.latesttask"/>
               </a>
             </li>
             <li id="tasklist">
               <a href="<c:url value="/order/tasklist"/>">
                 <sp:message code="label.mytask"/>
               </a>
             </li>
          </sec:authorize>
          <sec:authorize ifAnyGranted="ROLE_USER,ROLE_FREELANCER">
             <li id="edituser">
                <a href="<c:url value="/user/edit?mode=Y"/>">
                 <sp:message code="label.userinfo"/>
               </a>
             </li>
          </sec:authorize>
           <sec:authorize ifAnyGranted="ROLE_USER">
             <li id="uitgbank">
               <a href="<c:url value="/bank/view"/>">
                 Uitg <sp:message code="label.bankinfo"/>
               </a>
             </li>
           </sec:authorize>
          <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_SYSUSER,ROLE_FREELANCER,ROLE_SALES,ROLE_FINANCE,ROLE_PROJECTMANAGER">
             <li id="bankedit">
               <a href="<c:url value="/bank/edit"/>">
                 <sp:message code="label.bankinfo"/>
               </a>
             </li>
           </sec:authorize>
           <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_SYSUSER,ROLE_SALES,ROLE_FINANCE,ROLE_PROJECTMANAGER">
              <li>
               <a>
                 <sp:message code="label.admin"/>
               </a>
             </li>
             <li id="allorder">
               <a href="<c:url value="/order/allorderlist"/>">
                 &nbsp;&nbsp;&nbsp;&nbsp;<sp:message code="label.allorder"/>
               </a>
             </li>
              <li id="clist">
               <a href="<c:url value="/user/clientlist"/>">
                 &nbsp;&nbsp;&nbsp;&nbsp;<sp:message code="label.client"/>
               </a>
             </li>
              <li id="flist">
               <a href="<c:url value="/user/freelancerList"/>">
                 &nbsp;&nbsp;&nbsp;&nbsp;<sp:message code="label.freelancer"/>
               </a>
             </li>
              <li id="currlist">
               <a href="<c:url value="/currency/list"/>">
                 &nbsp;&nbsp;&nbsp;&nbsp;<sp:message code="label.currency"/>
               </a>
             </li>
              <li id="industrylist">
               <a href="<c:url value="/industry/list"/>">
                 &nbsp;&nbsp;&nbsp;&nbsp;<sp:message code="label.industry"/>
               </a>
             </li>
           </sec:authorize>
   </ul>