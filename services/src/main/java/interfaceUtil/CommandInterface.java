package interfaceUtil;

import javax.ejb.Remote;

import base.Command;

@Remote
public interface CommandInterface extends UtilInterface<Command>{

	public abstract void add(Integer commandtype_id, Integer login_id,
			Integer privilege_id, Integer application_id, Integer role_id);

	public abstract void update(Integer id, Integer commandtype_id,
			Integer login_id, Integer privilege_id, Integer application_id,
			Integer role_id);

}