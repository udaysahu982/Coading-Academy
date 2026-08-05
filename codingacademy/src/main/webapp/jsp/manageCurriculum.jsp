<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Course Curriculum</title>
<style>
    body { font-family: Arial, sans-serif; margin: 40px; background: #f4f6f9; }
    .container { max-width: 800px; margin: 0 auto; background: white; padding: 30px; border-radius: 8px; border: 1px solid #ccc; }
    .course-header { margin-bottom: 25px; border-bottom: 2px solid #007bff; padding-bottom: 10px; }
    .add-chapter-box { background: #f8f9fa; border: 1px solid #ced4da; padding: 20px; border-radius: 6px; margin-bottom: 25px; }
    .add-chapter-box h4 { margin-top: 0; margin-bottom: 12px; color: #495057; }
    .chapter-form-row { display: flex; gap: 10px; }
    .chapter-form-row input[type="text"] { flex: 1; padding: 8px 12px; border: 1px solid #ccc; border-radius: 4px; }
    .chapter-form-row button { background: #007bff; color: white; border: none; padding: 8px 16px; border-radius: 4px; cursor: pointer; font-weight: bold; }
    .chapter-form-row button:hover { background: #0056b3; }
    .chapter-card { background: #fff; border: 1px solid #ddd; border-radius: 6px; margin-bottom: 15px; overflow: hidden; }
    .chapter-bar { display: flex; justify-content: space-between; align-items: center; background: #e9ecef; padding: 12px 20px; cursor: pointer; font-weight: bold; }
    .chapter-bar:hover { background: #dde2e6; }
    .chapter-content { display: none; padding: 15px 20px; background: #fafafa; border-top: 1px solid #ddd; }
    .item-row { display: flex; justify-content: space-between; align-items: center; padding: 8px 0; border-bottom: 1px dashed #eee; font-size: 14px; }
    .btn-add { background: #28a745; color: white; padding: 6px 12px; text-decoration: none; border-radius: 4px; font-size: 12px; font-weight: bold; }
    .btn-add:hover { background: #218838; }
    .btn-edit { background: #ffc107; color: #212529; padding: 4px 8px; text-decoration: none; border-radius: 4px; font-size: 11px; font-weight: bold; margin-right: 5px; }
    .btn-edit:hover { background: #e0a800; }
    .no-items { font-style: italic; color: #666; font-size: 13px; }
    .inline-edit-form { display: inline-flex; gap: 5px; align-items: center; }
    .inline-edit-form input[type="text"] { padding: 4px 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 3px; }
    .btn-save { background: #17a2b8; color: white; border: none; padding: 4px 8px; border-radius: 3px; cursor: pointer; font-size: 11px; }
    .btn-cancel { background: #6c757d; color: white; border: none; padding: 4px 8px; border-radius: 3px; cursor: pointer; font-size: 11px; }
</style>
</head>
<body>

<div class="container">
    <div class="course-header">
        <h2>Course: ${course.title}</h2>
        <p>Manage chapters and attach learning materials below.</p>
    </div>

    <div class="add-chapter-box">
        <h4>Add New Chapter / Section</h4>
        <form action="addChapter" method="post" class="chapter-form-row">
            <input type="hidden" name="courseId" value="${course.id}" />
            <input type="text" name="sectionTitle" placeholder="Enter chapter title (e.g. Collections Framework)" required="true" />
            <button type="submit">+ Create Chapter</button>
        </form>
    </div>

    <h3>Chapters / Sections</h3>
    
    <c:forEach var="sec" items="${section}">
        <div class="chapter-card">
            
            <div class="chapter-bar" onclick="toggleChapter(${sec.id})">
                <!-- Chapter Title Display Area -->
                <span id="title-container-${sec.id}">
                    📁 <span id="title-text-${sec.id}">${sec.sectionTitle}</span>
                </span>
                
                <div>
                    <!-- Edit Button -->
                    <a href="deleteChapter?sectionId=${sec.id}&courseId=${course.id}">delete</a>
                    <a href="javascript:void(0);" class="btn-edit" onclick="event.stopPropagation(); enableEdit(${sec.id}, '${sec.sectionTitle}')">Edit Chapter Title</a>
                    <a href="openAddSectionItem?sectionId=${sec.id}&courseId=${course.id}" class="btn-add" onclick="event.stopPropagation();">+ Add Content</a>
                    <span style="margin-left: 10px; font-size: 12px;">▼ Toggle</span>
                </div>
            </div>
            
            <div id="chapter-items-${sec.id}" class="chapter-content">
                <c:choose>
                    <c:when test="${not empty sec.items}">
                        <c:forEach var="item" items="${sec.items}">
                            <div class="item-row">
                                <span>📄 ${item.itemTitle}</span>
                                <a href="deleteContent?contentId=${item.id}&courseId=${course.id}">Delete Content</a>
                                <a href="openEditContent?contentId=${item.id}">Edit Content</a>
                                <a href="openViewContent?itemId=${item.id}">View Content--</a>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <span class="no-items">No content added to this section yet. Click "+ Add Content" to upload notes or links.</span>
                    </c:otherwise>
                </c:choose>
            </div>
            
        </div>
    </c:forEach>
    
    <c:if test="${empty section}">
        <p>No chapters available for this course yet.</p>
    </c:if>
</div>

<script>
    // Toggle the dropdown visibility for a specific chapter
    function toggleChapter(sectionId) {
        var content = document.getElementById("chapter-items-" + sectionId);
        content.style.display = (content.style.display === "block") ? "none" : "block";
    }

    // Enable inline editing mode for the chapter title
    function enableEdit(sectionId, currentTitle) {
        var titleContainer = document.getElementById("title-container-" + sectionId);
        
        // Replace the title container content with an inline form
        titleContainer.innerHTML = `
            <form action="updateChapter" method="post" class="inline-edit-form" onclick="event.stopPropagation();">
                <input type="hidden" name="sectionId" value="\${sectionId}" />
                <input type="hidden" name="courseId" value="${course.id}" />
                <input type="text" name="sectionTitle" value="\${currentTitle}" required="true" autofocus />
                <button type="submit" class="btn-save">Save</button>
                <button type="button" class="btn-cancel" onclick="cancelEdit(\${sectionId}, '\${currentTitle}')">Cancel</button>
            </form>
        `;
    }

    // Revert back to normal text if edit is canceled
    function cancelEdit(sectionId, originalTitle) {
        var titleContainer = document.getElementById("title-container-" + sectionId);
        titleContainer.innerHTML = `📁 <span id="title-text-\${sectionId}">\${originalTitle}</span>`;
    }
</script>

</body>
</html>