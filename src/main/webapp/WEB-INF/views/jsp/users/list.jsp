<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.mkyong.form.model.User"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />
<head><style>
#myTable th.header{
padding-bottom:75px;}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script language="javascript" type="text/javascript">
  
  function setBodyProperty(){
	  
	  var user_id = ${user.id};
	  
  if(user_id !=""){
	  alert("kk"+user_id);
  
  $('#modal-terms').modal('show');
	
  
  } 
  </script>
  <style type="text/css">
  
 .modelul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid black;
    

}

.modelli {
    float: left;
}

.modelli{
    display: block;
    color: #000;
    padding: 16px;
    text-decoration: none;

}

.body-clr {

 background-color:#b3edff !important;
}
.modal-header {

 background-color:#69f !important;
}

  </style>
  
</head>

<body onload="setBodyProperty()">
 
	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All Users ${message}</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th class="col-md-1">#ID</th>
					<th class="col-md-2">Name</th>
					<th>Email</th>
					<th> Framework</th>
					<th class="header col-md-3">Action</th>
				</tr>
			</thead>

			<c:forEach var="user" items="${users}">
				<tr>
					<td>
						${user.id}
					</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
				
					<td><c:forEach var="framework" items="${user.framework}" varStatus="loop">
						${framework}
    					<c:if test="${not loop.last}">,</c:if>
						</c:forEach></td>
					<td class="col-md-3">
						<spring:url value="/users/${user.id}" var="userUrl" />
		        
						<spring:url value="/userslist/${user.id}" var="userUrl1" />
						<spring:url value="/users/${user.id}/delete" var="deleteUrl" /> 
						<spring:url value="/users/${user.id}/update" var="updateUrl" />
						<spring:url value="/users/${user.id}/emailfrom" var="emailUrl" />
						<button class="btn btn-primary" onclick="location.href='${userUrl}'">View</button>
						<!--button data-toggle="modal" data-target="#confirm-submit" class="btn btn-info" onclick="location.href='${userUrl1}','${user.id}'">View</button-->
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
						<!--button class="btn btn-danger" onclick="this.disabled=true;post('${emailUrl}')">Email</button--></td>
						
						
				</tr>
			</c:forEach>
		</table>
			<div class="modal fade" id="modal-terms" tabindex="-1" role="dialog"
aria-labelledby="modal-terms-label" aria-hidden="true">
         <div class="modal-dialog modal-lg modalHeight" id="modal-terms">
            <div class="modal-content">
               <div class="modal-header modal-header">
                  <button type="button" class="close" data-dismiss="modal">
                  <span aria-hidden="true">&times;</span><span
class="sr-only">Close</span>
                  </button>
                  <h2 class="modal-title" id="modal-terms-label">Customer Information</h2>
               </div>
               <div class="modal-body body-clr">
                 <div class="row ">
                 <div>
                  <ul class="modelul">
                  <li class="modelli" style="text-align:center;color:#009;width:30px">SrNo.</li>
                   <li class="modelli" style="text-align:center;color:#009;width:120px">Account No</li>
                  <li class="modelli" style="text-align:center;color:#009;width:120px">Cus.Code</li>
                  <li class="modelli" style="text-align:left;width:140px;color:#009">A/C Title</li>
                  <li class="modelli" style="text-align:left;width:135px;color:#009">Father Name</li>
                  <li class="modelli" style="text-align:left;width:135px;color:#009 ">Mother Name</li>
                  <li class="modelli" style="text-align:center;color:#009">Date of Birth</li>
                </ul>

                <ul class="modelul">
                  <li class="modelli" style="text-align:center;width:30px">${user.id}</li>
                  <li class="modelli" style="text-align:center;width:120px;">${user.name}</li>
                  <li class="modelli" style="text-align:center;width:120px;">${user.email}</li>
                  <li class="modelli" style="text-align:left;width:140px">${user.address}</li>
                  <li class="modelli" style="text-align:left;width:135px">${user.framework}</li>
                  <li class="modelli" style="text-align:left;width:135px">${user.sex}</li>
                  <li class="modelli" style="text-align:left"></li>
                </ul>

            </div>
              </div>
               </div>
            </div>
         </div>
      </div>

	<jsp:include page="../fragments/footer.jsp" />
	
	


</body>
</html>