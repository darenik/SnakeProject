package util;

import interfaceUtil.UserRoleInterface;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import base.Account;
import base.UserRole;
import base.RoleList;
@Stateless
public class UserRoleUtil extends Util<UserRole> implements UserRoleInterface{
    /**************************************************/
	public UserRoleUtil()
    {
		this.tableName="UserRole";
		this.className=UserRole.class;
    }
	
	public void add(Integer role_id, Integer login_id)
	{
		try
		{
			em= emf.createEntityManager();
			//entityManager.getTransaction().begin();
			UserRole ur = new UserRole();
			RoleList rl = em.find(RoleList.class, role_id);
			ur.setRoleList(rl);
			Account account = em.find(Account.class, login_id);
			ur.setAccount(account);
			em.persist(ur);
			//entityManager.getTransaction().commit();
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} 
		finally {
				em.close();
			}
		
	}
	
	public void update(Integer id, Integer role_id, Integer login_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			UserRole ur = em.find(UserRole.class, id);
			RoleList rl = em.find(RoleList.class, role_id);
			ur.setRoleList(rl);
			Account account = em.find(Account.class, login_id);
			ur.setAccount(account);
			em.persist(ur);
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