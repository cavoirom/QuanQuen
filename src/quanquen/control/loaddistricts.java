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
		
		//Get province from quanquen
		String province = request.getParameter("province");
		province = (province == null)? "TP.Hồ Chí Minh" : new String(province.getBytes("8859_1"),"UTF-8");
		
		HttpSession session = request.getSession();
		String all = "-------------All-----------------";
		//Get district from session
		String district = (String)session.getAttribute("district");
		district = (district == null)? all: district;
		
		//Get province from session
		String provinceSession = (String)session.getAttribute("provinceSession");
		
		//Get districts form session.
		List<String> districtsSession = (List<String>)session.getAttribute("districts");
		
		//if province not change then not load again districts
		if ((province != null && !province.equals(provinceSession)) || districtsSession == null){
			//Get list district by province
			districtsSession = new BALAddress().getDistrictsByProvince(province);
			System.out.println(province);
			System.out.println(districtsSession.toString());
//			districtsSession.add(0, all);
			session.setAttribute("districtsSession", districtsSession);
		}
		
		//Save information
		session.setAttribute("provinceSession", province);
		session.setAttribute("district", district);
		
		PrintWriter out = response.getWriter();
		String text = "";
		for (String str: districtsSession){
			if (str.equals(district)){
				text = text + "<option selected='selected'>" + str + "</option>";
			}else{
				text = text + "<option value ='"+ str +"'>" + str + "</option>";
			}
		}
		out.println(text);
		out.flush();
		out.close();
	}

}
