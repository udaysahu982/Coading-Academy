<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Enrolled Courses</title>

<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Inter',sans-serif;
}

body{
    background:#f8fafc;
    padding:40px;
}

.page-title{
    text-align:center;
    margin-bottom:40px;
    color:#0f172a;
    font-size:32px;
    font-weight:700;
}

.course-container{
    max-width:1200px;
    margin:auto;
    display:grid;
    grid-template-columns:repeat(auto-fill,minmax(340px,1fr));
    gap:25px;
}

.course-card{
    background:#ffffff;
    border-radius:16px;
    overflow:hidden;
    box-shadow:0 10px 25px -5px rgba(0,0,0,0.08);
    border:1px solid #e2e8f0;
    transition:0.3s;
}

.course-card:hover{
    transform:translateY(-5px);
}

.course-image{
    height:180px;
    background:linear-gradient(135deg,#6366f1 0%,#4338ca 100%);
    display:flex;
    justify-content:center;
    align-items:center;
    color:white;
    font-size:20px;
    font-weight:600;
}

.course-content{
    padding:24px;
}

.course-title{
    font-size:22px;
    font-weight:700;
    color:#0f172a;
    margin-bottom:12px;
}

.course-description{
    color:#475569;
    line-height:1.6;
    margin-bottom:20px;
}

.info-box{
    background:#f1f5f9;
    padding:14px;
    border-radius:10px;
    margin-bottom:20px;
}

.info-box p{
    margin:8px 0;
    color:#334155;
}

.price{
    font-size:28px;
    font-weight:700;
    color:#0f172a;
    margin-bottom:20px;
}

.btn{
    width:100%;
    display:block;
    text-align:center;
    text-decoration:none;
    padding:14px;
    border-radius:10px;
    background:#6366f1;
    color:white;
    font-weight:600;
    transition:0.3s;
}

.btn:hover{
    background:#4f46e5;
}

.empty-box{
    text-align:center;
    margin-top:100px;
    font-size:22px;
    color:#64748b;
}

</style>

</head>
<body>

<h1 class="page-title">My Enrolled Courses</h1>

<c:choose>

    <c:when test="${not empty enrolledCoursesList}">

        <div class="course-container">

            <c:forEach items="${enrolledCoursesList}" var="item">

                <div class="course-card">

                    <div class="course-image">
                        Course Preview
                    </div>

                    <div class="course-content">

                        <h2 class="course-title">
                            ${item.title}
                        </h2>

                        <p class="course-description">
                            ${item.description}
                        </p>

                        <div class="info-box">

                            <p>
                                <strong>Category:</strong>
                                ${item.category}
                            </p>

                            <p>
                                <strong>Level:</strong>
                                ${item.level}
                            </p>

                            <p>
                                <strong>Course ID:</strong>
                                ${item.id}
                            </p>

                        </div>

                        <div class="price">
                            ₹${item.price}
                        </div>

                        <a href="viewEnrolledCourse?courseId=${item.id}" class="btn">
                            Continue Learning
                        </a>

                    </div>

                </div>

            </c:forEach>

        </div>

    </c:when>

    <c:otherwise>

        <div class="empty-box">
            You have not enrolled in any courses yet.
        </div>

    </c:otherwise>

</c:choose>

</body>
</html>