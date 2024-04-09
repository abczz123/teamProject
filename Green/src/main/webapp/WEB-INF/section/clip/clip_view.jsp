<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<td>${board.boardFile}</td>
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
				<td>작성 년도</td>
				<td>${board.boardWriteYear}</td>
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