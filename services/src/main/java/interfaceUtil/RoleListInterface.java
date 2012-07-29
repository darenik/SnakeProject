package interfaceUtil;

import javax.ejb.Remote;

import base.RoleList;
@Remote
public interface RoleListInterface extends UtilInterface<RoleList>{
	public abstract void add(String name, Integer application_id);

	public abstract void update(Integer id, String name, Integer application_id);
}