package pl.studioit.puzzlecrm.dao;


import java.util.List;
import org.springframework.stereotype.Repository;
import pl.studioit.puzzlecrm.domain.Category;

@Repository("categoryDAO")
public class CategoryDAO extends GenericDAO<Category,Long> {
	
	public List<Category> findLevel(int level) {
		return entityManager.createQuery("select o from " + entityClass.getName() + " o where o.parent is null", entityClass).getResultList();
		
	}

}
