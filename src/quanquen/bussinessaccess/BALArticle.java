package quanquen.bussinessaccess;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import quanquen.model.Article;
import quanquen.model.Place;

public class BALArticle {
	private static PersistenceManager pm;
	
	public List<Integer> getArticleByDescDate(){
		List<Integer> articlesId;
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Article.class);
		query.setOrdering("this.postedDate DESCENDING");
		query.setResult("id");
		query.setRange(0, 7);
		articlesId = (List<Integer>) query.execute();
		pm.close();
		return articlesId;
	}
}
