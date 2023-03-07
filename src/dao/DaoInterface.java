package dao;

import java.util.ArrayList;

import model.Book;

public interface DaoInterface<T> {
	public int distinct(T t);
	public int add(T t);
	public int update(T t);
	public int delete(T t);
	public ArrayList<T> selectAll();
	public T selectById(T t);
	public ArrayList<T> selectByCondition(String condition);
	int distinct();

}
