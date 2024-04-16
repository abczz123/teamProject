<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<style>
.img{
	width:150px;
	height:150px;
}
</style>
</head>
<body>
	<h3>메인 페이지</h3>
	<a href="/signin">로그인</a>
	<a href="/signup">회원가입</a>
	<hr>
	
	<a>홈</a>
	<a >VR 아카이빙</a>
	<a>영상 게시판</a>
	<a>디지털 조감도</a>
	
	<hr>
	
	<section>
		검색창
	</section>
	
	<hr>
	<section>
		<h3>VR 아카이빙</h3> <a href="/vr">더보기</a>
			<table border=1>
				<tr>
					<td>게시글 번호</td>
					<td>제목</td>
					<td>내용</td>
					<td>작성 년도</td>
					<td>등록 날짜</td>
					<td>수정 날짜</td>
					<td>파일</td>
				</tr>
				<c:forEach items="${vrList}" var="board">
					<tr>
						<td>${board.boardNo}</td>
						<td><a href="<c:url value='/vr_view/${board.boardNo}'/>">${board.boardTitle}</a></td>
						<td>${board.boardContent}</td>
						<td>${board.boardWriteYear}</td>
						
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
						
						<c:forEach items="${board.imageFiles}" var="image">
						<td><img class="img" src="${image.fileName}" alt="이미지"></td>
						</c:forEach>					
					</tr>
				</c:forEach>
			</table>
	</section>
	
	<hr>
	<section>
		<h3>영상 게시판</h3> <a href="/clip">더보기</a>
				<table border=1>
				
				<tr>
					<td>게시글 번호</td>
					<td>제목</td>
					<td>내용</td>
					<td>등록 날짜</td>
					<td>수정 날짜</td>
					<td>파일</td>
				</tr>
				<c:forEach items="${videoList}" var="board">
					<tr>
						<td>${board.boardNo}</td>
						<td><a href="<c:url value='/clip_view/${board.boardNo}'/>">${board.boardTitle}</td>
						<td>${board.boardContent}</td>
						
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
						
						<c:forEach items="${board.videoFiles}" var="video">
						<c:set var="youtubeUrl" value="${video.fileName}"/>
						<td>
					        <iframe width="150" height="150" src="https://www.youtube.com/embed/${fn:substringAfter(youtubeUrl, 'v=')}" title="YouTube 동영상" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
					    </td>
						</c:forEach>				
					</tr>
				</c:forEach>
				</table>
	</section>
	
	<hr>
	<section>
		<h3>디지털 조감도</h3> <a href="viewmap">더보기</a>

	</section>
	
	<hr>
	<footer>
		<h3>푸터 섹션</h3>
	</footer>
</body>
</html>