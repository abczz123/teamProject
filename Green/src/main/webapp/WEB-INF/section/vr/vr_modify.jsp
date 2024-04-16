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
	<form action="/vr_modify" method="post" enctype="multipart/form-data">
					<input type="hidden" name="sectionNo" value="2">
					<input type="hidden" name="boardWriteYear" value="${board.boardWriteYear}">
		<table border="1">
			<tr>
				<td>게시글 번호</td>
				<td><input type="text" name="boardNo" value="${board.boardNo}" readonly="readonly"></td>
			</tr>
				<c:forEach items="${image}" var="img">
				<tr>
					<td>파일</td>
					<td><img class = "Img" src="${img.fileName}" alt="이미지"></td>
				</tr>
				</c:forEach>
				<c:forEach items="${image}" var="img">
				<tr>
				<td>파일 수정</td>
				<td><input type="file" name="files"></td>
				</tr>
				</c:forEach>
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
			<button type="button" onclick="location.href='/vr'">목록으로</button>
	</form>
	</div>
	<br>
</body>
</html>