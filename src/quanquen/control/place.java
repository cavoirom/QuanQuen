package quanquen.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanquen.bussinessaccess.BALPlace;
import quanquen.model.Place;

/*
 * Display detail for place. detail.jsp
 */

public class place extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public place() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPlace = (String)request.getParameter("id");
		Integer id = null;
		
		if (idPlace != null){
			id = new Integer(idPlace);
		}
		
		Place place = new BALPlace().getPlaceAndUpdateNumber(id);
		request.setAttribute("place", place);
		RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
		dispatcher.forward(request, response);
	}

}
