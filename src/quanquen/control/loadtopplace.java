package quanquen.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quanquen.bussinessaccess.BALArticle;
import quanquen.bussinessaccess.BALPlace;
import quanquen.model.Article;
import quanquen.model.Place;

/*
 * Load top place, new place, new article. index.jsp
 */

public class loadtopplace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public loadtopplace() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Load places for home page
		BALPlace balPlace = new BALPlace();
		List<Place> topPlaces = (List<Place>)balPlace.getPlacesByVisistorDesc();
		List<Place> newPlaces = (List<Place>)balPlace.getPlacesByDateDesc();
		List<Integer> newArticlesId = (List<Integer>)(new BALArticle().getArticleByDescDate());
		List<Place> placesWithNewArticle = balPlace.getPlacesByListArticleId(newArticlesId);
		
		//Save to session
		HttpSession session = request.getSession();
		session.setAttribute("topPlaces", topPlaces);
		session.setAttribute("placesWithNewArticle", placesWithNewArticle);
		session.setAttribute("newPlaces", newPlaces);
		String ul = (String)session.getAttribute("ul");
		if(ul == null){
			ul = "index.jsp";
			session.setAttribute("ul", ul);
		}
		
		//Return home page
		response.sendRedirect(session.getAttribute("ul").toString());
	}

}
