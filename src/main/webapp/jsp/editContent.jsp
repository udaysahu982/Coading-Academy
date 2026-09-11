<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Section Item Content</title>
<style>
    body { font-family: Arial, sans-serif; margin: 40px; background: #f9f9f9; }
    .form-container { background: white; padding: 30px; border-radius: 8px; border: 1px solid #ccc; max-width: 600px; margin: 0 auto; }
    .form-group { margin-bottom: 20px; }
    label { display: block; font-weight: bold; margin-bottom: 5px; font-size: 14px; }
    input[type="text"], textarea { width: 100%; padding: 8px 12px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
    input[type="file"] { display: block; margin-top: 5px; }
    button { background-color: #007bff; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; font-weight: bold; }
    button:hover { background-color: #0056b3; }
</style>
</head>
<body>

<div class="form-container">
    <h2>Edit Section Content</h2>
    
    <form action="updateContent" method="post" enctype="multipart/form-data">
        
        <input type="hidden" name="id" value="${item.id}" />
        <input type="hidden" name="sectionId" value="${item.sectionId}" />
        <input type="hidden" name="courseId" value="${item.courseId}" />
        
        <div class="form-group">
            <label>Item Title:</label>
            <input type="text" name="itemTitle" value="${item.itemTitle}" required="true" />
        </div>
        
        <div class="form-group">
            <label>Item Text / Notes Description:</label>
            <textarea name="itemText" rows="5" >${item.itemText}</textarea>
        </div>
        
        <div class="form-group">
            <label>Upload Notes File (PDF, JPG, PNG):</label>
            <input type="file" name="notesFile" accept=".pdf,.jpg,.jpeg,.png" />
            <c:if test="${item.itemNotesFile != null}">
    		<p>File already uploaded.</p>
</c:if>
        </div>
        
        <div class="form-group">
            <label>YouTube Video Link:</label>
            <input type="text" name="itemYtLink" value="${item.itemYtLink}" />
        </div>
        
        <button type="submit">Update Content Item</button>
    </form>
</div>

</body>
</html>