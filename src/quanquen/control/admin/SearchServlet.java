package quanquen.control.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quanquen.model.Member;

public class SearchServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Setup output stream
		PrintWriter out = resp.getWriter();

		// Check authorization
		HttpSession session = req.getSession(true);
		boolean isAdminAuthorized;
		if (session.getAttribute("isAdminAuthorized") == null)
			isAdminAuthorized = false;
		else
			isAdminAuthorized = (Boolean) session
					.getAttribute("isAdminAuthorized");
		if (isAdminAuthorized) {
			// Check request
			String requestURI = req.getRequestURI();

			if (requestURI.endsWith("searchmember.jsp")) {
				String keyword = req.getParameter("keyword");

				// test
				// out.println(keyword);
				// out.println(result.size());

				session.setAttribute("searchMemberResult", (List<Member>) this.searchMember(keyword));
				resp.sendRedirect("home.jsp?cat=mem&c=res");
			}
		}

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public static List<Member> searchMember(String k) {
		PersistenceManagerFactory pmf = JDOHelper
				.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		// Get member from datastore
		Query q = pm.newQuery(quanquen.model.Member.class);
		pm.getFetchPlan().setGroup("search");
		q.setFilter("username.matches('.*" + k + ".*')");
		q.compile();
		List<Member> result = (List<Member>) q.execute();
		tx.commit();
		pm.close();
		return result;
	}

}
