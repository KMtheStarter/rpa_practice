<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
</head>
<body>
	<div align="center">
		<table border=1>
			<thead>
				<td>번호</td>
				<td>제목</td>
				<td>시간</td>
			</thead>
			<c:forEach items="${ boardList }" var="board">
			<tr>
				<td>${ board.num }</td>
				<td><a href="${ pageContext.request.contextPath }/board/${ board.num }">${ board.title }</a></td>
				<td>${ board.time }</td>
			</tr>
			</c:forEach>
		</table>
		<button onclick="location.href='${ pageContext.request.contextPath }/post'">새 글 작성</button>
	</div>
</body>
</html>