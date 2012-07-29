package util;

import interfaceUtil.UtilInterface;

import java.util.List;

import javax.persistence.*;
import base.*;

public abstract class Util<T> implements UtilInterface<T> {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected String tableName;
	protected Class<T> className;

	public Util() {
		emf = Persistence.createEntityManagerFactory("SnakeProject");
	}

	@SuppressWarnings("unchecked")
	public List<T> getList() {
		try {
			em = emf.createEntityManager();
			//em.getTransaction().begin();
			String address="from "+tableName; 
			List<T> result= (List<T>)em.createQuery(address).getResultList();
			//em.getTransaction().commit();
			return result;
		} 
		catch (Exception e) {
			//em.getTransaction().rollback();
			e.getStackTrace();
			return null;
		} 
		finally {
			em.close();
		}
	}

	/* (non-Javadoc)
	 * @see util.UtilInterface#delete(int)
	 */
	public boolean delete(int id){
		try {
			em = emf.createEntityManager();
			//em.getTransaction().begin();
			T temp = em.find(className, id);
			em.remove(temp);
			//em.getTransaction().commit();
			return true;
		} 
		catch (Exception e) {
			//em.getTransaction().rollback();
			e.getStackTrace();
			return false;
		} 
		finally {
			em.close();
		}
	}

	/* (non-Javadoc)
	 * @see util.UtilInterface#findById(int)
	 */
	public T findById(int id){
		try {
			em = emf.createEntityManager();
			//em.getTransaction().begin();
			T temp = em.find(className, new Integer(id));
			//em.getTransaction().commit();
			return temp;
		} 
		catch (Exception e) {
			//em.getTransaction().rollback();
			e.getStackTrace();
			return null;
		} 
		finally {
			em.close();
		}
	}
}
