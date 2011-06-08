package pl.studioit.puzzlecrm.test;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.studioit.puzzlecrm.domain.Category;
import pl.studioit.puzzlecrm.domain.MyEntity;
import pl.studioit.puzzlecrm.drools.MyDomain;
import pl.studioit.puzzlecrm.jms.MyQueueSender;
import pl.studioit.puzzlecrm.service.ActivitiService;
import pl.studioit.puzzlecrm.service.CategoryService;
import pl.studioit.puzzlecrm.service.DroolsService;
import pl.studioit.puzzlecrm.service.MyEntityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/spring/applicationContext*.xml"})
public class CategoryTest extends TestCase {
	
	@Autowired
	private CategoryService categoryService;
	
	private List<Category> parseList(List<Category> list){
		for (Category c: list){

			System.out.println("Menu level "+c.getName());
			//if (!c.getChildren().isEmpty()) parseList(c.getChildren());
			
		}
		
		return list;		
	}
	
	@Test
	public void testCategoryEntity() {
		//categoryService.findLevel(0);
		Category entity = new Category();
		entity.setName("waterpaint");
		
		//List<Category> list = new  LinkedList<Category>();
		//list.add(entity);
		//categoryService.find(3L).setChildren(list);
		
		//Category cat = categoryService.find(8L);
		List <Category> l = categoryService.findSubTree("drawing");
		parseList(l);
		//l = categoryService.findSubTree("drawing");
		//parseList(l);
		//for (Category c: l) {
			//System.out.println("Menu  "+c.getName());
			//parseList(c.getChildren());
		//}
		//assertEquals(3, cat.getChildren().size());
		//entity.setParent(cat);
		//cat.getChildren().add(entity);
		//categoryService.persist(entity);
		

	}
	
}
