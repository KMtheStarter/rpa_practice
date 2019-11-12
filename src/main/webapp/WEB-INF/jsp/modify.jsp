<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<form action="${ pageContext.request.contextPath }/board/${ board.num }" method="post">
		<div align="center">
			<table border=1>
				<tr>
					<td>제목</td>
					<td><input type="text" style="width: 580px;"
					name="title" value="${ board.title }"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="3" cols="80" name="content">${ board.content }</textarea></td>
				</tr>
			</table>
			<button>수정</button>
		</div>
	</form>
</body>
</html>