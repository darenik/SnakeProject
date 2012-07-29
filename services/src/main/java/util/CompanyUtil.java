package util;

import interfaceUtil.CompanyInterface;


import javax.ejb.*;
import javax.faces.bean.*;


import base.Company;

@ManagedBean(name="companyUtil")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CompanyUtil extends Util<Company> implements CompanyInterface{
	public CompanyUtil(){
		this.tableName="Company";
		this.className=Company.class;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void add(String name, String telephone, String address)
	{							
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();			
			Company tmp = new Company();
			tmp.setName(name);
			tmp.setTelephone(telephone);
			tmp.setAddress(address);
			em.persist(tmp);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} 
		finally {
			if (em!=null)
				em.close();
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void update(Integer id,String name, String telephone, String address)
	{
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();			
			Company tmp = em.find(Company.class, id);
			tmp.setName(name);
			tmp.setTelephone(telephone);
			tmp.setAddress(address);
			em.persist(tmp);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} 
		finally {
			if (em!=null)
				em.close();
		}
	}	
}