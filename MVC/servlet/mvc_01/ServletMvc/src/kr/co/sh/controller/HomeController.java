package kr.co.sh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sh.model.Test2Service;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 주소를 가져온다.
		String url = request.getRequestURI();
		
		// view 로 사용할 JSP
		String viewName = null;
		
		// controller
		if(url.contains("main.mvc")) {
			//System.out.println(" > main 요청");
			viewName = "main.jsp";
		} else if(url.contains("test1.mvc")) {
			//System.out.println(" > test1 요청");
			// Model 부분 (파라미터 추출,..)
			String str1 = request.getParameter("data1");
			String str2 = request.getParameter("data2");
			int number1 = Integer.parseInt(str1);
			int number2 = Integer.parseInt(str2);
			int result = number1 + number2;
			
			// 하단에 request로 전달 하니까
			request.setAttribute("result", result);
			
			viewName = "test1.jsp";
		} else if(url.contains("test2.mvc")) {
			//System.out.println(" > test2 요청");
			
			// 모델 요청
			int result = Test2Service.minus(request);
			request.setAttribute("result", result);
			
			viewName = "test2.jsp";
		}
		
		// 해당 jsp 로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
