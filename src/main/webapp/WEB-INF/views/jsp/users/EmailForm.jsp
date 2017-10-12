<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../fragments/header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email with Spring MVC</title>

<style type="text/css">
.group {
	position: relative;
	margin-bottom: 45px;
}

.input1 {
	font-size: 12px;
	padding: 10px 10px 10px 5px;
	-webkit-appearance: none;
	display: block;
	background-color: #F5EDED !important;
	width: 80%;
	border: none;
	border-radius: 0;
	border-bottom: 1px solid #757575;
}

input:focus {
	outline: none;
}

textarea {
	font-size: 12px;
	padding: 10px 10px 10px 5px;
	-webkit-appearance: none;
	display: block;
 	background-color: #F5EDED !important;
	width: 80%;
	border: none;
	border-radius: 0;
	border-bottom: 1px solid #757575;
	border-right: 1px solid #757575;
	border-left: 1px solid #757575;
}

.horizonInpuBox {
	display: inline;
}
</style>

</head>
<body style="background-color: #F5EDED">
	<!--  <center>
        <h1>Sending e-mail with Spring MVC</h1>
        	<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		 </center> -->
	<form    method="post" action="/spring-mvc-form/users/emailfrom" enctype="multipart/form-data" style="padding-left: 300px;background-color: #F5EDED">
		<table border="0" width="80%">
			<tr class="group">
				<td align="right">To:</td>
				<td><input type="text" class="input1" name="recipient" size="82" placeholder="To" /></td>
			</tr>
			<tr class="group">
				<td align="right">CC:</td>
				<td><input type="text" class="input1" name="recipientCc" size="65"placeholder="CC"  /></td>
			</tr>
			<tr class="group">
				<td align="right">Subject:</td>
				<td><input type="text" class="input1"  name="subject" size="65%" placeholder="Subject"/></td>
			</tr>

			<tr>
				<td></td>
				<td><textarea cols="80" rows="15" name="message"></textarea></td>
			</tr>

		</table>

		<div style="width: 20%; float: left">
			<button type="submit" style="margin-left: 60px" value="Send E-mail ">Send E-mail</button>
		</div>

		<div style="width: 80%; float: right">
			<input type="file" name="attachFile" size="60" />
		</div>

	</form>

	<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>