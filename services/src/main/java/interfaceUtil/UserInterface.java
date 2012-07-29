package interfaceUtil;

import java.sql.Date;

import javax.ejb.Remote;

import base.User;
@Remote
public interface UserInterface extends UtilInterface<User>{
	public abstract void add(String surname, String name, String lastname,
			Date birthday);

	public abstract void update(Integer id, String surname, String name,
			String lastname, Date birthday);
}