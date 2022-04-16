<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Display Numbers</title>

<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>SERIES - NEXT NUMBER in the Series</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<table>
				<tr>
					<th>Number 1</th>
					<th>Number 2</th>
					<th>Number 3</th>
					<th>Number 4</th>
					<th>Number 5</th>
					<th>Number 6</th>
					<th>NextNumber</th>
				</tr>		
					<tr>
						<td> ${num1} </td>
						<td> ${num2} </td>
						<td> ${num3} </td>
						<td> ${num4} </td>
						<td> ${num5} </td>
						<td> ${num6} </td>
						<td> ${nextnum} </td>
					</tr>			
			</table>
		</div>
	</div>
	<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/number/showFormForEnteringIntegers">Back to next series Inputs</a>
		</p>
</body>

</html>
