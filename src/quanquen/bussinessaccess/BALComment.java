package quanquen.bussinessaccess;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import quanquen.model.Comment;

public class BALComment {
	private static PersistenceManager pm;
	
	public Comment getCommentById(int id){
		Comment comment = new Comment(id);
		Comment ret = null;
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Comment.class);
		query.setFilter("");
		return null;
	}

}
