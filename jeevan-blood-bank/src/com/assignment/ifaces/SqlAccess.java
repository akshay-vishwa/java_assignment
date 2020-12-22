package com.assignment.ifaces;

import java.util.List;

public interface SqlAccess<T> {
	
	public int addDonor(T t);
	public List<T> findAll();

}
