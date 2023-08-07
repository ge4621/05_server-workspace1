package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pizza
 */
@WebServlet("/confirmPizza.do")
public class pizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pizza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("이거 잘되나??");
		//1)전달 값 중에 한글이 있을 경우 인코디 처리(POST방식 일때만)
		//인코딩
		//request.setCharacterEncoding("UTF-8");
		
		//요청시 전달 값 뽑기 및 데이터 가용 처리(파싱 같은 것) => 변수 및 객체 기록
		//request.getParameter("키값") => "벨류값 반환"(자료형 : String)
		//request.getParameterValues("키값") : ["벨류값", "벨류값",...](반환형 : String[])
		//=> 만일 키 값이 존재하지 않을 경우 null반환
		
		String userName = request.getParameter("userName");//"차은우" req속성
		String phone = request.getParameter("phone");//"01011112222" , 
		String address = request.getParameter("address");//"서울시 강남구" req속성
		String message = request.getParameter("message");//"빨리 가져다 주세요" | ""
		
		String pizza = request.getParameter("pizza");//"콤비네이션 피자"
		String[] topping = request.getParameterValues("topping");//"["고구마 무스","치즈 바이트"...]" | null
		String[] side = request.getParameterValues("side");//["핫소스","피클"...] | null
		String payment = request.getParameter("payment");//"card"|"cash"
		//int price = request.getParameter("price")
		//3)요청 처리(db에 sql 문 실행하러 > Service > Dao)
		
		System.out.println("userName : " + userName);
		System.out.println("phone : " + phone);
		System.out.println("address : " + address);
		System.out.println("message : " + message);
		
		
		if(topping == null) {
			System.out.println("topping :없다");
		}else {
			System.out.println("topping : " + String.join("/", topping));
		}
		
		if(side == null) {
			System.out.println("side :없다");
		}else {
			System.out.println("side : " + String.join("/", side));
		}
		
		System.out.println("pizza : " + pizza);
		System.out.println("payment : " + payment);
		
		//가격 설정
		int price = 0;
		
		switch(pizza) {
		case "콤비네이션피자" : price += 5000; break;
		case "치즈피자" : price += 6000; break;
		case "포테이토피자" : 
		case "고구마피자" : price += 7000;break;
		case "불고기피자" : price += 8000;break;
		}
		
		
		if(topping != null) {//토핑이 null이 아닐때만 돌리기
			for(int i = 0 ;i<topping.length;i++) {
				
				switch(topping[i]) {
				case "고구마무스" :
				case "콘크림무스" :price += 1500; break;
				case "파인애플토핑" :
				case "치즈토핑" : price += 2000; break;
				case "치즈바이트" : 
				case "치즈크러스트" : price += 3000;break;
				
				}
			}
			
		}
		
		if(side != null) {
			for(int i =0;i<side.length;i++) {
				switch(side[i]) {
				case "콜라" :
				case "사이다" : price +=2000; break;
				case "핫소스" :
				case "갈릭소스" : price += 300; break;
				case "피클" :
				case "파마산 치즈가루" : price += 500; break;
				}
			}
		}
		System.out.println("price : " + price);
		
		//4)요청처리 후 사용자가 보게될 응답 페이지(결제 페이지) 만들기
		//	응답페이지(jsp)를 선택해서 포워딩
		//단, 응답페이지에서 필요한 데이터가 있다면 담아서 포워딩 할 것!!
		//request attribute 영역에 담기 
		//어떤 데이터가 필요한지 모르겠으면? => 머저 jsp를 만들어보기!!
		
		request.setAttribute("name",userName);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		request.setAttribute("topping", topping);
		request.setAttribute("side", side);
		request.setAttribute("payment", payment);
		request.setAttribute("price", price);
		
		//응답할 뷰(jsp)선택
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/pizzaPayment.jsp");
		//선택된 뷰가 사용자에게 보여지도록 포워딩
		view.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
