package pl.studioit.puzzlecrm.dao;


import java.util.List;
import org.springframework.stereotype.Repository;
import pl.studioit.puzzlecrm.domain.Category;

@Repository("categoryDAO")
public class CategoryDAO extends GenericDAO<Category,Long> {
	private List<Category> categories;
	
	public List<Category> findSubTree(String category) {
			
		 	
			categories = entityManager.createQuery("select o from " + entityClass.getName() + " o where o.parent.name=:category order by o.name", entityClass).setParameter("category", category).getResultList();  
        
        	 
			
	return categories;
		
	}

}
