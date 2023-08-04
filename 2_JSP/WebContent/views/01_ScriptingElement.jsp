<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{color:red;}
</style>
</head>
<body>
	<h1>스크립트 원소</h1>
	
	<!-- html 주석 : 개발자 도구 탭에 노출된다. -->
	<%--JSP 주석 : 개발자 도구 탭에 노출이 안된다. --%>
	
	<%
		//스크립틀릿 : 이 안에 일반적인 자바 코드 작성(변수 선언 및 초기화, 제어문)
		int sum =0;
		for(int i=1;i<=100;i++){
			sum +=i;
		}
		
		System.out.println("덧셈 끝!! 결과 : " + sum);
	%>
	
	<p>
		화면으로 출력하고자 한다면 <br>
		스크립틀릿 이용해서 출력 가능 : <% out.println(sum); %> <br>
		표현식(출력식) 이용해서 출력 가능 : <%= sum %> <!-- out.println();으로 감싸져 있다고 생각하면 됨 -->
	</p>
	
	<%
		String[] name = {"문동은","박연진","이사라","최혜정"};
	%>
	
	<h5>배열의 길이 : <%= name.length %></h5>
	<h5>배열에 담긴 값 : <%=String.join("-",name) %></h5>
	
	<h4>반복문을 통해 html요소 반복적으로 화면에 출력 가능</h4>
	
	<!-- for Each문 -->
	<ul>
		<% for(String a:name){ %>
			<li><%= a %></li>
		<% } %>
	</ul>	
	
	<%!
		public void test(){
		//선언하는 구문	
	}
	%>
	
	<%test(); %>
	
	
	
	
</body>
</html>