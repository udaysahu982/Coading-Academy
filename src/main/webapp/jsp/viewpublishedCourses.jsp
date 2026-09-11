<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Published Courses | Coding Academy</title>
<style>
    body {
        font-family: 'Inter', system-ui, -apple-system, sans-serif;
        background-color: #f3f4f6;
        color: #1f2937;
        margin: 0;
        padding: 40px;
    }

    .container {
        max-width: 1200px;
        margin: 0 auto;
    }

    .header-flex {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 30px;
    }

    h2 {
        margin: 0;
        font-size: 26px;
        font-weight: 700;
        color: #111827;
    }

    .btn-add {
        background-color: #4f46e5;
        color: white;
        padding: 10px 18px;
        border-radius: 8px;
        text-decoration: none;
        font-size: 14px;
        font-weight: 600;
        transition: background-color 0.2s;
    }

    .btn-add:hover {
        background-color: #4338ca;
    }

    .courses-grid {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
        gap: 24px;
    }

    .course-card {
        background: #ffffff;
        border-radius: 12px;
        box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.05), 0 2px 4px -2px rgba(0, 0, 0, 0.05);
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        padding: 24px;
        border: 1px solid #e5e7eb;
        transition: transform 0.2s, box-shadow 0.2s;
    }

    .course-card:hover {
        transform: translateY(-3px);
        box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.08);
    }

    .card-top {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 12px;
    }

    .badge-category {
        background-color: #e0e7ff;
        color: #4f46e5;
        font-size: 11px;
        font-weight: 600;
        padding: 4px 10px;
        border-radius: 20px;
        text-transform: uppercase;
        letter-spacing: 0.05em;
    }

    .badge-level {
        font-size: 12px;
        color: #6b7280;
        font-weight: 500;
    }

    .course-title {
        font-size: 18px;
        font-weight: 700;
        color: #1f2937;
        margin: 0 0 10px 0;
        line-height: 1.4;
    }

    .course-desc {
        font-size: 14px;
        color: #4b5563;
        margin: 0 0 20px 0;
        line-height: 1.5;
        flex-grow: 1;
    }

    .card-footer {
        display: flex;
        justify-content: space-between;
        align-items: center;
        border-top: 1px solid #f3f4f6;
        padding-top: 16px;
        margin-top: auto;
    }

    .course-price {
        font-size: 18px;
        font-weight: 700;
        color: #059669;
    }

    .card-actions {
        display: flex;
        gap: 8px;
        margin-top: 16px;
        border-top: 1px solid #f3f4f6;
        padding-top: 16px;
    }

    .btn-action {
        flex: 1;
        padding: 8px 12px;
        border-radius: 6px;
        text-align: center;
        text-decoration: none;
        font-size: 13px;
        font-weight: 600;
        transition: background-color 0.2s;
    }

    .btn-notes {
        background-color: #f3f4f6;
        color: #374151;
    }

    .btn-notes:hover {
        background-color: #e5e7eb;
    }

    .btn-edit {
        background-color: #eff6ff;
        color: #2563eb;
    }

    .btn-edit:hover {
        background-color: #dbeafe;
    }

    .no-courses {
        grid-column: 1 / -1;
        text-align: center;
        background: #ffffff;
        padding: 50px;
        border-radius: 12px;
        color: #6b7280;
        font-style: italic;
        border: 1px solid #e5e7eb;
    }
</style>
</head>
<body>

<div class="container">
    <div class="header-flex">
        <h2>Your Published Courses</h2>
        <a href="openAddCourse" class="btn-add">+ Add New Course</a>
    </div>

    <div class="courses-grid">
        <c:forEach var="c" items="${courses}">
            <div class="course-card">
                <div>
                    <div class="card-top">
                        <span class="badge-category">${c.category}</span>
                        <span class="badge-level">${c.level}</span>
                    </div>
                    <h3 class="course-title">${c.title}</h3>
                    <p class="course-desc">${c.description}</p>
                </div>
                <div>
                    <div class="card-footer">
                        <span class="course-price">₹${c.price}</span>
                    </div>
                    <div class="card-actions">
                        <a href="manageCurriculum?courseId=${c.id}" class="btn-action btn-notes">+ Add Material</a>
                        <a href="openEditCourse?courseId=${c.id}" class="btn-action btn-edit">Edit Course</a>
                    </div>
                </div>
            </div>
        </c:forEach>
        
        <c:if test="${empty courses}">
            <div class="no-courses">
                <p>No courses published yet. Click "+ Add New Course" to get started!</p>
            </div>
        </c:if>
    </div>
</div>

</body>
</html>