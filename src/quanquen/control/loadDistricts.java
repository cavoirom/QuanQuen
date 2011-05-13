package quanquen.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quanquen.bussinessaccess.BALAddress;

/*
 * Load district by province
 */
public class loadDistricts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public loadDistricts() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String province = request.getParameter("province");
		HttpSession session = request.getSession();
		String district = (String)session.getAttribute("district");
		
		List<String> districts = new BALAddress().getDistrictsByProvince(province);
		PrintWriter out = response.getWriter();
		String text = "";
		for (int i=0; i < districts.size(); i++){
			if (district != null && districts.get(i).equals(district)){
				text = text + "<option value='" + districts.get(i) +"' selected='selected'>" + districts.get(i) + "</option>";
			}
			text = text + "<option value='" + districts.get(i) +"'>" + districts.get(i) + "</option>";
		}
		out.println();
		out.close();
	}

}
