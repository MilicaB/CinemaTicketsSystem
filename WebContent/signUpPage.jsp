<%@ page language="java" contentType="text/html; "%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Registration Form</title>
<link rel="stylesheet" href="css/registerStyle.css">
</head>

<body>
	<div class="container">
		<section class="register">
			<h1>Register</h1>
			<form method="post" action="Registration">
				<div class="reg_section personal_info">
					<h3>Your Personal Information</h3>
					<input type="text" name="username" value=""
						placeholder="Your Desired Username"> 
						<input type="email"
						name="email" value="" placeholder="Your E-mail Address">
				</div>
				<div class="reg_section password">
					<h3>Your Password</h3>
					<input type="password" name="password" value=""
						placeholder="Your Password">
				</div>
				<div class="reg_section password"></div>
				<!-- <p class="terms">
          <label>
          <input type="checkbox" name="remember_me" id="remember_me">
           I accept  <a href="http://www.imomen.com/">iMomen</a>Terms & Condition
        </label>  
      </p> -->
				<p class="submit">
					<input type="submit" name="commit" value="Sign Up">
				</p>


				<%
					if (request.getAttribute("errorMessage") != null) {
				%>
				<br/>
				<p style="color: red">
					<%=request.getAttribute("errorMessage")%>
					<%
						}
					%>


					<%
						if (request.getAttribute("errorPassword") != null) {
					%>
				<br/>
				<p style="color: red">
					<%=request.getAttribute("errorPassword")%>
					<%
						}
					%>
					<%
						if (request.getAttribute("errorDB") != null) {
					%>
				<br/>
				<p style="color: red">
				
					<%=request.getAttribute("errorDB")%>
					<%
						}
					%>
					<%
						if (request.getAttribute("shortPassword") != null) {
					%>
				<br/>
				<p style="color: red">
				
					<%=request.getAttribute("shortPassword")%>
					<%
						}
					%>
				
			</form>
		</section>
	</div>

</body>
</html>