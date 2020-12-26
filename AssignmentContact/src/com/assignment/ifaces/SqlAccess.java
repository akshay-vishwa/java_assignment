package com.assignment.ifaces;

import java.util.List;

public interface SqlAccess<T> {
	
	public int addContact(T t);
	public List<T> findAll();
	public int update(T update,long phNumber);
	public int remove(long number);
	public T findByNumber(long number);
	
}
