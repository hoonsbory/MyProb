package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BankDao;
import DAO.BankDao_loan;
import DAO.BankDao_save;
import VO.LoanVo;
import VO.SavingVo;
import service.BankService;
import service.BankServiceimp;

/**
 * Servlet implementation class saveServlet
 */
@WebServlet("/loan.do")
public class loanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loanServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8"); 
        
        String name = request.getParameter("name");
		int period = Integer.parseInt(request.getParameter("period"));
		int money = Integer.parseInt(request.getParameter("money"));
		
		LoanVo vo = new LoanVo();
		
		BankDao dao = new BankDao_loan();
		
		BankService service = new BankServiceimp(dao);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		vo.setName(name);
		vo.setPeriod(period);
		vo.setMoney(money);
		
		String account = service.insertaccount(vo);

		map = service.showaccount(account);
		
		
		request.setAttribute("map2", map);
		
		request.getRequestDispatcher("/insert.jsp").forward(request, response);
		
		
	}

}
