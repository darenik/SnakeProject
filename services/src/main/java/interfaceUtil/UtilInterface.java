package interfaceUtil;

import java.util.List;

public interface UtilInterface<T> {

	@SuppressWarnings("unchecked")
	public abstract List<T> getList();

	public abstract boolean delete(int id);

	public abstract T findById(int id);
}