<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>${course.id}</h2>
<h2>${course.title}</h2>
<h2>${course.description}</h2>
<h2>${course.id}</h2>
<h2>${course.id}</h2>


<ul>
		<c:forEach items="${courseSections}"  var="section">
		<li> 
			  
			  <div>
			  <h2>${section.sectionTitle}</h2>
			      
			      
			       
			       
			  </div>
			  
			  <div>
			  
			  </div>
			  
		</li>
		</c:forEach>
		
</ul>





</body>
</html>