package kr.ac.kopo.framework;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"*.do"})
public class DispatcherServlet extends HttpServlet {

	private HandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			mappings = new HandlerMapping();
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		
		/*
		 	/board/list.do   ==> new kr.ac.kopo.board.controller.BoardController().list()
		 	/board/detail.do ==> new kr.ac.kopo.board.controller.BoardController().detail()
		 	/login.do        ==> new kr.ac.kopo.member.controller.MemberController().login() 
		 */
		
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("uri : " + uri);
	}

	
	
}









