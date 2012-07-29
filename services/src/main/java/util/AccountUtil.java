package util;

import interfaceUtil.AccountInterface;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import base.Account;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AccountUtil extends Util<Account> implements AccountInterface{
	public AccountUtil()
    {
		this.tableName="Account";
		this.className=Account.class;
    }
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void add(String login, String password)
	{
		try
		{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Account account = new Account();
			account.setLogin(login);
			account.setPassword(password);
			em.persist(account);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} 
		finally {
				em.close();
			}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void update(Integer id, String login, String password)
	{
		try
		{
			em = emf.createEntityManager();
			//em.getTransaction().begin();
			Account account = em.find(Account.class, id);
			account.setLogin(login);
			account.setPassword(password);
			em.persist(account);
			//em.getTransaction().commit();
		}
		catch (Exception e) {
			//em.getTransaction().rollback();
			e.printStackTrace();
		} 
		finally {
				em.close();
			}
	}
}
