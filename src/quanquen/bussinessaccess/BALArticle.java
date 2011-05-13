package quanquen.bussinessaccess;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import quanquen.model.Article;

public class BALArticle {
	private static PersistenceManager pm;
	
	public List<Article> getArticleByDescDate(){
		List<Article> articles;
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Article.class);
		query.setOrdering("this.postedDate DESCENDING");
		query.setRange(0, 7);
		articles = (List<Article>) query.execute();
		pm.close();
		return articles;
	}
}
