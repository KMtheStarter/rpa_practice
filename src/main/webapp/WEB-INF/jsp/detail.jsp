<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	function deleteComment(num){
		if(confirm("삭제하시겠습니까?")){
			$.ajax({
				type : "DELETE",
				url : "${ pageContext.request.contextPath }/board/" + num,
				success : function(data){
					console.log(data);
					if (data == 1){
						location.href="${ pageContext.request.contextPath }/board"
					} else {
						alert("삭제에 실패했습니다.");
					}
				}
			});
		}
	}
</script>
</head>
<body>
	<div align="center">
		<table border=1 style="width: 60%">
			<tr>
				<td>제목</td>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<td>작성시간</td>
				<td>${ board.time }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${ board.content }</td>
			</tr>
		</table>
		<button onclick="location.href='${ pageContext.request.contextPath }/modify/${ board.num }'">수정</button>
		<button onclick="deleteComment(${ board.num })">삭제</button>
	</div>
</body>
</html>