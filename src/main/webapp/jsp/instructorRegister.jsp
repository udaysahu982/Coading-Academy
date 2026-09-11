<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>

<style>
    body{
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .container{
        background: white;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.2);
    }

    h2{
        text-align: center;
        margin-bottom: 20px;
    }

    table{
        border-collapse: collapse;
    }

    td{
        padding: 10px;
    }

    input[type=text],
    input[type=email],
    input[type=password]{
        width: 250px;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type=submit]{
        width: 100%;
        padding: 10px;
        border: none;
        background-color: #007bff;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }

    input[type=submit]:hover{
        background-color: #0056b3;
    }

    .error{
        color: red;
        font-size: 13px;
        margin-top: 3px;
        display: block;
    }
</style>

</head>
<body>

<div class="container">

```
<h2>Instructor Registration</h2>

<form:form action="instructorRegister" method="post" modelAttribute="user">

    <table>

        <tr>
            <td>
                <form:input path="name" placeholder="Enter your Name"/>
                <form:errors path="name" cssClass="error"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:input path="email" placeholder="Enter your Email"/>
                <form:errors path="email" cssClass="error"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:input path="phone" placeholder="Enter your Phone Number"/>
                <form:errors path="phone" cssClass="error"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:password path="password" placeholder="Enter your Password"/>
                <form:errors path="password" cssClass="error"/>
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="Register">
            </td>
        </tr>
        
            <tr>
            <td>
                <a href="login">Login here</a>
            </td>
        </tr>

    </table>
    
    

</form:form>
```

</div>

</body>
</html>
