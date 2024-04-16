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
		<table border="1">
			<tr>
				<td>게시글 번호</td>
				<td>${board.boardNo}</td>
			</tr>
				<c:forEach items="${image}" var="img">
				<tr>
					<td>파일</td>
					<td><img class = "Img" src="${img.fileName}" alt="이미지"></td>
				</tr>
				</c:forEach>
			<tr>
				<td>게시글 제목</td>
				<td>${board.boardTitle}</td>
			</tr>
			<tr>
				<td>게시글 내용</td>
				<td>${board.boardContent}</td>
			</tr>
			<tr>
				<td>작성 년도</td>
				<td>${board.boardWriteYear}</td>
			</tr>
			<tr>
				<td>등록 날짜</td>
					<c:set var="formattedRegDate1" value="${fn:substring(board.regDate.toString(), 0, 4)}"/>
					<c:set var="formattedRegDate2" value="${fn:substring(board.regDate.toString(), 5, 7)}"/>
					<c:set var="formattedRegDate3" value="${fn:substring(board.regDate.toString(), 8, 10)}"/>
					<c:set var="formattedRegDate4" value="${fn:substring(board.regDate.toString(), 11, 13)}"/>
					<c:set var="formattedRegDate5" value="${fn:substring(board.regDate.toString(), 14, 16)}"/>
						
				<td>
					<c:out value="${formattedRegDate1}" />년 <c:out value="${formattedRegDate2}" />월 
					<c:out value="${formattedRegDate3}" />일 <c:out value="${formattedRegDate4}" />시
					<c:out value="${formattedRegDate5}" />분
				</td>
			</tr>
			<tr>
				<td>수정 날짜</td>
					<c:set var="formattedModDate1" value="${fn:substring(board.modDate.toString(), 0, 4)}"/>
					<c:set var="formattedModDate2" value="${fn:substring(board.modDate.toString(), 5, 7)}"/>
					<c:set var="formattedModDate3" value="${fn:substring(board.modDate.toString(), 8, 10)}"/>
					<c:set var="formattedModDate4" value="${fn:substring(board.modDate.toString(), 11, 13)}"/>
					<c:set var="formattedModDate5" value="${fn:substring(board.modDate.toString(), 14, 16)}"/>
						
				<td>
					<c:out value="${formattedModDate1}" />년 <c:out value="${formattedModDate2}" />월 
					<c:out value="${formattedModDate3}" />일 <c:out value="${formattedModDate4}" />시
					<c:out value="${formattedModDate5}" />분
				</td>
			</tr>
		</table>
	</div>
	<br>
	<button type="button" onclick="location.href='/vr_modify?boardNo=${board.boardNo}'">수정</button>
	<button type="button" onclick="location.href='/vr_remove?boardNo=${board.boardNo}'">삭제</button>
	<button type="button" onclick="location.href='/vr'">목록으로</button>
</body>
</html>