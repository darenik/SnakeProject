package util;

import interfaceUtil.CommandInterface;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import base.Account;
import base.ApplicationList;
import base.Command;
import base.CommandType;
import base.PrivilegeList;
import base.RoleList;

@Stateless
public class CommandUtil extends Util<Command> implements CommandInterface{

    /**************************************************/
	public CommandUtil()
    {
		this.tableName="Command";
		this.className=Command.class;
    }

	
	
	public void add(Integer commandtype_id,Integer login_id, Integer privilege_id, Integer application_id, Integer role_id)
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			Command c = new Command();
			base.Account account = em.find(Account.class, login_id);
			c.setAccount(account);
			base.PrivilegeList privilegelist = em.find(PrivilegeList.class, privilege_id);
			c.setPrivilegelist(privilegelist);
			base.ApplicationList applicationlist = em.find(ApplicationList.class, application_id);
			c.setApplicationlist(applicationlist);
			base.CommandType commandtype = em.find(CommandType.class, commandtype_id);
			c.setCommandtype(commandtype);
			base.RoleList rolelist = em.find(RoleList.class, role_id);
			c.setRolelist(rolelist);
			em.persist(c);
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
	
	public void update(Integer id, Integer commandtype_id, Integer login_id, Integer privilege_id, Integer application_id, Integer role_id )
	{
		try
		{
			em = emf.createEntityManager();
			//entityManager.getTransaction().begin();
			Command c = em.find(Command.class, id);
			base.Account account = em.find(Account.class, login_id);
			c.setAccount(account);
			base.PrivilegeList privilegelist = em.find(PrivilegeList.class, privilege_id);
			c.setPrivilegelist(privilegelist);
			base.ApplicationList applicationlist = em.find(ApplicationList.class, application_id);
			c.setApplicationlist(applicationlist);
			base.CommandType commandtype = em.find(CommandType.class, commandtype_id);
			c.setCommandtype(commandtype);
			base.RoleList rolelist = em.find(RoleList.class, role_id);
			c.setRolelist(rolelist);
			em.persist(c);
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