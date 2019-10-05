<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(()=>{
	let error = "<c:out value='${error}'/>";
	if(error==1){
		alert("존재하지않는 계좌번호입니다");
	}
})


</script>
<style type="text/css">
#username{
	display : inline;
	font-size: 1.5em;
	font-weight: bold;
}
table , td{
	text-align: center;
	border: 1px solid black;
	
}
.firstTR{
	font-size : 1.2em;
	font-weight: bold;
}
</style>
</head>
<body>


<h2>계좌조회
</h2>

<form action="search.do" method="get">
<input type="text" name="account" id="account">
<input type="submit">


</form>



<c:if test="${not empty map2}">
	<p id="username">${map2.vo.name}</p>님의 대출통장 정보입니다.
	<table>
		<tr class = "firstTR">
			<td>이름</td>
			<td>기간</td>
			<td>대출액</td>
			<td>이율</td>
			<td>이자액</td>
			<td>월상환액</td>
			<td>계좌번호</td>
			
		</tr>
		<tr>
			<td>${map2.vo.name}</td>
			<td>${map2.vo.period}</td>
			<td>${map2.vo.money}</td>
			<td>${map2.vo.rate}%</td>
			<td>${map2.vo.interest}</td>
			<td>${map2.vo.returnMoney}</td>
			<td>${map2.vo.account}</td>
			
		</tr>
	</table>
</c:if>
<c:if test="${not empty map}">
	<p id="username">${map.vo.name}</p>님의 적금통장 정보입니다.
	<table>
		<tr class = "firstTR">
			<td>이름</td>
			<td>기간</td>
			<td>월입금액</td>
			<td>이율</td>
			<td>이자액</td>
			<td>총입금액</td>
			<td>만기시 환급액</td>
			<td>계좌번호</td>
			
		</tr>
		<tr>
			<td>${map.vo.name}</td>
			<td>${map.vo.period}</td>
			<td>${map.vo.money}</td>
			<td>${map.vo.rate}%</td>
			<td>${map.vo.interest}</td>
			<td>${map.vo.entire}</td>
			<td>${map.vo.returnMoney}</td>
			<td>${map.vo.account}</td>
			
		</tr>
	</table>
</c:if>
<a href="./index.jsp">홈으로</a>
</body>
</html>