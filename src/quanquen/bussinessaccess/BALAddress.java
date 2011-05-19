package quanquen.bussinessaccess;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import quanquen.model.Address;

public class BALAddress {
	private static PersistenceManager pm;
	
	public List<Address> getAdress(){
		List<Address> address = new ArrayList<Address>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Address.class);
		address = (List<Address>)query.execute();
		pm.close();
		return address;
	}
	
	public List<Address> getAdressByProvince(String province){
		List<Address> address = new ArrayList<Address>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Address.class);
		query.declareParameters("String province");
		query.setFilter("this.province == province");
		pm.close();
		return address;
	}
	
	//Pass
	public List<String> getAllProvince(){
		List<String> provinces = new ArrayList<String>();
		pm = Connection.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();	
		Query query = pm.newQuery(Address.class);
		//SET field;
		query.setResult("distinct province");
		//SET unique
		//query.setUnique(true);
		provinces = (List<String>)query.execute();
		tx.commit();
		pm.close();
		return provinces;		
	}
	//Pass
	public List<String> getDistrictsByProvince(String province){
		List<String> districts = new ArrayList<String>();
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();	
		Query query = pm.newQuery(Address.class);
		query.setFilter("this.province.matches('(?i).*" + province + ".*')");
		//SET field;
		query.setResult("distinct district");
		districts = (List<String>)query.execute(province);
		tx.commit();
		pm.close();
		return districts;	
	}
	
	public static void main(String[] args) {
		System.out.println(new BALAddress().getDistrictsByProvince("Hồ chí minh").toString());
	}
}
