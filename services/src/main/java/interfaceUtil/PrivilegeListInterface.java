package interfaceUtil;

import javax.ejb.Remote;

import base.PrivilegeList;
@Remote
public interface PrivilegeListInterface extends UtilInterface<PrivilegeList>{
	public abstract void add(String name, Integer application_id);

	public abstract void update(Integer id, String name, Integer application_id);
}