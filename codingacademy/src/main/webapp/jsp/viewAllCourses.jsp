<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Courses</title>

<style>

body{
    font-family: Arial, sans-serif;
    background:#f4f6f9;
    margin:0;
    padding:20px;
}

.course-container{
    display:flex;
    flex-wrap:wrap;
    gap:20px;
}

.course-card{
    width:320px;
    background:white;
    border-radius:12px;
    box-shadow:0 2px 10px rgba(0,0,0,0.15);
    overflow:hidden;
    transition:0.3s;
}

.course-card:hover{
    transform:translateY(-5px);
}

.card-body{
    padding:15px;
}

.course-title{
    font-size:22px;
    font-weight:bold;
    color:#333;
    margin-bottom:10px;
}

.course-description{
    color:#666;
    margin-bottom:10px;
}

.badge{
    display:inline-block;
    padding:5px 10px;
    border-radius:20px;
    font-size:12px;
    margin-right:5px;
    background:#e9ecef;
}

.price{
    margin-top:15px;
    font-size:20px;
    font-weight:bold;
    color:#28a745;
}

.btn{
    display:block;
    text-align:center;
    text-decoration:none;
    background:#007bff;
    color:white;
    padding:10px;
    margin-top:15px;
    border-radius:6px;
}

.btn:hover{
    background:#0056b3;
}

</style>

</head>
<body>

<h1>Available Courses</h1>

<div class="course-container">

    <c:forEach var="course" items="${courses}">

        <div class="course-card">

            <div class="card-body">

                <div class="course-title">
                    ${course.title}
                </div>

                <div class="course-description">
                    ${course.description}
                </div>

                <div>
                    <span class="badge">
                        ${course.category}
                    </span>

                    <span class="badge">
                        ${course.level}
                    </span>
                </div>

                <div class="price">
                    ₹${course.price}
                </div>

                <a href="viewCourse?id=${course.id}" class="btn">
                    View Course
                </a>

            </div>

        </div>

    </c:forEach>

</div>

</body>
</html>