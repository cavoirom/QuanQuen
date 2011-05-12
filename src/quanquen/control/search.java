package quanquen.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quanquen.bussinessaccess.BALPlace;
import quanquen.model.Place;


public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public search() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//get type of search
		String type = request.getParameter("type");
		type = (type == null)? "Tên địa điểm" : type;
		//get Search Value
		String searchvalue = request.getParameter("searchvalue");
		
		//Check for type of search
		List<Place> places = new BALPlace().getPlaces(type, searchvalue);
		
		//Save information for times other search
		HttpSession session = request.getSession();
		session.setAttribute("searchvalue", searchvalue);
		session.setAttribute("type", type);
		
		//Return result for client
		response.sendRedirect("result.jsp");
	}
}
