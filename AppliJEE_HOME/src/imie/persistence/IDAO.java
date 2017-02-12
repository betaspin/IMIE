package imie.persistence;

import java.util.List;


public interface IDAO<T> {
	
	public List<T> findAll();
	
	public T findOne(T data);
	
	public T findOne(Integer i);
	
	public T insert(T data);
	
	public T update(T data);
	
	public void delete(T data);
	
	public void delete(Integer i);
	
	public void deleteAll();	
}
