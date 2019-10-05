package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BankDao;
import DAO.BankDao_loan;
import DAO.BankDao_save;
import VO.SavingVo;
import service.BankService;
import service.BankServiceimp;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/search.do")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		String account = request.getParameter("account");

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		BankDao dao = new BankDao_save();
		BankDao dao2 = new BankDao_loan();
		BankService service = new BankServiceimp(dao);
		BankService service2 = new BankServiceimp(dao2);

		map = service.showaccount(account);
		map2 = service2.showaccount(account);

		
			request.setAttribute("map2", map2);
	
			request.setAttribute("map", map);

			System.out.println(map);
			System.out.println(map2);
			if(map.size()==0 && map2.size()==0) {
			request.setAttribute("error", 1);
			}
		
		request.getRequestDispatcher("/select.jsp").forward(request, response);
	}

}
