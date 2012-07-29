package interfaceUtil;

import javax.ejb.Remote;

import base.ApplicationList;
@Remote
public interface ApplicationListInterface extends UtilInterface<ApplicationList>{

	public abstract void add(String name);

	public abstract void update(Integer id, String name);
}