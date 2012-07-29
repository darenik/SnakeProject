package util;
import interfaceUtil.UserInterface;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import base.Account;
import base.User;
@Stateless
public class UserUtil extends Util<User> implements UserInterface{
    /**************************************************/
	public UserUtil()
    {
		this.tableName="User";
		this.className=User.class;
    }
	
	public void add(String surname, String name, String lastname, Date birthday)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			User usr=new User();
			usr.setName(name);
			usr.setSurname(surname);
			usr.setLastname(lastname);
			usr.setBirthday(birthday);
			em.persist(usr);
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
	
	public void update(Integer id, String surname, String name, String lastname, Date birthday)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			User usr=em.find(User.class, id);
			usr.setName(name);
			usr.setSurname(surname);
			usr.setLastname(lastname);
			usr.setBirthday(birthday);
			em.persist(usr);
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