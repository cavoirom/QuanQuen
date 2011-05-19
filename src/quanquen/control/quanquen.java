package quanquen.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanquen.bussinessaccess.BALPlace;
import quanquen.model.Place;

public class quanquen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public quanquen() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String province = request.getParameter("province");
		province = (province == null)? "TP.Hồ Chí Minh": new String(province.getBytes("8859_1"),"UTF-8");
		String district = request.getParameter("district");
		district = (district == null)? "": new String(district.getBytes("8859_1"),"UTF-8");
		String category = request.getParameter("type");
		category = (category == null)? "Cà phê": new String(category.getBytes("8859_1"),"UTF-8");
		
		List<Place> places = new BALPlace().getPlacesByCategoryAddress(province, district, category, 1);
		System.out.println("Số địa điểm quán quen: " + places.size());
		request.setAttribute("places", places);
		RequestDispatcher dispatcher = request.getRequestDispatcher("quanquen.jsp");
		dispatcher.forward(request, response);
	}

}
