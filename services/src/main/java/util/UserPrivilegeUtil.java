package util;

import interfaceUtil.UserPrivilegeInterface;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import base.Account;
import base.PrivilegeList;
import base.UserPrivilege;
@Stateless
public class UserPrivilegeUtil extends Util<UserPrivilege> implements UserPrivilegeInterface{

    /**************************************************/
	public UserPrivilegeUtil()
    {
		this.tableName="UserPrivilege";
		this.className=UserPrivilege.class;
    }
	
	public void add(Integer privilege_id, Integer login_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			UserPrivilege up = new UserPrivilege();
			PrivilegeList pl = em.find(PrivilegeList.class, privilege_id);
			up.setPrivilegelist(pl);
			Account account = em.find(Account.class, login_id);
			up.setAccount(account);
			em.persist(up);
			//entityManager.getTransaction().commit();
		}
		catch (Exception e) {
			//entityManager.getTransaction().rollback();
			e.printStackTrace();
		} 
		finally {
				em.close();
			}
		
	}
	
	public void update(Integer id, Integer privilege_id, Integer login_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			UserPrivilege up = em.find(UserPrivilege.class, id);
			base.PrivilegeList pl = em.find(PrivilegeList.class, privilege_id);
			up.setPrivilegelist(pl);
			base.Account account = em.find(Account.class, login_id);
			up.setAccount(account);
			em.persist(up);
			//entityManager.getTransaction().commit();
		}
		catch (Exception e) {
			//entityManager.getTransaction().rollback();
			e.printStackTrace();
		} 
		finally {
				em.close();
			}
	}
}