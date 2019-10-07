<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<h2>적금 통장 개설</h2>
<form action="save.do" method="get">
이름<br>
<input type="text" name="name" id="name" required="required" ><br>
기간<br>
<input type="text" name="period" id="period" required="required" pattern="([0-9]{1,2})">개월<br>
월입금액<br>
<input type="text" name="money" id="money" required="required" pattern="([0-9]{1,10})">원<br>
<!--(^[0-9]*$) 숫자만 허용하는 정규식 -->
<input type="submit" value="개설">
</form>

<c:if test="${not empty map}">
	신규 개설된<p id="username"> ${map.vo.name}</p>님의 적금통장 정보입니다.
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
			<td>${map.vo.period}개월</td>
			<td>${map.vo.money}원</td>
			<td>${map.vo.rate}%</td>
			<td>${map.vo.interest}원</td>
			<td>${map.vo.entire}원</td>
			<td>${map.vo.returnMoney}원</td>
			<td>${map.vo.account}</td>
			
		</tr>
	</table>
</c:if>
<h2>대출 통장 개설</h2>
<form action="loan.do" method="get">
이름<br>
<input type="text" name="name" id="name" required="required"><br>
기간<br>
<input type="text" name="period" id="period" required="required" pattern="([0-9]{1,2})">개월<br>
대출액<br>
<input type="text" name="money" id="money" required="required" pattern="([0-9]{1,11})">원<br>
<input type="submit" value="개설">
</form>
<c:if test="${not empty map2}">
	신규 개설된<p id="username">${map2.vo.name}</p>님의 대출통장 정보입니다.
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
			<td>${map2.vo.period}개월</td>
			<td>${map2.vo.money}원</td>
			<td>${map2.vo.rate}%</td>
			<td>${map2.vo.interest}원</td>
			<td>${map2.vo.returnMoney}원</td>
			<td>${map2.vo.account}</td>
			
		</tr>
	</table>
</c:if>
<a href="./index.jsp">홈으로</a>
</body>
</html>