package util;

import interfaceUtil.RoleListInterface;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import base.Account;
import base.ApplicationList;

import base.RoleList;
@Stateless
public class RoleListUtil extends Util<RoleList> implements RoleListInterface{
	/**************************************************/
	public RoleListUtil()
    {
		this.tableName="RoleList";
		this.className=RoleList.class;
    }
	
	public void add(String name,Integer application_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			RoleList rl = new RoleList();
			base.ApplicationList applicationlist = em.find(ApplicationList.class, application_id);
			rl.setApplicationlist(applicationlist);
			rl.setName(name);
			em.persist(rl);
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
	
	public void update(Integer id, String name,Integer application_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			RoleList rl = em.find(RoleList.class, id);
			rl.setName(name);
			ApplicationList applicationlist = em.find(ApplicationList.class, application_id);
			rl.setApplicationlist(applicationlist);
			em.persist(rl);
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