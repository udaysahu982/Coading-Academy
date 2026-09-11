<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course | Coding Academy</title>

<style>
    :root {
        --primary: #4f46e5;
        --primary-hover: #4338ca;
        --bg-color: #f3f4f6;
        --card-bg: #ffffff;
        --text-main: #1f2937;
        --text-muted: #6b7280;
        --border-color: #d1d5db;
        --error-color: #ef4444;
    }

    body {
        font-family: 'Inter', system-ui, -apple-system, sans-serif;
        background-color: var(--bg-color);
        color: var(--text-main);
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
        padding: 20px;
    }

    .container {
        background: var(--card-bg);
        padding: 40px;
        border-radius: 16px;
        box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.05), 0 8px 10px -6px rgba(0, 0, 0, 0.05);
        width: 100%;
        max-width: 480px;
        box-sizing: border-box;
    }

    h2 {
        color: var(--text-main);
        text-align: center;
        margin-top: 0;
        margin-bottom: 25px;
        font-size: 24px;
        font-weight: 700;
        letter-spacing: -0.025em;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    td {
        padding: 10px 0;
    }

    .input-field, 
    select, 
    textarea {
        width: 100%;
        padding: 12px 14px;
        border: 1px solid var(--border-color);
        border-radius: 8px;
        font-size: 14px;
        color: var(--text-main);
        background-color: #fff;
        box-sizing: border-box;
        transition: all 0.2s ease;
    }

    .input-field:focus, 
    select:focus {
        border-color: var(--primary);
        outline: none;
        box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.15);
    }

    select {
        cursor: pointer;
    }

    input[type=submit] {
        width: 100%;
        padding: 14px;
        border: none;
        background-color: var(--primary);
        color: white;
        border-radius: 8px;
        font-size: 15px;
        font-weight: 600;
        cursor: pointer;
        transition: background-color 0.2s ease;
        margin-top: 10px;
    }

    input[type=submit]:hover {
        background-color: var(--primary-hover);
    }

    .error {
        color: var(--error-color);
        font-size: 12px;
        margin-top: 4px;
        display: block;
    }
</style>
</head>
<body>

<div class="container">

    <h2>Publish New Course</h2>

    <form:form action="editCourse" method="post" modelAttribute="course">

        <table>
         <tr>
                <td>
                    <form:input path="id" cssClass="input-field" placeholder="Course Title (e.g. Full Stack Java)" type="hidden" />
                    
                </td>
            </tr>

            <tr>
                <td>
                    <form:input path="title" cssClass="input-field" placeholder="Course Title (e.g. Full Stack Java)"  />
                    <form:errors path="title" cssClass="error"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:input path="description" cssClass="input-field" placeholder="Short Description" />
                    <form:errors path="description" cssClass="error"/>
                </td>
            </tr>
            
              <tr>
                <td>
                    <form:input path="instructorId" cssClass="input-field" placeholder="Short Description" type="hidden" />
                </td>
            </tr>

            <tr>
                <td>
                    <form:select path="category" cssClass="input-field">
                        <form:option value="" disabled="true" selected="true">Select Course Category</form:option>
                        <c:forEach var="cat" items="${categoryList}">
                            <form:option value="${cat.name}">${cat.name}</form:option>
                        </c:forEach>
                    </form:select>
                    <form:errors path="category" cssClass="error"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:select path="level" cssClass="input-field">
                        <form:option value="" disabled="true" selected="true">Select Difficulty Level</form:option>
                        <form:option value="Beginner">Beginner Level</form:option>
                        <form:option value="Intermediate">Intermediate Level</form:option>
                        <form:option value="Advanced">Advanced Level</form:option>
                        <form:option value="All Levels">All Levels</form:option>
                    </form:select>
                    <form:errors path="level" cssClass="error"/>
                </td>
            </tr>
            
            <tr>
                <td>
                    <form:input path="price" cssClass="input-field"  type="number" step="0.01" placeholder="Course Price (₹)"/>
                    <form:errors path="price" cssClass="error"/>
                </td>
            </tr>

            <tr>
                <td>
                    <input type="submit" value="Publish Course">
                </td>
            </tr>

        </table>

    </form:form>

</div>

</body>
</html>