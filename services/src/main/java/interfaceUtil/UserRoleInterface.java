package interfaceUtil;

import javax.ejb.Remote;

import base.UserRole;
@Remote
public interface UserRoleInterface extends UtilInterface<UserRole>{
	public abstract void add(Integer role_id, Integer login_id);

	public abstract void update(Integer id, Integer role_id, Integer login_id);
}