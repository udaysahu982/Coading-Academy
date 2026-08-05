<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Section Items</title>
<style>
    body { font-family: Arial, sans-serif; margin: 40px; background: #f9f9f9; }
    .item-card { background: white; padding: 20px; border-radius: 8px; border: 1px solid #ccc; margin-bottom: 20px; max-width: 700px; }
    .item-title { font-size: 18px; font-weight: bold; color: #007bff; margin-bottom: 10px; }
    .item-text { margin-bottom: 15px; white-space: pre-wrap; color: #333; }
    .media-box { margin-bottom: 15px; }
    embed, img { max-width: 100%; height: auto; border-radius: 4px; border: 1px solid #ddd; }
    .yt-link { display: inline-block; background: #ff0000; color: white; padding: 6px 12px; text-decoration: none; border-radius: 4px; font-size: 13px; }
</style>
</head>
<body>

<h2>Curriculum Items</h2>

<c:forEach var="item" items="${items}">
    <div class="item-card">
        
        <div class="item-title">${item.itemTitle}</div>
        
        <div class="item-text">${item.itemText}</div>
        
        <c:if test="${not empty item.itemNotesFile}">
            <div class="media-box">
                <label>Attached Document / Image:</label><br>
                <embed src="${pageContext.request.contextPath}/viewItemFile?id=${item.id}" width="100%" height="400px" />
                <div style="margin-top: 5px;">
                    <a href="${pageContext.request.contextPath}/viewItemFile?id=${item.id}" target="_blank">Open / Download File in New Tab</a>
                </div>
            </div>
        </c:if>
        
        <c:if test="${not empty item.itemYtLink}">
            <div class="media-box">
                <a href="${item.itemYtLink}" target="_blank" class="yt-link">Watch YouTube Video</a>
            </div>
        </c:if>
        
    </div>
</c:forEach>

<c:if test="${empty items}">
    <p>No content items found for this section yet.</p>
</c:if>

</body>
</html>