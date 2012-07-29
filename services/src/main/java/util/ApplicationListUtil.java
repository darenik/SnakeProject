package util;

import interfaceUtil.ApplicationListInterface;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import base.Account;
import base.ApplicationList;

@Stateless
public class ApplicationListUtil extends Util<ApplicationList> implements ApplicationListInterface{

    /**************************************************/
	public ApplicationListUtil()
    {
		this.tableName="ApplicationList";
		this.className=ApplicationList.class;
    }
	
	
	public void add(String name)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			ApplicationList al = new ApplicationList();
			al.setName(name);
			em.persist(al);
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
	
	public void update(Integer id, String name)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			ApplicationList al = em.find(ApplicationList.class, id);
			al.setName(name);
			em.persist(al);
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