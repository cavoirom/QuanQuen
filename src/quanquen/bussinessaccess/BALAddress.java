package quanquen.bussinessaccess;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import quanquen.model.Address;

public class BALAddress {
	private PersistenceManager pm;
	
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
	
	public List<String> getAllProvince(){
		List<String> provinces = new ArrayList<String>();
		List<Address> address = getAdress();
		for (Address add: address){
			String province = add.getProvince();
			if (!provinces.contains(province)){
				provinces.add(province);
			}
		}
		return provinces;		
	}
	
	public List<String> getDistrictsByProvince(String province){
		List<String> districts = new ArrayList<String>();
		List<Address> address = getAdressByProvince(province);
		for (Address add: address){
			String district = add.getDistrict();
			if (!district.contains(province)){
				districts.add(province);
			}
		}
		return districts;		
	}
}
