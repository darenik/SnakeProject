package interfaceUtil;

import base.CommandType;
import javax.ejb.*;

@Remote
public interface CommandTypeInterface extends UtilInterface<CommandType>{
	public abstract void add(String name);

	public abstract void update(Integer id, String name);
}