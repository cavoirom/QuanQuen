package quanquen.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanquen.bussinessaccess.BALPlace;
import quanquen.model.Place;

/*
 * Display detail for Place
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
		String placeid = (String)request.getParameter("id");
		Integer id = null;
		if (placeid != null){
			id = Integer.parseInt(placeid);
		}
		if (placeid == null){
			response.sendRedirect("message.jsp?code=0");
		}
		Place place = new BALPlace().getPlaceByID(id);
	}

}
