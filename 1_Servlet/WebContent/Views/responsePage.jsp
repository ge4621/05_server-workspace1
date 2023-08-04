<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{color:red;}
	#name{color:orange;}
	#age{color:blue;}
	#city{color:yellowgreen;}
	#height{color:purple;}
	#gender{color:green;}
	
</style>
</head>
<body>
	
	<%
		//스크립틀릿(scriptlet) == html문서 내에 자바코드를 쓸 수 있는 영역
		//int a=10;	
		
		//request.getAttribute("키") : object (그에 해당하는 벨류 값)
		String name = (String)request.getAttribute("name"); //형변환 필요 getAttribute => 반환형이 object , 다운캐스팅 강제형변환 오브젝트 모든 것의 부모
		int age = (int)request.getAttribute("age");
		String city = (String)request.getAttribute("city");
		double height = (double)request.getAttribute("height");
		String gender = (String)request.getAttribute("gender");
		String[] foods = (String[])request.getAttribute("foods");
	%>
	
	<h2>개인정보 응답화면 - POST</h2>
	
	<span id="name"><%= name%></span>님은 
	<span id="age"><%= age %></span>살이며,
	<span id="city"><%=city %></span>에 사는
	키는 <span id="height"><%= height %></span>cm 이고
	
	성별은 
	<% if(gender == null){ %>	
		선택하지 않았습니다. <br> <!-- case1 -->
	<%}else{%>	
		<%if(gender.equals("M")){ %>
			<span id="gender">남자</span>입니다. <br> <!-- case2 -->
		<%}else{ %>
			<span id="gender">여자</span>입니다. <br> <!-- case2-1 -->
		<%} %>
	<%} %>


	좋아하는 음식은
		 <% if(foods == null){ %>
			없습니다.
		<% }else{ %>
			<ul>
				<% for(int i = 0 ;i<foods.length; i++){ %>
					<li><%= foods[i] %></li>
				<% } %>
			</ul>
		<% } %>

</body>
</html>