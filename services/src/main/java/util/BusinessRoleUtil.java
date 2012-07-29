package util;

import interfaceUtil.BusinessRoleInterface;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import base.Account;
import base.BusinessRole;
import base.Division;
@Stateless
public class BusinessRoleUtil extends Util<BusinessRole> implements BusinessRoleInterface{
    /**************************************************/
	public BusinessRoleUtil()
    {
		this.tableName="BusinessRole";
		this.className=BusinessRole.class;
    }
	
	public void add(Integer id, String name, Integer division_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			BusinessRole br = new BusinessRole();
			br.setName(name);
			Division dvn=em.find(Division.class,division_id);
			br.setDivision(dvn);
			em.persist(br);
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
	
	public void update(Integer id, String name, Integer division_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			BusinessRole br = em.find(BusinessRole.class, id);
			br.setName(name);
			Division dvn=em.find(Division.class,division_id);
			br.setDivision(dvn);
			em.persist(br);
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
