package pl.studioit.puzzlecrm.service.impl;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.studioit.puzzlecrm.dao.CategoryDAO;
import pl.studioit.puzzlecrm.domain.Category;
import pl.studioit.puzzlecrm.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;
	
	private Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Transactional(readOnly=false)
	public void persist(Category entity) {
		categoryDAO.persist(entity);
		log.info("persist {}",entity);

	}

	@Transactional(readOnly=false)
	public void remove(Category entity) {
		categoryDAO.remove(entity);
		log.info("remove {}",entity);

	}

	@Transactional(readOnly=false)
	public void removeAll() {
		categoryDAO.removeAll();
		log.info("removeAll");

	}

	@Transactional(readOnly=false)
	public void refresh(Category entity) {
		categoryDAO.refresh(entity);
		log.info("refresh {}",entity);

	}

	@Transactional(readOnly=true)
	public Category find(Long id) {
		return categoryDAO.find(id);
		
	}

	@Transactional(readOnly=false)
	public void flush() {
		categoryDAO.flush();

	}
	@Transactional(readOnly=false)
	public void merge(Category entity) {
		categoryDAO.merge(entity);
		log.info("merge {}",entity);
	}

	@Transactional(readOnly=true)
	public long count() {
		return categoryDAO.count();
	}
	
	@Transactional(readOnly=true)
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	
	@Transactional(readOnly=true)
	public List<Category> findEntries(int firstResult, int maxResults) {
		return categoryDAO.findEntries(firstResult, maxResults);
	}
	@Transactional(readOnly=true)
	public List<Category> findLevel(int level){
		return categoryDAO.findLevel(level);
	}
}
