package quanquen.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quanquen.bussinessaccess.BALPlace;
import quanquen.model.Place;

/*
 * Search for Place by address, name, price, comment, author
 */

public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public search() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get type of search
		String type = request.getParameter("type");
		type = (type == null)? "name" : type;
		
		//get address
		String address = (String)request.getParameter("address");
		if (address != null){
			address = new String(address.getBytes("8859_1"),"UTF-8");
		}
		
		//get Search Value
		String searchvalue = new String(request.getParameter("searchvalue").getBytes("8859_1"),"UTF-8");
		
		//Check for type of search
		BALPlace balPlace = new BALPlace();
		List<Place> places = balPlace.getPlacesByTypes(type.trim(), searchvalue.trim(), address, 1);
		
		//Save information for times other search
		HttpSession session = request.getSession();
		session.setAttribute("searchvalue", searchvalue);
		session.setAttribute("type", type);
		session.setAttribute("address", address);
		
		//Return result for client
		request.setAttribute("places", places);
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);

	}
}
