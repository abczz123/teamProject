<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VR 아카이빙</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
.img{
	width:150px;
	height:150px;
}
</style>
</head>
<body>
	<h3>VR 아카이빙</h3>
	<button type="button" onclick="location.href='/vr'">전체 조회</button>
	<button type="button" onclick="location.href='/vr_now'">2024</button>
	<button type="button" onclick="location.href='/vr_now+1'">2025</button>
	<button type="button" onclick="location.href='/vr_now+2'">2026</button>	
	<hr>
	<div>
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
		<c:forEach items="${list}" var="board">
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
	</div>
		<form action="" id="actionForm" method="get">
			<input type="hidden" name="pageNum" value="${page.cv.pageNum}">
			<input type="hidden" name="amount" value="${page.cv.amount}">
		</form>
	<div>
		<c:if test="${not page.prev}">
			<a href=""> [prev] </a>
		</c:if>
		<c:if test="${page.prev}">
			<a class="pageBtn" href="${page.startPage-1}"> [prev] </a>
		</c:if>
		<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" step="1">
			<a class="pageBtn" href="${num}">${num}</a>
		</c:forEach>
		<c:if test="${not page.next}">
			<a href=""> [next] </a>
		</c:if>
		<c:if test="${page.next}">
			<a class="pageBtn" href="${page.endPage+1}"> [next] </a>
		</c:if>
	</div>
	<br>
	<button type="button" onclick="location.href='/vr_write'">게시글 작성</button>
	<br>
	<br>
	<button type="button" onclick="location.href='/main'">메인으로</button>
	<script type="text/javascript">
		$(document).ready(function(){
			
			let actionForm = $('#actionForm');
			
			$('.pageBtn').on("click", function(e){
				e.preventDefault();
				actionForm.find("input[name='pageNum']").val($(this).attr("href"));
				actionForm.submit();
			});
			
		})
	</script>
</body>
</html>