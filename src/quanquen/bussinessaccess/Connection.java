package quanquen.bussinessaccess;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

/*
 * Create pool connection to JDO
 */

public class Connection {
	
	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	
	public static PersistenceManager getPersistenceManager(){
		return pmf.getPersistenceManager();
	}
}
