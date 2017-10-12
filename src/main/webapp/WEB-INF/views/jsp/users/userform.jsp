<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${userForm['new']}">
			<h1>Add User</h1>
		</c:when>
		<c:otherwise>
			<h1>Update User</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/users" var="userActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control " id="name" placeholder="Name" />
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		</spring:bind>
		<spring:bind path="designation">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Designation</label>
				<div class="col-sm-10">
					<form:input path="designation" type="text" class="form-control " id="designation" placeholder="Designation" />
					<form:errors path="designation" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control" id="email" placeholder="Email" />
					<form:errors path="email" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="password">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<form:password path="password" class="form-control" id="password" placeholder="Password" />
					<form:errors path="password" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="confirmPassword">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Confirm Password</label>
				<div class="col-sm-10">
					<form:password path="confirmPassword" class="form-control" id="password" placeholder="Password" />
					<form:errors path="confirmPassword" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="address">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Address</label>
				<div class="col-sm-10">
					<form:textarea path="address" rows="5" class="form-control" id="address" placeholder="Address" />
					<form:errors path="address" class="control-label" />
				</div>
			</div>
		</spring:bind>

<spring:bind path="education">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Education</label>
				<div class="col-sm-10">
					<form:textarea path="education" rows="5" class="form-control" id="education" placeholder="Education" />
					<form:errors path="education" class="control-label" />
				</div>
			</div>
		</spring:bind>
		<spring:bind path="padt">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">PM,Analysis & Designing Tools</label>
				<div class="col-sm-10">
					<form:textarea path="padt" rows="5" class="form-control" id="padt" placeholder="PM, Analysis & Designing Tools" />
					<form:errors path="padt" class="control-label" />
				</div>
			</div>
		</spring:bind>
	<spring:bind path="databases">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Databases</label>
				<div class="col-sm-10">
					<form:textarea path="databases" rows="5" class="form-control" id="databases" placeholder="Databases" />
					<form:errors path="address" class="control-label" />
				</div>
			</div>
		</spring:bind>
		<spring:bind path="ltt">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Language & Tools</label>
				<div class="col-sm-10">
					<form:textarea path="ltt" rows="5" class="form-control" id="ltt" placeholder="Language & Tools" />
					<form:errors path="ltt" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="os">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Operating System</label>
				<div class="col-sm-10">
					<form:textarea path="os" rows="5" class="form-control" id="os" placeholder="Operating System" />
					<form:errors path="os" class="control-label" />
				</div>
			</div>
		</spring:bind>

<spring:bind path="tc">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Training/Certification
				</label>
				<div class="col-sm-10">
					<form:textarea path="tc" rows="5" class="form-control" id="tc" placeholder="Training/
Certification
					" />
					<form:errors path="tc" class="control-label" />
				</div>
			</div>
		</spring:bind>
	<spring:bind path="td">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Training Needs - 2017
				</label>
				<div class="col-sm-10">
					<form:textarea path="td" rows="5" class="form-control" id="td" placeholder="Training Needs - 2017" />
					<form:errors path="td" class="control-label" />
				</div>
			</div>
		</spring:bind>
		

		<spring:bind path="framework">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Web Frameworks</label>
				<div class="col-sm-10">
					<form:checkboxes path="framework" items="${frameworkList}" element="label class='checkbox-inline'" />
					<br />
					<form:errors path="framework" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="sex">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Gender</label>
				<div class="col-sm-10">
					<label class="radio-inline"> <form:radiobutton path="sex" value="M" /> Male
					</label> <label class="radio-inline"> <form:radiobutton path="sex" value="F" /> Female
					</label> <br />
					<form:errors path="sex" class="control-label" />
				</div>
			</div>
		</spring:bind>
		<!-- Custom Script, Spring map to model via 'name' attribute
		<div class="form-group">
			<label class="col-sm-2 control-label">Number</label>
			<div class="col-sm-10">

				<c:forEach items="${numberList}" var="obj">
					<div class="radio">
						<label> 
							<input type="radio" name="number" value="${obj}">${obj}
						</label>
					</div>
				</c:forEach>
			</div>
		</div>
 		-->

		<spring:bind path="country">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Country</label>
				<div class="col-sm-5">
					<form:select path="country" class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${countryList}" />
					</form:select>
					<form:errors path="country" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

		<spring:bind path="skill">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Java Skills</label>
				<div class="col-sm-5">
					<form:select path="skill" items="${javaSkillList}" multiple="true" size="5" class="form-control" />
					<form:errors path="skill" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${userForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-left">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-left">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>