<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
  <title>Weather Portal</title>
</head>
<article>
  <header>
  <ul>
    <li>
		        <h2>Weather Portal</h2>
    </li>
</ul>
		  <ul>
		    <li>
		        <hr>
		    </li>
		  </ul>
		   
  </header>
</article>
<body>
<div class="container">
	<form  action="/weatherByCity" method="get" class="">
 <div class="row">
  <label>Select you city:</label>
<select id="city" name="city"> >
  <option value="2643743">London</option>
  <option value="1819729">Hong Kong</option>
 
</select>
</div>

  <div class="row">
		    <input type="submit" value="Submit">
		  </div>
		  </form>
		  </div>
		  </body>
</html>