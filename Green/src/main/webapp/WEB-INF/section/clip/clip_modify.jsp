<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.Img{
	width:350px;
	height:350px;
}
</style>
</head>
<body>
	<div>
	<form action="/clip_modify" method="post" enctype="multipart/form-data">
					<input type="hidden" name="sectionNo" value="3">
					<input type="hidden" name="boardWriteYear" value="${board.boardWriteYear}">
		<table border="1">
			<tr>
				<td>게시글 번호</td>
				<td><input type="text" name="boardNo" value="${board.boardNo}" readonly="readonly"></td>
			</tr>
				<tr>
				<td>파일</td>
				<c:forEach items="${video}" var="clip">
					<c:set var="youtubeUrl" value="${clip.fileName}"/>
				    <td>
				        <iframe width="1280" height="640" src="https://www.youtube.com/embed/${fn:substringAfter(youtubeUrl, 'v=')}" title="YouTube 동영상" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
				    </td>
				</c:forEach>
				</tr>
				<tr>
					<td>파일 수정</td>
					<td><input type="text" name="youtubeLink"></td>
				</tr>
			<tr>
				<td>게시글 제목</td>
				<td><input type="text" name="boardTitle" value="${board.boardTitle}"></td>
			</tr>
			<tr>
				<td>게시글 내용</td>
				<td><input type="text" name="boardContent" value="${board.boardContent}"></td>
			</tr>
		</table>
			<br>
			<button type="submit">수정 완료</button>
			<button type="button" onclick="location.href='/clip'">목록으로</button>
	</form>
	</div>
	<br>
</body>
</html>