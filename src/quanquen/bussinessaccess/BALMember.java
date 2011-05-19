package quanquen.bussinessaccess;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import quanquen.model.Member;

public class BALMember {
	private static int numberResult = 20;
	private static PersistenceManager pm;
	public BALMember(){
		
	}
	public BALMember(int numberResult){
		this.numberResult = numberResult;
	}
	
	public boolean addMember(Member member){
		pm = Connection.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
		
		tx.commit();
		pm.close();
		return false;
	}
}
