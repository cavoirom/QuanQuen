package quanquen.bussinessaccess;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import quanquen.model.Category;

public class BALCategory {
	private static PersistenceManager pm;
	
	public BALCategory() {
	}
	
	public List<String> getCategoriesByAddress(String province, String district){
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		Query query = pm.newQuery(Category.class);
		query.declareVariables("Place place");
		query.setResult("distinct this.title");
		query.declareParameters("Integer id");
		List<Integer> ids = new BALPlace().getListIdPlaceByAddress(province, district);
		List<String> strCategories = new ArrayList<String>();
		for (Integer id:ids){
			query.setFilter("this.places.contains(place) && place.id==id");
			strCategories.addAll((List<String>)query.execute(id));
		}
		List<String> stand = getCategories();
		stand.retainAll(strCategories);
		tx.commit();
		pm.close();
		return stand;	
	}
	
	public List<String> getCategories(){
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		Query query = pm.newQuery(Category.class);
		query.setResult("distinct this.title");
		query.setOrdering("this.title ASC");
		List<String> strCategories = (List<String>)query.execute();
		tx.commit();
		pm.close();
		return strCategories;
	}
}
