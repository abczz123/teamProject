<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Stylesheet" href="/Style/style.css">
<title>글 작성</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div>
		<h3>vr 아카이빙 작성</h3>
		<form action="vr_write" method="post" enctype="multipart/form-data">
		<input type="hidden" name="sectionNo" value="2">
			<table class="getTable" border="1">
				<tr>
					<th>파일</th>
					<td id="fileContainer"><input type="file" name="files"></td>
				</tr>
				<tr>
					<td colspan="2">
					<button type="button" class="addFile">파일 추가하기</button>
					</td>
				</tr>
				<tr>
					<th>글 제목</th>
					<td> <input type="text" name="boardTitle"> </td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td> <input type="text" name="boardContent"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">글 등록</button>
						<button type="reset">다시 작성</button>
						<button type="button" onclick="location.href='/vr'">글 목록 보기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	
		$(document).ready(function(e){
			
			$('.addFile').on("click", function(e){
				$('<br>').appendTo($('#fileContainer'))
				$('<br>').appendTo($('#fileContainer'))
				$('<input type="file" name="files">').appendTo($('#fileContainer'))
			});
			
		});
	
	</script>
</body>
</html>