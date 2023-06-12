package dao;

import java.util.ArrayList;

//dao: data access object
public interface DAOInterface<T> {
	// Thêm một đối tượng t vào csdl
	public int insert(T t);

	public int update(T t);

	public int deleteById(T t);

	public ArrayList<T> selectAll();
	
	public T selectById(T t);
	
	public ArrayList<T> selectByCondition(String condition);
}
