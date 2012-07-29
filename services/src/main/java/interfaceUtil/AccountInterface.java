package interfaceUtil;

import javax.ejb.Remote;

import base.Account;

@Remote
public interface AccountInterface extends UtilInterface<Account>{

	public abstract void add(String login, String password);

	public abstract void update(Integer id, String login, String password);
}