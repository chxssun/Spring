<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	    	<form action="boardInsert.do" method="post">
	    		<table class="table">
	    			<tr>
	    				<td>제목</td>
	    				<td><input class="form-control" name="title" type="text"> </td>
	    			</tr>
	    			<tr>
	    				<td>내용</td>
	    				<td><textarea class="form-control" name="contents" rows="7" cols=""></textarea></td>
	    			</tr>
	    			<tr>
	    				<td>작성자</td>
	    				<td><input class="form-control" name="writer" type="text"> </td>
	    			</tr>
	    			<tr>
	    				<td colspan="2" align="center">
	    					<button class="btn btn-success" type="submit">등록</button>
	    					<button class="btn btn-warning" type="reset">취소</button>
	    					<a class="btn btn-info" href="boardList.do">목록</a>
	    				</td>
	    			</tr>
	    		</table>	
	    	</form>
	    </div>
	    <div class="panel-footer">웹기반 인공지능 Track2 (B) - 김창선</div>
	  </div>
	</div>
</body>
</html>