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

import quanquen.model.*;

@SuppressWarnings("serial")
public class AuthorizationServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Setup output stream
		PrintWriter out = resp.getWriter();

		// out.println("System is closed.");

		/* init data */
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String rememberPassword = req.getParameter("rememberPassword");
		if (rememberPassword == null) {
			rememberPassword = "";
		}

		boolean isAdminAuthorized = false;
		String requestURI = req.getRequestURI();

		/* begin - process login */
		if (requestURI.endsWith("login.jsp")) {
			HttpSession session = req.getSession(true);
			session.setAttribute("username", username);
			if (this.authorize(username, password)) {
				isAdminAuthorized = true;
				session.setAttribute("isAdminAuthorized", isAdminAuthorized);
				if (rememberPassword.equals("on")) {
					session.setMaxInactiveInterval(3600*24*7*2);
				}
				else {
					session.setMaxInactiveInterval(1800);
				}
				resp.sendRedirect("home.jsp");
			} else
				resp.sendRedirect("index.jsp?status=false");
		}
		/* end - process login */

		if (requestURI.endsWith("logout.jsp")) {
			HttpSession session = req.getSession(true);
			session.invalidate();
			resp.sendRedirect("index.jsp");
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	private boolean authorize(String username, String password) {
		PersistenceManagerFactory pmf = JDOHelper
				.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		// Get member from datastore
		Query q = pm.newQuery(quanquen.model.Member.class);
		pm.getFetchPlan().setGroup("authorization");
		q.setFilter("username == u");
		q.declareParameters("String u");
		q.compile();
		List<Member> result = (List<Member>) q.execute(username);
		if (result.size() <= 0) {
			tx.commit();
			pm.close();
			return false;
		}
		Member m = result.get(0);

		boolean isAdmin = false;
		Iterator<String> it = m.getGroup().getPermissions().iterator();
		// Check admin permission
		while (it.hasNext()) {
			if (it.next().equals("admin"))
				isAdmin = true;
			// System.out.println(it.next());
		}
		tx.commit();
		pm.close();
		// System.out.println(m.getEmail());
		// System.out.println(m.getGroup().getName());
		// System.out.println(m.getUsername()+":"+m.getPassword());
		// System.out.println(username+":"+password);
		// pm.close();

		// do authorization
		if (m.getUsername().equals(username)
				&& m.getPassword().equals(password) && isAdmin) {
			return true;
		} else {
			return false;
		}
	}
}
