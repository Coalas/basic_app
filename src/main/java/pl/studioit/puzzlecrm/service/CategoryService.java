package pl.studioit.puzzlecrm.service;


import java.util.List;

import pl.studioit.puzzlecrm.domain.Category;

public interface CategoryService {
	public void persist(Category entity);
	public void remove(Category entity);
	public void removeAll();
	public void refresh(Category entity);
	public Category find(Long id);
	public void flush();
	public void merge(Category entity);
	public long count();
	public List<Category> findAll();
	public List<Category> findEntries(int firstResult, int maxResults);
	public List<Category> findSubTree(String category);
}
