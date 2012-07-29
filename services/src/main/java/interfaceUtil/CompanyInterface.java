package interfaceUtil;

import javax.ejb.Remote;

import base.Company;
@Remote
public interface CompanyInterface extends UtilInterface<Company>{
	public abstract void add(String name, String telephone, String address);

	public abstract void update(Integer id, String name, String telephone,
			String address);
}