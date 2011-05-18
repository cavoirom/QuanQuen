package quanquen.bussinessaccess;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 * Create pool connection to JDO
 */

public class Connection {
	
	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	
	public static PersistenceManager getPersistenceManager(){
		return pmf.getPersistenceManager();
	}
}
