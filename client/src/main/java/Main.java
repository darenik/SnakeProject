import interfaceUtil.*;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import base.*;

public class Main {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		Properties props = new Properties(); 
		props.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
		//props.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
		//под томкат
		props.put(Context.PROVIDER_URL, "http://127.0.0.1:8080/tomee/ejb");
		//под openejb
		//props.put(Context.PROVIDER_URL, "http://localhost:4204/ejb");
		InitialContext ic=new InitialContext(props);
		CompanyInterface cmp=(CompanyInterface)ic.lookup("CompanyUtilRemote");
		
		List<Company> list;
		cmp.add("Компания", "111", "Москва");
		
		/*Company com =cmp.find(1);
				System.out.println(com.getName()+" "+com.getTelephone()+" "+com.getAddress());


		list = cmp.print();
		for (Iterator<Company> iterator = list.iterator(); iterator.hasNext();) {
			Company tmp = (Company) iterator.next();
			System.out.println(tmp.getName()+" "+tmp.getTelephone()+" "+tmp.getAddress());
		}
		
		cmp.update(2,"Петров и Водкин", "22222", "Бобруйск");
		
		list = cmp.print();
		for (Iterator<Company> iterator = list.iterator(); iterator.hasNext();) {
			Company tmp = (Company) iterator.next();
			System.out.println(tmp.getName()+" "+tmp.getTelephone()+" "+tmp.getAddress());
		}
		
		cmp.delete(2);
		*/
		AccountInterface acc=(AccountInterface)ic.lookup("AccountUtilRemote");
		List<Account> listAccount;
		acc.add("account", "password");
		//acc.add("ivanov", "1234");
		/*
		Account tmp =acc.find(1);
			System.out.println(tmp.getLogin()+" "+tmp.getPassword());
		*/
		
		Account tmp;
		listAccount=acc.getList();
		//listAccount = acc.print();
		for (Iterator<Account> iterator = listAccount.iterator(); iterator.hasNext();) {
			tmp = (Account) iterator.next();
			System.out.println(tmp.getLogin()+" "+tmp.getPassword());
		}
		/*
		acc.update(2,"ivanov", "22222");
		
		listAccount = acc.print();
		for (Iterator<Account> iterator = listAccount.iterator(); iterator.hasNext();) {
				tmp = (Account) iterator.next();
				System.out.println(tmp.getLogin()+" "+tmp.getPassword());
		}
		
		acc.delete(2);
		*/
	}
}

