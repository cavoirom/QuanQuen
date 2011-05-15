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


public class loadtopplace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public loadtopplace() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BALPlace balPlace = new BALPlace();
		List<Place> topPlaces = (List<Place>)balPlace.getPlacesByVisistorDesc();
		List<Place> newPlaces = (List<Place>)balPlace.getPlacesByDateDesc();
		//BALArticle balArticle = new BALArticle();
		List<Integer> newArticlesId = (List<Integer>)(new BALArticle().getArticleByDescDate());
		List<Place> placesWithNewArticle = new ArrayList<Place>();
		for (int i=1; i<newArticlesId.size(); i++){
			Place place = balPlace.getPlacesByArticleId(newArticlesId.get(i));
			placesWithNewArticle.add(place);
		}
		HttpSession session = request.getSession();
		System.out.println(placesWithNewArticle.size());
		session.setAttribute("topPlaces", topPlaces);
		session.setAttribute("placesWithNewArticle", placesWithNewArticle);
		session.setAttribute("newPlaces", newPlaces);
		System.out.println(session.getAttribute("ul").toString());
		response.sendRedirect(session.getAttribute("ul").toString());
	}

}
