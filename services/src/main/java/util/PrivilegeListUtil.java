package util;

import interfaceUtil.PrivilegeListInterface;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import base.Account;
import base.ApplicationList;
import base.PrivilegeList;
@Stateless
public class PrivilegeListUtil extends Util<PrivilegeList> implements PrivilegeListInterface{
    /**************************************************/
	public PrivilegeListUtil()
    {
		this.tableName="PrivilegeList";
		this.className=PrivilegeList.class;
    }
	
	public void add(String name,Integer application_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			PrivilegeList pl = new PrivilegeList();
			base.ApplicationList applicationlist = em.find(ApplicationList.class, application_id);
			pl.setApplicationList(applicationlist);
			pl.setName(name);
			em.persist(pl);
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
			PrivilegeList pl = em.find(PrivilegeList.class, id);
			pl.setName(name);
			ApplicationList applicationlist = em.find(ApplicationList.class, application_id);
			pl.setApplicationList(applicationlist);
			em.persist(pl);
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