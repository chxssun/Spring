<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2>Spring MVC 01</h2>
	  <div class="panel panel-default">
	    <div class="panel-heading">Board</div>
	    <div class="panel-body">
	    	<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
				</thead>
				<tbody>
					<!-- 게시글 내용 출력 -->
					<c:forEach varStatus="i" items="${list }" var="vo">
					<tr>
						<!-- <td><c:out value="${vo.idx }"/></td> --> 
						<td><c:out value="${i.count }"/></td> <!-- i.index는 0부터 i.count는 1부터 -->
						<td>
							<a href="boardContents.do?idx=${vo.idx }">
								<c:out value="${vo.title }"/>
							</a>
						</td>
						<td><c:out value="${vo.writer }"/></td>
						<td>${fn:split(vo.indate, " ")[0] }</td> 
						<td><c:out value="${vo.count }"/></td> 
					</tr>
					</c:forEach>
				</tbody>
	    	</table>
	 		
	 		<a href="boardForm.do" class="btn btn-primary">글쓰기</a>
	 		
	    </div>
	    <div class="panel-footer">웹기반 인공지능 Track2 (B) - 김창선</div>
	  </div>
	</div>
</body>
</html>