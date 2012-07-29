package interfaceUtil;

import javax.ejb.Remote;

import base.UserPrivilege;
@Remote
public interface UserPrivilegeInterface extends UtilInterface<UserPrivilege> {
	public abstract void add(Integer privilege_id, Integer login_id);

	public abstract void update(Integer id, Integer privilege_id,
			Integer login_id);
}