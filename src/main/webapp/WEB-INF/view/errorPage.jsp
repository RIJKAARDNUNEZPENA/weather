<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
  <title>Weather Error</title>
</head>
<body>
	<div>
		<ul class="form-style-1">
		    <li>
		        <h2>Weather Error</h2>
		        <br></br>
		    </li>
		    <li>
		        <label>service not available: </label>
		        <textarea name="message" class="field-long field-textarea">${message}</textarea>
		    </li>
		    <li>
		        <form action="/">
				    <input type="submit" value="home" />
				</form>
		    </li>
		</ul>
	</div>
</body>
</html>