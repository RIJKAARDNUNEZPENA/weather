<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
  <title>Weather Characteristics</title>
</head>
<style>
table {
  width:100%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
table#t01 tr:nth-child(even) {
  background-color: #eee;
}
table#t01 tr:nth-child(odd) {
 background-color: #fff;
}
table#t01 th {
  background-color: black ;
  color: white;
}
</style>
<body>

	<div align: center>
		 
		        <h3  align=center>Weather Characteristics ${weather.nameCity} </h3>
		    
		        <hr> 

		    <table id="t01" align=center>
				  <tr>
				    <td><label><strong>Date:</strong></label></td>
				    <td><output name="currentDate">${weather.todayDate}</output></td> 
				  </tr>
				  <tr>
				    <td><label><strong>City:</strong></label></td>
				    <td><output name="city">${weather.nameCity}</output></td>
				  </tr>
				  <tr>
				    <td><label><strong>Weather description:</strong></label></td>
				    <td><output name="desc">${weather.descriptionWeather}</output></td>
				  </tr>
				  <tr>
				    <td><label><strong>Temperature in Fahrenheit: </strong></label> </td>
				    <td><output name="tempF">${weather.farengeithTemperature}</output></td>
				  </tr>
				  <tr>
				    <td><label><strong>Temperature in Celcius: </strong></label> </td>
				    <td><output name="tempC">${weather.celciusTemperature}</output></td>
				  </tr>
				  <tr>
				    <td><label><strong>Sunrise:</strong></label></td>
				    <td><output name="sunrise">${weather.sunrise}</output></td>
				  </tr>
				  <tr>
				    <td><label><strong>Sunset:</strong></label></td>
				    <td><output name="sunset">${weather.sunset}</output></td>
				  </tr>
				</table>
		    
		    <br/>
		        <form action="/">
				    <input align=center class="button" type="submit" value="Return" />
				</form> 
	</div>

</body>
</html>