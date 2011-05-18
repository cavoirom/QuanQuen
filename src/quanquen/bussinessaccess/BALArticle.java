package quanquen.bussinessaccess;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import quanquen.model.Article;
import quanquen.model.Place;

public class BALArticle {
	private static PersistenceManager pm;
	
	public List<Integer> getArticleByDescDate(){
		List<Integer> articlesId;
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.setSerializeRead(true);
		tx.begin();		
		Query query = pm.newQuery(Article.class);
		query.setOrdering("this.postedDate DESCENDING");
		query.setResult("id");
		query.setRange(0, 7);
		articlesId = (List<Integer>) query.execute();
		tx.commit();
		pm.close();
		return articlesId;
	}
	
	public Article getArticleById(int id){
		Article article = new Article(id);
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.setSerializeRead(true);
		tx.begin();
		Query query = pm.newQuery(Article.class);
		query.declareParameters("Article article");
		query.setFilter("this.id == article.id");
		query.setRange(0, 1);
		article = ((List<Article>) query.execute()).get(0);
		tx.commit();
		pm.close();
		return article;
	}
}
