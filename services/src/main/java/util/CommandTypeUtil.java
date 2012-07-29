package util;


import interfaceUtil.CommandTypeInterface;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import base.Account;
import base.CommandType;
@Stateless
public class CommandTypeUtil extends Util<CommandType> implements CommandTypeInterface{
    /**************************************************/
	public CommandTypeUtil()
    {
		this.tableName="CommandType";
		this.className=CommandType.class;
    }
	
	public void add(String name)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			CommandType ct = new CommandType();
			ct.setName(name);
			em.persist(ct);
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
			CommandType ct = em.find(CommandType.class, id);
			ct.setName(name);
			em.persist(ct);
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
