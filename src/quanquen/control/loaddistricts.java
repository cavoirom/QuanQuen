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
		String province = ((List<String>)session.getAttribute("provinces")).get(provinceid);
		List<String> districts = new BALAddress().getDistrictsByProvince(province);
		System.out.println("So huyện quận: " + districts.size());
		PrintWriter out = response.getWriter();
		String text = "";
		for (int i=0; i < districts.size(); i++){
			if (district != null && i==new Integer(district)){
				text = text + "\n" + "<option value=\"" + i +"\" selected=\"selected\">" + districts.get(i) + "</option>";
			}else{
				text = text + "\n" + "<option value=\"" + i + "\">" + districts.get(i) + "</option>";
			}
		}
		out.print(text);
		out.close();
	}

}
