<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>User Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2" style="text-align: right;">ID</label>
		<div class="col-sm-10 text-left">${user.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2 control-label" style="text-align: right;">Name</label>
		<div class="col-sm-10 ">${user.name}</div>
	</div>
	<div class="row">
		<label class="col-sm-2" style="text-align: right;">Designation</label>
		<div class="col-sm-10">${user.designation}</div>
	</div>

	<div class="row">
		<label class="col-sm-2" style="text-align: right;">Email</label>
		<div class="col-sm-10">${user.email}</div>
	
	</div>
		<div class="row">
		<label class="col-sm-2" style="text-align: right;">Address</label>
		<div class="col-sm-10">${user.address}</div>
	</div>
		<div class="row">
		<label class="col-sm-2" style="text-align: right;">PM, Analysis & Designing Tools</label>
		<div class="col-sm-10">${user.padt}</div>
	</div>
<div class="row">
		<label class="col-sm-2" style="text-align: right;">Databases</label>
		<div class="col-sm-10">${user.databases}</div>
	</div>
	<div class="row">
		<label class="col-sm-2" style="text-align: right;">Language & Tools</label>
		<div class="col-sm-10">${user.ltt}</div>
	</div>
		<div class="row">
		<label class="col-sm-2" style="text-align: right;">Operating System</label>
		<div class="col-sm-10">${user.os}</div>
	</div>
	<div class="row">
		<label class="col-sm-2" style="text-align: right;">TrainingCertification</label>
		<div class="col-sm-10">${user.tc}</div>
	</div>
		<div class="row">
		<label class="col-sm-2" style="text-align: right;">TrainingNeeds-2017</label>
		<div class="col-sm-9">${user.td}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2" style="text-align: right;">Web Frameworks</label>
		<div class="col-sm-10">${user.framework}</div>
	</div>

	<div class="row">
		<label class="col-sm-2" style="text-align: right;">Gender</label>
		<div class="col-sm-10">${user.sex}</div>
	</div>

	<div class="row">
		<label class="col-sm-2" style="text-align: right;">Sex</label>
		<div class="col-sm-10">${user.education}</div>
	</div>
	

	<div class="row">
		<label class="col-sm-2" style="text-align: right;">Country</label>
		<div class="col-sm-10">${user.country}</div>
	</div>
	<div class="row">
		<label class="col-sm-2" style="text-align: right;">Skill</label>
		<div class="col-sm-10">${user.skill}</div>
	</div>
	
	
</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>