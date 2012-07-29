package interfaceUtil;

import javax.ejb.Remote;

import base.BusinessRole;
@Remote
public interface BusinessRoleInterface extends UtilInterface<BusinessRole>{

	public abstract void add(Integer id, String name, Integer division_id);

	public abstract void update(Integer id, String name, Integer division_id);
}