package quanquen.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quanquen.bussinessaccess.BALAddress;

public class category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public category() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String province = request.getParameter("province");	
		province = (province == null)? "Hồ Chí Minh": province;
		session.setAttribute("province", province);
		List<String> provinces;
		provinces = (List<String>)session.getAttribute("provinces");
		if (provinces == null){
			provinces = new BALAddress().getAllProvince();
			session.setAttribute("provinces",provinces);
		}
		
		response.sendRedirect("quanquen.jsp");
	}

}
