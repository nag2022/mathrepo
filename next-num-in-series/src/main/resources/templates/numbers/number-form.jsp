<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>


<head>

<title>
Save Numbers
</title>

<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
		    document.getElementById('input1').value ='';
			document.getElementById('input2').value ='';
   			document.getElementById('input3').value ='';
   			document.getElementById('input4').value ='';
   			document.getElementById('input5').value ='';
   			document.getElementById('input6').value ='';
	});
</script>
<script type="text/javascript">


 var numbersOnly = /^\d+$/;
 function testInputData(myfield) {
 
  var myData = document.getElementById(myfield).value;
  if(myData!==''){
 		if(!numbersOnly.test(myData)){
 			document.getElementById(myfield).value ='';
 			document.getElementById(myfield).focus();
 		}		
 	}
 else
 	{
 			document.getElementById(myfield).focus();
 	}
  return;
 }
 </script>
</head>




<body>

<div id="wrapper">
	<div id="header">
	<h2>SERIES - NEXT NUMBER in the Series</h2>
	
	</div>
</div>

<div id="container">
		<h3>Save Numbers</h3>
	
		<form:form action="displayNumbers" modelAttribute="sixnums" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>Number 1:</label></td>
						<td><label>Number 2:</label></td>
						<td><label>Number 3:</label></td>
						<td><label>Number 4:</label></td>
						<td><label>Number 5:</label></td>
						<td><label>Number 6:</label></td>
					</tr>
					<tr>
						<td><form:input type="text" id="input1" path="num1" style="width: 101px;"  onfocusout="Javascript:testInputData('input1')"/></td>
						<td><form:input type="text" id="input2" path="num2" style="width: 101px;"  onfocusout="Javascript:testInputData('input2')"/></td>
						<td><form:input type="text" id="input3" path="num3" style="width: 101px;"  onfocusout="Javascript:testInputData('input3')"/></td>
						<td><form:input type="text" id="input4" path="num4" style="width: 101px;"  onfocusout="Javascript:testInputData('input4')"/></td>
						<td><form:input type="text" id="input5" path="num5" style="width: 101px;"  onfocusout="Javascript:testInputData('input5')"/></td>
						<td><form:input type="text" id="input6" path="num6" style="width: 101px;"  onfocusout="Javascript:testInputData('input6')"/></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Process" class="save" /></td>
					</tr>		
				</tbody>
			</table>
		</form:form>
	
		
	</div>
</body>
</html>