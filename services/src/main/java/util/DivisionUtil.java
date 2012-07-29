package util;
import interfaceUtil.DivisionInterface;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import base.Account;
import base.Company;
import base.Division;

@Stateless
public class DivisionUtil extends Util<Division> implements DivisionInterface{
    /**************************************************/
	public DivisionUtil()
    {
		this.tableName="Division";
		this.className=Division.class;
    }
	
	public void add(String name, Integer company_id, Integer parentdivision_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			Division dvn=new Division();
			dvn.setName(name);
			Company cmp = em.find(Company.class, company_id);
			dvn.setCompany(cmp);
			Division parentdvn = em.find(Division.class, parentdivision_id);
			dvn.setParentdivision(parentdvn);
			em.persist(dvn);
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
	
	public void update(Integer id, String name, Integer company_id, Integer parentdivision_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			Division dvn = em.find(Division.class, id);
			dvn.setName(name);
			Company cmp = em.find(Company.class, company_id);
			dvn.setCompany(cmp);
			Division parentdvn = em.find(Division.class, parentdivision_id);
			dvn.setParentdivision(parentdvn);
			em.persist(dvn);
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