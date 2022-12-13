package com.soyfri.interview.demo.commons;

import java.io.Serializable;
import java.util.Collection;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = -8831776283063974912L;

	private int count;
	private int currentPage;
	private int nextPage;
	private int previousPage;
	private String currentUser;
	private Collection<T> resultSet;
	
	public Page() {
		this.count = 10;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage + 1;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		previousPage--;
		this.previousPage = previousPage < 0 ? 0 : previousPage;
	}

	public Collection<T> getResultSet() {
		return resultSet;
	}

	public void setResultSet(Collection<T> resultSet) {
		this.resultSet = resultSet;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	
}
