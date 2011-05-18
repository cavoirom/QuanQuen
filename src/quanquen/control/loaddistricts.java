package quanquen.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quanquen.bussinessaccess.BALAddress;

/*
 * Load district by province. quanquen.jsp
 */
public class loaddistricts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public loaddistricts() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int provinceid = Integer.parseInt(request.getParameter("provinceid"));
		HttpSession session = request.getSession();
		String district = (String)session.getAttribute("district");
		Integer id = null;
		if (district == null || district.equals("")){
			id = -1;
		}else{
			id = new Integer(district);
		}
		String province = ((List<String>)session.getAttribute("provinces")).get(provinceid);
		List<String> districts = new BALAddress().getDistrictsByProvince(province);
		PrintWriter out = response.getWriter();
		String text = "";
		if (district == null || new Integer(district) == -1){
			text = "<option value=\"-1\" selected=\"selected\">----------Tất cả----------</option>";
		}else{
			text = "<option value=\"-1\">----------Tất cả----------</option>";
		}
		for (int i = 0; i < districts.size(); i++){
			if (i == id){
				text = text + "<option value=\"" + i +"\" selected=\"selected\">" + districts.get(i) + "</option>";
			}else{
				text = text + "<option value=\"" + i + "\">" + districts.get(i) + "</option>";
			}
		}
		out.println(text);
		out.close();
	}

}
