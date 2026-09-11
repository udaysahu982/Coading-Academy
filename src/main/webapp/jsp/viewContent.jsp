<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Content</title>
<style>
    * { box-sizing: border-box; }
    body { font-family: 'Segoe UI', Arial, sans-serif; margin: 0; padding: 40px; background: #f4f6f9; color: #333; }
    .card { max-width: 700px; margin: 0 auto; background: white; padding: 40px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.05); border: 1px solid #e1e8ed; }
    h2 { margin-top: 0; color: #1a202c; font-size: 24px; border-bottom: 2px solid #edf2f7; padding-bottom: 15px; margin-bottom: 20px; }
    .description { font-size: 15px; line-height: 1.7; color: #4a5568; margin-bottom: 30px; background: #f8fafc; padding: 20px; border-radius: 8px; border-left: 4px solid #3182ce; }
    .action-group { display: flex; flex-wrap: wrap; gap: 12px; align-items: center; margin-top: 25px; padding-top: 20px; border-top: 1px solid #edf2f7; }
    .btn { display: inline-flex; align-items: center; gap: 8px; padding: 10px 20px; text-decoration: none; border-radius: 6px; font-size: 14px; font-weight: 600; transition: background 0.2s, transform 0.1s; }
    .btn-view { background: #3182ce; color: white; }
    .btn-view:hover { background: #2b6cb0; }
    .btn-yt { background: #e53e3e; color: white; }
    .btn-yt:hover { background: #c53030; }
    .label { font-size: 13px; text-transform: uppercase; letter-spacing: 0.5px; color: #718096; font-weight: 700; display: block; margin-bottom: 8px; }
</style>
</head>
<body>

<div class="card">
    <h2>${item.itemTitle}</h2>
    
    <div class="description">
        <span class="label">Description</span>
        ${item.itemText}
    </div>
    
    <div class="action-group">
        <c:if test="${not empty item.itemYtLink}">
            <a href="${item.itemYtLink}" target="_blank" class="btn btn-yt">▶ Watch YouTube Video</a>
        </c:if>
        
        <c:if test="${not empty item.itemNotesFile}">
            <a href="${pageContext.request.contextPath}/viewItemFile?id=${item.id}" target="_blank" class="btn btn-view">👁 View File</a>
        </c:if>
    </div>
</div>

</body>
</html>