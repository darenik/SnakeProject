package interfaceUtil;

import javax.ejb.Remote;

import base.Division;
@Remote
public interface DivisionInterface extends UtilInterface<Division>{

	public abstract void add(String name, Integer company_id,
			Integer parentdivision_id);

	public abstract void update(Integer id, String name, Integer company_id,
			Integer parentdivision_id);
}