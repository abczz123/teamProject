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
.img{
	max-width:100%;
	height:auto;
}
</style>
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<td>게시글 번호</td>
				<td>${board.boardNo}</td>
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
				<td>게시글 제목</td>
				<td>${board.boardTitle}</td>
			</tr>
			<tr>
				<td>게시글 내용</td>
				<td>${board.boardContent}</td>
			</tr>
			<tr>
				<td>등록 날짜</td>
				<td>${board.regDate}</td>
			</tr>
			<tr>
				<td>수정 날짜</td>
				<td>${board.modDate}</td>
			</tr>
		</table>
	</div>
	<br>
	<button type="button" onclick="location.href='/clip'">목록으로</button>
</body>
</html>